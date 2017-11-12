package com.impetus.blkch.sql.parser;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.generated.SqlBaseLexer;
import com.impetus.blkch.sql.generated.SqlBaseParser;
import com.impetus.blkch.sql.parser.AbstractSyntaxTreeVisitor;
import com.impetus.blkch.sql.parser.CaseInsensitiveCharStream;
import com.impetus.blkch.sql.parser.LogicalPlan;

public class BlockchainVisitorTest {

	@Test
	public void testBlockchainVisitor() {
		String sql = "select a, b from TRANSACTION t";
		LogicalPlan plan = getLogicalPlan(sql);
		assertNotNull(plan);
	}

	public LogicalPlan getLogicalPlan(String sqlText) {
		LogicalPlan logicalPlan = null;
		SqlBaseParser parser = getParser(sqlText);
		AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
		logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
		logicalPlan.getQuery().traverse();
		return logicalPlan;
	}

	public SqlBaseParser getParser(String sqlText) {
		SqlBaseLexer lexer = new SqlBaseLexer(new CaseInsensitiveCharStream(sqlText));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SqlBaseParser parser = new SqlBaseParser(tokens);
		return parser;
	}
	
}
