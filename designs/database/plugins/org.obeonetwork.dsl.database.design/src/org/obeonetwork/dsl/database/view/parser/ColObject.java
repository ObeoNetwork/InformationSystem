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
	/**
	 * Get name of the column.
	 * @return name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Get table of the column.
	 * @return table name
	 */
	public String getTable(){
		return table;
	}
	
	/**
	 * Get alias of the column.
	 * @return alias
	 */
	public String getAlias(){
		return alias;
	}
}
