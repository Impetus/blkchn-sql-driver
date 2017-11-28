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

import com.impetus.blkch.sql.generated.SqlBaseParser.AggregationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ColumnReferenceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ComparisonContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ComparisonOperatorContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DereferenceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FromClauseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FunctionCallContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.LogicalBinaryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NamedExpressionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NamedExpressionSeqContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NumericLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QueryOrganizationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetQuantifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleStatementContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SortItemContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.StarContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.StringLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.UnquotedIdentifierContext;
import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.Comparator;
import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
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
import com.impetus.blkch.sql.query.QuantifierNode.Quantifier;
import com.impetus.blkch.sql.query.QuantifierNode;
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

    @Override
    public LogicalPlan visitSingleStatement(SingleStatementContext ctx) {
        logger.trace("In visitSingleStatement " + ctx.getText());
        query = new Query();
        logicalPlan.setQuery(query);
        logicalPlan.setCurrentNode(query);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitNamedExpressionSeq(NamedExpressionSeqContext ctx) {
        logger.trace("In visitNamedExpressionSeq " + ctx.getText());
        SelectClause selectClause = new SelectClause();
        logicalPlan.getCurrentNode().addChildNode(selectClause);
        logicalPlan.setCurrentNode(selectClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitNamedExpression(NamedExpressionContext ctx) {
        logger.trace("In visitNamedExpression " + ctx.getText());
        if (logicalPlan.getCurrentNode() instanceof SelectClause) {
            SelectItem selectItem = new SelectItem();
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
        Column column = new Column(ctx.getText());
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
        FunctionNode functionNode = new FunctionNode();
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
    public LogicalPlan visitFromClause(FromClauseContext ctx) {
        logger.trace("In visitFromClause " + ctx.getText());
        FromItem fromItem = new FromItem();
        logicalPlan.getCurrentNode().addChildNode(fromItem);
        logicalPlan.setCurrentNode(fromItem);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitUnquotedIdentifier(UnquotedIdentifierContext ctx) {
        logger.trace("In visitUnquotedIdentifier " + ctx.getText());
        IdentifierNode node = new IdentifierNode(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(node);
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitTableIdentifier(TableIdentifierContext ctx) {
        logger.trace("In visitTableIdentifier " + ctx.getText());
        Table table = new Table(ctx.getText());
        logicalPlan.getCurrentNode().addChildNode(table);
        logicalPlan.setCurrentNode(table);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitDereference(DereferenceContext ctx) {
        logger.trace("In visitDereference " + ctx.getText());
        TreeNode node = new TreeNode("DEREFERENCE");
        logicalPlan.getCurrentNode().addChildNode(node);
        logicalPlan.setCurrentNode(node);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitLogicalBinary(LogicalBinaryContext ctx) {
        logger.trace("In visitLogicalBinary " + ctx.getText());
        if (logicalPlan.getCurrentNode() instanceof Query) {
            if (logicalPlan.getQuery().getChildNodes().size() < 3) {
                WhereClause whereClause = new WhereClause();
                logicalPlan.getCurrentNode().addChildNode(whereClause);
                if (ctx.AND() != null) {
                    LogicalOperation andNode = new LogicalOperation(Operator.AND);
                    whereClause.addChildNode(andNode);
                    logicalPlan.setCurrentNode(andNode);
                } else if (ctx.OR() != null) {
                    LogicalOperation orNode = new LogicalOperation(Operator.OR);
                    whereClause.addChildNode(orNode);
                    logicalPlan.setCurrentNode(orNode);
                }
            } else {
                HavingClause havingClause = new HavingClause();
                logicalPlan.getCurrentNode().addChildNode(havingClause);
                if (ctx.AND() != null) {
                    LogicalOperation andNode = new LogicalOperation(Operator.AND);
                    havingClause.addChildNode(andNode);
                    logicalPlan.setCurrentNode(andNode);
                } else if (ctx.OR() != null) {
                    LogicalOperation orNode = new LogicalOperation(Operator.OR);
                    havingClause.addChildNode(orNode);
                    logicalPlan.setCurrentNode(orNode);
                }
            }
            try {
                return visitChildrenAndResetNode(ctx);
            } finally {
                logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
            }
        } else {
            if (ctx.AND() != null) {
                LogicalOperation andNode = new LogicalOperation(Operator.AND);
                logicalPlan.getCurrentNode().addChildNode(andNode);
                logicalPlan.setCurrentNode(andNode);
            } else if (ctx.OR() != null) {
                LogicalOperation orNode = new LogicalOperation(Operator.OR);
                logicalPlan.getCurrentNode().addChildNode(orNode);
                logicalPlan.setCurrentNode(orNode);
            }
            return visitChildrenAndResetNode(ctx);
        }
    }

    @Override
    public LogicalPlan visitComparison(ComparisonContext ctx) {
        logger.trace("In visitComparison " + ctx.getText());
        if (logicalPlan.getCurrentNode() instanceof Query) {
            if (logicalPlan.getQuery().getChildNodes().size() < 3) {
                WhereClause whereClause = new WhereClause();
                logicalPlan.getCurrentNode().addChildNode(whereClause);
                FilterItem filterItem = new FilterItem();
                whereClause.addChildNode(filterItem);
                logicalPlan.setCurrentNode(filterItem);
            } else {
                HavingClause havingClause = new HavingClause();
                logicalPlan.getCurrentNode().addChildNode(havingClause);
                FilterItem filterItem = new FilterItem();
                havingClause.addChildNode(filterItem);
                logicalPlan.setCurrentNode(filterItem);
            }
            try {
                return visitChildrenAndResetNode(ctx);
            } finally {
                logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
            }
        } else {
            FilterItem filterItem = new FilterItem();
            logicalPlan.getCurrentNode().addChildNode(filterItem);
            logicalPlan.setCurrentNode(filterItem);
            return visitChildrenAndResetNode(ctx);
        }
    }

    @Override
    public LogicalPlan visitComparisonOperator(ComparisonOperatorContext ctx) {
        logger.trace("In visitComparisonOperator " + ctx.getText());
        Comparator node = new Comparator(ComparisionOperator.getOp(ctx.getText().trim()));
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
    public LogicalPlan visitAggregation(AggregationContext ctx) {
        logger.trace("In visitComparisonOperator " + ctx.getText());
        GroupByClause groupByClause = new GroupByClause();
        logicalPlan.getCurrentNode().addChildNode(groupByClause);
        logicalPlan.setCurrentNode(groupByClause);
        return visitChildrenAndResetNode(ctx);
    }

    @Override
    public LogicalPlan visitQueryOrganization(QueryOrganizationContext ctx) {
        logger.trace("In visitQueryOrganization " + ctx.getText());
        if (ctx.ORDER() != null && ctx.BY() != null) {
            OrderByClause orderByClause = new OrderByClause();
            logicalPlan.getCurrentNode().addChildNode(orderByClause);
            logicalPlan.setCurrentNode(orderByClause);
            for (SortItemContext sortItem : ctx.order) {
                sortItem.accept(this);
            }
            logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
        }
        if (ctx.LIMIT() != null) {
            LimitClause limitClause = new LimitClause();
            logicalPlan.getCurrentNode().addChildNode(limitClause);
            logicalPlan.setCurrentNode(limitClause);
            ctx.limit.accept(this);
            logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
        }
        return defaultResult();
    }

    @Override
    public LogicalPlan visitSortItem(SortItemContext ctx) {
        logger.trace("In visitSortItem " + ctx.getText());
        OrderItem orderItem = new OrderItem();
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
