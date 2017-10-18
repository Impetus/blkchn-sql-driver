package com.impetus.blkch.sql.parser;

public abstract class AbstractSQLParser implements ParserInterface{

	public abstract LogicalPlan parsePlan(String sqlText);
	
}
