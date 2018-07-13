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

import org.antlr.v4.runtime.tree.RuleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.impetus.blkch.sql.function.UpgradeFunction;
import com.impetus.blkch.sql.function.Version;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.AddressVlaueContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArgsContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.AssetContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.AsyncOptionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.BooleanLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.BytesContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CallFunctionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ClassOptionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColTypeListContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColumnNamesContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColumnReferenceContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColumnValuesContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComparisonContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComparisonOperatorContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CreateAssetContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DeleteFunctionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DeploySmartContractRuleContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DereferenceContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DropAssetContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.EndorsersFileContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FieldDelimiterContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FromClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FunctionCallContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.GroupByClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.HavingClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LimitClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ListContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ListTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LogicalBinaryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NamedExpressionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NumericLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.OrderByClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ParameterValuesContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.PolicyFileContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.RecordDelimiterContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SelectClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SetQuantifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SimpleQueryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SingleInsertContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SmartFunctionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SortItemContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StarContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StorageTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StringLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.TableIdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.UnquotedIdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.UpgradeFunctionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.VersionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.WhereClauseContext;
import com.impetus.blkch.sql.insert.*;
import com.impetus.blkch.sql.parser.LogicalPlan.SQLType;
import com.impetus.blkch.sql.query.*;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.IdentifierNode.IdentType;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.OrderingDirection.Direction;
import com.impetus.blkch.sql.query.QuantifierNode.Quantifier;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.smartcontract.*;

public class BlockchainVisitor extends AbstractSyntaxTreeVisitor {

    private static final Logger logger = LoggerFactory.getLogger(BlockchainVisitor.class);

    LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");

    Query query;
    CreateFunction crtFunction;
    ClassName className;
    Insert insert;
    CallFunction callFunction;
    CreateAsset createAsset;
    DeleteFunction deleteFunction;
    DropAsset dropAsset;
    UpgradeFunction upgradeFunction;
    SmartContractFunction smartContractFunction;
    SmartCnrtDeploy smartCnrtDeploy;

    @Override
    public LogicalPlan visitSimpleQuery(SimpleQueryContext ctx) {
        logger.trace("In visitSimpleQuery " + ctx.getText());
        query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        logicalPlan.setType(SQLType.QUERY);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitSingleInsert(SingleInsertContext ctx) {
        logger.trace("In visitSingleInsert " + ctx.getText());
        insert = new Insert();
        logicalPlan.setInsert(insert);
        logicalPlan.setCurrentNode(insert);
        logicalPlan.setType(SQLType.INSERT);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitCreateFunctionRule(BlkchnSqlParser.CreateFunctionRuleContext ctx) {
        logger.trace("In visitCreateFunctionRule " + ctx.getText());
        crtFunction = new CreateFunction();
        logicalPlan.setCreateFunction(crtFunction);
        logicalPlan.setCurrentNode(crtFunction);
        logicalPlan.setType(SQLType.CREATE_FUNCTION);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitCallFunction(CallFunctionContext ctx) {
        logger.trace("In visitCallFunction " + ctx.getText());
        callFunction = new CallFunction();
        logicalPlan.setCallFunction(callFunction);
        logicalPlan.setCurrentNode(callFunction);
        logicalPlan.setType(SQLType.CALL_FUNCTION);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitClassName(BlkchnSqlParser.ClassNameContext ctx) {
        logger.trace("In visitClassName " + ctx.getText());
        className = new ClassName(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(className);
        logicalPlan.setCurrentNode(className);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitSelectClause(SelectClauseContext ctx) {
        logger.trace("In visitSelectClause " + ctx.getText());
        TreeNode selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);
        logicalPlan.setCurrentNode(selectClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitFromClause(FromClauseContext ctx) {
        logger.trace("In visitFromClause " + ctx.getText());
        TreeNode fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        logicalPlan.setCurrentNode(fromItem);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitWhereClause(WhereClauseContext ctx) {
        logger.trace("In visitWhereClause " + ctx.getText());
        TreeNode whereClause = new WhereClause();
        logicalPlan.getCurrentNode().addChildNode(whereClause);
        logicalPlan.setCurrentNode(whereClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitGroupByClause(GroupByClauseContext ctx) {
        logger.trace("In visitGroupByClause " + ctx.getText());
        TreeNode groupByClause = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupByClause);
        logicalPlan.setCurrentNode(groupByClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitHavingClause(HavingClauseContext ctx) {
        logger.trace("In visitHavingClause " + ctx.getText());
        TreeNode havingClause = new HavingClause();
        logicalPlan.getCurrentNode().addChildNode(havingClause);
        logicalPlan.setCurrentNode(havingClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitOrderByClause(OrderByClauseContext ctx) {
        logger.trace("In visitOrderByClause " + ctx.getText());
        TreeNode orderByClause = new OrderByClause();
        logicalPlan.getCurrentNode().addChildNode(orderByClause);
        logicalPlan.setCurrentNode(orderByClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitLimitClause(LimitClauseContext ctx) {
        logger.trace("In visitLimitClause " + ctx.getText());
        TreeNode limitClause = new LimitClause();
        logicalPlan.getCurrentNode().addChildNode(limitClause);
        logicalPlan.setCurrentNode(limitClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitNamedExpression(NamedExpressionContext ctx) {
        logger.trace("In visitNamedExpression " + ctx.getText());
        if (logicalPlan.getCurrentNode() instanceof SelectClause) {
            TreeNode selectItem = new SelectItem();
            logicalPlan.getCurrentNode().addChildNode(selectItem);
            logicalPlan.setCurrentNode(selectItem);
            return visitChildrenAndResetNode(ctx);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LogicalPlan visitColumnReference(ColumnReferenceContext ctx) {
        logger.trace("In visitColumnReference " + ctx.getText());
        TreeNode column = new Column();
        logicalPlan.getCurrentNode().addChildNode(column);
        logicalPlan.setCurrentNode(column);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitStar(StarContext ctx) {
        logger.trace("In visitStar " + ctx.getText());
        if (ctx.qualifiedName() != null) {
            logicalPlan.getCurrentNode().addChildNode(new StarNode(ctx.qualifiedName().getText()));
        } else {
            logicalPlan.getCurrentNode().addChildNode(new StarNode());
        }
        return defaultResult();
    }

    @Override
    public LogicalPlan visitFunctionCall(FunctionCallContext ctx) {
        logger.trace("In visitFunctionCall " + ctx.getText());
        TreeNode functionNode = new FunctionNode();
        logicalPlan.getCurrentNode().addChildNode(functionNode);
        logicalPlan.setCurrentNode(functionNode);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitSetQuantifier(SetQuantifierContext ctx) {
        logger.trace("In visitSetQuantifier " + ctx.getText());
        if (ctx.DISTINCT() != null) {
            logicalPlan.getCurrentNode().addChildNode(new QuantifierNode(Quantifier.DISTINCT));
        } else {
            logicalPlan.getCurrentNode().addChildNode(new QuantifierNode(Quantifier.ALL));
        }
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitUnquotedIdentifier(UnquotedIdentifierContext ctx) {
        logger.trace("In visitUnquotedIdentifier " + ctx.getText());
        TreeNode node = new IdentifierNode(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(node);
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitTableIdentifier(TableIdentifierContext ctx) {
        logger.trace("In visitTableIdentifier " + ctx.getText());
        TreeNode table = new Table();
        logicalPlan.getCurrentNode().addChildNode(table);
        logicalPlan.setCurrentNode(table);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitDereference(DereferenceContext ctx) {
        logger.trace("In visitDereference " + ctx.getText());
        TreeNode node = new DereferenceNode();
        logicalPlan.getCurrentNode().addChildNode(node);
        logicalPlan.setCurrentNode(node);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitLogicalBinary(LogicalBinaryContext ctx) {
        logger.trace("In visitLogicalBinary " + ctx.getText());
        if (ctx.AND() != null) {
            TreeNode andNode = new LogicalOperation(Operator.AND);
            logicalPlan.getCurrentNode().addChildNode(andNode);
            logicalPlan.setCurrentNode(andNode);
        } else if (ctx.OR() != null) {
            TreeNode orNode = new LogicalOperation(Operator.OR);
            logicalPlan.getCurrentNode().addChildNode(orNode);
            logicalPlan.setCurrentNode(orNode);
        }
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitComparison(ComparisonContext ctx) {
        logger.trace("In visitComparison " + ctx.getText());
        TreeNode filterItem = new FilterItem();
        logicalPlan.getCurrentNode().addChildNode(filterItem);
        logicalPlan.setCurrentNode(filterItem);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitComparisonOperator(ComparisonOperatorContext ctx) {
        logger.trace("In visitComparisonOperator " + ctx.getText());
        TreeNode node = new Comparator(ComparisionOperator.getOp(ctx.getText().trim()));
        node.addChildNode(new IdentifierNode(ctx.getText()));
        logicalPlan.getCurrentNode().addChildNode(node);
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitNumericLiteral(NumericLiteralContext ctx) {
        logger.trace("In visitNumericLiteral " + ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(new IdentifierNode(ctx.getText(), IdentType.NUMBER));
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitStringLiteral(StringLiteralContext ctx) {
        logger.trace("In visitStringLiteral " + ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(new IdentifierNode(ctx.getText(), IdentType.STRING));
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitBooleanLiteral(BooleanLiteralContext ctx) {
        logger.trace("In visitBooleanLiteral " + ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(new IdentifierNode(ctx.getText(), IdentType.BOOLEAN));
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitSortItem(SortItemContext ctx) {
        logger.trace("In visitSortItem " + ctx.getText());
        TreeNode orderItem = new OrderItem();
        logicalPlan.getCurrentNode().addChildNode(orderItem);
        logicalPlan.setCurrentNode(orderItem);
        if (ctx.DESC() != null) {
            logicalPlan.getCurrentNode().addChildNode(new OrderingDirection(Direction.DESC));
        } else {
            logicalPlan.getCurrentNode().addChildNode(new OrderingDirection(Direction.ASC));
        }
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitVersion(VersionContext ctx) {
        logger.trace("In visitVersion " + ctx.getText());
        Version version = new Version(ctx.STRING().getText());
        logicalPlan.getCurrentNode().addChildNode(version);
        logicalPlan.setCurrentNode(version);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitEndorsersFile(EndorsersFileContext ctx) {
        logger.trace("In visitEndorsersFile " + ctx.getText());
        Endorsers endorsers = new Endorsers();
        logicalPlan.getCurrentNode().addChildNode(endorsers);
        logicalPlan.setCurrentNode(endorsers);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitPolicyFile(PolicyFileContext ctx) {
        logger.trace("In visitPolicyFile " + ctx.getText());
        PolicyFile policyFile = new PolicyFile(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(policyFile);
        logicalPlan.setCurrentNode(policyFile);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitArgs(ArgsContext ctx) {
        logger.trace("In visitArgs " + ctx.getText());
        Args args = new Args();
        logicalPlan.getCurrentNode().addChildNode(args);
        logicalPlan.setCurrentNode(args);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitColumnNames(ColumnNamesContext ctx) {
        logger.trace("In visitColumnNames " + ctx.getText());
        ColumnName columnName = new ColumnName();
        logicalPlan.getCurrentNode().addChildNode(columnName);
        logicalPlan.setCurrentNode(columnName);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitColumnValues(ColumnValuesContext ctx) {
        logger.trace("In visitColumnValues " + ctx.getText());
        ColumnValue columnValue = new ColumnValue();
        logicalPlan.getCurrentNode().addChildNode(columnValue);
        logicalPlan.setCurrentNode(columnValue);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitParameterValues(ParameterValuesContext ctx) {
        logger.trace("In visitParameterValues " + ctx.getText());
        Parameters parameters = new Parameters();
        logicalPlan.getCurrentNode().addChildNode(parameters);
        logicalPlan.setCurrentNode(parameters);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitCreateAsset(CreateAssetContext ctx) {
        logger.trace("In visitCreateAsset " + ctx.getText());
        createAsset = new CreateAsset();
        logicalPlan.setCreateAsset(createAsset);
        logicalPlan.setCurrentNode(createAsset);
        logicalPlan.setType(SQLType.CREATE_ASSET);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitAsset(AssetContext ctx) {
        logger.trace("In visitAsset " + ctx.getText());
        Asset asset = new Asset();
        logicalPlan.getCurrentNode().addChildNode(asset);
        logicalPlan.setCurrentNode(asset);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitColTypeList(ColTypeListContext ctx) {
        logger.trace("In visitColTypeList " + ctx.getText());
        ColumnTypeList columnTypeList = new ColumnTypeList();
        logicalPlan.getCurrentNode().addChildNode(columnTypeList);
        logicalPlan.setCurrentNode(columnTypeList);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitColType(ColTypeContext ctx) {
        logger.trace("In visitColType " + ctx.getText());
        ColumnType columnType = new ColumnType();
        logicalPlan.getCurrentNode().addChildNode(columnType);
        logicalPlan.setCurrentNode(columnType);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitStorageType(StorageTypeContext ctx) {
        logger.trace("In visitStorageType " + ctx.getText());
        StorageType storageType = new StorageType();
        if (ctx.JSON() != null) {
            storageType.addChildNode(new IdentifierNode("JSON"));
        } else {
            storageType.addChildNode(new IdentifierNode("CSV"));
        }
        logicalPlan.getCurrentNode().addChildNode(storageType);
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitFieldDelimiter(FieldDelimiterContext ctx) {
        logger.trace("In visitFieldDelimiter " + ctx.getText());
        FieldDelimiter fieldDelimiter = new FieldDelimiter();
        fieldDelimiter.addChildNode(new IdentifierNode(ctx.STRING().getText().replace("'", "").replace("\"", "")));
        logicalPlan.getCurrentNode().addChildNode(fieldDelimiter);
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitRecordDelimiter(RecordDelimiterContext ctx) {
        logger.trace("In visitRecordDelimiter " + ctx.getText());
        RecordDelimiter recordDelimiter = new RecordDelimiter();
        recordDelimiter.addChildNode(new IdentifierNode(ctx.STRING().getText().replace("'", "").replace("\"", "")));
        logicalPlan.getCurrentNode().addChildNode(recordDelimiter);
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitDeleteFunction(DeleteFunctionContext ctx) {
        logger.trace("In visitDeleteFunction " + ctx.getText());
        deleteFunction = new DeleteFunction();
        logicalPlan.setDeleteFunction(deleteFunction);
        logicalPlan.setCurrentNode(deleteFunction);
        logicalPlan.setType(SQLType.DELETE_FUNCTION);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitDeploySmartContractRule(DeploySmartContractRuleContext ctx) {
        logger.trace("In visitDeploySmartContractRule " + ctx.getText());
        smartCnrtDeploy = new SmartCnrtDeploy();
        logicalPlan.setSmartCnrtDeploy(smartCnrtDeploy);
        logicalPlan.setCurrentNode(smartCnrtDeploy);
        logicalPlan.setType(SQLType.DEPLOY_SMARTCONTRACT);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitDropAsset(DropAssetContext ctx) {
        logger.trace("In visitDropAsset " + ctx.getText());
        dropAsset = new DropAsset();
        logicalPlan.setDropAsset(dropAsset);
        logicalPlan.setCurrentNode(dropAsset);
        logicalPlan.setType(SQLType.DROP_ASSET);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitUpgradeFunction(UpgradeFunctionContext ctx) {
        logger.trace("In visitUpgradeFunction " + ctx.getText());
        upgradeFunction = new UpgradeFunction();
        logicalPlan.setUpgradeFunction(upgradeFunction);
        logicalPlan.setCurrentNode(upgradeFunction);
        logicalPlan.setType(SQLType.UPGRADE_FUNCTION);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan defaultResult() {
        return logicalPlan;
    }

    /*
     * If you call logicalPlan.setCurrentNode(node); then call this method so that node pointer can be reset to parent
     * after visiting children. Note that this will happen recursively for each level of tree. If you are not setting
     * current node and just creating and adding nodes to parent call visitChildren directly.
     */
    public LogicalPlan visitChildrenAndResetNode(RuleNode node) {
        try {
            return visitChildren(node);
        } finally {
            logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
        }
    }

    @Override
    public LogicalPlan visitList(ListContext ctx) {
        logger.trace("In visitList " + ctx.getText());
        ListAgrs args = new ListAgrs();
        logicalPlan.getCurrentNode().addChildNode(args);
        logicalPlan.setCurrentNode(args);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitSmartFunction(SmartFunctionContext ctx) {
        logger.trace("In visitSmartFunction " + ctx.getText());
        smartContractFunction = new SmartContractFunction();
        logicalPlan.getCurrentNode().addChildNode(smartContractFunction);
        logicalPlan.setCurrentNode(smartContractFunction);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitBytes(BytesContext ctx) {
        logger.trace("In visitBytes " + ctx.getText());
        BytesArgs args = new BytesArgs(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(args);
        logicalPlan.setCurrentNode(args);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitClassOption(ClassOptionContext ctx) {
        logger.trace("In visitClassOption " + ctx.getText());
        SmartCnrtClassOption args = new SmartCnrtClassOption(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(args);
        logicalPlan.setCurrentNode(args);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitAsyncOption(AsyncOptionContext ctx) {
        logger.trace("In visitAsyncOption " + ctx.getText());
        SmartCnrtAsyncOption args = new SmartCnrtAsyncOption(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(args);
        logicalPlan.setCurrentNode(args);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitListType(ListTypeContext ctx) {
        logger.trace("In visitListType " + ctx.getText());
        SmartCnrtListType args = new SmartCnrtListType(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(args);
        logicalPlan.setCurrentNode(args);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitAddressVlaue(AddressVlaueContext ctx) {
        logger.trace("In visitAddressVlaue " + ctx.getText());
        SmartCnrtAddressOption args = new SmartCnrtAddressOption(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(args);
        logicalPlan.setCurrentNode(args);
        return visitChildrenAndResetNode(ctx);
    }

}
