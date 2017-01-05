/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen.services;

import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
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
}
