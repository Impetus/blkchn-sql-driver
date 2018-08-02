package com.impetus.blkch.sql.user;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Affiliation extends LogicalPlan {
    
    public static final String DESCRIPTION = "AFFILIATION";
    
    private String value;

    public Affiliation(String value) {
        super(DESCRIPTION + ":" + value);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

}
