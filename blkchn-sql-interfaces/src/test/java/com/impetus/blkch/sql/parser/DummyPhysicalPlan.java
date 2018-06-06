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
package com.impetus.blkch.sql.parser;

import java.util.Arrays;
import java.util.List;

import com.impetus.blkch.util.BigIntegerRangeOperations;
import com.impetus.blkch.util.LongRangeOperations;
import com.impetus.blkch.util.RangeOperations;

public class DummyPhysicalPlan extends PhysicalPlan
{

    public DummyPhysicalPlan(String description, LogicalPlan logicalPlan)
    {
        super(description, logicalPlan);
    }

    @Override
    public List<String> getRangeCols(String table)
    {
        return Arrays.asList("column1", "column2");
    }

    @Override
    public List<String> getQueryCols(String table)
    {
        return Arrays.asList("qcol1", "qcol2");
    }

    @Override
    public RangeOperations<?> getRangeOperations(String table, String column)
    {
        switch (column)
        {
        case "column1":
            return new LongRangeOperations();
        default:
            return new BigIntegerRangeOperations();
        }
    }

    @Override
    public boolean tableExists(String table) {
        return true;
    }

    @Override
    public boolean columnExists(String table, String column) {
        return true;
    }
    

}
