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
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.Placeholder;
import com.impetus.blkch.sql.query.WhereClause;

public class QueryPlaceholderHandler implements PlaceholderHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryPlaceholderHandler.class);

    protected LogicalPlan logicalPlan;

    protected Object[] placeholderValues;

    protected List<Integer> placeholderIndexes = new ArrayList<Integer>();

    protected int filterItemIndex;

    protected TreeNode whereClause;

    public QueryPlaceholderHandler(LogicalPlan logicalPlan) {
        this.logicalPlan = logicalPlan;
        this.filterItemIndex = 0;
        this.whereClause = logicalPlan.getQuery().getChildType(WhereClause.class, 0);
    }

    @Override
    public void setPlaceholderIndex() {
        if (null != whereClause)
            setPlaceholderIndex(whereClause);
    }

    @Override
    public void setPlaceholderIndex(TreeNode node) {
        for (TreeNode child : node.getChildNodes()) {
            if (child.getClass().isAssignableFrom((LogicalOperation.class))) {
                setPlaceholderIndex(child);
            } else if (child.getClass().isAssignableFrom((FilterItem.class))) {
                if (child.hasChildType(Placeholder.class)) {
                    placeholderIndexes.add(filterItemIndex);
                }
                filterItemIndex++;
            } 
        }
    }

    @Override
    public void alterLogicalPlan(Object[] placeholderValues) {
        filterItemIndex = 0;
        this.placeholderValues = placeholderValues;
        setPlaceholderValue(whereClause);
    }

    @Override
    public void setPlaceholderValue(TreeNode node) {
        for (TreeNode child : node.getChildNodes()) {
            if (child.getClass().isAssignableFrom((LogicalOperation.class))) {
                setPlaceholderValue(child);
            } else if (child.getClass().isAssignableFrom((FilterItem.class))) {
                if ((child.hasChildType(Placeholder.class) || child.hasChildType(IdentifierNode.class))
                        && placeholderIndexes.contains(filterItemIndex)) {
                    if (null != placeholderValues[placeholderIndexes.indexOf(filterItemIndex)]) {
                        IdentifierNode ident = new IdentifierNode(
                                placeholderValues[placeholderIndexes.indexOf(filterItemIndex)].toString());
                        child.setChildNode(ident, 2);
                    } else {
                        LOGGER.error("ERROR : Can't set NULL value");
                        throw new BlkchnException("Can't set NULL value");
                    }
                }
                filterItemIndex++;
            } else {
                LOGGER.error("ERROR while setting up filterItem values");
                throw new BlkchnException("ERROR while setting up filterItem values");
            }
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
