/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.graalfeatureextensions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.obeonetwork.graal.design.graalfeatureextensions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraalfeatureextensionsFactoryImpl extends EFactoryImpl implements GraalfeatureextensionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraalfeatureextensionsFactory init() {
		try {
			GraalfeatureextensionsFactory theGraalfeatureextensionsFactory = (GraalfeatureextensionsFactory)EPackage.Registry.INSTANCE.getEFactory(GraalfeatureextensionsPackage.eNS_URI);
			if (theGraalfeatureextensionsFactory != null) {
				return theGraalfeatureextensionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraalfeatureextensionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalfeatureextensionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GraalfeatureextensionsPackage.UI_CONFIGURATION: return createUIConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIConfiguration createUIConfiguration() {
		UIConfigurationImpl uiConfiguration = new UIConfigurationImpl();
		return uiConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalfeatureextensionsPackage getGraalfeatureextensionsPackage() {
		return (GraalfeatureextensionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraalfeatureextensionsPackage getPackage() {
		return GraalfeatureextensionsPackage.eINSTANCE;
	}

} //GraalfeatureextensionsFactoryImpl
