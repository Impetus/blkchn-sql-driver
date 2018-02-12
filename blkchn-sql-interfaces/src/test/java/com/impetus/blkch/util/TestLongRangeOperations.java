package com.impetus.blkch.util;

import junit.framework.TestCase;

import org.junit.Test;

public class TestLongRangeOperations extends TestCase {
    
    private RangeOperations<Long> longRangeOperations = new LongRangeOperations();
    
    @Test
    public void testGetValue() {
        Long actual = longRangeOperations.getValue("12");
        Long expected = new Long(12);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMinValue() {
        Long actual = longRangeOperations.getMinValue();
        Long expected = Long.MIN_VALUE;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMaxValue() {
        Long actual = longRangeOperations.getMaxValue();
        Long expected = Long.MAX_VALUE;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAdd() {
        Long actual = longRangeOperations.add(50l, 1);
        Long expected = 51l;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSubtract() {
        Long actual = longRangeOperations.subtract(50l, 1);
        Long expected = 49l;
        assertEquals(expected, actual);
    }

}
