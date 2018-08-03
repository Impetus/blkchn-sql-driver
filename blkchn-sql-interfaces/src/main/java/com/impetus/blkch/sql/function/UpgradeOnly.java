package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class UpgradeOnly extends LogicalPlan {
    
    public static final String DESCRIPTION = "UPGRADE_ONLY";

    public UpgradeOnly() {
        super(DESCRIPTION);
    }

}
