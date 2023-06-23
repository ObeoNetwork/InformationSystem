/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.cinematic.CinematicElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.FlowState#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowState()
 * @model abstract="true"
 * @generated
 */
public interface FlowState extends CinematicElement {

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.flow.FlowAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Flow Actions defined on this Flow State (Flow Actions calling View Actions or Operations).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowState_Actions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<FlowAction> getActions();

} // FlowState
