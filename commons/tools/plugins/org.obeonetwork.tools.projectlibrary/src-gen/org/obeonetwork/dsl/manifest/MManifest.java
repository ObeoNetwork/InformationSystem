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

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MManifest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getExportDate <em>Export Date</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getImportDate <em>Import Date</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getVersionMajor <em>Version Major</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getVersionMinor <em>Version Minor</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getVersionPatch <em>Version Patch</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getVersionQualifier <em>Version Qualifier</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getComment <em>Comment</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.MManifest#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest()
 * @model
 * @generated
 */
public interface MManifest extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' attribute.
	 * @see #setProjectId(String)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_ProjectId()
	 * @model
	 * @generated
	 */
	String getProjectId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getProjectId <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' attribute.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(String value);

	/**
	 * Returns the value of the '<em><b>Export Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Date</em>' attribute.
	 * @see #setExportDate(Date)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_ExportDate()
	 * @model
	 * @generated
	 */
	Date getExportDate();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getExportDate <em>Export Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Date</em>' attribute.
	 * @see #getExportDate()
	 * @generated
	 */
	void setExportDate(Date value);

	/**
	 * Returns the value of the '<em><b>Import Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Date</em>' attribute.
	 * @see #setImportDate(Date)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_ImportDate()
	 * @model
	 * @generated
	 */
	Date getImportDate();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getImportDate <em>Import Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Date</em>' attribute.
	 * @see #getImportDate()
	 * @generated
	 */
	void setImportDate(Date value);

	/**
	 * Returns the value of the '<em><b>Version Major</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Major</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Major</em>' attribute.
	 * @see #setVersionMajor(int)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_VersionMajor()
	 * @model
	 * @generated
	 */
	int getVersionMajor();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionMajor <em>Version Major</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Major</em>' attribute.
	 * @see #getVersionMajor()
	 * @generated
	 */
	void setVersionMajor(int value);

	/**
	 * Returns the value of the '<em><b>Version Minor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Minor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Minor</em>' attribute.
	 * @see #setVersionMinor(int)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_VersionMinor()
	 * @model
	 * @generated
	 */
	int getVersionMinor();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionMinor <em>Version Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Minor</em>' attribute.
	 * @see #getVersionMinor()
	 * @generated
	 */
	void setVersionMinor(int value);

	/**
	 * Returns the value of the '<em><b>Version Patch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Patch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Patch</em>' attribute.
	 * @see #setVersionPatch(int)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_VersionPatch()
	 * @model
	 * @generated
	 */
	int getVersionPatch();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionPatch <em>Version Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Patch</em>' attribute.
	 * @see #getVersionPatch()
	 * @generated
	 */
	void setVersionPatch(int value);

	/**
	 * Returns the value of the '<em><b>Version Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Qualifier</em>' attribute.
	 * @see #setVersionQualifier(String)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_VersionQualifier()
	 * @model
	 * @generated
	 */
	String getVersionQualifier();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getVersionQualifier <em>Version Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Qualifier</em>' attribute.
	 * @see #getVersionQualifier()
	 * @generated
	 */
	void setVersionQualifier(String value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.manifest.MManifest#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

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
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#getMManifest_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<MManifest> getDependencies();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.obeonetwork.dsl.manifest.BadVersionStringException" versionAsStringRequired="true"
	 * @generated
	 */
	void setVersion(String versionAsString) throws BadVersionStringException;

} // MManifest
