/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.spec.ColumnSpec;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

public class DatabaseEEFPropertiesServices {

	public boolean typeInstanceLengthFeatureIsVisible(TypeInstance self, EStructuralFeature feature) {
		boolean isVisible = TypesLibraryPackage.Literals.TYPE_INSTANCE__LENGTH.getName().equals(feature.getName());
		if (isVisible && self.getNativeType() != null && self.getNativeType().getSpec() != null) {
			NativeTypeKind nativeTypeKind = self.getNativeType().getSpec();
			isVisible = nativeTypeKind == NativeTypeKind.LENGTH || nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION;
		}
		return isVisible;
	}
	
	public boolean typeInstancePrecisionFeatureIsVisible(TypeInstance self, EStructuralFeature feature) {
		boolean isVisible = TypesLibraryPackage.Literals.TYPE_INSTANCE__PRECISION.getName().equals(feature.getName());
		if (isVisible && self.getNativeType() != null && self.getNativeType().getSpec() != null) {
			NativeTypeKind nativeTypeKind = self.getNativeType().getSpec();
			isVisible = nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION;
		}
		return isVisible;
	}
	
	public boolean typeInstanceLiteralsFeatureIsVisible(TypeInstance self, EStructuralFeature feature) {
		boolean isVisible = TypesLibraryPackage.Literals.TYPE_INSTANCE__LITERALS.getName().equals(feature.getName());
		if (isVisible && self.getNativeType() != null && self.getNativeType().getSpec() != null) {
			NativeTypeKind nativeTypeKind = self.getNativeType().getSpec();
			isVisible = nativeTypeKind == NativeTypeKind.ENUM;
		}
		return isVisible;
	}
	
	public void updatePrimaryKey(ColumnSpec column, Boolean newValue) {
		if (newValue) {
			column.addToPrimaryKey();
		} else {
			column.removeFromPrimaryKey();
		}
	}
	
	public void updateIndexes(ColumnSpec column, Boolean newValue) {
		if (newValue) {
			column.addToUniqueIndex();
		} else {
			column.removeFromUniqueIndex();
		}
	}
	
	public PrimaryKey getPrimaryKey(EObject object) {
		if (object instanceof Table) {
			return ((Table) object).getPrimaryKey();
		} else if (object instanceof PrimaryKey) {
			return (PrimaryKey) object;
		}
		return null;
	}
	
	public PrimaryKey getPrimaryKey(PrimaryKey primaryKey) {
		return primaryKey;
	}
	
}
