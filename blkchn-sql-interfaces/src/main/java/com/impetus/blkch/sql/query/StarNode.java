package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class StarNode extends TreeNode {

    public static final String DESCRIPTION = "STAR";

    private String tableIdentifier;

    public StarNode() {
        this(null);
    }

    public StarNode(String tableIdentifier) {
        super(DESCRIPTION + ":" + ((tableIdentifier != null) ? tableIdentifier + ".*" : "*"));
        this.tableIdentifier = tableIdentifier;
    }

    public String getTableIdentifier() {
        return tableIdentifier;
    }

    public void setTableIdentifier(String tableIdentifier) {
        this.tableIdentifier = tableIdentifier;
    }

}
