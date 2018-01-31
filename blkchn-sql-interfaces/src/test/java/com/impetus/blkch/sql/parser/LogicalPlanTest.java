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

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.GroupByClause;
import com.impetus.blkch.sql.query.HavingClause;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LimitClause;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.OrderByClause;
import com.impetus.blkch.sql.query.OrderItem;
import com.impetus.blkch.sql.query.OrderingDirection;
import com.impetus.blkch.sql.query.OrderingDirection.Direction;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.query.WhereClause;

public class LogicalPlanTest extends TestCase {

    @Test
    public void testSimpleSelect() {
        String sql = "select a, b from TRANSACTION t";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildSimpleSelect();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSimpleSelectWithWhereClause() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world'";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildSelectWithWhere();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSimpleSelectWithWhereClauseAndGroupBy() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world' group by c";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildSelectWithGroupBy();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithHaving() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world' group by c having b > 100";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildHaving();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithHavingAndOrderBy() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world' group by c having b > 100 order by b desc";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildOrderByClause();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithHavingOrderByAndLimit() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world' group by c having b > 100 order by b desc limit 10";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildOrderByClause();
        TreeNode limit = new LimitClause();
        logicalPlan.getCurrentNode().addChildNode(limit);
        TreeNode ident = new IdentifierNode("10");
        limit.addChildNode(ident);

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithWhereClouse() {
        String sql = "select a, b from TRANSACTION t where a = 10";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = new LogicalPlan("BlockChainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause1 = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause1);
        TreeNode selectItem1 = new SelectItem();
        selectClause1.addChildNode(selectItem1);
        TreeNode column1 = new Column();

        selectItem1.addChildNode(column1);
        TreeNode ident1 = new IdentifierNode("a");
        column1.addChildNode(ident1);
        TreeNode selectItem2 = new SelectItem();
        selectClause1.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("b");
        column2.addChildNode(ident2);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);

        TreeNode whereItem = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereItem);
        TreeNode filterItem = new FilterItem();
        whereItem.addChildNode(filterItem);
        TreeNode col3 = new Column();
        TreeNode ident5 = new IdentifierNode("a");
        col3.addChildNode(ident5);
        filterItem.addChildNode(col3);

        TreeNode comprator = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident6 = new IdentifierNode("=");
        comprator.addChildNode(ident6);
        filterItem.addChildNode(comprator);

        TreeNode ident7 = new IdentifierNode("10");
        filterItem.addChildNode(ident7);

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithWhereAndLogicalOperatorClouse() {
        String sql = "select a, b from TRANSACTION t where a = 10 AND b = 5";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = new LogicalPlan("BlockChainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause1 = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause1);
        TreeNode selectItem1 = new SelectItem();
        selectClause1.addChildNode(selectItem1);
        TreeNode column1 = new Column();

        selectItem1.addChildNode(column1);
        TreeNode ident1 = new IdentifierNode("a");
        column1.addChildNode(ident1);
        TreeNode selectItem2 = new SelectItem();
        selectClause1.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("b");
        column2.addChildNode(ident2);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);

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

        TreeNode ident7 = new IdentifierNode("10");
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

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testCreateFunction() {
        String sql = "Create Function someFunction AS '/home/xyz' WITH VERSION '1.0' WITH ENDORSERS AND(Org1.member, OR(Org2.member, Org3.member)) "
                + "WITH ARGS init, 500, 230";
        LogicalPlan plan = getLogicalPlan(sql);
        //plan.traverse();
        plan.getCreateFunction().traverse();
    }
    
    @Test
    public void testCallFunction() {
        String sql = "CALL someFunc(xyz, abc, 300)";
        LogicalPlan plan = getLogicalPlan(sql);
        plan.getCallFunction().traverse();
    }
    
    @Test
    public void testInsert() {
       String sql = "INSERT INTO someTable VALUES(first, second, third, 4)";
       LogicalPlan plan = getLogicalPlan(sql);
       plan.getInsert().traverse();
    }

    @Test
    public void testSelectWithWhereAndLimitClouse() {
        String sql = "select a, b from TRANSACTION t where a = 10 limit 3";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = new LogicalPlan("BlockChainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause1 = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause1);
        TreeNode selectItem1 = new SelectItem();
        selectClause1.addChildNode(selectItem1);
        TreeNode column1 = new Column();

        selectItem1.addChildNode(column1);
        TreeNode ident1 = new IdentifierNode("a");
        column1.addChildNode(ident1);
        TreeNode selectItem2 = new SelectItem();
        selectClause1.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("b");
        column2.addChildNode(ident2);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);

        TreeNode whereItem = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereItem);
        TreeNode filterItem = new FilterItem();
        whereItem.addChildNode(filterItem);
        TreeNode col3 = new Column();
        TreeNode ident5 = new IdentifierNode("a");
        col3.addChildNode(ident5);
        filterItem.addChildNode(col3);

        TreeNode comprator = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident6 = new IdentifierNode("=");
        comprator.addChildNode(ident6);
        filterItem.addChildNode(comprator);

        TreeNode ident7 = new IdentifierNode("10");
        filterItem.addChildNode(ident7);

        TreeNode limitClause = new LimitClause();
        limitClause.addChildNode(new IdentifierNode("3"));
        logicalPlan.getCurrentNode().addChildNode(limitClause);

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }
    
    @Test
    public void testForRange() {
        String sql = "SELECT * FROM block where blockno > 10 and blockno<30 or (blockno > 50 and tid='0xabcdf233') or (blockno=55 and from='hari')";
//        String sql = "SELECT * FROM block where blockno > 10 and blockno<30 and blockno != 20";
        LogicalPlan plan = getLogicalPlan(sql);
        plan.getQuery().traverse();
    }

    private LogicalPlan buildOrderByClause() {
        LogicalPlan logicalPlan = buildHaving();
        TreeNode orderByClause = new OrderByClause();
        logicalPlan.getCurrentNode().addChildNode(orderByClause);
        TreeNode orderItem = new OrderItem();
        orderByClause.addChildNode(orderItem);
        TreeNode orderDir = new OrderingDirection(Direction.DESC);
        orderItem.addChildNode(orderDir);
        TreeNode column = new Column();
        orderItem.addChildNode(column);
        TreeNode ident = new IdentifierNode("b");
        column.addChildNode(ident);
        return logicalPlan;
    }

    private LogicalPlan buildHaving() {
        LogicalPlan logicalPlan = buildSelectWithGroupBy();

        TreeNode havingClause = new HavingClause();
        logicalPlan.getCurrentNode().addChildNode(havingClause);
        TreeNode filterItem = new FilterItem();
        havingClause.addChildNode(filterItem);
        TreeNode column3 = new Column();
        filterItem.addChildNode(column3);
        TreeNode ident5 = new IdentifierNode("b");
        column3.addChildNode(ident5);
        TreeNode comparator = new Comparator(ComparisionOperator.GT);
        filterItem.addChildNode(comparator);
        TreeNode ident6 = new IdentifierNode(">");
        comparator.addChildNode(ident6);
        TreeNode ident7 = new IdentifierNode("100");
        filterItem.addChildNode(ident7);
        return logicalPlan;
    }

    private LogicalPlan buildSelectWithGroupBy() {
        LogicalPlan logicalPlan = buildSelectWithWhere();

        TreeNode groupBy = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupBy);
        TreeNode column1 = new Column();
        groupBy.addChildNode(column1);
        TreeNode ident1 = new IdentifierNode("c");
        column1.addChildNode(ident1);
        return logicalPlan;
    }

    private LogicalPlan buildSimpleSelect() {
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause1 = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause1);
        TreeNode selectItem1 = new SelectItem();
        selectClause1.addChildNode(selectItem1);
        TreeNode column1 = new Column();
        selectItem1.addChildNode(column1);
        TreeNode ident1 = new IdentifierNode("a");
        column1.addChildNode(ident1);
        TreeNode selectItem2 = new SelectItem();
        selectClause1.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("b");
        column2.addChildNode(ident2);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);
        return logicalPlan;
    }

    private LogicalPlan buildSelectWithWhere() {
        LogicalPlan logicalPlan = buildSimpleSelect();

        TreeNode whereClause = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereClause);
        TreeNode filterItem = new FilterItem();
        whereClause.addChildNode(filterItem);
        TreeNode column3 = new Column();
        filterItem.addChildNode(column3);
        TreeNode ident5 = new IdentifierNode("a");
        column3.addChildNode(ident5);
        TreeNode comparator = new Comparator(ComparisionOperator.EQ);
        filterItem.addChildNode(comparator);
        TreeNode ident6 = new IdentifierNode("=");
        comparator.addChildNode(ident6);
        TreeNode ident7 = new IdentifierNode("'hello world'");
        filterItem.addChildNode(ident7);
        return logicalPlan;
    }

    public LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        BlkchnSqlParser parser = getParser(sqlText);
        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        return logicalPlan;
    }

    public BlkchnSqlParser getParser(String sqlText) {
        BlkchnSqlLexer lexer = new BlkchnSqlLexer(new CaseInsensitiveCharStream(sqlText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlkchnSqlParser parser = new BlkchnSqlParser(tokens);
        return parser;
    }

}
