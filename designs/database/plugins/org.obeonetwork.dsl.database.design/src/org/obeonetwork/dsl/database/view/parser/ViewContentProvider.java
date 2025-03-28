/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.view.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.ViewColumn;
import org.obeonetwork.dsl.database.ViewTable;
import org.obeonetwork.utils.common.StringUtils;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

public class ViewContentProvider {

	private List<ViewTable> tables = null;
	private List<ViewColumn> columns = null;

	/**
	 * Parse the query to find tables and columns used for the view.
	 * @param query
	 */
	public void parseViewQuery(String query) {
		Statement statement;
		CCJSqlParserManager pm = new CCJSqlParserManager();
		try {
			statement = pm.parse(new StringReader(query));
			if (statement instanceof Select) {
				Select selectStatement = (Select)statement;
				ViewContentFinder viewContentFinder = new ViewContentFinder();
				viewContentFinder.parseView(selectStatement);

				tables = new ArrayList<>();
				for (Table table : viewContentFinder.getTables()) {
					ViewTable viewTable = DatabaseFactory.eINSTANCE.createViewTable();
					viewTable.setName(getFullTableName(table));
					viewTable.setAlias(table.getAlias());
					tables.add(viewTable);
				}
				
				columns= new ArrayList<>();
				for(ColObject col : viewContentFinder.getColumns()) {
					ViewColumn viewColumn = DatabaseFactory.eINSTANCE.createViewColumn();
					viewColumn.setAlias(col.getAlias());
					viewColumn.setName(col.getName());
					// TODO Already handled by DatabaseServices.computeViewTableFromViewColumn(ViewColumn)
					viewColumn.setFrom(getViewTable(col.getTable()));
				}
			}
		} catch (JSQLParserException e) {
			// nothing to do
		}
	}
	
	private ViewTable getViewTable(String tableName) {
		ViewTable viewTable = null;
		viewTable = tables.stream().filter(t -> tableName.equalsIgnoreCase(t.getAlias())).findFirst().orElse(null);
		
		if(viewTable == null) {
			viewTable = tables.stream().filter(t -> tableName.equalsIgnoreCase(t.getName())).findFirst().orElse(null);
		}
		
		if(viewTable == null) {
			viewTable = tables.stream()
					.filter(t -> t.getName().contains("."))
					.filter(t -> tableName.equalsIgnoreCase(t.getName().split("\\.")[1])).findFirst().orElse(null);
		}
		
		return viewTable;
	}

	private String getFullTableName(Table table) {
		String fullTableName;
		if(!StringUtils.isNullOrWhite(table.getSchemaName())) {
			fullTableName = table.getSchemaName() + "." + table.getName();
		} else {
			fullTableName = table.getName();
		}
		return fullTableName;
	}
	
	public List<ViewTable> getTables(){
		return tables;
	}
	
	public  List<ViewColumn> getColumns(){
		return columns;
	}
}
