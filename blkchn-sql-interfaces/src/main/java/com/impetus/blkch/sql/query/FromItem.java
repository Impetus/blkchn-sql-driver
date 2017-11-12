package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.schema.Table;

public class FromItem extends LogicalPlan {

	public static final String DESCRIPTION = "FROM_ITEM";
	
	private Table table;
	
	private String alias;
	
	public FromItem() {
		super(DESCRIPTION);
	}
	
	public Table getTable() {
		return table;
	}

	public String getAlias() {
		return alias;
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
}
