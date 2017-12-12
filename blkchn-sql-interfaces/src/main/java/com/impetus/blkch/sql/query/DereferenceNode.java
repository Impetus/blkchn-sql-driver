package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class DereferenceNode extends TreeNode {
    public static final String DESCRIPTION = "DEREFERENCE";

    public DereferenceNode() {
        super(DESCRIPTION);
    }
}
