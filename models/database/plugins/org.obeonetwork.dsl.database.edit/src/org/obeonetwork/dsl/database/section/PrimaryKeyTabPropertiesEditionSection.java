package org.obeonetwork.dsl.database.section;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.Table;

public class PrimaryKeyTabPropertiesEditionSection extends AbstractDatabasePropertiesEditionSection {

	 
	public boolean select(Object toTest) {
		EObject eObj = resolveSemanticObject(toTest);
		if (eObj != null && eObj instanceof Table) {
			// Check if there is a PK
			Table table = (Table)eObj;
			if (table.getPrimaryKey() != null) {
				return getProvider(eObj) != null;
			}
		}
		return false;
	}
}
