/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
* *
* * Licensed under the Apache License, Version 2.0 (the "License");
* * you may not use this file except in compliance with the License.
* * You may obtain a copy of the License at
* *
* * http://www.apache.org/licenses/LICENSE-2.0
* *
* * Unless required by applicable law or agreed to in writing, software
* * distributed under the License is distributed on an "AS IS" BASIS,
* * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* * See the License for the specific language governing permissions and
* * limitations under the License.
******************************************************************************/
package com.impetus.blkch.sql.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.parser.LogicalPlan.SQLType;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.DirectAPINode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.FunctionNode;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.RangeNode;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.query.WhereClause;
import com.impetus.blkch.util.RangeOperations;
import com.impetus.blkch.util.Utilities;

public abstract class PhysicalPlan extends TreeNode {

    private LogicalPlan logicalPlan;
    
    private WhereClause whereClause;
    
    private List<SelectItem> selectItems = new ArrayList<>();
    
    private Map<String, String> columnAliasMapping = new HashMap<>();

    public PhysicalPlan(String description, LogicalPlan logicalPlan) {
        super(description);
        this.logicalPlan = logicalPlan;
        if(logicalPlan.getType() == SQLType.QUERY) {
            String table = logicalPlan.getQuery().getChildType(FromItem.class, 0).getChildType(Table.class, 0).getChildType(IdentifierNode.class, 0).getValue();
            if(!tableExists(table)) {
                throw new BlkchnException(String.format("Table %s doesn't exist", table));
            }
            //process aliases and add to map
            processAliasMapping(logicalPlan.getQuery().getChildType(SelectClause.class, 0));
            if(logicalPlan.getQuery().hasChildType(WhereClause.class)) {
                this.whereClause = getPhysicalWhereClause();
            }
        }
    }
    

    private void processAliasMapping(SelectClause selectClause)
    {
        for (SelectItem item : selectClause.getChildType(SelectItem.class))
        {
            selectItems.add(item);
            if (item.getChildType(IdentifierNode.class, 0) != null && item.hasChildType(Column.class))
            {
                columnAliasMapping.put(item.getChildType(IdentifierNode.class, 0).getValue(),
                        item.getChildType(Column.class, 0).getChildType(IdentifierNode.class, 0).getValue());
            }
            else if (item.getChildType(IdentifierNode.class, 0) != null && item.hasChildType(FunctionNode.class))
            {
                columnAliasMapping.put(item.getChildType(IdentifierNode.class, 0).getValue(), 
                        Utilities.createFunctionColName(item.getChildType(FunctionNode.class, 0)));
            }
        }
    }


    public WhereClause getWhereClause() {
        return whereClause;
    }
    
    public Map<String, String> getColumnAliasMapping() {
        return columnAliasMapping;
    }
    
    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    private WhereClause getPhysicalWhereClause() {
        WhereClause whereClause = new WhereClause();
        if (logicalPlan.getQuery().getChildType(WhereClause.class, 0).hasChildType(FilterItem.class)) {
            whereClause.addChildNode(processFilterItem(logicalPlan.getQuery().getChildType(WhereClause.class, 0).getChildType(FilterItem.class, 0)));
        } else {
            TreeNode whereClauseNodes = processLogicalOperation(logicalPlan.getQuery().getChildType(WhereClause.class, 0).
                    getChildType(LogicalOperation.class, 0));
            whereClause.addChildNode(whereClauseNodes);
        }
        return whereClause;
    }

    private TreeNode processLogicalOperation(LogicalOperation logicalOperation) {
        if (logicalOperation.getChildNodes().size() != 2) {
            throw new BlkchnException("Logical operation should have two boolean expressions");
        }
        TreeNode firstChild;
        TreeNode secondChild;
        if (logicalOperation.getChildNode(0) instanceof LogicalOperation) {
            firstChild = processLogicalOperation((LogicalOperation) logicalOperation.getChildNode(0));
        } else {
            firstChild = processFilterItem((FilterItem)logicalOperation.getChildNode(0));
        }
        if (logicalOperation.getChildNode(1) instanceof LogicalOperation) {
            secondChild = processLogicalOperation((LogicalOperation) logicalOperation.getChildNode(1));
        } else {
            secondChild = processFilterItem((FilterItem)logicalOperation.getChildNode(1));
        }
        if((firstChild instanceof RangeNode<?>) && (secondChild instanceof RangeNode<?>)) {
            RangeNode<?> firstRange = (RangeNode<?>)firstChild;
            RangeNode<?> secondRange = (RangeNode<?>)secondChild;
            if(firstRange.getColumn().equals(secondRange.getColumn()) &&
                    firstRange.getTable().equals(secondRange.getTable())) {
                String table = logicalPlan.getQuery().getChildType(FromItem.class, 0).getChildType(Table.class, 0).getChildType(IdentifierNode.class, 0).getValue();
                RangeOperations<?> rangeOperations = getRangeOperations(table, firstRange.getColumn());
                return rangeOperations.processRangeNodes(firstRange, secondRange, logicalOperation);
            }
        }
        LogicalOperation physicalLogicalOperation = new LogicalOperation(logicalOperation.isAnd() ? Operator.AND : Operator.OR);
        physicalLogicalOperation.addChildNode(firstChild);
        physicalLogicalOperation.addChildNode(secondChild);
        return physicalLogicalOperation;
    }

    private TreeNode processFilterItem(FilterItem filterItem) {
        String table = logicalPlan.getQuery().getChildType(FromItem.class, 0).getChildType(Table.class, 0).getChildType(IdentifierNode.class, 0).getValue();
        String column = filterItem.getChildType(Column.class, 0).getChildType(IdentifierNode.class, 0).getValue();
        if(columnAliasMapping.get(column) != null){
            column = columnAliasMapping.get(column);
        }
        if(!columnExists(table, column)) {
            throw new BlkchnException(String.format("Column %s doesn't exist in table %s", column, table));
        }
        if(getRangeCols(table).contains(column)) {
            RangeOperations<?> rangeOperations =  getRangeOperations(table, column);
            return rangeOperations.processFilterItem(filterItem, table, column);
        } else if(getQueryCols(table).contains(column) && filterItem.getChildType(Comparator.class, 0).isEQ()) {
            String value = filterItem.getChildType(IdentifierNode.class, 0).getValue();
            return new DirectAPINode(table, column, value);
        } else {
            return createFilterItem(column, filterItem.getChildType(Comparator.class, 0), filterItem.getChildType(IdentifierNode.class, 0).getValue());
        }
    }
    
    public boolean validateLogicalPlan() {
        Color color = Color.GREEN;
        if(logicalPlan.getType() == SQLType.QUERY) {
            if(whereClause != null) {
                color = validateNode(whereClause.getChildNode(0));
            }
        }
        return color == Color.GREEN;
    }
    
    public Color validateNode(TreeNode node) {
        if(node instanceof LogicalOperation) {
            Color first = validateNode(node.getChildNode(0));
            Color second = validateNode(node.getChildNode(1));
            if(((LogicalOperation)node).isAnd()) {
                return Color.and(first, second);
            } else {
                return Color.or(first, second);
            }
        } else {
            if(node instanceof FilterItem) {
                return Color.RED;
            } else {
                return Color.GREEN;
            }
        }
    }
    
    private Column createColumn(String colName) {
        Column column = new Column();
        IdentifierNode identifierNode = new IdentifierNode(colName);
        column.addChildNode(identifierNode);
        return column;
    }
    
    private FilterItem createFilterItem(String colName, Comparator cmp, String value) {
        FilterItem filterItem = new FilterItem();
        filterItem.addChildNode(createColumn(colName));
        filterItem.addChildNode(cmp);
        filterItem.addChildNode(new IdentifierNode(value));
        return filterItem;
    }
    
    public PhysicalPlan paginate(RangeNode<?> rangeNode) {
        if (!logicalPlan.getType().equals(SQLType.QUERY)) {
            return this;
        }
        PhysicalPlan paginatedPlan = (PhysicalPlan) this.clone();
        if(whereClause == null) {
            paginatedPlan.whereClause = new WhereClause();
            paginatedPlan.whereClause.addChildNode(rangeNode);
        } else {
            TreeNode whereClassNode = generatePage(whereClause.getChildNode(0), rangeNode,
                    paginatedPlan.validateLogicalPlan());
            TreeNode reducedWhereClassNode = processLogicalOperation((LogicalOperation) whereClassNode);
            paginatedPlan.whereClause.setChildNodes(Arrays.asList(reducedWhereClassNode)); // Using setChildNodes since old child nodes should be overridden
        }
        return paginatedPlan;
    }
    
    private TreeNode generatePage(TreeNode currentNode, RangeNode<?> rangeNode, boolean isExecutable) {
        if (currentNode instanceof LogicalOperation) {
            LogicalOperation oper = (LogicalOperation) currentNode;
            if (oper.isAnd()) {
                TreeNode left = generatePage(oper.getChildNode(0), rangeNode, isExecutable);
                TreeNode right = generatePage(oper.getChildNode(1), rangeNode, true);
                LogicalOperation returnOper = new LogicalOperation(Operator.AND);
                returnOper.addChildNode(left);
                returnOper.addChildNode(right);
                return returnOper;
            } else {
                TreeNode left = generatePage(oper.getChildNode(0), rangeNode, isExecutable);
                TreeNode right = generatePage(oper.getChildNode(1), rangeNode, isExecutable);
                LogicalOperation returnOper = new LogicalOperation(Operator.OR);
                returnOper.addChildNode(left);
                returnOper.addChildNode(right);
                return returnOper;
            }
        } else if ((currentNode instanceof RangeNode<?>) || (currentNode instanceof DirectAPINode)) {
            LogicalOperation oper = new LogicalOperation(Operator.AND);
            oper.addChildNode((TreeNode) rangeNode.clone());
            oper.addChildNode((TreeNode) currentNode.clone());
            return oper;
        } else {
            if (!isExecutable) {
                LogicalOperation oper = new LogicalOperation(Operator.AND);
                oper.addChildNode((TreeNode) rangeNode.clone());
                oper.addChildNode((TreeNode) currentNode.clone());
                return oper;
            }
            return (TreeNode) currentNode.clone();
        }
    }

    public abstract List<String> getRangeCols(String table);

    public abstract List<String> getQueryCols(String table);
    
    public abstract RangeOperations<?> getRangeOperations(String table, String column);
    
    public abstract boolean tableExists(String table);
    
    public abstract boolean columnExists(String table, String column);
    
    public static enum Color {
        RED,
        GREEN;
        
        public static Color and(Color first, Color second) {
            if(first == RED && second == RED) {
                return RED;
            } else {
                return GREEN;
            }
        }
        
        public static Color or(Color first, Color second) {
            if(first == GREEN && second == GREEN) {
                return GREEN;
            } else {
                return RED;
            }
        }
    }
    
    @Override
    public Object clone() {
        PhysicalPlan root = (PhysicalPlan) super.clone();
        root.logicalPlan = (LogicalPlan) this.logicalPlan.clone();
        root.whereClause = this.whereClause == null ? null : (WhereClause) this.whereClause.clone();
        root.selectItems = new ArrayList<>();
        for (SelectItem selectItem : this.selectItems) {
            root.selectItems.add((SelectItem) selectItem.clone());
        }
        root.columnAliasMapping = new HashMap<>();
        for (Map.Entry<String, String> columnAliasEntry : columnAliasMapping.entrySet()) {
            root.columnAliasMapping.put(columnAliasEntry.getKey(), columnAliasEntry.getValue());
        }
        return root;
    }

}
