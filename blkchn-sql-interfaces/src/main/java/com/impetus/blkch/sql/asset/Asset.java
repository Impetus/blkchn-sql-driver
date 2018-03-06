package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Asset extends LogicalPlan {
    
    public static final String DESCRIPTION = "ASSET";

    public Asset() {
        super(DESCRIPTION);
    }

}
