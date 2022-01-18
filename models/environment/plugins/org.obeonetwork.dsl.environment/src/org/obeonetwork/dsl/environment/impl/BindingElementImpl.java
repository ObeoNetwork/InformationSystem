/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingElementImpl#getBoundElement <em>Bound Element</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingElementImpl#getBindingExpression <em>Binding Expression</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingElementImpl#getReferencedByAsLeft <em>Referenced By As Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingElementImpl#getReferencedByAsRight <em>Referenced By As Right</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingElementImpl#getReferencedBy <em>Referenced By</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingElementImpl#getPathReferences <em>Path References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindingElementImpl extends ObeoDSMObjectImpl implements BindingElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getBindingExpression() <em>Binding Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String BINDING_EXPRESSION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.BINDING_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundableElement getBoundElement() {
		return (BoundableElement) eDynamicGet(EnvironmentPackage.BINDING_ELEMENT__BOUND_ELEMENT,
				EnvironmentPackage.Literals.BINDING_ELEMENT__BOUND_ELEMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundableElement basicGetBoundElement() {
		return (BoundableElement) eDynamicGet(EnvironmentPackage.BINDING_ELEMENT__BOUND_ELEMENT,
				EnvironmentPackage.Literals.BINDING_ELEMENT__BOUND_ELEMENT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundElement(BoundableElement newBoundElement) {
		eDynamicSet(EnvironmentPackage.BINDING_ELEMENT__BOUND_ELEMENT,
				EnvironmentPackage.Literals.BINDING_ELEMENT__BOUND_ELEMENT, newBoundElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBindingExpression() {
		return (String) eDynamicGet(EnvironmentPackage.BINDING_ELEMENT__BINDING_EXPRESSION,
				EnvironmentPackage.Literals.BINDING_ELEMENT__BINDING_EXPRESSION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingExpression(String newBindingExpression) {
		eDynamicSet(EnvironmentPackage.BINDING_ELEMENT__BINDING_EXPRESSION,
				EnvironmentPackage.Literals.BINDING_ELEMENT__BINDING_EXPRESSION, newBindingExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BindingReference> getReferencedByAsLeft() {
		return (EList<BindingReference>) eDynamicGet(EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT,
				EnvironmentPackage.Literals.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BindingReference> getReferencedByAsRight() {
		return (EList<BindingReference>) eDynamicGet(EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT,
				EnvironmentPackage.Literals.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<BindingReference> getReferencedBy() {
		List<BindingReference> all = new ArrayList<BindingReference>();
		all.addAll(getReferencedByAsLeft());
		all.addAll(getReferencedByAsRight());
		return new UnmodifiableEList<BindingReference>(this, EnvironmentPackage.Literals.BINDING_ELEMENT__REFERENCED_BY,
				all.size(), all.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BoundableElement> getPathReferences() {
		return (EList<BoundableElement>) eDynamicGet(EnvironmentPackage.BINDING_ELEMENT__PATH_REFERENCES,
				EnvironmentPackage.Literals.BINDING_ELEMENT__PATH_REFERENCES, true, true);
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
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getReferencedByAsLeft()).basicAdd(otherEnd,
					msgs);
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getReferencedByAsRight()).basicAdd(otherEnd,
					msgs);
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
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT:
			return ((InternalEList<?>) getReferencedByAsLeft()).basicRemove(otherEnd, msgs);
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT:
			return ((InternalEList<?>) getReferencedByAsRight()).basicRemove(otherEnd, msgs);
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
		case EnvironmentPackage.BINDING_ELEMENT__BOUND_ELEMENT:
			if (resolve)
				return getBoundElement();
			return basicGetBoundElement();
		case EnvironmentPackage.BINDING_ELEMENT__BINDING_EXPRESSION:
			return getBindingExpression();
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT:
			return getReferencedByAsLeft();
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT:
			return getReferencedByAsRight();
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY:
			return getReferencedBy();
		case EnvironmentPackage.BINDING_ELEMENT__PATH_REFERENCES:
			return getPathReferences();
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
		case EnvironmentPackage.BINDING_ELEMENT__BOUND_ELEMENT:
			setBoundElement((BoundableElement) newValue);
			return;
		case EnvironmentPackage.BINDING_ELEMENT__BINDING_EXPRESSION:
			setBindingExpression((String) newValue);
			return;
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT:
			getReferencedByAsLeft().clear();
			getReferencedByAsLeft().addAll((Collection<? extends BindingReference>) newValue);
			return;
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT:
			getReferencedByAsRight().clear();
			getReferencedByAsRight().addAll((Collection<? extends BindingReference>) newValue);
			return;
		case EnvironmentPackage.BINDING_ELEMENT__PATH_REFERENCES:
			getPathReferences().clear();
			getPathReferences().addAll((Collection<? extends BoundableElement>) newValue);
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
		case EnvironmentPackage.BINDING_ELEMENT__BOUND_ELEMENT:
			setBoundElement((BoundableElement) null);
			return;
		case EnvironmentPackage.BINDING_ELEMENT__BINDING_EXPRESSION:
			setBindingExpression(BINDING_EXPRESSION_EDEFAULT);
			return;
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT:
			getReferencedByAsLeft().clear();
			return;
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT:
			getReferencedByAsRight().clear();
			return;
		case EnvironmentPackage.BINDING_ELEMENT__PATH_REFERENCES:
			getPathReferences().clear();
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
		case EnvironmentPackage.BINDING_ELEMENT__BOUND_ELEMENT:
			return basicGetBoundElement() != null;
		case EnvironmentPackage.BINDING_ELEMENT__BINDING_EXPRESSION:
			return BINDING_EXPRESSION_EDEFAULT == null ? getBindingExpression() != null
					: !BINDING_EXPRESSION_EDEFAULT.equals(getBindingExpression());
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT:
			return !getReferencedByAsLeft().isEmpty();
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT:
			return !getReferencedByAsRight().isEmpty();
		case EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY:
			return !getReferencedBy().isEmpty();
		case EnvironmentPackage.BINDING_ELEMENT__PATH_REFERENCES:
			return !getPathReferences().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BindingElementImpl
