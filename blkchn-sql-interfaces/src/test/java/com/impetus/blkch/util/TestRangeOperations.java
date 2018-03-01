package com.impetus.blkch.util;

import junit.framework.TestCase;

import org.junit.Test;

import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.RangeNode;

public class TestRangeOperations extends TestCase {

    private RangeOperations<Long> rangeOperations = new LongRangeOperations();
    
    @Test
    public void testDiscreteAnd() {
        Range<Long> range1 = new Range<>(1l, 3l);
        Range<Long> range2 = new Range<Long>(4l, 5l);
        RangeList<Long> andRange = rangeOperations.and(range1, range2);
        assertNull(andRange);
    }
    
    @Test
    public void testOverlappingAnd() {
        Range<Long> range1 = new Range<>(1l, 3l);
        Range<Long> range2 = new Range<Long>(2l, 5l);
        RangeList<Long> andRange = rangeOperations.and(range1, range2);
        RangeList<Long> expectedRangeList = new RangeList<>();
        expectedRangeList.addRange(new Range<>(2l, 3l));
        assertEquals(expectedRangeList, andRange);
    }
    
    @Test
    public void testEdgeCaseAnd() {
        Range<Long> range1 = new Range<>(1l, 3l);
        Range<Long> range2 = new Range<Long>(3l, 5l);
        RangeList<Long> andRange = rangeOperations.and(range1, range2);
        RangeList<Long> expectedRangeList = new RangeList<>();
        expectedRangeList.addRange(new Range<>(3l, 3l));
        assertEquals(expectedRangeList, andRange);
    }
    
    @Test
    public void testDiscreteOr() {
        Range<Long> range1 = new Range<>(1l, 3l);
        Range<Long> range2 = new Range<Long>(4l, 5l);
        RangeList<Long> orRange = rangeOperations.or(range1, range2);
        RangeList<Long> expectedRangeList = new RangeList<>();
        expectedRangeList.addAllRanges(new Range<Long>(1l, 3l), new Range<Long>(4l, 5l));
        assertEquals(expectedRangeList, orRange);
    }
    
    @Test
    public void testOverlappingOr() {
        Range<Long> range1 = new Range<>(1l, 3l);
        Range<Long> range2 = new Range<Long>(2l, 5l);
        RangeList<Long> orRange = rangeOperations.or(range1, range2);
        RangeList<Long> expectedRangeList = new RangeList<>();
        expectedRangeList.addAllRanges(new Range<Long>(1l, 5l));
        assertEquals(expectedRangeList, orRange);
    }
    
    @Test
    public void testEdgeCaseOr() {
        Range<Long> range1 = new Range<>(1l, 3l);
        Range<Long> range2 = new Range<Long>(3l, 5l);
        RangeList<Long> orRange = rangeOperations.or(range1, range2);
        RangeList<Long> expectedRangeList = new RangeList<>();
        expectedRangeList.addAllRanges(new Range<Long>(1l, 5l));
        assertEquals(expectedRangeList, orRange);
    }
    
    @Test
    public void testProcessFilterItem() {
        FilterItem filterItem = new FilterItem();
        Column column = new Column();
        IdentifierNode colName = new IdentifierNode("testCol");
        Comparator comparator = new Comparator(ComparisionOperator.GT);
        IdentifierNode colValue = new IdentifierNode("50");
        filterItem.addChildNode(column);
        filterItem.addChildNode(comparator);
        filterItem.addChildNode(colValue);
        column.addChildNode(colName);
        RangeNode<?> actual = rangeOperations.processFilterItem(filterItem, "TestTable", "TestCol");
        RangeNode<Long> expected = new RangeNode<>("TestTable", "TestCol");
        expected.getRangeList().addRange(new Range<Long>(51l, Long.MAX_VALUE));
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRangeNodeOr() {
        RangeNode<Long> rangeNode1 = new RangeNode<>("table", "column");
        rangeNode1.getRangeList().addAllRanges(new Range<>(1l, 5l), new Range<>(7l, 10l), new Range<>(13l, 18l));
        RangeNode<Long> rangeNode2 = new RangeNode<>("table", "column");
        rangeNode2.getRangeList().addAllRanges(new Range<>(8l, 9l), new Range<>(15l, 20l), new Range<>(22l, 25l), new Range<>(2l, 6l));
        RangeNode<Long> actual = rangeOperations.rangeNodeOr(rangeNode1, rangeNode2);
        RangeNode<Long> expected = new RangeNode<>("table", "column");
        expected.getRangeList().addAllRanges(new Range<>(1l, 6l), new Range<>(7l, 10l), new Range<>(13l, 20l), new Range<>(22l, 25l));
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRangeNodeAnd() {
        RangeNode<Long> rangeNode1 = new RangeNode<>("table", "column");
        rangeNode1.getRangeList().addAllRanges(new Range<>(1l, 5l), new Range<>(7l, 10l), new Range<>(13l, 18l));
        RangeNode<Long> rangeNode2 = new RangeNode<>("table", "column");
        rangeNode2.getRangeList().addAllRanges(new Range<>(8l, 9l), new Range<>(15l, 20l), new Range<>(22l, 25l), new Range<>(2l, 6l));
        RangeNode<Long> actual = rangeOperations.rangeNodeAnd(rangeNode1, rangeNode2);
        RangeNode<Long> expected = new RangeNode<Long>("table", "column");
        expected.getRangeList().addAllRanges(new Range<>(2l, 5l), new Range<>(8l, 9l), new Range<>(15l, 18l));
        assertEquals(expected, actual);
    }
    
    @Test
    public void testProcessRangeNodesAnd() {
        RangeNode<Long> rangeNode1 = new RangeNode<>("table", "column");
        rangeNode1.getRangeList().addAllRanges(new Range<>(1l, 5l), new Range<>(7l, 10l), new Range<>(13l, 18l));
        RangeNode<Long> rangeNode2 = new RangeNode<>("table", "column");
        rangeNode2.getRangeList().addAllRanges(new Range<>(8l, 9l), new Range<>(15l, 20l), new Range<>(22l, 25l), new Range<>(2l, 6l));
        RangeNode<Long> actual = rangeOperations.processRangeNodes(rangeNode1, rangeNode2, new LogicalOperation(Operator.AND));
        RangeNode<Long> expected = new RangeNode<Long>("table", "column");
        expected.getRangeList().addAllRanges(new Range<>(2l, 5l), new Range<>(8l, 9l), new Range<>(15l, 18l));
        assertEquals(expected, actual);
    }
    
    @Test
    public void testProcessRangeNodesOr() {
        RangeNode<Long> rangeNode1 = new RangeNode<>("table", "column");
        rangeNode1.getRangeList().addAllRanges(new Range<>(1l, 5l), new Range<>(7l, 10l), new Range<>(13l, 18l));
        RangeNode<Long> rangeNode2 = new RangeNode<>("table", "column");
        rangeNode2.getRangeList().addAllRanges(new Range<>(8l, 9l), new Range<>(15l, 20l), new Range<>(22l, 25l), new Range<>(2l, 6l));
        RangeNode<Long> actual = rangeOperations.processRangeNodes(rangeNode1, rangeNode2, new LogicalOperation(Operator.OR));
        RangeNode<Long> expected = new RangeNode<Long>("table", "column");
        expected.getRangeList().addAllRanges(new Range<>(1l, 6l), new Range<>(13l, 20l), new Range<>(7l, 10l), new Range<>(22l, 25l));
        assertEquals(expected, actual);
    }
    
    
}
