package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Function extends LogicalPlan {
    
    public static final String DESCRIPTION = "FUNCTION";

    public Function() {
        super(DESCRIPTION);
    }

}
