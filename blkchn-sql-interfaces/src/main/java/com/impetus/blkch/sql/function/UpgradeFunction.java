package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class UpgradeFunction extends LogicalPlan {
    
    public static final String DESCRIPTION = "UPGRADE_FUNCTION";
    
    public UpgradeFunction() {
        super(DESCRIPTION);
    }

}