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
package org.obeonetwork.dsl.interaction.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.Execution;
import org.obeonetwork.dsl.interaction.InteractionFragment;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.Message;
import org.obeonetwork.dsl.interaction.Operand;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.interaction.StateInvariant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.EndImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.EndImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EndImpl extends NamedElementImpl implements End {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getContext() {
		return (Participant)eDynamicGet(InteractionPackage.END__CONTEXT, InteractionPackage.Literals.END__CONTEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetContext() {
		return (Participant)eDynamicGet(InteractionPackage.END__CONTEXT, InteractionPackage.Literals.END__CONTEXT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Participant newContext) {
		eDynamicSet(InteractionPackage.END__CONTEXT, InteractionPackage.Literals.END__CONTEXT, newContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionFragment getOwner() {
		return (InteractionFragment)eDynamicGet(InteractionPackage.END__OWNER, InteractionPackage.Literals.END__OWNER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionFragment basicGetOwner() {
		return (InteractionFragment)eDynamicGet(InteractionPackage.END__OWNER, InteractionPackage.Literals.END__OWNER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(InteractionFragment newOwner) {
		eDynamicSet(InteractionPackage.END__OWNER, InteractionPackage.Literals.END__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Checks if the end is a starting end
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStartingEnd() {
		return (getOwner() != null && equals(getOwner().getStartingEnd()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Checks if the end is a finishing end
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isFinishingEnd() {
		return (getOwner() != null && equals(getOwner().getFinishingEnd()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the end's owner is a message
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMessageEnd() {
		return (getOwner() != null && getOwner() instanceof Message);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the owner as an execution if the end's owner is a message
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Message getMessage() {
		if (isMessageEnd()) {
			return (Message)getOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the end's owner is an execution
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isExecutionEnd() {
		return (getOwner() != null && getOwner() instanceof Execution);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the owner as an execution if the end's owner is an execution
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Execution getExecution() {
		if (isExecutionEnd()) {
			return (Execution)getOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the end's owner is a state invariant
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStateInvariantEnd() {
		return (getOwner() != null && getOwner() instanceof StateInvariant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the owner as an execution if the end's owner is a state invariant
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StateInvariant getStateInvariant() {
		if (isStateInvariantEnd()) {
			return (StateInvariant)getOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the end's owner is an interaction use
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isInteractionUseEnd() {
		return (getOwner() != null && getOwner() instanceof InteractionUse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the owner as an execution if the end's owner is an interaction use
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InteractionUse getInteractionUse() {
		if (isInteractionUseEnd()) {
			return (InteractionUse)getOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the end's owner is a combined fragment
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isCombinedFragmentEnd() {
		return (getOwner() != null && getOwner() instanceof CombinedFragment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the owner as an execution if the end's owner is a combined fragment
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CombinedFragment getCombinedFragment() {
		if (isCombinedFragmentEnd()) {
			return (CombinedFragment)getOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the end's owner is an operand
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isOperandEnd() {
		return (getOwner() != null && getOwner() instanceof Operand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the owner as an execution if the end's owner is an operand
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Operand getOperand() {
		if (isOperandEnd()) {
			return (Operand)getOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.END__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case InteractionPackage.END__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
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
			case InteractionPackage.END__CONTEXT:
				setContext((Participant)newValue);
				return;
			case InteractionPackage.END__OWNER:
				setOwner((InteractionFragment)newValue);
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
			case InteractionPackage.END__CONTEXT:
				setContext((Participant)null);
				return;
			case InteractionPackage.END__OWNER:
				setOwner((InteractionFragment)null);
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
			case InteractionPackage.END__CONTEXT:
				return basicGetContext() != null;
			case InteractionPackage.END__OWNER:
				return basicGetOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //EndImpl
