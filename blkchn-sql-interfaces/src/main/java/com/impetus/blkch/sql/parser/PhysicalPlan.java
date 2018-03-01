package com.impetus.blkch.sql.parser;

import java.util.ArrayList;
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
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.RangeNode;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.query.WhereClause;
import com.impetus.blkch.util.RangeOperations;

public abstract class PhysicalPlan extends TreeNode {

    private LogicalPlan logicalPlan;
    
    private WhereClause whereClause;
    
    private List<SelectItem> selectItems = new ArrayList<>();
    
    private Map<String, String> columnAliasMapping = new HashMap<>();

    public PhysicalPlan(String description, LogicalPlan logicalPlan) {
        super(description);
        this.logicalPlan = logicalPlan;
        if(logicalPlan.getType() == SQLType.QUERY) {
            //process aliases and add to map
            processAliasMapping(logicalPlan.getQuery().getChildType(SelectClause.class, 0));
            if(logicalPlan.getQuery().hasChildType(WhereClause.class)) {
                this.whereClause = getPhysicalWhereClause();
            }
        }
    }
    

    private void processAliasMapping(SelectClause selectClause)
    {
        //TODO: handle functions with alias
        for (SelectItem item : selectClause.getChildType(SelectItem.class))
        {
            selectItems.add(item);
            if (item.getChildType(IdentifierNode.class, 0) != null && item.hasChildType(Column.class))
            {
                columnAliasMapping.put(item.getChildType(IdentifierNode.class, 0).getValue(),
                        item.getChildType(Column.class, 0).getChildType(IdentifierNode.class, 0).getValue());
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
        if(getRangeCols(table).contains(column)) {
            RangeOperations<?> rangeOperations =  getRangeOperations(table, column);
            return rangeOperations.processFilterItem(filterItem, table, column);
        } else if(getQueryCols(table).contains(column) && filterItem.getChildType(Comparator.class, 0).isEQ()) {
            String value = filterItem.getChildType(IdentifierNode.class, 0).getValue();
            return new DirectAPINode(table, column, value);
        } else {
            return filterItem;
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

    public abstract List<String> getRangeCols(String table);

    public abstract List<String> getQueryCols(String table);
    
    public abstract RangeOperations<?> getRangeOperations(String table, String column);
    
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

}
