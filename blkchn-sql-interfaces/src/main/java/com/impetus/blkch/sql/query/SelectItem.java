package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.schema.Column;

public class SelectItem implements QueryItem {

	private Column column;
	
	private String alias;
	
	private Query query;
	
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
		this.column = column;
		this.alias = alias;
	}
	
	void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public Query getQuery() {
		return query;
	}
}
