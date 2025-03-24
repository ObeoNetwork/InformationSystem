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
package org.obeonetwork.dsl.environment;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespaces Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.NamespacesContainer#getOwnedNamespaces <em>Owned Namespaces</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getNamespacesContainer()
 * @model abstract="true"
 * @generated
 */
public interface NamespacesContainer extends Identifiable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * <!-- begin-model-doc -->
	 * The list of owned namespaces.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Namespaces</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getNamespacesContainer_OwnedNamespaces()
	 * @see org.obeonetwork.dsl.environment.Namespace#getOwner
	 * @model opposite="owner" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Namespace> getOwnedNamespaces();

} // NamespacesContainer
