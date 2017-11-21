package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class FunctionNode extends TreeNode {
	
	public static final String DESCRIPTION = "FUNCTION";

	public FunctionNode() {
		super(DESCRIPTION);
	}

}
