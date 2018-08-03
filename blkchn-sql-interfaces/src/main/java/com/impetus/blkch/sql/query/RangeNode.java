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

import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.util.Range;
import com.impetus.blkch.util.RangeList;

public class RangeNode<T extends Number & Comparable<T>> extends TreeNode {
    
    private static final String DESCRIPTION = "RANGE";
    
    private String table;
    
    private String column;
    
    private RangeList<T> rangeList = new RangeList<>();

    public RangeNode(String table, String column) {
        super(DESCRIPTION + ":" + table + ":" + column);
        this.table = table;
        this.column = column;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
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
    public boolean equals(Object obj) {
        if(!(obj instanceof RangeNode<?>)) {
            return false;
        }
        RangeNode<?> other = (RangeNode<?>) obj; 
        return super.equals(obj) && this.rangeList.equals(other.rangeList);
    }
    
    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + table.hashCode();
        hashCode = prime * hashCode + column.hashCode();
        hashCode = prime * hashCode + rangeList.hashCode();
        return hashCode;
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
    
    @Override
    public Object clone() {
        RangeNode<T> rangeNode = (RangeNode<T>)super.clone();
        rangeNode.rangeList = new RangeList<>();
        for(Range<T> range : this.rangeList.getRanges()) {
            rangeNode.rangeList.addRange(new Range<T>(range.getMin(), range.getMax()));
        }
        return rangeNode;
    }

}
