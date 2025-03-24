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
package org.obeonetwork.dsl.cinematic.flow;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.FlowEvent#getBinds <em>Binds</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowEvent()
 * @model
 * @generated
 */
public interface FlowEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Binds</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.ViewEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The View Events this Flow Event is binded to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binds</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowEvent_Binds()
	 * @model
	 * @generated
	 */
	EList<ViewEvent> getBinds();

} // FlowEvent
