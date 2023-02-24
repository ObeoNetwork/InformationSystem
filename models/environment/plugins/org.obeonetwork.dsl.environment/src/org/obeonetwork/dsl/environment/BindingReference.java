/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingReference#getLeft <em>Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingReference#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingReference()
 * @model
 * @generated
 */
public interface BindingReference extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.BindingElement#getReferencedByAsLeft <em>Referenced By As Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The left binding element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(BindingElement)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingReference_Left()
	 * @see org.obeonetwork.dsl.environment.BindingElement#getReferencedByAsLeft
	 * @model opposite="referencedByAsLeft" required="true"
	 * @generated
	 */
	BindingElement getLeft();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.BindingReference#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(BindingElement value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.BindingElement#getReferencedByAsRight <em>Referenced By As Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The right binding element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(BindingElement)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingReference_Right()
	 * @see org.obeonetwork.dsl.environment.BindingElement#getReferencedByAsRight
	 * @model opposite="referencedByAsRight" required="true"
	 * @generated
	 */
	BindingElement getRight();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.BindingReference#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(BindingElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model bindingElementRequired="true"
	 * @generated
	 */
	BindingElement getOppositeBindingElement(BindingElement bindingElement);

} // BindingReference
