// Generated from BlkchnSql.g4 by ANTLR 4.5
package com.impetus.blkch.sql.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BlkchnSqlParser}.
 */
public interface BlkchnSqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(BlkchnSqlParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(BlkchnSqlParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementDefault}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDefault(BlkchnSqlParser.StatementDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementDefault}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDefault(BlkchnSqlParser.StatementDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleInsert}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSingleInsert(BlkchnSqlParser.SingleInsertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleInsert}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSingleInsert(BlkchnSqlParser.SingleInsertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateFunctionRule(BlkchnSqlParser.CreateFunctionRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateFunctionRule(BlkchnSqlParser.CreateFunctionRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCallFunctionRule(BlkchnSqlParser.CallFunctionRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCallFunctionRule(BlkchnSqlParser.CallFunctionRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createAssetRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateAssetRule(BlkchnSqlParser.CreateAssetRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createAssetRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateAssetRule(BlkchnSqlParser.CreateAssetRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deleteFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteFunctionRule(BlkchnSqlParser.DeleteFunctionRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deleteFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteFunctionRule(BlkchnSqlParser.DeleteFunctionRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropAssetRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDropAssetRule(BlkchnSqlParser.DropAssetRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropAssetRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDropAssetRule(BlkchnSqlParser.DropAssetRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code upgradeFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUpgradeFunctionRule(BlkchnSqlParser.UpgradeFunctionRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code upgradeFunctionRule}
	 * labeled alternative in {@link BlkchnSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUpgradeFunctionRule(BlkchnSqlParser.UpgradeFunctionRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void enterInsertInto(BlkchnSqlParser.InsertIntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void exitInsertInto(BlkchnSqlParser.InsertIntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#columnNames}.
	 * @param ctx the parse tree
	 */
	void enterColumnNames(BlkchnSqlParser.ColumnNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#columnNames}.
	 * @param ctx the parse tree
	 */
	void exitColumnNames(BlkchnSqlParser.ColumnNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#columnValues}.
	 * @param ctx the parse tree
	 */
	void enterColumnValues(BlkchnSqlParser.ColumnValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#columnValues}.
	 * @param ctx the parse tree
	 */
	void exitColumnValues(BlkchnSqlParser.ColumnValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#constantSeq}.
	 * @param ctx the parse tree
	 */
	void enterConstantSeq(BlkchnSqlParser.ConstantSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#constantSeq}.
	 * @param ctx the parse tree
	 */
	void exitConstantSeq(BlkchnSqlParser.ConstantSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#createFunction}.
	 * @param ctx the parse tree
	 */
	void enterCreateFunction(BlkchnSqlParser.CreateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#createFunction}.
	 * @param ctx the parse tree
	 */
	void exitCreateFunction(BlkchnSqlParser.CreateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#upgradeFunction}.
	 * @param ctx the parse tree
	 */
	void enterUpgradeFunction(BlkchnSqlParser.UpgradeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#upgradeFunction}.
	 * @param ctx the parse tree
	 */
	void exitUpgradeFunction(BlkchnSqlParser.UpgradeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#createAsset}.
	 * @param ctx the parse tree
	 */
	void enterCreateAsset(BlkchnSqlParser.CreateAssetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#createAsset}.
	 * @param ctx the parse tree
	 */
	void exitCreateAsset(BlkchnSqlParser.CreateAssetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#asset}.
	 * @param ctx the parse tree
	 */
	void enterAsset(BlkchnSqlParser.AssetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#asset}.
	 * @param ctx the parse tree
	 */
	void exitAsset(BlkchnSqlParser.AssetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#storageType}.
	 * @param ctx the parse tree
	 */
	void enterStorageType(BlkchnSqlParser.StorageTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#storageType}.
	 * @param ctx the parse tree
	 */
	void exitStorageType(BlkchnSqlParser.StorageTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#fieldDelimiter}.
	 * @param ctx the parse tree
	 */
	void enterFieldDelimiter(BlkchnSqlParser.FieldDelimiterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#fieldDelimiter}.
	 * @param ctx the parse tree
	 */
	void exitFieldDelimiter(BlkchnSqlParser.FieldDelimiterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#recordDelimiter}.
	 * @param ctx the parse tree
	 */
	void enterRecordDelimiter(BlkchnSqlParser.RecordDelimiterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#recordDelimiter}.
	 * @param ctx the parse tree
	 */
	void exitRecordDelimiter(BlkchnSqlParser.RecordDelimiterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#deleteFunction}.
	 * @param ctx the parse tree
	 */
	void enterDeleteFunction(BlkchnSqlParser.DeleteFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#deleteFunction}.
	 * @param ctx the parse tree
	 */
	void exitDeleteFunction(BlkchnSqlParser.DeleteFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#dropAsset}.
	 * @param ctx the parse tree
	 */
	void enterDropAsset(BlkchnSqlParser.DropAssetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#dropAsset}.
	 * @param ctx the parse tree
	 */
	void exitDropAsset(BlkchnSqlParser.DropAssetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(BlkchnSqlParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(BlkchnSqlParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#version}.
	 * @param ctx the parse tree
	 */
	void enterVersion(BlkchnSqlParser.VersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#version}.
	 * @param ctx the parse tree
	 */
	void exitVersion(BlkchnSqlParser.VersionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#endorsersFile}.
	 * @param ctx the parse tree
	 */
	void enterEndorsersFile(BlkchnSqlParser.EndorsersFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#endorsersFile}.
	 * @param ctx the parse tree
	 */
	void exitEndorsersFile(BlkchnSqlParser.EndorsersFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#policyFile}.
	 * @param ctx the parse tree
	 */
	void enterPolicyFile(BlkchnSqlParser.PolicyFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#policyFile}.
	 * @param ctx the parse tree
	 */
	void exitPolicyFile(BlkchnSqlParser.PolicyFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(BlkchnSqlParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(BlkchnSqlParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#argParamSeq}.
	 * @param ctx the parse tree
	 */
	void enterArgParamSeq(BlkchnSqlParser.ArgParamSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#argParamSeq}.
	 * @param ctx the parse tree
	 */
	void exitArgParamSeq(BlkchnSqlParser.ArgParamSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#argParam}.
	 * @param ctx the parse tree
	 */
	void enterArgParam(BlkchnSqlParser.ArgParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#argParam}.
	 * @param ctx the parse tree
	 */
	void exitArgParam(BlkchnSqlParser.ArgParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void enterCallFunction(BlkchnSqlParser.CallFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void exitCallFunction(BlkchnSqlParser.CallFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#parameterValues}.
	 * @param ctx the parse tree
	 */
	void enterParameterValues(BlkchnSqlParser.ParameterValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#parameterValues}.
	 * @param ctx the parse tree
	 */
	void exitParameterValues(BlkchnSqlParser.ParameterValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleQuery}
	 * labeled alternative in {@link BlkchnSqlParser#query}.
	 * @param ctx the parse tree
	 */
	void enterSimpleQuery(BlkchnSqlParser.SimpleQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleQuery}
	 * labeled alternative in {@link BlkchnSqlParser#query}.
	 * @param ctx the parse tree
	 */
	void exitSimpleQuery(BlkchnSqlParser.SimpleQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#queryOrganization}.
	 * @param ctx the parse tree
	 */
	void enterQueryOrganization(BlkchnSqlParser.QueryOrganizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#queryOrganization}.
	 * @param ctx the parse tree
	 */
	void exitQueryOrganization(BlkchnSqlParser.QueryOrganizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(BlkchnSqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(BlkchnSqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(BlkchnSqlParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(BlkchnSqlParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link BlkchnSqlParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterQueryTermDefault(BlkchnSqlParser.QueryTermDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link BlkchnSqlParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitQueryTermDefault(BlkchnSqlParser.QueryTermDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setOperation}
	 * labeled alternative in {@link BlkchnSqlParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterSetOperation(BlkchnSqlParser.SetOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setOperation}
	 * labeled alternative in {@link BlkchnSqlParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitSetOperation(BlkchnSqlParser.SetOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link BlkchnSqlParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterQueryPrimaryDefault(BlkchnSqlParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link BlkchnSqlParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitQueryPrimaryDefault(BlkchnSqlParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link BlkchnSqlParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(BlkchnSqlParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link BlkchnSqlParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(BlkchnSqlParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void enterSortItem(BlkchnSqlParser.SortItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void exitSortItem(BlkchnSqlParser.SortItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(BlkchnSqlParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(BlkchnSqlParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void enterSelectClause(BlkchnSqlParser.SelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void exitSelectClause(BlkchnSqlParser.SelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(BlkchnSqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(BlkchnSqlParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(BlkchnSqlParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(BlkchnSqlParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(BlkchnSqlParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(BlkchnSqlParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(BlkchnSqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(BlkchnSqlParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantifier(BlkchnSqlParser.SetQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantifier(BlkchnSqlParser.SetQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(BlkchnSqlParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(BlkchnSqlParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#joinRelation}.
	 * @param ctx the parse tree
	 */
	void enterJoinRelation(BlkchnSqlParser.JoinRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#joinRelation}.
	 * @param ctx the parse tree
	 */
	void exitJoinRelation(BlkchnSqlParser.JoinRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(BlkchnSqlParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(BlkchnSqlParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void enterJoinCriteria(BlkchnSqlParser.JoinCriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void exitJoinCriteria(BlkchnSqlParser.JoinCriteriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(BlkchnSqlParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(BlkchnSqlParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#identifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierSeq(BlkchnSqlParser.IdentifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#identifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierSeq(BlkchnSqlParser.IdentifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTableName(BlkchnSqlParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTableName(BlkchnSqlParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aliasedQuery}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterAliasedQuery(BlkchnSqlParser.AliasedQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aliasedQuery}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitAliasedQuery(BlkchnSqlParser.AliasedQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineTableDefault2}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterInlineTableDefault2(BlkchnSqlParser.InlineTableDefault2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineTableDefault2}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitInlineTableDefault2(BlkchnSqlParser.InlineTableDefault2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code aliasedRelation}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterAliasedRelation(BlkchnSqlParser.AliasedRelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aliasedRelation}
	 * labeled alternative in {@link BlkchnSqlParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitAliasedRelation(BlkchnSqlParser.AliasedRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#inlineTable}.
	 * @param ctx the parse tree
	 */
	void enterInlineTable(BlkchnSqlParser.InlineTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#inlineTable}.
	 * @param ctx the parse tree
	 */
	void exitInlineTable(BlkchnSqlParser.InlineTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTableIdentifier(BlkchnSqlParser.TableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTableIdentifier(BlkchnSqlParser.TableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#namedExpression}.
	 * @param ctx the parse tree
	 */
	void enterNamedExpression(BlkchnSqlParser.NamedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#namedExpression}.
	 * @param ctx the parse tree
	 */
	void exitNamedExpression(BlkchnSqlParser.NamedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#namedExpressionSeq}.
	 * @param ctx the parse tree
	 */
	void enterNamedExpressionSeq(BlkchnSqlParser.NamedExpressionSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#namedExpressionSeq}.
	 * @param ctx the parse tree
	 */
	void exitNamedExpressionSeq(BlkchnSqlParser.NamedExpressionSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(BlkchnSqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(BlkchnSqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link BlkchnSqlParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(BlkchnSqlParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link BlkchnSqlParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(BlkchnSqlParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link BlkchnSqlParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanDefault(BlkchnSqlParser.BooleanDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link BlkchnSqlParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanDefault(BlkchnSqlParser.BooleanDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link BlkchnSqlParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBinary(BlkchnSqlParser.LogicalBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link BlkchnSqlParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBinary(BlkchnSqlParser.LogicalBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#predicated}.
	 * @param ctx the parse tree
	 */
	void enterPredicated(BlkchnSqlParser.PredicatedContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#predicated}.
	 * @param ctx the parse tree
	 */
	void exitPredicated(BlkchnSqlParser.PredicatedContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(BlkchnSqlParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(BlkchnSqlParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpressionDefault(BlkchnSqlParser.ValueExpressionDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpressionDefault(BlkchnSqlParser.ValueExpressionDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(BlkchnSqlParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(BlkchnSqlParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code placeholder}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterPlaceholder(BlkchnSqlParser.PlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code placeholder}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitPlaceholder(BlkchnSqlParser.PlaceholderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticBinary(BlkchnSqlParser.ArithmeticBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticBinary(BlkchnSqlParser.ArithmeticBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticUnary(BlkchnSqlParser.ArithmeticUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link BlkchnSqlParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticUnary(BlkchnSqlParser.ArithmeticUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dereference}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterDereference(BlkchnSqlParser.DereferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dereference}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitDereference(BlkchnSqlParser.DereferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleCase}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCase(BlkchnSqlParser.SimpleCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleCase}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCase(BlkchnSqlParser.SimpleCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnReference(BlkchnSqlParser.ColumnReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnReference(BlkchnSqlParser.ColumnReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowConstructor}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowConstructor(BlkchnSqlParser.RowConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowConstructor}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowConstructor(BlkchnSqlParser.RowConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code last}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterLast(BlkchnSqlParser.LastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code last}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitLast(BlkchnSqlParser.LastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code star}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStar(BlkchnSqlParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code star}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStar(BlkchnSqlParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(BlkchnSqlParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(BlkchnSqlParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeFunctionCall}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionCall(BlkchnSqlParser.TimeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeFunctionCall}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionCall(BlkchnSqlParser.TimeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryExpression}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryExpression(BlkchnSqlParser.SubqueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryExpression}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryExpression(BlkchnSqlParser.SubqueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cast}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterCast(BlkchnSqlParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitCast(BlkchnSqlParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantDefault}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefault(BlkchnSqlParser.ConstantDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantDefault}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefault(BlkchnSqlParser.ConstantDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(BlkchnSqlParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(BlkchnSqlParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BlkchnSqlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BlkchnSqlParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code searchedCase}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSearchedCase(BlkchnSqlParser.SearchedCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code searchedCase}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSearchedCase(BlkchnSqlParser.SearchedCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code first}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFirst(BlkchnSqlParser.FirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code first}
	 * labeled alternative in {@link BlkchnSqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFirst(BlkchnSqlParser.FirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(BlkchnSqlParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(BlkchnSqlParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterIntervalLiteral(BlkchnSqlParser.IntervalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitIntervalLiteral(BlkchnSqlParser.IntervalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstructor(BlkchnSqlParser.TypeConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstructor(BlkchnSqlParser.TypeConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(BlkchnSqlParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(BlkchnSqlParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(BlkchnSqlParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(BlkchnSqlParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(BlkchnSqlParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(BlkchnSqlParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(BlkchnSqlParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(BlkchnSqlParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(BlkchnSqlParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(BlkchnSqlParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#predicateOperator}.
	 * @param ctx the parse tree
	 */
	void enterPredicateOperator(BlkchnSqlParser.PredicateOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#predicateOperator}.
	 * @param ctx the parse tree
	 */
	void exitPredicateOperator(BlkchnSqlParser.PredicateOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(BlkchnSqlParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(BlkchnSqlParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterInterval(BlkchnSqlParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitInterval(BlkchnSqlParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void enterIntervalField(BlkchnSqlParser.IntervalFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void exitIntervalField(BlkchnSqlParser.IntervalFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void enterIntervalValue(BlkchnSqlParser.IntervalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void exitIntervalValue(BlkchnSqlParser.IntervalValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexDataType}
	 * labeled alternative in {@link BlkchnSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterComplexDataType(BlkchnSqlParser.ComplexDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexDataType}
	 * labeled alternative in {@link BlkchnSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitComplexDataType(BlkchnSqlParser.ComplexDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveDataType}
	 * labeled alternative in {@link BlkchnSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveDataType(BlkchnSqlParser.PrimitiveDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveDataType}
	 * labeled alternative in {@link BlkchnSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveDataType(BlkchnSqlParser.PrimitiveDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void enterColTypeList(BlkchnSqlParser.ColTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void exitColTypeList(BlkchnSqlParser.ColTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#colType}.
	 * @param ctx the parse tree
	 */
	void enterColType(BlkchnSqlParser.ColTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#colType}.
	 * @param ctx the parse tree
	 */
	void exitColType(BlkchnSqlParser.ColTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#complexColTypeList}.
	 * @param ctx the parse tree
	 */
	void enterComplexColTypeList(BlkchnSqlParser.ComplexColTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#complexColTypeList}.
	 * @param ctx the parse tree
	 */
	void exitComplexColTypeList(BlkchnSqlParser.ComplexColTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#complexColType}.
	 * @param ctx the parse tree
	 */
	void enterComplexColType(BlkchnSqlParser.ComplexColTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#complexColType}.
	 * @param ctx the parse tree
	 */
	void exitComplexColType(BlkchnSqlParser.ComplexColTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void enterWhenClause(BlkchnSqlParser.WhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void exitWhenClause(BlkchnSqlParser.WhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(BlkchnSqlParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(BlkchnSqlParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(BlkchnSqlParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(BlkchnSqlParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link BlkchnSqlParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedIdentifier(BlkchnSqlParser.UnquotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link BlkchnSqlParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedIdentifier(BlkchnSqlParser.UnquotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link BlkchnSqlParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifierAlternative(BlkchnSqlParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link BlkchnSqlParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifierAlternative(BlkchnSqlParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(BlkchnSqlParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(BlkchnSqlParser.QuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(BlkchnSqlParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(BlkchnSqlParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(BlkchnSqlParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(BlkchnSqlParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigIntLiteral(BlkchnSqlParser.BigIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigIntLiteral(BlkchnSqlParser.BigIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterSmallIntLiteral(BlkchnSqlParser.SmallIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitSmallIntLiteral(BlkchnSqlParser.SmallIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterTinyIntLiteral(BlkchnSqlParser.TinyIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitTinyIntLiteral(BlkchnSqlParser.TinyIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(BlkchnSqlParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(BlkchnSqlParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigDecimalLiteral(BlkchnSqlParser.BigDecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link BlkchnSqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigDecimalLiteral(BlkchnSqlParser.BigDecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlkchnSqlParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void enterNonReserved(BlkchnSqlParser.NonReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlkchnSqlParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void exitNonReserved(BlkchnSqlParser.NonReservedContext ctx);
}