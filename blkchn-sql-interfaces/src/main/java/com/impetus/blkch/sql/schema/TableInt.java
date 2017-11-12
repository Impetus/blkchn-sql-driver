package com.impetus.blkch.sql.schema;

import java.util.List;

public interface TableInt {

	public List<ColumnInt> getColumns();
	
	public String getName();
	
	public ColumnInt getColumn(String columnName);
}
