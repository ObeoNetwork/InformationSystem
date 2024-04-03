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
package org.obeonetwork.dsl.entity.extensionUtilities;

import org.eclipse.emf.ecore.EClass;
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
 * @see org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesFactory
 * @model kind="package"
 * @generated
 */
public interface ExtensionUtilitiesPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "extensionUtilities";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/entity/2.0.0/utilities";

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
	ExtensionUtilitiesPackage eINSTANCE = org.obeonetwork.dsl.entity.extensionUtilities.impl.ExtensionUtilitiesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl <em>Entity Filter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.impl.ExtensionUtilitiesPackageImpl#getEntityFilter()
	 * @generated
	 */
	int ENTITY_FILTER = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__TECHNICALID = EnvironmentPackage.FILTER__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__METADATAS = EnvironmentPackage.FILTER__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__DESCRIPTION = EnvironmentPackage.FILTER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__KEYWORDS = EnvironmentPackage.FILTER__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__BEHAVIOURS = EnvironmentPackage.FILTER__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__BINDING_REGISTRIES = EnvironmentPackage.FILTER__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__VERSION = EnvironmentPackage.FILTER__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__CREATED_ON = EnvironmentPackage.FILTER__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__MODIFIED_ON = EnvironmentPackage.FILTER__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__ATTRIBUTE_REFERENCES = EnvironmentPackage.FILTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__REFERENCE_REFERENCES = EnvironmentPackage.FILTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Property References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__OWNED_PROPERTY_REFERENCES = EnvironmentPackage.FILTER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER__ENTITY = EnvironmentPackage.FILTER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Entity Filter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FILTER_FEATURE_COUNT = EnvironmentPackage.FILTER_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter <em>Entity Filter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Filter</em>'.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter
	 * @generated
	 */
	EClass getEntityFilter();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getAttributeReferences <em>Attribute References</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute References</em>'.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getAttributeReferences()
	 * @see #getEntityFilter()
	 * @generated
	 */
	EReference getEntityFilter_AttributeReferences();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getReferenceReferences <em>Reference References</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference References</em>'.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getReferenceReferences()
	 * @see #getEntityFilter()
	 * @generated
	 */
	EReference getEntityFilter_ReferenceReferences();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getOwnedPropertyReferences <em>Owned Property References</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Property References</em>'.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getOwnedPropertyReferences()
	 * @see #getEntityFilter()
	 * @generated
	 */
	EReference getEntityFilter_OwnedPropertyReferences();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter#getEntity()
	 * @see #getEntityFilter()
	 * @generated
	 */
	EReference getEntityFilter_Entity();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtensionUtilitiesFactory getExtensionUtilitiesFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl <em>Entity Filter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl
		 * @see org.obeonetwork.dsl.entity.extensionUtilities.impl.ExtensionUtilitiesPackageImpl#getEntityFilter()
		 * @generated
		 */
		EClass ENTITY_FILTER = eINSTANCE.getEntityFilter();

		/**
		 * The meta object literal for the '<em><b>Attribute References</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_FILTER__ATTRIBUTE_REFERENCES = eINSTANCE.getEntityFilter_AttributeReferences();

		/**
		 * The meta object literal for the '<em><b>Reference References</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_FILTER__REFERENCE_REFERENCES = eINSTANCE.getEntityFilter_ReferenceReferences();

		/**
		 * The meta object literal for the '<em><b>Owned Property References</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_FILTER__OWNED_PROPERTY_REFERENCES = eINSTANCE.getEntityFilter_OwnedPropertyReferences();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_FILTER__ENTITY = eINSTANCE.getEntityFilter_Entity();

	}

} // ExtensionUtilitiesPackage
