package com.impetus.blkch.sql.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.sql.generated.SqlBaseBaseListener;
import com.impetus.blkch.sql.generated.SqlBaseParser;

public class SqlBaseListenerGethImpl extends SqlBaseBaseListener {

	private static final Logger logger = LoggerFactory.getLogger(SqlBaseListenerGethImpl.class);

	SqlBaseParser parser;

	public SqlBaseListenerGethImpl(SqlBaseParser parser) {
		this.parser = parser;
	}

	public void enterSingleStatement(SqlBaseParser.SingleStatementContext ctx) {
		logger.info("Implement listener interface just for testing availability.\n "
				+ "All actual implementation is via visitor pattern");
	}

}