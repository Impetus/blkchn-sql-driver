package com.impetus.blkch.sql.smartcontract;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class SmartCnrtDeploy extends LogicalPlan {

    public static final String DESCRIPTION = "SmartContractDeploy";

    public SmartCnrtDeploy() {
        super(DESCRIPTION);
    }

}
