package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class LimitClause extends TreeNode {
	
	public static final String DESCRIPTION = "LIMIT_CLAUSE";

	public LimitClause() {
		super(DESCRIPTION);
	}

}
