/*******************************************************************************
 * * Copyright 2017 Impetus Infotech.
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

public class Comparator extends TreeNode {

    public static final String DESCRIPTION = "COMPARATOR";

    private ComparisionOperator op;

    public Comparator(ComparisionOperator op) {
        super(DESCRIPTION + ":" + op.opValue);
        this.op = op;
    }

    public boolean isEQ() {
        return this.op == ComparisionOperator.EQ;
    }

    public boolean isGT() {
        return this.op == ComparisionOperator.GT;
    }

    public boolean isGTE() {
        return this.op == ComparisionOperator.GTE;
    }

    public boolean isLT() {
        return this.op == ComparisionOperator.LT;
    }

    public boolean isLTE() {
        return this.op == ComparisionOperator.LTE;
    }

    public boolean isNEQ() {
        return this.op == ComparisionOperator.NEQ;
    }

    public static enum ComparisionOperator {

        EQ("="), GT(">"), GTE(">="), LT("<"), LTE("<="), NEQ("!=");

        private String opValue;

        private ComparisionOperator(String val) {
            this.opValue = val;
        }

        public static ComparisionOperator getOp(String val) {
            for (ComparisionOperator op : ComparisionOperator.values()) {
                if (op.opValue.equals(val)) {
                    return op;
                }
            }
            throw new RuntimeException("Unidentified Operator " + val);
        }
    }

}
