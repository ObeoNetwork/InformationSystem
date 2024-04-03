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

import org.eclipse.emf.compare.internal.spec.ComparisonSpec;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;

/**
 * We have to inherit ComparisonSpec to get all the implementations
 *
 * @generated NOT
 */
@SuppressWarnings("restriction")
public class DatabaseChangeSetImpl extends ComparisonSpec implements DatabaseChangeSet {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseChangeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.DATABASE_CHANGE_SET;
	}

} // DatabaseChangeSetImpl
