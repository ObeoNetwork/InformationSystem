/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.bindingdialect;

import org.eclipse.sirius.viewpoint.DRepresentationElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DBinding Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getLeft <em>Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBindingEdge()
 * @model
 * @generated
 */
public interface DBindingEdge extends DRepresentationElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsLeft <em>Edges As Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(DBoundElement)
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBindingEdge_Left()
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsLeft
	 * @model opposite="edgesAsLeft" required="true"
	 * @generated
	 */
	DBoundElement getLeft();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(DBoundElement value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsRight <em>Edges As Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(DBoundElement)
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBindingEdge_Right()
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsRight
	 * @model opposite="edgesAsRight" required="true"
	 * @generated
	 */
	DBoundElement getRight();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(DBoundElement value);

} // DBindingEdge
