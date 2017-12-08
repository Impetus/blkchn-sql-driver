package com.impetus.blkch.sql.parser;

import junit.framework.TestCase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.generated.SqlBaseLexer;
import com.impetus.blkch.sql.generated.SqlBaseParser;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.DereferenceNode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.FunctionNode;
import com.impetus.blkch.sql.query.GroupByClause;
import com.impetus.blkch.sql.query.HavingClause;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LimitClause;
import com.impetus.blkch.sql.query.OrderByClause;
import com.impetus.blkch.sql.query.OrderItem;
import com.impetus.blkch.sql.query.OrderingDirection;
import com.impetus.blkch.sql.query.OrderingDirection.Direction;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.StarNode;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.query.WhereClause;

public class LogicalPlanTestMultiple extends TestCase {

    @Test
    public void testGroupBy() {
        String sql = "select count(blocknumber), blocknumber from TRANSACTION t group by blocknumber ";
        LogicalPlan plan = getLogicalPlan(sql);
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause1 = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause1);
        TreeNode selectItem1 = new SelectItem();
        selectClause1.addChildNode(selectItem1);
        TreeNode functionNode = new FunctionNode();
        TreeNode column1 = new Column();
        TreeNode ident1 = new IdentifierNode("count");
        TreeNode columIden = new IdentifierNode("blocknumber");
        column1.addChildNode(columIden);
        functionNode.addChildNode(ident1);
        functionNode.addChildNode(column1);
        selectItem1.addChildNode(functionNode);
        TreeNode selectItem2 = new SelectItem();
        selectClause1.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("blocknumber");
        column2.addChildNode(ident2);
        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);
        TreeNode groupByClause = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupByClause);
        TreeNode groupBycolumn = new Column();
        TreeNode groupIdentifier = new IdentifierNode("blocknumber");
        groupBycolumn.addChildNode(groupIdentifier);
        groupByClause.addChildNode(groupBycolumn);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testOrderBy() {
        String sql = "select count(blocknumber), blocknumber from TRANSACTION t order by blocknumber ";
        LogicalPlan plan = getLogicalPlan(sql);
        System.out.println("hello plan" + plan.getQuery());

        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause1 = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause1);
        TreeNode selectItem1 = new SelectItem();
        selectClause1.addChildNode(selectItem1);
        TreeNode functionNode = new FunctionNode();
        TreeNode column1 = new Column();
        TreeNode ident1 = new IdentifierNode("count");
        TreeNode columIden = new IdentifierNode("blocknumber");
        column1.addChildNode(columIden);
        functionNode.addChildNode(ident1);
        functionNode.addChildNode(column1);
        selectItem1.addChildNode(functionNode);
        TreeNode selectItem2 = new SelectItem();
        selectClause1.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("blocknumber");
        column2.addChildNode(ident2);
        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);
        TreeNode orderByClause = new OrderByClause();
        logicalPlan.getCurrentNode().addChildNode(orderByClause);
        TreeNode orderItem = new OrderItem();
        TreeNode orderingDirection = new OrderingDirection(Direction.ASC);
        TreeNode orderBycolumn = new Column();
        TreeNode orderIdentifier = new IdentifierNode("blocknumber");
        orderBycolumn.addChildNode(orderIdentifier);
        orderItem.addChildNode(orderingDirection);
        orderItem.addChildNode(orderBycolumn);
        orderByClause.addChildNode(orderItem);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testGroupByOrderBy() {
        String sql = "select count(blocknumber), blocknumber,blockhash from TRANSACTION t"
                + " group by blocknumber,blockhash order by blocknumber ";
        LogicalPlan plan = getLogicalPlan(sql);
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);
        TreeNode selectItem1 = new SelectItem();
        selectClause.addChildNode(selectItem1);
        TreeNode functionNode = new FunctionNode();
        TreeNode column1 = new Column();
        TreeNode ident1 = new IdentifierNode("count");
        TreeNode columIden = new IdentifierNode("blocknumber");
        column1.addChildNode(columIden);
        functionNode.addChildNode(ident1);
        functionNode.addChildNode(column1);
        selectItem1.addChildNode(functionNode);

        TreeNode selectItem2 = new SelectItem();
        selectClause.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("blocknumber");
        column2.addChildNode(ident2);

        TreeNode selectItem3 = new SelectItem();
        selectClause.addChildNode(selectItem3);
        TreeNode column3 = new Column();
        selectItem3.addChildNode(column3);
        TreeNode ident5 = new IdentifierNode("blockhash");
        column3.addChildNode(ident5);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);

        TreeNode groupByClause = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupByClause);
        TreeNode groupBycolumn1 = new Column();
        TreeNode groupIdentifier1 = new IdentifierNode("blocknumber");
        groupBycolumn1.addChildNode(groupIdentifier1);
        groupByClause.addChildNode(groupBycolumn1);

        TreeNode groupBycolumn2 = new Column();
        TreeNode groupIdentifier2 = new IdentifierNode("blockhash");
        groupBycolumn2.addChildNode(groupIdentifier2);
        groupByClause.addChildNode(groupBycolumn2);

        TreeNode orderByClause = new OrderByClause();
        logicalPlan.getCurrentNode().addChildNode(orderByClause);
        TreeNode orderItem = new OrderItem();
        TreeNode orderingDirection = new OrderingDirection(Direction.ASC);
        TreeNode orderBycolumn = new Column();
        TreeNode orderIdentifier = new IdentifierNode("blocknumber");
        orderBycolumn.addChildNode(orderIdentifier);
        orderItem.addChildNode(orderingDirection);
        orderItem.addChildNode(orderBycolumn);
        orderByClause.addChildNode(orderItem);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testGroupByOrderByHaving() {
        String sql = "select count(blocknumber), blocknumber,blockhash from TRANSACTION t "
                + "group by blocknumber,blockhash having blocknumber > 123456 order by blocknumber ";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);
        TreeNode selectItem1 = new SelectItem();
        selectClause.addChildNode(selectItem1);
        TreeNode functionNode = new FunctionNode();
        TreeNode column1 = new Column();
        TreeNode ident1 = new IdentifierNode("count");
        TreeNode columIden = new IdentifierNode("blocknumber");
        column1.addChildNode(columIden);
        functionNode.addChildNode(ident1);
        functionNode.addChildNode(column1);
        selectItem1.addChildNode(functionNode);

        TreeNode selectItem2 = new SelectItem();
        selectClause.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("blocknumber");
        column2.addChildNode(ident2);

        TreeNode selectItem3 = new SelectItem();
        selectClause.addChildNode(selectItem3);
        TreeNode column3 = new Column();
        selectItem3.addChildNode(column3);
        TreeNode ident5 = new IdentifierNode("blockhash");
        column3.addChildNode(ident5);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);

        TreeNode groupByClause = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupByClause);
        TreeNode groupBycolumn1 = new Column();
        TreeNode groupIdentifier1 = new IdentifierNode("blocknumber");
        groupBycolumn1.addChildNode(groupIdentifier1);
        groupByClause.addChildNode(groupBycolumn1);

        TreeNode groupBycolumn2 = new Column();
        TreeNode groupIdentifier2 = new IdentifierNode("blockhash");
        groupBycolumn2.addChildNode(groupIdentifier2);
        groupByClause.addChildNode(groupBycolumn2);

        TreeNode havingClause = new HavingClause();
        TreeNode filterItem = new FilterItem();
        TreeNode havingColumn = new Column();
        TreeNode havingColIdent = new IdentifierNode("blocknumber");
        havingColumn.addChildNode(havingColIdent);
        filterItem.addChildNode(havingColumn);
        TreeNode comparator = new Comparator(ComparisionOperator.GT);
        TreeNode compIdent = new IdentifierNode(">");
        comparator.addChildNode(compIdent);
        filterItem.addChildNode(comparator);
        TreeNode havColIdent = new IdentifierNode("123456");
        filterItem.addChildNode(havColIdent);
        havingClause.addChildNode(filterItem);
        logicalPlan.getCurrentNode().addChildNode(havingClause);

        TreeNode orderByClause = new OrderByClause();
        logicalPlan.getCurrentNode().addChildNode(orderByClause);
        TreeNode orderItem = new OrderItem();
        TreeNode orderingDirection = new OrderingDirection(Direction.ASC);
        TreeNode orderBycolumn = new Column();
        TreeNode orderIdentifier = new IdentifierNode("blocknumber");
        orderBycolumn.addChildNode(orderIdentifier);
        orderItem.addChildNode(orderingDirection);
        orderItem.addChildNode(orderBycolumn);
        orderByClause.addChildNode(orderItem);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectAlias() {
        String sql = "select blocknumber as blknum , blockhash as blkhsh from TRANSACTION ";
        LogicalPlan plan = getLogicalPlan(sql);
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);

        TreeNode selectItem1 = new SelectItem();
        TreeNode column1 = new Column();
        TreeNode colIdent1 = new IdentifierNode("blocknumber");
        column1.addChildNode(colIdent1);
        TreeNode aliasIdent1 = new IdentifierNode("blknum");
        selectItem1.addChildNode(column1);
        selectItem1.addChildNode(aliasIdent1);
        selectClause.addChildNode(selectItem1);

        TreeNode selectItem2 = new SelectItem();
        TreeNode column2 = new Column();
        TreeNode colIdent2 = new IdentifierNode("blockhash");
        column2.addChildNode(colIdent2);
        TreeNode aliasIdent2 = new IdentifierNode("blkhsh");
        selectItem2.addChildNode(column2);
        selectItem2.addChildNode(aliasIdent2);
        selectClause.addChildNode(selectItem2);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testWhereAliasGroupByOrderby() {
        String sql = "select count(blocknumber) as count, blocknumber as blknum"
                + ",blockhash from TRANSACTION where blocknumber=123349 group by blknum,blockhash"
                + " having count > 4 order by blknum limit 5";
        LogicalPlan plan = getLogicalPlan(sql);
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);
        TreeNode selectItem1 = new SelectItem();
        selectClause.addChildNode(selectItem1);
        TreeNode functionNode = new FunctionNode();
        TreeNode column1 = new Column();
        TreeNode ident1 = new IdentifierNode("count");
        TreeNode columIden = new IdentifierNode("blocknumber");
        column1.addChildNode(columIden);
        functionNode.addChildNode(ident1);
        functionNode.addChildNode(column1);
        TreeNode selItemIdent1 = new IdentifierNode("count");
        selectItem1.addChildNode(functionNode);
        selectItem1.addChildNode(selItemIdent1);

        TreeNode selectItem2 = new SelectItem();
        selectClause.addChildNode(selectItem2);
        TreeNode column2 = new Column();
        selectItem2.addChildNode(column2);
        TreeNode ident2 = new IdentifierNode("blocknumber");
        column2.addChildNode(ident2);
        TreeNode selItemIdent2 = new IdentifierNode("blknum");
        selectItem2.addChildNode(selItemIdent2);

        TreeNode selectItem3 = new SelectItem();
        selectClause.addChildNode(selectItem3);
        TreeNode column3 = new Column();
        selectItem3.addChildNode(column3);
        TreeNode ident5 = new IdentifierNode("blockhash");
        column3.addChildNode(ident5);

        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);

        TreeNode whereClause = new WhereClause();
        TreeNode whefilterItem = new FilterItem();
        TreeNode filterColumn = new Column();
        TreeNode filColIdent = new IdentifierNode("blocknumber");
        filterColumn.addChildNode(filColIdent);
        whefilterItem.addChildNode(filterColumn);
        TreeNode whecomparator = new Comparator(ComparisionOperator.EQ);
        TreeNode whecompIdent = new IdentifierNode("=");
        whecomparator.addChildNode(whecompIdent);
        whefilterItem.addChildNode(whecomparator);
        TreeNode whereIdent = new IdentifierNode("123349");
        whefilterItem.addChildNode(whereIdent);
        whereClause.addChildNode(whefilterItem);
        logicalPlan.getCurrentNode().addChildNode(whereClause);

        TreeNode groupByClause = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupByClause);
        TreeNode groupBycolumn1 = new Column();
        TreeNode groupIdentifier1 = new IdentifierNode("blknum");
        groupBycolumn1.addChildNode(groupIdentifier1);
        groupByClause.addChildNode(groupBycolumn1);

        TreeNode groupBycolumn2 = new Column();
        TreeNode groupIdentifier2 = new IdentifierNode("blockhash");
        groupBycolumn2.addChildNode(groupIdentifier2);
        groupByClause.addChildNode(groupBycolumn2);

        TreeNode havingClause = new HavingClause();
        TreeNode filterItem = new FilterItem();
        TreeNode havingColumn = new Column();
        TreeNode havingColIdent = new IdentifierNode("count");
        havingColumn.addChildNode(havingColIdent);
        filterItem.addChildNode(havingColumn);
        TreeNode comparator = new Comparator(ComparisionOperator.GT);
        TreeNode compIdent = new IdentifierNode(">");
        comparator.addChildNode(compIdent);
        filterItem.addChildNode(comparator);
        TreeNode havColIdent = new IdentifierNode("4");
        filterItem.addChildNode(havColIdent);
        havingClause.addChildNode(filterItem);
        logicalPlan.getCurrentNode().addChildNode(havingClause);

        TreeNode orderByClause = new OrderByClause();
        logicalPlan.getCurrentNode().addChildNode(orderByClause);
        TreeNode orderItem = new OrderItem();
        TreeNode orderingDirection = new OrderingDirection(Direction.ASC);
        TreeNode orderBycolumn = new Column();
        TreeNode orderIdentifier = new IdentifierNode("blknum");
        orderBycolumn.addChildNode(orderIdentifier);
        orderItem.addChildNode(orderingDirection);
        orderItem.addChildNode(orderBycolumn);
        orderByClause.addChildNode(orderItem);
        
        TreeNode limitClause= new LimitClause();
        TreeNode limitIdent= new IdentifierNode("5");
        limitClause.addChildNode(limitIdent);
        logicalPlan.getCurrentNode().addChildNode(limitClause);
        
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testStarLimitNode() {
        String sql = "select * from TRANSACTION t limit 5";
        LogicalPlan plan = getLogicalPlan(sql);
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);
        TreeNode selectItem = new SelectItem();
        TreeNode starNode = new StarNode();
        selectItem.addChildNode(starNode);
        selectClause.addChildNode(selectItem);
        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);
        
        TreeNode limitClause= new LimitClause();
        TreeNode limIdent= new IdentifierNode("5");
        limitClause.addChildNode(limIdent);
        logicalPlan.getCurrentNode().addChildNode(limitClause);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }
    
    @Test
    public void testTableAlias() {
        String sql = "select t.blocknumber as blknum from TRANSACTION t";
        LogicalPlan plan = getLogicalPlan(sql);
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);
        TreeNode selectItem = new SelectItem();
        
        TreeNode deference = new DereferenceNode();
        TreeNode deferCol= new Column();
        TreeNode deferColIdent= new IdentifierNode("t");
        deferCol.addChildNode(deferColIdent);
        TreeNode deferIdent= new IdentifierNode("blocknumber");
        deference.addChildNode(deferCol);
        deference.addChildNode(deferIdent);
        
        TreeNode selectIdent = new IdentifierNode("blknum");
        
        selectItem.addChildNode(deference);
        selectItem.addChildNode(selectIdent);
        selectClause.addChildNode(selectItem);
        
        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        TreeNode table = new Table();
        fromItem.addChildNode(table);
        TreeNode ident3 = new IdentifierNode("t");
        fromItem.addChildNode(ident3);
        TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    public LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        SqlBaseParser parser = getParser(sqlText);
        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        return logicalPlan;
    }

    public SqlBaseParser getParser(String sqlText) {
        SqlBaseLexer lexer = new SqlBaseLexer(new CaseInsensitiveCharStream(sqlText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokens);
        return parser;
    }

}
