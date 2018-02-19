package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class CreateAsset extends LogicalPlan {
    
    public static final String DESCRIPTION = "CREATE_ASSET";

    public CreateAsset() {
        super(DESCRIPTION);
    }

}
