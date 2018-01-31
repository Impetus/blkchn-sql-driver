package com.impetus.blkch.util;

public class Range<T extends Number & Comparable<T>> {
    
    private T min;
    
    private T max;
    
    public Range(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }
    
    public T getMax() {
        return max;
    }
    
    @Override
    public String toString() {
        return "[" + min + "-" + max + "]";
    }
    
}
