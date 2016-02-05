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

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

public class ViewContentProvider {

	private List<String> tables;
	private List<ColObject> columns;
	/**
	 * Constructor;
	 */
	 public ViewContentProvider (){
		 tables = new ArrayList<String>();
		 columns = new ArrayList<ColObject>();
	 }

	/**
	 * Parse the query to find tables and columns used for the view.
	 * @param query
	 */
	public void parseViewQuery(String query){
		Statement statement;
		CCJSqlParserManager pm = new CCJSqlParserManager();
		try {
			statement = pm.parse(new StringReader(query));
			if (statement instanceof Select) {
				Select selectStatement = (Select)statement;
				ViewContentFinder viewContentFinder = new ViewContentFinder();
				viewContentFinder.parseView(selectStatement);

				for (Table table : viewContentFinder.getTables()){
					tables.add(
							table.getName());
				}
				columns= viewContentFinder.getColumns();
			}
		} catch (JSQLParserException e) {
			// nothing to do
		}
	}
	
	/**
	 * Get list of tables.
	 * @return list of table names.
	 */
	public List<String> getTables(){
		return tables;
	}
	
	/**
	 * Get list of Columns.
	 * @return list of columns objects.
	 */
	public  List<ColObject> getColumns(){
		return columns;
	}
}
