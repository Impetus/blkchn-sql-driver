package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.schema.Column;

public class SelectItem extends LogicalPlan {

	public static final String DESCRIPTION = "SELECT_ITEM";
	
	private Column column;
	
	private String alias;
	
	private Query query;
	
	public SelectItem(String description){
		super(description);
	}
	
	public SelectItem(Column column) {
		this(column, null);
	}
	
	public Column getColumn() {
		return column;
	}

	public String getAlias() {
		return alias;
	}

	public SelectItem(Column column, String alias) {
		super(DESCRIPTION);
		this.column = column;
		this.alias = alias;
	}
	
	@Override
	public Query getQuery() {
		return query;
	}
}
