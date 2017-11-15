package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class OrderingDirection extends TreeNode{

	public static final String DESCRIPTION = "ORDER_DIR";
	
	private Direction direction;
	
	public OrderingDirection(Direction direction) {
		super(DESCRIPTION + ":" + direction);
		this.direction = direction;
	}
	
	public boolean isAsc() {
		return direction == Direction.ASC;
	}
	
	public boolean isDesc() {
		return direction == Direction.DESC;
	}
	
	public static enum Direction {
		ASC,
		DESC
	}

}
