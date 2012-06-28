/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.services.label;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.util.DatabaseSwitch;
import org.obeonetwork.dsl.typeslibrary.provider.TypesLibraryItemProviderAdapterFactory;

public class DatabaseLabelServices extends DatabaseSwitch<String>{
	
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new TypesLibraryItemProviderAdapterFactory());

	public String getDatabaseElementLabel(DatabaseElement element) {
		return doSwitch(element);
	}

	@Override
	public String caseColumn(Column column) {
		String label = caseNamedElement(column);
		label += " : ";
		String typeLabel = "undefined";
		if (column.getType() != null) {
			typeLabel = adapterFactoryLabelProvider.getText(column.getType());
		}
		
		label += typeLabel;
		return label;
	}

	@Override
	public String caseNamedElement(NamedElement namedElement) {
		return namedElement.getName();
	}
	
	
}
