package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class StorageType extends LogicalPlan {

    public static final String DESCRIPTION = "STORAGE_TYPE";
    
    public StorageType() {
        super(DESCRIPTION);
    }
}
