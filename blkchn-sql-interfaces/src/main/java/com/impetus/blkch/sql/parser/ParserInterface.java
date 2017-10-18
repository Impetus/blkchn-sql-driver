package com.impetus.blkch.sql.parser;

public interface ParserInterface {
	
	public LogicalPlan parsePlan(String sqlText);

}
