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
