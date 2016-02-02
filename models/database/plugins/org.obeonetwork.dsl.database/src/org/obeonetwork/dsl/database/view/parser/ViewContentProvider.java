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
	
	 public ViewContentProvider (){
		 tables = new ArrayList<String>();
		 columns = new ArrayList<ColObject>();
	 }

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
	
	public List<String> getTables(){
		return tables;
	}
	public  List<ColObject> getColumns(){
		return columns;
	}
}
