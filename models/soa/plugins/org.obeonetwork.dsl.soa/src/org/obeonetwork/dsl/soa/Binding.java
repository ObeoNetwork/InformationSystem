/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Binding#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getBinding()
 * @model
 * @generated
 */
public interface Binding extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Technology</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.BindingKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technology</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The binding kind.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technology</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.BindingKind
	 * @see #setTechnology(BindingKind)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getBinding_Technology()
	 * @model
	 * @generated
	 */
	BindingKind getTechnology();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Binding#getTechnology <em>Technology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.BindingKind
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(BindingKind value);

} // Binding