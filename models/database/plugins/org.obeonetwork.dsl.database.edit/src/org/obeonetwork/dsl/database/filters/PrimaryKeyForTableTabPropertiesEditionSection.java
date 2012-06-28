package org.obeonetwork.dsl.database.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.IFilter;
import org.obeonetwork.dsl.database.Table;

public class PrimaryKeyForTableTabPropertiesEditionSection  implements IFilter {

	
	public boolean select(Object toTest) {
		EObject eObj = EEFUtils.resolveSemanticObject(toTest);
		if (eObj != null) {
			if (eObj instanceof Table) { 
				// Check if there is a PK
				Table table = (Table)eObj;
				return (table.getPrimaryKey() != null);
			}
		}
		return false;
	}
}