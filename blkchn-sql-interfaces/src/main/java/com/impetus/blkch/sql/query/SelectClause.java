package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class SelectClause extends TreeNode {
	
	public static final String DESCRIPTION = "SELECT_CLAUSE";
	
	public SelectClause() {
		super(DESCRIPTION);
	}

}
