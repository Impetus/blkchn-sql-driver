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

import com.impetus.blkch.sql.parser.LogicalPlan;

public class FilterItem extends LogicalPlan {

    public static final String DESCRIPTION = "FILTER_ITEM";

    private Column column;

    private OperatorType operator;

    private Object operand;

    public FilterItem(Column column, OperatorType operator, Object operand) {
        super(DESCRIPTION);
        this.column = column;
        this.operator = operator;
        this.operand = operand;
    }

    public FilterItem() {
        this(null, null, null);
    }

    public Column getColumn() {
        return column;
    }

    public OperatorType getOperator() {
        return operator;
    }

    public Object getOperand() {
        return operand;
    }

}
