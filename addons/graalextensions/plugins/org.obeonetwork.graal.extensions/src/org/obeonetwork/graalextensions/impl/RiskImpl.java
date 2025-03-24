/**
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.environment.impl.MetaDataImpl;

import org.obeonetwork.graalextensions.BenefitsLevel;
import org.obeonetwork.graalextensions.DrawbacksLevel;
import org.obeonetwork.graalextensions.GraalExtensionsPackage;
import org.obeonetwork.graalextensions.Risk;
import org.obeonetwork.graalextensions.RiskLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Risk</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.graalextensions.impl.RiskImpl#getBenefits <em>Benefits</em>}</li>
 *   <li>{@link org.obeonetwork.graalextensions.impl.RiskImpl#getDrawbacks <em>Drawbacks</em>}</li>
 *   <li>{@link org.obeonetwork.graalextensions.impl.RiskImpl#getRisk <em>Risk</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RiskImpl extends MetaDataImpl implements Risk {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getBenefits() <em>Benefits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBenefits()
	 * @generated
	 * @ordered
	 */
	protected static final BenefitsLevel BENEFITS_EDEFAULT = BenefitsLevel.UNDEFINED;

	/**
	 * The default value of the '{@link #getDrawbacks() <em>Drawbacks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawbacks()
	 * @generated
	 * @ordered
	 */
	protected static final DrawbacksLevel DRAWBACKS_EDEFAULT = DrawbacksLevel.UNDEFINED;

	/**
	 * The default value of the '{@link #getRisk() <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRisk()
	 * @generated
	 * @ordered
	 */
	protected static final RiskLevel RISK_EDEFAULT = RiskLevel.UNDEFINED;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RiskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalExtensionsPackage.Literals.RISK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BenefitsLevel getBenefits() {
		return (BenefitsLevel)eDynamicGet(GraalExtensionsPackage.RISK__BENEFITS, GraalExtensionsPackage.Literals.RISK__BENEFITS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBenefits(BenefitsLevel newBenefits) {
		eDynamicSet(GraalExtensionsPackage.RISK__BENEFITS, GraalExtensionsPackage.Literals.RISK__BENEFITS, newBenefits);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrawbacksLevel getDrawbacks() {
		return (DrawbacksLevel)eDynamicGet(GraalExtensionsPackage.RISK__DRAWBACKS, GraalExtensionsPackage.Literals.RISK__DRAWBACKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrawbacks(DrawbacksLevel newDrawbacks) {
		eDynamicSet(GraalExtensionsPackage.RISK__DRAWBACKS, GraalExtensionsPackage.Literals.RISK__DRAWBACKS, newDrawbacks);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RiskLevel getRisk() {
		return (RiskLevel)eDynamicGet(GraalExtensionsPackage.RISK__RISK, GraalExtensionsPackage.Literals.RISK__RISK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRisk(RiskLevel newRisk) {
		eDynamicSet(GraalExtensionsPackage.RISK__RISK, GraalExtensionsPackage.Literals.RISK__RISK, newRisk);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalExtensionsPackage.RISK__BENEFITS:
				return getBenefits();
			case GraalExtensionsPackage.RISK__DRAWBACKS:
				return getDrawbacks();
			case GraalExtensionsPackage.RISK__RISK:
				return getRisk();
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
			case GraalExtensionsPackage.RISK__BENEFITS:
				setBenefits((BenefitsLevel)newValue);
				return;
			case GraalExtensionsPackage.RISK__DRAWBACKS:
				setDrawbacks((DrawbacksLevel)newValue);
				return;
			case GraalExtensionsPackage.RISK__RISK:
				setRisk((RiskLevel)newValue);
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
			case GraalExtensionsPackage.RISK__BENEFITS:
				setBenefits(BENEFITS_EDEFAULT);
				return;
			case GraalExtensionsPackage.RISK__DRAWBACKS:
				setDrawbacks(DRAWBACKS_EDEFAULT);
				return;
			case GraalExtensionsPackage.RISK__RISK:
				setRisk(RISK_EDEFAULT);
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
			case GraalExtensionsPackage.RISK__BENEFITS:
				return getBenefits() != BENEFITS_EDEFAULT;
			case GraalExtensionsPackage.RISK__DRAWBACKS:
				return getDrawbacks() != DRAWBACKS_EDEFAULT;
			case GraalExtensionsPackage.RISK__RISK:
				return getRisk() != RISK_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //RiskImpl
