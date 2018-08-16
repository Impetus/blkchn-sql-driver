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
package com.impetus.blkch.sql.parser;

import java.math.BigInteger;

import junit.framework.TestCase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.BlkchnErrorListener;
import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.DirectAPINode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.RangeNode;
import com.impetus.blkch.sql.query.WhereClause;
import com.impetus.blkch.util.Range;

public class PhysicalPlanTest extends TestCase
{
    @Test
    public void testForRange() {
        String sql = "SELECT column1 as rcol1, column2 as rcol2, column3, qcol1 as direct1 FROM myTable tbl where rcol1 > 10 and column2 < 30 or (column3 != 25 and direct1 = 30)";
        LogicalPlan plan = getLogicalPlan(sql);
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        WhereClause actual = physicalPlan.getWhereClause();
        WhereClause expected = buildRangeAndDirectWhereClause();
        assertEquals(expected, actual);
    }

    @Test
    public void testValidateLogicalPlan(){

        String sql = "Select * from myTable tbl where column1 = 100 and rcol1 > 5";
        LogicalPlan plan = getLogicalPlan(sql);
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        boolean actual = physicalPlan.validateLogicalPlan();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testPaginate(){
        String sql = "Select * from myTable tbl";
        LogicalPlan plan = getLogicalPlan(sql);
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        RangeNode<Long> rangeNode1 = new RangeNode<>("myTable", "column1");
        rangeNode1.getRangeList().addRange(new Range<Long>(0l, Long.MAX_VALUE));
        PhysicalPlan newPhysicalPlan = physicalPlan.paginate(rangeNode1);
        WhereClause actual = newPhysicalPlan.getWhereClause();
        WhereClause expected = buildRangeClause();
        assertEquals(expected, actual);
    }

    @Test
    public void testPaginateWithDirectAPI(){
        String sql = "Select * from myTable tbl where qcol1 = 30";
        LogicalPlan plan = getLogicalPlan(sql);
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        RangeNode<Long> rangeNode1 = new RangeNode<>("myTable", "column1");
        rangeNode1.getRangeList().addRange(new Range<Long>(0l, Long.MAX_VALUE));
        PhysicalPlan newPhysicalPlan = physicalPlan.paginate(rangeNode1);
        WhereClause actual = newPhysicalPlan.getWhereClause();
        WhereClause expected = buildRangeClauseWithDirectAPI();
        assertEquals(expected, actual);
    }

    private WhereClause buildRangeClauseWithDirectAPI() {
        WhereClause whereClause = new WhereClause();
        LogicalOperation and = new LogicalOperation(Operator.AND);
        RangeNode<Long> rangeNode = new RangeNode<>("myTable", "column1");
        rangeNode.getRangeList().addRange(new Range<Long>(0l, Long.MAX_VALUE));
        and.addChildNode(rangeNode);
        and.addChildNode(new DirectAPINode("myTable", "qcol1", "30"));
        whereClause.addChildNode(and);
        return whereClause;
    }

    private WhereClause buildRangeClause() {
        WhereClause whereClause = new WhereClause();
        RangeNode<Long> rangeNode1 = new RangeNode<>("myTable", "column1");
        rangeNode1.getRangeList().addRange(new Range<Long>(0l, Long.MAX_VALUE));
        whereClause.addChildNode(rangeNode1);
        return whereClause;
    }

    @Test
    public void testComplexRangeQuery(){
        String sql = "SELECT column1 as rcol1, column2 as rcol2, column3, qcol1 as direct1 FROM myTable tbl where rcol1 > 10 and rcol1 < 25 and (column2 <= 30 and "
                + "column2 >= 20 and rcol2 != 25) or (column3 != 25 and direct1 < 30)";
        LogicalPlan plan = getLogicalPlan(sql);
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        WhereClause actual = physicalPlan.getWhereClause();
        WhereClause expected = buildComplexRangeQueryWhereClause();
        assertEquals(expected, actual);
    }
    
    private WhereClause buildRangeAndDirectWhereClause() {
        WhereClause whereClause = new WhereClause();
        LogicalOperation or = new LogicalOperation(Operator.OR);
        LogicalOperation and1 = new LogicalOperation(Operator.AND);
        RangeNode<Long> rangeNode1 = new RangeNode<>("myTable", "column1");
        rangeNode1.getRangeList().addRange(new Range<Long>(11l, Long.MAX_VALUE));
        and1.addChildNode(rangeNode1);
        RangeNode<BigInteger> rangeNode2 = new RangeNode<>("myTable", "column2");
        rangeNode2.getRangeList().addRange(new Range<>(new BigInteger("0"), new BigInteger("29")));
        and1.addChildNode(rangeNode2);
        or.addChildNode(and1);
        LogicalOperation and2 = new LogicalOperation(Operator.AND);
        and2.addChildNode(createFilterItem("column3", "!=", "25"));
        and2.addChildNode(new DirectAPINode("myTable", "qcol1", "30"));
        or.addChildNode(and2);
        whereClause.addChildNode(or);
        return whereClause;
    }
    
    private WhereClause buildComplexRangeQueryWhereClause() {
        WhereClause whereClause = new WhereClause();
        LogicalOperation or = new LogicalOperation(Operator.OR);
        LogicalOperation and1 = new LogicalOperation(Operator.AND);
        RangeNode<Long> rangeNode1 = new RangeNode<>("myTable", "column1");
        rangeNode1.getRangeList().addRange(new Range<>(11l, 24l));
        and1.addChildNode(rangeNode1);
        RangeNode<BigInteger> rangeNode2 = new RangeNode<>("myTable", "column2");
        rangeNode2.getRangeList().addAllRanges(new Range<>(new BigInteger("20"), new BigInteger("24")), new Range<>(new BigInteger("26"), new BigInteger("30")));
        and1.addChildNode(rangeNode2);
        or.addChildNode(and1);
        LogicalOperation and2 = new LogicalOperation(Operator.AND);
        and2.addChildNode(createFilterItem("column3", "!=", "25"));
        and2.addChildNode(createFilterItem("qcol1", "<", "30"));
        or.addChildNode(and2);
        whereClause.addChildNode(or);
        return whereClause;
    }
    
    private FilterItem createFilterItem(String columnName, String comparator, String value) {
        FilterItem filterItem = new FilterItem();
        Column column = new Column();
        column.addChildNode(new IdentifierNode(columnName));
        filterItem.addChildNode(column);
        Comparator comp = new Comparator(Comparator.ComparisionOperator.getOp(comparator));
        comp.addChildNode(new IdentifierNode(comparator));
        filterItem.addChildNode(comp);
        filterItem.addChildNode(new IdentifierNode(value));
        return filterItem;
    }
    
    public LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        BlkchnSqlParser parser = getParser(sqlText);
        parser.removeErrorListeners();
        parser.addErrorListener(BlkchnErrorListener.INSTANCE);
        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        return logicalPlan;
    }
    
    public BlkchnSqlParser getParser(String sqlText) {
        BlkchnSqlLexer lexer = new BlkchnSqlLexer(new CaseInsensitiveCharStream(sqlText));
        lexer.removeErrorListeners();
        lexer.addErrorListener(BlkchnErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlkchnSqlParser parser = new BlkchnSqlParser(tokens);
        return parser;
    }


}
