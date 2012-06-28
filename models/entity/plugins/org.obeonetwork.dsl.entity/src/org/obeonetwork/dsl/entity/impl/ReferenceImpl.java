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
package org.obeonetwork.dsl.entity.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Reference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.ReferenceImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.ReferenceImpl#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.ReferenceImpl#getOppositeOf <em>Opposite Of</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.ReferenceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.ReferenceImpl#isNavigable <em>Navigable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends PropertyImpl implements Reference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getEntity() {
		return (Entity)eDynamicGet(EntityPackage.REFERENCE__ENTITY, EntityPackage.Literals.REFERENCE__ENTITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetEntity() {
		return (Entity)eDynamicGet(EntityPackage.REFERENCE__ENTITY, EntityPackage.Literals.REFERENCE__ENTITY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntity(Entity newEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEntity, EntityPackage.REFERENCE__ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntity(Entity newEntity) {
		eDynamicSet(EntityPackage.REFERENCE__ENTITY, EntityPackage.Literals.REFERENCE__ENTITY, newEntity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsComposite() {
		return (Boolean)eDynamicGet(EntityPackage.REFERENCE__IS_COMPOSITE, EntityPackage.Literals.REFERENCE__IS_COMPOSITE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsComposite(boolean newIsComposite) {
		eDynamicSet(EntityPackage.REFERENCE__IS_COMPOSITE, EntityPackage.Literals.REFERENCE__IS_COMPOSITE, newIsComposite);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getOppositeOf() {
		return (Reference)eDynamicGet(EntityPackage.REFERENCE__OPPOSITE_OF, EntityPackage.Literals.REFERENCE__OPPOSITE_OF, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference basicGetOppositeOf() {
		return (Reference)eDynamicGet(EntityPackage.REFERENCE__OPPOSITE_OF, EntityPackage.Literals.REFERENCE__OPPOSITE_OF, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeOf(Reference newOppositeOf) {
		eDynamicSet(EntityPackage.REFERENCE__OPPOSITE_OF, EntityPackage.Literals.REFERENCE__OPPOSITE_OF, newOppositeOf);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getType() {
		return (Entity)eDynamicGet(EntityPackage.REFERENCE__TYPE, EntityPackage.Literals.REFERENCE__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetType() {
		return (Entity)eDynamicGet(EntityPackage.REFERENCE__TYPE, EntityPackage.Literals.REFERENCE__TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Entity newType) {
		eDynamicSet(EntityPackage.REFERENCE__TYPE, EntityPackage.Literals.REFERENCE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNavigable() {
		return (Boolean)eDynamicGet(EntityPackage.REFERENCE__NAVIGABLE, EntityPackage.Literals.REFERENCE__NAVIGABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNavigable(boolean newNavigable) {
		eDynamicSet(EntityPackage.REFERENCE__NAVIGABLE, EntityPackage.Literals.REFERENCE__NAVIGABLE, newNavigable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canBeOppositeOf(Reference opposite) {
		return (opposite != null
			&& getEntity() != null
			&& getType() != null
			&& opposite.getEntity() != null
			&& opposite.getType() != null
			&& getEntity().isSubtypeOf(opposite.getType())
			&& opposite.getEntity().isSubtypeOf(getType())
			);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityPackage.REFERENCE__ENTITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEntity((Entity)otherEnd, msgs);
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
			case EntityPackage.REFERENCE__ENTITY:
				return basicSetEntity(null, msgs);
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
			case EntityPackage.REFERENCE__ENTITY:
				return eInternalContainer().eInverseRemove(this, EntityPackage.ENTITY__OWNED_REFERENCES, Entity.class, msgs);
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
			case EntityPackage.REFERENCE__ENTITY:
				if (resolve) return getEntity();
				return basicGetEntity();
			case EntityPackage.REFERENCE__IS_COMPOSITE:
				return isIsComposite();
			case EntityPackage.REFERENCE__OPPOSITE_OF:
				if (resolve) return getOppositeOf();
				return basicGetOppositeOf();
			case EntityPackage.REFERENCE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case EntityPackage.REFERENCE__NAVIGABLE:
				return isNavigable();
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
			case EntityPackage.REFERENCE__ENTITY:
				setEntity((Entity)newValue);
				return;
			case EntityPackage.REFERENCE__IS_COMPOSITE:
				setIsComposite((Boolean)newValue);
				return;
			case EntityPackage.REFERENCE__OPPOSITE_OF:
				setOppositeOf((Reference)newValue);
				return;
			case EntityPackage.REFERENCE__TYPE:
				setType((Entity)newValue);
				return;
			case EntityPackage.REFERENCE__NAVIGABLE:
				setNavigable((Boolean)newValue);
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
			case EntityPackage.REFERENCE__ENTITY:
				setEntity((Entity)null);
				return;
			case EntityPackage.REFERENCE__IS_COMPOSITE:
				setIsComposite(IS_COMPOSITE_EDEFAULT);
				return;
			case EntityPackage.REFERENCE__OPPOSITE_OF:
				setOppositeOf((Reference)null);
				return;
			case EntityPackage.REFERENCE__TYPE:
				setType((Entity)null);
				return;
			case EntityPackage.REFERENCE__NAVIGABLE:
				setNavigable(NAVIGABLE_EDEFAULT);
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
			case EntityPackage.REFERENCE__ENTITY:
				return basicGetEntity() != null;
			case EntityPackage.REFERENCE__IS_COMPOSITE:
				return isIsComposite() != IS_COMPOSITE_EDEFAULT;
			case EntityPackage.REFERENCE__OPPOSITE_OF:
				return basicGetOppositeOf() != null;
			case EntityPackage.REFERENCE__TYPE:
				return basicGetType() != null;
			case EntityPackage.REFERENCE__NAVIGABLE:
				return isNavigable() != NAVIGABLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // ReferenceImpl
