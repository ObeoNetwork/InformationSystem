/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.database.dbevolution.AddColumnChange;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Column Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AddColumnChangeImpl extends ColumnChangeImpl implements AddColumnChange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddColumnChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.ADD_COLUMN_CHANGE;
	}

} //AddColumnChangeImpl
