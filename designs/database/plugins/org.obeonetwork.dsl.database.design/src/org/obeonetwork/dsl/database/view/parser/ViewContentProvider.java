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

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

public class ViewContentProvider {

	private List<TblObject> tables;
	private List<ColObject> columns;
	/**
	 * Constructor;
	 */
	 public ViewContentProvider (){
		 tables = new ArrayList<TblObject>();
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

				tables = viewContentFinder.getTables();
				columns= viewContentFinder.getColumns();
			}
		} catch (JSQLParserException e) {
			// nothing to do
		}
	}
	
	public List<TblObject> getTables(){
		return tables;
	}
	
	public  List<ColObject> getColumns(){
		return columns;
	}
	
}
