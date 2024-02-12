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
package org.obeonetwork.dsl.environment.metadatadef;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefFactory
 * @model kind="package"
 * @generated
 */
public interface MetadatadefPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metadatadef";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/environment/metadatadef/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metadatadef";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetadatadefPackage eINSTANCE = org.obeonetwork.dsl.environment.metadatadef.impl.MetadatadefPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionsImpl <em>Meta Data Definitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionsImpl
	 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetadatadefPackageImpl#getMetaDataDefinitions()
	 * @generated
	 */
	int META_DATA_DEFINITIONS = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITIONS__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Meta Data Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITIONS__META_DATA_DEFINITIONS = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Meta Data Definitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITIONS_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionImpl <em>Meta Data Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionImpl
	 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetadatadefPackageImpl#getMetaDataDefinition()
	 * @generated
	 */
	int META_DATA_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITION__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITION__TITLE = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITION__BODY = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITION__CONDITION = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Meta Data Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_DEFINITION_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions <em>Meta Data Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data Definitions</em>'.
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions
	 * @generated
	 */
	EClass getMetaDataDefinitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions#getMetaDataDefinitions <em>Meta Data Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meta Data Definitions</em>'.
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions#getMetaDataDefinitions()
	 * @see #getMetaDataDefinitions()
	 * @generated
	 */
	EReference getMetaDataDefinitions_MetaDataDefinitions();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition <em>Meta Data Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data Definition</em>'.
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition
	 * @generated
	 */
	EClass getMetaDataDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getTitle()
	 * @see #getMetaDataDefinition()
	 * @generated
	 */
	EAttribute getMetaDataDefinition_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getBody()
	 * @see #getMetaDataDefinition()
	 * @generated
	 */
	EAttribute getMetaDataDefinition_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition#getCondition()
	 * @see #getMetaDataDefinition()
	 * @generated
	 */
	EAttribute getMetaDataDefinition_Condition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetadatadefFactory getMetadatadefFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionsImpl <em>Meta Data Definitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionsImpl
		 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetadatadefPackageImpl#getMetaDataDefinitions()
		 * @generated
		 */
		EClass META_DATA_DEFINITIONS = eINSTANCE.getMetaDataDefinitions();

		/**
		 * The meta object literal for the '<em><b>Meta Data Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_DATA_DEFINITIONS__META_DATA_DEFINITIONS = eINSTANCE
				.getMetaDataDefinitions_MetaDataDefinitions();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionImpl <em>Meta Data Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionImpl
		 * @see org.obeonetwork.dsl.environment.metadatadef.impl.MetadatadefPackageImpl#getMetaDataDefinition()
		 * @generated
		 */
		EClass META_DATA_DEFINITION = eINSTANCE.getMetaDataDefinition();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA_DEFINITION__TITLE = eINSTANCE.getMetaDataDefinition_Title();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA_DEFINITION__BODY = eINSTANCE.getMetaDataDefinition_Body();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA_DEFINITION__CONDITION = eINSTANCE.getMetaDataDefinition_Condition();

	}

} //MetadatadefPackage
