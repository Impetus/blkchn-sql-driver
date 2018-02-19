package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class FieldDelimiter extends LogicalPlan {

    public static final String DESCRIPTION = "FIELD_DELIMITER";
    
    public FieldDelimiter() {
        super(DESCRIPTION);
    }
}
