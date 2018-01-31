package com.impetus.blkch.sql.parser;

import java.util.Arrays;
import java.util.List;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.DirectAPINode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.RangeNode;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.query.WhereClause;
import com.impetus.blkch.util.LongRangeOperations;
import com.impetus.blkch.util.RangeOperations;

public abstract class PhysicalPlan extends TreeNode {

    private LogicalPlan logicalPlan;

    public PhysicalPlan(String description, LogicalPlan logicalPlan) {
        super(description);
        this.logicalPlan = logicalPlan;
    }

    public WhereClause getPhysicalWhereClause() {
        if (logicalPlan.getQuery().getChildType(WhereClause.class, 0).hasChildType(FilterItem.class)) {
            return logicalPlan.getQuery().getChildType(WhereClause.class, 0);
        } else {
            TreeNode whereClauseNodes = processLogicalOperation((LogicalOperation)logicalPlan.getQuery().getChildType(WhereClause.class, 0).
                    getChildType(LogicalOperation.class, 0));
            WhereClause whereClause = new WhereClause();
            whereClause.addChildNode(whereClauseNodes);
            return whereClause;
        }
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
            if(firstRange.getColumn().equals(secondRange.getColumn())) {
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
        if(getRangeCols(table).contains(column)) {
            RangeOperations<?> rangeOperations =  getRangeOperations(table, column);
            return rangeOperations.processFilterItem(filterItem);
        } else if(getQueryCols(table).contains(column)) {
            String value = filterItem.getChildType(IdentifierNode.class, 0).getValue();
            return new DirectAPINode(column, value);
        } else {
            return filterItem;
        }
    }

    public abstract List<String> getRangeCols(String table);

    public abstract List<String> getQueryCols(String table);
    
    public abstract RangeOperations<?> getRangeOperations(String table, String column);

}
