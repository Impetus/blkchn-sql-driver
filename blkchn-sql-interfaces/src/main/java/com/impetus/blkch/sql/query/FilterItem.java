package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.schema.Column;

public class FilterItem implements QueryItem {

	private Column column;
	
	private OperatorType operator;
	
	private Object operand;
	
	private Query query;
	
	public FilterItem(Column column, OperatorType operator, Object operand) {
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
	
	void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public Query getQuery() {
		return query;
	}
}
