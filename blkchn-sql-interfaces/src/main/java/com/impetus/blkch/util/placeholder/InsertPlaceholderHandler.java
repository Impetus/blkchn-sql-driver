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
package com.impetus.blkch.util.placeholder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.insert.ColumnValue;
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.Placeholder;

public class InsertPlaceholderHandler implements PlaceholderHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(InsertPlaceholderHandler.class);

    protected LogicalPlan logicalPlan;

    protected Object[] placeholderValues;

    protected List<Integer> placeholderIndexes = new ArrayList<Integer>();

    protected int columnValIndex;

    protected TreeNode columnValue;

    public InsertPlaceholderHandler(LogicalPlan logicalPlan) {
        this.logicalPlan = logicalPlan;
        this.columnValIndex = 0;
        this.columnValue = logicalPlan.getInsert().getChildType(ColumnValue.class, 0);
    }

    @Override
    public void setPlaceholderIndex() {
        setPlaceholderIndex(columnValue);
    }

    @Override
    public void setPlaceholderIndex(TreeNode node) {
        for (TreeNode child : node.getChildNodes()) {
            if (child.getClass().isAssignableFrom((Placeholder.class)))
                placeholderIndexes.add(columnValIndex);
            columnValIndex++;

        }
    }

    @Override
    public void alterLogicalPlan(Object[] placeholderValues) {
        columnValIndex = 0;
        this.placeholderValues = placeholderValues;
        setPlaceholderValue(columnValue);
    }

    @Override
    public void setPlaceholderValue(TreeNode node) {
        for (TreeNode child : node.getChildNodes()) {
            if ((child.getClass().isAssignableFrom((Placeholder.class))
                    || child.getClass().isAssignableFrom((IdentifierNode.class)))
                    && placeholderIndexes.contains(columnValIndex)) {
                if (null != placeholderValues[placeholderIndexes.indexOf(columnValIndex)]) {
                    IdentifierNode ident = new IdentifierNode(
                            placeholderValues[placeholderIndexes.indexOf(columnValIndex)].toString());
                    ident.setParent(node);
                    child.getParent().setChildNode(ident, columnValIndex);
                } else {
                    LOGGER.error("ERROR: Can't set NULL value");
                    throw new BlkchnException("Can't set NULL value");
                }

            }
            columnValIndex++;
        }

    }

    @Override
    public boolean isIndexListEmpty() {
        if (placeholderIndexes.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public int getIndexListCount() {
        if (!placeholderIndexes.isEmpty())
            return placeholderIndexes.size();
        else {
            LOGGER.error("ERROR :Index List is empty");
            throw new BlkchnException("ERROR :Index List is empty");
        }
    }
}
