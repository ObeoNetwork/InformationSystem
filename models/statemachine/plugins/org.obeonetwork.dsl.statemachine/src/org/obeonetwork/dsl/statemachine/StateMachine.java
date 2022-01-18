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
package org.obeonetwork.dsl.statemachine;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Behaviour;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.statemachine.StateMachine#getRegions <em>Regions</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends StateMachineDescription, Behaviour {
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.statemachine.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getStateMachine_Regions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Region> getRegions();

} // StateMachine
