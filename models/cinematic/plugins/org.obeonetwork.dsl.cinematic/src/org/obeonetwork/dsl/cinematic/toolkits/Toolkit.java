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
package org.obeonetwork.dsl.cinematic.toolkits;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Toolkit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getWidgets <em>Widgets</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getToolkit()
 * @model
 * @generated
 */
public interface Toolkit extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.toolkits.Widget}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit <em>Toolkit</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The widgets owned by this Toolkit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Widgets</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getToolkit_Widgets()
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit
	 * @model opposite="toolkit" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Widget> getWidgets();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of this Toolkit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getToolkit_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Toolkit
