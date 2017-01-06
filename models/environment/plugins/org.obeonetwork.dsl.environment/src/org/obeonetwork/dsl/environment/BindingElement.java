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
package org.obeonetwork.dsl.environment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingElement#getBoundElement <em>Bound Element</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingElement#getBindingExpression <em>Binding Expression</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingElement#getReferencedByAsLeft <em>Referenced By As Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingElement#getReferencedByAsRight <em>Referenced By As Right</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingElement#getReferencedBy <em>Referenced By</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingElement#getPathReferences <em>Path References</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingElement()
 * @model
 * @generated
 */
public interface BindingElement extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Bound Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Element</em>' reference.
	 * @see #setBoundElement(BoundableElement)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingElement_BoundElement()
	 * @model
	 * @generated
	 */
	BoundableElement getBoundElement();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.BindingElement#getBoundElement <em>Bound Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Element</em>' reference.
	 * @see #getBoundElement()
	 * @generated
	 */
	void setBoundElement(BoundableElement value);

	/**
	 * Returns the value of the '<em><b>Binding Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Expression</em>' attribute.
	 * @see #setBindingExpression(String)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingElement_BindingExpression()
	 * @model
	 * @generated
	 */
	String getBindingExpression();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.BindingElement#getBindingExpression <em>Binding Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Expression</em>' attribute.
	 * @see #getBindingExpression()
	 * @generated
	 */
	void setBindingExpression(String value);

	/**
	 * Returns the value of the '<em><b>Referenced By As Left</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BindingReference}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.BindingReference#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced By As Left</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By As Left</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingElement_ReferencedByAsLeft()
	 * @see org.obeonetwork.dsl.environment.BindingReference#getLeft
	 * @model opposite="left"
	 * @generated
	 */
	EList<BindingReference> getReferencedByAsLeft();

	/**
	 * Returns the value of the '<em><b>Referenced By As Right</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BindingReference}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.BindingReference#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced By As Right</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By As Right</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingElement_ReferencedByAsRight()
	 * @see org.obeonetwork.dsl.environment.BindingReference#getRight
	 * @model opposite="right"
	 * @generated
	 */
	EList<BindingReference> getReferencedByAsRight();

	/**
	 * Returns the value of the '<em><b>Referenced By</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BindingReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingElement_ReferencedBy()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<BindingReference> getReferencedBy();

	/**
	 * Returns the value of the '<em><b>Path References</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BoundableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path References</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingElement_PathReferences()
	 * @model
	 * @generated
	 */
	EList<BoundableElement> getPathReferences();

} // BindingElement
