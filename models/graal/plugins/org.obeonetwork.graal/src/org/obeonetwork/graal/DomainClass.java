/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal;

import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.DomainClass#getEstimatedVolumetry <em>Estimated Volumetry</em>}</li>
 *   <li>{@link org.obeonetwork.graal.DomainClass#isHistorized <em>Historized</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getDomainClass()
 * @model
 * @generated
 */
public interface DomainClass extends StructuredType {
	/**
	 * Returns the value of the '<em><b>Estimated Volumetry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimated Volumetry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The estimated volumetry.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Estimated Volumetry</em>' attribute.
	 * @see #setEstimatedVolumetry(int)
	 * @see org.obeonetwork.graal.GraalPackage#getDomainClass_EstimatedVolumetry()
	 * @model
	 * @generated
	 */
	int getEstimatedVolumetry();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graal.DomainClass#getEstimatedVolumetry <em>Estimated Volumetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimated Volumetry</em>' attribute.
	 * @see #getEstimatedVolumetry()
	 * @generated
	 */
	void setEstimatedVolumetry(int value);

	/**
	 * Returns the value of the '<em><b>Historized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Historized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if the domain class is historized.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Historized</em>' attribute.
	 * @see #setHistorized(boolean)
	 * @see org.obeonetwork.graal.GraalPackage#getDomainClass_Historized()
	 * @model required="true"
	 * @generated
	 */
	boolean isHistorized();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graal.DomainClass#isHistorized <em>Historized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Historized</em>' attribute.
	 * @see #isHistorized()
	 * @generated
	 */
	void setHistorized(boolean value);

} // DomainClass
