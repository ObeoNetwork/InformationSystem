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
package org.obeonetwork.dsl.environment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTO</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getOwnedContainer <em>Owned Container</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO()
 * @model
 * @generated
 */
public interface DTO extends StructuredType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owned filter container.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Container</em>' containment reference.
	 * @see #setOwnedContainer(FilterContainer)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_OwnedContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	FilterContainer getOwnedContainer();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.DTO#getOwnedContainer <em>Owned Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Container</em>' containment reference.
	 * @see #getOwnedContainer()
	 * @generated
	 */
	void setOwnedContainer(FilterContainer value);

} // DTO