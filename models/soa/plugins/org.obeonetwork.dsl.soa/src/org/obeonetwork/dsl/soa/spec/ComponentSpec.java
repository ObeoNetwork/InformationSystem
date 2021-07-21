/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.spec;

import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.impl.ComponentImpl;

public class ComponentSpec extends ComponentImpl {

	public ComponentSpec() {
		super();
		setInformation(SoaFactory.eINSTANCE.createInformation());
		setLicense(SoaFactory.eINSTANCE.createLicense());
		setContact(SoaFactory.eINSTANCE.createContact());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApiVersion(String newApiVersion) {
		getInformation().setVersion(newApiVersion);
	}

}
