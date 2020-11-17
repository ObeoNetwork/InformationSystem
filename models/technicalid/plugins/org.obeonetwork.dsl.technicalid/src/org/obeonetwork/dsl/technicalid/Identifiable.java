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
package org.obeonetwork.dsl.technicalid;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.technicalid.Identifiable#getTechnicalid <em>Technicalid</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.technicalid.TechnicalIDPackage#getIdentifiable()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Identifiable extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technicalid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Technical identifier of the element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technicalid</em>' attribute.
	 * @see #setTechnicalid(String)
	 * @see org.obeonetwork.dsl.technicalid.TechnicalIDPackage#getIdentifiable_Technicalid()
	 * @model id="true"
	 * @generated
	 */
	String getTechnicalid();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.technicalid.Identifiable#getTechnicalid <em>Technicalid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technicalid</em>' attribute.
	 * @see #getTechnicalid()
	 * @generated
	 */
	void setTechnicalid(String value);

} // Identifiable
