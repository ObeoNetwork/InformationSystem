/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.scaffold.impl;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldPackage;
import fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traceability Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.impl.TraceabilityInfoImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.impl.TraceabilityInfoImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceabilityInfoImpl extends CDOObjectImpl implements TraceabilityInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2012, 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceabilityInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaffoldPackage.Literals.TRACEABILITY_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLeft() {
		return (EObject)eGet(ScaffoldPackage.Literals.TRACEABILITY_INFO__LEFT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(EObject newLeft) {
		eSet(ScaffoldPackage.Literals.TRACEABILITY_INFO__LEFT, newLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRight() {
		return (EObject)eGet(ScaffoldPackage.Literals.TRACEABILITY_INFO__RIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(EObject newRight) {
		eSet(ScaffoldPackage.Literals.TRACEABILITY_INFO__RIGHT, newRight);
	}

} //TraceabilityInfoImpl
