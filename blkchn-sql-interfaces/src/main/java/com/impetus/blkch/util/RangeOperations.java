package com.impetus.blkch.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.RangeNode;

public abstract class RangeOperations<T extends Number & Comparable<T>> {
    
    private static final Logger logger = LoggerFactory.getLogger(RangeOperations.class);

    public RangeList<T> and(Range<T> r1, Range<T> r2) {
        if (checkDiscrete(r1, r2)) {
            return null;
        } else {
            RangeList<T> rangeList = new RangeList<>();
            T min = r1.getMin().compareTo(r2.getMin()) < 0 ? r2.getMin() : r1.getMin();
            T max = r1.getMax().compareTo(r2.getMax()) < 0 ? r1.getMax() : r2.getMax();
            rangeList.addRange(new Range<T>(min, max));
            return rangeList;
        }
    }

    @SuppressWarnings("unchecked")
    public RangeList<T> or(Range<T> r1, Range<T> r2) {
        RangeList<T> rangeList = new RangeList<>();
        if (checkDiscrete(r1, r2)) {
            rangeList.addAllRanges(r1, r2);
            return rangeList;
        } else {
            T min = r1.getMin().compareTo(r2.getMin()) < 0 ? r1.getMin() : r2.getMin();
            T max = r1.getMax().compareTo(r2.getMax()) < 0 ? r2.getMax() : r1.getMax();
            rangeList.addRange(new Range<T>(min, max));
            return rangeList;
        }
    }

    private boolean checkDiscrete(Range<T> r1, Range<T> r2) {
        if (r1.getMax().compareTo(r2.getMin()) < 0 || r2.getMax().compareTo(r1.getMin()) < 0) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public RangeNode<T> processFilterItem(FilterItem filterItem, String table, String columnName) {
        Comparator comparator = filterItem.getChildType(Comparator.class, 0);
        String column = columnName == null? filterItem.getChildType(Column.class, 0).getChildType(IdentifierNode.class, 0).getValue() : columnName;
        String valueString = filterItem.getChildType(IdentifierNode.class, 0).getValue();
        T value = getValue(valueString);
        if(value.compareTo(getMinValue()) < 0 || value.compareTo(getMaxValue()) > 0){
            String errMsg = "Value: " + value + " is not in valid range";
            logger.error(errMsg);
            throw new BlkchnException(errMsg);
        }
        RangeNode<T> rangeNode = new RangeNode<>(table, column);
        if (comparator.isEQ()) {
            Range<T> range = new Range<T>(value, value);
            rangeNode.getRangeList().addRange(range);
        } else if (comparator.isGT()) {
            Range<T> range = new Range<T>(add(value, 1), getMaxValue());
            rangeNode.getRangeList().addRange(range);
        } else if (comparator.isGTE()) {
            Range<T> range = new Range<T>(value, getMaxValue());
            rangeNode.getRangeList().addRange(range);
        } else if (comparator.isLT()) {
            Range<T> range = new Range<T>(getMinValue(), subtract(value, 1));
            rangeNode.getRangeList().addRange(range);
        } else if (comparator.isLTE()) {
            Range<T> range = new Range<T>(getMinValue(), value);
            rangeNode.getRangeList().addRange(range);
        } else {
            Range<T> range1 = new Range<T>(getMinValue(), subtract(value, 1));
            Range<T> range2 = new Range<T>(add(value, 1), getMaxValue());
            rangeNode.getRangeList().addAllRanges(range1, range2);
        }
        return rangeNode;

    }

    public RangeNode<T> rangeNodeOr(RangeNode<T> left, RangeNode<T> right) {
        RangeNode<T> resultNode = new RangeNode<T>(left.getTable(), left.getColumn());
        RangeList<T> resultRange = new RangeList<>();

        for (Range<T> r1 : left.getRangeList().getRanges()) {
            for (Range<T> r2 : right.getRangeList().getRanges()) {
                RangeList<T> combinedRange = or(r1, r2);
                resultRange.addAllRanges(combinedRange.getRanges());
            }
        }
        resultNode.getRangeList().addAllRanges(processOrList(resultRange.getRanges()));
        return resultNode;
    }
    
    
    private List<Range<T>> processOrList(List<Range<T>> list) {
        List<Range<T>> temp = new ArrayList<>();
        int delIndex = -1;
        for(Range<T> r : list) {
            boolean isDiscrete = true;
            RangeList<T> merged = null;
            for(Range<T> t : temp) {
                if(!checkDiscrete(r, t)) {
                    merged = or(r, t);
                    delIndex = temp.indexOf(t);
                    isDiscrete = false;
                    break;
                }
            }
            if (isDiscrete) {
                temp.add(r);
            } else {
                temp.remove(delIndex);
                temp.addAll(merged.getRanges());
            }
        }
        if(checkDiscreteList(temp)){
            return temp;
        }
        else{
            return processOrList(temp);
        }
    }

    private boolean checkDiscreteList(List<Range<T>> temp)
    {
        for(int i = 0 ; i < temp.size() - 1 ; i++) {
            for(int j = i + 1 ; j < temp.size() ; j++) {
                if(!checkDiscrete(temp.get(i), temp.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public RangeNode<T> rangeNodeAnd(RangeNode<T> left, RangeNode<T> right) {
        RangeNode<T> resultNode = new RangeNode<>(left.getTable(), left.getColumn());
        RangeList<T> resultRange = new RangeList<>();
        for (Range<T> r1 : left.getRangeList().getRanges()) {
            for (Range<T> r2 : right.getRangeList().getRanges()) {
                RangeList<T> combinedRange = and(r1, r2);
                if (combinedRange != null) {
                    resultRange.addAllRanges(combinedRange.getRanges());
                }
            }
        }
        resultNode.setRangeList(resultRange);
        return resultNode;
    }

    @SuppressWarnings("unchecked")
    public RangeNode<T> processRangeNodes(RangeNode<?> left, RangeNode<?> right, LogicalOperation logicalOperation) {
        RangeNode<T> firstRange = (RangeNode<T>) left;
        RangeNode<T> secondRange = (RangeNode<T>) left;
        if (logicalOperation.isAnd()) {
            return rangeNodeAnd(firstRange, secondRange);
        } else {
            return rangeNodeOr(firstRange, secondRange);
        }
    }

    public abstract T getValue(String valueString);

    public abstract T getMinValue();

    public abstract T getMaxValue();

    public abstract T add(T value, int step);

    public abstract T subtract(T value, int step);
}
