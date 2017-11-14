package com.impetus.blkch.sql.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.impetus.blkch.sql.parser.LogicalPlan;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.Table;

public class LogicalPlanTest {

	LogicalPlan logicalPlan;
	
	@Before
	public void setUp() {
		logicalPlan = new LogicalPlan("TEST PLAN");
		Query query = new Query();
		query.setRootNode(true);
		SelectItem selectItem = new SelectItem();
		query.addChildNode(selectItem);
		logicalPlan.setQuery(query);
		logicalPlan.setCurrentNode(query);
	}
	
	@Test
	public void testLogicalPLan() {
		FromItem fromItem = new FromItem();
		logicalPlan.getCurrentNode().addChildNode(fromItem);
		assertEquals(2, logicalPlan.getCurrentNode().getChildNodes().size());
		logicalPlan.setCurrentNode(fromItem);
		Table table = new Table("table1");
		logicalPlan.getCurrentNode().addChildNode(table);
		logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent().getChildNode(0));
		Column col1 = new Column("column1");
		Column col2 = new Column("column2");
		logicalPlan.getCurrentNode().addChildNode(col1);
		logicalPlan.getCurrentNode().addChildNode(col2);
		logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
		printQuery(logicalPlan.getCurrentNode());
		assertEquals(logicalPlan.getCurrentNode().getDescription(), Query.DESCRIPTION);
		assertEquals(logicalPlan.getCurrentNode().getChildNode(0).getDescription(), SelectItem.DESCRIPTION);
		assertEquals(logicalPlan.getCurrentNode().getChildNode(1).getDescription(), FromItem.DESCRIPTION);
		assertEquals(logicalPlan.getCurrentNode().getChildNode(0).getChildNode(0).getDescription(), Column.DESCRIPTION + ":" + "column1");
		assertEquals(logicalPlan.getCurrentNode().getChildNode(0).getChildNode(1).getDescription(), Column.DESCRIPTION + ":" + "column2");
		assertEquals(logicalPlan.getCurrentNode().getChildNode(1).getDescription(), FromItem.DESCRIPTION);
		assertEquals(logicalPlan.getCurrentNode().getChildNode(1).getChildNode(0).getDescription(), Table.DESCRIPTION + ":" + "table1");
	}
	
	private void printQuery(TreeNode rootNode) {
		rootNode.traverse();
	}
	
	

}
