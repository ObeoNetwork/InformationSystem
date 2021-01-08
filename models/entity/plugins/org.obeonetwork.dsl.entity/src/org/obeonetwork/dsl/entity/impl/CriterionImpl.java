/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.entity.Criterion;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class CriterionImpl extends ObeoDSMObjectImpl implements
		Criterion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CriterionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.CRITERION;
	}

} // CriterionImpl
