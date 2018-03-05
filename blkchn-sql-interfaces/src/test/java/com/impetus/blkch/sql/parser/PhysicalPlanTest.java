package com.impetus.blkch.sql.parser;

import com.impetus.blkch.sql.query.LogicalOperation;
import junit.framework.TestCase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;

public class PhysicalPlanTest extends TestCase
{
    @Test
    public void testForRange() {
        String sql = "SELECT column1 as rcol1, column2 as rcol2, column3, qcol1 as direct1 FROM myTable tbl where rcol1 > 10 and column2 < 30 or (column3 != 25 and direct1 < 30)";
        LogicalPlan plan = getLogicalPlan(sql);
        plan.getQuery().traverse();
        
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        physicalPlan.getWhereClause().traverse();
        
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

    //TODO Add assert
    @Test
    public void testRandomTestCase1(){
        String sql = "Select * from myTable tbl where rcol1 = 100 and rcol1 > 5";
        LogicalPlan plan = getLogicalPlan(sql);
        plan.getQuery().traverse();
        System.out.println("\n\n\n\n");
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        physicalPlan.getWhereClause().traverse();

    }

    @Test
    public void testValidateNode(){

        String sql = "Select * from myTable tbl where rcol1 = 100 and rcol1 > 5";
        LogicalPlan plan = getLogicalPlan(sql);
        plan.getQuery().traverse();
        System.out.println("\n\n\n\n");
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        physicalPlan.getWhereClause().traverse();
        TreeNode node = new TreeNode("abcd");

        LogicalOperation opr1 = new LogicalOperation(LogicalOperation.Operator.AND);
        opr1.addChildNode(new TreeNode("blockNum = 2"));
        opr1.addChildNode(new TreeNode("blockTrxId = 'dummyTrxId'"));
        //opr1.addChildNode(new FilterItem());//"thirdChild = 'dummyChild'"));

        PhysicalPlan.Color c = physicalPlan.validateNode(opr1);
    }

    @Test
    public void testProcessLogicalOperation(){

        String sql = "SELECT column1 as rcol1, column2 as rcol2, column3, qcol1 as direct1 FROM myTable tbl where rcol1 > 10 and rcol1 < 25 and column2 < 30 and column2 > 20 or (column3 != 25 and direct1 < 30)";
        LogicalPlan plan = getLogicalPlan(sql);
        //plan.getQuery().traverse();
        DummyPhysicalPlan physicalPlan = new DummyPhysicalPlan("dummyPlan", plan);
        physicalPlan.getWhereClause().traverse();


        String sql2 = "SELECT column1 as rcol1, column2 as rcol2, qcolumn3, qcol2 as xyz FROM myTable tbl where column1 < 10 and column1 > 2  or (qcolumn3 > 25 and xyz = 30)";
        LogicalPlan plan2 = getLogicalPlan(sql2);
        plan2.getQuery().traverse();
        System.out.println("\n\n\n");
        DummyPhysicalPlan physicalPlan2 = new DummyPhysicalPlan("dummyPlan", plan2);
        physicalPlan2.getWhereClause().traverse();

    }


}
