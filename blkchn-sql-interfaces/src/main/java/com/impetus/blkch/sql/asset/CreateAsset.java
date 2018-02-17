package com.impetus.blkch.sql.asset;

import com.impetus.blkch.sql.parser.TreeNode;

public class CreateAsset extends TreeNode {
    
    public static final String DESCRIPTION = "CREATE_ASSET";

    public CreateAsset() {
        super(DESCRIPTION);
    }

}
