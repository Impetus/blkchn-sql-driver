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

import com.impetus.blkch.sql.generated.SqlBaseLexer;
import com.impetus.blkch.sql.generated.SqlBaseParser;
import com.impetus.blkch.sql.query.LimitClause;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;

public class BlockchainVisitorTest {

    
	//String sql = "select transactionid as trans, blocknum from TRANSACTION t where trans=123 and t.blocknum < 5 GROUP "
	//+ "BY t.blocknum having blocknum > 2 order BY blockhash, transactionhash desc";
	
	@Test
    public void testSimpleSelect() {
        String sql = "select a, b from TRANSACTION t";
        LogicalPlan plan = getLogicalPlan(sql);
        assertNotNull(plan);
    }
	
	@Test
    public void testBlockchainVisitor() {
        String sql = "select count(sum(tt)) as cnt,transactionid as trans, t.blocknum from TRANSACTION t where trans=123 and t.blocknum < 5 or blockhash='sdf' or previousHash='2' GROUP BY t.blocknum having blocknum > 2"
                + " order BY blockhash, transactionhash desc limit 100";
        LogicalPlan plan = getLogicalPlan(sql);
        assertNotNull(plan);
    }

    public LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        SqlBaseParser parser = getParser(sqlText);
        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        logicalPlan.getQuery().traverse();
        SelectClause clause = logicalPlan.getQuery().getChildType(SelectClause.class, 0);
        return logicalPlan;
    }

    public SqlBaseParser getParser(String sqlText) {
        SqlBaseLexer lexer = new SqlBaseLexer(new CaseInsensitiveCharStream(sqlText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokens);
        return parser;
    }

}
