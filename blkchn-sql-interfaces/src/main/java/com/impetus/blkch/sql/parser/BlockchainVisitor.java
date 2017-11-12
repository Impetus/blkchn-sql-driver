package com.impetus.blkch.sql.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.sql.generated.SqlBaseParser.ColumnReferenceContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.FromClauseContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.NamedExpressionSeqContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.QuerySpecificationContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.SingleStatementContext;
import com.impetus.blkch.sql.generated.SqlBaseParser.TableIdentifierContext;
import com.impetus.blkch.sql.query.FromItem;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.SelectItem;
import com.impetus.blkch.sql.schema.Column;
import com.impetus.blkch.sql.schema.Table;

public class BlockchainVisitor extends AbstractSyntaxTreeVisitor{

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
		logger.trace("In visitQuerySpecification " + ctx.getText());
		SelectItem selectItem = new SelectItem(SelectItem.DESCRIPTION);
		logicalPlan.getCurrentNode().addChildNode(selectItem);
		logicalPlan.setCurrentNode(selectItem);
		return visitChildrenAndResetNode(ctx);
	}
	
	@Override
	public LogicalPlan visitColumnReference(ColumnReferenceContext ctx) {
		logger.trace("In visitColumnReference " + ctx.getText());
		Column column = new Column(ctx.getText());
		logicalPlan.getCurrentNode().addChildNode(column);
		return visitChildren(ctx);
	}
	
	
	@Override
	public LogicalPlan visitFromClause(FromClauseContext ctx) {
		logger.trace("In visitFromClause " + ctx.getText());
		FromItem fromItem = new FromItem(ctx.getText());
		logicalPlan.getCurrentNode().addChildNode(fromItem);
		logicalPlan.setCurrentNode(fromItem);
		return visitChildrenAndResetNode(ctx);
	}

	@Override
	public LogicalPlan visitTableIdentifier(TableIdentifierContext ctx) {
		logger.trace("In visitTableIdentifier " + ctx.getText());
		Table table = new Table(ctx.getText());
		logicalPlan.getCurrentNode().addChildNode(table);
		return visitChildren(ctx);
	}
	
	
	@Override
	public  LogicalPlan defaultResult() {
		return logicalPlan;
	}
	
	/*
	 * If you call logicalPlan.setCurrentNode(node);
	 * then call this method so that node pointer can be reset to parent after visiting children.
	 * Note that this will happen recursively for each level of tree.
	 * If you are not setting current node and just creating and adding nodes to parent call visitChildren directly.
	 */
	public LogicalPlan visitChildrenAndResetNode(RuleNode node) {
		try{
			return visitChildren(node);
		}finally{
			logicalPlan.setCurrentNode(logicalPlan.getCurrentNode().getParent());
		}
	}
}
