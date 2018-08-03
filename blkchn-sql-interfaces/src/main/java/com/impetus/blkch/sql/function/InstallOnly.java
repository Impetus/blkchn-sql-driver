package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class InstallOnly extends LogicalPlan {

    public static final String DESCRIPTION = "INSTALL_ONLY";

    public InstallOnly() {
        super(DESCRIPTION);
    }
}
