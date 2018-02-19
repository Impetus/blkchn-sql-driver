package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class DropAsset extends LogicalPlan {
    
    public static final String DESCRIPTION = "DROP_ASSET";
    
    public DropAsset() {
        super(DESCRIPTION);
    }

}
