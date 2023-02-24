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
package org.obeonetwork.tools.migration;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class XMIResourceWithMigrationSupportImpl extends XMIResourceImpl {
	
	private IMigrationHelper migrationHelper = null;
	
	public XMIResourceWithMigrationSupportImpl(URI uri) {
		super(uri);
	}

	public void attachMigrationHelper(IMigrationHelper migrationHelper) {
		this.migrationHelper = migrationHelper;
		
		ExtendedMetaData extendedMetadata = migrationHelper.getExtendedMetaData();
		XMLResource.ResourceHandler resourceHandler = migrationHelper.getResourceHandler();
		
		Map<Object, Object> loadOptions = getDefaultLoadOptions();
		Map<Object, Object> saveOptions = getDefaultSaveOptions();
		
		loadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		
		if (extendedMetadata != null) {
			saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetadata);
			loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetadata);
		}

		if (resourceHandler != null) {
			saveOptions.put(XMLResource.OPTION_RESOURCE_HANDLER, resourceHandler);
			loadOptions.put(XMLResource.OPTION_RESOURCE_HANDLER, resourceHandler);
		}
		
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		if (migrationHelper != null && migrationHelper.isMigrationNeeded()) {
			EObject eObject = migrationHelper.getEObject(uriFragment);
			if (eObject != null) {
				return eObject;
			}
		}
		return super.getEObject(uriFragment);
	}
	
	@Override
	protected XMLHelper createXMLHelper() {
		if (migrationHelper != null) {
			XMLHelper helper = migrationHelper.createXMLHelper(this);
			if (helper != null) {
				return helper;
			}
		}
		return super.createXMLHelper();
	}
}
