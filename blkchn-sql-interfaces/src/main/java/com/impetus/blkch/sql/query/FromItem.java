package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.schema.Table;

public class FromItem implements QueryItem {

	private Table table;
	
	private String alias;
	
	private Query query;
	
	public FromItem(Table table) {
		this(table, null);
	}
	
	public FromItem(Table table, String alias) {
		this.table = table;
		this.alias = alias;
	}

	public Table getTable() {
		return table;
	}

	public String getAlias() {
		return alias;
	}
	
	void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public Query getQuery() {
		return query;
	}
}
