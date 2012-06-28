/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.dsl.environment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.Namespace#getOwnedNamespaces <em>Owned Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Namespace#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Namespace#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getNamespace()
 * @model
 * @generated
 */
public interface Namespace extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Namespaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Namespace}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.Namespace#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Namespaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Namespaces</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getNamespace_OwnedNamespaces()
	 * @see org.obeonetwork.dsl.environment.Namespace#getOwner
	 * @model opposite="owner" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Namespace> getOwnedNamespaces();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.Namespace#getOwnedNamespaces <em>Owned Namespaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Namespace)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getNamespace_Owner()
	 * @see org.obeonetwork.dsl.environment.Namespace#getOwnedNamespaces
	 * @model opposite="ownedNamespaces" transient="false"
	 * @generated
	 */
	Namespace getOwner();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Namespace#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Namespace value);

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
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getNamespace_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Namespace#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Namespace
