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
package org.obeonetwork.dsl.cinematic.view;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewContainerReference#getViewContainer <em>View Container</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainerReference()
 * @model
 * @generated
 */
public interface ViewContainerReference extends AbstractViewElement {
	/**
	 * Returns the value of the '<em><b>View Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced View Container.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Container</em>' reference.
	 * @see #setViewContainer(ViewContainer)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewContainerReference_ViewContainer()
	 * @model required="true"
	 * @generated
	 */
	ViewContainer getViewContainer();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.ViewContainerReference#getViewContainer <em>View Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Container</em>' reference.
	 * @see #getViewContainer()
	 * @generated
	 */
	void setViewContainer(ViewContainer value);

} // ViewContainerReference
