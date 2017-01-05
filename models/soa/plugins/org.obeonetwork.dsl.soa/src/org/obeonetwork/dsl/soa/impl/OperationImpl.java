/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.impl.ActionImpl;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.OperationKind;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#isPublic <em>Public</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getFault <em>Fault</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends ActionImpl implements Operation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final OperationKind KIND_EDEFAULT = OperationKind.REQUEST_RESPONSE_LITERAL;
	/**
	 * The default value of the '{@link #isPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PUBLIC_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getInput() {
		return (EList<Parameter>)eDynamicGet(SoaPackage.OPERATION__INPUT, SoaPackage.Literals.OPERATION__INPUT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getOutput() {
		return (EList<Parameter>)eDynamicGet(SoaPackage.OPERATION__OUTPUT, SoaPackage.Literals.OPERATION__OUTPUT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationKind getKind() {
		return (OperationKind)eDynamicGet(SoaPackage.OPERATION__KIND, SoaPackage.Literals.OPERATION__KIND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(OperationKind newKind) {
		eDynamicSet(SoaPackage.OPERATION__KIND, SoaPackage.Literals.OPERATION__KIND, newKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPublic() {
		return (Boolean)eDynamicGet(SoaPackage.OPERATION__PUBLIC, SoaPackage.Literals.OPERATION__PUBLIC, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublic(boolean newPublic) {
		eDynamicSet(SoaPackage.OPERATION__PUBLIC, SoaPackage.Literals.OPERATION__PUBLIC, newPublic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getFault() {
		return (EList<Parameter>)eDynamicGet(SoaPackage.OPERATION__FAULT, SoaPackage.Literals.OPERATION__FAULT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.OPERATION__INPUT:
				return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
			case SoaPackage.OPERATION__OUTPUT:
				return ((InternalEList<?>)getOutput()).basicRemove(otherEnd, msgs);
			case SoaPackage.OPERATION__FAULT:
				return ((InternalEList<?>)getFault()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.OPERATION__INPUT:
				return getInput();
			case SoaPackage.OPERATION__OUTPUT:
				return getOutput();
			case SoaPackage.OPERATION__KIND:
				return getKind();
			case SoaPackage.OPERATION__PUBLIC:
				return isPublic();
			case SoaPackage.OPERATION__FAULT:
				return getFault();
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
			case SoaPackage.OPERATION__INPUT:
				getInput().clear();
				getInput().addAll((Collection<? extends Parameter>)newValue);
				return;
			case SoaPackage.OPERATION__OUTPUT:
				getOutput().clear();
				getOutput().addAll((Collection<? extends Parameter>)newValue);
				return;
			case SoaPackage.OPERATION__KIND:
				setKind((OperationKind)newValue);
				return;
			case SoaPackage.OPERATION__PUBLIC:
				setPublic((Boolean)newValue);
				return;
			case SoaPackage.OPERATION__FAULT:
				getFault().clear();
				getFault().addAll((Collection<? extends Parameter>)newValue);
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
			case SoaPackage.OPERATION__INPUT:
				getInput().clear();
				return;
			case SoaPackage.OPERATION__OUTPUT:
				getOutput().clear();
				return;
			case SoaPackage.OPERATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case SoaPackage.OPERATION__PUBLIC:
				setPublic(PUBLIC_EDEFAULT);
				return;
			case SoaPackage.OPERATION__FAULT:
				getFault().clear();
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
			case SoaPackage.OPERATION__INPUT:
				return !getInput().isEmpty();
			case SoaPackage.OPERATION__OUTPUT:
				return !getOutput().isEmpty();
			case SoaPackage.OPERATION__KIND:
				return getKind() != KIND_EDEFAULT;
			case SoaPackage.OPERATION__PUBLIC:
				return isPublic() != PUBLIC_EDEFAULT;
			case SoaPackage.OPERATION__FAULT:
				return !getFault().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationImpl