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

import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.ViewEvent#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewEvent()
 * @model
 * @generated
 */
public interface ViewEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the View Event.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(WidgetEventType)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getViewEvent_Type()
	 * @model
	 * @generated
	 */
	WidgetEventType getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.ViewEvent#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(WidgetEventType value);

} // ViewEvent
