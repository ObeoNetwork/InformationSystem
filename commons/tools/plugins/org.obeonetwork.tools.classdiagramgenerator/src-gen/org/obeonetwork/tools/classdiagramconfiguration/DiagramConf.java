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
/**
 */
package org.obeonetwork.tools.classdiagramconfiguration;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Conf</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.DiagramConf#getDescriptionId <em>Description Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.DiagramConf#getMetamodels <em>Metamodels</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getDiagramConf()
 * @model
 * @generated
 */
public interface DiagramConf extends ConfigurationElement {
	/**
	 * Returns the value of the '<em><b>Description Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Id</em>' attribute.
	 * @see #setDescriptionId(String)
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getDiagramConf_DescriptionId()
	 * @model
	 * @generated
	 */
	String getDescriptionId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.DiagramConf#getDescriptionId <em>Description Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Id</em>' attribute.
	 * @see #getDescriptionId()
	 * @generated
	 */
	void setDescriptionId(String value);

	/**
	 * Returns the value of the '<em><b>Metamodels</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodels</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodels</em>' attribute list.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getDiagramConf_Metamodels()
	 * @model
	 * @generated
	 */
	EList<String> getMetamodels();

} // DiagramConf
