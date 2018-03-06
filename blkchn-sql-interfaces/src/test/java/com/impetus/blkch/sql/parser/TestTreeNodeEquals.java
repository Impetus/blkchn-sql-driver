package com.impetus.blkch.sql.parser;
import junit.framework.TestCase;

import org.junit.Test;

import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.GroupByClause;
import com.impetus.blkch.sql.query.HavingClause;
import com.impetus.blkch.sql.query.IdentifierNode;

public class TestTreeNodeEquals extends TestCase {

    @Test
    public void testFilterEqualsOverrrideTrue() {
        TreeNode havingClauseNode1 = new HavingClause();
        TreeNode havingClauseNode2 = new HavingClause();
        TreeNode filterItem1 = new FilterItem();
        TreeNode filterItem2 = new FilterItem();

        TreeNode column1 = new Column();
        TreeNode comparator1 = new Comparator(ComparisionOperator.EQ);
        TreeNode compIdent1 = new IdentifierNode("=");
        comparator1.addChildNode(compIdent1);
        TreeNode colIdent1 = new IdentifierNode("blocknumber");
        column1.addChildNode(colIdent1);
        TreeNode filItemIdent1 = new IdentifierNode("1234");
        filterItem1.addChildNode(column1);
        filterItem1.addChildNode(comparator1);
        filterItem1.addChildNode(filItemIdent1);
        havingClauseNode1.addChildNode(filterItem1);
        havingClauseNode1.traverse();

        TreeNode column2 = new Column();
        TreeNode comparator2 = new Comparator(ComparisionOperator.EQ);
        TreeNode compIdent2 = new IdentifierNode("=");
        comparator2.addChildNode(compIdent2);
        TreeNode colIdent2 = new IdentifierNode("blocknumber");
        column2.addChildNode(colIdent2);
        TreeNode filItemIdent2 = new IdentifierNode("1234");
        filterItem2.addChildNode(column2);
        filterItem2.addChildNode(comparator2);
        filterItem2.addChildNode(filItemIdent2);
        havingClauseNode2.addChildNode(filterItem2);
        havingClauseNode2.traverse();
        assertTrue(havingClauseNode1.equals(havingClauseNode2));
        assertTrue(havingClauseNode1.hashCode() == havingClauseNode2.hashCode());
        assertFalse(havingClauseNode1 == havingClauseNode2);

    }

    @Test
    public void testFilterEqualsOverrrideFalse() {
        TreeNode havingClauseNode1 = new HavingClause();
        TreeNode havingClauseNode2 = new HavingClause();
        TreeNode filterItem1 = new FilterItem();
        TreeNode filterItem2 = new FilterItem();

        TreeNode column1 = new Column();
        TreeNode comparator1 = new Comparator(ComparisionOperator.EQ);
        TreeNode compIdent1 = new IdentifierNode("=");
        comparator1.addChildNode(compIdent1);
        TreeNode colIdent1 = new IdentifierNode("blocknumber");
        column1.addChildNode(colIdent1);
        TreeNode filItemIdent1 = new IdentifierNode("1234");
        filterItem1.addChildNode(column1);
        filterItem1.addChildNode(comparator1);
        filterItem1.addChildNode(filItemIdent1);
        havingClauseNode1.addChildNode(filterItem1);
        havingClauseNode1.traverse();

        TreeNode column2 = new Column();
        TreeNode comparator2 = new Comparator(ComparisionOperator.EQ);
        TreeNode compIdent2 = new IdentifierNode("=");
        comparator2.addChildNode(compIdent2);
        TreeNode colIdent2 = new IdentifierNode("blocknumber");
        column2.addChildNode(colIdent2);
        TreeNode filItemIdent2 = new IdentifierNode("12");
        filterItem2.addChildNode(column2);
        filterItem2.addChildNode(comparator2);
        filterItem2.addChildNode(filItemIdent2);
        havingClauseNode2.addChildNode(filterItem2);
        havingClauseNode2.traverse();
        assertFalse(havingClauseNode1.equals(havingClauseNode2));
        assertFalse(havingClauseNode1.hashCode() == havingClauseNode2.hashCode());
        assertFalse(havingClauseNode1 == havingClauseNode2);

    }

    @Test
    public void testEqualsGroupByOverrideTrue() {
        TreeNode groupByClause1= new GroupByClause();
        TreeNode groupByClause2= new GroupByClause();
        TreeNode column11= new Column();
        TreeNode column12= new Column();
        TreeNode colIdent11=new IdentifierNode("blocknumber");
        TreeNode colIdent12=new IdentifierNode("blockhash");
        column11.addChildNode(colIdent11);
        column12.addChildNode(colIdent12);
        groupByClause1.addChildNode(column11);
        groupByClause1.addChildNode(column12);
        groupByClause1.traverse();
        
        TreeNode column21= new Column();
        TreeNode column22= new Column();
        TreeNode colIdent21=new IdentifierNode("blocknumber");
        TreeNode colIdent22=new IdentifierNode("blockhash");
        column21.addChildNode(colIdent21);
        column22.addChildNode(colIdent22);
        groupByClause2.addChildNode(column21);
        groupByClause2.addChildNode(column22);
        groupByClause2.traverse();
        assertTrue(groupByClause1.equals(groupByClause2));
        assertTrue(groupByClause1.hashCode() == groupByClause2.hashCode());
        assertFalse(groupByClause1 == groupByClause2);
        
    }
    

    @Test
    public void testEqualsGroupByOverrideFalse() {
        TreeNode groupByClause1= new GroupByClause();
        TreeNode groupByClause2= new GroupByClause();
        TreeNode column11= new Column();
        TreeNode column12= new Column();
        TreeNode colIdent11=new IdentifierNode("blocknumber");
        TreeNode colIdent12=new IdentifierNode("blockhash");
        column11.addChildNode(colIdent11);
        column12.addChildNode(colIdent12);
        groupByClause1.addChildNode(column11);
        groupByClause1.addChildNode(column12);
        groupByClause1.traverse();
        
        TreeNode column21= new Column();
        TreeNode column22= new Column();
        TreeNode colIdent21=new IdentifierNode("blocknumber");
        TreeNode colIdent22=new IdentifierNode("blockhash");
        column21.addChildNode(colIdent21);
        column22.addChildNode(colIdent22);
        groupByClause2.addChildNode(column22);
        groupByClause2.addChildNode(column21);
        groupByClause2.traverse();
        assertFalse(groupByClause1.equals(groupByClause2));
        assertFalse(groupByClause1.hashCode() == groupByClause2.hashCode());
        assertFalse(groupByClause1 == groupByClause2);
        
    }
}
