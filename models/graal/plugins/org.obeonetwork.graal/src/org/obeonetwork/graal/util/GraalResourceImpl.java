/**
 * Copyright (c) 2010-2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graal.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.obeonetwork.graal.migration.GraalXMLHelper;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.graal.util.GraalResourceFactoryImpl
 * @generated
 */
public class GraalResourceImpl extends XMIResourceImpl {
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
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		getEObjectToExtensionMap().clear();
		super.save(options);
	}

	/**
	 * user UUID as identifier
	 */
	protected boolean useUUIDs() {
		return true;
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		EObject rewrittenFragment = super.getEObject(uriFragment);
		
		// TODO Migration code here
		
		return rewrittenFragment;
	}
	
	@Override
	protected XMLHelper createXMLHelper() {
		return new GraalXMLHelper(this);
	}
	
} //GraalResourceImpl
