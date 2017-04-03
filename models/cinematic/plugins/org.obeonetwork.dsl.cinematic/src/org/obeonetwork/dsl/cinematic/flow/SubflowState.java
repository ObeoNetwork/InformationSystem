/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subflow State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.SubflowState#getSubflow <em>Subflow</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.SubflowState#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getSubflowState()
 * @model
 * @generated
 */
public interface SubflowState extends FlowState {
	/**
	 * Returns the value of the '<em><b>Subflow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subflow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subflow</em>' reference.
	 * @see #setSubflow(Flow)
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getSubflowState_Subflow()
	 * @model required="true"
	 * @generated
	 */
	Flow getSubflow();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.flow.SubflowState#getSubflow <em>Subflow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subflow</em>' reference.
	 * @see #getSubflow()
	 * @generated
	 */
	void setSubflow(Flow value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getSubflowState_Name()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

} // SubflowState
