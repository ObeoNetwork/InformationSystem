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
package org.obeonetwork.dsl.manifest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sirius.viewpoint.impl.DFeatureExtensionImpl;

import org.obeonetwork.dsl.manifest.MImportExportData;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.dsl.manifest.ManifestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MImport Export Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MImportExportDataImpl#getExportedManifests <em>Exported Manifests</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MImportExportDataImpl#getImportedManifests <em>Imported Manifests</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MImportExportDataImpl#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MImportExportDataImpl extends DFeatureExtensionImpl implements MImportExportData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getExportedManifests() <em>Exported Manifests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportedManifests()
	 * @generated
	 * @ordered
	 */
	protected EList<MManifest> exportedManifests;

	/**
	 * The cached value of the '{@link #getImportedManifests() <em>Imported Manifests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedManifests()
	 * @generated
	 * @ordered
	 */
	protected EList<MManifest> importedManifests;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<MManifest> dependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MImportExportDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ManifestPackage.Literals.MIMPORT_EXPORT_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MManifest> getExportedManifests() {
		if (exportedManifests == null) {
			exportedManifests = new EObjectContainmentEList<MManifest>(MManifest.class, this, ManifestPackage.MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS);
		}
		return exportedManifests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MManifest> getImportedManifests() {
		if (importedManifests == null) {
			importedManifests = new EObjectContainmentEList<MManifest>(MManifest.class, this, ManifestPackage.MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS);
		}
		return importedManifests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MManifest> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<MManifest>(MManifest.class, this, ManifestPackage.MIMPORT_EXPORT_DATA__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ManifestPackage.MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS:
				return ((InternalEList<?>)getExportedManifests()).basicRemove(otherEnd, msgs);
			case ManifestPackage.MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS:
				return ((InternalEList<?>)getImportedManifests()).basicRemove(otherEnd, msgs);
			case ManifestPackage.MIMPORT_EXPORT_DATA__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ManifestPackage.MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS:
				return getExportedManifests();
			case ManifestPackage.MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS:
				return getImportedManifests();
			case ManifestPackage.MIMPORT_EXPORT_DATA__DEPENDENCIES:
				return getDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ManifestPackage.MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS:
				getExportedManifests().clear();
				getExportedManifests().addAll((Collection<? extends MManifest>)newValue);
				return;
			case ManifestPackage.MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS:
				getImportedManifests().clear();
				getImportedManifests().addAll((Collection<? extends MManifest>)newValue);
				return;
			case ManifestPackage.MIMPORT_EXPORT_DATA__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends MManifest>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ManifestPackage.MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS:
				getExportedManifests().clear();
				return;
			case ManifestPackage.MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS:
				getImportedManifests().clear();
				return;
			case ManifestPackage.MIMPORT_EXPORT_DATA__DEPENDENCIES:
				getDependencies().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ManifestPackage.MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS:
				return exportedManifests != null && !exportedManifests.isEmpty();
			case ManifestPackage.MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS:
				return importedManifests != null && !importedManifests.isEmpty();
			case ManifestPackage.MIMPORT_EXPORT_DATA__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MImportExportDataImpl
