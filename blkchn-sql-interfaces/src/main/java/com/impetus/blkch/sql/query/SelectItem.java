package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class SelectItem extends LogicalPlan {

	public static final String DESCRIPTION = "SELECT_ITEM";
	
	private Column column;
	
	private String alias;
	
	private Query query;
	
	public SelectItem(){
		super(DESCRIPTION);
	}
		
	public Column getColumn() {
		return column;
	}

	public String getAlias() {
		return alias;
	}

	@Override
	public Query getQuery() {
		return query;
	}
}
