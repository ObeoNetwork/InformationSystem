/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.Activity#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.obeonetwork.graal.Activity#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.obeonetwork.graal.Activity#getSubActivities <em>Sub Activities</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getActivity()
 * @model abstract="true"
 * @generated
 */
public interface Activity extends GraalObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of nodes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getActivity_Nodes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of transitions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getActivity_Transitions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Sub Activities</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.Loop}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Activities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of sub activities.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Activities</em>' containment reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getActivity_SubActivities()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Loop> getSubActivities();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasChildAttachedToUserStory(UserStory userStory);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Task getContainingTask();

} // Activity
