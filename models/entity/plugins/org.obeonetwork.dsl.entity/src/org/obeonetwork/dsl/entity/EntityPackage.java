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
	String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	String eNS_URI = "http://www.obeonetwork.org/dsl/entity/3.0.0";

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
	int ROOT__TECHNICALID = EnvironmentPackage.TYPES_DEFINITION__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__METADATAS = EnvironmentPackage.TYPES_DEFINITION__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__DESCRIPTION = EnvironmentPackage.TYPES_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__KEYWORDS = EnvironmentPackage.TYPES_DEFINITION__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BEHAVIOURS = EnvironmentPackage.TYPES_DEFINITION__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BINDING_REGISTRIES = EnvironmentPackage.TYPES_DEFINITION__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__VERSION = EnvironmentPackage.TYPES_DEFINITION__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CREATED_ON = EnvironmentPackage.TYPES_DEFINITION__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__MODIFIED_ON = EnvironmentPackage.TYPES_DEFINITION__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__TYPES = EnvironmentPackage.TYPES_DEFINITION__TYPES;

	/**
	 * The feature id for the '<em><b>Owned Namespaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWNED_NAMESPACES = EnvironmentPackage.TYPES_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NAME = EnvironmentPackage.TYPES_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = EnvironmentPackage.TYPES_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.EntityImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 1;

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
	 * The feature id for the '<em><b>Supertype</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY__SUPERTYPE = EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Associated Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ASSOCIATED_TYPES = EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_ATTRIBUTES = EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ATTRIBUTES = EnvironmentPackage.STRUCTURED_TYPE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Owned References</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_REFERENCES = EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__REFERENCES = EnvironmentPackage.STRUCTURED_TYPE__REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__PROPERTIES = EnvironmentPackage.STRUCTURED_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Estimated Volumetry</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ESTIMATED_VOLUMETRY = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Estimated Access</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ESTIMATED_ACCESS = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Historized</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY__HISTORIZED = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Finders</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_FINDERS = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inheritance Kind</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__INHERITANCE_KIND = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = EnvironmentPackage.STRUCTURED_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.impl.FinderImpl <em>Finder</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.impl.FinderImpl
	 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getFinder()
	 * @generated
	 */
	int FINDER = 2;

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
	int CRITERION = 4;

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
	int INTERNAL_CRITERION = 3;

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
	int EXTERNAL_CRITERION = 5;

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
	int INHERITANCE_KIND = 6;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Root <em>Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.obeonetwork.dsl.entity.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Root#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.entity.Root#getName()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity
	 * @generated
	 */
	EClass getEntity();

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
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entity.Entity#getInheritanceKind <em>Inheritance Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inheritance Kind</em>'.
	 * @see org.obeonetwork.dsl.entity.Entity#getInheritanceKind()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_InheritanceKind();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__NAME = eINSTANCE.getRoot_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.impl.EntityImpl
		 * @see org.obeonetwork.dsl.entity.impl.EntityPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

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
		 * The meta object literal for the '<em><b>Inheritance Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__INHERITANCE_KIND = eINSTANCE.getEntity_InheritanceKind();

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
