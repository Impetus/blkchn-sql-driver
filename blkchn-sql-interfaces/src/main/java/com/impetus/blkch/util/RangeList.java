package com.impetus.blkch.util;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public final class RangeList<T extends Number & Comparable<T>> {

    private List<Range<T>> ranges = new ArrayList<>();
    
    public final void addRange(Range<T> range) {
        ranges.add(range);
    }
    
    public final void addAllRanges(List<Range<T>> ranges) {
        for(Range<T> range : ranges) {
            this.ranges.add(range);
        }
    }
    
    @SafeVarargs
    public final void addAllRanges(Range<T>... ranges) {
        addAllRanges(Arrays.asList(ranges));
    }
    
    public final List<Range<T>> getRanges() {
        return ranges;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof RangeList<?>)) {
            return false;
        }
        RangeList<?> other = (RangeList<?>) obj;
        if(ranges.size() != other.ranges.size()) {
            return false;
        }
        for(Range<T> range : ranges) {
            boolean elemEqual = false;
            for(Range<?> otherRange : other.ranges) {
                if(range.equals(otherRange)) {
                    elemEqual = true;
                }
            }
            if(!elemEqual) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;
        for(Range<T> range : ranges) {
            hashCode = prime * hashCode + range.hashCode();
        }
        return hashCode;
    }
    
}
