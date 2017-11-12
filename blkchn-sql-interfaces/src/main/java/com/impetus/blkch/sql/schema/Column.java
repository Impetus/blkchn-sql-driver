package com.impetus.blkch.sql.schema;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Column extends LogicalPlan implements ColumnInt{

	public static final String DESCRIPTION = "COLUMN";
	
	private String name;
	
	public Column(String name){
		super(DESCRIPTION + ":" + name);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ColumnType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
