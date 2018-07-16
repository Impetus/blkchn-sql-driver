package com.impetus.blkch.util.placeholder;

import com.impetus.blkch.sql.parser.TreeNode;

public interface PlaceholderHandler {

    public void setPlaceholderIndex();

    public void setPlaceholderIndex(TreeNode node);

    public void alterLogicalPlan(Object[] placeholderValues);

    public void setPlaceholderValue(TreeNode node);

    public boolean isIndexListEmpty();

    public int getIndexListCount();
}
