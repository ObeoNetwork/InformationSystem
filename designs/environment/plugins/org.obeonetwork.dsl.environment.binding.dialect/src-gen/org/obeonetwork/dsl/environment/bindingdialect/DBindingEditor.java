/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
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
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorDescription;

import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DBinding Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getBoundElements <em>Bound Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getBindingEdges <em>Binding Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBindingEditor()
 * @model
 * @generated
 */
public interface DBindingEditor extends DRepresentation, DSemanticDecorator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011, 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' reference.
	 * @see #setDescription(DBindingEditorDescription)
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBindingEditor_Description()
	 * @model required="true"
	 * @generated
	 */
	DBindingEditorDescription getDescription();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getDescription <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(DBindingEditorDescription value);

	/**
	 * Returns the value of the '<em><b>Bound Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Elements</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBindingEditor_BoundElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<DBoundElement> getBoundElements();

	/**
	 * Returns the value of the '<em><b>Binding Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Edges</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#getDBindingEditor_BindingEdges()
	 * @model containment="true"
	 * @generated
	 */
	EList<DBindingEdge> getBindingEdges();

} // DBindingEditor
