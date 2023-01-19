/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.services;

import java.util.HashMap;
import java.util.Optional;

import org.eclipse.eef.core.api.EEFPage;
import org.eclipse.eef.ide.ui.properties.api.EEFTabDescriptor;
import org.eclipse.eef.properties.ui.api.EEFTabContents;
import org.eclipse.eef.properties.ui.api.EEFTabbedPropertySheetPage;
import org.eclipse.eef.properties.ui.api.IEEFTabDescriptor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertySheet;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.spec.ColumnSpec;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.utils.common.IntrospectionUtils;

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
	
	/**
	 * Force the refresh of the Properties view if the "Column Page" is active. Do nothing otherwise.
	 * 
	 * @param self an EObject
	 * @return self
	 */
	public EObject forceRefresh(EObject self) {
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IWorkbenchPart part = page.getActivePart();
		
		if(part instanceof PropertySheet) {
			PropertySheet sheet = (PropertySheet) part;
			if(sheet.getCurrentPage() instanceof EEFTabbedPropertySheetPage) {
				EEFTabbedPropertySheetPage currentPage = (EEFTabbedPropertySheetPage) sheet.getCurrentPage();
				// Warning: we use reflection here because we are limited be the EEF API.
				HashMap<IEEFTabDescriptor, EEFTabContents> descriptorToTab = IntrospectionUtils.getFieldValue(currentPage, "descriptorToTab", HashMap.class);
	            Optional<EEFTabDescriptor> tabDescriptor = descriptorToTab.keySet().stream()
	            		.filter(tab -> tab.getId().startsWith("Column PageColumn"))
	            		.filter(EEFTabDescriptor.class::isInstance)
	            		.map(tab -> (EEFTabDescriptor) tab)
	            		.findFirst();
	            if(tabDescriptor.isPresent()) {
	            	// Warning: we use reflection here because we are limited be the EEF API.
	            	EEFPage eefPage = IntrospectionUtils.getFieldValue(tabDescriptor.get(), "eefPage", EEFPage.class);
	            	// We change the page identifier to fool EEF and trigger the tab recreation.
	            	// See {@link EEFTabbedPropertySheetPage.updateTabs(List<IEEFTabDescriptor> descriptors)}
	            	eefPage.getDescription().setIdentifier(eefPage.getDescription().getIdentifier()+System.currentTimeMillis());
	            }
			}
		}
		
		return self;
	}
	
}
