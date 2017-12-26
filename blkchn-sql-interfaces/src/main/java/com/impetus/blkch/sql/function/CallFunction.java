package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class CallFunction extends LogicalPlan {
    
    public static final String DESCRIPTION = "CallFunction";

    public CallFunction() {
        super(DESCRIPTION);
    }

}
