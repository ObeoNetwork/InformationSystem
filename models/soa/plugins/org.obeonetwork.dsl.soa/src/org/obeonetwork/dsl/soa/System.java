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

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Namespace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getOwnedComponents <em>Owned Components</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getOwnedWires <em>Owned Wires</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends Namespace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Components</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSystem_OwnedComponents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Component> getOwnedComponents();

	/**
	 * Returns the value of the '<em><b>Owned Wires</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Wire}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Wires</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Wires</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSystem_OwnedWires()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Wire> getOwnedWires();

} // System