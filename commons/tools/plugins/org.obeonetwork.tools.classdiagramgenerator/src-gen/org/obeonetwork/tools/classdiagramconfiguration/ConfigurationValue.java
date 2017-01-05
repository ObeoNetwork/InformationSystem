/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 */
package org.obeonetwork.tools.classdiagramconfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue#getFullQualifiedId <em>Full Qualified Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationValue()
 * @model abstract="true"
 * @generated
 */
public interface ConfigurationValue extends EObject {
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
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationValue_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue#getId <em>Id</em>}' attribute.
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
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfigurationValue_FullQualifiedId()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getFullQualifiedId();

} // ConfigurationValue
