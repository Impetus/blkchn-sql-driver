package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.schema.Column;

public class FilterItem extends LogicalPlan {

	public static final String DESCRIPTION = "FILTER_ITEM";
	
	private Column column;
	
	private OperatorType operator;
	
	private Object operand;
	
	private Query query;
	
	public FilterItem(Column column, OperatorType operator, Object operand, String description) {
		super(DESCRIPTION);
		this.column = column;
		this.operator = operator;
		this.operand = operand;
	}

	public Column getColumn() {
		return column;
	}

	public OperatorType getOperator() {
		return operator;
	}

	public Object getOperand() {
		return operand;
	}
	
	@Override
	public Query getQuery() {
		return query;
	}
}
