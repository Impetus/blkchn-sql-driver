package com.impetus.blkch.util;

import java.math.BigInteger;

import org.junit.Test;

import junit.framework.TestCase;

public class TestBigIntegerRangeOperations extends TestCase {

    private RangeOperations<BigInteger> bigIntegerRangeOperations = new BigIntegerRangeOperations();
    
    @Test
    public void testGetValue() {
        BigInteger actual = bigIntegerRangeOperations.getValue("12");
        BigInteger expected = new BigInteger("12");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMinValue() {
        BigInteger actual = bigIntegerRangeOperations.getMinValue();
        BigInteger expected = new BigInteger("0");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMaxValue() {
        BigInteger actual = bigIntegerRangeOperations.getMaxValue();
        BigInteger expected = new BigInteger(Long.toString(Long.MAX_VALUE));
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAdd() {
        BigInteger actual = bigIntegerRangeOperations.add(new BigInteger("50"), 1);
        BigInteger expected = new BigInteger("51");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSubtract() {
        BigInteger actual = bigIntegerRangeOperations.subtract(new BigInteger("50"), 1);
        BigInteger expected = new BigInteger("49");
        assertEquals(expected, actual);
    }
    
}
