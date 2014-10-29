/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.entity.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.obeonetwork.dsl.entity.migration.EntityXMLHelper;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.entity.util.EntityResourceFactoryImpl
 * @generated
 */
public class EntityResourceImpl extends XMIResourceImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public EntityResourceImpl(URI uri) {
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
		if (uriFragment == null) {
			return null;
		}
		EObject rewrittenFragment = super.getEObject(uriFragment);
		
		// TODO Migration code here
		
		return rewrittenFragment;
	}
	
	@Override
	protected XMLHelper createXMLHelper() {
		return new EntityXMLHelper(this);
	}

} //EntityResourceImpl
