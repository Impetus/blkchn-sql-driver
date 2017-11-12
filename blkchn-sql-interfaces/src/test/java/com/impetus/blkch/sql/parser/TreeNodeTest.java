package com.impetus.blkch.sql.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeNodeTest {

	@Test
	public void testTreeNode() {
		TreeNode rootNode = new TreeNode("CEO");
		rootNode.setRootNode(true);
		TreeNode cfo = new TreeNode("CFO");
		TreeNode cto = new TreeNode("CTO");
		TreeNode arch1 = new TreeNode("ARCHITECT-1");
		TreeNode arch2 = new TreeNode("ARCHITECT-2");
		TreeNode lead1 = new TreeNode("LEAD-1");
		TreeNode lead2 = new TreeNode("LEAD-2");
		TreeNode dev1 = new TreeNode("DEV-1");
		TreeNode dev2 = new TreeNode("DEV-2");
		TreeNode dev3 = new TreeNode("DEV-3");
		TreeNode dev4 = new TreeNode("DEV-4");
		TreeNode dev5 = new TreeNode("DEV-5");
		
		rootNode.addChildNode(cfo);
		rootNode.addChildNode(cto);
		cto.addChildNode(arch1);
		cto.addChildNode(arch2);
		arch1.addChildNode(lead1);
		lead1.addChildNode(dev1);
		lead1.addChildNode(dev2);
		arch2.addChildNode(lead2);
		lead2.addChildNode(dev3);
		lead2.addChildNode(dev4);
		lead2.addChildNode(dev5);
		//rootNode.traverse(rootNode.getChildNode(1).getChildNode(1));
		rootNode.traverse();

	}

}
