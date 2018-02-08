package com.impetus.blkch.sql.parser;

import java.util.Arrays;
import java.util.List;

import com.impetus.blkch.util.BigIntegerRangeOperations;
import com.impetus.blkch.util.LongRangeOperations;
import com.impetus.blkch.util.RangeOperations;

public class DummyPhysicalPlan extends PhysicalPlan
{

    public DummyPhysicalPlan(String description, LogicalPlan logicalPlan)
    {
        super(description, logicalPlan);
    }

    @Override
    public List<String> getRangeCols(String table)
    {
        return Arrays.asList("column1", "column2");
    }

    @Override
    public List<String> getQueryCols(String table)
    {
        return Arrays.asList("qcol1", "qcol2");
    }

    @Override
    public RangeOperations<?> getRangeOperations(String table, String column)
    {
        switch (column)
        {
        case "column1":
            return new LongRangeOperations();
        default:
            return new BigIntegerRangeOperations();
        }
    }
    

}
