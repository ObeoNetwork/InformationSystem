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
package org.obeonetwork.dsl.cinematic.toolkits;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit <em>Toolkit</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getPossibleEvents <em>Possible Events</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#isIsContainer <em>Is Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Widget extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Implementation()
	 * @model
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Toolkit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toolkit</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Toolkit</em>' container reference.
	 * @see #setToolkit(Toolkit)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Toolkit()
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getWidgets
	 * @model opposite="widgets" transient="false"
	 * @generated
	 */
	Toolkit getToolkit();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit <em>Toolkit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Toolkit</em>' container reference.
	 * @see #getToolkit()
	 * @generated
	 */
	void setToolkit(Toolkit value);

	/**
	 * Returns the value of the '<em><b>Possible Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Events</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_PossibleEvents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<WidgetEventType> getPossibleEvents();

	/**
	 * Returns the value of the '<em><b>Is Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Container</em>' attribute.
	 * @see #setIsContainer(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_IsContainer()
	 * @model
	 * @generated
	 */
	boolean isIsContainer();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#isIsContainer <em>Is Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Container</em>' attribute.
	 * @see #isIsContainer()
	 * @generated
	 */
	void setIsContainer(boolean value);

} // Widget
