package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class ClassName extends LogicalPlan {

    public static final String DESCRIPTION = "ClassName";

    public ClassName(String name) {
        super(DESCRIPTION + ":" + name);
    }
}
