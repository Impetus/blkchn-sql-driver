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

import com.impetus.blkch.sql.insert.ColumnValue;
import com.impetus.blkch.sql.insert.Insert;
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.LogicalPlanTest;
import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.Placeholder;
import com.impetus.blkch.sql.query.WhereClause;

import junit.framework.TestCase;

public class TestPlaceholderLogicalPlan extends TestCase {
    
    protected Object[] placeholderValues;

    protected QueryPlaceholderHandler handler;

    protected LogicalPlan placeHLogicalPlan;

    @Before
    public void setUp() {
        String sql = "select a, b from TRANSACTION t where a = ?";
        placeHLogicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        handler = new QueryPlaceholderHandler(placeHLogicalPlan);
        handler.setPlaceholderIndex();
        if (!handler.isIndexListEmpty()) {
            this.placeholderValues = new Object[handler.getIndexListCount()];
            placeholderValues[0] = "'hello world'";
        }
        handler.alterLogicalPlan(placeholderValues);
    }

    @Test
    public void testLogicalPlanQueryPlaceholder() {
        String sql = "select * from table where column1=? and column2=? and column3='some_value'";
        LogicalPlan logicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        assertTrue(logicalPlan.getQuery().getChildType(WhereClause.class, 0).equals(manualWhereClause()));
    }

    @Test
    public void testLogicalPlanInsertPlaceholder() {
        String sql = "insert into transaction (toAddress, value, unit, async) values (?, 2.22, 'ether', ?)";
        LogicalPlan logicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        assertTrue(logicalPlan.getInsert().getChildType(ColumnValue.class, 0).equals(manualColumnValue()));
    }

    @Test
    public void testSimpleSelectWithWhereClause() {
        LogicalPlan logicalPlan = LogicalPlanTest.buildSelectWithWhere();
        assertTrue(logicalPlan.getQuery().equals(placeHLogicalPlan.getQuery()));
    }

    @Test
    public void testSimpleSelectWithMultiWhereClause() {
        String sql = "select a, b from TRANSACTION t where a = '?' AND b = ?";
        LogicalPlan pHLogicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        QueryPlaceholderHandler handler = new QueryPlaceholderHandler(pHLogicalPlan);
        handler.setPlaceholderIndex();
        Object[] placeholderValues;
        if (!handler.isIndexListEmpty()) {
            placeholderValues = new Object[handler.getIndexListCount()];
            placeholderValues[0] = "5";
            handler.alterLogicalPlan(placeholderValues);
        }
        LogicalPlan logicalPlan = buildSelectWithWherePlaceHolder();
        assertTrue(logicalPlan.getQuery().equals(pHLogicalPlan.getQuery()));
    }

    @Test
    public void testInsertWithPlaceHolder() {
        String sql = "INSERT INTO someTable VALUES('first', ?, 'third', 4, ?)";
        LogicalPlan pHLogicalPlan = new LogicalPlanGen().getLogicalPlan(sql);
        InsertPlaceholderHandler handler = new InsertPlaceholderHandler(pHLogicalPlan);
        handler.setPlaceholderIndex();
        Object[] placeholderValues;
        if (!handler.isIndexListEmpty()) {
            placeholderValues = new Object[handler.getIndexListCount()];
            placeholderValues[0] = "'second'";
            placeholderValues[1] = "false";
            handler.alterLogicalPlan(placeholderValues);
        }
        Insert actual = pHLogicalPlan.getInsert();
        Insert expected = LogicalPlanTest.buildInsert();
        assertEquals(expected, actual);
    }


    public TreeNode manualColumnValue() {

        ColumnValue columnValue = new ColumnValue();
        Placeholder placeholder1 = new Placeholder("?");
        IdentifierNode ident1 = new IdentifierNode("2.22");
        IdentifierNode ident2 = new IdentifierNode("'ether'");
        Placeholder placeholder2 = new Placeholder("?");
        columnValue.addChildNode(placeholder1);
        columnValue.addChildNode(ident1);
        columnValue.addChildNode(ident2);
        columnValue.addChildNode(placeholder2);
        return columnValue;
    }

    public TreeNode manualWhereClause() {
        WhereClause whereClause = new WhereClause();
        LogicalOperation op1 = new LogicalOperation(Operator.AND);
        whereClause.addChildNode(op1);
        LogicalOperation op2 = new LogicalOperation(Operator.AND);
        FilterItem filterItem1 = new FilterItem();
        Column column1 = new Column();
        IdentifierNode columnIdent1 = new IdentifierNode("column3");
        column1.addChildNode(columnIdent1);
        Comparator comp1 = new Comparator(ComparisionOperator.EQ);
        IdentifierNode compIdent1 = new IdentifierNode("=");
        comp1.addChildNode(compIdent1);
        IdentifierNode ident1 = new IdentifierNode("'some_value'");
        filterItem1.addChildNode(column1);
        filterItem1.addChildNode(comp1);
        filterItem1.addChildNode(ident1);
        op1.addChildNode(op2);
        op1.addChildNode(filterItem1);

        FilterItem filterItem2 = new FilterItem();
        Column column2 = new Column();
        IdentifierNode columnIdent2 = new IdentifierNode("column1");
        column2.addChildNode(columnIdent2);
        Comparator comp2 = new Comparator(ComparisionOperator.EQ);
        IdentifierNode compIdent2 = new IdentifierNode("=");
        comp2.addChildNode(compIdent2);
        Placeholder plceHolder1 = new Placeholder("?");
        filterItem2.addChildNode(column2);
        filterItem2.addChildNode(comp2);
        filterItem2.addChildNode(plceHolder1);
        op2.addChildNode(filterItem2);

        FilterItem filterItem3 = new FilterItem();
        Column column3 = new Column();
        IdentifierNode columnIdent3 = new IdentifierNode("column2");
        column3.addChildNode(columnIdent3);
        Comparator comp3 = new Comparator(ComparisionOperator.EQ);
        IdentifierNode compIdent3 = new IdentifierNode("=");
        comp3.addChildNode(compIdent3);
        Placeholder plceHolder2 = new Placeholder("?");
        filterItem3.addChildNode(column3);
        filterItem3.addChildNode(comp3);
        filterItem3.addChildNode(plceHolder2);
        op2.addChildNode(filterItem3);
        return whereClause;
    }

    public static LogicalPlan buildSelectWithWherePlaceHolder() {
        LogicalPlan logicalPlan = LogicalPlanTest.buildSimpleSelect();

        TreeNode whereItem = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereItem);

        TreeNode logicalOper = new LogicalOperation(LogicalOperation.Operator.AND);
        whereItem.addChildNode(logicalOper);

        TreeNode filterItem = new FilterItem();
        logicalOper.addChildNode(filterItem);

        TreeNode col3 = new Column();
        TreeNode ident5 = new IdentifierNode("a");
        col3.addChildNode(ident5);
        filterItem.addChildNode(col3);

        TreeNode comprator = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident6 = new IdentifierNode("=");
        comprator.addChildNode(ident6);
        filterItem.addChildNode(comprator);

        TreeNode ident7 = new IdentifierNode("'?'");
        filterItem.addChildNode(ident7);

        TreeNode filterItem2 = new FilterItem();
        logicalOper.addChildNode(filterItem2);

        TreeNode col4 = new Column();
        TreeNode ident8 = new IdentifierNode("b");
        col4.addChildNode(ident8);
        filterItem2.addChildNode(col4);

        TreeNode comprator2 = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident9 = new IdentifierNode("=");
        comprator2.addChildNode(ident9);
        filterItem2.addChildNode(comprator2);

        TreeNode ident10 = new IdentifierNode("5");
        filterItem2.addChildNode(ident10);
        return logicalPlan;
    }
}
