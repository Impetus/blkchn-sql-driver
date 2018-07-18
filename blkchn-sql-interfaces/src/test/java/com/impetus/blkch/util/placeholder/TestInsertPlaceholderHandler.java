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
package com.impetus.blkch.util.placeholder;

import org.junit.Before;
import org.junit.Test;

import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.query.IdentifierNode;

import junit.framework.TestCase;

public class TestInsertPlaceholderHandler extends TestCase {

    protected Object[] placeholderValues;

    protected InsertPlaceholderHandler handler;

    @Before
    public void setUp() {
        String sql = "insert into transaction (toAddress, value, unit, async) values (?, ?, 'ether', ?)";
        LogicalPlan logicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        handler = new InsertPlaceholderHandler(logicalPlan);
        handler.setPlaceholderIndex();
        if (!handler.isIndexListEmpty())
            this.placeholderValues = new Object[handler.getIndexListCount()];
    }

    @Test
    public void testIndexListCount() {
        int count = handler.getIndexListCount();
        assertEquals(3, count);
    }

    @Test
    public void testAlterLogicalPlan() {
        System.out.println(placeholderValues.length);
        placeholderValues[0] = 1234;
        placeholderValues[1] = "abcd";
        placeholderValues[2] = true;
        handler.alterLogicalPlan(placeholderValues);
        IdentifierNode ident = handler.columnValue.getChildType(IdentifierNode.class, 0);
        assertEquals(String.valueOf(1234), ident.getValue());
    }

    @Test
    public void testSetPlaceholderValue() {
        placeholderValues[0] = 5564;
        placeholderValues[1] = "cdef";
        placeholderValues[2] = false;
        handler.columnValIndex = 0;
        handler.placeholderValues = placeholderValues;
        handler.setPlaceholderValue(handler.columnValue);
        ;
        IdentifierNode ident = handler.columnValue.getChildType(IdentifierNode.class, 0);
        assertEquals(String.valueOf(5564), ident.getValue());
    }

    @Test
    public void testSetPlaceholderValueException() {
        placeholderValues[0] = 5564;
        placeholderValues[1] = "cdef";
        handler.columnValIndex = 0;
        handler.placeholderValues = placeholderValues;
        String msg=null;
        try {
            handler.setPlaceholderValue(handler.columnValue);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        assertEquals("Can't set NULL value", msg);
    }
}
