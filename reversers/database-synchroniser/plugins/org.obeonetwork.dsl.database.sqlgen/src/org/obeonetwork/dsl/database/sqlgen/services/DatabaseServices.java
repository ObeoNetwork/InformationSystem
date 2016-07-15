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
