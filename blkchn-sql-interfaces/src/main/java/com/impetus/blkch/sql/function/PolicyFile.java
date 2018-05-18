package com.impetus.blkch.sql.function;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class PolicyFile extends LogicalPlan {
    
    public static final String DESCRIPTION = "POLICY_FILE";
    
    private String fileLocation;

    public PolicyFile(String fileLocation) {
        super(DESCRIPTION + ":" + fileLocation);
        this.fileLocation = fileLocation;
    }
    
    public String getFileLocation() {
        return fileLocation;
    }

}
