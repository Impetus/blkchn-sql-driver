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
import junit.framework.TestCase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import com.impetus.blkch.sql.generated.SqlBaseLexer;
import com.impetus.blkch.sql.generated.SqlBaseParser;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.Table;

public class LogicalPlanTest extends TestCase {

	@Test
    public void testSimpleSelect() {
        String sql = "select a, b from TRANSACTION t";
        LogicalPlan plan = getLogicalPlan(sql);
        
        LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");
        Query query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        TreeNode selectClause1 = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause1);
        TreeNode selectItem1 = new SelectItem();
    	selectClause1.addChildNode(selectItem1);
    	TreeNode column1 = new Column();
    	selectItem1.addChildNode(column1);
    	TreeNode ident1 = new IdentifierNode("a");
    	column1.addChildNode(ident1);
    	TreeNode selectItem2 = new SelectItem();
    	selectClause1.addChildNode(selectItem2);
    	TreeNode column2 = new Column();
    	selectItem2.addChildNode(column2);
    	TreeNode ident2 = new IdentifierNode("b");
    	column2.addChildNode(ident2);
    	
    	TreeNode fromItem = new FromItem();
    	logicalPlan.getCurrentNode().addChildNode(fromItem);
    	TreeNode table = new Table();
    	fromItem.addChildNode(table);
    	TreeNode ident3 = new IdentifierNode("t");
    	fromItem.addChildNode(ident3);
    	TreeNode ident4 = new IdentifierNode("TRANSACTION");
        table.addChildNode(ident4);
        logicalPlan.getQuery().traverse();
        plan.getQuery().traverse();
        assertTrue(logicalPlan.equals(plan));
    }
	

    public LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        SqlBaseParser parser = getParser(sqlText);
        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        return logicalPlan;
    }

    public SqlBaseParser getParser(String sqlText) {
        SqlBaseLexer lexer = new SqlBaseLexer(new CaseInsensitiveCharStream(sqlText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokens);
        return parser;
    }
    

}
