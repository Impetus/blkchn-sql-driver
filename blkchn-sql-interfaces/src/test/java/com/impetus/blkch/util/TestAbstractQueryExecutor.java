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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import junit.framework.TestCase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;
import com.impetus.blkch.sql.parser.AbstractSyntaxTreeVisitor;
import com.impetus.blkch.sql.parser.BlockchainVisitor;
import com.impetus.blkch.sql.parser.CaseInsensitiveCharStream;
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.DataNode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.RangeNode;

public class TestAbstractQueryExecutor extends TestCase {

    @Test
    public void testMergeDataNodesAnd() {
        DataNode<Long> first = new DataNode<>("test", Arrays.asList(1l, 2l, 4l, 6l));
        DataNode<Long> second = new DataNode<>("test", Arrays.asList(2l, 4l, 5l, 8l));
        DummyQueryExecutor dummyQueryExecutor = new DummyQueryExecutor(
                getLogicalPlan("SELECT * FROM test Where column1 < 12"));
        try {
            @SuppressWarnings("unchecked")
            DataNode<Long> actual = (DataNode<Long>) ReflectionUtils.invoke(dummyQueryExecutor, "mergeDataNodes",
                    new Class[] { DataNode.class, DataNode.class, Operator.class }, new Object[] { first, second,
                            Operator.AND });
            DataNode<Long> expected = new DataNode<>("test", Arrays.asList(2l, 4l));
            assertEquals(expected, actual);
        } catch (Throwable e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fail(stringWriter.toString());
        }
    }

    @Test
    public void testMergeDataNodesOr() {
        DataNode<Long> first = new DataNode<>("test", Arrays.asList(1l, 2l, 4l, 6l));
        DataNode<Long> second = new DataNode<>("test", Arrays.asList(2l, 4l, 5l, 8l));
        DummyQueryExecutor dummyQueryExecutor = new DummyQueryExecutor(
                getLogicalPlan("SELECT * FROM test Where column1 < 12"));
        try {
            @SuppressWarnings("unchecked")
            DataNode<Long> actual = (DataNode<Long>) ReflectionUtils.invoke(dummyQueryExecutor, "mergeDataNodes",
                    new Class[] { DataNode.class, DataNode.class, Operator.class }, new Object[] { first, second,
                            Operator.OR });
            DataNode<Long> expected = new DataNode<>("test", Arrays.asList(1l, 2l, 4l, 5l, 6l, 8l));
            assertEquals(expected, actual);
        } catch (Throwable e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fail(stringWriter.toString());
        }
    }

    @Test
    public void testCompareNumbers() {
        Number first = 3l;
        Number second = 3l;
        DummyQueryExecutor dummyQueryExecutor = new DummyQueryExecutor(
                getLogicalPlan("SELECT * FROM test Where column1 < 12"));
        try {
            boolean actual = (Boolean) ReflectionUtils.invoke(dummyQueryExecutor, "compareNumbers", new Class[] {
                    Number.class, Number.class, Comparator.class }, new Object[] { first, second,
                    new Comparator(ComparisionOperator.EQ) });
            assertTrue(actual);
            first = 5l;
            actual = (Boolean) ReflectionUtils.invoke(dummyQueryExecutor, "compareNumbers", new Class[] { Number.class,
                    Number.class, Comparator.class }, new Object[] { first, second,
                    new Comparator(ComparisionOperator.GT) });
            assertTrue(actual);
            second = 6l;
            actual = (Boolean) ReflectionUtils.invoke(dummyQueryExecutor, "compareNumbers", new Class[] { Number.class,
                    Number.class, Comparator.class }, new Object[] { first, second,
                    new Comparator(ComparisionOperator.LT) });
            assertTrue(actual);
            first = 6l;
            actual = (Boolean) ReflectionUtils.invoke(dummyQueryExecutor, "compareNumbers", new Class[] { Number.class,
                    Number.class, Comparator.class }, new Object[] { first, second,
                    new Comparator(ComparisionOperator.LTE) });
            assertTrue(actual);
            actual = (Boolean) ReflectionUtils.invoke(dummyQueryExecutor, "compareNumbers", new Class[] { Number.class,
                    Number.class, Comparator.class }, new Object[] { first, second,
                    new Comparator(ComparisionOperator.GTE) });
            assertTrue(actual);
            first = 7l;
            actual = (Boolean) ReflectionUtils.invoke(dummyQueryExecutor, "compareNumbers", new Class[] { Number.class,
                    Number.class, Comparator.class }, new Object[] { first, second,
                    new Comparator(ComparisionOperator.NEQ) });
            assertTrue(actual);
            actual = (Boolean) ReflectionUtils.invoke(dummyQueryExecutor, "compareNumbers", new Class[] { Number.class,
                    Number.class, Comparator.class }, new Object[] { first, second,
                    new Comparator(ComparisionOperator.EQ) });
            assertFalse(actual);
        } catch (Throwable e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fail(stringWriter.toString());
        }
    }

    @Test
    public void testCombineFilterItemAndDataNodes() {
        DataNode<Long> dataNode = new DataNode<>("test", Arrays.asList(1l, 2l, 5l, 7l, 12l));
        FilterItem fi = createFilterItem("filterField", ComparisionOperator.EQ, "value1");
        DummyQueryExecutor dummyQueryExecutor = new DummyQueryExecutor(
                getLogicalPlan("SELECT * FROM test Where column1 < 12"));
        dummyQueryExecutor.addToDataMap("1", new TestQueryObject(1, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("2", new TestQueryObject(2, 2, "qval1", "qval2", "value2"));
        dummyQueryExecutor.addToDataMap("5", new TestQueryObject(5, 3, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("7", new TestQueryObject(7, 2, "qval1", "qval2", "value3"));
        dummyQueryExecutor.addToDataMap("12", new TestQueryObject(12, 2, "qval1", "qval2", "value1"));
        try {
            @SuppressWarnings("unchecked")
            DataNode<Long> actual = (DataNode<Long>) ReflectionUtils.invoke(dummyQueryExecutor,
                    "combineFilterItemAndDataNodes", new Class[] { FilterItem.class, DataNode.class }, new Object[] {fi, dataNode});
            DataNode<Long> expected = new DataNode<>("test", Arrays.asList(1l, 5l, 12l));
            assertEquals(expected, actual);
        } catch (Throwable e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fail(stringWriter.toString());
        }
    }
    
    @Test
    public void testFilterWithValue() {
        TreeNode root = new LogicalOperation(Operator.AND);
        TreeNode leftChild = new LogicalOperation(Operator.AND);
        TreeNode rightChild = new LogicalOperation(Operator.OR);
        RangeNode<Long> leftRange = new RangeNode<>("test", "column1");
        leftRange.getRangeList().addAllRanges(new Range<>(2l, 4l), new Range<>(7l, 15l));
        TreeNode leftFilterItem = createFilterItem("filterField", ComparisionOperator.EQ, "value1");
        TreeNode rightDataNode = new DataNode<>("test", Arrays.asList(1l, 2l, 5l, 6l, 7l, 9l, 10l, 12l));
        TreeNode rightFilterItem = createFilterItem("filterField", ComparisionOperator.NEQ, "value1");
        leftChild.addChildNode(leftRange);
        leftChild.addChildNode(leftFilterItem);
        rightChild.addChildNode(rightDataNode);
        rightChild.addChildNode(rightFilterItem);
        root.addChildNode(leftChild);
        root.addChildNode(rightChild);
        DataNode<Long> dataNode = new DataNode<>("test", Arrays.asList(1l, 2l, 4l, 5l, 7l, 10l, 11l, 12l));
        DummyQueryExecutor dummyQueryExecutor = new DummyQueryExecutor(
                getLogicalPlan("SELECT * FROM test Where column1 < 12"));
        dummyQueryExecutor.addToDataMap("1", new TestQueryObject(1, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("2", new TestQueryObject(2, 2, "qval1", "qval2", "value2"));
        dummyQueryExecutor.addToDataMap("4", new TestQueryObject(4, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("5", new TestQueryObject(5, 3, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("6", new TestQueryObject(6, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("7", new TestQueryObject(7, 2, "qval1", "qval2", "value3"));
        dummyQueryExecutor.addToDataMap("9", new TestQueryObject(9, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("10", new TestQueryObject(10, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("11", new TestQueryObject(11, 2, "qval1", "qval2", "value3"));
        dummyQueryExecutor.addToDataMap("12", new TestQueryObject(12, 2, "qval1", "qval2", "value1"));
        try {
            @SuppressWarnings("unchecked")
            DataNode<Long> actual = (DataNode<Long>) ReflectionUtils.invoke(dummyQueryExecutor,
                    "filterWithValue", new Class[] { TreeNode.class, DataNode.class }, new Object[] {root, dataNode});
            DataNode<Long> expected = new DataNode<>("test", Arrays.asList(10l, 12l));
            assertEquals(expected, actual);
        } catch (Throwable e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fail(stringWriter.toString());
        }
    }
    
    public void testOptimize() {
        LogicalOperation root = new LogicalOperation(Operator.AND);
        LogicalOperation firstLeft = new LogicalOperation(Operator.AND);
        LogicalOperation firstRight = new LogicalOperation(Operator.OR);
        LogicalOperation secondLeftLeft = new LogicalOperation(Operator.OR);
        LogicalOperation secondLeftRight = new LogicalOperation(Operator.OR);
        secondLeftLeft.addChildNode(createFilterItem("filterField", ComparisionOperator.EQ, "value1"));
        secondLeftLeft.addChildNode(new DataNode<>("test", Arrays.asList(1l, 4l, 5l)));
        RangeNode<Long> rangeNode1 = new RangeNode<>("test", "column1");
        rangeNode1.getRangeList().addAllRanges(new Range<>(2l, 4l), new Range<>(7l, 9l));
        secondLeftRight.addChildNode(rangeNode1);
        secondLeftRight.addChildNode(new DataNode<>("test", Arrays.asList(3l, 5l, 7l, 11l)));
        firstLeft.addChildNode(secondLeftLeft);
        firstLeft.addChildNode(secondLeftRight);
        root.addChildNode(firstLeft);
        
        LogicalOperation secondRightLeft = new LogicalOperation(Operator.OR);
        LogicalOperation secondRightRight = new LogicalOperation(Operator.OR);
        RangeNode<Long> rangeNode2 = new RangeNode<>("test", "column1");
        rangeNode2.getRangeList().addRange(new Range<>(4l, 8l));
        secondRightLeft.addChildNode(rangeNode2);
        secondRightLeft.addChildNode(new DataNode<>("test", Arrays.asList(1l, 3l, 5l)));
        LogicalOperation thirdRightRightLeft = new LogicalOperation(Operator.AND);
        thirdRightRightLeft.addChildNode(createFilterItem("filterField", ComparisionOperator.NEQ, "value1"));
        thirdRightRightLeft.addChildNode(new DataNode<>("test", Arrays.asList(7l, 8l, 9l, 10l)));
        LogicalOperation thirdRightRightRight = new LogicalOperation(Operator.AND);
        thirdRightRightRight.addChildNode(createFilterItem("filterField", ComparisionOperator.EQ, "value1"));
        RangeNode<Long> rangeNode3 = new RangeNode<>("test", "column1");
        rangeNode3.getRangeList().addAllRanges(new Range<>(1l, 3l), new Range<>(11l, 15l));
        thirdRightRightRight.addChildNode(rangeNode3);
        secondRightRight.addChildNode(thirdRightRightLeft);
        secondRightRight.addChildNode(thirdRightRightRight);
        firstRight.addChildNode(secondRightLeft);
        firstRight.addChildNode(secondRightRight);
        root.addChildNode(firstRight);
        
        DummyQueryExecutor dummyQueryExecutor = new DummyQueryExecutor(
                getLogicalPlan("SELECT * FROM test Where column1 < 12"));
        dummyQueryExecutor.addToDataMap("1", new TestQueryObject(1, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("2", new TestQueryObject(2, 2, "qval1", "qval2", "value2"));
        dummyQueryExecutor.addToDataMap("3", new TestQueryObject(3, 2, "qval1", "qval2", "value2"));
        dummyQueryExecutor.addToDataMap("4", new TestQueryObject(4, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("5", new TestQueryObject(5, 3, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("6", new TestQueryObject(6, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("7", new TestQueryObject(7, 2, "qval1", "qval2", "value3"));
        dummyQueryExecutor.addToDataMap("8", new TestQueryObject(8, 2, "qval1", "qval2", "value2"));
        dummyQueryExecutor.addToDataMap("9", new TestQueryObject(9, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("10", new TestQueryObject(10, 2, "qval1", "qval2", "value1"));
        dummyQueryExecutor.addToDataMap("11", new TestQueryObject(11, 2, "qval1", "qval2", "value3"));
        dummyQueryExecutor.addToDataMap("12", new TestQueryObject(12, 2, "qval1", "qval2", "value1"));
        
        try {
            TreeNode actual = (TreeNode) ReflectionUtils.invoke(dummyQueryExecutor,
                    "optimize", new Class[] { TreeNode.class }, new Object[] {root});
            
            TreeNode expected = new LogicalOperation(Operator.AND);
            TreeNode eFirstLeft = new LogicalOperation(Operator.AND);
            LogicalOperation eSecondLeftLeft = new LogicalOperation(Operator.OR);
            eSecondLeftLeft.addChildNode(createFilterItem("filterField", ComparisionOperator.EQ, "value1"));
            eSecondLeftLeft.addChildNode(new DataNode<>("test", Arrays.asList(1l, 4l, 5l)));
            RangeNode<Long> eRangeNode1 = new RangeNode<>("test", "column1");
            eRangeNode1.getRangeList().addAllRanges(new Range<>(2l, 4l), new Range<>(5l, 5l), new Range<>(7l, 9l), new Range<>(11l, 11l));
            eFirstLeft.addChildNode(eSecondLeftLeft);
            eFirstLeft.addChildNode(eRangeNode1);
            expected.addChildNode(eFirstLeft);
            
            TreeNode eFirstRight = new LogicalOperation(Operator.OR);
            RangeNode<Long> eRangeNode2 = new RangeNode<>("test", "column1");
            eRangeNode2.getRangeList().addAllRanges(new Range<>(1l, 1l), new Range<>(3l, 3l), new Range<>(4l, 8l));
            TreeNode eSecondRightRight = new LogicalOperation(Operator.OR);
            eSecondRightRight.addChildNode(new DataNode<>("test", Arrays.asList(7l, 8l)));
            TreeNode eThirdRightRightRight = new LogicalOperation(Operator.AND);
            eThirdRightRightRight.addChildNode(createFilterItem("filterField", ComparisionOperator.EQ, "value1"));
            RangeNode<Long> eRangeNode3 = new RangeNode<>("test", "column1");
            eRangeNode3.getRangeList().addAllRanges(new Range<>(1l, 3l), new Range<>(11l, 15l));
            eThirdRightRightRight.addChildNode(eRangeNode3);
            eSecondRightRight.addChildNode(eThirdRightRightRight);
            eFirstRight.addChildNode(eRangeNode2);
            eFirstRight.addChildNode(eSecondRightRight);
            expected.addChildNode(eFirstRight);
            actual.traverse();
            expected.traverse();
            assertEquals(expected, actual);
        } catch (Throwable e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fail(stringWriter.toString());
        }
    }

    private LogicalPlan getLogicalPlan(String query) {
        BlkchnSqlLexer lexer = new BlkchnSqlLexer(new CaseInsensitiveCharStream(query));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlkchnSqlParser parser = new BlkchnSqlParser(tokens);
        AbstractSyntaxTreeVisitor visitor = new BlockchainVisitor();
        return visitor.visitSingleStatement(parser.singleStatement());
    }

    private FilterItem createFilterItem(String colName, ComparisionOperator op, String colValue) {
        FilterItem fi = new FilterItem();
        Column column = new Column();
        column.addChildNode(new IdentifierNode(colName));
        Comparator comparator = new Comparator(op);
        comparator.addChildNode(new IdentifierNode(op.toString()));
        IdentifierNode value = new IdentifierNode(colValue);
        fi.addChildNode(column);
        fi.addChildNode(comparator);
        fi.addChildNode(value);
        return fi;
    }
}
