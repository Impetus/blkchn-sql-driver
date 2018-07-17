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
package com.impetus.blkch.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RangeList<T extends Number & Comparable<T>> implements Serializable {

    private List<Range<T>> ranges = new ArrayList<>();
    
    public final void addRange(Range<T> range) {
        ranges.add(range);
    }
    
    public final void addAllRanges(List<Range<T>> ranges) {
        for(Range<T> range : ranges) {
            this.ranges.add(range);
        }
    }
    
    @SafeVarargs
    public final void addAllRanges(Range<T>... ranges) {
        addAllRanges(Arrays.asList(ranges));
    }
    
    public final List<Range<T>> getRanges() {
        return ranges;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof RangeList<?>)) {
            return false;
        }
        RangeList<?> other = (RangeList<?>) obj;
        if(ranges.size() != other.ranges.size()) {
            return false;
        }
        for(Range<T> range : ranges) {
            boolean elemEqual = false;
            for(Range<?> otherRange : other.ranges) {
                if(range.equals(otherRange)) {
                    elemEqual = true;
                }
            }
            if(!elemEqual) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;
        int listHashCode = 1;
        for(Range<T> range : ranges) {
            listHashCode += range.hashCode();
        }
        hashCode = prime * hashCode + listHashCode;
        return hashCode;
    }
    
}
