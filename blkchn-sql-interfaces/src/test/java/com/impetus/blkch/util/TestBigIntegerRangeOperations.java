/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
* *
* * Licensed under the Apache License, Version 2.0 (the "License");
* * you may not use this file except in compliance with the License.
* * You may obtain a copy of the License at
* *
* * http://www.apache.org/licenses/LICENSE-2.0
* *
* * Unless required by applicable law or agreed to in writing, software
* * distributed under the License is distributed on an "AS IS" BASIS,
* * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* * See the License for the specific language governing permissions and
* * limitations under the License.
******************************************************************************/
package com.impetus.blkch.util;

import java.math.BigInteger;

import junit.framework.TestCase;

import org.junit.Test;

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
