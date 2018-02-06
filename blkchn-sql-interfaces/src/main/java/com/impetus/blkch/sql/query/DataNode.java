package com.impetus.blkch.sql.query;

import java.util.List;

import com.impetus.blkch.sql.parser.TreeNode;

public class DataNode<T> extends TreeNode {
    
    public static final String DESCRIPTION = "DATANODE";
    
    private String table;
    
    private List<T> keys;

    public DataNode(String table, List<T> keys) {
        super(DESCRIPTION + ":" + table + "," + keys);
        this.table = table;
        this.keys = keys;
    }
    
    public List<T> getKeys() {
        return keys;
    }
    
    public String getTable() {
        return table;
    }

}
