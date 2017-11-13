package com.impetus.blkch.sql.query;


import java.util.List;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Query extends LogicalPlan{

	public static final String DESCRIPTION = "QUERY";
	
	private List<SelectItem> selectItems;
	
	private FromItem fromItem;
	
	private List<FilterItem> whereItems;
	
	private List<LogicalPlan> subqueries;
	
	public Query() {
		super(DESCRIPTION);
	}
	
	public Query addSelectItem(SelectItem item) {
		selectItems.add(item);
		return this;
	}
	
	public Query setFromItem(FromItem item) {
		fromItem = item;
		return this;
	}
	
	public Query addWhereItem(FilterItem item) {
		whereItems.add(item);
		return this;
	}

}
