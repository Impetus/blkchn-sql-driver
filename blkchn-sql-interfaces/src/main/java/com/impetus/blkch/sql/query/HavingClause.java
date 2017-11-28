package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class HavingClause extends TreeNode {

    public static final String DESCRIPTION = "HAVING_CLAUSE";

    public HavingClause() {
        super(DESCRIPTION);
    }

}
