package com.impetus.blkch.sql.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.WhereClause;

public class PhysicalPlan extends TreeNode {
    
    private LogicalPlan logicalPlan;
    
    private Map<Integer, FilterItem> whereClauseMap;
    
    private Set<TreeNode> whereClauseItems;

    public PhysicalPlan(String description, LogicalPlan logicalPlan) {
        super(description);
        this.logicalPlan = logicalPlan;
    }
    
    public WhereClause getPhysicalWhereClause() {
        whereClauseItems = new HashSet<>();
        if(logicalPlan.getChildType(WhereClause.class, 0).hasChildType(FilterItem.class)) {
            whereClauseItems.add(logicalPlan.getChildType(WhereClause.class, 0).getChildType(FilterItem.class, 0));
            return logicalPlan.getChildType(WhereClause.class, 0);
        } else {
            return null;
        }
    }
    
    private void processLogicalOperation(LogicalOperation logicalOperation) {
        if (logicalOperation.getChildNodes().size() != 2) {
            throw new BlkchnException("Logical operation should have two boolean expressions");
        }
        if (logicalOperation.getChildNode(0) instanceof LogicalOperation) {
            // TODO
        } else {
            whereClauseMapUpdateFI((FilterItem) logicalOperation.getChildNode(0));
        }
        if (logicalOperation.getChildNode(1) instanceof LogicalOperation) {
            // TODO
        } else {
            // TODO
        }
    }
    
    private void processFilterItem(FilterItem filterItem) {
        
    }
    
    private void generateUUIDs() {
        if(logicalPlan.hasChildType(WhereClause.class)) {
            whereClauseMap = new HashMap<>();
            WhereClause whereClause = logicalPlan.getQuery().getChildType(WhereClause.class, 0);
            if (whereClause.hasChildType(FilterItem.class)) {
                FilterItem filterItem = whereClause.getChildType(FilterItem.class, 0);
                whereClauseMapUpdateFI(filterItem);
            } else {
                LogicalOperation operation = whereClause.getChildType(LogicalOperation.class, 0);
                WhereClauseMapUpdateLO(operation);
            }
        }
    }
    
    private void WhereClauseMapUpdateLO(LogicalOperation logicalOperation) {
        if (logicalOperation.getChildNodes().size() != 2) {
            throw new BlkchnException("Logical operation should have two boolean expressions");
        }
        if (logicalOperation.getChildNode(0) instanceof LogicalOperation) {
            WhereClauseMapUpdateLO((LogicalOperation)logicalOperation.getChildNode(0));
        } else {
            whereClauseMapUpdateFI((FilterItem) logicalOperation.getChildNode(0));
        }
        if (logicalOperation.getChildNode(1) instanceof LogicalOperation) {
            WhereClauseMapUpdateLO((LogicalOperation)logicalOperation.getChildNode(1));
        } else {
            whereClauseMapUpdateFI((FilterItem) logicalOperation.getChildNode(1));
        }
    }
    
    private void whereClauseMapUpdateFI(FilterItem filterItem) {
        whereClauseMap.put(filterItem.hashCode(), filterItem);
    }
    
    public List<String> getRangeCols(String table) {
        return Arrays.asList("blockNo");
    }
    
    public List<String> getQueryCols(String table) {
        return Arrays.asList("blockNo", "transactionId", "blockHash");
    }

}
