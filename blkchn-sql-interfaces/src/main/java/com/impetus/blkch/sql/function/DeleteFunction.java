package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class DeleteFunction extends LogicalPlan {
    
    public static final String DESCRIPTION = "DELETE_FUNCTION";

    public DeleteFunction() {
        super(DESCRIPTION);
    }

}
