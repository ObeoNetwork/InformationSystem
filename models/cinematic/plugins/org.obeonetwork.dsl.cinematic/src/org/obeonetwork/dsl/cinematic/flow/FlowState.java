/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
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
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.FlowState#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
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
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowState_Actions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<FlowAction> getActions();

} // FlowState
