/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
* *
* * Licensed under the Apache License, Version 2.0 (the "License");
* * you may not use this file except in compliance with the License.
* * You may obtain a copy of the License at
* *
* * http://www.apache.org/licenses/LICENSE-2.0
* *
* * Unless required by applicable law or agreed to in writing, software
* * distributed under the License is distributed on an "AS IS" BASIS,
* * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* * See the License for the specific language governing permissions and
* * limitations under the License.
******************************************************************************/
package com.impetus.blkch.sql.query;

import java.util.ArrayList;
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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof DataNode<?>)) {
            return false;
        }
        DataNode<?> other = (DataNode<?>) obj;
        if(!this.table.equals(other.table)) {
            return false;
        }
        if(this.keys.size() != other.keys.size()) {
            return false;
        }
        for(T key : this.keys) {
            boolean exists = false;
            for(Object otherKey : other.keys) {
                if(key.equals(otherKey)) {
                    exists = true;
                    break;
                }
            }
            if(!exists) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + table.hashCode();
        int listHashCode = 0;
        for(T key : keys) {
            listHashCode += key.hashCode();
        }
        hashCode = prime * hashCode + listHashCode;
        return hashCode;
    }
    
    @Override
    public Object clone() {
        DataNode<T> root = (DataNode<T>) super.clone();
        root.keys = new ArrayList<>();
        for(T key : this.keys) {
            root.keys.add(key);
        }
        return root;
    }
}
