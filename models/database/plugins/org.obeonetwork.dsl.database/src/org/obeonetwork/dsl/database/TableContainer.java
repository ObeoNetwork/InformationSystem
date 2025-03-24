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
 * A representation of the model object '<em><b>Table Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.TableContainer#getTables <em>Tables</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.TableContainer#getSequences <em>Sequences</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getTableContainer()
 * @model abstract="true"
 * @generated
 */
public interface TableContainer extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.AbstractTable}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.AbstractTable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of contained tables.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getTableContainer_Tables()
	 * @see org.obeonetwork.dsl.database.AbstractTable#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractTable> getTables();

	/**
	 * Returns the value of the '<em><b>Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.Sequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of contained sequences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sequences</em>' containment reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getTableContainer_Sequences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sequence> getSequences();

} // TableContainer
