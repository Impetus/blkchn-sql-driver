package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class DirectAPINode extends TreeNode {
    
    public static final String DESCRIPTION = "DirectAPINode";
    
    private String column;
    
    private String value;
    
    public DirectAPINode(String column, String value) {
        super(DESCRIPTION + ":" + column + "=" + value);
        this.column = column;
        this.value = value;
    }
    
    public String getColumn() {
        return column;
    }
    
    public String getValue() {
        return value;
    }

}
