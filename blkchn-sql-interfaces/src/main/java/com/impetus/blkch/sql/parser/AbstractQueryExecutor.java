package com.impetus.blkch.sql.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.parser.PhysicalPlan.Color;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.DataNode;
import com.impetus.blkch.sql.query.DirectAPINode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.RangeNode;
import com.impetus.blkch.util.RangeOperations;

public abstract class AbstractQueryExecutor {
    
    protected LogicalPlan logicalPlan;
    
    protected PhysicalPlan physicalPlan;

    protected Map<String, Object> dataMap = new HashMap<>();

    protected Map<String, Map<String, Object>> auxillaryDataMap = new HashMap<>();
    
    protected TreeNode executeDirectAPIs(String table, TreeNode node) {
        if (node instanceof LogicalOperation) {
            LogicalOperation oper = (LogicalOperation) node;
            TreeNode first = executeDirectAPIs(table, oper.getChildNode(0));
            TreeNode second = executeDirectAPIs(table, oper.getChildNode(1));
            LogicalOperation returnOp = new LogicalOperation(oper.isAnd() ? Operator.AND : Operator.OR);
            returnOp.addChildNode(first);
            returnOp.addChildNode(second);
            return returnOp;
        } else if (node instanceof DirectAPINode) {
            DirectAPINode directAPI = (DirectAPINode) node;
            String column = directAPI.getColumn();
            String value = directAPI.getValue();
            return getDataNode(table, column, value);
        } else if (node instanceof RangeNode<?>) {
            RangeNode<?> rangeNode = (RangeNode<?>) node;
            if (rangeNode.getRangeList().getRanges().size() == 1
                    && rangeNode.getRangeList().getRanges().get(0).getMin() == rangeNode.getRangeList().getRanges()
                            .get(0).getMax()) {
                String column = rangeNode.getColumn();
                String value = rangeNode.getRangeList().getRanges().get(0).getMin().toString();
                return getDataNode(table, column, value);
            }
            return node;

        } else {
            return node;
        }
    }
    
    protected <T> TreeNode optimize(TreeNode node) {
        if (!(node instanceof LogicalOperation)) {
            return node;
        }
        LogicalOperation oper = (LogicalOperation) node;
        TreeNode left = optimize(oper.getChildNode(0));
        TreeNode right = optimize(oper.getChildNode(1));
        if (oper.isOr()) {
            return optimizeOr(left, right);
        } else {
            return optimizeAnd(left, right);
        }
    }
    
    @SuppressWarnings("unchecked")
    protected <T> DataNode<T> execute(TreeNode node) {
        if (node instanceof LogicalOperation) {
            LogicalOperation oper = (LogicalOperation) node;
            if (physicalPlan.validateNode(oper.getChildNode(0)) == Color.GREEN) {
                DataNode<T> first = execute(oper.getChildNode(0));
                if (physicalPlan.validateNode(oper.getChildNode(1)) == Color.GREEN && oper.isOr()) {
                    DataNode<T> second = execute(oper.getChildNode(1));
                    return mergeDataNodes(first, second, Operator.OR);
                } else {
                    return filterWithValue(oper.getChildNode(1), first);
                }
            } else {
                DataNode<T> second = execute(oper.getChildNode(1));
                return filterWithValue(oper.getChildNode(0), second);
            }
        } else if (node instanceof DataNode<?>) {
            return (DataNode<T>) node;
        } else if (node instanceof RangeNode<?>) {
            return (DataNode<T>) executeRangeNode((RangeNode<?>) node);
        }
        throw new BlkchnException("can not execute for node: " + node);
    }

    @SuppressWarnings("unchecked")
    private <T> TreeNode optimizeAnd(TreeNode left, TreeNode right) {
        if (left instanceof DataNode<?>) {
            DataNode<T> dataNode = (DataNode<T>) left;
            if (right instanceof LogicalOperation) {
                LogicalOperation newOper = new LogicalOperation(Operator.AND);
                newOper.addChildNode(left);
                newOper.addChildNode(right);
                return newOper;
            } else if (right instanceof RangeNode<?>) {
                RangeNode<?> rangeNode = (RangeNode<?>) right;
                return combineRangeAndDataNodes(rangeNode, dataNode, new LogicalOperation(Operator.AND));
            } else if (right instanceof FilterItem) {
                FilterItem filterItem = (FilterItem) right;
                return combineFilterItemAndDataNodes(filterItem, dataNode);
            } else {
                // check for table name if joins are implemented
                DataNode<T> rightDataNode = (DataNode<T>) right;
                return mergeDataNodes(dataNode, rightDataNode, Operator.AND);
            }
        } else if (right instanceof DataNode<?>) {
            DataNode<T> dataNode = (DataNode<T>) right;
            if (left instanceof LogicalOperation) {
                LogicalOperation newOper = new LogicalOperation(Operator.AND);
                newOper.addChildNode(left);
                newOper.addChildNode(right);
                return newOper;
            } else if (left instanceof RangeNode<?>) {
                RangeNode<?> rangeNode = (RangeNode<?>) left;
                return combineRangeAndDataNodes(rangeNode, dataNode, new LogicalOperation(Operator.AND));
            } else {
                FilterItem filterItem = (FilterItem) left;
                return combineFilterItemAndDataNodes(filterItem, dataNode);
            }
        } else if (left instanceof RangeNode<?> && right instanceof RangeNode<?>) {
            RangeNode<?> leftRangeNode = (RangeNode<?>) left;
            RangeNode<?> rightRangeNode = (RangeNode<?>) right;
            if (leftRangeNode.getColumn().equals(rightRangeNode.getColumn())
                    && leftRangeNode.getTable().equals(rightRangeNode.getTable())) {
                RangeOperations<?> rangeOps = physicalPlan.getRangeOperations(leftRangeNode.getTable(),
                        leftRangeNode.getColumn());
                return rangeOps.processRangeNodes(leftRangeNode, rightRangeNode, new LogicalOperation(Operator.AND));
            } else {
                LogicalOperation newOper = new LogicalOperation(Operator.AND);
                newOper.addChildNode(left);
                newOper.addChildNode(right);
                return newOper;
            }
        } else {
            LogicalOperation newOper = new LogicalOperation(Operator.AND);
            newOper.addChildNode(left);
            newOper.addChildNode(right);
            return newOper;
        }
    }
    
    @SuppressWarnings("unchecked")
    private <T> TreeNode optimizeOr(TreeNode left, TreeNode right) {
        if (left instanceof DataNode<?>) {
            DataNode<T> dataNode = (DataNode<T>) left;
            if (right instanceof LogicalOperation || right instanceof FilterItem) {
                LogicalOperation newOper = new LogicalOperation(Operator.OR);
                newOper.addChildNode(left);
                newOper.addChildNode(right);
                return newOper;
            } else if (right instanceof RangeNode<?>) {
                RangeNode<?> rangeNode = (RangeNode<?>) right;
                return combineRangeAndDataNodes(rangeNode, dataNode, new LogicalOperation(Operator.OR));
            } else {
                // check for table name if joins are implemented
                DataNode<T> rightDataNode = (DataNode<T>) right;
                return mergeDataNodes(dataNode, rightDataNode, Operator.OR);
            }
        } else if (right instanceof DataNode<?>) {
            DataNode<T> dataNode = (DataNode<T>) right;
            if (left instanceof LogicalOperation || left instanceof FilterItem) {
                LogicalOperation newOper = new LogicalOperation(Operator.OR);
                newOper.addChildNode(left);
                newOper.addChildNode(right);
                return newOper;
            } else {
                RangeNode<?> rangeNode = (RangeNode<?>) left;
                return combineRangeAndDataNodes(rangeNode, dataNode, new LogicalOperation(Operator.OR));
            }
        } else if (left instanceof RangeNode<?> && right instanceof RangeNode<?>) {
            RangeNode<?> leftRangeNode = (RangeNode<?>) left;
            RangeNode<?> rightRangeNode = (RangeNode<?>) right;
            if (leftRangeNode.getColumn().equals(rightRangeNode.getColumn())
                    && leftRangeNode.getTable().equals(rightRangeNode.getTable())) {
                RangeOperations<?> rangeOps = physicalPlan.getRangeOperations(leftRangeNode.getTable(),
                        leftRangeNode.getColumn());
                return rangeOps.processRangeNodes(leftRangeNode, rightRangeNode, new LogicalOperation(Operator.OR));
            } else {
                LogicalOperation newOper = new LogicalOperation(Operator.OR);
                newOper.addChildNode(left);
                newOper.addChildNode(right);
                return newOper;
            }
        } else {
            LogicalOperation newOper = new LogicalOperation(Operator.OR);
            newOper.addChildNode(left);
            newOper.addChildNode(right);
            return newOper;
        }
    }
    
    @SuppressWarnings("unchecked")
    private <T> DataNode<T> filterWithValue(TreeNode node, DataNode<T> dataNode) {
        if (node instanceof LogicalOperation) {
            LogicalOperation oper = (LogicalOperation) node;
            DataNode<T> first = filterWithValue(oper.getChildNode(0), dataNode);
            DataNode<T> second = filterWithValue(oper.getChildNode(1), dataNode);
            if(oper.isAnd()) {
                return mergeDataNodes(first, second, Operator.AND);
            } else {
                return mergeDataNodes(first, second, Operator.OR);
            }
        } else if (node instanceof DataNode<?>) {
            return mergeDataNodes(dataNode, (DataNode<T>) node, Operator.AND);
        } else if (node instanceof RangeNode<?>) {
            return filterRangeNodeWithValue((RangeNode<?>) node, dataNode);
        } else {
            return combineFilterItemAndDataNodes((FilterItem) node, dataNode);
        }
    }
    
    private <T> DataNode<T> combineFilterItemAndDataNodes(FilterItem filterItem, DataNode<T> dataNode) {
        String filterColName = filterItem.getChildType(Column.class, 0).getChildType(IdentifierNode.class, 0)
                .getValue();
        String filterValue = filterItem.getChildType(IdentifierNode.class, 0).getValue();
        Comparator comparator = filterItem.getChildType(Comparator.class, 0);
        List<T> filterKeys = dataNode.getKeys().stream().filter(key -> {
            Object obj = dataMap.get(key.toString());
            return filterField(filterColName, obj, filterValue, comparator);
        }).collect(Collectors.toList());
        return new DataNode<>(dataNode.getTable(), filterKeys);
    }
    
    protected boolean compareNumbers(Number first, Number second, Comparator comparator) {
        if (comparator.isEQ()) {
            return first.doubleValue() == second.doubleValue();
        } else if (comparator.isGT()) {
            return first.doubleValue() > second.doubleValue();
        } else if (comparator.isGTE()) {
            return first.doubleValue() >= second.doubleValue();
        } else if (comparator.isLT()) {
            return first.doubleValue() < second.doubleValue();
        } else if (comparator.isLTE()) {
            return first.doubleValue() <= second.doubleValue();
        } else {
            return first.doubleValue() != second.doubleValue();
        }
    }
    
    protected <T> DataNode<T> mergeDataNodes(DataNode<T> first, DataNode<T> second, Operator op) {
        List<T> newKeys = new ArrayList<>();
        if (op == Operator.AND) {
            for (T firstKey : first.getKeys()) {
                for (T secondKey : second.getKeys()) {
                    if (firstKey.equals(secondKey)) {
                        newKeys.add(secondKey);
                        break;
                    }
                }
            }
        } else {
            newKeys.addAll(first.getKeys());
            for (T key : second.getKeys()) {
                if (!newKeys.contains(key)) {
                    newKeys.add(key);
                }
            }
        }
        return new DataNode<>(first.getTable(), newKeys);
    }
    
    protected abstract DataNode<?> getDataNode(String table, String column, String value);
    
    protected abstract <T extends Number & Comparable<T>> DataNode<?> executeRangeNode(RangeNode<T> rangeNode);
    
    protected abstract <T extends Number & Comparable<T>> TreeNode combineRangeAndDataNodes(RangeNode<T> rangeNode,
            DataNode<?> dataNode, LogicalOperation oper);
    
    protected abstract boolean filterField(String fieldName, Object obj, String value, Comparator comparator);
    
    protected abstract <T> DataNode<T> filterRangeNodeWithValue(RangeNode<?> rangeNode, DataNode<T> dataNode);

}
