/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.TypesDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getOwnedComponents <em>Owned Components</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.System#getOwnedWires <em>Owned Wires</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends TypesDefinition, NamespacesContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSystem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.System#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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