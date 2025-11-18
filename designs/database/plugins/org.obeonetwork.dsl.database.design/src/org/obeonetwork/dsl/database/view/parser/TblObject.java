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

public class TblObject {

	private String name;
	private String alias;

	TblObject(String name, String alias){
		this.name = name;
		this.alias = alias;
	}

	TblObject(String name){
		this.name = name;
		this.alias = "";
	}

	public String getName(){
		return name;
	}

	public String getAlias(){
		return alias;
	}

}
