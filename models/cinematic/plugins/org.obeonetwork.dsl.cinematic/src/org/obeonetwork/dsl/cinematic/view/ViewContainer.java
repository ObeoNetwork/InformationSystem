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
package org.obeonetwork.dsl.cinematic.view;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewContainers <em>View Containers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewElements <em>View Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewContainerReferences <em>View Container References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainer()
 * @model
 * @generated
 */
public interface ViewContainer extends AbstractViewElement {
	/**
	 * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the directly contained View Containers, View Elements and View Container References.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Elements</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainer_OwnedElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractViewElement> getOwnedElements();

	/**
	 * Returns the value of the '<em><b>View Containers</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.ViewContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Containers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the directly contained View Containers.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Containers</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainer_ViewContainers()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ViewContainer> getViewContainers();

	/**
	 * Returns the value of the '<em><b>View Elements</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.ViewElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the directly contained View Elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Elements</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainer_ViewElements()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ViewElement> getViewElements();

	/**
	 * Returns the value of the '<em><b>View Container References</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.ViewContainerReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Container References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the directly contained View Container References.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Container References</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainer_ViewContainerReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ViewContainerReference> getViewContainerReferences();

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' containment reference.
	 * @see #setLayout(Layout)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainer_Layout()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Layout getLayout();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getLayout <em>Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' containment reference.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(Layout value);

} // ViewContainer
