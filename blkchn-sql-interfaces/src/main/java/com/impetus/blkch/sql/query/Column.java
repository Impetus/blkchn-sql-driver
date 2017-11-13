package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Column extends LogicalPlan{

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

	
}
