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
package org.obeonetwork.dsl.soa.spec;

import org.obeonetwork.dsl.soa.License;
import org.obeonetwork.dsl.soa.Messages;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.impl.ComponentImpl;

public class ComponentSpec extends ComponentImpl {

	public ComponentSpec() {
		super();
		setInformation(SoaFactory.eINSTANCE.createInformation());
		
		License license = SoaFactory.eINSTANCE.createLicense();
		license.setName(Messages.License_DefaultName);
		license.setURL(Messages.License_DefaultURL);
		setLicense(license);
		setContact(SoaFactory.eINSTANCE.createContact());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApiVersion(String newApiVersion) {
		getInformation().setApiVersion(newApiVersion);
	}

}
