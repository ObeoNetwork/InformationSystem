/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.MediaType;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.ParameterRestData;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getMediaType <em>Media Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getStatusMessage <em>Status Message</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getRestData <em>Rest Data</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterImpl extends ObeoDSMObjectImpl implements Parameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final MultiplicityKind MULTIPLICITY_EDEFAULT = MultiplicityKind.ONE_LITERAL;

	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_CODE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getStatusMessage() <em>Status Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_MESSAGE_EDEFAULT = null;

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
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_EDEFAULT = null;

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
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType() {
		return (Type)eDynamicGet(SoaPackage.PARAMETER__TYPE, SoaPackage.Literals.PARAMETER__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return (Type)eDynamicGet(SoaPackage.PARAMETER__TYPE, SoaPackage.Literals.PARAMETER__TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Type newType) {
		eDynamicSet(SoaPackage.PARAMETER__TYPE, SoaPackage.Literals.PARAMETER__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<MediaType> getMediaType() {
		return (EList<MediaType>)eDynamicGet(SoaPackage.PARAMETER__MEDIA_TYPE, SoaPackage.Literals.PARAMETER__MEDIA_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String)eDynamicGet(SoaPackage.PARAMETER__NAME, SoaPackage.Literals.PARAMETER__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(SoaPackage.PARAMETER__NAME, SoaPackage.Literals.PARAMETER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MultiplicityKind getMultiplicity() {
		return (MultiplicityKind)eDynamicGet(SoaPackage.PARAMETER__MULTIPLICITY, SoaPackage.Literals.PARAMETER__MULTIPLICITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMultiplicity(MultiplicityKind newMultiplicity) {
		eDynamicSet(SoaPackage.PARAMETER__MULTIPLICITY, SoaPackage.Literals.PARAMETER__MULTIPLICITY, newMultiplicity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsUnique() {
		return (Boolean)eDynamicGet(SoaPackage.PARAMETER__IS_UNIQUE, SoaPackage.Literals.PARAMETER__IS_UNIQUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsUnique(boolean newIsUnique) {
		eDynamicSet(SoaPackage.PARAMETER__IS_UNIQUE, SoaPackage.Literals.PARAMETER__IS_UNIQUE, newIsUnique);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOrdered() {
		return (Boolean)eDynamicGet(SoaPackage.PARAMETER__IS_ORDERED, SoaPackage.Literals.PARAMETER__IS_ORDERED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOrdered(boolean newIsOrdered) {
		eDynamicSet(SoaPackage.PARAMETER__IS_ORDERED, SoaPackage.Literals.PARAMETER__IS_ORDERED, newIsOrdered);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatusCode() {
		return (String)eDynamicGet(SoaPackage.PARAMETER__STATUS_CODE, SoaPackage.Literals.PARAMETER__STATUS_CODE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatusCode(String newStatusCode) {
		eDynamicSet(SoaPackage.PARAMETER__STATUS_CODE, SoaPackage.Literals.PARAMETER__STATUS_CODE, newStatusCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatusMessage() {
		return (String)eDynamicGet(SoaPackage.PARAMETER__STATUS_MESSAGE, SoaPackage.Literals.PARAMETER__STATUS_MESSAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatusMessage(String newStatusMessage) {
		eDynamicSet(SoaPackage.PARAMETER__STATUS_MESSAGE, SoaPackage.Literals.PARAMETER__STATUS_MESSAGE, newStatusMessage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterRestData getRestData() {
		return (ParameterRestData)eDynamicGet(SoaPackage.PARAMETER__REST_DATA, SoaPackage.Literals.PARAMETER__REST_DATA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterRestData basicGetRestData() {
		return (ParameterRestData)eDynamicGet(SoaPackage.PARAMETER__REST_DATA, SoaPackage.Literals.PARAMETER__REST_DATA, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRestData(ParameterRestData newRestData, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newRestData, SoaPackage.PARAMETER__REST_DATA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRestData(ParameterRestData newRestData) {
		eDynamicSet(SoaPackage.PARAMETER__REST_DATA, SoaPackage.Literals.PARAMETER__REST_DATA, newRestData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMinimum() {
		return (String)eDynamicGet(SoaPackage.PARAMETER__MINIMUM, SoaPackage.Literals.PARAMETER__MINIMUM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimum(String newMinimum) {
		eDynamicSet(SoaPackage.PARAMETER__MINIMUM, SoaPackage.Literals.PARAMETER__MINIMUM, newMinimum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMaximum() {
		return (String)eDynamicGet(SoaPackage.PARAMETER__MAXIMUM, SoaPackage.Literals.PARAMETER__MAXIMUM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaximum(String newMaximum) {
		eDynamicSet(SoaPackage.PARAMETER__MAXIMUM, SoaPackage.Literals.PARAMETER__MAXIMUM, newMaximum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPattern() {
		return (String)eDynamicGet(SoaPackage.PARAMETER__PATTERN, SoaPackage.Literals.PARAMETER__PATTERN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPattern(String newPattern) {
		eDynamicSet(SoaPackage.PARAMETER__PATTERN, SoaPackage.Literals.PARAMETER__PATTERN, newPattern);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.PARAMETER__MEDIA_TYPE:
				return ((InternalEList<?>)getMediaType()).basicRemove(otherEnd, msgs);
			case SoaPackage.PARAMETER__REST_DATA:
				return basicSetRestData(null, msgs);
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
			case SoaPackage.PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case SoaPackage.PARAMETER__MEDIA_TYPE:
				return getMediaType();
			case SoaPackage.PARAMETER__NAME:
				return getName();
			case SoaPackage.PARAMETER__MULTIPLICITY:
				return getMultiplicity();
			case SoaPackage.PARAMETER__IS_UNIQUE:
				return isIsUnique();
			case SoaPackage.PARAMETER__IS_ORDERED:
				return isIsOrdered();
			case SoaPackage.PARAMETER__STATUS_CODE:
				return getStatusCode();
			case SoaPackage.PARAMETER__STATUS_MESSAGE:
				return getStatusMessage();
			case SoaPackage.PARAMETER__REST_DATA:
				if (resolve) return getRestData();
				return basicGetRestData();
			case SoaPackage.PARAMETER__MINIMUM:
				return getMinimum();
			case SoaPackage.PARAMETER__MAXIMUM:
				return getMaximum();
			case SoaPackage.PARAMETER__PATTERN:
				return getPattern();
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
			case SoaPackage.PARAMETER__TYPE:
				setType((Type)newValue);
				return;
			case SoaPackage.PARAMETER__MEDIA_TYPE:
				getMediaType().clear();
				getMediaType().addAll((Collection<? extends MediaType>)newValue);
				return;
			case SoaPackage.PARAMETER__NAME:
				setName((String)newValue);
				return;
			case SoaPackage.PARAMETER__MULTIPLICITY:
				setMultiplicity((MultiplicityKind)newValue);
				return;
			case SoaPackage.PARAMETER__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case SoaPackage.PARAMETER__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case SoaPackage.PARAMETER__STATUS_CODE:
				setStatusCode((String)newValue);
				return;
			case SoaPackage.PARAMETER__STATUS_MESSAGE:
				setStatusMessage((String)newValue);
				return;
			case SoaPackage.PARAMETER__REST_DATA:
				setRestData((ParameterRestData)newValue);
				return;
			case SoaPackage.PARAMETER__MINIMUM:
				setMinimum((String)newValue);
				return;
			case SoaPackage.PARAMETER__MAXIMUM:
				setMaximum((String)newValue);
				return;
			case SoaPackage.PARAMETER__PATTERN:
				setPattern((String)newValue);
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
			case SoaPackage.PARAMETER__TYPE:
				setType((Type)null);
				return;
			case SoaPackage.PARAMETER__MEDIA_TYPE:
				getMediaType().clear();
				return;
			case SoaPackage.PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__STATUS_CODE:
				setStatusCode(STATUS_CODE_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__STATUS_MESSAGE:
				setStatusMessage(STATUS_MESSAGE_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__REST_DATA:
				setRestData((ParameterRestData)null);
				return;
			case SoaPackage.PARAMETER__MINIMUM:
				setMinimum(MINIMUM_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__PATTERN:
				setPattern(PATTERN_EDEFAULT);
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
			case SoaPackage.PARAMETER__TYPE:
				return basicGetType() != null;
			case SoaPackage.PARAMETER__MEDIA_TYPE:
				return !getMediaType().isEmpty();
			case SoaPackage.PARAMETER__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SoaPackage.PARAMETER__MULTIPLICITY:
				return getMultiplicity() != MULTIPLICITY_EDEFAULT;
			case SoaPackage.PARAMETER__IS_UNIQUE:
				return isIsUnique() != IS_UNIQUE_EDEFAULT;
			case SoaPackage.PARAMETER__IS_ORDERED:
				return isIsOrdered() != IS_ORDERED_EDEFAULT;
			case SoaPackage.PARAMETER__STATUS_CODE:
				return STATUS_CODE_EDEFAULT == null ? getStatusCode() != null : !STATUS_CODE_EDEFAULT.equals(getStatusCode());
			case SoaPackage.PARAMETER__STATUS_MESSAGE:
				return STATUS_MESSAGE_EDEFAULT == null ? getStatusMessage() != null : !STATUS_MESSAGE_EDEFAULT.equals(getStatusMessage());
			case SoaPackage.PARAMETER__REST_DATA:
				return basicGetRestData() != null;
			case SoaPackage.PARAMETER__MINIMUM:
				return MINIMUM_EDEFAULT == null ? getMinimum() != null : !MINIMUM_EDEFAULT.equals(getMinimum());
			case SoaPackage.PARAMETER__MAXIMUM:
				return MAXIMUM_EDEFAULT == null ? getMaximum() != null : !MAXIMUM_EDEFAULT.equals(getMaximum());
			case SoaPackage.PARAMETER__PATTERN:
				return PATTERN_EDEFAULT == null ? getPattern() != null : !PATTERN_EDEFAULT.equals(getPattern());
		}
		return super.eIsSet(featureID);
	}

} //ParameterImpl