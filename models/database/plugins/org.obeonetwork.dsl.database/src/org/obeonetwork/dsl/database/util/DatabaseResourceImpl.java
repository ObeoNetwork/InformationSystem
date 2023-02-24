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
package org.obeonetwork.dsl.database.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.obeonetwork.tools.migration.XMIResourceWithMigrationSupportImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.database.util.DatabaseResourceFactoryImpl
 * @generated NOT
 */
public class DatabaseResourceImpl extends XMIResourceWithMigrationSupportImpl {

	public DatabaseResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		getEObjectToExtensionMap().clear();
		super.save(options);
	}	

	@Override
	protected boolean useUUIDs() {
		return true;
	}

}
