/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.query;

import java.util.ArrayList;
import java.util.List;

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;


public class ForeignKeyQuery {
	private ForeignKey fk;

	public ForeignKeyQuery(ForeignKey fk) {
		this.fk = fk;
	}
	
	/**
	 * Returns all FK columns
	 * @return
	 */
	public List<Column> getFKColumns() {
		List<Column> columns = new ArrayList<Column>();
		for (ForeignKeyElement element : fk.getElements()) {
			columns.add(element.getFkColumn());
		}
		return columns;
	}
	
	/**
	 * Returns all PK columns
	 * @return
	 */
	public List<Column> getPKColumns() {
		List<Column> columns = new ArrayList<Column>();
		for (ForeignKeyElement element : fk.getElements()) {
			columns.add(element.getPkColumn());
		}
		return columns;
	}
}
