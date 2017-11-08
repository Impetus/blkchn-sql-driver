package com.impetus.blkch.sql.schema;

import java.util.List;

public interface Table {

	public List<Column> getColumns();
	
	public String getName();
	
	public Column getColumn(String columnName);
}
