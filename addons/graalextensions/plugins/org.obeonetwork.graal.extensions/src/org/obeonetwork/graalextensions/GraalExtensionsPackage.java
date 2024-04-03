/**
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.graalextensions.GraalExtensionsFactory
 * @model kind="package"
 * @generated
 */
public interface GraalExtensionsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2024 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graalextensions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mindef.gouv.fr/dsl/safran/graal-extensions/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sge";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraalExtensionsPackage eINSTANCE = org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.graalextensions.impl.RiskImpl <em>Risk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.graalextensions.impl.RiskImpl
	 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getRisk()
	 * @generated
	 */
	int RISK = 0;

	/**
	 * The feature id for the '<em><b>Benefits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__BENEFITS = EnvironmentPackage.META_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Drawbacks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__DRAWBACKS = EnvironmentPackage.META_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Risk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__RISK = EnvironmentPackage.META_DATA_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Risk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK_FEATURE_COUNT = EnvironmentPackage.META_DATA_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.graalextensions.BenefitsLevel <em>Benefits Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.graalextensions.BenefitsLevel
	 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getBenefitsLevel()
	 * @generated
	 */
	int BENEFITS_LEVEL = 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.graalextensions.DrawbacksLevel <em>Drawbacks Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.graalextensions.DrawbacksLevel
	 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getDrawbacksLevel()
	 * @generated
	 */
	int DRAWBACKS_LEVEL = 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.graalextensions.RiskLevel <em>Risk Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.graalextensions.RiskLevel
	 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getRiskLevel()
	 * @generated
	 */
	int RISK_LEVEL = 3;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.graalextensions.Risk <em>Risk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Risk</em>'.
	 * @see org.obeonetwork.graalextensions.Risk
	 * @generated
	 */
	EClass getRisk();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.graalextensions.Risk#getBenefits <em>Benefits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Benefits</em>'.
	 * @see org.obeonetwork.graalextensions.Risk#getBenefits()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Benefits();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.graalextensions.Risk#getDrawbacks <em>Drawbacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drawbacks</em>'.
	 * @see org.obeonetwork.graalextensions.Risk#getDrawbacks()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Drawbacks();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.graalextensions.Risk#getRisk <em>Risk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Risk</em>'.
	 * @see org.obeonetwork.graalextensions.Risk#getRisk()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Risk();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.graalextensions.BenefitsLevel <em>Benefits Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Benefits Level</em>'.
	 * @see org.obeonetwork.graalextensions.BenefitsLevel
	 * @generated
	 */
	EEnum getBenefitsLevel();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.graalextensions.DrawbacksLevel <em>Drawbacks Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Drawbacks Level</em>'.
	 * @see org.obeonetwork.graalextensions.DrawbacksLevel
	 * @generated
	 */
	EEnum getDrawbacksLevel();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.graalextensions.RiskLevel <em>Risk Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Risk Level</em>'.
	 * @see org.obeonetwork.graalextensions.RiskLevel
	 * @generated
	 */
	EEnum getRiskLevel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraalExtensionsFactory getGraalExtensionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.graalextensions.impl.RiskImpl <em>Risk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.graalextensions.impl.RiskImpl
		 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getRisk()
		 * @generated
		 */
		EClass RISK = eINSTANCE.getRisk();

		/**
		 * The meta object literal for the '<em><b>Benefits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RISK__BENEFITS = eINSTANCE.getRisk_Benefits();

		/**
		 * The meta object literal for the '<em><b>Drawbacks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RISK__DRAWBACKS = eINSTANCE.getRisk_Drawbacks();

		/**
		 * The meta object literal for the '<em><b>Risk</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RISK__RISK = eINSTANCE.getRisk_Risk();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.graalextensions.BenefitsLevel <em>Benefits Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.graalextensions.BenefitsLevel
		 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getBenefitsLevel()
		 * @generated
		 */
		EEnum BENEFITS_LEVEL = eINSTANCE.getBenefitsLevel();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.graalextensions.DrawbacksLevel <em>Drawbacks Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.graalextensions.DrawbacksLevel
		 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getDrawbacksLevel()
		 * @generated
		 */
		EEnum DRAWBACKS_LEVEL = eINSTANCE.getDrawbacksLevel();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.graalextensions.RiskLevel <em>Risk Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.graalextensions.RiskLevel
		 * @see org.obeonetwork.graalextensions.impl.GraalExtensionsPackageImpl#getRiskLevel()
		 * @generated
		 */
		EEnum RISK_LEVEL = eINSTANCE.getRiskLevel();

	}

} //GraalExtensionsPackage
