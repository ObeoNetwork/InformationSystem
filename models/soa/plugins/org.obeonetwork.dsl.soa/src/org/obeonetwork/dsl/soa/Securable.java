/**
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Securable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Securable#getSecurityApplications <em>Security Applications</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Securable#getSecuritySchemes <em>Security Schemes</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurable()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Securable extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Security Applications</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.SecurityApplication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Applications</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurable_SecurityApplications()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<SecurityApplication> getSecurityApplications();

	/**
	 * Returns the value of the '<em><b>Security Schemes</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.SecurityScheme}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Schemes</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurable_SecuritySchemes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<SecurityScheme> getSecuritySchemes();

} // Securable
