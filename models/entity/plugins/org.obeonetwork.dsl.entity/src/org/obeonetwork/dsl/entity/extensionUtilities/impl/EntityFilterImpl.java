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
package org.obeonetwork.dsl.entity.extensionUtilities.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.obeonetwork.dsl.entity.Attribute;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.Property;
import org.obeonetwork.dsl.entity.Reference;
import org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter;
import org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage;
import org.obeonetwork.dsl.environment.impl.FilterImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Entity Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl#getAttributeReferences <em>Attribute References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl#getReferenceReferences <em>Reference References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl#getOwnedPropertyReferences <em>Owned Property References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.extensionUtilities.impl.EntityFilterImpl#getEntity <em>Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityFilterImpl extends FilterImpl implements EntityFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensionUtilitiesPackage.Literals.ENTITY_FILTER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList getAttributeReferences() {
		BasicEList result = new UniqueEList() {
			protected Object[] newData(int capacity) {
				return new Attribute[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		Collection properties = getOwnedPropertyReferences();
		for (Iterator iter = properties.iterator(); iter.hasNext();) {
			Property property = (Property) iter.next();
			if (property instanceof Attribute) {
				result.add(property);
			}
		}
		result.shrink();
		EList unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare(
				this, ExtensionUtilitiesPackage.eINSTANCE
						.getEntityFilter_AttributeReferences(), result.size(),
				result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList getReferenceReferences() {
		BasicEList result = new UniqueEList() {
			protected Object[] newData(int capacity) {
				return new Reference[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		Collection properties = getOwnedPropertyReferences();
		for (Iterator iter = properties.iterator(); iter.hasNext();) {
			Property property = (Property) iter.next();
			if (property instanceof Reference) {
				result.add(property);
			}
		}
		result.shrink();
		EList unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare(
				this, ExtensionUtilitiesPackage.eINSTANCE
						.getEntityFilter_ReferenceReferences(), result.size(),
				result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Property> getOwnedPropertyReferences() {
		return (EList<Property>)eDynamicGet(ExtensionUtilitiesPackage.ENTITY_FILTER__OWNED_PROPERTY_REFERENCES, ExtensionUtilitiesPackage.Literals.ENTITY_FILTER__OWNED_PROPERTY_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getEntity() {
		return (Entity)eDynamicGet(ExtensionUtilitiesPackage.ENTITY_FILTER__ENTITY, ExtensionUtilitiesPackage.Literals.ENTITY_FILTER__ENTITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetEntity() {
		return (Entity)eDynamicGet(ExtensionUtilitiesPackage.ENTITY_FILTER__ENTITY, ExtensionUtilitiesPackage.Literals.ENTITY_FILTER__ENTITY, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntity(Entity newEntity) {
		eDynamicSet(ExtensionUtilitiesPackage.ENTITY_FILTER__ENTITY, ExtensionUtilitiesPackage.Literals.ENTITY_FILTER__ENTITY, newEntity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtensionUtilitiesPackage.ENTITY_FILTER__ATTRIBUTE_REFERENCES:
				return getAttributeReferences();
			case ExtensionUtilitiesPackage.ENTITY_FILTER__REFERENCE_REFERENCES:
				return getReferenceReferences();
			case ExtensionUtilitiesPackage.ENTITY_FILTER__OWNED_PROPERTY_REFERENCES:
				return getOwnedPropertyReferences();
			case ExtensionUtilitiesPackage.ENTITY_FILTER__ENTITY:
				if (resolve) return getEntity();
				return basicGetEntity();
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
			case ExtensionUtilitiesPackage.ENTITY_FILTER__OWNED_PROPERTY_REFERENCES:
				getOwnedPropertyReferences().clear();
				getOwnedPropertyReferences().addAll((Collection<? extends Property>)newValue);
				return;
			case ExtensionUtilitiesPackage.ENTITY_FILTER__ENTITY:
				setEntity((Entity)newValue);
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
			case ExtensionUtilitiesPackage.ENTITY_FILTER__OWNED_PROPERTY_REFERENCES:
				getOwnedPropertyReferences().clear();
				return;
			case ExtensionUtilitiesPackage.ENTITY_FILTER__ENTITY:
				setEntity((Entity)null);
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
			case ExtensionUtilitiesPackage.ENTITY_FILTER__ATTRIBUTE_REFERENCES:
				return !getAttributeReferences().isEmpty();
			case ExtensionUtilitiesPackage.ENTITY_FILTER__REFERENCE_REFERENCES:
				return !getReferenceReferences().isEmpty();
			case ExtensionUtilitiesPackage.ENTITY_FILTER__OWNED_PROPERTY_REFERENCES:
				return !getOwnedPropertyReferences().isEmpty();
			case ExtensionUtilitiesPackage.ENTITY_FILTER__ENTITY:
				return basicGetEntity() != null;
		}
		return super.eIsSet(featureID);
	}

} // EntityFilterImpl
