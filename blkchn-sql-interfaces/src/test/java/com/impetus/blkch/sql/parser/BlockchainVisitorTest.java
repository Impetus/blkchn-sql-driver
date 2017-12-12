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
package com.impetus.blkch.sql.parser;

import static org.junit.Assert.assertNotNull;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;
import com.impetus.blkch.sql.query.SelectClause;

public class BlockchainVisitorTest {

    @Test
    public void testBlockchainVisitor() {
        String sql = "select count(sum(tt)) as cnt,transactionid, t.blocknum from TRANSACTION where trans=123 and t.blocknum < 5 or blockhash='sdf' or previousHash='2' GROUP BY t.blocknum having blocknum > 2"
                + " order BY blockhash, transactionhash desc limit 100";
        LogicalPlan plan = getLogicalPlan(sql);
        assertNotNull(plan);
    }

    public LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        BlkchnSqlParser parser = getParser(sqlText);
        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        logicalPlan.getQuery().traverse();
        SelectClause clause = logicalPlan.getQuery().getChildType(SelectClause.class, 0);
        return logicalPlan;
    }

    public BlkchnSqlParser getParser(String sqlText) {
        BlkchnSqlLexer lexer = new BlkchnSqlLexer(new CaseInsensitiveCharStream(sqlText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlkchnSqlParser parser = new BlkchnSqlParser(tokens);
        return parser;
    }

}
