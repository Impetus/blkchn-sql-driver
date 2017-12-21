package com.impetus.blkch.sql.insert;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class ColumnName extends LogicalPlan {

    public static final String DESCRIPTION = "ColumnName";

    public ColumnName() {
        super(DESCRIPTION);
    }

}
