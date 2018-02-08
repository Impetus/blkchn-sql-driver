package com.impetus.blkch.sql.parser;

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

}
