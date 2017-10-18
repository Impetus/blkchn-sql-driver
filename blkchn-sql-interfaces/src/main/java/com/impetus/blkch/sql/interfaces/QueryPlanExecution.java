package com.impetus.blkch.sql.interfaces;

import java.sql.ResultSet;

import com.impetus.blkch.sql.parser.LogicalPlan;

public interface QueryPlanExecution {
	
	public LogicalPlan getLogicalPlan(String sqlText) ;
	
	public PhysicalPlan convertToPhysicalPlan(LogicalPlan logicalPlan);
	
	public Object executePlan(PhysicalPlan physicalPlan);
	
	public ResultSet executeQuery(String sqlText);

}
