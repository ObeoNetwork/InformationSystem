/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.overview.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLParserPool;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.obeonetwork.dsl.overview.migration.OverviewMigrationHelper;
import org.obeonetwork.tools.migration.XMIResourceWithMigrationSupportImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.overview.util.OverviewResourceImpl
 * @generated
 */
public class OverviewResourceFactoryImpl extends ResourceFactoryImpl {
	
	private List<Object> lookupTable = new ArrayList<Object>();
	private XMLParserPool parserPool = new XMLParserPoolImpl();
	private Map<String, Object> nameToFeatureMap = new HashMap<String, Object>();
	
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverviewResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Resource createResource(URI uri) {
		XMIResourceWithMigrationSupportImpl result = new OverviewResourceImpl(uri);

		Map<Object, Object> saveOptions = result.getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE, lookupTable);

		Map<Object, Object> loadOptions = result.getDefaultLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, parserPool);
		loadOptions.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, nameToFeatureMap);

		result.attachMigrationHelper(new OverviewMigrationHelper());
		return result;
	}

} //OverviewResourceFactoryImpl
