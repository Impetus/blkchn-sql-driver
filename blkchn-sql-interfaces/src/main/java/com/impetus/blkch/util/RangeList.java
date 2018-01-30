package com.impetus.blkch.util;

import java.util.List;

import java.util.ArrayList;

public class RangeList<T extends Comparable<T>> {

    private List<Range<T>> ranges = new ArrayList<>();
    
    public void addRange(Range<T> range) {
        ranges.add(range);
    }
    
    public void addAllRanges(Range<T>... ranges) {
        for(Range<T> range : ranges) {
            this.ranges.add(range);
        }
    }
    
    
}
