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

public class OrderingDirection extends TreeNode {

    public static final String DESCRIPTION = "ORDER_DIR";

    private Direction direction;

    public OrderingDirection(Direction direction) {
        super(DESCRIPTION + ":" + direction);
        this.direction = direction;
    }

    public boolean isAsc() {
        return direction == Direction.ASC;
    }

    public boolean isDesc() {
        return direction == Direction.DESC;
    }

    public static enum Direction {
        ASC, DESC
    }

}
