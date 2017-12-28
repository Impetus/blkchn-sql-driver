package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class ClassName extends LogicalPlan {

    public static final String DESCRIPTION = "ClassName";
    
    private String name;

    public ClassName(String name) {
        super(DESCRIPTION + ":" + name);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
