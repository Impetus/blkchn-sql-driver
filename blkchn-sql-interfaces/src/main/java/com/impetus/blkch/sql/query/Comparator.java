package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class Comparator extends TreeNode {
	
	public static final String DESCRIPTION = "COMPARATOR";
	
	private ComparisionOperator op;

	public Comparator(ComparisionOperator op) {
		super(DESCRIPTION + ":" + op.opValue);
		this.op = op;
	}
	
	public boolean isEQ() {
		return this.op == ComparisionOperator.EQ;
	}
	
	public boolean isGT() {
		return this.op == ComparisionOperator.GT;
	}
	
	public boolean isGTE() {
		return this.op == ComparisionOperator.GTE;
	}
	
	public boolean isLT() {
		return this.op == ComparisionOperator.LT;
	}
	
	public boolean isLTE() {
		return this.op == ComparisionOperator.LTE;
	}
	
	public boolean isNEQ() {
		return this.op == ComparisionOperator.NEQ;
	}
	
	public static enum ComparisionOperator {
		
		EQ("="),
		GT(">"),
		GTE(">="),
		LT("<"),
		LTE("<="),
		NEQ("!=");
		
		private String opValue;
		
		private ComparisionOperator(String val) {
			this.opValue = val;
		}
		
		public static ComparisionOperator getOp(String val) {
			for(ComparisionOperator op : ComparisionOperator.values()) {
				if(op.opValue.equals(val)) {
					return op;
				}
			}
			throw new RuntimeException("Unidentified Operator " + val);
		}
	}

}
