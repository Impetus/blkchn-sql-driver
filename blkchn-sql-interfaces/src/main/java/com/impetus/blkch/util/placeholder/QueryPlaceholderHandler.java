package com.impetus.blkch.util.placeholder;

import java.util.ArrayList;
import java.util.List;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.Placeholder;
import com.impetus.blkch.sql.query.WhereClause;

public class QueryPlaceholderHandler implements PlaceholderHandler {

    protected LogicalPlan logicalPlan;

    protected Object[] placeholderValues;

    protected List<Integer> placeholderIndexes = new ArrayList<Integer>();

    protected int filterItemIndex;

    protected TreeNode whereClause;

    protected boolean isListEmpty = true;

    public QueryPlaceholderHandler(LogicalPlan logicalPlan) {
        this.logicalPlan = logicalPlan;
        this.filterItemIndex = 0;
        this.whereClause = logicalPlan.getQuery().getChildType(WhereClause.class, 0);
    }

    @Override
    public void setPlaceholderIndex() {
        setPlaceholderIndex(whereClause);
    }

    @Override
    public void setPlaceholderIndex(TreeNode node) {
        for (TreeNode child : node.getChildNodes()) {
            if (child.getClass().isAssignableFrom((LogicalOperation.class))) {
                setPlaceholderIndex(child);
            } else if (child.getClass().isAssignableFrom((FilterItem.class))) {
                if (child.hasChildType(Placeholder.class))
                    placeholderIndexes.add(filterItemIndex);
                filterItemIndex++;
            } else
                throw new BlkchnException(
                        "ERROR while setting up the placeholder (?) indexes. Please verify if query is executable.");
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
                    } else
                        throw new BlkchnException("Can't set NULL value");
                }
                filterItemIndex++;
            } else
                throw new BlkchnException("ERROR while setting up filterItem values");
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
        else
            throw new BlkchnException("ERROR :Index List is empty");
    }
}
