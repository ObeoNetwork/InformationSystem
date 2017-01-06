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
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ReferenceImpl#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ReferenceImpl#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ReferenceImpl#getOppositeOf <em>Opposite Of</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ReferenceImpl#getContainingType <em>Containing Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ReferenceImpl#getReferencedType <em>Referenced Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends PropertyImpl implements Reference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #isIsComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMPOSITE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isNavigable() <em>Navigable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNavigable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NAVIGABLE_EDEFAULT = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsComposite() {
		return (Boolean) eDynamicGet(EnvironmentPackage.REFERENCE__IS_COMPOSITE,
				EnvironmentPackage.Literals.REFERENCE__IS_COMPOSITE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsComposite(boolean newIsComposite) {
		eDynamicSet(EnvironmentPackage.REFERENCE__IS_COMPOSITE, EnvironmentPackage.Literals.REFERENCE__IS_COMPOSITE,
				newIsComposite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNavigable() {
		return (Boolean) eDynamicGet(EnvironmentPackage.REFERENCE__NAVIGABLE,
				EnvironmentPackage.Literals.REFERENCE__NAVIGABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNavigable(boolean newNavigable) {
		eDynamicSet(EnvironmentPackage.REFERENCE__NAVIGABLE, EnvironmentPackage.Literals.REFERENCE__NAVIGABLE,
				newNavigable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getOppositeOf() {
		return (Reference) eDynamicGet(EnvironmentPackage.REFERENCE__OPPOSITE_OF,
				EnvironmentPackage.Literals.REFERENCE__OPPOSITE_OF, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference basicGetOppositeOf() {
		return (Reference) eDynamicGet(EnvironmentPackage.REFERENCE__OPPOSITE_OF,
				EnvironmentPackage.Literals.REFERENCE__OPPOSITE_OF, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeOf(Reference newOppositeOf) {
		eDynamicSet(EnvironmentPackage.REFERENCE__OPPOSITE_OF, EnvironmentPackage.Literals.REFERENCE__OPPOSITE_OF,
				newOppositeOf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredType getContainingType() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.REFERENCE__CONTAINING_TYPE,
				EnvironmentPackage.Literals.REFERENCE__CONTAINING_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredType basicGetContainingType() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.REFERENCE__CONTAINING_TYPE,
				EnvironmentPackage.Literals.REFERENCE__CONTAINING_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingType(StructuredType newContainingType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingType, EnvironmentPackage.REFERENCE__CONTAINING_TYPE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingType(StructuredType newContainingType) {
		eDynamicSet(EnvironmentPackage.REFERENCE__CONTAINING_TYPE,
				EnvironmentPackage.Literals.REFERENCE__CONTAINING_TYPE, newContainingType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredType getReferencedType() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.REFERENCE__REFERENCED_TYPE,
				EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredType basicGetReferencedType() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.REFERENCE__REFERENCED_TYPE,
				EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedType(StructuredType newReferencedType) {
		eDynamicSet(EnvironmentPackage.REFERENCE__REFERENCED_TYPE,
				EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE, newReferencedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean canBeOppositeOf(Reference opposite) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.REFERENCE__CONTAINING_TYPE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingType((StructuredType) otherEnd, msgs);
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
		case EnvironmentPackage.REFERENCE__CONTAINING_TYPE:
			return basicSetContainingType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case EnvironmentPackage.REFERENCE__CONTAINING_TYPE:
			return eInternalContainer().eInverseRemove(this, EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES,
					StructuredType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EnvironmentPackage.REFERENCE__IS_COMPOSITE:
			return isIsComposite();
		case EnvironmentPackage.REFERENCE__NAVIGABLE:
			return isNavigable();
		case EnvironmentPackage.REFERENCE__OPPOSITE_OF:
			if (resolve)
				return getOppositeOf();
			return basicGetOppositeOf();
		case EnvironmentPackage.REFERENCE__CONTAINING_TYPE:
			if (resolve)
				return getContainingType();
			return basicGetContainingType();
		case EnvironmentPackage.REFERENCE__REFERENCED_TYPE:
			if (resolve)
				return getReferencedType();
			return basicGetReferencedType();
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
		case EnvironmentPackage.REFERENCE__IS_COMPOSITE:
			setIsComposite((Boolean) newValue);
			return;
		case EnvironmentPackage.REFERENCE__NAVIGABLE:
			setNavigable((Boolean) newValue);
			return;
		case EnvironmentPackage.REFERENCE__OPPOSITE_OF:
			setOppositeOf((Reference) newValue);
			return;
		case EnvironmentPackage.REFERENCE__CONTAINING_TYPE:
			setContainingType((StructuredType) newValue);
			return;
		case EnvironmentPackage.REFERENCE__REFERENCED_TYPE:
			setReferencedType((StructuredType) newValue);
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
		case EnvironmentPackage.REFERENCE__IS_COMPOSITE:
			setIsComposite(IS_COMPOSITE_EDEFAULT);
			return;
		case EnvironmentPackage.REFERENCE__NAVIGABLE:
			setNavigable(NAVIGABLE_EDEFAULT);
			return;
		case EnvironmentPackage.REFERENCE__OPPOSITE_OF:
			setOppositeOf((Reference) null);
			return;
		case EnvironmentPackage.REFERENCE__CONTAINING_TYPE:
			setContainingType((StructuredType) null);
			return;
		case EnvironmentPackage.REFERENCE__REFERENCED_TYPE:
			setReferencedType((StructuredType) null);
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
		case EnvironmentPackage.REFERENCE__IS_COMPOSITE:
			return isIsComposite() != IS_COMPOSITE_EDEFAULT;
		case EnvironmentPackage.REFERENCE__NAVIGABLE:
			return isNavigable() != NAVIGABLE_EDEFAULT;
		case EnvironmentPackage.REFERENCE__OPPOSITE_OF:
			return basicGetOppositeOf() != null;
		case EnvironmentPackage.REFERENCE__CONTAINING_TYPE:
			return basicGetContainingType() != null;
		case EnvironmentPackage.REFERENCE__REFERENCED_TYPE:
			return basicGetReferencedType() != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceImpl
