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
 * A representation of the model object '<em><b>Priority Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.PriorityDefinition#getPriorities <em>Priorities</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getPriorityDefinition()
 * @model
 * @generated
 */
public interface PriorityDefinition extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Priorities</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priorities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of priorities.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Priorities</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getPriorityDefinition_Priorities()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<Priority> getPriorities();

} // PriorityDefinition