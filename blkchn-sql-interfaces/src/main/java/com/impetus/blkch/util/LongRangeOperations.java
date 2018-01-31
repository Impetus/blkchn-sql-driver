package com.impetus.blkch.util;

public class LongRangeOperations extends RangeOperations<Long> {

    @Override
    public Long getValue(String valueString) {
        return Long.parseLong(valueString);
    }

    @Override
    public Long getMinValue() {
        return Long.MIN_VALUE;
    }

    @Override
    public Long getMaxValue() {
        return Long.MAX_VALUE;
    }

    @Override
    public Long add(Long value, int step) {
        return value + step;
    }

    @Override
    public Long subtract(Long value, int step) {
        return value - step;
    }

}
