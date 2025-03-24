/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.typeslibrary;

import org.obeonetwork.dsl.technicalid.Identifiable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Defined Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getUserDefinedTypeRef()
 * @model
 * @generated
 */
public interface UserDefinedTypeRef extends Type, Identifiable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(UserDefinedType)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getUserDefinedTypeRef_Type()
	 * @model required="true"
	 * @generated
	 */
	UserDefinedType getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(UserDefinedType value);

} // UserDefinedTypeRef
