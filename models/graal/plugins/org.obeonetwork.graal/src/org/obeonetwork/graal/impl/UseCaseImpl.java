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
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.ServiceDTO;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.DomainModelRegistry;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getDtoCategories <em>Dto Categories</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getDtos <em>Dtos</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getEntityBlocks <em>Entity Blocks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getEntities <em>Entities</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends NamedElementImpl implements UseCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Category> getDtoCategories() {
		return (EList<Category>)eDynamicGet(GraalPackage.USE_CASE__DTO_CATEGORIES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceDTO> getDtos() {
		return (EList<ServiceDTO>)eDynamicGet(GraalPackage.USE_CASE__DTOS, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__DTOS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Block> getEntityBlocks() {
		return (EList<Block>)eDynamicGet(GraalPackage.USE_CASE__ENTITY_BLOCKS, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Entity> getEntities() {
		return (EList<Entity>)eDynamicGet(GraalPackage.USE_CASE__ENTITIES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__ENTITIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Actor> getActors() {
		return (EList<Actor>)eDynamicGet(GraalPackage.USE_CASE__ACTORS, GraalPackage.Literals.USE_CASE__ACTORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractTask> getTasks() {
		return (EList<AbstractTask>)eDynamicGet(GraalPackage.USE_CASE__TASKS, GraalPackage.Literals.USE_CASE__TASKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<UseCase> getIncludes() {
		return (EList<UseCase>)eDynamicGet(GraalPackage.USE_CASE__INCLUDES, GraalPackage.Literals.USE_CASE__INCLUDES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<UseCase> getExtends() {
		return (EList<UseCase>)eDynamicGet(GraalPackage.USE_CASE__EXTENDS, GraalPackage.Literals.USE_CASE__EXTENDS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.USE_CASE__DTO_CATEGORIES:
				return getDtoCategories();
			case GraalPackage.USE_CASE__DTOS:
				return getDtos();
			case GraalPackage.USE_CASE__ENTITY_BLOCKS:
				return getEntityBlocks();
			case GraalPackage.USE_CASE__ENTITIES:
				return getEntities();
			case GraalPackage.USE_CASE__ACTORS:
				return getActors();
			case GraalPackage.USE_CASE__TASKS:
				return getTasks();
			case GraalPackage.USE_CASE__INCLUDES:
				return getIncludes();
			case GraalPackage.USE_CASE__EXTENDS:
				return getExtends();
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
			case GraalPackage.USE_CASE__DTO_CATEGORIES:
				getDtoCategories().clear();
				getDtoCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case GraalPackage.USE_CASE__DTOS:
				getDtos().clear();
				getDtos().addAll((Collection<? extends ServiceDTO>)newValue);
				return;
			case GraalPackage.USE_CASE__ENTITY_BLOCKS:
				getEntityBlocks().clear();
				getEntityBlocks().addAll((Collection<? extends Block>)newValue);
				return;
			case GraalPackage.USE_CASE__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends Entity>)newValue);
				return;
			case GraalPackage.USE_CASE__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case GraalPackage.USE_CASE__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends AbstractTask>)newValue);
				return;
			case GraalPackage.USE_CASE__INCLUDES:
				getIncludes().clear();
				getIncludes().addAll((Collection<? extends UseCase>)newValue);
				return;
			case GraalPackage.USE_CASE__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends UseCase>)newValue);
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
			case GraalPackage.USE_CASE__DTO_CATEGORIES:
				getDtoCategories().clear();
				return;
			case GraalPackage.USE_CASE__DTOS:
				getDtos().clear();
				return;
			case GraalPackage.USE_CASE__ENTITY_BLOCKS:
				getEntityBlocks().clear();
				return;
			case GraalPackage.USE_CASE__ENTITIES:
				getEntities().clear();
				return;
			case GraalPackage.USE_CASE__ACTORS:
				getActors().clear();
				return;
			case GraalPackage.USE_CASE__TASKS:
				getTasks().clear();
				return;
			case GraalPackage.USE_CASE__INCLUDES:
				getIncludes().clear();
				return;
			case GraalPackage.USE_CASE__EXTENDS:
				getExtends().clear();
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
			case GraalPackage.USE_CASE__DTO_CATEGORIES:
				return !getDtoCategories().isEmpty();
			case GraalPackage.USE_CASE__DTOS:
				return !getDtos().isEmpty();
			case GraalPackage.USE_CASE__ENTITY_BLOCKS:
				return !getEntityBlocks().isEmpty();
			case GraalPackage.USE_CASE__ENTITIES:
				return !getEntities().isEmpty();
			case GraalPackage.USE_CASE__ACTORS:
				return !getActors().isEmpty();
			case GraalPackage.USE_CASE__TASKS:
				return !getTasks().isEmpty();
			case GraalPackage.USE_CASE__INCLUDES:
				return !getIncludes().isEmpty();
			case GraalPackage.USE_CASE__EXTENDS:
				return !getExtends().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DomainModelRegistry.class) {
			switch (derivedFeatureID) {
				case GraalPackage.USE_CASE__DTO_CATEGORIES: return GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES;
				case GraalPackage.USE_CASE__DTOS: return GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS;
				case GraalPackage.USE_CASE__ENTITY_BLOCKS: return GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS;
				case GraalPackage.USE_CASE__ENTITIES: return GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DomainModelRegistry.class) {
			switch (baseFeatureID) {
				case GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES: return GraalPackage.USE_CASE__DTO_CATEGORIES;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS: return GraalPackage.USE_CASE__DTOS;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS: return GraalPackage.USE_CASE__ENTITY_BLOCKS;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES: return GraalPackage.USE_CASE__ENTITIES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //UseCaseImpl
