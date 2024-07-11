/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.ConstrainableElement;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.AttributeImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.AttributeImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.AttributeImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.AttributeImpl#getContainingType <em>Containing Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends PropertyImpl implements Attribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final String MINIMUM_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMaximum() {
		return (String) eDynamicGet(EnvironmentPackage.ATTRIBUTE__MAXIMUM,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MAXIMUM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaximum(String newMaximum) {
		eDynamicSet(EnvironmentPackage.ATTRIBUTE__MAXIMUM, EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MAXIMUM,
				newMaximum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMinimum() {
		return (String) eDynamicGet(EnvironmentPackage.ATTRIBUTE__MINIMUM,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MINIMUM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimum(String newMinimum) {
		eDynamicSet(EnvironmentPackage.ATTRIBUTE__MINIMUM, EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MINIMUM,
				newMinimum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPattern() {
		return (String) eDynamicGet(EnvironmentPackage.ATTRIBUTE__PATTERN,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__PATTERN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPattern(String newPattern) {
		eDynamicSet(EnvironmentPackage.ATTRIBUTE__PATTERN, EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__PATTERN,
				newPattern);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getType() {
		return (DataType) eDynamicGet(EnvironmentPackage.ATTRIBUTE__TYPE, EnvironmentPackage.Literals.ATTRIBUTE__TYPE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetType() {
		return (DataType) eDynamicGet(EnvironmentPackage.ATTRIBUTE__TYPE, EnvironmentPackage.Literals.ATTRIBUTE__TYPE,
				false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(DataType newType) {
		eDynamicSet(EnvironmentPackage.ATTRIBUTE__TYPE, EnvironmentPackage.Literals.ATTRIBUTE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredType getContainingType() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE,
				EnvironmentPackage.Literals.ATTRIBUTE__CONTAINING_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredType basicGetContainingType() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE,
				EnvironmentPackage.Literals.ATTRIBUTE__CONTAINING_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingType(StructuredType newContainingType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingType, EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainingType(StructuredType newContainingType) {
		eDynamicSet(EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE,
				EnvironmentPackage.Literals.ATTRIBUTE__CONTAINING_TYPE, newContainingType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE:
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
		case EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE:
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
		case EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE:
			return eInternalContainer().eInverseRemove(this, EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES,
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
		case EnvironmentPackage.ATTRIBUTE__MAXIMUM:
			return getMaximum();
		case EnvironmentPackage.ATTRIBUTE__MINIMUM:
			return getMinimum();
		case EnvironmentPackage.ATTRIBUTE__PATTERN:
			return getPattern();
		case EnvironmentPackage.ATTRIBUTE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE:
			if (resolve)
				return getContainingType();
			return basicGetContainingType();
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
		case EnvironmentPackage.ATTRIBUTE__MAXIMUM:
			setMaximum((String) newValue);
			return;
		case EnvironmentPackage.ATTRIBUTE__MINIMUM:
			setMinimum((String) newValue);
			return;
		case EnvironmentPackage.ATTRIBUTE__PATTERN:
			setPattern((String) newValue);
			return;
		case EnvironmentPackage.ATTRIBUTE__TYPE:
			setType((DataType) newValue);
			return;
		case EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE:
			setContainingType((StructuredType) newValue);
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
		case EnvironmentPackage.ATTRIBUTE__MAXIMUM:
			setMaximum(MAXIMUM_EDEFAULT);
			return;
		case EnvironmentPackage.ATTRIBUTE__MINIMUM:
			setMinimum(MINIMUM_EDEFAULT);
			return;
		case EnvironmentPackage.ATTRIBUTE__PATTERN:
			setPattern(PATTERN_EDEFAULT);
			return;
		case EnvironmentPackage.ATTRIBUTE__TYPE:
			setType((DataType) null);
			return;
		case EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE:
			setContainingType((StructuredType) null);
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
		case EnvironmentPackage.ATTRIBUTE__MAXIMUM:
			return MAXIMUM_EDEFAULT == null ? getMaximum() != null : !MAXIMUM_EDEFAULT.equals(getMaximum());
		case EnvironmentPackage.ATTRIBUTE__MINIMUM:
			return MINIMUM_EDEFAULT == null ? getMinimum() != null : !MINIMUM_EDEFAULT.equals(getMinimum());
		case EnvironmentPackage.ATTRIBUTE__PATTERN:
			return PATTERN_EDEFAULT == null ? getPattern() != null : !PATTERN_EDEFAULT.equals(getPattern());
		case EnvironmentPackage.ATTRIBUTE__TYPE:
			return basicGetType() != null;
		case EnvironmentPackage.ATTRIBUTE__CONTAINING_TYPE:
			return basicGetContainingType() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConstrainableElement.class) {
			switch (derivedFeatureID) {
			case EnvironmentPackage.ATTRIBUTE__MAXIMUM:
				return EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM;
			case EnvironmentPackage.ATTRIBUTE__MINIMUM:
				return EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM;
			case EnvironmentPackage.ATTRIBUTE__PATTERN:
				return EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ConstrainableElement.class) {
			switch (baseFeatureID) {
			case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM:
				return EnvironmentPackage.ATTRIBUTE__MAXIMUM;
			case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM:
				return EnvironmentPackage.ATTRIBUTE__MINIMUM;
			case EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN:
				return EnvironmentPackage.ATTRIBUTE__PATTERN;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //AttributeImpl
