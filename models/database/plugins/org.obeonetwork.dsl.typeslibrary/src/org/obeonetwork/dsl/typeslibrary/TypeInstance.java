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

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getNativeType <em>Native Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getLength <em>Length</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getPrecision <em>Precision</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypeInstance()
 * @model
 * @generated
 */
public interface TypeInstance extends Type, Identifiable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Native Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Type</em>' reference.
	 * @see #setNativeType(NativeType)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypeInstance_NativeType()
	 * @model required="true"
	 * @generated
	 */
	NativeType getNativeType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getNativeType <em>Native Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Type</em>' reference.
	 * @see #getNativeType()
	 * @generated
	 */
	void setNativeType(NativeType value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Integer)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypeInstance_Length()
	 * @model
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision</em>' attribute.
	 * @see #setPrecision(Integer)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypeInstance_Precision()
	 * @model
	 * @generated
	 */
	Integer getPrecision();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision</em>' attribute.
	 * @see #getPrecision()
	 * @generated
	 */
	void setPrecision(Integer value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' attribute list.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypeInstance_Literals()
	 * @model
	 * @generated
	 */
	EList<String> getLiterals();

} // TypeInstance
