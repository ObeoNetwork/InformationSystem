/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.obeonetwork.dsl.database.View;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update View Query Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange#getNewView <em>New View</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateViewQueryChange()
 * @model
 * @generated
 */
public interface UpdateViewQueryChange extends ViewChange {
	/**
	 * Returns the value of the '<em><b>New View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New View</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New View</em>' reference.
	 * @see #setNewView(View)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateViewQueryChange_NewView()
	 * @model required="true"
	 * @generated
	 */
	View getNewView();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange#getNewView <em>New View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New View</em>' reference.
	 * @see #getNewView()
	 * @generated
	 */
	void setNewView(View value);

} // UpdateViewQueryChange
