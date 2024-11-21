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
package org.obeonetwork.dsl.environment.metadatadef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition;
import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions;
import org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage;

import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Data Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionsImpl#getMetaDataDefinitions <em>Meta Data Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaDataDefinitionsImpl extends IdentifiableImpl implements MetaDataDefinitions {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaDataDefinitionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetadatadefPackage.Literals.META_DATA_DEFINITIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<MetaDataDefinition> getMetaDataDefinitions() {
		return (EList<MetaDataDefinition>) eDynamicGet(MetadatadefPackage.META_DATA_DEFINITIONS__META_DATA_DEFINITIONS,
				MetadatadefPackage.Literals.META_DATA_DEFINITIONS__META_DATA_DEFINITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MetadatadefPackage.META_DATA_DEFINITIONS__META_DATA_DEFINITIONS:
			return ((InternalEList<?>) getMetaDataDefinitions()).basicRemove(otherEnd, msgs);
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
		case MetadatadefPackage.META_DATA_DEFINITIONS__META_DATA_DEFINITIONS:
			return getMetaDataDefinitions();
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
		case MetadatadefPackage.META_DATA_DEFINITIONS__META_DATA_DEFINITIONS:
			getMetaDataDefinitions().clear();
			getMetaDataDefinitions().addAll((Collection<? extends MetaDataDefinition>) newValue);
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
		case MetadatadefPackage.META_DATA_DEFINITIONS__META_DATA_DEFINITIONS:
			getMetaDataDefinitions().clear();
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
		case MetadatadefPackage.META_DATA_DEFINITIONS__META_DATA_DEFINITIONS:
			return !getMetaDataDefinitions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MetaDataDefinitionsImpl
