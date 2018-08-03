package com.impetus.blkch.sql.parser;

import org.junit.Test;

import com.impetus.blkch.util.placeholder.LogicalPlanGen;

import junit.framework.TestCase;

public class FilterItemTest extends TestCase{

    @Test
    public void testValidateLogicalPlan(){

        String sql = "Select * from myTable tbl where column1 is not null and rcol1 > 5";
        LogicalPlan plan = new LogicalPlanGen().getLogicalPlan(sql);
        plan.getQuery().traverse();
        assertEquals(true, true);
    }
}
