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
package org.obeonetwork.dsl.environment.bindingdialect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.sirius.viewpoint.DRepresentationElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DBound Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getParent <em>Parent</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getChildren <em>Children</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsLeft <em>Edges As Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsRight <em>Edges As Right</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBoundElement()
 * @model
 * @generated
 */
public interface DBoundElement extends DRepresentationElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2021 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(DBoundElement)
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBoundElement_Parent()
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	DBoundElement getParent();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(DBoundElement value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBoundElement_Children()
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<DBoundElement> getChildren();

	/**
	 * Returns the value of the '<em><b>Edges As Left</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges As Left</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges As Left</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBoundElement_EdgesAsLeft()
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getLeft
	 * @model opposite="left"
	 * @generated
	 */
	EList<DBindingEdge> getEdgesAsLeft();

	/**
	 * Returns the value of the '<em><b>Edges As Right</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges As Right</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges As Right</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBoundElement_EdgesAsRight()
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getRight
	 * @model opposite="right"
	 * @generated
	 */
	EList<DBindingEdge> getEdgesAsRight();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBoundElement_Edges()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<DBindingEdge> getEdges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getPath();

} // DBoundElement
