/**
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.ParameterRestData;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Rest Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterRestDataImpl#getPassingMode <em>Passing Mode</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterRestDataImpl#getRestId <em>Rest Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterRestDataImpl extends IdentifiableImpl implements ParameterRestData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getPassingMode() <em>Passing Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassingMode()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterPassingMode PASSING_MODE_EDEFAULT = ParameterPassingMode.BODY;

	/**
	 * The default value of the '{@link #getRestId() <em>Rest Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestId()
	 * @generated
	 * @ordered
	 */
	protected static final String REST_ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterRestDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.PARAMETER_REST_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterPassingMode getPassingMode() {
		return (ParameterPassingMode)eDynamicGet(SoaPackage.PARAMETER_REST_DATA__PASSING_MODE, SoaPackage.Literals.PARAMETER_REST_DATA__PASSING_MODE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassingMode(ParameterPassingMode newPassingMode) {
		eDynamicSet(SoaPackage.PARAMETER_REST_DATA__PASSING_MODE, SoaPackage.Literals.PARAMETER_REST_DATA__PASSING_MODE, newPassingMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRestId() {
		return (String)eDynamicGet(SoaPackage.PARAMETER_REST_DATA__REST_ID, SoaPackage.Literals.PARAMETER_REST_DATA__REST_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestId(String newRestId) {
		eDynamicSet(SoaPackage.PARAMETER_REST_DATA__REST_ID, SoaPackage.Literals.PARAMETER_REST_DATA__REST_ID, newRestId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaPackage.PARAMETER_REST_DATA__PASSING_MODE:
				return getPassingMode();
			case SoaPackage.PARAMETER_REST_DATA__REST_ID:
				return getRestId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SoaPackage.PARAMETER_REST_DATA__PASSING_MODE:
				setPassingMode((ParameterPassingMode)newValue);
				return;
			case SoaPackage.PARAMETER_REST_DATA__REST_ID:
				setRestId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SoaPackage.PARAMETER_REST_DATA__PASSING_MODE:
				setPassingMode(PASSING_MODE_EDEFAULT);
				return;
			case SoaPackage.PARAMETER_REST_DATA__REST_ID:
				setRestId(REST_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SoaPackage.PARAMETER_REST_DATA__PASSING_MODE:
				return getPassingMode() != PASSING_MODE_EDEFAULT;
			case SoaPackage.PARAMETER_REST_DATA__REST_ID:
				return REST_ID_EDEFAULT == null ? getRestId() != null : !REST_ID_EDEFAULT.equals(getRestId());
		}
		return super.eIsSet(featureID);
	}

} //ParameterRestDataImpl
