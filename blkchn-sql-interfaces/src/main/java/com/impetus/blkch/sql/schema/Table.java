package com.impetus.blkch.sql.schema;

import java.util.ArrayList;
import java.util.List;

import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.TreeNode;

public class Table  extends LogicalPlan implements TableInt{

	public static final String DESCRIPTION = "TABLE";
	
	private List<ColumnInt> columns = new ArrayList<ColumnInt>();
	
	private String name;
	
	public Table(String name){
		super(DESCRIPTION + ":" + name);
		this.name = name;
	}
	
	
	public List<ColumnInt> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnInt> columns) {
		this.columns = columns;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ColumnInt getColumn(String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(String name) {
		this.name = name;
	} 

}
