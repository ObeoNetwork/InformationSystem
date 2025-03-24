/**
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.cdo.CDOObject;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Rest Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.ParameterRestData#getPassingMode <em>Passing Mode</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.ParameterRestData#getRestId <em>Rest Id</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameterRestData()
 * @model
 * @generated
 */
public interface ParameterRestData extends Identifiable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Passing Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.ParameterPassingMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameter passing mode.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Passing Mode</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.ParameterPassingMode
	 * @see #setPassingMode(ParameterPassingMode)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameterRestData_PassingMode()
	 * @model
	 * @generated
	 */
	ParameterPassingMode getPassingMode();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.ParameterRestData#getPassingMode <em>Passing Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passing Mode</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.ParameterPassingMode
	 * @see #getPassingMode()
	 * @generated
	 */
	void setPassingMode(ParameterPassingMode value);

	/**
	 * Returns the value of the '<em><b>Rest Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest Id</em>' attribute.
	 * @see #setRestId(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameterRestData_RestId()
	 * @model
	 * @generated
	 */
	String getRestId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.ParameterRestData#getRestId <em>Rest Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest Id</em>' attribute.
	 * @see #getRestId()
	 * @generated
	 */
	void setRestId(String value);

} // ParameterRestData
