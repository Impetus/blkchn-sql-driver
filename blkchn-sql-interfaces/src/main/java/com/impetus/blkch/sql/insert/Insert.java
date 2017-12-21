package com.impetus.blkch.sql.insert;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Insert extends LogicalPlan {

    public static final String DESCRIPTION = "INSERT";

    public Insert() {
        super(DESCRIPTION);
    }

}
