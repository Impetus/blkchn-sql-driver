package com.impetus.blkch.sql.schema;

public interface Column {

	public String getName();
	
	public ColumnType getType();
	
	public Table getTable();
}
