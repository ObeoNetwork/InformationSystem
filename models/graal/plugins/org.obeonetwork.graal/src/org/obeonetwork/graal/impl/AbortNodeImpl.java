/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.graal.AbortNode;
import org.obeonetwork.graal.GraalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abort Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AbortNodeImpl extends NodeImpl implements AbortNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbortNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.ABORT_NODE;
	}

} //AbortNodeImpl
