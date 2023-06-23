/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.IFilter;
import org.obeonetwork.dsl.database.Table;


/**
 * Class used to filter properties view
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 */
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