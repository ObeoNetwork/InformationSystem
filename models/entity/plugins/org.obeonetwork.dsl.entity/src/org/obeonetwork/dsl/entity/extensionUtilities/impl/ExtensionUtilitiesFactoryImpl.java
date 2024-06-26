/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.extensionUtilities.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.obeonetwork.dsl.entity.extensionUtilities.*;
import org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter;
import org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesFactory;
import org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ExtensionUtilitiesFactoryImpl extends EFactoryImpl implements
		ExtensionUtilitiesFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ExtensionUtilitiesFactory init() {
		try {
			ExtensionUtilitiesFactory theExtensionUtilitiesFactory = (ExtensionUtilitiesFactory)EPackage.Registry.INSTANCE.getEFactory(ExtensionUtilitiesPackage.eNS_URI);
			if (theExtensionUtilitiesFactory != null) {
				return theExtensionUtilitiesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExtensionUtilitiesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ExtensionUtilitiesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExtensionUtilitiesPackage.ENTITY_FILTER: return (EObject)createEntityFilter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EntityFilter createEntityFilter() {
		EntityFilterImpl entityFilter = new EntityFilterImpl();
		return entityFilter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionUtilitiesPackage getExtensionUtilitiesPackage() {
		return (ExtensionUtilitiesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExtensionUtilitiesPackage getPackage() {
		return ExtensionUtilitiesPackage.eINSTANCE;
	}

} // ExtensionUtilitiesFactoryImpl
