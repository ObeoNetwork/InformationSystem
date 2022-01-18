/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.database.scaffold;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traceability Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getLeft <em>Left</em>}</li>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldPackage#getTraceabilityInfo()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface TraceabilityInfo extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2022 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(EObject)
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldPackage#getTraceabilityInfo_Left()
	 * @model required="true"
	 * @generated
	 */
	EObject getLeft();

	/**
	 * Sets the value of the '{@link fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(EObject value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(EObject)
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldPackage#getTraceabilityInfo_Right()
	 * @model required="true"
	 * @generated
	 */
	EObject getRight();

	/**
	 * Sets the value of the '{@link fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(EObject value);

} // TraceabilityInfo
