package com.impetus.blkch.util;

import java.math.BigInteger;

public class BigIntegerRangeOperations extends RangeOperations<BigInteger> {

    @Override
    public BigInteger getValue(String valueString) {
        return new BigInteger(valueString);
    }

    @Override
    public BigInteger getMinValue() {
        return new BigInteger("0");
    }

    @Override
    public BigInteger getMaxValue() {
        return new BigInteger(Integer.toString(Integer.MAX_VALUE));
    }

    @Override
    public BigInteger add(BigInteger value, int step) {
        return value.add(new BigInteger(Integer.toString(step)));
    }

    @Override
    public BigInteger subtract(BigInteger value, int step) {
        return value.subtract(new BigInteger(Integer.toString(step)));
    }

}
