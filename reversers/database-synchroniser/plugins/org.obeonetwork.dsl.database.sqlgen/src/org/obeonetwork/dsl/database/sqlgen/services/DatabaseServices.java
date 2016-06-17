package org.obeonetwork.dsl.database.sqlgen.services;

import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.query.IndexQuery;

public class DatabaseServices {

	public boolean isIndexForForeignKey(Index index) {
		ForeignKey associatedForeignKey = new IndexQuery(index).getAssociatedForeignKey();
		return associatedForeignKey != null;
	}
}
