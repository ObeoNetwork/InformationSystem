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
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.RemoveConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Remove Constraint</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class RemoveConstraintImpl extends ConstraintChangeImpl implements RemoveConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.REMOVE_CONSTRAINT;
	}

} // RemoveConstraintImpl
