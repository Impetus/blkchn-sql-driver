package com.impetus.blkch.sql.parser;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.sql.generated.*;
import com.impetus.blkch.sql.generated.SqlBaseParser.AddTableColumnsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.AddTablePartitionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.AggregationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.AliasedQueryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.AliasedRelationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.AlterViewQueryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.AnalyzeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ArithmeticBinaryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ArithmeticOperatorContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ArithmeticUnaryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.BigDecimalLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.BigIntLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.BooleanDefaultContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.BooleanLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.BooleanValueContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.BucketSpecContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CacheTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CastContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ChangeColumnContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ClearCacheContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ColPositionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ColTypeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ColTypeListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ColumnReferenceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ComparisonContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ComparisonOperatorContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ComplexColTypeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ComplexColTypeListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ComplexDataTypeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ConstantDefaultContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ConstantListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateDatabaseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateFileFormatContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateFunctionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateHiveTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateTableHeaderContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateTableLikeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateTempViewUsingContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CreateViewContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.CtesContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DecimalLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DereferenceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DescribeColNameContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DescribeDatabaseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DescribeFuncNameContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DescribeFunctionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DescribeTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DoubleLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DropDatabaseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DropFunctionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DropTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.DropTablePartitionsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ExistsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ExplainContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ExpressionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FailNativeCommandContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FirstContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FrameBoundContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FromClauseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FunctionCallContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FunctionIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.GenericFileFormatContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.GroupingSetContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.HintContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.HintStatementContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IdentifierCommentContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IdentifierCommentListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IdentifierListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IdentifierSeqContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.InlineTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.InlineTableDefault1Context;
import com.impetus.blkch.sql.generated.SqlBaseParser.InlineTableDefault2Context;
import com.impetus.blkch.sql.generated.SqlBaseParser.InsertIntoContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IntegerLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IntervalContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IntervalFieldContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IntervalLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.IntervalValueContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.JoinCriteriaContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.JoinRelationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.JoinTypeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.LastContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.LateralViewContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.LoadDataContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.LocationSpecContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.LogicalBinaryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.LogicalNotContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ManageResourceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.MultiInsertQueryBodyContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.MultiInsertQueryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NamedExpressionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NamedExpressionSeqContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NamedQueryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NamedWindowContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NestedConstantListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NonReservedContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NullLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NumericLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.OrderedIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.OrderedIdentifierListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ParenthesizedExpressionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.PartitionSpecContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.PartitionSpecLocationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.PartitionValContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.PredicateContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.PredicateOperatorContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.PredicatedContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.PrimitiveDataTypeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QualifiedNameContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QueryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QueryOrganizationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QueryPrimaryDefaultContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QuerySpecificationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QueryTermDefaultContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QuotedIdentifierAlternativeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QuotedIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RecoverPartitionsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RefreshResourceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RefreshTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RelationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RenameTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RenameTablePartitionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RepairTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ResetConfigurationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ResourceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RowConstructorContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RowFormatDelimitedContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.RowFormatSerdeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SampleContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SearchedCaseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetConfigurationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetDatabasePropertiesContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetOperationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetQuantifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetTableLocationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetTablePropertiesContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SetTableSerDeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowColumnsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowCreateTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowDatabasesContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowFunctionsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowPartitionsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowTablesContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ShowTblPropertiesContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SimpleCaseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleDataTypeContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleExpressionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleFunctionIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleInsertQueryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleStatementContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleTableIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SkewSpecContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SmallIntLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SortItemContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.StarContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.StatementDefaultContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.StorageHandlerContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.StringLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SubqueryContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SubqueryExpressionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SubscriptContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableFileFormatContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableNameContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TablePropertyContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TablePropertyKeyContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TablePropertyListContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TablePropertyValueContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableProviderContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableValuedFunctionContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TimeFunctionCallContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TinyIntLiteralContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TruncateTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TypeConstructorContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.UncacheTableContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.UnquotedIdentifierContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.UnsetTablePropertiesContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.UnsupportedHiveNativeCommandsContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.UseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.ValueExpressionDefaultContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.WhenClauseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.WindowDefContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.WindowFrameContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.WindowRefContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.WindowsContext;
import com.impetus.blkch.sql.parser.LogicalPlan;

public class AbstractSyntaxTreeVisitor extends	AbstractParseTreeVisitor<LogicalPlan> implements
		SqlBaseVisitor<LogicalPlan> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractSyntaxTreeVisitor.class);

	@Override
	public LogicalPlan visitSingleStatement(SingleStatementContext ctx) {
		logger.trace("In visitSingleStatement " + ctx.getText());
		visitChildren(ctx);
		return new LogicalPlan();
	}

	@Override
	public LogicalPlan visitSingleExpression(SingleExpressionContext ctx) {
		logger.trace("In visitSingleExpression " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSingleTableIdentifier(
			SingleTableIdentifierContext ctx) {
		logger.trace("In visitSingleTableIdentifier " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSingleFunctionIdentifier(
			SingleFunctionIdentifierContext ctx) {
		logger.trace("In visitSingleFunctionIdentifier " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSingleDataType(SingleDataTypeContext ctx) {
		logger.trace("In visitSingleDataType " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitStatementDefault(StatementDefaultContext ctx) {
		logger.trace("In visitStatementDefault " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitUse(UseContext ctx) {
		logger.trace("In visitUse " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateDatabase(CreateDatabaseContext ctx) {
		logger.trace("In visitCreateDatabase " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSetDatabaseProperties(
			SetDatabasePropertiesContext ctx) {
		logger.trace("In visitSetDatabaseProperties " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDropDatabase(DropDatabaseContext ctx) {
		logger.trace("In visitDropDatabase " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateTable(CreateTableContext ctx) {
		logger.trace("In visitCreateTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateHiveTable(CreateHiveTableContext ctx) {
		logger.trace("In visitCreateHiveTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateTableLike(CreateTableLikeContext ctx) {
		logger.trace("In visitCreateTableLike " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitAnalyze(AnalyzeContext ctx) {
		logger.trace("In visitAnalyze " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitAddTableColumns(AddTableColumnsContext ctx) {
		logger.trace("In visitAddTableColumns " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRenameTable(RenameTableContext ctx) {
		logger.trace("In visitRenameTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSetTableProperties(SetTablePropertiesContext ctx) {
		logger.trace("In visitSetTableProperties " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitUnsetTableProperties(UnsetTablePropertiesContext ctx) {
		logger.trace("In visitUnsetTableProperties " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitChangeColumn(ChangeColumnContext ctx) {
		logger.trace("In visitChangeColumn " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSetTableSerDe(SetTableSerDeContext ctx) {
		logger.trace("In visitSetTableSerDe " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitAddTablePartition(AddTablePartitionContext ctx) {
		logger.trace("In visitAddTablePartition " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRenameTablePartition(RenameTablePartitionContext ctx) {
		logger.trace("In visitRenameTablePartition " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDropTablePartitions(DropTablePartitionsContext ctx) {
		logger.trace("In visitDropTablePartitions " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSetTableLocation(SetTableLocationContext ctx) {
		logger.trace("In visitSetTableLocation " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRecoverPartitions(RecoverPartitionsContext ctx) {
		logger.trace("In visitRecoverPartitions " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDropTable(DropTableContext ctx) {
		logger.trace("In visitDropTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateView(CreateViewContext ctx) {
		logger.trace("In visitCreateView " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateTempViewUsing(CreateTempViewUsingContext ctx) {
		logger.trace("In visitCreateTempViewUsing " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitAlterViewQuery(AlterViewQueryContext ctx) {
		logger.trace("In visitAlterViewQuery " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateFunction(CreateFunctionContext ctx) {
		logger.trace("In visitCreateFunction " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDropFunction(DropFunctionContext ctx) {
		logger.trace("In visitDropFunction " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitExplain(ExplainContext ctx) {
		logger.trace("In visitExplain " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowTables(ShowTablesContext ctx) {
		logger.trace("In visitShowTables " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowTable(ShowTableContext ctx) {
		logger.trace("In visitShowTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowDatabases(ShowDatabasesContext ctx) {
		logger.trace("In visitShowDatabases " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowTblProperties(ShowTblPropertiesContext ctx) {
		logger.trace("In visitShowTblProperties " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowColumns(ShowColumnsContext ctx) {
		logger.trace("In visitShowColumns " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowPartitions(ShowPartitionsContext ctx) {
		logger.trace("In visitShowPartitions " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowFunctions(ShowFunctionsContext ctx) {
		logger.trace("In visitShowFunctions " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitShowCreateTable(ShowCreateTableContext ctx) {
		logger.trace("In visitShowCreateTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDescribeFunction(DescribeFunctionContext ctx) {
		logger.trace("In visitDescribeFunction " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDescribeDatabase(DescribeDatabaseContext ctx) {
		logger.trace("In visitDescribeDatabase " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDescribeTable(DescribeTableContext ctx) {
		logger.trace("In visitDescribeTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRefreshTable(RefreshTableContext ctx) {
		logger.trace("In visitRefreshTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRefreshResource(RefreshResourceContext ctx) {
		logger.trace("In visitRefreshResource " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCacheTable(CacheTableContext ctx) {
		logger.trace("In visitCacheTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitUncacheTable(UncacheTableContext ctx) {
		logger.trace("In visitUncacheTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitClearCache(ClearCacheContext ctx) {
		logger.trace("In visitClearCache " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitLoadData(LoadDataContext ctx) {
		logger.trace("In visitLoadData " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTruncateTable(TruncateTableContext ctx) {
		logger.trace("In visitTruncateTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRepairTable(RepairTableContext ctx) {
		logger.trace("In visitRepairTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitManageResource(ManageResourceContext ctx) {
		logger.trace("In visitManageResource " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitFailNativeCommand(FailNativeCommandContext ctx) {
		logger.trace("In visitFailNativeCommand " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSetConfiguration(SetConfigurationContext ctx) {
		logger.trace("In visitSetConfiguration " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitResetConfiguration(ResetConfigurationContext ctx) {
		logger.trace("In visitResetConfiguration " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitUnsupportedHiveNativeCommands(
			UnsupportedHiveNativeCommandsContext ctx) {
		logger.trace("In visitUnsupportedHiveNativeCommands "
				+ ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateTableHeader(CreateTableHeaderContext ctx) {
		logger.trace("In visitCreateTableHeader " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitBucketSpec(BucketSpecContext ctx) {
		logger.trace("In visitBucketSpec " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSkewSpec(SkewSpecContext ctx) {
		logger.trace("In visitSkewSpec " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitLocationSpec(LocationSpecContext ctx) {
		logger.trace("In visitLocationSpec " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitQuery(QueryContext ctx) {
		logger.trace("In visitQuery " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitInsertInto(InsertIntoContext ctx) {
		logger.trace("In visitInsertInto " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitPartitionSpecLocation(
			PartitionSpecLocationContext ctx) {
		logger.trace("In visitPartitionSpecLocation " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitPartitionSpec(PartitionSpecContext ctx) {
		logger.trace("In visitPartitionSpec " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitPartitionVal(PartitionValContext ctx) {
		logger.trace("In visitPartitionVal " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDescribeFuncName(DescribeFuncNameContext ctx) {
		logger.trace("In visitDescribeFuncName " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitDescribeColName(DescribeColNameContext ctx) {
		logger.trace("In visitDescribeColName " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCtes(CtesContext ctx) {
		logger.trace("In visitCtes " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitNamedQuery(NamedQueryContext ctx) {
		logger.trace("In visitNamedQuery " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTableProvider(TableProviderContext ctx) {
		logger.trace("In visitTableProvider " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTablePropertyList(TablePropertyListContext ctx) {
		logger.trace("In visitTablePropertyList " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTableProperty(TablePropertyContext ctx) {
		logger.trace("In visitTableProperty " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTablePropertyKey(TablePropertyKeyContext ctx) {
		logger.trace("In visitTablePropertyKey " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTablePropertyValue(TablePropertyValueContext ctx) {
		logger.trace("In visitTablePropertyValue " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitConstantList(ConstantListContext ctx) {
		logger.trace("In visitConstantList " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitNestedConstantList(NestedConstantListContext ctx) {
		logger.trace("In visitNestedConstantList " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitCreateFileFormat(CreateFileFormatContext ctx) {
		logger.trace("In visitCreateFileFormat " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTableFileFormat(TableFileFormatContext ctx) {
		logger.trace("In visitTableFileFormat " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitGenericFileFormat(GenericFileFormatContext ctx) {
		logger.trace("In visitGenericFileFormat " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitStorageHandler(StorageHandlerContext ctx) {
		logger.trace("In visitStorageHandler " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitResource(ResourceContext ctx) {
		logger.trace("In visitResource " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSingleInsertQuery(SingleInsertQueryContext ctx) {
		logger.trace("In visitSingleInsertQuery " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitMultiInsertQuery(MultiInsertQueryContext ctx) {
		logger.trace("In visitMultiInsertQuery " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitQueryOrganization(QueryOrganizationContext ctx) {
		logger.trace("In visitQueryOrganization " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitMultiInsertQueryBody(MultiInsertQueryBodyContext ctx) {
		logger.trace("In visitMultiInsertQueryBody " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitQueryTermDefault(QueryTermDefaultContext ctx) {
		logger.trace("In visitQueryTermDefault " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitSetOperation(SetOperationContext ctx) {
		logger.trace("In visitSetOperation " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitQueryPrimaryDefault(QueryPrimaryDefaultContext ctx) {
		logger.trace("In visitQueryPrimaryDefault " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTable(TableContext ctx) {
		logger.trace("In visitTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitInlineTableDefault1(InlineTableDefault1Context ctx) {
		logger.trace("In visitInlineTableDefault1 " + ctx.getText());
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
	public LogicalPlan visitHint(HintContext ctx) {
		logger.trace("In visitHint " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitHintStatement(HintStatementContext ctx) {
		logger.trace("In visitHintStatement " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitFromClause(FromClauseContext ctx) {
		logger.trace("In visitFromClause " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitAggregation(AggregationContext ctx) {
		logger.trace("In visitAggregation " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitGroupingSet(GroupingSetContext ctx) {
		logger.trace("In visitGroupingSet " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitLateralView(LateralViewContext ctx) {
		logger.trace("In visitLateralView " + ctx.getText());
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
	public LogicalPlan visitSample(SampleContext ctx) {
		logger.trace("In visitSample " + ctx.getText());
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
	public LogicalPlan visitOrderedIdentifierList(
			OrderedIdentifierListContext ctx) {
		logger.trace("In visitOrderedIdentifierList " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitOrderedIdentifier(OrderedIdentifierContext ctx) {
		logger.trace("In visitOrderedIdentifier " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitIdentifierCommentList(
			IdentifierCommentListContext ctx) {
		logger.trace("In visitIdentifierCommentList " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitIdentifierComment(IdentifierCommentContext ctx) {
		logger.trace("In visitIdentifierComment " + ctx.getText());
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
	public LogicalPlan visitInlineTableDefault2(InlineTableDefault2Context ctx) {
		logger.trace("In visitInlineTableDefault2 " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTableValuedFunction(TableValuedFunctionContext ctx) {
		logger.trace("In visitTableValuedFunction " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitInlineTable(InlineTableContext ctx) {
		logger.trace("In visitInlineTable " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRowFormatSerde(RowFormatSerdeContext ctx) {
		logger.trace("In visitRowFormatSerde " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitRowFormatDelimited(RowFormatDelimitedContext ctx) {
		logger.trace("In visitRowFormatDelimited " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitTableIdentifier(TableIdentifierContext ctx) {
		logger.trace("In visitTableIdentifier " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitFunctionIdentifier(FunctionIdentifierContext ctx) {
		logger.trace("In visitFunctionIdentifier " + ctx.getText());
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
	public LogicalPlan visitExists(ExistsContext ctx) {
		logger.trace("In visitExists " + ctx.getText());
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
	public LogicalPlan visitValueExpressionDefault(
			ValueExpressionDefaultContext ctx) {
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
	public LogicalPlan visitParenthesizedExpression(
			ParenthesizedExpressionContext ctx) {
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
	public LogicalPlan visitColPosition(ColPositionContext ctx) {
		logger.trace("In visitColPosition " + ctx.getText());
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
	public LogicalPlan visitColTypeList(ColTypeListContext ctx) {
		logger.trace("In visitColTypeList " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitColType(ColTypeContext ctx) {
		logger.trace("In visitColType " + ctx.getText());
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
	public LogicalPlan visitWindows(WindowsContext ctx) {
		logger.trace("In visitWindows " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitNamedWindow(NamedWindowContext ctx) {
		logger.trace("In visitNamedWindow " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitWindowRef(WindowRefContext ctx) {
		logger.trace("In visitWindowRef " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitWindowDef(WindowDefContext ctx) {
		logger.trace("In visitWindowDef " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitWindowFrame(WindowFrameContext ctx) {
		logger.trace("In visitWindowFrame " + ctx.getText());
		return visitChildren(ctx);

	}

	@Override
	public LogicalPlan visitFrameBound(FrameBoundContext ctx) {
		logger.trace("In visitFrameBound " + ctx.getText());
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
	public LogicalPlan visitQuotedIdentifierAlternative(
			QuotedIdentifierAlternativeContext ctx) {
		logger.trace("In visitQuotedIdentifierAlternative "
				+ ctx.getText());
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

}
