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
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.StructuredType;
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
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.UseCaseImpl#getExtends <em>Extends</em>}</li>
 * </ul>
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
	public EList<Namespace> getNamespaces() {
		return (EList<Namespace>)eDynamicGet(GraalPackage.USE_CASE__NAMESPACES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__NAMESPACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StructuredType> getTypes() {
		return (EList<StructuredType>)eDynamicGet(GraalPackage.USE_CASE__TYPES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__TYPES, true, true);
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
			case GraalPackage.USE_CASE__NAMESPACES:
				return getNamespaces();
			case GraalPackage.USE_CASE__TYPES:
				return getTypes();
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
			case GraalPackage.USE_CASE__NAMESPACES:
				getNamespaces().clear();
				getNamespaces().addAll((Collection<? extends Namespace>)newValue);
				return;
			case GraalPackage.USE_CASE__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends StructuredType>)newValue);
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
			case GraalPackage.USE_CASE__NAMESPACES:
				getNamespaces().clear();
				return;
			case GraalPackage.USE_CASE__TYPES:
				getTypes().clear();
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
			case GraalPackage.USE_CASE__NAMESPACES:
				return !getNamespaces().isEmpty();
			case GraalPackage.USE_CASE__TYPES:
				return !getTypes().isEmpty();
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
				case GraalPackage.USE_CASE__NAMESPACES: return GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES;
				case GraalPackage.USE_CASE__TYPES: return GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES;
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
				case GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES: return GraalPackage.USE_CASE__NAMESPACES;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES: return GraalPackage.USE_CASE__TYPES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //UseCaseImpl
