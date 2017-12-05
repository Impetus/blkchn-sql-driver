/*******************************************************************************
* * Copyright 2017 Impetus Infotech.
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
package com.impetus.blkch.sql.parser;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.Table;

public class LogicalPlanTest extends TestCase {

    LogicalPlan logicalPlan;

    @Before
    public void setUp() {
        logicalPlan = new LogicalPlan("TEST PLAN");
        Query query = new Query();
        query.setRootNode(true);
        SelectItem selectItem = new SelectItem();
        query.addChildNode(selectItem);
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
    }

    @Test
    public void testLogicalPLan() {
        FromItem fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        assertEquals(2, logicalPlan.getCurrentNode().getChildNodes().size());
        logicalPlan.setCurrentNode(fromItem);
        Table table = new Table();
        logicalPlan.getCurrentNode().addChildNode(table);
        logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent().getChildNode(0));
        Column col1 = new Column();
        Column col2 = new Column();
        logicalPlan.getCurrentNode().addChildNode(col1);
        logicalPlan.getCurrentNode().addChildNode(col2);
        logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
        printQuery(logicalPlan.getCurrentNode());
        assertEquals(logicalPlan.getCurrentNode().getDescription(), Query.DESCRIPTION);
        assertEquals(logicalPlan.getCurrentNode().getChildNode(0).getDescription(), SelectItem.DESCRIPTION);
        assertEquals(logicalPlan.getCurrentNode().getChildNode(1).getDescription(), FromItem.DESCRIPTION);
        assertEquals(logicalPlan.getCurrentNode().getChildNode(0).getChildNode(0).getDescription(), Column.DESCRIPTION);
        assertEquals(logicalPlan.getCurrentNode().getChildNode(0).getChildNode(1).getDescription(), Column.DESCRIPTION);
        assertEquals(logicalPlan.getCurrentNode().getChildNode(1).getDescription(), FromItem.DESCRIPTION);
        assertEquals(logicalPlan.getCurrentNode().getChildNode(1).getChildNode(0).getDescription(), Table.DESCRIPTION);
    }

    private void printQuery(TreeNode rootNode) {
        rootNode.traverse();
    }

}
