package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Version extends LogicalPlan {

    public static final String DESCRIPTION = "Version";
    
    public String version;

    public Version(String version) {
        super(DESCRIPTION + ":" + version);
        this.version = version;
    }
    
    public String getVersion() {
        return version;
    }

}