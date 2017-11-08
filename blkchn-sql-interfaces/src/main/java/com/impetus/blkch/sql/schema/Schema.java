package com.impetus.blkch.sql.schema;

import java.util.List;

public interface Schema {

	public List<Table> getTables();
	
	public Table getTable(String tableName);
	
}
