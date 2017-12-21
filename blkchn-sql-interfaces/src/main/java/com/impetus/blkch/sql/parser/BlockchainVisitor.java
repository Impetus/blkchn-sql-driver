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

import org.antlr.v4.runtime.tree.RuleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.sql.function.Args;
import com.impetus.blkch.sql.function.ClassName;
import com.impetus.blkch.sql.function.CreateFunction;
import com.impetus.blkch.sql.function.Endorsers;
import com.impetus.blkch.sql.function.Version;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArgsContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColumnReferenceContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComparisonContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComparisonOperatorContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DereferenceContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.EndorserDetailsContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.EndorsersContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FromClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FunctionCallContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.GroupByClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.HavingClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LimitClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LogicalBinaryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NamedExpressionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NumericLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.OrderByClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SelectClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SetQuantifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SimpleQueryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SortItemContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StarContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StringLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.TableIdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.UnquotedIdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.VersionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.WhereClauseContext;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.DereferenceNode;
import com.impetus.blkch.sql.query.FilterItem;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.FunctionNode;
import com.impetus.blkch.sql.query.GroupByClause;
import com.impetus.blkch.sql.query.HavingClause;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LimitClause;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.OrderByClause;
import com.impetus.blkch.sql.query.OrderItem;
import com.impetus.blkch.sql.query.OrderingDirection;
import com.impetus.blkch.sql.query.OrderingDirection.Direction;
import com.impetus.blkch.sql.query.QuantifierNode;
import com.impetus.blkch.sql.query.QuantifierNode.Quantifier;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectClause;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.query.StarNode;
import com.impetus.blkch.sql.query.Table;
import com.impetus.blkch.sql.query.WhereClause;

public class BlockchainVisitor extends AbstractSyntaxTreeVisitor {

    private static final Logger logger = LoggerFactory.getLogger(BlockchainVisitor.class);

    LogicalPlan logicalPlan = new LogicalPlan("BlockchainVisitor");

    Query query;
    CreateFunction crtFunction;
    ClassName className;

    @Override
    public LogicalPlan visitSimpleQuery(SimpleQueryContext ctx) {
        logger.trace("In visitSimpleQuery " + ctx.getText());
        query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitCreateFunctionRule(BlkchnSqlParser.CreateFunctionRuleContext ctx) {
        logger.trace("In visitCreateFunctionRule " + ctx.getText());
        crtFunction = new CreateFunction();
        logicalPlan.setCreateFunction(crtFunction);
        logicalPlan.setCurrentNode(crtFunction);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitClassName(BlkchnSqlParser.ClassNameContext ctx){
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
        logicalPlan.getCurrentNode().addChildNode(new IdentifierNode(ctx.getText()));
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitStringLiteral(StringLiteralContext ctx) {
        logger.trace("In visitStringLiteral " + ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(new IdentifierNode(ctx.getText()));
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
    public LogicalPlan visitEndorsers(EndorsersContext ctx) {
        logger.trace("In visitEndorsers " + ctx.getText());
        Endorsers endorsers = new Endorsers();
        logicalPlan.getCurrentNode().addChildNode(endorsers);
        logicalPlan.setCurrentNode(endorsers);
        return visitChildrenAndResetNode(ctx);
    }
    
    @Override
    public LogicalPlan visitEndorserDetails(EndorserDetailsContext ctx) {
        logger.trace("In visitEndorserDetails " + ctx.getText());
        if(ctx.ENDORSER() != null) {
            IdentifierNode node = new IdentifierNode(ctx.ENDORSER().getText());
            logicalPlan.getCurrentNode().addChildNode(node);
            logicalPlan.setCurrentNode(node);
        } else {
            if(ctx.AND() != null) {
                LogicalOperation oper = new LogicalOperation(Operator.AND);
                logicalPlan.getCurrentNode().addChildNode(oper);
                logicalPlan.setCurrentNode(oper);
            } else {
                LogicalOperation oper = new LogicalOperation(Operator.OR);
                logicalPlan.getCurrentNode().addChildNode(oper);
                logicalPlan.setCurrentNode(oper);
            }
        }
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
    public LogicalPlan defaultResult() {
        return logicalPlan;
    }

    /*
     * If you call logicalPlan.setCurrentNode(node); then call this method so
     * that node pointer can be reset to parent after visiting children. Note
     * that this will happen recursively for each level of tree. If you are not
     * setting current node and just creating and adding nodes to parent call
     * visitChildren directly.
     */
    public LogicalPlan visitChildrenAndResetNode(RuleNode node) {
        try {
            return visitChildren(node);
        } finally {
            logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
        }
    }

}
