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

import org.obeonetwork.dsl.entity.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Property Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getEntityPropertyBinding()
 * @model
 * @generated
 */
public interface EntityPropertyBinding extends DataBinding {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Property)
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#getEntityPropertyBinding_Property()
	 * @model required="true"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

} // EntityPropertyBinding
