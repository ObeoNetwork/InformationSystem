package org.obeonetwork.dsl.database.view.parser;


public class ColObject {
	
	private String name;
	private String table;
	private String alias;

	ColObject(String name, String table, String alias){
		this.name = name;
		this.table = table;
		this.alias = alias;
	}
	ColObject(String name, String table){
		this.name = name;
		this.table = table;
		this.alias = "";
	}
	ColObject(String name){
		this.name = name;
		this.table = "";
		this.alias = "";
	}
	public String getName(){
		return name;
	}
	public String getTable(){
		return table;
	}
	public String getAlias(){
		return alias;
	}
}
