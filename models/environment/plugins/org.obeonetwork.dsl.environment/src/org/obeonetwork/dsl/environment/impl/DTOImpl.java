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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.FilterContainer;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DTO</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getOwnedContainer <em>Owned Container</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getAssociatedTypes <em>Associated Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getSupertype <em>Supertype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DTOImpl extends StructuredTypeImpl implements DTO {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DTOImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.DTO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterContainer getOwnedContainer() {
		return (FilterContainer) eDynamicGet(
				EnvironmentPackage.DTO__OWNED_CONTAINER,
				EnvironmentPackage.Literals.DTO__OWNED_CONTAINER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterContainer basicGetOwnedContainer() {
		return (FilterContainer) eDynamicGet(
				EnvironmentPackage.DTO__OWNED_CONTAINER,
				EnvironmentPackage.Literals.DTO__OWNED_CONTAINER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedContainer(
			FilterContainer newOwnedContainer, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newOwnedContainer,
				EnvironmentPackage.DTO__OWNED_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedContainer(FilterContainer newOwnedContainer) {
		eDynamicSet(EnvironmentPackage.DTO__OWNED_CONTAINER,
				EnvironmentPackage.Literals.DTO__OWNED_CONTAINER,
				newOwnedContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StructuredType> getAssociatedTypes() {
		return (EList<StructuredType>) eDynamicGet(
				EnvironmentPackage.DTO__ASSOCIATED_TYPES,
				EnvironmentPackage.Literals.DTO__ASSOCIATED_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Property> getProperties() {
		BasicEList result = new UniqueEList() {
			protected Object[] newData(int capacity) {
				return new Property[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getAttributes());
		result.addAll(getReferences());
		result.shrink();
		EList unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare(
				this, EnvironmentPackage.eINSTANCE.getDTO_Attributes(),
				result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Reference> getReferences() {
		BasicEList result = new UniqueEList() {
			protected Object[] newData(int capacity) {
				return new Reference[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getOwnedReferences());
		if (getSupertype() != null)
			result.addAll(getSupertype().getReferences());
		result.shrink();
		EList unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare(
				this, EnvironmentPackage.eINSTANCE.getDTO_References(),
				result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Reference> getOwnedReferences() {
		return (EList<Reference>) eDynamicGet(
				EnvironmentPackage.DTO__OWNED_REFERENCES,
				EnvironmentPackage.Literals.DTO__OWNED_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Attribute> getAttributes() {
		BasicEList result = new UniqueEList() {
			protected Object[] newData(int capacity) {
				return new Attribute[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getOwnedAttributes());
		if (getSupertype() != null)
			result.addAll(getSupertype().getAttributes());
		result.shrink();
		EList unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare(
				this, EnvironmentPackage.eINSTANCE.getDTO_Attributes(),
				result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Attribute> getOwnedAttributes() {
		return (EList<Attribute>) eDynamicGet(
				EnvironmentPackage.DTO__OWNED_ATTRIBUTES,
				EnvironmentPackage.Literals.DTO__OWNED_ATTRIBUTES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTO getSupertype() {
		return (DTO) eDynamicGet(EnvironmentPackage.DTO__SUPERTYPE,
				EnvironmentPackage.Literals.DTO__SUPERTYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTO basicGetSupertype() {
		return (DTO) eDynamicGet(EnvironmentPackage.DTO__SUPERTYPE,
				EnvironmentPackage.Literals.DTO__SUPERTYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupertype(DTO newSupertype) {
		eDynamicSet(EnvironmentPackage.DTO__SUPERTYPE,
				EnvironmentPackage.Literals.DTO__SUPERTYPE, newSupertype);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSubtypeOf(DTO dto) {
		// A DTO A is a subtype of a DTO B
		// - A and B are both the same DTO
		// - the supertype of A is B
		// - the supertype of A is a subtype of B
		return (EcoreUtil.equals(this, dto) || (getSupertype() != null && (EcoreUtil
				.equals(getSupertype(), dto) || getSupertype().isSubtypeOf(dto))));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.DTO__OWNED_REFERENCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedReferences())
					.basicAdd(otherEnd, msgs);
		case EnvironmentPackage.DTO__OWNED_ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedAttributes())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			return basicSetOwnedContainer(null, msgs);
		case EnvironmentPackage.DTO__OWNED_REFERENCES:
			return ((InternalEList<?>) getOwnedReferences()).basicRemove(
					otherEnd, msgs);
		case EnvironmentPackage.DTO__OWNED_ATTRIBUTES:
			return ((InternalEList<?>) getOwnedAttributes()).basicRemove(
					otherEnd, msgs);
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			if (resolve)
				return getOwnedContainer();
			return basicGetOwnedContainer();
		case EnvironmentPackage.DTO__ASSOCIATED_TYPES:
			return getAssociatedTypes();
		case EnvironmentPackage.DTO__PROPERTIES:
			return getProperties();
		case EnvironmentPackage.DTO__REFERENCES:
			return getReferences();
		case EnvironmentPackage.DTO__OWNED_REFERENCES:
			return getOwnedReferences();
		case EnvironmentPackage.DTO__ATTRIBUTES:
			return getAttributes();
		case EnvironmentPackage.DTO__OWNED_ATTRIBUTES:
			return getOwnedAttributes();
		case EnvironmentPackage.DTO__SUPERTYPE:
			if (resolve)
				return getSupertype();
			return basicGetSupertype();
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			setOwnedContainer((FilterContainer) newValue);
			return;
		case EnvironmentPackage.DTO__ASSOCIATED_TYPES:
			getAssociatedTypes().clear();
			getAssociatedTypes().addAll(
					(Collection<? extends StructuredType>) newValue);
			return;
		case EnvironmentPackage.DTO__OWNED_REFERENCES:
			getOwnedReferences().clear();
			getOwnedReferences().addAll(
					(Collection<? extends Reference>) newValue);
			return;
		case EnvironmentPackage.DTO__OWNED_ATTRIBUTES:
			getOwnedAttributes().clear();
			getOwnedAttributes().addAll(
					(Collection<? extends Attribute>) newValue);
			return;
		case EnvironmentPackage.DTO__SUPERTYPE:
			setSupertype((DTO) newValue);
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			setOwnedContainer((FilterContainer) null);
			return;
		case EnvironmentPackage.DTO__ASSOCIATED_TYPES:
			getAssociatedTypes().clear();
			return;
		case EnvironmentPackage.DTO__OWNED_REFERENCES:
			getOwnedReferences().clear();
			return;
		case EnvironmentPackage.DTO__OWNED_ATTRIBUTES:
			getOwnedAttributes().clear();
			return;
		case EnvironmentPackage.DTO__SUPERTYPE:
			setSupertype((DTO) null);
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			return basicGetOwnedContainer() != null;
		case EnvironmentPackage.DTO__ASSOCIATED_TYPES:
			return !getAssociatedTypes().isEmpty();
		case EnvironmentPackage.DTO__PROPERTIES:
			return !getProperties().isEmpty();
		case EnvironmentPackage.DTO__REFERENCES:
			return !getReferences().isEmpty();
		case EnvironmentPackage.DTO__OWNED_REFERENCES:
			return !getOwnedReferences().isEmpty();
		case EnvironmentPackage.DTO__ATTRIBUTES:
			return !getAttributes().isEmpty();
		case EnvironmentPackage.DTO__OWNED_ATTRIBUTES:
			return !getOwnedAttributes().isEmpty();
		case EnvironmentPackage.DTO__SUPERTYPE:
			return basicGetSupertype() != null;
		}
		return super.eIsSet(featureID);
	}

} //DTOImpl