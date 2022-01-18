/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Types Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.TypesDefinition#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getTypesDefinition()
 * @model
 * @generated
 */
public interface TypesDefinition extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Type}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.Type#getTypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getTypesDefinition_Types()
	 * @see org.obeonetwork.dsl.environment.Type#getTypeDefinition
	 * @model opposite="typeDefinition" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Type> getTypes();

} // TypesDefinition