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
package org.obeonetwork.dsl.typeslibrary;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Native Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.NativeType#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.NativeType#getSpec <em>Spec</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.NativeType#getMapsTo <em>Maps To</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getNativeType()
 * @model
 * @generated
 */
public interface NativeType extends Identifiable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2021 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getNativeType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.NativeType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Spec</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.typeslibrary.NativeTypeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spec</em>' attribute.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeTypeKind
	 * @see #setSpec(NativeTypeKind)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getNativeType_Spec()
	 * @model
	 * @generated
	 */
	NativeTypeKind getSpec();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.NativeType#getSpec <em>Spec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spec</em>' attribute.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeTypeKind
	 * @see #getSpec()
	 * @generated
	 */
	void setSpec(NativeTypeKind value);

	/**
	 * Returns the value of the '<em><b>Maps To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps To</em>' reference.
	 * @see #setMapsTo(NativeType)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getNativeType_MapsTo()
	 * @model
	 * @generated
	 */
	NativeType getMapsTo();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.NativeType#getMapsTo <em>Maps To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maps To</em>' reference.
	 * @see #getMapsTo()
	 * @generated
	 */
	void setMapsTo(NativeType value);

} // NativeType
