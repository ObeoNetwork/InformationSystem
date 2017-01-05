/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.util;

import org.eclipse.emf.common.util.URI;
import org.obeonetwork.tools.migration.XMIResourceWithMigrationSupportImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.graal.util.GraalResourceFactoryImpl
 * @generated NOT
 */
public class GraalResourceImpl extends XMIResourceWithMigrationSupportImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public GraalResourceImpl(URI uri) {
		super(uri);
	}
	
//	@Override
//	public void save(Map<?, ?> options) throws IOException {
//		getEObjectToExtensionMap().clear();
//		super.save(options);
//	}

	/**
	 * user UUID as identifier
	 */
	protected boolean useUUIDs() {
		return true;
	}
	
} //GraalResourceImpl
