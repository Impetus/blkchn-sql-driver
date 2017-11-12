package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.schema.Table;

public class FromItem extends LogicalPlan {

	public static final String DESCRIPTION = "FROM_ITEM";
	
	private Table table;
	
	private String alias;
	
	private Query query;
	
	public FromItem(String name) {
		super(DESCRIPTION + ":" + name);
	}
	
	public FromItem(Table table) {
		this(table, null);
	}
	
	public FromItem(Table table, String alias) {
		super(DESCRIPTION + ":" + table.getName());
		this.table = table;
		this.alias = alias;
	}

	public Table getTable() {
		return table;
	}

	public String getAlias() {
		return alias;
	}
	
	@Override
	public Query getQuery() {
		return query;
	}
}
