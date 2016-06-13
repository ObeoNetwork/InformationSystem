/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.view.parser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.jsqlparser.expression.AllComparisonExpression;
import net.sf.jsqlparser.expression.AnyComparisonExpression;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.CaseExpression;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.InverseExpression;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.TimeValue;
import net.sf.jsqlparser.expression.TimestampValue;
import net.sf.jsqlparser.expression.WhenClause;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseXor;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.expression.operators.arithmetic.Division;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.arithmetic.Subtraction;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.ItemsListVisitor;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.Matches;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.FromItemVisitor;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SelectItemVisitor;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.statement.select.SubJoin;
import net.sf.jsqlparser.statement.select.SubSelect;
import net.sf.jsqlparser.statement.select.Union;


public class ViewContentFinder implements SelectVisitor, FromItemVisitor, ExpressionVisitor, ItemsListVisitor, SelectItemVisitor{
	// List of tables
	private List<Table> tables = new ArrayList<Table>();

	// Map of object ColObject with (name, table, alias)
	private List<ColObject> columns = new ArrayList<ColObject>();

	private String alias="";


	public void parseView(Select select){
		select.getSelectBody().accept(this);
	}

	public List<Table> getTables(){
		return tables;
	}
	public  List<ColObject> getColumns(){
		return columns;
	}

	public void visit(PlainSelect plainSelect) {

		// Compute from 
		plainSelect.getFromItem().accept(this);
		if (plainSelect.getJoins() != null) {
			for (Iterator<?> joinsIt = plainSelect.getJoins().iterator(); joinsIt.hasNext();) {
				Join join = (Join) joinsIt.next();
				join.getRightItem().accept(this);
			}
		}
		
		// Compute select items
		List<SelectItem> selectList = plainSelect.getSelectItems();
		for (SelectItem sel : selectList){
			alias ="";
			sel.accept(this);
		}
	}

	public void visit(Union union) {
		for (Iterator<?> iter = union.getPlainSelects().iterator(); iter.hasNext();) {
			PlainSelect plainSelect = (PlainSelect) iter.next();
			visit(plainSelect);
		}
	}

	// FromItemVisitor methods
		public void visit(Table tableName) {
		tables.add(tableName);
	}

	public void visit(SubSelect subSelect) {
		subSelect.getSelectBody().accept(this);
	}

	public void visit(SubJoin subjoin) {
		subjoin.getLeft().accept(this);
		subjoin.getJoin().getRightItem().accept(this);
	}

	// Expression visitor methods
	public void visit(NullValue nullValue) {
		// nothing to do
	}

	public void visit(Function function) {
		String parameters ="";
		boolean first=true;
		for (Object param : function.getParameters().getExpressions()){
			if (first == true){
				parameters+= param.toString();
				first = false;
			}else{
				parameters+=", "+ param.toString();
			}
		}
		ColObject col = new ColObject(function.getName()+"("+parameters+")", "", alias);
		columns.add(col);
	}

	public void visit(InverseExpression inverseExpression) {
		inverseExpression.getExpression().accept(this);
	}

	public void visit(JdbcParameter jdbcParameter) {
		// nothing to do
	}

	public void visit(DoubleValue doubleValue) {
		// nothing to do
	}

	public void visit(LongValue longValue) {
		// nothing to do
	}

	public void visit(DateValue dateValue) {
		// nothing to do
	}

	public void visit(TimeValue timeValue) {
		// nothing to do

	}

	public void visit(TimestampValue timestampValue) {
		// nothing to do
	}

	public void visit(Parenthesis parenthesis) {
		parenthesis.getExpression().accept(this);
	}

	public void visit(StringValue stringValue) {
		// nothing to do
	}

	public void visit(Addition addition) {
		visitBinaryExpression(addition);
	}

	public void visit(Division division) {
		visitBinaryExpression(division);
	}

	public void visit(Multiplication multiplication) {
		visitBinaryExpression(multiplication);
	}

	public void visit(Subtraction subtraction) {
		visitBinaryExpression(subtraction);
	}

	public void visit(AndExpression andExpression) {
		visitBinaryExpression(andExpression);
	}

	public void visit(OrExpression orExpression) {
		visitBinaryExpression(orExpression);
	}

	public void visit(Between between) {
		between.getLeftExpression().accept(this);
		between.getBetweenExpressionStart().accept(this);
		between.getBetweenExpressionEnd().accept(this);
	}

	public void visit(EqualsTo equalsTo) {
		visitBinaryExpression(equalsTo);
	}

	public void visit(GreaterThan greaterThan) {
		visitBinaryExpression(greaterThan);
	}

	public void visit(GreaterThanEquals greaterThanEquals) {
		visitBinaryExpression(greaterThanEquals);
	}

	public void visit(InExpression inExpression) {
		inExpression.getLeftExpression().accept(this);
		inExpression.getItemsList().accept(this);
	}

	public void visit(IsNullExpression isNullExpression) {
		// nothing to do
	}

	public void visit(LikeExpression likeExpression) {
		visitBinaryExpression(likeExpression);
	}

	public void visit(MinorThan minorThan) {
		visitBinaryExpression(minorThan);
	}

	public void visit(MinorThanEquals minorThanEquals) {
		visitBinaryExpression(minorThanEquals);
	}

	public void visit(NotEqualsTo notEqualsTo) {
		visitBinaryExpression(notEqualsTo);
	}

	public void visit(Column tableColumn) {
		// Check alias is not null
		if (alias == null){
			alias = "";
		}
		// Before to add a table we have to check table is not already present table name may be an alias.
		boolean alreadyPresentTable = false;
		for (Table table : tables){
			if (table.getAlias()!=null && tableColumn.getTable() != null 
					&& (table.getAlias().equals(tableColumn.getTable().getName()))){
				alreadyPresentTable = true;
			}else if (tableColumn.getTable() != null &&table.getName().equals(tableColumn.getTable().getName())) {
				alreadyPresentTable = true;
			}else if (tableColumn.getTable() != null && tableColumn.getTable().getName() == null){
				alreadyPresentTable = true;
			}
		}
		if (!alreadyPresentTable){
			tables.add(tableColumn.getTable());
		}
		
		ColObject col = new ColObject(tableColumn.getColumnName(),
				tableColumn.getTable().getName(), alias);
		columns.add(col);
	}

	public void visit(CaseExpression caseExpression) {
		// nothing to do
	}

	public void visit(WhenClause whenClause) {
		// nothing to do
	}

	public void visit(ExistsExpression existsExpression) {
		existsExpression.getRightExpression().accept(this);
	}

	public void visit(AllComparisonExpression allComparisonExpression) {
		allComparisonExpression.GetSubSelect().getSelectBody().accept(this);
	}

	public void visit(AnyComparisonExpression anyComparisonExpression) {
		anyComparisonExpression.GetSubSelect().getSelectBody().accept(this);
	}

	public void visit(Concat concat) {
		// nothing to do
	}

	public void visit(Matches matches) {
		// nothing to do
	}

	public void visit(BitwiseAnd bitwiseAnd) {
		// nothing to do
	}

	public void visit(BitwiseOr bitwiseOr) {
		// nothing to do
	}

	public void visit(BitwiseXor bitwiseXor) {
		// nothing to do
	}

	public void visitBinaryExpression(BinaryExpression binaryExpression) {
		binaryExpression.getLeftExpression().accept(this);
		binaryExpression.getRightExpression().accept(this);
	}


	// ItemListVisitor methods
	public void visit(ExpressionList expressionList) {
		for (Iterator iter = expressionList.getExpressions().iterator(); iter.hasNext();) {
			Expression expression = (Expression) iter.next();
			expression.accept(this);
		}
	}


	// SelectItemVisitor methods
	public void visit(AllColumns arg0) {
		ColObject col = new ColObject("*","", alias);
		columns.add(col);
	}

	public void visit(AllTableColumns allTableColumns) {
		ColObject col = new ColObject("*", allTableColumns.getTable().getName(), alias);
		// Before to add a table we have to check table is not already present table name may be an alias.
				boolean alreadyPresentTable = false;
				for (Table table : tables){
					if (table.getAlias()!=null && allTableColumns.getTable() != null 
							&& (table.getAlias().equals(allTableColumns.getTable().getName()))){
						alreadyPresentTable = true;
					}else if (allTableColumns.getTable() != null &&table.getName().equals(allTableColumns.getTable().getName())) {
						alreadyPresentTable = true;
					}else if (allTableColumns.getTable() != null && allTableColumns.getTable().getName() == null){
						alreadyPresentTable = true;
					}
				}
				if (!alreadyPresentTable){
					tables.add(allTableColumns.getTable());
				}
		columns.add(col);
	}

	public void visit(SelectExpressionItem selectExpressionItem) {
		alias= selectExpressionItem.getAlias();
		selectExpressionItem.getExpression().accept(this);
	}
}
