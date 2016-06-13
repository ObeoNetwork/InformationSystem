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
package org.obeonetwork.dsl.entityrelation.design.services.label;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.LogicalElement;
import org.obeonetwork.dsl.entityrelation.NamedElement;
import org.obeonetwork.dsl.entityrelation.util.EntityRelationSwitch;
import org.obeonetwork.dsl.typeslibrary.provider.TypesLibraryItemProviderAdapterFactory;

public class EntityRelationLabelServices extends EntityRelationSwitch<String>{
	
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new TypesLibraryItemProviderAdapterFactory());

	public String getLogicalElementLabel(LogicalElement element) {
		return doSwitch(element);
	}

//	@Override
//	public String caseColumn(Column column) {
//		String label = caseNamedElement(column);
//		label += " : ";
//		String typeLabel = "undefined";
//		if (column.getType() != null) {
//			typeLabel = adapterFactoryLabelProvider.getText(column.getType());
//		}
//		
//		label += typeLabel;
//		return label;
//	}
	
	

	@Override
	public String caseNamedElement(NamedElement namedElement) {
		return namedElement.getName();
	}

	@Override
	public String caseAttribute(Attribute object) {
		String label = caseNamedElement(object);
		label += " : ";
		String typeLabel = "undefined";
		if (object.getType() != null) {
			typeLabel = adapterFactoryLabelProvider.getText(object.getType());
		}
		
		label += typeLabel;
		return label;
	}
	
	
}
