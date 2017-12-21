package com.impetus.blkch.sql.insert;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class ColumnValue extends LogicalPlan {

    public static final String DESCRIPTION = "ColumnValue";

    public ColumnValue() {
        super(DESCRIPTION);
    }

}
