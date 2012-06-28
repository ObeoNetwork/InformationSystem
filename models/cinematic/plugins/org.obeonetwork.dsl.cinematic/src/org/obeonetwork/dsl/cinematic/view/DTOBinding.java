/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.view;

import org.obeonetwork.dsl.soa.ServiceDTO;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTO Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.DTOBinding#getDto <em>Dto</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getDTOBinding()
 * @model
 * @generated
 */
public interface DTOBinding extends DataBinding {
	/**
	 * Returns the value of the '<em><b>Dto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dto</em>' reference.
	 * @see #setDto(ServiceDTO)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getDTOBinding_Dto()
	 * @model required="true"
	 * @generated
	 */
	ServiceDTO getDto();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.DTOBinding#getDto <em>Dto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dto</em>' reference.
	 * @see #getDto()
	 * @generated
	 */
	void setDto(ServiceDTO value);

} // DTOBinding
