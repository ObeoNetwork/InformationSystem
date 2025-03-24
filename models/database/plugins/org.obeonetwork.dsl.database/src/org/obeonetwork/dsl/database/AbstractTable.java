/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.AbstractTable#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getAbstractTable()
 * @model abstract="true"
 * @generated
 */
public interface AbstractTable extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.TableContainer#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The container of this table.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(TableContainer)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getAbstractTable_Owner()
	 * @see org.obeonetwork.dsl.database.TableContainer#getTables
	 * @model opposite="tables" required="true" transient="false"
	 * @generated
	 */
	TableContainer getOwner();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.AbstractTable#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(TableContainer value);

} // AbstractTable
