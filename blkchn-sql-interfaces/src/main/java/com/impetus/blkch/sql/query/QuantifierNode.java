package com.impetus.blkch.sql.query;

import com.impetus.blkch.sql.parser.TreeNode;

public class QuantifierNode extends TreeNode {

    public static final String DESCRIPTION = "QUANTIFIER";

    private Quantifier quantifier;

    public QuantifierNode(Quantifier quantifier) {
        super(DESCRIPTION + ":" + quantifier);
        this.quantifier = quantifier;
    }

    public boolean isDistinct() {
        return quantifier == Quantifier.DISTINCT;
    }

    public boolean isAll() {
        return quantifier == Quantifier.ALL;
    }

    public static enum Quantifier {

        DISTINCT,

        ALL
    }

}
