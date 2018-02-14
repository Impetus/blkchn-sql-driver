package com.impetus.blkch.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.impetus.blkch.sql.parser.AbstractQueryExecutor;
import com.impetus.blkch.sql.parser.DummyPhysicalPlan;
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.DataNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.RangeNode;

public class DummyQueryExecutor extends AbstractQueryExecutor {

    public DummyQueryExecutor(LogicalPlan logicalPlan) {
        this.logicalPlan = logicalPlan;
        this.physicalPlan = new DummyPhysicalPlan("DummyPhysicalPlan", logicalPlan);
    }

    @Override
    protected DataNode<?> getDataNode(String table, String column, String value) {
        if (Long.parseLong(value) < 10) {
            return new DataNode<>(table, Arrays.asList(1l, 3l, 4l, 8l));
        } else {
            return new DataNode<>(table, Arrays.asList(11l, 15l, 16l));
        }
    }

    @Override
    protected <T extends Number & Comparable<T>> DataNode<T> executeRangeNode(RangeNode<T> rangeNode) {
        List<T> keys = new ArrayList<>();
        for (Range<T> range : rangeNode.getRangeList().getRanges()) {
            Long min = (Long) range.getMin() < 0 ? 0l : (Long) range.getMin();
            Long max = (Long) range.getMax() > 20 ? 20l : (Long) range.getMax();
            for (Long i = min; i <= max; i++) {
                keys.add((T)i);
            }
        }
        return new DataNode<>(rangeNode.getTable(), keys);
    }

    @Override
    protected <T extends Number & Comparable<T>> RangeNode<T> combineRangeAndDataNodes(RangeNode<T> rangeNode,
            DataNode<?> dataNode, LogicalOperation oper) {
        String tableName = dataNode.getTable();
        List<String> keys = dataNode.getKeys().stream().map(x -> x.toString()).collect(Collectors.toList());
        String rangeCol = rangeNode.getColumn();
        RangeOperations<T> rangeOps = (RangeOperations<T>) physicalPlan.getRangeOperations(tableName, rangeCol);
        List<RangeNode<T>> dataRanges = keys.stream().map(key -> {
            RangeNode<T> node = new RangeNode<>(rangeNode.getTable(), rangeCol);
            node.getRangeList().addRange(new Range<T>((T)new Long(key), (T)new Long(key)));
            return node;
        }).collect(Collectors.toList());
        RangeNode<T> dataRangeNodes = dataRanges.get(0);
        if (dataRanges.size() > 1) {
            for (int i = 1; i < dataRanges.size(); i++) {
                dataRangeNodes = rangeOps.rangeNodeOr(dataRangeNodes, dataRanges.get(i));
            }
        }
        if (oper.isAnd()) {
            return rangeOps.rangeNodeAnd(dataRangeNodes, rangeNode);
        } else {
            return rangeOps.rangeNodeOr(dataRangeNodes, rangeNode);
        }
    }

    @Override
    protected boolean filterField(String fieldName, Object obj, String value, Comparator comparator) {
        boolean retValue = false;
        if (obj instanceof TestQueryObject) {
            TestQueryObject testQueryObject = (TestQueryObject) obj;
            if ("filterField".equals(fieldName)) {
                if(comparator.isEQ()) {
                    retValue = testQueryObject.getFilterField().equals(value);
                } else {
                    retValue = !testQueryObject.getFilterField().equals(value);
                }
            }
        }
        return retValue;
    }

    @Override
    protected <T> DataNode<T> filterRangeNodeWithValue(RangeNode<?> rangeNode, DataNode<T> dataNode) {
        List<T> filteredKeys = dataNode.getKeys().stream().filter(key -> {
            boolean include = false;
            Long longKey = (Long) key;
            for (Range<?> range : rangeNode.getRangeList().getRanges()) {
                if (((Long) range.getMin()) <= longKey && ((Long) range.getMax()) >= longKey) {
                    include = true;
                    break;
                }
            }
            return include;
        }).collect(Collectors.toList());
        return new DataNode<>(dataNode.getTable(), filteredKeys);
    }
    
    public void addToDataMap(String key, Object value) {
        this.dataMap.put(key, value);
    }

}
