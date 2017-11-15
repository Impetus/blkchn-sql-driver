package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class LogicalOperation extends TreeNode {
	
	public static final String DESCRIPTION = "LOGICAL_OPER";
	
	private Operator operation;

	public LogicalOperation(Operator operation) {
		super(DESCRIPTION + ":" + operation);
		this.operation = operation;
	}
	
	public boolean isAnd() {
		return operation == Operator.AND;
	}
	
	public boolean isOr() {
		return operation == Operator.OR;
	}

	public static enum Operator {
		
		AND,
		
		OR
	}
}
