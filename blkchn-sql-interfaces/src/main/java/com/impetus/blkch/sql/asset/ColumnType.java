package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class ColumnType extends LogicalPlan {

    public static final String DESCRIPTION = "COLUMN_TYPE";
    
    public ColumnType() {
        super(DESCRIPTION);
    }
}
