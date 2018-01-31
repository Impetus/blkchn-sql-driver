package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.util.Range;
import com.impetus.blkch.util.RangeList;

public class RangeNode<T extends Number & Comparable<T>> extends TreeNode {
    
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
    
    public void setRangeList(RangeList<T> rangeList) {
        this.rangeList = rangeList;
    }
    
    public RangeList<T> getRangeList() {
        return rangeList;
    }
    
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getDescription() + ":[");
        for(Range<T> range : rangeList.getRanges()) {
            sb.append("[" + range.getMin() + "-" + range.getMax() + "]");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

}
