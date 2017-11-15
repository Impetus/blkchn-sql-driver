package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class GroupByClause extends TreeNode{
	
	public static final String DESCRIPTION = "GROUP_BY_CLAUSE";

	public GroupByClause() {
		super(DESCRIPTION);
	}

}
