/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.components;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

/**
 * Custom class to bypass EEF limitations
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class CustomColumnPropertiesEditionComponent extends ColumnPropertiesEditionComponent {

	public CustomColumnPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject column, String editing_mode) {
		super(editingContext, column, editing_mode);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		super.initPart(key, kind, elt, allResource);
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			final ColumnPropertiesEditionPart basePart = (ColumnPropertiesEditionPart)editingPart;
			updateTypeFieldsVisibility((Column)elt, basePart);
		}
		setInitializing(false);
	}

	@Override
	public void updateSemanticModel(IPropertiesEditionEvent event) {
		Column columnObject = (Column)semanticObject;
		
		if (DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey == event.getAffectedEditor()) {
			if (Boolean.TRUE.equals(event.getNewValue())) {
				columnObject.addToPrimaryKey();
			} else {
				columnObject.removeFromPrimaryKey();
			}
		}
		if (DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique == event.getAffectedEditor()) {
			if (Boolean.TRUE.equals(event.getNewValue())) {
				columnObject.addToUniqueIndex();
			} else {
				columnObject.removeFromUniqueIndex();
			}
		}
		super.updateSemanticModel(event);
	}

	@Override
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ColumnPropertiesEditionPart basePart = (ColumnPropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType().equals((msg.getFeature()))) {
				updateTypeFieldsVisibility((Column)semanticObject, basePart);
			}
		}
	}
	
	private void updateTypeFieldsVisibility(Column column, ColumnPropertiesEditionPart basePart) {
		if (column.getType() instanceof TypeInstance) {
			TypeInstance typeInstance = (TypeInstance)column.getType();
			if (typeInstance.getNativeType() != null) {
				NativeTypeKind nativeTypeKind = typeInstance.getNativeType().getSpec();
				boolean lengthVisible = (nativeTypeKind == NativeTypeKind.LENGTH || nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION);
				boolean precisionVisible = (nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION);
				boolean literalsVisible = (nativeTypeKind == NativeTypeKind.ENUM);
				basePart.updateTypeFields(lengthVisible, precisionVisible, literalsVisible);
			}
		}		
	}
}
