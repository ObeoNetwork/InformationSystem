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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getViewpoint <em>Viewpoint</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getColors <em>Colors</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getJavaExtensions <em>Java Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
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
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfiguration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfiguration_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Viewpoint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewpoint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewpoint</em>' reference.
	 * @see #setViewpoint(Viewpoint)
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfiguration_Viewpoint()
	 * @model
	 * @generated
	 */
	Viewpoint getViewpoint();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.Configuration#getViewpoint <em>Viewpoint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewpoint</em>' reference.
	 * @see #getViewpoint()
	 * @generated
	 */
	void setViewpoint(Viewpoint value);

	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.tools.classdiagramconfiguration.DiagramConf}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagrams</em>' containment reference list.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfiguration_Diagrams()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagramConf> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Colors</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colors</em>' containment reference list.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfiguration_Colors()
	 * @model containment="true"
	 * @generated
	 */
	EList<ColorInfo> getColors();

	/**
	 * Returns the value of the '<em><b>Java Extensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Extensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Extensions</em>' attribute list.
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getConfiguration_JavaExtensions()
	 * @model
	 * @generated
	 */
	EList<String> getJavaExtensions();

} // Configuration
