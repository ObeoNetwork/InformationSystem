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
package org.obeonetwork.dsl.environment.bindingdialect.description;

import org.eclipse.sirius.viewpoint.description.tool.RepresentationCreationDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DBinding Editor Creation Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionPackage#getDBindingEditorCreationDescription()
 * @model
 * @generated
 */
public interface DBindingEditorCreationDescription extends RepresentationCreationDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

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
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionPackage#getDBindingEditorCreationDescription_Description()
	 * @model required="true"
	 * @generated
	 */
	DBindingEditorDescription getDescription();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription#getDescription <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(DBindingEditorDescription value);

} // DBindingEditorCreationDescription
