package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class IdentifierNode extends TreeNode {

    public static final String DESCRIPTION = "IDENT";

    private String value;

    public IdentifierNode(String value) {
        super(DESCRIPTION + ":" + value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
