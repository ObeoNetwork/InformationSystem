/**
 * Copyright (c) 2010-2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graal.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.ServiceDTO;
import org.obeonetwork.graal.DomainModelRegistry;
import org.obeonetwork.graal.GraalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Model Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.DomainModelRegistryImpl#getDtoCategories <em>Dto Categories</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.DomainModelRegistryImpl#getDtos <em>Dtos</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.DomainModelRegistryImpl#getEntityBlocks <em>Entity Blocks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.DomainModelRegistryImpl#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
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
	public EList<Category> getDtoCategories() {
		return (EList<Category>)eDynamicGet(GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceDTO> getDtos() {
		return (EList<ServiceDTO>)eDynamicGet(GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__DTOS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Block> getEntityBlocks() {
		return (EList<Block>)eDynamicGet(GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Entity> getEntities() {
		return (EList<Entity>)eDynamicGet(GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__ENTITIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES:
				return getDtoCategories();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS:
				return getDtos();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS:
				return getEntityBlocks();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES:
				return getEntities();
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
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES:
				getDtoCategories().clear();
				getDtoCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS:
				getDtos().clear();
				getDtos().addAll((Collection<? extends ServiceDTO>)newValue);
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS:
				getEntityBlocks().clear();
				getEntityBlocks().addAll((Collection<? extends Block>)newValue);
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends Entity>)newValue);
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
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES:
				getDtoCategories().clear();
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS:
				getDtos().clear();
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS:
				getEntityBlocks().clear();
				return;
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES:
				getEntities().clear();
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
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES:
				return !getDtoCategories().isEmpty();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS:
				return !getDtos().isEmpty();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS:
				return !getEntityBlocks().isEmpty();
			case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES:
				return !getEntities().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DomainModelRegistryImpl
