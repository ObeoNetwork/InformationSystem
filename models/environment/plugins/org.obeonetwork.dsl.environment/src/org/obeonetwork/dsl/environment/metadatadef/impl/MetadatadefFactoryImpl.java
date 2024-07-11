/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.metadatadef.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.obeonetwork.dsl.environment.metadatadef.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadatadefFactoryImpl extends EFactoryImpl implements MetadatadefFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetadatadefFactory init() {
		try {
			MetadatadefFactory theMetadatadefFactory = (MetadatadefFactory) EPackage.Registry.INSTANCE
					.getEFactory(MetadatadefPackage.eNS_URI);
			if (theMetadatadefFactory != null) {
				return theMetadatadefFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetadatadefFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadatadefFactoryImpl() {
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
		case MetadatadefPackage.META_DATA_DEFINITIONS:
			return (EObject) createMetaDataDefinitions();
		case MetadatadefPackage.META_DATA_DEFINITION:
			return (EObject) createMetaDataDefinition();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaDataDefinitions createMetaDataDefinitions() {
		MetaDataDefinitionsImpl metaDataDefinitions = new MetaDataDefinitionsImpl();
		return metaDataDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaDataDefinition createMetaDataDefinition() {
		MetaDataDefinitionImpl metaDataDefinition = new MetaDataDefinitionImpl();
		return metaDataDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetadatadefPackage getMetadatadefPackage() {
		return (MetadatadefPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetadatadefPackage getPackage() {
		return MetadatadefPackage.eINSTANCE;
	}

} //MetadatadefFactoryImpl
