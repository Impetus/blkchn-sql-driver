package com.impetus.blkch.util;

import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.RangeNode;

public abstract class RangeOperations<T extends Comparable<T>> {

    public RangeList<T> and(Range<T> r1, Range<T> r2) { 
        if (checkDiscrete(r1, r2)) { 
            return null; 
        } else {
            RangeList<T> rangeList = new RangeList<>();
            T min = r1.getMin().compareTo(r2.getMin()) < 0 ? r2.getMin() : r1.getMin();
            T max = r1.getMax().compareTo(r2.getMax()) < 0 ? r2.getMax() : r1.getMax();
            rangeList.addRange(createRange(min, max));
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
            rangeList.addRange(createRange(min, max));
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
    public RangeNode<T> processFilterItem(FilterItem filterItem){
        Comparator comparator = filterItem.getChildType(Comparator.class, 0);
        String column = filterItem.getChildType(Column.class, 0).getChildType(IdentifierNode.class, 0).getValue();
        String valueString = filterItem.getChildType(IdentifierNode.class, 0).getValue();
        T value = getValue(valueString);
        RangeNode<T> rangeNode = new RangeNode<>(column);
        if(comparator.isEQ()) {
            Range<T> range = createRange(value, value);
            rangeNode.getRangeList().addRange(range);
        } else if(comparator.isGT()) {
            Range<T> range = createRange(add(value, 1), getMaxValue());
            rangeNode.getRangeList().addRange(range);
        } else if(comparator.isGTE()) {
            Range<T> range = createRange(value, getMaxValue());
            rangeNode.getRangeList().addRange(range);
        } else if(comparator.isLT()) {
            Range<T> range = createRange(subtract(value, 1), getMinValue());
            rangeNode.getRangeList().addRange(range);
        } else if (comparator.isLTE()) {
            Range<T> range = createRange(value, getMinValue());
            rangeNode.getRangeList().addRange(range);
        } else {
            Range<T> range1 = createRange(getMinValue(), subtract(value, 1));
            Range<T> range2 = createRange(add(value, 1), getMaxValue());
            rangeNode.getRangeList().addAllRanges(range1, range2);
        }
        return rangeNode;
        
    }
 
    /*public RangeNode processRangeTree(RangeNode root) { 
        RangeNode left, right; 
        if (root.getOperator() == null) { 
            return root; 
        } 
        left = processRangeTree(root.getLeft()); 
        right = processRangeTree(root.getRight()); 
 
        if (root.isAndOp()) { 
            return rangeNodeAnd(left, right); 
        } else if (root.isOrOp()) { 
            return rangeNodeOr(left, right); 
        } 
        return new RangeNode(); 
    } 
 
    private static RangeNode rangeNodeOr(RangeNode left, RangeNode right) { 
        RangeNode resultNode = new RangeNode(); 
        List<Range> resultRange = new ArrayList<Range>(); 
        resultNode.setRange(resultRange); 
 
        for (Range r1 : left.getRange()) { 
            for (Range r2 : right.getRange()) { 
                resultRange.addAll(or(r1, r2)); 
            } 
        } 
 
        return resultNode; 
    } 
 
    private static RangeNode rangeNodeAnd(RangeNode left, RangeNode right) { 
        RangeNode resultNode = new RangeNode(); 
        List<Range> resultRange = new ArrayList<Range>(); 
        resultNode.setRange(resultRange); 
 
        for (Range r1 : left.getRange()) { 
            for (Range r2 : right.getRange()) { 
                resultRange.add(and(r1, r2)); 
            } 
        } 
 
        return resultNode; 
    }*/
    
    public abstract Range<T> createRange(T min, T max);
    
    public abstract T getValue(String valueString);
    
    public abstract T getMinValue();
    
    public abstract T getMaxValue();
    
    public abstract T add(T value, int step);
    
    public abstract T subtract(T value, int step);
}
