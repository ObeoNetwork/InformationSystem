/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.graal.DomainModelRegistry;
import org.obeonetwork.graal.GraalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Model Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.DomainModelRegistryImpl#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.DomainModelRegistryImpl#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DomainModelRegistryImpl extends CDOObjectImpl implements DomainModelRegistry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainModelRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.DOMAIN_MODEL_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Namespace> getNamespaces() {
		return (EList<Namespace>)eDynamicGet(GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__NAMESPACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StructuredType> getTypes() {
		return (EList<StructuredType>)eDynamicGet(GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES:
				return getNamespaces();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES:
				return getTypes();
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
			case GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES:
				getNamespaces().clear();
				getNamespaces().addAll((Collection<? extends Namespace>)newValue);
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends StructuredType>)newValue);
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
			case GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES:
				getNamespaces().clear();
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES:
				getTypes().clear();
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
			case GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES:
				return !getNamespaces().isEmpty();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES:
				return !getTypes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DomainModelRegistryImpl
