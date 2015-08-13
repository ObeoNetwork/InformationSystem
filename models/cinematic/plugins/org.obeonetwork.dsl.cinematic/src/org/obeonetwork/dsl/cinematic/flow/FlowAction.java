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
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.environment.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.FlowAction#getCalls <em>Calls</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.FlowAction#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowAction()
 * @model
 * @generated
 */
public interface FlowAction extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Calls</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.ViewAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowAction_Calls()
	 * @model
	 * @generated
	 */
	EList<ViewAction> getCalls();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getFlowAction_Operations()
	 * @model
	 * @generated
	 */
	EList<Action> getOperations();

} // FlowAction
