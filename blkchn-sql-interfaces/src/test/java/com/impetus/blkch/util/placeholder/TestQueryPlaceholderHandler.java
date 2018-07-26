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

import com.impetus.blkch.sql.parser.DummyPhysicalPlan;
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.PhysicalPlan;
import com.impetus.blkch.sql.query.IdentifierNode;

import junit.framework.TestCase;

public class TestQueryPlaceholderHandler extends TestCase {

    protected Object[] placeholderValues;

    protected QueryPlaceholderHandler handler;

    @Before
    public void setUp() {
        String sql = "select * from transaction where blocknumber=? or hash=? or value=12222";
        LogicalPlan logicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        handler = new QueryPlaceholderHandler(logicalPlan);
        handler.setPlaceholderIndex();
        if (!handler.isIndexListEmpty())
            this.placeholderValues = new Object[handler.getIndexListCount()];
    }

    @Test
    public void testIndexListCount() {
        int count = handler.getIndexListCount();
        assertEquals(2, count);
    }

    @Test
    public void testAlterLogicalPlan() {
        System.out.println(placeholderValues.length);
        placeholderValues[0] = 1234;
        placeholderValues[1] = "abcd";
        handler.alterLogicalPlan(placeholderValues);
        IdentifierNode ident = handler.whereClause.getChildNode(0).getChildNode(0).getChildNode(0)
                .getChildType(IdentifierNode.class, 0);
        assertEquals(String.valueOf(1234), ident.getValue());
    }

    @Test
    public void testSetPlaceholderValue() {
        placeholderValues[0] = 5564;
        placeholderValues[1] = "cdef";
        handler.filterItemIndex = 0;
        handler.placeholderValues = placeholderValues;
        handler.setPlaceholderValue(handler.whereClause);
        IdentifierNode ident = handler.whereClause.getChildNode(0).getChildNode(0).getChildNode(0)
                .getChildType(IdentifierNode.class, 0);
        assertEquals(String.valueOf(5564), ident.getValue());
    }

    @Test
    public void testOneEqualsZero() {
        String sql = "select * from transaction where 1=0";
        LogicalPlan logicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        logicalPlan.getQuery().traverse();
    }
    
    @Test
    public void testPhysicalPlan() {
        String sql = "select * from block where blocknumber > 21 and blocknumber < 30 or Blocknumber=25";
        LogicalPlan logicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", logicalPlan);
        physicalPlan.getWhereClause().traverse();
    }
}
