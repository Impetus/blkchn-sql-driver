package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class WhereClause extends TreeNode {

    public static final String DESCRIPTION = "WHERE_CLAUSE";

    public WhereClause() {
        super(DESCRIPTION);
    }

}
