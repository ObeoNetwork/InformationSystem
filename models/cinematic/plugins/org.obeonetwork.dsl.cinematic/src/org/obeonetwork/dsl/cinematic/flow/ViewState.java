/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.ViewState#isNewInstance <em>New Instance</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.ViewState#isRefresh <em>Refresh</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.ViewState#getViewContainers <em>View Containers</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getViewState()
 * @model
 * @generated
 */
public interface ViewState extends NamedFlowState {
	/**
	 * Returns the value of the '<em><b>New Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this view state instanciates a new view.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>New Instance</em>' attribute.
	 * @see #setNewInstance(boolean)
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getViewState_NewInstance()
	 * @model
	 * @generated
	 */
	boolean isNewInstance();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.flow.ViewState#isNewInstance <em>New Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Instance</em>' attribute.
	 * @see #isNewInstance()
	 * @generated
	 */
	void setNewInstance(boolean value);

	/**
	 * Returns the value of the '<em><b>Refresh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refresh</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if a refresh should be performed on the view.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Refresh</em>' attribute.
	 * @see #setRefresh(boolean)
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getViewState_Refresh()
	 * @model
	 * @generated
	 */
	boolean isRefresh();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.flow.ViewState#isRefresh <em>Refresh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refresh</em>' attribute.
	 * @see #isRefresh()
	 * @generated
	 */
	void setRefresh(boolean value);

	/**
	 * Returns the value of the '<em><b>View Containers</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.ViewContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The view containers this View State is presented by.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Containers</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getViewState_ViewContainers()
	 * @model
	 * @generated
	 */
	EList<ViewContainer> getViewContainers();

} // ViewState
