package com.impetus.blkch.util.placeholder;

import java.util.ArrayList;
import java.util.List;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.insert.ColumnValue;
import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.parser.TreeNode;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.Placeholder;

public class InsertPlaceholderHandler implements PlaceholderHandler {

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
                IdentifierNode ident = new IdentifierNode(
                        placeholderValues[placeholderIndexes.indexOf(columnValIndex)].toString());
                ident.setParent(node);
                child.getParent().setChildNode(ident, columnValIndex);

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
        else
            throw new BlkchnException("ERROR :Index List is empty");
    }
}
