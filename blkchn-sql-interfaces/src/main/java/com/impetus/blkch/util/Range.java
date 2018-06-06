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

public final class Range<T extends Number & Comparable<T>> {
    
    private T min;
    
    private T max;
    
    public Range(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }
    
    public T getMax() {
        return max;
    }
    
    @Override
    public String toString() {
        return "[" + min + "-" + max + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Range<?>)) {
            return false;
        }
        Range<?> other = (Range<?>) obj;
        return this.min.equals(other.min) && this.max.equals(other.max);
    }
    
    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + min.hashCode();
        hashCode = prime * hashCode + max.hashCode();
        return hashCode;
    }
    
}
