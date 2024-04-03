/**
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.manifest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.sirius.viewpoint.DFeatureExtension;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MImport Export Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.manifest.MImportExportData#getExportedManifests <em>Exported Manifests</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MImportExportData#getImportedManifests <em>Imported Manifests</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MImportExportData#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMImportExportData()
 * @model
 * @generated
 */
public interface MImportExportData extends DFeatureExtension {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2024 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Exported Manifests</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.manifest.MManifest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported Manifests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exported Manifests</em>' containment reference list.
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMImportExportData_ExportedManifests()
	 * @model containment="true"
	 * @generated
	 */
	EList<MManifest> getExportedManifests();

	/**
	 * Returns the value of the '<em><b>Imported Manifests</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.manifest.MManifest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Manifests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Manifests</em>' containment reference list.
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMImportExportData_ImportedManifests()
	 * @model containment="true"
	 * @generated
	 */
	EList<MManifest> getImportedManifests();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.manifest.MManifest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMImportExportData_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<MManifest> getDependencies();

} // MImportExportData
