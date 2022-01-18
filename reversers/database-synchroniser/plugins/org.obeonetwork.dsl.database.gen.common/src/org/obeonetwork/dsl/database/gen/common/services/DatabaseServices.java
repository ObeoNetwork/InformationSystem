/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.gen.common.services;

import java.util.ArrayList;
import java.util.Collection;

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.query.IndexQuery;

public class DatabaseServices {

	public boolean isIndexForForeignKey(Index index) {
		ForeignKey associatedForeignKey = new IndexQuery(index).getAssociatedForeignKey();
		return associatedForeignKey != null;
	}
	
	public String getViewQuery(View view) {
		String query = view.getQuery();
		if (query != null && !query.endsWith(";")) {
			query += ";";
		}
		return query;
	}
	
	public boolean isIndexOnPKColumns(Index index) {
		PrimaryKey pk = index.getOwner().getPrimaryKey();
		
		// if there is no PK on table, the result is simple
		if (pk != null) {
			// else we have to compare the columns list
			Collection<Column> indexColumns = new ArrayList<Column>();
			for (IndexElement indexElt : index.getElements()) {
				Column indexColumn = indexElt.getColumn();
				if (indexColumn != null) {
					indexColumns.add(indexColumn);				
				} else {
					// Index is invalid
					return false;
				}
			}
			
			// Same number of columns ?
			if (pk.getColumns().size() == indexColumns.size()) {
				for (Column pkColumn : pk.getColumns()) {
					if (!indexColumns.remove(pkColumn)) {
						// the column was not in the list
						return false;
					}
				}
				
				// If we get there, this condition should always be true
				// let's be sure anyway
				if (indexColumns.isEmpty()) {
					return true;					
				}
			}
		}
		
		return false;
	}
}
