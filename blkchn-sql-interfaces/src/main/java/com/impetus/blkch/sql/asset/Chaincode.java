package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Chaincode extends LogicalPlan {
    
    public static final String DESCRIPTION = "CHAINCODE";

    public Chaincode() {
        super(DESCRIPTION);
    }

}
