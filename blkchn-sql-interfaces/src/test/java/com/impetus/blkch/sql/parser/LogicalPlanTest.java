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

import com.impetus.blkch.BlkchnErrorListener;
import com.impetus.blkch.BlkchnException;

import junit.framework.TestCase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.impetus.blkch.sql.asset.Asset;
import com.impetus.blkch.sql.asset.ColumnType;
import com.impetus.blkch.sql.asset.ColumnTypeList;
import com.impetus.blkch.sql.asset.CreateAsset;
import com.impetus.blkch.sql.asset.DropAsset;
import com.impetus.blkch.sql.asset.FieldDelimiter;
import com.impetus.blkch.sql.asset.RecordDelimiter;
import com.impetus.blkch.sql.asset.StorageType;
import com.impetus.blkch.sql.function.Args;
import com.impetus.blkch.sql.function.CallFunction;
import com.impetus.blkch.sql.function.ClassName;
import com.impetus.blkch.sql.function.CreateFunction;
import com.impetus.blkch.sql.function.DeleteFunction;
import com.impetus.blkch.sql.function.Endorsers;
import com.impetus.blkch.sql.function.Parameters;
import com.impetus.blkch.sql.function.PolicyFile;
import com.impetus.blkch.sql.function.Version;
import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;
import com.impetus.blkch.sql.insert.ColumnValue;
import com.impetus.blkch.sql.insert.Insert;
import com.impetus.blkch.sql.query.BytesArgs;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.GroupByClause;
import com.impetus.blkch.sql.query.HavingClause;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LimitClause;
import com.impetus.blkch.sql.query.ListAgrs;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.OrderByClause;
import com.impetus.blkch.sql.query.OrderItem;
import com.impetus.blkch.sql.query.OrderingDirection;
import com.impetus.blkch.sql.query.OrderingDirection.Direction;
import com.impetus.blkch.sql.smartcontract.SmartCnrtDeploy;
import com.impetus.blkch.sql.query.Placeholder;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.query.WhereClause;

import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class LogicalPlanTest extends TestCase {
    @Test
    public void testSimpleSelect() {
        String sql = "select a, b from TRANSACTION t";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildSimpleSelect();
        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testPlaceHolder() {
        String sql = "select count(*) as cnt, blocknumber from transaction where blocknumber = ? group by blocknumber";
        LogicalPlan plan = getLogicalPlan(sql);
        plan.getQuery().traverse();
        TreeNode node = plan.getQuery().getChildType(WhereClause.class, 0).getChildType(FilterItem.class, 0);

        assertTrue(node.hasChildType(Placeholder.class));
    }

    @Test
    public void testSimpleSelectWithWhereClause() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world'";
        LogicalPlan plan = getLogicalPlan(sql);
        LogicalPlan logicalPlan = buildSelectWithWhere();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSimpleSelectWithWhereClauseAndGroupBy() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world' group by c";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildSelectWithGroupBy();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithHaving() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world' group by c having b > 100";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildHaving();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithHavingAndOrderBy() {
        String sql = "select a, b from TRANSACTION t where a = 'hello world' group by c having b > 100 order by b desc";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildOrderByClause();

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithHavingOrderByAndLimit() {
        String sql =
            "select a, b from TRANSACTION t where a = 'hello world' group by c having b > 100 order by b desc limit 10";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = buildOrderByClause();
        TreeNode limit = new LimitClause();
        logicalPlan.getCurrentNode().addChildNode(limit);
        TreeNode ident = new IdentifierNode("10");
        limit.addChildNode(ident);

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testSelectWithWhereClouse() {
        String sql = "select a, b from TRANSACTION t where a = 10";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = new LogicalPlan("BlockChainVisitor");
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

        TreeNode whereItem = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereItem);
        TreeNode filterItem = new FilterItem();
        whereItem.addChildNode(filterItem);
        TreeNode col3 = new Column();
        TreeNode ident5 = new IdentifierNode("a");
        col3.addChildNode(ident5);
        filterItem.addChildNode(col3);

        TreeNode comprator = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident6 = new IdentifierNode("=");
        comprator.addChildNode(ident6);
        filterItem.addChildNode(comprator);

        TreeNode ident7 = new IdentifierNode("10");
        filterItem.addChildNode(ident7);

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testDeploySmartContract() {
        String sql = "DEPLOY smartcontract 'com.impetus.blkchn.eth.FirstSmartContract'()";
        LogicalPlan plan = getLogicalPlan(sql);
        SmartCnrtDeploy actual = plan.getSmartCnrtDeploy();
        SmartCnrtDeploy expected = new SmartCnrtDeploy();
        expected.addChildNode(new ClassName("'com.impetus.blkchn.eth.FirstSmartContract'"));
        assertEquals(expected, actual);
    }

    @Test
    public void testDeploySmartContractParameters() {
        String sql =
            "DEPLOY smartcontract 'com.impetus.blkchn.eth.FirstSmartContract'('xyz','qwerty',500,[1,2,3],HEX('0x123'))";
        LogicalPlan plan = getLogicalPlan(sql);
        SmartCnrtDeploy actual = plan.getSmartCnrtDeploy();
        SmartCnrtDeploy expected = new SmartCnrtDeploy();
        expected.addChildNode(new ClassName("'com.impetus.blkchn.eth.FirstSmartContract'"));
        Parameters parameters = new Parameters();
        parameters.addChildNode(new IdentifierNode("'xyz'"));
        parameters.addChildNode(new IdentifierNode("'qwerty'"));
        parameters.addChildNode(new IdentifierNode("500"));
        ListAgrs lstArgs = new ListAgrs();
        Parameters lstParameters = new Parameters();
        lstParameters.addChildNode(new IdentifierNode("1"));
        lstParameters.addChildNode(new IdentifierNode("2"));
        lstParameters.addChildNode(new IdentifierNode("3"));
        lstArgs.addChildNode(lstParameters);
        BytesArgs byt = new BytesArgs("HEX('0x123')");
        parameters.addChildNode(lstArgs);
        parameters.addChildNode(byt);
        expected.addChildNode(parameters);
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectWithWhereAndLogicalOperatorClouse() {
        String sql = "select a, b from TRANSACTION t where a = 10 AND b = 5";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = new LogicalPlan("BlockChainVisitor");
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

        TreeNode whereItem = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereItem);

        TreeNode logicalOper = new LogicalOperation(LogicalOperation.Operator.AND);
        whereItem.addChildNode(logicalOper);

        TreeNode filterItem = new FilterItem();
        logicalOper.addChildNode(filterItem);

        TreeNode col3 = new Column();
        TreeNode ident5 = new IdentifierNode("a");
        col3.addChildNode(ident5);
        filterItem.addChildNode(col3);

        TreeNode comprator = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident6 = new IdentifierNode("=");
        comprator.addChildNode(ident6);
        filterItem.addChildNode(comprator);

        TreeNode ident7 = new IdentifierNode("10");
        filterItem.addChildNode(ident7);

        TreeNode filterItem2 = new FilterItem();
        logicalOper.addChildNode(filterItem2);

        TreeNode col4 = new Column();
        TreeNode ident8 = new IdentifierNode("b");
        col4.addChildNode(ident8);
        filterItem2.addChildNode(col4);

        TreeNode comprator2 = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident9 = new IdentifierNode("=");
        comprator2.addChildNode(ident9);
        filterItem2.addChildNode(comprator2);

        TreeNode ident10 = new IdentifierNode("5");
        filterItem2.addChildNode(ident10);

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testCreateFunction() {
        String sql =
            "Create Function someFunction AS '/home/xyz' WITH VERSION '1.0' WITH ENDORSEMENT POLICY FILE '/home/username/fileloc' "
                + "WITH ARGS 'init', 500, 230";
        LogicalPlan plan = getLogicalPlan(sql);
        CreateFunction actual = plan.getCreateFunction();
        CreateFunction expected = buildCreateFunction();
        assertEquals(expected, actual);
    }

    @Test
    public void testCallFunction() {
        String sql = "CALL someFunc('xyz', 'abc', 300)";
        LogicalPlan plan = getLogicalPlan(sql);
        CallFunction actual = plan.getCallFunction();
        CallFunction expected = buildCallFunction();
        assertEquals(expected, actual);
    }

    @Test
    public void testInsert() {
        String sql = "INSERT INTO someTable VALUES('first', 'second', 'third', 4, false)";
        LogicalPlan plan = getLogicalPlan(sql);
        Insert actual = plan.getInsert();
        Insert expected = buildInsert();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectWithWhereAndLimitClouse() {
        String sql = "select a, b from TRANSACTION t where a = 10 limit 3";
        LogicalPlan plan = getLogicalPlan(sql);

        LogicalPlan logicalPlan = new LogicalPlan("BlockChainVisitor");
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

        TreeNode whereItem = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereItem);
        TreeNode filterItem = new FilterItem();
        whereItem.addChildNode(filterItem);
        TreeNode col3 = new Column();
        TreeNode ident5 = new IdentifierNode("a");
        col3.addChildNode(ident5);
        filterItem.addChildNode(col3);

        TreeNode comprator = new Comparator(Comparator.ComparisionOperator.EQ);
        TreeNode ident6 = new IdentifierNode("=");
        comprator.addChildNode(ident6);
        filterItem.addChildNode(comprator);

        TreeNode ident7 = new IdentifierNode("10");
        filterItem.addChildNode(ident7);

        TreeNode limitClause = new LimitClause();
        limitClause.addChildNode(new IdentifierNode("3"));
        logicalPlan.getCurrentNode().addChildNode(limitClause);

        assertTrue(logicalPlan.getQuery().equals(plan.getQuery()));
    }

    @Test
    public void testCreateAssetWithJSONStorage() {
        String sql = "CREATE ASSET user_asset" + " WITH STORAGE TYPE JSON";
        LogicalPlan plan = getLogicalPlan(sql);
        CreateAsset actual = plan.getCreateAsset();
        CreateAsset expected = buildCreateAssetJSON();
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateAssetWithCSVStorage() {
        String sql = "CREATE ASSET user_asset (" + "id int," + "name string," + "designation string" + ")"
            + " WITH STORAGE TYPE CSV " + "FIELDS DELIMITED BY ',' " + "RECORDS DELIMITED BY \"\\n\"";
        LogicalPlan plan = getLogicalPlan(sql);
        CreateAsset actual = plan.getCreateAsset();
        CreateAsset expected = buildCreateAssetCSV();
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteFunction() {
        String sql = "DELETE chaincod('deleteFunc', 'USER', 1001)";
        LogicalPlan plan = getLogicalPlan(sql);
        DeleteFunction actual = plan.getDeleteFunction();
        DeleteFunction expected = buildDeleteFunction();
        assertEquals(expected, actual);
    }

    @Test
    public void testDropAsset() {
        String sql = "DROP ASSET assetchain";
        LogicalPlan plan = getLogicalPlan(sql);
        DropAsset actual = plan.getDropAsset();
        DropAsset expected = buildDropAsset();
        assertEquals(expected, actual);
    }

    @Test(expected = BlkchnException.class)
    public void testWrongQuery() {
        String sql = "select * from block blk where blockNo = 2 And blockNo>=2 blockNo <=300";
        LogicalPlan plan = getLogicalPlan(sql);
    }

    private LogicalPlan buildOrderByClause() {
        LogicalPlan logicalPlan = buildHaving();
        TreeNode orderByClause = new OrderByClause();
        logicalPlan.getCurrentNode().addChildNode(orderByClause);
        TreeNode orderItem = new OrderItem();
        orderByClause.addChildNode(orderItem);
        TreeNode orderDir = new OrderingDirection(Direction.DESC);
        orderItem.addChildNode(orderDir);
        TreeNode column = new Column();
        orderItem.addChildNode(column);
        TreeNode ident = new IdentifierNode("b");
        column.addChildNode(ident);
        return logicalPlan;
    }

    private LogicalPlan buildHaving() {
        LogicalPlan logicalPlan = buildSelectWithGroupBy();

        TreeNode havingClause = new HavingClause();
        logicalPlan.getCurrentNode().addChildNode(havingClause);
        TreeNode filterItem = new FilterItem();
        havingClause.addChildNode(filterItem);
        TreeNode column3 = new Column();
        filterItem.addChildNode(column3);
        TreeNode ident5 = new IdentifierNode("b");
        column3.addChildNode(ident5);
        TreeNode comparator = new Comparator(ComparisionOperator.GT);
        filterItem.addChildNode(comparator);
        TreeNode ident6 = new IdentifierNode(">");
        comparator.addChildNode(ident6);
        TreeNode ident7 = new IdentifierNode("100");
        filterItem.addChildNode(ident7);
        return logicalPlan;
    }

    private LogicalPlan buildSelectWithGroupBy() {
        LogicalPlan logicalPlan = buildSelectWithWhere();

        TreeNode groupBy = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupBy);
        TreeNode column1 = new Column();
        groupBy.addChildNode(column1);
        TreeNode ident1 = new IdentifierNode("c");
        column1.addChildNode(ident1);
        return logicalPlan;
    }

    public static LogicalPlan buildSimpleSelect() {
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
        return logicalPlan;
    }

    public static LogicalPlan buildSelectWithWhere() {
        LogicalPlan logicalPlan = buildSimpleSelect();

        TreeNode whereClause = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereClause);
        TreeNode filterItem = new FilterItem();
        whereClause.addChildNode(filterItem);
        TreeNode column3 = new Column();
        filterItem.addChildNode(column3);
        TreeNode ident5 = new IdentifierNode("a");
        column3.addChildNode(ident5);
        TreeNode comparator = new Comparator(ComparisionOperator.EQ);
        filterItem.addChildNode(comparator);
        TreeNode ident6 = new IdentifierNode("=");
        comparator.addChildNode(ident6);
        TreeNode ident7 = new IdentifierNode("'hello world'");
        filterItem.addChildNode(ident7);
        return logicalPlan;
    }

    private CreateFunction buildCreateFunction() {
        CreateFunction createFunction = new CreateFunction();
        createFunction.addChildNode(new IdentifierNode("someFunction"));
        createFunction.addChildNode(new ClassName("'/home/xyz'"));
        createFunction.addChildNode(new Version("'1.0'"));
        Endorsers endorsers = new Endorsers();
        PolicyFile policy = new PolicyFile("'/home/username/fileloc'");
        endorsers.addChildNode(policy);
        createFunction.addChildNode(endorsers);
        Args args = new Args();
        args.addChildNode(new IdentifierNode("'init'"));
        args.addChildNode(new IdentifierNode("500"));
        args.addChildNode(new IdentifierNode("230"));
        createFunction.addChildNode(args);
        return createFunction;
    }

    private CallFunction buildCallFunction() {
        CallFunction callFunction = new CallFunction();
        callFunction.addChildNode(new IdentifierNode("someFunc"));
        Parameters parameters = new Parameters();
        parameters.addChildNode(new IdentifierNode("'xyz'"));
        parameters.addChildNode(new IdentifierNode("'abc'"));
        parameters.addChildNode(new IdentifierNode("300"));
        callFunction.addChildNode(parameters);
        return callFunction;
    }

    public static Insert buildInsert() {
        Insert insert = new Insert();
        Table table = new Table();
        table.addChildNode(new IdentifierNode("someTable"));
        insert.addChildNode(table);
        ColumnValue columnValue = new ColumnValue();
        columnValue.addChildNode(new IdentifierNode("'first'"));
        columnValue.addChildNode(new IdentifierNode("'second'"));
        columnValue.addChildNode(new IdentifierNode("'third'"));
        columnValue.addChildNode(new IdentifierNode("4"));
        columnValue.addChildNode(new IdentifierNode("false"));
        insert.addChildNode(columnValue);
        return insert;
    }

    private CreateAsset buildCreateAssetJSON() {
        CreateAsset createAsset = new CreateAsset();
        Asset asset = new Asset();
        asset.addChildNode(new IdentifierNode("user_asset"));
        createAsset.addChildNode(asset);
        StorageType storageType = new StorageType();
        storageType.addChildNode(new IdentifierNode("JSON"));
        createAsset.addChildNode(storageType);
        return createAsset;
    }

    private CreateAsset buildCreateAssetCSV() {
        CreateAsset createAsset = new CreateAsset();
        Asset asset = new Asset();
        asset.addChildNode(new IdentifierNode("user_asset"));
        createAsset.addChildNode(asset);
        ColumnTypeList columnTypeList = new ColumnTypeList();
        ColumnType columnType1 = new ColumnType();
        columnType1.addChildNode(new IdentifierNode("id"));
        columnType1.addChildNode(new IdentifierNode("int"));
        columnTypeList.addChildNode(columnType1);
        ColumnType columnType2 = new ColumnType();
        columnType2.addChildNode(new IdentifierNode("name"));
        columnType2.addChildNode(new IdentifierNode("string"));
        columnTypeList.addChildNode(columnType2);
        ColumnType columnType3 = new ColumnType();
        columnType3.addChildNode(new IdentifierNode("designation"));
        columnType3.addChildNode(new IdentifierNode("string"));
        columnTypeList.addChildNode(columnType3);
        createAsset.addChildNode(columnTypeList);
        StorageType storageType = new StorageType();
        storageType.addChildNode(new IdentifierNode("CSV"));
        createAsset.addChildNode(storageType);
        FieldDelimiter fieldDelimiter = new FieldDelimiter();
        fieldDelimiter.addChildNode(new IdentifierNode(","));
        createAsset.addChildNode(fieldDelimiter);
        RecordDelimiter recordDelimiter = new RecordDelimiter();
        recordDelimiter.addChildNode(new IdentifierNode("\\n"));
        createAsset.addChildNode(recordDelimiter);
        return createAsset;
    }

    private DeleteFunction buildDeleteFunction() {
        DeleteFunction deleteFunction = new DeleteFunction();
        deleteFunction.addChildNode(new IdentifierNode("chaincod"));
        Parameters parameters = new Parameters();
        parameters.addChildNode(new IdentifierNode("'deleteFunc'"));
        parameters.addChildNode(new IdentifierNode("'USER'"));
        parameters.addChildNode(new IdentifierNode("1001"));
        deleteFunction.addChildNode(parameters);
        return deleteFunction;
    }

    private DropAsset buildDropAsset() {
        DropAsset dropAsset = new DropAsset();
        Asset asset = new Asset();
        asset.addChildNode(new IdentifierNode("assetchain"));
        dropAsset.addChildNode(asset);
        return dropAsset;
    }

    public LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        BlkchnSqlParser parser = getParser(sqlText);

        parser.removeErrorListeners();
        parser.addErrorListener(BlkchnErrorListener.INSTANCE);

        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        return logicalPlan;
    }

    public BlkchnSqlParser getParser(String sqlText) {
        BlkchnSqlLexer lexer = new BlkchnSqlLexer(new CaseInsensitiveCharStream(sqlText));

        lexer.removeErrorListeners();
        lexer.addErrorListener(BlkchnErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlkchnSqlParser parser = new BlkchnSqlParser(tokens);
        return parser;
    }

}
