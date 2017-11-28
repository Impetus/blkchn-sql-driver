package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class OrderByClause extends TreeNode {

    public static final String DESCRIPTION = "ORDER_BY_CLAUSE";

    public OrderByClause() {
        super(DESCRIPTION);
    }

}
