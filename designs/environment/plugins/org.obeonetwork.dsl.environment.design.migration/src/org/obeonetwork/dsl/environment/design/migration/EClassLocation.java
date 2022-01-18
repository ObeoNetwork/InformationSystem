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
package org.obeonetwork.dsl.environment.design.migration;

/**
 * Class used to store informations on an EClass i.e.
 * the URI of its containing EPackage and the name
 * of the EClass.
 * This class is used by the automatic migration process
 * to bind the old EClass to the new one 
 * 
 * @author Stéphane Thibaudeau - Obeo
 */
public class EClassLocation {

	private String ePackageNsURI;
	private String eClassName;
	
	public EClassLocation(String ePackageNsURI, String eClassName) {
		super();
		this.ePackageNsURI = ePackageNsURI;
		this.eClassName = eClassName;
	}

	public String getEPackageNsURI() {
		return ePackageNsURI;
	}

	public void setEPackageNsURI(String ePackageNsURI) {
		this.ePackageNsURI = ePackageNsURI;
	}

	public String getEClassName() {
		return eClassName;
	}

	public void setEClassName(String eClassName) {
		this.eClassName = eClassName;
	}
	
}
