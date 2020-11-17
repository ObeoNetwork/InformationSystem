/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.TransitionKind;
import org.obeonetwork.graal.UserStory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TransitionImpl#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends GraalObjectImpl implements Transition {
	/**
	 * The default value of the '{@link #getGuard() <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected static final String GUARD_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final TransitionKind KIND_EDEFAULT = TransitionKind.NORMAL;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuard() {
		return (String)eDynamicGet(GraalPackage.TRANSITION__GUARD, GraalPackage.Literals.TRANSITION__GUARD, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(String newGuard) {
		eDynamicSet(GraalPackage.TRANSITION__GUARD, GraalPackage.Literals.TRANSITION__GUARD, newGuard);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		return (Node)eDynamicGet(GraalPackage.TRANSITION__SOURCE, GraalPackage.Literals.TRANSITION__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return (Node)eDynamicGet(GraalPackage.TRANSITION__SOURCE, GraalPackage.Literals.TRANSITION__SOURCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Node newSource, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newSource, GraalPackage.TRANSITION__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		eDynamicSet(GraalPackage.TRANSITION__SOURCE, GraalPackage.Literals.TRANSITION__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		return (Node)eDynamicGet(GraalPackage.TRANSITION__TARGET, GraalPackage.Literals.TRANSITION__TARGET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return (Node)eDynamicGet(GraalPackage.TRANSITION__TARGET, GraalPackage.Literals.TRANSITION__TARGET, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Node newTarget, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newTarget, GraalPackage.TRANSITION__TARGET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		eDynamicSet(GraalPackage.TRANSITION__TARGET, GraalPackage.Literals.TRANSITION__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionKind getKind() {
		return (TransitionKind)eDynamicGet(GraalPackage.TRANSITION__KIND, GraalPackage.Literals.TRANSITION__KIND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(TransitionKind newKind) {
		eDynamicSet(GraalPackage.TRANSITION__KIND, GraalPackage.Literals.TRANSITION__KIND, newKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Task getContainingTask() {
		EObject container = eContainer();
		while (container != null) {
			if (container instanceof Task) {
				return (Task)container;
			}
			container = container.eContainer();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.TRANSITION__SOURCE:
				Node source = basicGetSource();
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, GraalPackage.NODE__OUTGOING_TRANSITIONS, Node.class, msgs);
				return basicSetSource((Node)otherEnd, msgs);
			case GraalPackage.TRANSITION__TARGET:
				Node target = basicGetTarget();
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, GraalPackage.NODE__INCOMING_TRANSITIONS, Node.class, msgs);
				return basicSetTarget((Node)otherEnd, msgs);
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
			case GraalPackage.TRANSITION__SOURCE:
				return basicSetSource(null, msgs);
			case GraalPackage.TRANSITION__TARGET:
				return basicSetTarget(null, msgs);
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
			case GraalPackage.TRANSITION__GUARD:
				return getGuard();
			case GraalPackage.TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case GraalPackage.TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case GraalPackage.TRANSITION__KIND:
				return getKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraalPackage.TRANSITION__GUARD:
				setGuard((String)newValue);
				return;
			case GraalPackage.TRANSITION__SOURCE:
				setSource((Node)newValue);
				return;
			case GraalPackage.TRANSITION__TARGET:
				setTarget((Node)newValue);
				return;
			case GraalPackage.TRANSITION__KIND:
				setKind((TransitionKind)newValue);
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
			case GraalPackage.TRANSITION__GUARD:
				setGuard(GUARD_EDEFAULT);
				return;
			case GraalPackage.TRANSITION__SOURCE:
				setSource((Node)null);
				return;
			case GraalPackage.TRANSITION__TARGET:
				setTarget((Node)null);
				return;
			case GraalPackage.TRANSITION__KIND:
				setKind(KIND_EDEFAULT);
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
			case GraalPackage.TRANSITION__GUARD:
				return GUARD_EDEFAULT == null ? getGuard() != null : !GUARD_EDEFAULT.equals(getGuard());
			case GraalPackage.TRANSITION__SOURCE:
				return basicGetSource() != null;
			case GraalPackage.TRANSITION__TARGET:
				return basicGetTarget() != null;
			case GraalPackage.TRANSITION__KIND:
				return getKind() != KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean canBeAttachedToUserStory(UserStory userStory) {
		return true;
	}

	@Override
	public boolean isConcernedByUserStory(UserStory userStory) {
		return userStory.getElements().contains(this);
	}
	
	@Override
	public void attachToUserStory(UserStory userStory) {
		userStory.getElements().add(this);
	}

	@Override
	public void detachFromUserStory(UserStory userStory) {
		userStory.getElements().remove(this);
	}

} //TransitionImpl
