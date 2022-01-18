/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.flow.AsyncEventState;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Async Event State</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AsyncEventStateImpl extends NamedFlowStateImpl implements AsyncEventState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsyncEventStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.ASYNC_EVENT_STATE;
	}

} //AsyncEventStateImpl
