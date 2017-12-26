package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Parameters extends LogicalPlan {
    
    public static final String DESCRIPTION = "Parameters";
    
    public Parameters() {
        super(DESCRIPTION);
    }

}
