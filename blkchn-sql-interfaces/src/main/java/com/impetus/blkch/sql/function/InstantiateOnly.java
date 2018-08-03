package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class InstantiateOnly extends LogicalPlan {

    public static final String DESCRIPTION = "INSTANTIATE_ONLY";

    public InstantiateOnly() {
        super(DESCRIPTION);
    }
}
