/**
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.manifest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.manifest.ManifestFactory
 * @model kind="package"
 * @generated
 */
public interface ManifestPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "manifest";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/manifest/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "manifest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ManifestPackage eINSTANCE = org.obeonetwork.dsl.manifest.impl.ManifestPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl <em>MManifest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.manifest.impl.MManifestImpl
	 * @see org.obeonetwork.dsl.manifest.impl.ManifestPackageImpl#getMManifest()
	 * @generated
	 */
	int MMANIFEST = 0;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__PROJECT_ID = 0;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__CREATION_DATE = 1;

	/**
	 * The feature id for the '<em><b>Version Major</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__VERSION_MAJOR = 2;

	/**
	 * The feature id for the '<em><b>Version Minor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__VERSION_MINOR = 3;

	/**
	 * The feature id for the '<em><b>Version Patch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__VERSION_PATCH = 4;

	/**
	 * The feature id for the '<em><b>Version Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__VERSION_QUALIFIER = 5;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__COMMENT = 6;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST__DEPENDENCIES = 7;

	/**
	 * The number of structural features of the '<em>MManifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMANIFEST_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.manifest.impl.MImportExportDataImpl <em>MImport Export Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.manifest.impl.MImportExportDataImpl
	 * @see org.obeonetwork.dsl.manifest.impl.ManifestPackageImpl#getMImportExportData()
	 * @generated
	 */
	int MIMPORT_EXPORT_DATA = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPORT_EXPORT_DATA__DESCRIPTION = ViewpointPackage.DFEATURE_EXTENSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Exported Manifests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS = ViewpointPackage.DFEATURE_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported Manifests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS = ViewpointPackage.DFEATURE_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPORT_EXPORT_DATA__DEPENDENCIES = ViewpointPackage.DFEATURE_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>MImport Export Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPORT_EXPORT_DATA_FEATURE_COUNT = ViewpointPackage.DFEATURE_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '<em>Bad Version String Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.manifest.BadVersionStringException
	 * @see org.obeonetwork.dsl.manifest.impl.ManifestPackageImpl#getBadVersionStringException()
	 * @generated
	 */
	int BAD_VERSION_STRING_EXCEPTION = 2;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.manifest.MManifest <em>MManifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MManifest</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest
	 * @generated
	 */
	EClass getMManifest();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.manifest.MManifest#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Id</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getProjectId()
	 * @see #getMManifest()
	 * @generated
	 */
	EAttribute getMManifest_ProjectId();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.manifest.MManifest#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getCreationDate()
	 * @see #getMManifest()
	 * @generated
	 */
	EAttribute getMManifest_CreationDate();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionMajor <em>Version Major</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Major</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getVersionMajor()
	 * @see #getMManifest()
	 * @generated
	 */
	EAttribute getMManifest_VersionMajor();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionMinor <em>Version Minor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Minor</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getVersionMinor()
	 * @see #getMManifest()
	 * @generated
	 */
	EAttribute getMManifest_VersionMinor();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionPatch <em>Version Patch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Patch</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getVersionPatch()
	 * @see #getMManifest()
	 * @generated
	 */
	EAttribute getMManifest_VersionPatch();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionQualifier <em>Version Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Qualifier</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getVersionQualifier()
	 * @see #getMManifest()
	 * @generated
	 */
	EAttribute getMManifest_VersionQualifier();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.manifest.MManifest#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getComment()
	 * @see #getMManifest()
	 * @generated
	 */
	EAttribute getMManifest_Comment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.manifest.MManifest#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.obeonetwork.dsl.manifest.MManifest#getDependencies()
	 * @see #getMManifest()
	 * @generated
	 */
	EReference getMManifest_Dependencies();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.manifest.MImportExportData <em>MImport Export Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MImport Export Data</em>'.
	 * @see org.obeonetwork.dsl.manifest.MImportExportData
	 * @generated
	 */
	EClass getMImportExportData();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.manifest.MImportExportData#getExportedManifests <em>Exported Manifests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Manifests</em>'.
	 * @see org.obeonetwork.dsl.manifest.MImportExportData#getExportedManifests()
	 * @see #getMImportExportData()
	 * @generated
	 */
	EReference getMImportExportData_ExportedManifests();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.manifest.MImportExportData#getImportedManifests <em>Imported Manifests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imported Manifests</em>'.
	 * @see org.obeonetwork.dsl.manifest.MImportExportData#getImportedManifests()
	 * @see #getMImportExportData()
	 * @generated
	 */
	EReference getMImportExportData_ImportedManifests();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.manifest.MImportExportData#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.obeonetwork.dsl.manifest.MImportExportData#getDependencies()
	 * @see #getMImportExportData()
	 * @generated
	 */
	EReference getMImportExportData_Dependencies();

	/**
	 * Returns the meta object for data type '{@link org.obeonetwork.dsl.manifest.BadVersionStringException <em>Bad Version String Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bad Version String Exception</em>'.
	 * @see org.obeonetwork.dsl.manifest.BadVersionStringException
	 * @model instanceClass="org.obeonetwork.dsl.manifest.BadVersionStringException"
	 * @generated
	 */
	EDataType getBadVersionStringException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ManifestFactory getManifestFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl <em>MManifest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.manifest.impl.MManifestImpl
		 * @see org.obeonetwork.dsl.manifest.impl.ManifestPackageImpl#getMManifest()
		 * @generated
		 */
		EClass MMANIFEST = eINSTANCE.getMManifest();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMANIFEST__PROJECT_ID = eINSTANCE.getMManifest_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMANIFEST__CREATION_DATE = eINSTANCE.getMManifest_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Version Major</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMANIFEST__VERSION_MAJOR = eINSTANCE.getMManifest_VersionMajor();

		/**
		 * The meta object literal for the '<em><b>Version Minor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMANIFEST__VERSION_MINOR = eINSTANCE.getMManifest_VersionMinor();

		/**
		 * The meta object literal for the '<em><b>Version Patch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMANIFEST__VERSION_PATCH = eINSTANCE.getMManifest_VersionPatch();

		/**
		 * The meta object literal for the '<em><b>Version Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMANIFEST__VERSION_QUALIFIER = eINSTANCE.getMManifest_VersionQualifier();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMANIFEST__COMMENT = eINSTANCE.getMManifest_Comment();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MMANIFEST__DEPENDENCIES = eINSTANCE.getMManifest_Dependencies();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.manifest.impl.MImportExportDataImpl <em>MImport Export Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.manifest.impl.MImportExportDataImpl
		 * @see org.obeonetwork.dsl.manifest.impl.ManifestPackageImpl#getMImportExportData()
		 * @generated
		 */
		EClass MIMPORT_EXPORT_DATA = eINSTANCE.getMImportExportData();

		/**
		 * The meta object literal for the '<em><b>Exported Manifests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS = eINSTANCE.getMImportExportData_ExportedManifests();

		/**
		 * The meta object literal for the '<em><b>Imported Manifests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS = eINSTANCE.getMImportExportData_ImportedManifests();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIMPORT_EXPORT_DATA__DEPENDENCIES = eINSTANCE.getMImportExportData_Dependencies();

		/**
		 * The meta object literal for the '<em>Bad Version String Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.manifest.BadVersionStringException
		 * @see org.obeonetwork.dsl.manifest.impl.ManifestPackageImpl#getBadVersionStringException()
		 * @generated
		 */
		EDataType BAD_VERSION_STRING_EXCEPTION = eINSTANCE.getBadVersionStringException();

	}

} //ManifestPackage
