package com.impetus.blkch.util;

public final class Range<T extends Number & Comparable<T>> {
    
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
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Range<?>)) {
            return false;
        }
        Range<?> other = (Range<?>) obj;
        return this.min.equals(other.min) && this.max.equals(other.max);
    }
    
    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + min.hashCode();
        hashCode = prime * hashCode + max.hashCode();
        return hashCode;
    }
    
}
