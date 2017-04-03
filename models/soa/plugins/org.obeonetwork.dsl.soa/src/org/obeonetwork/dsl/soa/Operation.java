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
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getInput <em>Input</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getOutput <em>Output</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#isPublic <em>Public</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getFault <em>Fault</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Action {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Input()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getInput();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Output()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getOutput();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.OperationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.OperationKind
	 * @see #setKind(OperationKind)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Kind()
	 * @model
	 * @generated
	 */
	OperationKind getKind();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.OperationKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OperationKind value);

	/**
	 * Returns the value of the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public</em>' attribute.
	 * @see #setPublic(boolean)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Public()
	 * @model required="true"
	 * @generated
	 */
	boolean isPublic();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#isPublic <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public</em>' attribute.
	 * @see #isPublic()
	 * @generated
	 */
	void setPublic(boolean value);

	/**
	 * Returns the value of the '<em><b>Fault</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Fault()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getFault();

} // Operation