package com.impetus.blkch.sql.user;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Secret extends LogicalPlan {
    
    public static final String DESCRIPTION = "SECRET";
    
    private String value;
    
    public Secret(String value) {
        super(DESCRIPTION + ":" + value);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

}
