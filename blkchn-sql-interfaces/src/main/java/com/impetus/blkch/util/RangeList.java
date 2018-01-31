package com.impetus.blkch.util;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class RangeList<T extends Number & Comparable<T>> {

    private List<Range<T>> ranges = new ArrayList<>();
    
    public void addRange(Range<T> range) {
        ranges.add(range);
    }
    
    public void addAllRanges(List<Range<T>> ranges) {
        for(Range<T> range : ranges) {
            this.ranges.add(range);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void addAllRanges(Range<T>... ranges) {
        addAllRanges(Arrays.asList(ranges));
    }
    
    public List<Range<T>> getRanges() {
        return ranges;
    }
    
}
