/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.GraalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.ActorImpl#getSubActors <em>Sub Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.ActorImpl#getSuperActor <em>Super Actor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorImpl extends NamedElementImpl implements Actor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Actor> getSubActors() {
		return (EList<Actor>)eDynamicGet(GraalPackage.ACTOR__SUB_ACTORS, GraalPackage.Literals.ACTOR__SUB_ACTORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getSuperActor() {
		return (Actor)eDynamicGet(GraalPackage.ACTOR__SUPER_ACTOR, GraalPackage.Literals.ACTOR__SUPER_ACTOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetSuperActor() {
		return (Actor)eDynamicGet(GraalPackage.ACTOR__SUPER_ACTOR, GraalPackage.Literals.ACTOR__SUPER_ACTOR, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperActor(Actor newSuperActor, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newSuperActor, GraalPackage.ACTOR__SUPER_ACTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperActor(Actor newSuperActor) {
		eDynamicSet(GraalPackage.ACTOR__SUPER_ACTOR, GraalPackage.Literals.ACTOR__SUPER_ACTOR, newSuperActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.ACTOR__SUB_ACTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubActors()).basicAdd(otherEnd, msgs);
			case GraalPackage.ACTOR__SUPER_ACTOR:
				Actor superActor = basicGetSuperActor();
				if (superActor != null)
					msgs = ((InternalEObject)superActor).eInverseRemove(this, GraalPackage.ACTOR__SUB_ACTORS, Actor.class, msgs);
				return basicSetSuperActor((Actor)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.ACTOR__SUB_ACTORS:
				return ((InternalEList<?>)getSubActors()).basicRemove(otherEnd, msgs);
			case GraalPackage.ACTOR__SUPER_ACTOR:
				return basicSetSuperActor(null, msgs);
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
			case GraalPackage.ACTOR__SUB_ACTORS:
				return getSubActors();
			case GraalPackage.ACTOR__SUPER_ACTOR:
				if (resolve) return getSuperActor();
				return basicGetSuperActor();
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
			case GraalPackage.ACTOR__SUB_ACTORS:
				getSubActors().clear();
				getSubActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case GraalPackage.ACTOR__SUPER_ACTOR:
				setSuperActor((Actor)newValue);
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
			case GraalPackage.ACTOR__SUB_ACTORS:
				getSubActors().clear();
				return;
			case GraalPackage.ACTOR__SUPER_ACTOR:
				setSuperActor((Actor)null);
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
			case GraalPackage.ACTOR__SUB_ACTORS:
				return !getSubActors().isEmpty();
			case GraalPackage.ACTOR__SUPER_ACTOR:
				return basicGetSuperActor() != null;
		}
		return super.eIsSet(featureID);
	}

} //ActorImpl
