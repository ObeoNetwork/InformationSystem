/**
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.database.query;

import java.util.ArrayList;
import java.util.List;

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;

public class IndexQuery {
	private Index index;

	public IndexQuery(Index index) {
		this.index = index;
	}
	
	/**
	 * Return all columns associated with the index
	 * @return
	 */
	public List<Column> getColumns() {
		List<Column> columns = new ArrayList<Column>();
		for (IndexElement element : index.getElements()) {
			columns.add(element.getColumn());
		}
		return columns;
	}
	
	/**
	 * Return the foreign key associated with the index if there is one
	 * @return
	 */
	public ForeignKey getAssociatedForeignKey() {
		List<Column> columns = getColumns(); 
		if (columns.isEmpty()) {
			return null;
		}
		
		for (Column column : columns) {
			// Let's consider the first non-null column
			if (column != null) {
				// Check if one the foreign keys contains all columns
				for (ForeignKey fk : column.getForeignKeys()) {
					List<Column> fkColumns = new ForeignKeyQuery(fk).getFKColumns();
					if (fkColumns.containsAll(columns)
							&& columns.containsAll(fkColumns)) {
						return fk;
					}
				}				
			}
		}

		return null;
	}
}
