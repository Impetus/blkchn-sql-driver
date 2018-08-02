package com.impetus.blkch.sql.user;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class CreateUser extends LogicalPlan {
    
    public static final String DESCRIPTION = "CREATE_USER";

    public CreateUser() {
        super(DESCRIPTION);
    }

}
