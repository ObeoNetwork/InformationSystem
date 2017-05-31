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
package org.obeonetwork.dsl.database.dbevolution;

import org.obeonetwork.dsl.database.ForeignKey;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Foreign Key Change</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getForeignKeyChange()
 * @model abstract="true"
 * @generated
 */
public interface ForeignKeyChange extends DBDiff {
	/**
	 * Returns the value of the '<em><b>Foreign Key</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Foreign Key</em>' reference.
	 * @see #setForeignKey(ForeignKey)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getForeignKeyChange_ForeignKey()
	 * @model required="true"
	 * @generated
	 */
	ForeignKey getForeignKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange#getForeignKey <em>Foreign Key</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Foreign Key</em>' reference.
	 * @see #getForeignKey()
	 * @generated
	 */
	void setForeignKey(ForeignKey value);

} // ForeignKeyChange
