/*******************************************************************************
* * Copyright 2017 Impetus Infotech.
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

import java.util.List;

import com.impetus.blkch.sql.parser.LogicalPlan;

public class Query extends LogicalPlan {

    public static final String DESCRIPTION = "QUERY";

    private List<SelectItem> selectItems;

    private FromItem fromItem;

    private List<FilterItem> whereItems;

    private List<LogicalPlan> subqueries;

    public Query() {
        super(DESCRIPTION);
    }

    public Query addSelectItem(SelectItem item) {
        selectItems.add(item);
        return this;
    }

    public Query setFromItem(FromItem item) {
        fromItem = item;
        return this;
    }

    public Query addWhereItem(FilterItem item) {
        whereItems.add(item);
        return this;
    }

}
