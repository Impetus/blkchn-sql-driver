package com.impetus.blkch.sql.interfaces;

import org.antlr.v4.runtime.CommonTokenStream;

import com.impetus.blkch.sql.generated.SqlBaseLexer;
import com.impetus.blkch.sql.generated.SqlBaseParser;
import com.impetus.blkch.sql.parser.AbstractSyntaxTreeVisitor;
import com.impetus.blkch.sql.parser.CaseInsensitiveCharStream;
import com.impetus.blkch.sql.parser.LogicalPlan;

public abstract class QueryPlanAbstract implements QueryPlanExecution{

	private SqlBaseParser getParser(String sqlText) {
		SqlBaseLexer lexer = new SqlBaseLexer(new CaseInsensitiveCharStream(sqlText));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SqlBaseParser parser = new SqlBaseParser(tokens);
		return parser;
	}

	
	public LogicalPlan getLogicalPlan(String sqlText) {
		LogicalPlan logicalPlan = null;
		SqlBaseParser parser = getParser(sqlText);
		AbstractSyntaxTreeVisitor astBuilder = new AbstractSyntaxTreeVisitor();
		logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
		return logicalPlan;
	}

}
