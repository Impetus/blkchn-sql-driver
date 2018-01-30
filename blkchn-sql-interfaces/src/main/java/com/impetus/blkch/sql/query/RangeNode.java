package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.util.RangeList;

public class RangeNode<T extends Comparable<T>> extends TreeNode {
    
    private static final String DESCRIPTION = "RANGE:";
    
    private String column;
    
    private RangeList<T> rangeList = new RangeList<>();

    public RangeNode(String column) {
        super(DESCRIPTION + column);
        this.column = column;
    }
    
    public String getColumn() {
        return column;
    }
    
    public RangeList<T> getRangeList() {
        return rangeList;
    }

}
