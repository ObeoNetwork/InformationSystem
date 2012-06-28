/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package statemachine.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

import statemachine.AbstractState;
import statemachine.StatemachinePackage;
import statemachine.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link statemachine.impl.AbstractStateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link statemachine.impl.AbstractStateImpl#getOutcomingTransitions <em>Outcoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractStateImpl extends ObeoDSMObjectImpl implements AbstractState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinePackage.Literals.ABSTRACT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getIncomingTransitions() {
		return (EList<Transition>)eDynamicGet(StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS, StatemachinePackage.Literals.ABSTRACT_STATE__INCOMING_TRANSITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getOutcomingTransitions() {
		return (EList<Transition>)eDynamicGet(StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS, StatemachinePackage.Literals.ABSTRACT_STATE__OUTCOMING_TRANSITIONS, true, true);
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
			case StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransitions()).basicAdd(otherEnd, msgs);
			case StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutcomingTransitions()).basicAdd(otherEnd, msgs);
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
			case StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<?>)getIncomingTransitions()).basicRemove(otherEnd, msgs);
			case StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return ((InternalEList<?>)getOutcomingTransitions()).basicRemove(otherEnd, msgs);
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
			case StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return getIncomingTransitions();
			case StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return getOutcomingTransitions();
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
			case StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				getIncomingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				getOutcomingTransitions().clear();
				getOutcomingTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				return;
			case StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				getOutcomingTransitions().clear();
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
			case StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return !getIncomingTransitions().isEmpty();
			case StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return !getOutcomingTransitions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractStateImpl
