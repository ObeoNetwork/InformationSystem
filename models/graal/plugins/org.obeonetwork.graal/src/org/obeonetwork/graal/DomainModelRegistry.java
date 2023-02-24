/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Model Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.DomainModelRegistry#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.graal.DomainModelRegistry#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface DomainModelRegistry extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Namespaces</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of namespaces.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespaces</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry_Namespaces()
	 * @model
	 * @generated
	 */
	EList<Namespace> getNamespaces();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.StructuredType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of structured types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Types</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getDomainModelRegistry_Types()
	 * @model
	 * @generated
	 */
	EList<StructuredType> getTypes();

} // DomainModelRegistry
