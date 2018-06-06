/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;

public class TreeNodeTest {

    TreeNode rootNode;

    @Before
    public void setUpTree() {
        rootNode = new TreeNode("CEO");
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
    }

    @Test
    public void testPrintTree() {
        assertNotNull(rootNode);
        rootNode.traverse();
    }

    @Test
    public void testGetChildNodes() {
        int count = rootNode.getChildNodes().size();
        assertEquals(2, count);
    }

    @Test
    public void testGetChildNode() {
        TreeNode childNode = rootNode.getChildNode(0);
        assertEquals("CFO", childNode.getDescription().trim());
    }

    @Test
    public void testIsRootNode() {
        assertTrue(rootNode.isRootNode());
        TreeNode childNode = rootNode.getChildNode(0);
        assertFalse(childNode.isRootNode());
    }

    @Test
    public void testGetParent() {
        TreeNode parentNode = rootNode.getChildNode(0).getParent();
        assertSame(parentNode, rootNode);
    }
    
    @Test
    public void testEqualsOverridingNull(){
    	assertFalse(rootNode.equals(null));
    }
    
    @Test
    public void testEqualsOverridingTrue1(){
    	TreeNode selectClause1 = new SelectClause();
    	TreeNode selectClause2 = new SelectClause();
    	assertTrue(selectClause1.equals(selectClause2));
    	assertTrue(selectClause1.hashCode() == selectClause2.hashCode());
    	assertFalse(selectClause1 == selectClause2);
    }
    
    @Test
    public void testEqualsOverridingTrue2(){
    	TreeNode selectClause1 = new SelectClause();
    	TreeNode selectClause2 = new SelectClause();
    	TreeNode selectItem1 = new SelectItem();
    	TreeNode selectItem2 = new SelectItem();
    	TreeNode column1 = new Column();
    	TreeNode column2 = new Column();
    	TreeNode ident1 = new IdentifierNode("a");
    	TreeNode ident2 = new IdentifierNode("a");
    	selectClause1.addChildNode(selectItem1);
    	selectItem1.addChildNode(column1);
    	column1.addChildNode(ident1);
    	column2.addChildNode(ident2);
    	selectClause2.addChildNode(selectItem2);
    	selectItem2.addChildNode(column2);
    	assertTrue(selectClause1.equals(selectClause2));
    	assertTrue(selectClause1.hashCode() == selectClause2.hashCode());
    	assertFalse(selectClause1 == selectClause2);
    }
    
    
    @Test
    public void testEqualsOverridingFalse1(){
    	TreeNode selectClause1 = new SelectClause();
    	TreeNode selectClause2 = new SelectClause();
    	TreeNode selectItem1 = new SelectItem();
    	TreeNode selectItem2 = new SelectItem();
    	TreeNode column1 = new Column();
    	TreeNode column2 = new Column();
    	TreeNode ident1 = new IdentifierNode("a");
    	TreeNode ident2 = new IdentifierNode("b");
    	selectClause1.addChildNode(selectItem1);
    	selectItem1.addChildNode(column1);
    	column1.addChildNode(ident1);
    	column2.addChildNode(ident2);
    	selectClause2.addChildNode(selectItem2);
    	selectItem2.addChildNode(column2);
    	assertFalse(selectClause1.equals(selectClause2));
    	assertFalse(selectClause1.hashCode() == selectClause2.hashCode());
    	assertFalse(selectClause1 == selectClause2);
    }
    
    @Test
    public void testEqualsOverridingFalse2(){
    TreeNode selectClause1 = new SelectClause();
    TreeNode selectClause2 = new SelectClause();
    TreeNode selectItem1 = new SelectItem();
    TreeNode selectItem2 = new SelectItem();
    TreeNode column1 = new Column();
    TreeNode column2 = new Column();
    TreeNode ident1 = new IdentifierNode("a");
    TreeNode ident2 = new IdentifierNode("a");
    selectClause1.addChildNode(selectItem1);
    selectItem1.addChildNode(column1);
    column1.addChildNode(ident1);
    
    //swapped levels of child nodes
    selectClause2.addChildNode(column2);
    column2.addChildNode(selectItem2);
    selectItem2.addChildNode(ident2);
    
    assertFalse(selectClause1.equals(selectClause2));
    assertFalse(selectClause1.hashCode() == selectClause2.hashCode());
    assertFalse(selectClause1 == selectClause2);
    }
    
    @Test
    public void testEqualsOverridingTrue(){
    	TreeNode otherRootNode = new TreeNode("CEO");
    	otherRootNode.setRootNode(true);
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

        otherRootNode.addChildNode(cfo);
        otherRootNode.addChildNode(cto);
        cto.addChildNode(arch1);
        cto.addChildNode(arch2);
        arch1.addChildNode(lead1);
        lead1.addChildNode(dev1);
        lead1.addChildNode(dev2);
        arch2.addChildNode(lead2);
        lead2.addChildNode(dev3);
        lead2.addChildNode(dev4);
        lead2.addChildNode(dev5);
        assertTrue(rootNode.equals(otherRootNode));
    }
}
