/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.dsl.entity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.entity.EntityFactory
 * @model kind="package"
 * @generated
 */
public interface EntityPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "entity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/entity/2.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oent";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	EntityPackage eINSTANCE = org.obeonetwork.dsl.entity.impl.EntityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.RootImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__TECHNICALID = EnvironmentPackage.NAMESPACE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__METADATAS = EnvironmentPackage.NAMESPACE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__DESCRIPTION = EnvironmentPackage.NAMESPACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__KEYWORDS = EnvironmentPackage.NAMESPACE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BEHAVIOURS = EnvironmentPackage.NAMESPACE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BINDING_REGISTRIES = EnvironmentPackage.NAMESPACE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__VERSION = EnvironmentPackage.NAMESPACE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CREATED_ON = EnvironmentPackage.NAMESPACE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__MODIFIED_ON = EnvironmentPackage.NAMESPACE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Owned Namespaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWNED_NAMESPACES = EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWNER = EnvironmentPackage.NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NAME = EnvironmentPackage.NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BLOCKS = EnvironmentPackage.NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = EnvironmentPackage.NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.BlockImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLOCK__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__ENTITIES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subblocks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__SUBBLOCKS = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Block</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.EntityImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__TECHNICALID = EnvironmentPackage.STRUCTURED_TYPE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__METADATAS = EnvironmentPackage.STRUCTURED_TYPE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__DESCRIPTION = EnvironmentPackage.STRUCTURED_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__KEYWORDS = EnvironmentPackage.STRUCTURED_TYPE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__BEHAVIOURS = EnvironmentPackage.STRUCTURED_TYPE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__BINDING_REGISTRIES = EnvironmentPackage.STRUCTURED_TYPE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__VERSION = EnvironmentPackage.STRUCTURED_TYPE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__CREATED_ON = EnvironmentPackage.STRUCTURED_TYPE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__MODIFIED_ON = EnvironmentPackage.STRUCTURED_TYPE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = EnvironmentPackage.STRUCTURED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Type Definition</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__TYPE_DEFINITION = EnvironmentPackage.STRUCTURED_TYPE__TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_ATTRIBUTES = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned References</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_REFERENCES = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY__SUPERTYPE = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ATTRIBUTES = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__REFERENCES = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__PROPERTIES = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Estimated Volumetry</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ESTIMATED_VOLUMETRY = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Estimated Access</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ESTIMATED_ACCESS = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Historized</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY__HISTORIZED = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Owned Finders</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_FINDERS = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__BLOCK = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Inheritance Kind</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__INHERITANCE_KIND = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.PropertyImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__MULTIPLICITY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_PRIMARY_KEY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.AttributeImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TECHNICALID = PROPERTY__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__METADATAS = PROPERTY__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DESCRIPTION = PROPERTY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__KEYWORDS = PROPERTY__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__BEHAVIOURS = PROPERTY__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__BINDING_REGISTRIES = PROPERTY__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VERSION = PROPERTY__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__CREATED_ON = PROPERTY__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MODIFIED_ON = PROPERTY__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MULTIPLICITY = PROPERTY__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_PRIMARY_KEY = PROPERTY__IS_PRIMARY_KEY;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ENTITY = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.ReferenceImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TECHNICALID = PROPERTY__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__METADATAS = PROPERTY__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__DESCRIPTION = PROPERTY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__KEYWORDS = PROPERTY__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__BEHAVIOURS = PROPERTY__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__BINDING_REGISTRIES = PROPERTY__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__VERSION = PROPERTY__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CREATED_ON = PROPERTY__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__MODIFIED_ON = PROPERTY__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__MULTIPLICITY = PROPERTY__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__IS_PRIMARY_KEY = PROPERTY__IS_PRIMARY_KEY;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ENTITY = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__IS_COMPOSITE = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opposite Of</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__OPPOSITE_OF = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TYPE = PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Navigable</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAVIGABLE = PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.FinderImpl <em>Finder</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.FinderImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getFinder()
	 * @generated
	 */
	int FINDER = 6;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FINDER__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__ENTITY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Customized Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__CUSTOMIZED_NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Criterions</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__CRITERIONS = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER__MULTIPLICITY = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Finder</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.CriterionImpl <em>Criterion</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.CriterionImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getCriterion()
	 * @generated
	 */
	int CRITERION = 8;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The number of structural features of the '<em>Criterion</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.InternalCriterionImpl <em>Internal Criterion</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.InternalCriterionImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getInternalCriterion()
	 * @generated
	 */
	int INTERNAL_CRITERION = 7;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__TECHNICALID = CRITERION__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__METADATAS = CRITERION__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__DESCRIPTION = CRITERION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__KEYWORDS = CRITERION__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__BEHAVIOURS = CRITERION__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__BINDING_REGISTRIES = CRITERION__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__VERSION = CRITERION__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__CREATED_ON = CRITERION__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__MODIFIED_ON = CRITERION__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__TARGET = CRITERION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION__NAME = CRITERION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Internal Criterion</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CRITERION_FEATURE_COUNT = CRITERION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.ExternalCriterionImpl <em>External Criterion</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.ExternalCriterionImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getExternalCriterion()
	 * @generated
	 */
	int EXTERNAL_CRITERION = 9;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__TECHNICALID = CRITERION__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__METADATAS = CRITERION__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__DESCRIPTION = CRITERION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__KEYWORDS = CRITERION__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__BEHAVIOURS = CRITERION__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__BINDING_REGISTRIES = CRITERION__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__VERSION = CRITERION__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__CREATED_ON = CRITERION__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__MODIFIED_ON = CRITERION__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__NAME = CRITERION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION__TYPE = CRITERION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>External Criterion</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CRITERION_FEATURE_COUNT = CRITERION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.InheritanceKind <em>Inheritance Kind</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.InheritanceKind
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getInheritanceKind()
	 * @generated
	 */
	int INHERITANCE_KIND = 10;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Root <em>Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.obeonetwork.dsl.entity.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entity.Root#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see org.obeonetwork.dsl.entity.Root#getBlocks()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Blocks();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Block <em>Block</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.obeonetwork.dsl.entity.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Block#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.entity.Block#getName()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entity.Block#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see org.obeonetwork.dsl.entity.Block#getEntities()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Entities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entity.Block#getSubblocks <em>Subblocks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subblocks</em>'.
	 * @see org.obeonetwork.dsl.entity.Block#getSubblocks()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Subblocks();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entity.Entity#getOwnedAttributes <em>Owned Attributes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attributes</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getOwnedAttributes()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_OwnedAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entity.Entity#getOwnedReferences <em>Owned References</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned References</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getOwnedReferences()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_OwnedReferences();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entity.Entity#getSupertype <em>Supertype</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supertype</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getSupertype()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Supertype();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.entity.Entity#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getAttributes()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.entity.Entity#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>References</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getReferences()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_References();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.entity.Entity#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getProperties()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Properties();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Entity#getEstimatedVolumetry <em>Estimated Volumetry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Estimated Volumetry</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getEstimatedVolumetry()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_EstimatedVolumetry();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Entity#getEstimatedAccess <em>Estimated Access</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Estimated Access</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getEstimatedAccess()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_EstimatedAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Entity#isHistorized <em>Historized</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Historized</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#isHistorized()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Historized();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entity.Entity#getOwnedFinders <em>Owned Finders</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Finders</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getOwnedFinders()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_OwnedFinders();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.entity.Entity#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getBlock()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Block();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Entity#getInheritanceKind <em>Inheritance Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inheritance Kind</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getInheritanceKind()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_InheritanceKind();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Property <em>Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.obeonetwork.dsl.entity.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.entity.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Property#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.obeonetwork.dsl.entity.Property#getMultiplicity()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Multiplicity();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Property#isIsPrimaryKey <em>Is Primary Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Primary Key</em>'.
	 * @see org.obeonetwork.dsl.entity.Property#isIsPrimaryKey()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsPrimaryKey();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.obeonetwork.dsl.entity.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.entity.Attribute#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.entity.Attribute#getEntity()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Entity();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entity.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.entity.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Type();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.obeonetwork.dsl.entity.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.entity.Reference#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.entity.Reference#getEntity()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Entity();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Reference#isIsComposite <em>Is Composite</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Composite</em>'.
	 * @see org.obeonetwork.dsl.entity.Reference#isIsComposite()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_IsComposite();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entity.Reference#getOppositeOf <em>Opposite Of</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite Of</em>'.
	 * @see org.obeonetwork.dsl.entity.Reference#getOppositeOf()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_OppositeOf();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entity.Reference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.entity.Reference#getType()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Reference#isNavigable <em>Navigable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Navigable</em>'.
	 * @see org.obeonetwork.dsl.entity.Reference#isNavigable()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Navigable();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Finder <em>Finder</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finder</em>'.
	 * @see org.obeonetwork.dsl.entity.Finder
	 * @generated
	 */
	EClass getFinder();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Finder#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.entity.Finder#getName()
	 * @see #getFinder()
	 * @generated
	 */
	EAttribute getFinder_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.entity.Finder#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.entity.Finder#getEntity()
	 * @see #getFinder()
	 * @generated
	 */
	EReference getFinder_Entity();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Finder#getCustomizedName <em>Customized Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customized Name</em>'.
	 * @see org.obeonetwork.dsl.entity.Finder#getCustomizedName()
	 * @see #getFinder()
	 * @generated
	 */
	EAttribute getFinder_CustomizedName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entity.Finder#getCriterions <em>Criterions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Criterions</em>'.
	 * @see org.obeonetwork.dsl.entity.Finder#getCriterions()
	 * @see #getFinder()
	 * @generated
	 */
	EReference getFinder_Criterions();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Finder#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.obeonetwork.dsl.entity.Finder#getMultiplicity()
	 * @see #getFinder()
	 * @generated
	 */
	EAttribute getFinder_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.InternalCriterion <em>Internal Criterion</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Criterion</em>'.
	 * @see org.obeonetwork.dsl.entity.InternalCriterion
	 * @generated
	 */
	EClass getInternalCriterion();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entity.InternalCriterion#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.obeonetwork.dsl.entity.InternalCriterion#getTarget()
	 * @see #getInternalCriterion()
	 * @generated
	 */
	EReference getInternalCriterion_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.InternalCriterion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.entity.InternalCriterion#getName()
	 * @see #getInternalCriterion()
	 * @generated
	 */
	EAttribute getInternalCriterion_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Criterion <em>Criterion</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criterion</em>'.
	 * @see org.obeonetwork.dsl.entity.Criterion
	 * @generated
	 */
	EClass getCriterion();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.ExternalCriterion <em>External Criterion</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Criterion</em>'.
	 * @see org.obeonetwork.dsl.entity.ExternalCriterion
	 * @generated
	 */
	EClass getExternalCriterion();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.ExternalCriterion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.entity.ExternalCriterion#getName()
	 * @see #getExternalCriterion()
	 * @generated
	 */
	EAttribute getExternalCriterion_Name();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entity.ExternalCriterion#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.entity.ExternalCriterion#getType()
	 * @see #getExternalCriterion()
	 * @generated
	 */
	EReference getExternalCriterion_Type();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.entity.InheritanceKind <em>Inheritance Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Inheritance Kind</em>'.
	 * @see org.obeonetwork.dsl.entity.InheritanceKind
	 * @generated
	 */
	EEnum getInheritanceKind();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EntityFactory getEntityFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.RootImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ROOT__BLOCKS = eINSTANCE.getRoot_Blocks();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.BlockImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__NAME = eINSTANCE.getBlock_Name();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__ENTITIES = eINSTANCE.getBlock_Entities();

		/**
		 * The meta object literal for the '<em><b>Subblocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__SUBBLOCKS = eINSTANCE.getBlock_Subblocks();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.EntityImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Owned Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__OWNED_ATTRIBUTES = eINSTANCE.getEntity_OwnedAttributes();

		/**
		 * The meta object literal for the '<em><b>Owned References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__OWNED_REFERENCES = eINSTANCE.getEntity_OwnedReferences();

		/**
		 * The meta object literal for the '<em><b>Supertype</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__SUPERTYPE = eINSTANCE.getEntity_Supertype();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__ATTRIBUTES = eINSTANCE.getEntity_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__REFERENCES = eINSTANCE.getEntity_References();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__PROPERTIES = eINSTANCE.getEntity_Properties();

		/**
		 * The meta object literal for the '<em><b>Estimated Volumetry</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__ESTIMATED_VOLUMETRY = eINSTANCE.getEntity_EstimatedVolumetry();

		/**
		 * The meta object literal for the '<em><b>Estimated Access</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__ESTIMATED_ACCESS = eINSTANCE.getEntity_EstimatedAccess();

		/**
		 * The meta object literal for the '<em><b>Historized</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__HISTORIZED = eINSTANCE.getEntity_Historized();

		/**
		 * The meta object literal for the '<em><b>Owned Finders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__OWNED_FINDERS = eINSTANCE.getEntity_OwnedFinders();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__BLOCK = eINSTANCE.getEntity_Block();

		/**
		 * The meta object literal for the '<em><b>Inheritance Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__INHERITANCE_KIND = eINSTANCE.getEntity_InheritanceKind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.PropertyImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__MULTIPLICITY = eINSTANCE.getProperty_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Is Primary Key</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_PRIMARY_KEY = eINSTANCE.getProperty_IsPrimaryKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.AttributeImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__ENTITY = eINSTANCE.getAttribute_Entity();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.ReferenceImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__ENTITY = eINSTANCE.getReference_Entity();

		/**
		 * The meta object literal for the '<em><b>Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__IS_COMPOSITE = eINSTANCE.getReference_IsComposite();

		/**
		 * The meta object literal for the '<em><b>Opposite Of</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__OPPOSITE_OF = eINSTANCE.getReference_OppositeOf();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__TYPE = eINSTANCE.getReference_Type();

		/**
		 * The meta object literal for the '<em><b>Navigable</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__NAVIGABLE = eINSTANCE.getReference_Navigable();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.FinderImpl <em>Finder</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.FinderImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getFinder()
		 * @generated
		 */
		EClass FINDER = eINSTANCE.getFinder();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINDER__NAME = eINSTANCE.getFinder_Name();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference FINDER__ENTITY = eINSTANCE.getFinder_Entity();

		/**
		 * The meta object literal for the '<em><b>Customized Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINDER__CUSTOMIZED_NAME = eINSTANCE.getFinder_CustomizedName();

		/**
		 * The meta object literal for the '<em><b>Criterions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference FINDER__CRITERIONS = eINSTANCE.getFinder_Criterions();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINDER__MULTIPLICITY = eINSTANCE.getFinder_Multiplicity();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.InternalCriterionImpl <em>Internal Criterion</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.InternalCriterionImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getInternalCriterion()
		 * @generated
		 */
		EClass INTERNAL_CRITERION = eINSTANCE.getInternalCriterion();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_CRITERION__TARGET = eINSTANCE.getInternalCriterion_Target();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_CRITERION__NAME = eINSTANCE.getInternalCriterion_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.CriterionImpl <em>Criterion</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.CriterionImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getCriterion()
		 * @generated
		 */
		EClass CRITERION = eINSTANCE.getCriterion();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.ExternalCriterionImpl <em>External Criterion</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.ExternalCriterionImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getExternalCriterion()
		 * @generated
		 */
		EClass EXTERNAL_CRITERION = eINSTANCE.getExternalCriterion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_CRITERION__NAME = eINSTANCE.getExternalCriterion_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CRITERION__TYPE = eINSTANCE.getExternalCriterion_Type();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.InheritanceKind <em>Inheritance Kind</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.InheritanceKind
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getInheritanceKind()
		 * @generated
		 */
		EEnum INHERITANCE_KIND = eINSTANCE.getInheritanceKind();

	}

} // EntityPackage
