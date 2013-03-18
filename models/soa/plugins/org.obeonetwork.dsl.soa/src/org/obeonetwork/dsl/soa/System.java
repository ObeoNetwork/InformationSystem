/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getOwnedComponents <em>Owned Components</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getOwnedWires <em>Owned Wires</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getOwnedDtoRegistry <em>Owned Dto Registry</em>}</li>
 * </ul>
 * </p>
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
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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

	/**
	 * Returns the value of the '<em><b>Owned Dto Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Dto Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Dto Registry</em>' containment reference.
	 * @see #setOwnedDtoRegistry(DTORegistry)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSystem_OwnedDtoRegistry()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	DTORegistry getOwnedDtoRegistry();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.System#getOwnedDtoRegistry <em>Owned Dto Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Dto Registry</em>' containment reference.
	 * @see #getOwnedDtoRegistry()
	 * @generated
	 */
	void setOwnedDtoRegistry(DTORegistry value);

} // System