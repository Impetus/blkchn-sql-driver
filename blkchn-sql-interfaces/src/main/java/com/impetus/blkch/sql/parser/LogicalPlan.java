package com.impetus.blkch.sql.parser;

import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.QueryItemInterface;

public class LogicalPlan extends TreeNode implements QueryItemInterface{

	private TreeNode currentNode;
	private	Query query;
	
	public LogicalPlan(String description){
		super(description);
	}
	
	public TreeNode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(TreeNode currentNode) {
		this.currentNode = currentNode;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
	
}
