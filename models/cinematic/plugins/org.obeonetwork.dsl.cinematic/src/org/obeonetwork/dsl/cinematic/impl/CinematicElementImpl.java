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
package org.obeonetwork.dsl.cinematic.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class CinematicElementImpl extends ObeoDSMObjectImpl implements CinematicElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CinematicElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinematicPackage.Literals.CINEMATIC_ELEMENT;
	}

} //CinematicElementImpl
