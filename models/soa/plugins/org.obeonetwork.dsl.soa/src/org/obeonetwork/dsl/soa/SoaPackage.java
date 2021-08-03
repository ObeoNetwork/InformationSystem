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
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

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
 * @see org.obeonetwork.dsl.soa.SoaFactory
 * @model kind="package"
 * @generated
 */
public interface SoaPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "soa";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/soa/3.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "soa";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SoaPackage eINSTANCE = org.obeonetwork.dsl.soa.impl.SoaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.SystemImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__TECHNICALID = EnvironmentPackage.NAMESPACE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__METADATAS = EnvironmentPackage.NAMESPACE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DESCRIPTION = EnvironmentPackage.NAMESPACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__KEYWORDS = EnvironmentPackage.NAMESPACE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BEHAVIOURS = EnvironmentPackage.NAMESPACE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BINDING_REGISTRIES = EnvironmentPackage.NAMESPACE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__VERSION = EnvironmentPackage.NAMESPACE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CREATED_ON = EnvironmentPackage.NAMESPACE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MODIFIED_ON = EnvironmentPackage.NAMESPACE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__TYPES = EnvironmentPackage.NAMESPACE__TYPES;

	/**
	 * The feature id for the '<em><b>Owned Namespaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_NAMESPACES = EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNER = EnvironmentPackage.NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = EnvironmentPackage.NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_COMPONENTS = EnvironmentPackage.NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_WIRES = EnvironmentPackage.NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = EnvironmentPackage.NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ComponentImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Owned Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OWNED_SERVICES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REQUIRED_SERVICES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provided Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROVIDED_SERVICES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implementations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__IMPLEMENTATIONS = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OWNED_BINDING = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Block</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__BLOCK = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__URI = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Api Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__API_VERSION = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DEPRECATED = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Security Schemes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SECURITY_SCHEMES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>License</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__LICENSE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INFORMATION = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Contact</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CONTACT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Servers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SERVERS = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ServiceImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Owned Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__OWNED_INTERFACE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Synchronization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SYNCHRONIZATION = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__KIND = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referenced Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__REFERENCED_INTERFACE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BINDINGS = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Used Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__USED_TYPES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__URI = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.WireImpl <em>Wire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.WireImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getWire()
	 * @generated
	 */
	int WIRE = 3;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__SOURCE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__DEST = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Wire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.BindingImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 4;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Technology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__TECHNOLOGY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.InterfaceImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 5;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__OWNED_OPERATIONS = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.OperationImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TECHNICALID = EnvironmentPackage.ACTION__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__METADATAS = EnvironmentPackage.ACTION__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DESCRIPTION = EnvironmentPackage.ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__KEYWORDS = EnvironmentPackage.ACTION__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__BEHAVIOURS = EnvironmentPackage.ACTION__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__BINDING_REGISTRIES = EnvironmentPackage.ACTION__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VERSION = EnvironmentPackage.ACTION__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__CREATED_ON = EnvironmentPackage.ACTION__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__MODIFIED_ON = EnvironmentPackage.ACTION__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = EnvironmentPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__INPUT = EnvironmentPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OUTPUT = EnvironmentPackage.ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__KIND = EnvironmentPackage.ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PUBLIC = EnvironmentPackage.ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fault</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__FAULT = EnvironmentPackage.ACTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__URI = EnvironmentPackage.ACTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Verb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VERB = EnvironmentPackage.ACTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Exposition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__EXPOSITION = EnvironmentPackage.ACTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Paged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PAGED = EnvironmentPackage.ACTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Security Schemes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__SECURITY_SCHEMES = EnvironmentPackage.ACTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Servers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__SERVERS = EnvironmentPackage.ACTION_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = EnvironmentPackage.ACTION_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ParameterImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 8;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl <em>Implementation Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getImplementationComponent()
	 * @generated
	 */
	int IMPLEMENTATION_COMPONENT = 7;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Implement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__IMPLEMENT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT__ENTITIES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Implementation Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Media Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MEDIA_TYPE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MULTIPLICITY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_UNIQUE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_ORDERED = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__STATUS_CODE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Status Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__STATUS_MESSAGE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Rest Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__REST_DATA = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ParameterRestDataImpl <em>Parameter Rest Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ParameterRestDataImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getParameterRestData()
	 * @generated
	 */
	int PARAMETER_REST_DATA = 9;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REST_DATA__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Passing Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REST_DATA__PASSING_MODE = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rest Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REST_DATA__REST_ID = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Rest Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REST_DATA_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl <em>Security Scheme</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSecurityScheme()
	 * @generated
	 */
	int SECURITY_SCHEME = 10;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__KEY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__TYPE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Api Key Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__API_KEY_LOCATION = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Connect URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__CONNECT_URL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__FLOWS = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Http Scheme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__HTTP_SCHEME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME__FORMAT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Security Scheme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_SCHEME_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.FlowImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 11;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Flow Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__FLOW_TYPE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Authorization URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__AUTHORIZATION_URL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Token URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__TOKEN_URL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Refresh URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__REFRESH_URL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__SCOPES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.InformationImpl <em>Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.InformationImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getInformation()
	 * @generated
	 */
	int INFORMATION = 12;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Api Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__API_VERSION = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Terms Of Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__TERMS_OF_SERVICE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ContactImpl <em>Contact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ContactImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getContact()
	 * @generated
	 */
	int CONTACT = 13;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__URL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__EMAIL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.LicenseImpl <em>License</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.LicenseImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getLicense()
	 * @generated
	 */
	int LICENSE = 14;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__URL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>License</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.MediaTypeImpl <em>Media Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.MediaTypeImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getMediaType()
	 * @generated
	 */
	int MEDIA_TYPE = 15;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ExampleImpl <em>Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ExampleImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getExample()
	 * @generated
	 */
	int EXAMPLE = 16;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__IDENTIFIER = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Examples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE__EXAMPLES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Media Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_TYPE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Summary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__SUMMARY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__VALUE = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.PropertiesExtensionImpl <em>Properties Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.PropertiesExtensionImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getPropertiesExtension()
	 * @generated
	 */
	int PROPERTIES_EXTENSION = 17;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EXTENSION__TECHNICALID = EnvironmentPackage.ANNOTATION__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EXTENSION__TITLE = EnvironmentPackage.ANNOTATION__TITLE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EXTENSION__BODY = EnvironmentPackage.ANNOTATION__BODY;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EXTENSION__CONTEXT = EnvironmentPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Properties Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EXTENSION_FEATURE_COUNT = EnvironmentPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ServerImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getServer()
	 * @generated
	 */
	int SERVER = 18;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__URL = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.InterfaceKind <em>Interface Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.InterfaceKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getInterfaceKind()
	 * @generated
	 */
	int INTERFACE_KIND = 19;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.SynchronizationKind <em>Synchronization Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.SynchronizationKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSynchronizationKind()
	 * @generated
	 */
	int SYNCHRONIZATION_KIND = 20;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.BindingKind <em>Binding Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.BindingKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getBindingKind()
	 * @generated
	 */
	int BINDING_KIND = 21;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.OperationKind <em>Operation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.OperationKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getOperationKind()
	 * @generated
	 */
	int OPERATION_KIND = 22;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.Verb <em>Verb</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.Verb
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getVerb()
	 * @generated
	 */
	int VERB = 23;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.ParameterPassingMode <em>Parameter Passing Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.ParameterPassingMode
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getParameterPassingMode()
	 * @generated
	 */
	int PARAMETER_PASSING_MODE = 24;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.ExpositionKind <em>Exposition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.ExpositionKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getExpositionKind()
	 * @generated
	 */
	int EXPOSITION_KIND = 25;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.SecuritySchemeType <em>Security Scheme Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.SecuritySchemeType
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSecuritySchemeType()
	 * @generated
	 */
	int SECURITY_SCHEME_TYPE = 26;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.ApiKeyLocation <em>Api Key Location</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.ApiKeyLocation
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getApiKeyLocation()
	 * @generated
	 */
	int API_KEY_LOCATION = 27;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.HttpScheme <em>Http Scheme</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.HttpScheme
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getHttpScheme()
	 * @generated
	 */
	int HTTP_SCHEME = 28;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.FlowType <em>Flow Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.FlowType
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getFlowType()
	 * @generated
	 */
	int FLOW_TYPE = 29;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.obeonetwork.dsl.soa.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.System#getOwnedComponents <em>Owned Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Components</em>'.
	 * @see org.obeonetwork.dsl.soa.System#getOwnedComponents()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_OwnedComponents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.System#getOwnedWires <em>Owned Wires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Wires</em>'.
	 * @see org.obeonetwork.dsl.soa.System#getOwnedWires()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_OwnedWires();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.obeonetwork.dsl.soa.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Component#getOwnedServices <em>Owned Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Services</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getOwnedServices()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_OwnedServices();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.soa.Component#getRequiredServices <em>Required Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Services</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getRequiredServices()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_RequiredServices();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.soa.Component#getProvidedServices <em>Provided Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provided Services</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getProvidedServices()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ProvidedServices();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Component#getImplementations <em>Implementations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implementations</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getImplementations()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Implementations();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Component#getOwnedBinding <em>Owned Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Binding</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getOwnedBinding()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_OwnedBinding();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.soa.Component#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Block</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getBlock()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Block();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Component#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getURI()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_URI();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Component#getApiVersion <em>Api Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Version</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getApiVersion()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_ApiVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Component#isDeprecated <em>Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#isDeprecated()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Deprecated();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Component#getSecuritySchemes <em>Security Schemes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Security Schemes</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getSecuritySchemes()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_SecuritySchemes();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.soa.Component#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>License</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getLicense()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_License();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.soa.Component#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Information</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getInformation()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Information();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.soa.Component#getContact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contact</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getContact()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Contact();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Component#getServers <em>Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Servers</em>'.
	 * @see org.obeonetwork.dsl.soa.Component#getServers()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Servers();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.obeonetwork.dsl.soa.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.soa.Service#getOwnedInterface <em>Owned Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Interface</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getOwnedInterface()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_OwnedInterface();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Service#getSynchronization <em>Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synchronization</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getSynchronization()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Synchronization();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Service#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getKind()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.soa.Service#getReferencedInterface <em>Referenced Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Interface</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getReferencedInterface()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ReferencedInterface();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.soa.Service#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bindings</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getBindings()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Bindings();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.soa.Service#getUsedTypes <em>Used Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used Types</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getUsedTypes()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_UsedTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Service#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.obeonetwork.dsl.soa.Service#getURI()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_URI();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Wire <em>Wire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wire</em>'.
	 * @see org.obeonetwork.dsl.soa.Wire
	 * @generated
	 */
	EClass getWire();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.soa.Wire#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.obeonetwork.dsl.soa.Wire#getSource()
	 * @see #getWire()
	 * @generated
	 */
	EReference getWire_Source();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.soa.Wire#getDest <em>Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dest</em>'.
	 * @see org.obeonetwork.dsl.soa.Wire#getDest()
	 * @see #getWire()
	 * @generated
	 */
	EReference getWire_Dest();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see org.obeonetwork.dsl.soa.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Binding#getTechnology <em>Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Technology</em>'.
	 * @see org.obeonetwork.dsl.soa.Binding#getTechnology()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Technology();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see org.obeonetwork.dsl.soa.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Interface#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see org.obeonetwork.dsl.soa.Interface#getOwnedOperations()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_OwnedOperations();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Interface#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.Interface#getName()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Operation#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getInput()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Input();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Operation#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getOutput()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Output();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Operation#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getKind()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Operation#isPublic <em>Public</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#isPublic()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Public();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Operation#getFault <em>Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fault</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getFault()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Fault();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Operation#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getURI()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_URI();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Operation#getVerb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verb</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getVerb()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Verb();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Operation#getExposition <em>Exposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exposition</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getExposition()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Exposition();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Operation#isPaged <em>Paged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paged</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#isPaged()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Paged();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.soa.Operation#getSecuritySchemes <em>Security Schemes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Security Schemes</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getSecuritySchemes()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_SecuritySchemes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Operation#getServers <em>Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Servers</em>'.
	 * @see org.obeonetwork.dsl.soa.Operation#getServers()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Servers();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.ImplementationComponent <em>Implementation Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation Component</em>'.
	 * @see org.obeonetwork.dsl.soa.ImplementationComponent
	 * @generated
	 */
	EClass getImplementationComponent();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.soa.ImplementationComponent#getImplement <em>Implement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implement</em>'.
	 * @see org.obeonetwork.dsl.soa.ImplementationComponent#getImplement()
	 * @see #getImplementationComponent()
	 * @generated
	 */
	EReference getImplementationComponent_Implement();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.soa.ImplementationComponent#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entities</em>'.
	 * @see org.obeonetwork.dsl.soa.ImplementationComponent#getEntities()
	 * @see #getImplementationComponent()
	 * @generated
	 */
	EReference getImplementationComponent_Entities();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.soa.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Parameter#getMediaType <em>Media Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Media Type</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getMediaType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_MediaType();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getMultiplicity()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Multiplicity();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#isIsUnique()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_IsUnique();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#isIsOrdered()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_IsOrdered();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#getStatusCode <em>Status Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Code</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getStatusCode()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_StatusCode();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#getStatusMessage <em>Status Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Message</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getStatusMessage()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_StatusMessage();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.soa.Parameter#getRestData <em>Rest Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rest Data</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getRestData()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_RestData();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.ParameterRestData <em>Parameter Rest Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Rest Data</em>'.
	 * @see org.obeonetwork.dsl.soa.ParameterRestData
	 * @generated
	 */
	EClass getParameterRestData();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.ParameterRestData#getPassingMode <em>Passing Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passing Mode</em>'.
	 * @see org.obeonetwork.dsl.soa.ParameterRestData#getPassingMode()
	 * @see #getParameterRestData()
	 * @generated
	 */
	EAttribute getParameterRestData_PassingMode();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.ParameterRestData#getRestId <em>Rest Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rest Id</em>'.
	 * @see org.obeonetwork.dsl.soa.ParameterRestData#getRestId()
	 * @see #getParameterRestData()
	 * @generated
	 */
	EAttribute getParameterRestData_RestId();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.SecurityScheme <em>Security Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Scheme</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme
	 * @generated
	 */
	EClass getSecurityScheme();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.SecurityScheme#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getKey()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.SecurityScheme#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getType()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.SecurityScheme#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getName()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.SecurityScheme#getApiKeyLocation <em>Api Key Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Key Location</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getApiKeyLocation()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_ApiKeyLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.SecurityScheme#getConnectURL <em>Connect URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connect URL</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getConnectURL()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_ConnectURL();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.SecurityScheme#getFlows <em>Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flows</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getFlows()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EReference getSecurityScheme_Flows();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.SecurityScheme#getHttpScheme <em>Http Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Http Scheme</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getHttpScheme()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_HttpScheme();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.SecurityScheme#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.obeonetwork.dsl.soa.SecurityScheme#getFormat()
	 * @see #getSecurityScheme()
	 * @generated
	 */
	EAttribute getSecurityScheme_Format();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see org.obeonetwork.dsl.soa.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Flow#getFlowType <em>Flow Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flow Type</em>'.
	 * @see org.obeonetwork.dsl.soa.Flow#getFlowType()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_FlowType();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Flow#getAuthorizationURL <em>Authorization URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authorization URL</em>'.
	 * @see org.obeonetwork.dsl.soa.Flow#getAuthorizationURL()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_AuthorizationURL();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Flow#getTokenURL <em>Token URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token URL</em>'.
	 * @see org.obeonetwork.dsl.soa.Flow#getTokenURL()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_TokenURL();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Flow#getRefreshURL <em>Refresh URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Refresh URL</em>'.
	 * @see org.obeonetwork.dsl.soa.Flow#getRefreshURL()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_RefreshURL();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.soa.Flow#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scopes</em>'.
	 * @see org.obeonetwork.dsl.soa.Flow#getScopes()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Scopes();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Information <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information</em>'.
	 * @see org.obeonetwork.dsl.soa.Information
	 * @generated
	 */
	EClass getInformation();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Information#getApiVersion <em>Api Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Version</em>'.
	 * @see org.obeonetwork.dsl.soa.Information#getApiVersion()
	 * @see #getInformation()
	 * @generated
	 */
	EAttribute getInformation_ApiVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Information#getTermsOfService <em>Terms Of Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terms Of Service</em>'.
	 * @see org.obeonetwork.dsl.soa.Information#getTermsOfService()
	 * @see #getInformation()
	 * @generated
	 */
	EAttribute getInformation_TermsOfService();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Contact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contact</em>'.
	 * @see org.obeonetwork.dsl.soa.Contact
	 * @generated
	 */
	EClass getContact();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Contact#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.Contact#getName()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Contact#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.obeonetwork.dsl.soa.Contact#getURL()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_URL();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Contact#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.obeonetwork.dsl.soa.Contact#getEmail()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Email();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.License <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>License</em>'.
	 * @see org.obeonetwork.dsl.soa.License
	 * @generated
	 */
	EClass getLicense();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.License#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.License#getName()
	 * @see #getLicense()
	 * @generated
	 */
	EAttribute getLicense_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.License#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.obeonetwork.dsl.soa.License#getURL()
	 * @see #getLicense()
	 * @generated
	 */
	EAttribute getLicense_URL();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.MediaType <em>Media Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Media Type</em>'.
	 * @see org.obeonetwork.dsl.soa.MediaType
	 * @generated
	 */
	EClass getMediaType();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.MediaType#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.obeonetwork.dsl.soa.MediaType#getIdentifier()
	 * @see #getMediaType()
	 * @generated
	 */
	EAttribute getMediaType_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.MediaType#getExamples <em>Examples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Examples</em>'.
	 * @see org.obeonetwork.dsl.soa.MediaType#getExamples()
	 * @see #getMediaType()
	 * @generated
	 */
	EReference getMediaType_Examples();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Example <em>Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Example</em>'.
	 * @see org.obeonetwork.dsl.soa.Example
	 * @generated
	 */
	EClass getExample();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Example#getSummary <em>Summary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Summary</em>'.
	 * @see org.obeonetwork.dsl.soa.Example#getSummary()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_Summary();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Example#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.obeonetwork.dsl.soa.Example#getValue()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Example#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.Example#getName()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.PropertiesExtension <em>Properties Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Extension</em>'.
	 * @see org.obeonetwork.dsl.soa.PropertiesExtension
	 * @generated
	 */
	EClass getPropertiesExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.PropertiesExtension#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see org.obeonetwork.dsl.soa.PropertiesExtension#getContext()
	 * @see #getPropertiesExtension()
	 * @generated
	 */
	EAttribute getPropertiesExtension_Context();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Server <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see org.obeonetwork.dsl.soa.Server
	 * @generated
	 */
	EClass getServer();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Server#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.obeonetwork.dsl.soa.Server#getURL()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_URL();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.InterfaceKind <em>Interface Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interface Kind</em>'.
	 * @see org.obeonetwork.dsl.soa.InterfaceKind
	 * @generated
	 */
	EEnum getInterfaceKind();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.SynchronizationKind <em>Synchronization Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synchronization Kind</em>'.
	 * @see org.obeonetwork.dsl.soa.SynchronizationKind
	 * @generated
	 */
	EEnum getSynchronizationKind();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.BindingKind <em>Binding Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binding Kind</em>'.
	 * @see org.obeonetwork.dsl.soa.BindingKind
	 * @generated
	 */
	EEnum getBindingKind();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.OperationKind <em>Operation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation Kind</em>'.
	 * @see org.obeonetwork.dsl.soa.OperationKind
	 * @generated
	 */
	EEnum getOperationKind();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.Verb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Verb</em>'.
	 * @see org.obeonetwork.dsl.soa.Verb
	 * @generated
	 */
	EEnum getVerb();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.ParameterPassingMode <em>Parameter Passing Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter Passing Mode</em>'.
	 * @see org.obeonetwork.dsl.soa.ParameterPassingMode
	 * @generated
	 */
	EEnum getParameterPassingMode();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.ExpositionKind <em>Exposition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Exposition Kind</em>'.
	 * @see org.obeonetwork.dsl.soa.ExpositionKind
	 * @generated
	 */
	EEnum getExpositionKind();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.SecuritySchemeType <em>Security Scheme Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Security Scheme Type</em>'.
	 * @see org.obeonetwork.dsl.soa.SecuritySchemeType
	 * @generated
	 */
	EEnum getSecuritySchemeType();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.ApiKeyLocation <em>Api Key Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Api Key Location</em>'.
	 * @see org.obeonetwork.dsl.soa.ApiKeyLocation
	 * @generated
	 */
	EEnum getApiKeyLocation();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.HttpScheme <em>Http Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Http Scheme</em>'.
	 * @see org.obeonetwork.dsl.soa.HttpScheme
	 * @generated
	 */
	EEnum getHttpScheme();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.soa.FlowType <em>Flow Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Flow Type</em>'.
	 * @see org.obeonetwork.dsl.soa.FlowType
	 * @generated
	 */
	EEnum getFlowType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SoaFactory getSoaFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.SystemImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Owned Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__OWNED_COMPONENTS = eINSTANCE.getSystem_OwnedComponents();

		/**
		 * The meta object literal for the '<em><b>Owned Wires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__OWNED_WIRES = eINSTANCE.getSystem_OwnedWires();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ComponentImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Owned Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OWNED_SERVICES = eINSTANCE.getComponent_OwnedServices();

		/**
		 * The meta object literal for the '<em><b>Required Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__REQUIRED_SERVICES = eINSTANCE.getComponent_RequiredServices();

		/**
		 * The meta object literal for the '<em><b>Provided Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PROVIDED_SERVICES = eINSTANCE.getComponent_ProvidedServices();

		/**
		 * The meta object literal for the '<em><b>Implementations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__IMPLEMENTATIONS = eINSTANCE.getComponent_Implementations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Binding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OWNED_BINDING = eINSTANCE.getComponent_OwnedBinding();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__BLOCK = eINSTANCE.getComponent_Block();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__URI = eINSTANCE.getComponent_URI();

		/**
		 * The meta object literal for the '<em><b>Api Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__API_VERSION = eINSTANCE.getComponent_ApiVersion();

		/**
		 * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__DEPRECATED = eINSTANCE.getComponent_Deprecated();

		/**
		 * The meta object literal for the '<em><b>Security Schemes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__SECURITY_SCHEMES = eINSTANCE.getComponent_SecuritySchemes();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__LICENSE = eINSTANCE.getComponent_License();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INFORMATION = eINSTANCE.getComponent_Information();

		/**
		 * The meta object literal for the '<em><b>Contact</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__CONTACT = eINSTANCE.getComponent_Contact();

		/**
		 * The meta object literal for the '<em><b>Servers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__SERVERS = eINSTANCE.getComponent_Servers();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ServiceImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Owned Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__OWNED_INTERFACE = eINSTANCE.getService_OwnedInterface();

		/**
		 * The meta object literal for the '<em><b>Synchronization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SYNCHRONIZATION = eINSTANCE.getService_Synchronization();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__KIND = eINSTANCE.getService_Kind();

		/**
		 * The meta object literal for the '<em><b>Referenced Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__REFERENCED_INTERFACE = eINSTANCE.getService_ReferencedInterface();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__BINDINGS = eINSTANCE.getService_Bindings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Used Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__USED_TYPES = eINSTANCE.getService_UsedTypes();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__URI = eINSTANCE.getService_URI();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.WireImpl <em>Wire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.WireImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getWire()
		 * @generated
		 */
		EClass WIRE = eINSTANCE.getWire();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE__SOURCE = eINSTANCE.getWire_Source();

		/**
		 * The meta object literal for the '<em><b>Dest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE__DEST = eINSTANCE.getWire_Dest();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.BindingImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Technology</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__TECHNOLOGY = eINSTANCE.getBinding_Technology();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.InterfaceImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__OWNED_OPERATIONS = eINSTANCE.getInterface_OwnedOperations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__NAME = eINSTANCE.getInterface_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.OperationImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__INPUT = eINSTANCE.getOperation_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OUTPUT = eINSTANCE.getOperation_Output();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__KIND = eINSTANCE.getOperation_Kind();

		/**
		 * The meta object literal for the '<em><b>Public</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__PUBLIC = eINSTANCE.getOperation_Public();

		/**
		 * The meta object literal for the '<em><b>Fault</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__FAULT = eINSTANCE.getOperation_Fault();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__URI = eINSTANCE.getOperation_URI();

		/**
		 * The meta object literal for the '<em><b>Verb</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__VERB = eINSTANCE.getOperation_Verb();

		/**
		 * The meta object literal for the '<em><b>Exposition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__EXPOSITION = eINSTANCE.getOperation_Exposition();

		/**
		 * The meta object literal for the '<em><b>Paged</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__PAGED = eINSTANCE.getOperation_Paged();

		/**
		 * The meta object literal for the '<em><b>Security Schemes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__SECURITY_SCHEMES = eINSTANCE.getOperation_SecuritySchemes();

		/**
		 * The meta object literal for the '<em><b>Servers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__SERVERS = eINSTANCE.getOperation_Servers();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl <em>Implementation Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getImplementationComponent()
		 * @generated
		 */
		EClass IMPLEMENTATION_COMPONENT = eINSTANCE.getImplementationComponent();

		/**
		 * The meta object literal for the '<em><b>Implement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_COMPONENT__IMPLEMENT = eINSTANCE.getImplementationComponent_Implement();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_COMPONENT__ENTITIES = eINSTANCE.getImplementationComponent_Entities();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ParameterImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Media Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__MEDIA_TYPE = eINSTANCE.getParameter_MediaType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__MULTIPLICITY = eINSTANCE.getParameter_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__IS_UNIQUE = eINSTANCE.getParameter_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__IS_ORDERED = eINSTANCE.getParameter_IsOrdered();

		/**
		 * The meta object literal for the '<em><b>Status Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__STATUS_CODE = eINSTANCE.getParameter_StatusCode();

		/**
		 * The meta object literal for the '<em><b>Status Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__STATUS_MESSAGE = eINSTANCE.getParameter_StatusMessage();

		/**
		 * The meta object literal for the '<em><b>Rest Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__REST_DATA = eINSTANCE.getParameter_RestData();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ParameterRestDataImpl <em>Parameter Rest Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ParameterRestDataImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getParameterRestData()
		 * @generated
		 */
		EClass PARAMETER_REST_DATA = eINSTANCE.getParameterRestData();

		/**
		 * The meta object literal for the '<em><b>Passing Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_REST_DATA__PASSING_MODE = eINSTANCE.getParameterRestData_PassingMode();

		/**
		 * The meta object literal for the '<em><b>Rest Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_REST_DATA__REST_ID = eINSTANCE.getParameterRestData_RestId();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl <em>Security Scheme</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSecurityScheme()
		 * @generated
		 */
		EClass SECURITY_SCHEME = eINSTANCE.getSecurityScheme();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__KEY = eINSTANCE.getSecurityScheme_Key();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__TYPE = eINSTANCE.getSecurityScheme_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__NAME = eINSTANCE.getSecurityScheme_Name();

		/**
		 * The meta object literal for the '<em><b>Api Key Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__API_KEY_LOCATION = eINSTANCE.getSecurityScheme_ApiKeyLocation();

		/**
		 * The meta object literal for the '<em><b>Connect URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__CONNECT_URL = eINSTANCE.getSecurityScheme_ConnectURL();

		/**
		 * The meta object literal for the '<em><b>Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_SCHEME__FLOWS = eINSTANCE.getSecurityScheme_Flows();

		/**
		 * The meta object literal for the '<em><b>Http Scheme</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__HTTP_SCHEME = eINSTANCE.getSecurityScheme_HttpScheme();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_SCHEME__FORMAT = eINSTANCE.getSecurityScheme_Format();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.FlowImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>Flow Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__FLOW_TYPE = eINSTANCE.getFlow_FlowType();

		/**
		 * The meta object literal for the '<em><b>Authorization URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__AUTHORIZATION_URL = eINSTANCE.getFlow_AuthorizationURL();

		/**
		 * The meta object literal for the '<em><b>Token URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__TOKEN_URL = eINSTANCE.getFlow_TokenURL();

		/**
		 * The meta object literal for the '<em><b>Refresh URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__REFRESH_URL = eINSTANCE.getFlow_RefreshURL();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__SCOPES = eINSTANCE.getFlow_Scopes();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.InformationImpl <em>Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.InformationImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getInformation()
		 * @generated
		 */
		EClass INFORMATION = eINSTANCE.getInformation();

		/**
		 * The meta object literal for the '<em><b>Api Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFORMATION__API_VERSION = eINSTANCE.getInformation_ApiVersion();

		/**
		 * The meta object literal for the '<em><b>Terms Of Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFORMATION__TERMS_OF_SERVICE = eINSTANCE.getInformation_TermsOfService();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ContactImpl <em>Contact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ContactImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getContact()
		 * @generated
		 */
		EClass CONTACT = eINSTANCE.getContact();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__NAME = eINSTANCE.getContact_Name();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__URL = eINSTANCE.getContact_URL();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__EMAIL = eINSTANCE.getContact_Email();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.LicenseImpl <em>License</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.LicenseImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getLicense()
		 * @generated
		 */
		EClass LICENSE = eINSTANCE.getLicense();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LICENSE__NAME = eINSTANCE.getLicense_Name();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LICENSE__URL = eINSTANCE.getLicense_URL();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.MediaTypeImpl <em>Media Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.MediaTypeImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getMediaType()
		 * @generated
		 */
		EClass MEDIA_TYPE = eINSTANCE.getMediaType();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_TYPE__IDENTIFIER = eINSTANCE.getMediaType_Identifier();

		/**
		 * The meta object literal for the '<em><b>Examples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEDIA_TYPE__EXAMPLES = eINSTANCE.getMediaType_Examples();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ExampleImpl <em>Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ExampleImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getExample()
		 * @generated
		 */
		EClass EXAMPLE = eINSTANCE.getExample();

		/**
		 * The meta object literal for the '<em><b>Summary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__SUMMARY = eINSTANCE.getExample_Summary();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__VALUE = eINSTANCE.getExample_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__NAME = eINSTANCE.getExample_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.PropertiesExtensionImpl <em>Properties Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.PropertiesExtensionImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getPropertiesExtension()
		 * @generated
		 */
		EClass PROPERTIES_EXTENSION = eINSTANCE.getPropertiesExtension();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_EXTENSION__CONTEXT = eINSTANCE.getPropertiesExtension_Context();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ServerImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getServer()
		 * @generated
		 */
		EClass SERVER = eINSTANCE.getServer();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__URL = eINSTANCE.getServer_URL();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.InterfaceKind <em>Interface Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.InterfaceKind
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getInterfaceKind()
		 * @generated
		 */
		EEnum INTERFACE_KIND = eINSTANCE.getInterfaceKind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.SynchronizationKind <em>Synchronization Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.SynchronizationKind
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSynchronizationKind()
		 * @generated
		 */
		EEnum SYNCHRONIZATION_KIND = eINSTANCE.getSynchronizationKind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.BindingKind <em>Binding Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.BindingKind
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getBindingKind()
		 * @generated
		 */
		EEnum BINDING_KIND = eINSTANCE.getBindingKind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.OperationKind <em>Operation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.OperationKind
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getOperationKind()
		 * @generated
		 */
		EEnum OPERATION_KIND = eINSTANCE.getOperationKind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.Verb <em>Verb</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.Verb
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getVerb()
		 * @generated
		 */
		EEnum VERB = eINSTANCE.getVerb();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.ParameterPassingMode <em>Parameter Passing Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.ParameterPassingMode
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getParameterPassingMode()
		 * @generated
		 */
		EEnum PARAMETER_PASSING_MODE = eINSTANCE.getParameterPassingMode();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.ExpositionKind <em>Exposition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.ExpositionKind
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getExpositionKind()
		 * @generated
		 */
		EEnum EXPOSITION_KIND = eINSTANCE.getExpositionKind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.SecuritySchemeType <em>Security Scheme Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.SecuritySchemeType
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSecuritySchemeType()
		 * @generated
		 */
		EEnum SECURITY_SCHEME_TYPE = eINSTANCE.getSecuritySchemeType();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.ApiKeyLocation <em>Api Key Location</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.ApiKeyLocation
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getApiKeyLocation()
		 * @generated
		 */
		EEnum API_KEY_LOCATION = eINSTANCE.getApiKeyLocation();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.HttpScheme <em>Http Scheme</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.HttpScheme
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getHttpScheme()
		 * @generated
		 */
		EEnum HTTP_SCHEME = eINSTANCE.getHttpScheme();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.FlowType <em>Flow Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.FlowType
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getFlowType()
		 * @generated
		 */
		EEnum FLOW_TYPE = eINSTANCE.getFlowType();

}

} //SoaPackage
