/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.graalfeatureextensions;

import org.eclipse.sirius.viewpoint.ViewpointPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsFactory
 * @model kind="package"
 * @generated
 */
public interface GraalfeatureextensionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graalfeatureextensions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.obeonetwork.graal/featureextensions/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graal-feature-extensions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraalfeatureextensionsPackage eINSTANCE = org.obeonetwork.graal.design.graalfeatureextensions.impl.GraalfeatureextensionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.graal.design.graalfeatureextensions.impl.UIConfigurationImpl <em>UI Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.impl.UIConfigurationImpl
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.impl.GraalfeatureextensionsPackageImpl#getUIConfiguration()
	 * @generated
	 */
	int UI_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CONFIGURATION__DESCRIPTION = ViewpointPackage.DFEATURE_EXTENSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Viewpoint Analysis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CONFIGURATION__VIEWPOINT_ANALYSIS = ViewpointPackage.DFEATURE_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Active User Stories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CONFIGURATION__ACTIVE_USER_STORIES = ViewpointPackage.DFEATURE_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UI Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CONFIGURATION_FEATURE_COUNT = ViewpointPackage.DFEATURE_EXTENSION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration <em>UI Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Configuration</em>'.
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration
	 * @generated
	 */
	EClass getUIConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration#getViewpointAnalysis <em>Viewpoint Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Viewpoint Analysis</em>'.
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration#getViewpointAnalysis()
	 * @see #getUIConfiguration()
	 * @generated
	 */
	EReference getUIConfiguration_ViewpointAnalysis();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration#getActiveUserStories <em>Active User Stories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active User Stories</em>'.
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration#getActiveUserStories()
	 * @see #getUIConfiguration()
	 * @generated
	 */
	EReference getUIConfiguration_ActiveUserStories();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraalfeatureextensionsFactory getGraalfeatureextensionsFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.graal.design.graalfeatureextensions.impl.UIConfigurationImpl <em>UI Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.graal.design.graalfeatureextensions.impl.UIConfigurationImpl
		 * @see org.obeonetwork.graal.design.graalfeatureextensions.impl.GraalfeatureextensionsPackageImpl#getUIConfiguration()
		 * @generated
		 */
		EClass UI_CONFIGURATION = eINSTANCE.getUIConfiguration();

		/**
		 * The meta object literal for the '<em><b>Viewpoint Analysis</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_CONFIGURATION__VIEWPOINT_ANALYSIS = eINSTANCE.getUIConfiguration_ViewpointAnalysis();

		/**
		 * The meta object literal for the '<em><b>Active User Stories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_CONFIGURATION__ACTIVE_USER_STORIES = eINSTANCE.getUIConfiguration_ActiveUserStories();

	}

} //GraalfeatureextensionsPackage
