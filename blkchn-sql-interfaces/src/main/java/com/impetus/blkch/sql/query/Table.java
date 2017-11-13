package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Table  extends LogicalPlan{

	public static final String DESCRIPTION = "TABLE";
	
	private String name;
	
	public Table(String name){
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
