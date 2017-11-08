package com.impetus.blkch.sql.query;

import java.util.ArrayList;
import java.util.List;

public class Query {

	private List<SelectItem> selectItems;
	
	private FromItem fromItem;
	
	private List<FilterItem> whereItems;
	
	public Query() {
		selectItems = new ArrayList<>();
		whereItems = new ArrayList<>();
	}
	
	public Query addSelectItem(SelectItem item) {
		selectItems.add(item);
		item.setQuery(this);
		return this;
	}
	
	public Query setFromItem(FromItem item) {
		fromItem = item;
		item.setQuery(this);
		return this;
	}
	
	public Query addWhereItems(FilterItem item) {
		whereItems.add(item);
		item.setQuery(this);
		return this;
	}
}
