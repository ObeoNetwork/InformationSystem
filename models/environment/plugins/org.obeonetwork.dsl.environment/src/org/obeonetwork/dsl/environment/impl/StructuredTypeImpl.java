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
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structured Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getAssociatedTypes <em>Associated Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StructuredTypeImpl extends TypeImpl implements StructuredType {
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
	protected StructuredTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.STRUCTURED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredType getSupertype() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__SUPERTYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredType basicGetSupertype() {
		return (StructuredType) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__SUPERTYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupertype(StructuredType newSupertype) {
		eDynamicSet(EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__SUPERTYPE, newSupertype);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StructuredType> getAssociatedTypes() {
		return (EList<StructuredType>) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__ASSOCIATED_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Attribute> getOwnedAttributes() {
		return (EList<Attribute>) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_ATTRIBUTES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Attribute> getAttributes() {
		BasicEList<Attribute> result = new UniqueEList<Attribute>() {
			private static final long serialVersionUID = 7590892592603363094L;

			protected Object[] newData(int capacity) {
				return new Attribute[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getOwnedAttributes());
		if (getSupertype() != null) {
			result.addAll(getSupertype().getAttributes());
		}
		result.shrink();
		EList<Attribute> unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare<Attribute>(this,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__ATTRIBUTES, result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Reference> getOwnedReferences() {
		return (EList<Reference>) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Reference> getReferences() {
		BasicEList<Reference> result = new UniqueEList<Reference>() {
			private static final long serialVersionUID = 7590892592603363094L;

			protected Object[] newData(int capacity) {
				return new Reference[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getOwnedReferences());
		if (getSupertype() != null) {
			result.addAll(getSupertype().getReferences());
		}
		result.shrink();
		EList<Reference> unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare<Reference>(this,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__REFERENCES, result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Property> getProperties() {
		BasicEList<Property> result = new UniqueEList<Property>() {
			private static final long serialVersionUID = 3148122129800312442L;

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
		EList<Property> unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare<Property>(this,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__PROPERTIES, result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSubtypeOf(StructuredType type) {
		// A structured type A is a subtype of a structured type B
		// - A and B are both the same structured type
		// - the supertype of A is B
		// - the supertype of A is a subtype of B
		return (EcoreUtil.equals(this, type) || (getSupertype() != null
				&& (EcoreUtil.equals(getSupertype(), type) || getSupertype().isSubtypeOf(type))));
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
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedAttributes()).basicAdd(otherEnd, msgs);
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedReferences()).basicAdd(otherEnd, msgs);
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
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return ((InternalEList<?>) getOwnedAttributes()).basicRemove(otherEnd, msgs);
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return ((InternalEList<?>) getOwnedReferences()).basicRemove(otherEnd, msgs);
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
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			if (resolve)
				return getSupertype();
			return basicGetSupertype();
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			return getAssociatedTypes();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return getOwnedAttributes();
		case EnvironmentPackage.STRUCTURED_TYPE__ATTRIBUTES:
			return getAttributes();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return getOwnedReferences();
		case EnvironmentPackage.STRUCTURED_TYPE__REFERENCES:
			return getReferences();
		case EnvironmentPackage.STRUCTURED_TYPE__PROPERTIES:
			return getProperties();
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
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			setSupertype((StructuredType) newValue);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			getAssociatedTypes().clear();
			getAssociatedTypes().addAll((Collection<? extends StructuredType>) newValue);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			getOwnedAttributes().clear();
			getOwnedAttributes().addAll((Collection<? extends Attribute>) newValue);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			getOwnedReferences().clear();
			getOwnedReferences().addAll((Collection<? extends Reference>) newValue);
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
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			setSupertype((StructuredType) null);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			getAssociatedTypes().clear();
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			getOwnedAttributes().clear();
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			getOwnedReferences().clear();
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
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			return basicGetSupertype() != null;
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			return !getAssociatedTypes().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return !getOwnedAttributes().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__ATTRIBUTES:
			return !getAttributes().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return !getOwnedReferences().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__REFERENCES:
			return !getReferences().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__PROPERTIES:
			return !getProperties().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StructuredTypeImpl