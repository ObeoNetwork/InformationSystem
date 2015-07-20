/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	String eNS_URI = "http://www.obeonetwork.org/dsl/soa/2.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.obeonetwork.dsl.soa";

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
	 * The feature id for the '<em><b>Owned Dto Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_DTO_REGISTRY = EnvironmentPackage.NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = EnvironmentPackage.NAMESPACE_FEATURE_COUNT + 3;

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
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 7;

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
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 7;

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
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = EnvironmentPackage.ACTION_FEATURE_COUNT + 5;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__LOWER = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__UPPER = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

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
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.DTORegistryImpl <em>DTO Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.DTORegistryImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getDTORegistry()
	 * @generated
	 */
	int DTO_REGISTRY = 9;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Owned Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY__OWNED_CATEGORIES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DTO Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_REGISTRY_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.CategoryImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 10;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__TECHNICALID = EnvironmentPackage.TYPES_DEFINITION__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__METADATAS = EnvironmentPackage.TYPES_DEFINITION__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DESCRIPTION = EnvironmentPackage.TYPES_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__KEYWORDS = EnvironmentPackage.TYPES_DEFINITION__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BEHAVIOURS = EnvironmentPackage.TYPES_DEFINITION__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BINDING_REGISTRIES = EnvironmentPackage.TYPES_DEFINITION__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__VERSION = EnvironmentPackage.TYPES_DEFINITION__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CREATED_ON = EnvironmentPackage.TYPES_DEFINITION__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__MODIFIED_ON = EnvironmentPackage.TYPES_DEFINITION__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__TYPES = EnvironmentPackage.TYPES_DEFINITION__TYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = EnvironmentPackage.TYPES_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__OWNED_CATEGORIES = EnvironmentPackage.TYPES_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = EnvironmentPackage.TYPES_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.impl.ServiceDTOImpl <em>Service DTO</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.impl.ServiceDTOImpl
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getServiceDTO()
	 * @generated
	 */
	int SERVICE_DTO = 11;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__TECHNICALID = EnvironmentPackage.DTO__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__METADATAS = EnvironmentPackage.DTO__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__DESCRIPTION = EnvironmentPackage.DTO__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__KEYWORDS = EnvironmentPackage.DTO__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__BEHAVIOURS = EnvironmentPackage.DTO__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__BINDING_REGISTRIES = EnvironmentPackage.DTO__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__VERSION = EnvironmentPackage.DTO__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__CREATED_ON = EnvironmentPackage.DTO__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__MODIFIED_ON = EnvironmentPackage.DTO__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__NAME = EnvironmentPackage.DTO__NAME;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__TYPE_DEFINITION = EnvironmentPackage.DTO__TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owned Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__OWNED_CONTAINER = EnvironmentPackage.DTO__OWNED_CONTAINER;

	/**
	 * The feature id for the '<em><b>Associated Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__ASSOCIATED_TYPES = EnvironmentPackage.DTO__ASSOCIATED_TYPES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__PROPERTIES = EnvironmentPackage.DTO__PROPERTIES;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__REFERENCES = EnvironmentPackage.DTO__REFERENCES;

	/**
	 * The feature id for the '<em><b>Owned References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__OWNED_REFERENCES = EnvironmentPackage.DTO__OWNED_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__ATTRIBUTES = EnvironmentPackage.DTO__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__OWNED_ATTRIBUTES = EnvironmentPackage.DTO__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO__SUPERTYPE = EnvironmentPackage.DTO__SUPERTYPE;

	/**
	 * The number of structural features of the '<em>Service DTO</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DTO_FEATURE_COUNT = EnvironmentPackage.DTO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.InterfaceKind <em>Interface Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.InterfaceKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getInterfaceKind()
	 * @generated
	 */
	int INTERFACE_KIND = 12;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.SynchronizationKind <em>Synchronization Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.SynchronizationKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getSynchronizationKind()
	 * @generated
	 */
	int SYNCHRONIZATION_KIND = 13;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.BindingKind <em>Binding Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.BindingKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getBindingKind()
	 * @generated
	 */
	int BINDING_KIND = 14;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.soa.OperationKind <em>Operation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.soa.OperationKind
	 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getOperationKind()
	 * @generated
	 */
	int OPERATION_KIND = 15;

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
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.soa.System#getOwnedDtoRegistry <em>Owned Dto Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Dto Registry</em>'.
	 * @see org.obeonetwork.dsl.soa.System#getOwnedDtoRegistry()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_OwnedDtoRegistry();

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
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getLower()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Parameter#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.obeonetwork.dsl.soa.Parameter#getUpper()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Upper();

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
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.DTORegistry <em>DTO Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DTO Registry</em>'.
	 * @see org.obeonetwork.dsl.soa.DTORegistry
	 * @generated
	 */
	EClass getDTORegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.DTORegistry#getOwnedCategories <em>Owned Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Categories</em>'.
	 * @see org.obeonetwork.dsl.soa.DTORegistry#getOwnedCategories()
	 * @see #getDTORegistry()
	 * @generated
	 */
	EReference getDTORegistry_OwnedCategories();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.obeonetwork.dsl.soa.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.soa.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.soa.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.soa.Category#getOwnedCategories <em>Owned Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Categories</em>'.
	 * @see org.obeonetwork.dsl.soa.Category#getOwnedCategories()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_OwnedCategories();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.soa.ServiceDTO <em>Service DTO</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service DTO</em>'.
	 * @see org.obeonetwork.dsl.soa.ServiceDTO
	 * @generated
	 */
	EClass getServiceDTO();

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
		 * The meta object literal for the '<em><b>Owned Dto Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__OWNED_DTO_REGISTRY = eINSTANCE.getSystem_OwnedDtoRegistry();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__LOWER = eINSTANCE.getParameter_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__UPPER = eINSTANCE.getParameter_Upper();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.DTORegistryImpl <em>DTO Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.DTORegistryImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getDTORegistry()
		 * @generated
		 */
		EClass DTO_REGISTRY = eINSTANCE.getDTORegistry();

		/**
		 * The meta object literal for the '<em><b>Owned Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTO_REGISTRY__OWNED_CATEGORIES = eINSTANCE.getDTORegistry_OwnedCategories();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.CategoryImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__OWNED_CATEGORIES = eINSTANCE.getCategory_OwnedCategories();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.soa.impl.ServiceDTOImpl <em>Service DTO</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.soa.impl.ServiceDTOImpl
		 * @see org.obeonetwork.dsl.soa.impl.SoaPackageImpl#getServiceDTO()
		 * @generated
		 */
		EClass SERVICE_DTO = eINSTANCE.getServiceDTO();

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

}

} //SoaPackage
