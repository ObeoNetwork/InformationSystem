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

import statemachine.AbstractState;
import statemachine.StateMachineDescription;
import statemachine.StatemachinePackage;
import statemachine.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link statemachine.impl.StateMachineDescriptionImpl#getStates <em>States</em>}</li>
 *   <li>{@link statemachine.impl.StateMachineDescriptionImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StateMachineDescriptionImpl extends NamedElementImpl implements StateMachineDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinePackage.Literals.STATE_MACHINE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractState> getStates() {
		return (EList<AbstractState>)eDynamicGet(StatemachinePackage.STATE_MACHINE_DESCRIPTION__STATES, StatemachinePackage.Literals.STATE_MACHINE_DESCRIPTION__STATES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getTransitions() {
		return (EList<Transition>)eDynamicGet(StatemachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS, StatemachinePackage.Literals.STATE_MACHINE_DESCRIPTION__TRANSITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				return getStates();
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				return getTransitions();
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
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends AbstractState>)newValue);
				return;
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				getStates().clear();
				return;
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				getTransitions().clear();
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
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				return !getStates().isEmpty();
			case StatemachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				return !getTransitions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateMachineDescriptionImpl
