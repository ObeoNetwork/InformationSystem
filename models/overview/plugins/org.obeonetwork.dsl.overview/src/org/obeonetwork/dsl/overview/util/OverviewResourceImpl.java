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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.obeonetwork.tools.migration.XMIResourceWithMigrationSupportImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.overview.util.OverviewResourceFactoryImpl
 * @generated NOT
 */
public class OverviewResourceImpl extends XMIResourceWithMigrationSupportImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public OverviewResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		if (options == null || !options.containsKey(XMLResource.OPTION_URI_HANDLER)) {
			Map<Object, Object> saveOptions = new HashMap<Object, Object>();
			if (options != null) {
				saveOptions.putAll(options);
			}
			saveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
			super.save(saveOptions);
		} else {
			super.save(options);
		}
	}
	
	/**
	 * user UUID as identifier
	 */
	protected boolean useUUIDs() {
		return true;
	}

} //OverviewResourceImpl
