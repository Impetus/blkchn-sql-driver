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

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.sql.generated.*;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.AliasedQueryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.AliasedRelationContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArgParamContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArgParamSeqContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArgsContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArithmeticBinaryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArithmeticOperatorContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ArithmeticUnaryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.AssetContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.BigDecimalLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.BigIntLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.BooleanDefaultContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.BooleanLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.BooleanValueContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CallFunctionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CallFunctionRuleContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CastContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ChaincodeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColTypeListContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColumnNamesContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColumnReferenceContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ColumnValuesContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComparisonContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComparisonOperatorContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComplexColTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComplexColTypeListContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ComplexDataTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ConstantDefaultContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ConstantSeqContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CreateAssetContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CreateAssetRuleContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CreateFunctionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.CreateFunctionRuleContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DecimalLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DereferenceContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.DoubleLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.EndorserDetailsContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.EndorsersContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ExpressionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FieldDelimiterContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FirstContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FromClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FunctionCallContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.FunctionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.GroupByClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.HavingClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IdentifierListContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IdentifierSeqContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.InlineTableContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.InlineTableDefault2Context;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.InsertIntoContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IntegerLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IntervalContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IntervalFieldContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IntervalLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.IntervalValueContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.JoinCriteriaContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.JoinRelationContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.JoinTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LastContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LimitClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LogicalBinaryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.LogicalNotContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NamedExpressionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NamedExpressionSeqContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NonReservedContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NullLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.NumericLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.OrderByClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ParameterValuesContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ParenthesizedExpressionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.PredicateContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.PredicateOperatorContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.PredicatedContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.PrimitiveDataTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.QualifiedNameContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.QueryOrganizationContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.QueryPrimaryDefaultContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.QuerySpecificationContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.QueryTermDefaultContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.QuotedIdentifierAlternativeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.QuotedIdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.RecordDelimiterContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.RelationContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.RowConstructorContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SearchedCaseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SelectClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SetOperationContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SetQuantifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SimpleCaseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SimpleQueryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SingleInsertContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SingleStatementContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SmallIntLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SortItemContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StarContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StatementDefaultContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StorageTypeContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.StringLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SubqueryContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SubqueryExpressionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.SubscriptContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.TableIdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.TableNameContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.TimeFunctionCallContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.TinyIntLiteralContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.TypeConstructorContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.UnquotedIdentifierContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.ValueExpressionDefaultContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.VersionContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.WhenClauseContext;
import com.impetus.blkch.sql.generated.BlkchnSqlParser.WhereClauseContext;

public abstract class AbstractSyntaxTreeVisitor extends AbstractParseTreeVisitor<LogicalPlan> implements
        BlkchnSqlVisitor<LogicalPlan> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSyntaxTreeVisitor.class);

    @Override
    public LogicalPlan visitSingleStatement(SingleStatementContext ctx) {
        logger.trace("In visitSingleStatement " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitStatementDefault(StatementDefaultContext ctx) {
        logger.trace("In visitStatementDefault " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitQueryTermDefault(QueryTermDefaultContext ctx) {
        logger.trace("In visitQueryTermDefault " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitQueryPrimaryDefault(QueryPrimaryDefaultContext ctx) {
        logger.trace("In visitQueryPrimaryDefault " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSubquery(SubqueryContext ctx) {
        logger.trace("In visitSubquery " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSortItem(SortItemContext ctx) {
        logger.trace("In visitSortItem " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitQuerySpecification(QuerySpecificationContext ctx) {
        logger.trace("In visitQuerySpecification " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitFromClause(FromClauseContext ctx) {
        logger.trace("In visitFromClause " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSetQuantifier(SetQuantifierContext ctx) {
        logger.trace("In visitSetQuantifier " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitRelation(RelationContext ctx) {
        logger.trace("In visitRelation " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitJoinRelation(JoinRelationContext ctx) {
        logger.trace("In visitJoinRelation " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitJoinType(JoinTypeContext ctx) {
        logger.trace("In visitJoinType " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitJoinCriteria(JoinCriteriaContext ctx) {
        logger.trace("In visitJoinCriteria " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitIdentifierList(IdentifierListContext ctx) {
        logger.trace("In visitIdentifierList " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitIdentifierSeq(IdentifierSeqContext ctx) {
        logger.trace("In visitIdentifierSeq " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitTableName(TableNameContext ctx) {
        logger.trace("In visitTableName " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitAliasedQuery(AliasedQueryContext ctx) {
        logger.trace("In visitAliasedQuery " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitAliasedRelation(AliasedRelationContext ctx) {
        logger.trace("In visitAliasedRelation " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitInlineTable(InlineTableContext ctx) {
        logger.trace("In visitInlineTable " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitTableIdentifier(TableIdentifierContext ctx) {
        logger.trace("In visitTableIdentifier " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitNamedExpression(NamedExpressionContext ctx) {
        logger.trace("In visitNamedExpression " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitNamedExpressionSeq(NamedExpressionSeqContext ctx) {
        logger.trace("In visitNamedExpressionSeq " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitExpression(ExpressionContext ctx) {
        logger.trace("In visitExpression " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitLogicalNot(LogicalNotContext ctx) {
        logger.trace("In visitLogicalNot " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitBooleanDefault(BooleanDefaultContext ctx) {
        logger.trace("In visitBooleanDefault " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitLogicalBinary(LogicalBinaryContext ctx) {
        logger.trace("In visitLogicalBinary " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitPredicated(PredicatedContext ctx) {
        logger.trace("In visitPredicated " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitPredicate(PredicateContext ctx) {
        logger.trace("In visitPredicate " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitValueExpressionDefault(ValueExpressionDefaultContext ctx) {
        logger.trace("In visitValueExpressionDefault " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitComparison(ComparisonContext ctx) {
        logger.trace("In visitComparison " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitArithmeticBinary(ArithmeticBinaryContext ctx) {
        logger.trace("In visitArithmeticBinary " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitArithmeticUnary(ArithmeticUnaryContext ctx) {
        logger.trace("In visitArithmeticUnary " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitDereference(DereferenceContext ctx) {
        logger.trace("In visitDereference " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSimpleCase(SimpleCaseContext ctx) {
        logger.trace("In visitSimpleCase " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitColumnReference(ColumnReferenceContext ctx) {
        logger.trace("In visitColumnReference " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitRowConstructor(RowConstructorContext ctx) {
        logger.trace("In visitRowConstructor " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitLast(LastContext ctx) {
        logger.trace("In visitLast " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitStar(StarContext ctx) {
        logger.trace("In visitStar " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSubscript(SubscriptContext ctx) {
        logger.trace("In visitSubscript " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitTimeFunctionCall(TimeFunctionCallContext ctx) {
        logger.trace("In visitTimeFunctionCall " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSubqueryExpression(SubqueryExpressionContext ctx) {
        logger.trace("In visitSubqueryExpression " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitCast(CastContext ctx) {
        logger.trace("In visitCast " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitConstantDefault(ConstantDefaultContext ctx) {
        logger.trace("In visitConstantDefault " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitParenthesizedExpression(ParenthesizedExpressionContext ctx) {
        logger.trace("In visitParenthesizedExpression " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitFunctionCall(FunctionCallContext ctx) {
        logger.trace("In visitFunctionCall " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSearchedCase(SearchedCaseContext ctx) {
        logger.trace("In visitSearchedCase " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitFirst(FirstContext ctx) {
        logger.trace("In visitFirst " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitNullLiteral(NullLiteralContext ctx) {
        logger.trace("In visitNullLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitIntervalLiteral(IntervalLiteralContext ctx) {
        logger.trace("In visitIntervalLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitTypeConstructor(TypeConstructorContext ctx) {
        logger.trace("In visitTypeConstructor " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitNumericLiteral(NumericLiteralContext ctx) {
        logger.trace("In visitNumericLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitBooleanLiteral(BooleanLiteralContext ctx) {
        logger.trace("In visitBooleanLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitStringLiteral(StringLiteralContext ctx) {
        logger.trace("In visitStringLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitComparisonOperator(ComparisonOperatorContext ctx) {
        logger.trace("In visitComparisonOperator " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitArithmeticOperator(ArithmeticOperatorContext ctx) {
        logger.trace("In visitArithmeticOperator " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitPredicateOperator(PredicateOperatorContext ctx) {
        logger.trace("In visitPredicateOperator " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitBooleanValue(BooleanValueContext ctx) {
        logger.trace("In visitBooleanValue " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitInterval(IntervalContext ctx) {
        logger.trace("In visitInterval " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitIntervalField(IntervalFieldContext ctx) {
        logger.trace("In visitIntervalField " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitIntervalValue(IntervalValueContext ctx) {
        logger.trace("In visitIntervalValue " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitComplexDataType(ComplexDataTypeContext ctx) {
        logger.trace("In visitComplexDataType " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitPrimitiveDataType(PrimitiveDataTypeContext ctx) {
        logger.trace("In visitPrimitiveDataType " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitComplexColTypeList(ComplexColTypeListContext ctx) {
        logger.trace("In visitComplexColTypeList " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitComplexColType(ComplexColTypeContext ctx) {
        logger.trace("In visitComplexColType " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitWhenClause(WhenClauseContext ctx) {
        logger.trace("In visitWhenClause " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitQualifiedName(QualifiedNameContext ctx) {
        logger.trace("In visitQualifiedName " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitIdentifier(IdentifierContext ctx) {
        logger.trace("In visitIdentifier " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitUnquotedIdentifier(UnquotedIdentifierContext ctx) {
        logger.trace("In visitUnquotedIdentifier " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitQuotedIdentifierAlternative(QuotedIdentifierAlternativeContext ctx) {
        logger.trace("In visitQuotedIdentifierAlternative " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitQuotedIdentifier(QuotedIdentifierContext ctx) {
        logger.trace("In visitQuotedIdentifier " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitDecimalLiteral(DecimalLiteralContext ctx) {
        logger.trace("In visitDecimalLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitIntegerLiteral(IntegerLiteralContext ctx) {
        logger.trace("In visitIntegerLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitBigIntLiteral(BigIntLiteralContext ctx) {
        logger.trace("In visitBigIntLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSmallIntLiteral(SmallIntLiteralContext ctx) {
        logger.trace("In visitSmallIntLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitTinyIntLiteral(TinyIntLiteralContext ctx) {
        logger.trace("In visitTinyIntLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitDoubleLiteral(DoubleLiteralContext ctx) {
        logger.trace("In visitDoubleLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitBigDecimalLiteral(BigDecimalLiteralContext ctx) {
        logger.trace("In visitBigDecimalLiteral " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitNonReserved(NonReservedContext ctx) {
        logger.trace("In visitNonReserved " + ctx.getText());
        return visitChildren(ctx);

    }

    @Override
    public LogicalPlan visitSimpleQuery(SimpleQueryContext ctx) {
        logger.trace("In visitSimpleQuery " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitSelectClause(SelectClauseContext ctx) {
        logger.trace("In visitSelectClause " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitWhereClause(WhereClauseContext ctx) {
        logger.trace("In visitWhereClause " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitGroupByClause(GroupByClauseContext ctx) {
        logger.trace("In visitGroupByClause " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitHavingClause(HavingClauseContext ctx) {
        logger.trace("In visitHavingClause " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitQueryOrganization(QueryOrganizationContext ctx) {
        logger.trace("In visitQueryOrganization " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitOrderByClause(OrderByClauseContext ctx) {
        logger.trace("In visitOrderByClause " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitLimitClause(LimitClauseContext ctx) {
        logger.trace("In visitLimitClause " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitInlineTableDefault2(InlineTableDefault2Context ctx) {
        logger.trace("In visitInlineTableDefault2 " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitSetOperation(SetOperationContext ctx) {
        logger.trace("In visitSetOperation " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitSingleInsert(SingleInsertContext ctx)
    {
        logger.trace("In visitSingleInsert " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitCreateFunction(CreateFunctionContext ctx)
    {
        logger.trace("In visitCreateFunction " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitClassName(BlkchnSqlParser.ClassNameContext ctx) {
        logger.trace("In visitClassName " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitCallFunction(CallFunctionContext ctx)
    {
        logger.trace("In visitCallFunction " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitInsertInto(InsertIntoContext ctx)
    {
        logger.trace("In visitInsertInto " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitColumnNames(ColumnNamesContext ctx)
    {
        logger.trace("In visitColumnNames " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitColumnValues(ColumnValuesContext ctx)
    {
        logger.trace("In visitColumnValues " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitCreateFunctionRule(CreateFunctionRuleContext ctx)
    {
        logger.trace("In visitCreateFunctionRule " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitCallFunctionRule(CallFunctionRuleContext ctx)
    {
        logger.trace("In visitCallFunctionRule " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitParameterValues(ParameterValuesContext ctx)
    {
        logger.trace("In visitParameterValues " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitVersion(VersionContext ctx) {
        logger.trace("In visitVersion " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitEndorsers(EndorsersContext ctx) {
        logger.trace("In visitEndorsers " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitEndorserDetails(EndorserDetailsContext ctx) {
        logger.trace("In visitEndorserDetails " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitArgs(ArgsContext ctx) {
        logger.trace("In visitArgs " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitArgParamSeq(ArgParamSeqContext ctx) {
        logger.trace("In visitArgParamSeq " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitArgParam(ArgParamContext ctx) {
        logger.trace("In visitArgParam " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitConstantSeq(ConstantSeqContext ctx)
    {
        logger.trace("In visitConstantSeq " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitCreateAssetRule(CreateAssetRuleContext ctx) {
        logger.trace("In visitCreateAssetRule " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitCreateAsset(CreateAssetContext ctx) {
        logger.trace("In visitCreateAsset " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitAsset(AssetContext ctx) {
        logger.trace("In visitAsset " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitChaincode(ChaincodeContext ctx) {
        logger.trace("In visitChaincode " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitFunction(FunctionContext ctx) {
        logger.trace("In visitFunction " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitStorageType(StorageTypeContext ctx) {
        logger.trace("In visitStorageType " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitFieldDelimiter(FieldDelimiterContext ctx) {
        logger.trace("In visitFieldDelimiter " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitRecordDelimiter(RecordDelimiterContext ctx) {
        logger.trace("In visitRecordDelimiter " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitColTypeList(ColTypeListContext ctx) {
        logger.trace("In visitColTypeList " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public LogicalPlan visitColType(ColTypeContext ctx) {
        logger.trace("In visitColType " + ctx.getText());
        return visitChildren(ctx);
    }


}
