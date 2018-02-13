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
