package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Version extends LogicalPlan {

    public static final String DESCRIPTION = "Version";

    public Version(String version) {
        super(DESCRIPTION + ":" + version);
    }

}