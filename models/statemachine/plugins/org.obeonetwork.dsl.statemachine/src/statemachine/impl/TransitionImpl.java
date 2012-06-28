/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package statemachine.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

import statemachine.AbstractState;
import statemachine.StatemachinePackage;
import statemachine.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link statemachine.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link statemachine.impl.TransitionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link statemachine.impl.TransitionImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends ObeoDSMObjectImpl implements Transition {
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
		return StatemachinePackage.Literals.TRANSITION;
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
	public String getGuard() {
		return (String)eDynamicGet(StatemachinePackage.TRANSITION__GUARD, StatemachinePackage.Literals.TRANSITION__GUARD, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(String newGuard) {
		eDynamicSet(StatemachinePackage.TRANSITION__GUARD, StatemachinePackage.Literals.TRANSITION__GUARD, newGuard);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractState getFrom() {
		return (AbstractState)eDynamicGet(StatemachinePackage.TRANSITION__FROM, StatemachinePackage.Literals.TRANSITION__FROM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractState basicGetFrom() {
		return (AbstractState)eDynamicGet(StatemachinePackage.TRANSITION__FROM, StatemachinePackage.Literals.TRANSITION__FROM, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrom(AbstractState newFrom, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newFrom, StatemachinePackage.TRANSITION__FROM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(AbstractState newFrom) {
		eDynamicSet(StatemachinePackage.TRANSITION__FROM, StatemachinePackage.Literals.TRANSITION__FROM, newFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractState getTo() {
		return (AbstractState)eDynamicGet(StatemachinePackage.TRANSITION__TO, StatemachinePackage.Literals.TRANSITION__TO, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractState basicGetTo() {
		return (AbstractState)eDynamicGet(StatemachinePackage.TRANSITION__TO, StatemachinePackage.Literals.TRANSITION__TO, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTo(AbstractState newTo, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newTo, StatemachinePackage.TRANSITION__TO, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(AbstractState newTo) {
		eDynamicSet(StatemachinePackage.TRANSITION__TO, StatemachinePackage.Literals.TRANSITION__TO, newTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatemachinePackage.TRANSITION__FROM:
				AbstractState from = basicGetFrom();
				if (from != null)
					msgs = ((InternalEObject)from).eInverseRemove(this, StatemachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS, AbstractState.class, msgs);
				return basicSetFrom((AbstractState)otherEnd, msgs);
			case StatemachinePackage.TRANSITION__TO:
				AbstractState to = basicGetTo();
				if (to != null)
					msgs = ((InternalEObject)to).eInverseRemove(this, StatemachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS, AbstractState.class, msgs);
				return basicSetTo((AbstractState)otherEnd, msgs);
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
			case StatemachinePackage.TRANSITION__FROM:
				return basicSetFrom(null, msgs);
			case StatemachinePackage.TRANSITION__TO:
				return basicSetTo(null, msgs);
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
			case StatemachinePackage.TRANSITION__GUARD:
				return getGuard();
			case StatemachinePackage.TRANSITION__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case StatemachinePackage.TRANSITION__TO:
				if (resolve) return getTo();
				return basicGetTo();
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
			case StatemachinePackage.TRANSITION__GUARD:
				setGuard((String)newValue);
				return;
			case StatemachinePackage.TRANSITION__FROM:
				setFrom((AbstractState)newValue);
				return;
			case StatemachinePackage.TRANSITION__TO:
				setTo((AbstractState)newValue);
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
			case StatemachinePackage.TRANSITION__GUARD:
				setGuard(GUARD_EDEFAULT);
				return;
			case StatemachinePackage.TRANSITION__FROM:
				setFrom((AbstractState)null);
				return;
			case StatemachinePackage.TRANSITION__TO:
				setTo((AbstractState)null);
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
			case StatemachinePackage.TRANSITION__GUARD:
				return GUARD_EDEFAULT == null ? getGuard() != null : !GUARD_EDEFAULT.equals(getGuard());
			case StatemachinePackage.TRANSITION__FROM:
				return basicGetFrom() != null;
			case StatemachinePackage.TRANSITION__TO:
				return basicGetTo() != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
