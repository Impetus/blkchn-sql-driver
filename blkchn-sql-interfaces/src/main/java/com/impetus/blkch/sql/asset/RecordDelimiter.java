package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class RecordDelimiter extends LogicalPlan {

    public static final String DESCRIPTION = "RECORD_DELIMITER";
    
    public RecordDelimiter() {
        super(DESCRIPTION);
    }
}
