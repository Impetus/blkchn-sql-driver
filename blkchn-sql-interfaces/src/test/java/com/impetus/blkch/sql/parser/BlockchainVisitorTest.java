package com.impetus.blkch.sql.parser;

import static org.junit.Assert.assertNotNull;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.generated.SqlBaseLexer;
import com.impetus.blkch.sql.generated.SqlBaseParser;
import com.impetus.blkch.sql.query.LimitClause;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;

public class BlockchainVisitorTest {

	@Test
	public void testBlockchainVisitor() {
		String sql = "select transactionid as trans, blocknum from TRANSACTION t where trans=123 and t.blocknum < 5 GROUP BY t.blocknum having blocknum > 2"
				+ " order BY blockhash, transactionhash desc";
		LogicalPlan plan = getLogicalPlan(sql);
		assertNotNull(plan);
	}

	public LogicalPlan getLogicalPlan(String sqlText) {
		LogicalPlan logicalPlan = null;
		SqlBaseParser parser = getParser(sqlText);
		AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
		logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
		logicalPlan.getQuery().traverse();
		System.out.println(logicalPlan.getQuery().hasChildType(LimitClause.class));
		SelectClause clause = logicalPlan.getQuery().getChildType(SelectClause.class, 0);
		System.out.println(clause);
		System.out.println(clause.getChildType(SelectItem.class));
		return logicalPlan;
	}

	public SqlBaseParser getParser(String sqlText) {
		SqlBaseLexer lexer = new SqlBaseLexer(new CaseInsensitiveCharStream(sqlText));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SqlBaseParser parser = new SqlBaseParser(tokens);
		return parser;
	}
	
}
