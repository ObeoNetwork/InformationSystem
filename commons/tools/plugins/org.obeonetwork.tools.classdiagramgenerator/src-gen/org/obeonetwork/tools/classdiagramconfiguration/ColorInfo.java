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
/**
 */
package org.obeonetwork.tools.classdiagramconfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getRed <em>Red</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getGreen <em>Green</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getBlue <em>Blue</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getColorInfo()
 * @model
 * @generated
 */
public interface ColorInfo extends EObject {
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
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getColorInfo_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Red</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red</em>' attribute.
	 * @see #setRed(int)
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getColorInfo_Red()
	 * @model
	 * @generated
	 */
	int getRed();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getRed <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red</em>' attribute.
	 * @see #getRed()
	 * @generated
	 */
	void setRed(int value);

	/**
	 * Returns the value of the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Green</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green</em>' attribute.
	 * @see #setGreen(int)
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getColorInfo_Green()
	 * @model
	 * @generated
	 */
	int getGreen();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getGreen <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green</em>' attribute.
	 * @see #getGreen()
	 * @generated
	 */
	void setGreen(int value);

	/**
	 * Returns the value of the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue</em>' attribute.
	 * @see #setBlue(int)
	 * @see org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage#getColorInfo_Blue()
	 * @model
	 * @generated
	 */
	int getBlue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.tools.classdiagramconfiguration.ColorInfo#getBlue <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue</em>' attribute.
	 * @see #getBlue()
	 * @generated
	 */
	void setBlue(int value);

} // ColorInfo
