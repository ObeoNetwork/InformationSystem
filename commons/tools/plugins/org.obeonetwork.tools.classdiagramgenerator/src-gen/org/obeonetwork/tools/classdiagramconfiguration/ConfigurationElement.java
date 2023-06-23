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
/**
 */
package org.obeonetwork.tools.classdiagramconfiguration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getFullQualifiedId <em>Full Qualified Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getChildren <em>Children</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getStringValues <em>String Values</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getBooleanValues <em>Boolean Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationElement()
 * @model
 * @generated
 */
public interface ConfigurationElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationElement_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Full Qualified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Qualified Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Qualified Id</em>' attribute.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationElement_FullQualifiedId()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getFullQualifiedId();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationElement_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConfigurationElement> getChildren();

	/**
	 * Returns the value of the '<em><b>String Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.tools.classdiagramconfiguration.StringValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Values</em>' containment reference list.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationElement_StringValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<StringValue> getStringValues();

	/**
	 * Returns the value of the '<em><b>Boolean Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.tools.classdiagramconfiguration.BooleanValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Values</em>' containment reference list.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationElement_BooleanValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<BooleanValue> getBooleanValues();

} // ConfigurationElement
