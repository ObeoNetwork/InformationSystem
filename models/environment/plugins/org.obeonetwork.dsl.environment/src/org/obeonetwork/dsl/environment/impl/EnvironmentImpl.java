/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.dsl.environment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.environment.Behaviour;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.InterDSMLink;
import org.obeonetwork.dsl.environment.PriorityDefinition;
import org.obeonetwork.dsl.environment.TypesDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.EnvironmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.EnvironmentImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.EnvironmentImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.EnvironmentImpl#getPriorityDefinitions <em>Priority Definitions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.EnvironmentImpl#getTypesDefinition <em>Types Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentImpl extends ObeoDSMObjectImpl implements Environment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eDynamicGet(EnvironmentPackage.ENVIRONMENT__NAME,
				EnvironmentPackage.Literals.ENVIRONMENT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(EnvironmentPackage.ENVIRONMENT__NAME,
				EnvironmentPackage.Literals.ENVIRONMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Action> getActions() {
		return (EList<Action>) eDynamicGet(
				EnvironmentPackage.ENVIRONMENT__ACTIONS,
				EnvironmentPackage.Literals.ENVIRONMENT__ACTIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<InterDSMLink> getLinks() {
		return (EList<InterDSMLink>) eDynamicGet(
				EnvironmentPackage.ENVIRONMENT__LINKS,
				EnvironmentPackage.Literals.ENVIRONMENT__LINKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityDefinition getPriorityDefinitions() {
		return (PriorityDefinition) eDynamicGet(
				EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS,
				EnvironmentPackage.Literals.ENVIRONMENT__PRIORITY_DEFINITIONS,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityDefinition basicGetPriorityDefinitions() {
		return (PriorityDefinition) eDynamicGet(
				EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS,
				EnvironmentPackage.Literals.ENVIRONMENT__PRIORITY_DEFINITIONS,
				false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPriorityDefinitions(
			PriorityDefinition newPriorityDefinitions, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newPriorityDefinitions,
				EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriorityDefinitions(PriorityDefinition newPriorityDefinitions) {
		eDynamicSet(EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS,
				EnvironmentPackage.Literals.ENVIRONMENT__PRIORITY_DEFINITIONS,
				newPriorityDefinitions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesDefinition getTypesDefinition() {
		return (TypesDefinition) eDynamicGet(
				EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION,
				EnvironmentPackage.Literals.ENVIRONMENT__TYPES_DEFINITION,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesDefinition basicGetTypesDefinition() {
		return (TypesDefinition) eDynamicGet(
				EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION,
				EnvironmentPackage.Literals.ENVIRONMENT__TYPES_DEFINITION,
				false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypesDefinition(
			TypesDefinition newTypesDefinition, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newTypesDefinition,
				EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypesDefinition(TypesDefinition newTypesDefinition) {
		eDynamicSet(EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION,
				EnvironmentPackage.Literals.ENVIRONMENT__TYPES_DEFINITION,
				newTypesDefinition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.ENVIRONMENT__ACTIONS:
			return ((InternalEList<?>) getActions())
					.basicRemove(otherEnd, msgs);
		case EnvironmentPackage.ENVIRONMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS:
			return basicSetPriorityDefinitions(null, msgs);
		case EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION:
			return basicSetTypesDefinition(null, msgs);
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
		case EnvironmentPackage.ENVIRONMENT__NAME:
			return getName();
		case EnvironmentPackage.ENVIRONMENT__ACTIONS:
			return getActions();
		case EnvironmentPackage.ENVIRONMENT__LINKS:
			return getLinks();
		case EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS:
			if (resolve)
				return getPriorityDefinitions();
			return basicGetPriorityDefinitions();
		case EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION:
			if (resolve)
				return getTypesDefinition();
			return basicGetTypesDefinition();
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
		case EnvironmentPackage.ENVIRONMENT__NAME:
			setName((String) newValue);
			return;
		case EnvironmentPackage.ENVIRONMENT__ACTIONS:
			getActions().clear();
			getActions().addAll((Collection<? extends Action>) newValue);
			return;
		case EnvironmentPackage.ENVIRONMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends InterDSMLink>) newValue);
			return;
		case EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS:
			setPriorityDefinitions((PriorityDefinition) newValue);
			return;
		case EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION:
			setTypesDefinition((TypesDefinition) newValue);
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
		case EnvironmentPackage.ENVIRONMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case EnvironmentPackage.ENVIRONMENT__ACTIONS:
			getActions().clear();
			return;
		case EnvironmentPackage.ENVIRONMENT__LINKS:
			getLinks().clear();
			return;
		case EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS:
			setPriorityDefinitions((PriorityDefinition) null);
			return;
		case EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION:
			setTypesDefinition((TypesDefinition) null);
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
		case EnvironmentPackage.ENVIRONMENT__NAME:
			return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT
					.equals(getName());
		case EnvironmentPackage.ENVIRONMENT__ACTIONS:
			return !getActions().isEmpty();
		case EnvironmentPackage.ENVIRONMENT__LINKS:
			return !getLinks().isEmpty();
		case EnvironmentPackage.ENVIRONMENT__PRIORITY_DEFINITIONS:
			return basicGetPriorityDefinitions() != null;
		case EnvironmentPackage.ENVIRONMENT__TYPES_DEFINITION:
			return basicGetTypesDefinition() != null;
		}
		return super.eIsSet(featureID);
	}

} //EnvironmentImpl