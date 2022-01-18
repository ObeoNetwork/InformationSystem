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
package org.obeonetwork.dsl.entity.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Finder;
import org.obeonetwork.dsl.entity.InheritanceKind;
import org.obeonetwork.dsl.environment.impl.StructuredTypeImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getEstimatedVolumetry <em>Estimated Volumetry</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getEstimatedAccess <em>Estimated Access</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#isHistorized <em>Historized</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getOwnedFinders <em>Owned Finders</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getInheritanceKind <em>Inheritance Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityImpl extends StructuredTypeImpl implements Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getEstimatedVolumetry() <em>Estimated Volumetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimatedVolumetry()
	 * @generated
	 * @ordered
	 */
	protected static final int ESTIMATED_VOLUMETRY_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getEstimatedAccess() <em>Estimated Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimatedAccess()
	 * @generated
	 * @ordered
	 */
	protected static final int ESTIMATED_ACCESS_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #isHistorized() <em>Historized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistorized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HISTORIZED_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getInheritanceKind() <em>Inheritance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritanceKind()
	 * @generated
	 * @ordered
	 */
	protected static final InheritanceKind INHERITANCE_KIND_EDEFAULT = InheritanceKind.TABLE_PER_SUBCLASS_LITERAL;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.ENTITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getEstimatedVolumetry() {
		return (Integer)eDynamicGet(EntityPackage.ENTITY__ESTIMATED_VOLUMETRY, EntityPackage.Literals.ENTITY__ESTIMATED_VOLUMETRY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimatedVolumetry(int newEstimatedVolumetry) {
		eDynamicSet(EntityPackage.ENTITY__ESTIMATED_VOLUMETRY, EntityPackage.Literals.ENTITY__ESTIMATED_VOLUMETRY, newEstimatedVolumetry);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getEstimatedAccess() {
		return (Integer)eDynamicGet(EntityPackage.ENTITY__ESTIMATED_ACCESS, EntityPackage.Literals.ENTITY__ESTIMATED_ACCESS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimatedAccess(int newEstimatedAccess) {
		eDynamicSet(EntityPackage.ENTITY__ESTIMATED_ACCESS, EntityPackage.Literals.ENTITY__ESTIMATED_ACCESS, newEstimatedAccess);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHistorized() {
		return (Boolean)eDynamicGet(EntityPackage.ENTITY__HISTORIZED, EntityPackage.Literals.ENTITY__HISTORIZED, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistorized(boolean newHistorized) {
		eDynamicSet(EntityPackage.ENTITY__HISTORIZED, EntityPackage.Literals.ENTITY__HISTORIZED, newHistorized);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Finder> getOwnedFinders() {
		return (EList<Finder>)eDynamicGet(EntityPackage.ENTITY__OWNED_FINDERS, EntityPackage.Literals.ENTITY__OWNED_FINDERS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InheritanceKind getInheritanceKind() {
		return (InheritanceKind)eDynamicGet(EntityPackage.ENTITY__INHERITANCE_KIND, EntityPackage.Literals.ENTITY__INHERITANCE_KIND, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritanceKind(InheritanceKind newInheritanceKind) {
		eDynamicSet(EntityPackage.ENTITY__INHERITANCE_KIND, EntityPackage.Literals.ENTITY__INHERITANCE_KIND, newInheritanceKind);
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
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedFinders()).basicAdd(otherEnd, msgs);
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
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return ((InternalEList<?>)getOwnedFinders()).basicRemove(otherEnd, msgs);
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
			case EntityPackage.ENTITY__ESTIMATED_VOLUMETRY:
				return getEstimatedVolumetry();
			case EntityPackage.ENTITY__ESTIMATED_ACCESS:
				return getEstimatedAccess();
			case EntityPackage.ENTITY__HISTORIZED:
				return isHistorized();
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return getOwnedFinders();
			case EntityPackage.ENTITY__INHERITANCE_KIND:
				return getInheritanceKind();
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
			case EntityPackage.ENTITY__ESTIMATED_VOLUMETRY:
				setEstimatedVolumetry((Integer)newValue);
				return;
			case EntityPackage.ENTITY__ESTIMATED_ACCESS:
				setEstimatedAccess((Integer)newValue);
				return;
			case EntityPackage.ENTITY__HISTORIZED:
				setHistorized((Boolean)newValue);
				return;
			case EntityPackage.ENTITY__OWNED_FINDERS:
				getOwnedFinders().clear();
				getOwnedFinders().addAll((Collection<? extends Finder>)newValue);
				return;
			case EntityPackage.ENTITY__INHERITANCE_KIND:
				setInheritanceKind((InheritanceKind)newValue);
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
			case EntityPackage.ENTITY__ESTIMATED_VOLUMETRY:
				setEstimatedVolumetry(ESTIMATED_VOLUMETRY_EDEFAULT);
				return;
			case EntityPackage.ENTITY__ESTIMATED_ACCESS:
				setEstimatedAccess(ESTIMATED_ACCESS_EDEFAULT);
				return;
			case EntityPackage.ENTITY__HISTORIZED:
				setHistorized(HISTORIZED_EDEFAULT);
				return;
			case EntityPackage.ENTITY__OWNED_FINDERS:
				getOwnedFinders().clear();
				return;
			case EntityPackage.ENTITY__INHERITANCE_KIND:
				setInheritanceKind(INHERITANCE_KIND_EDEFAULT);
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
			case EntityPackage.ENTITY__ESTIMATED_VOLUMETRY:
				return getEstimatedVolumetry() != ESTIMATED_VOLUMETRY_EDEFAULT;
			case EntityPackage.ENTITY__ESTIMATED_ACCESS:
				return getEstimatedAccess() != ESTIMATED_ACCESS_EDEFAULT;
			case EntityPackage.ENTITY__HISTORIZED:
				return isHistorized() != HISTORIZED_EDEFAULT;
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return !getOwnedFinders().isEmpty();
			case EntityPackage.ENTITY__INHERITANCE_KIND:
				return getInheritanceKind() != INHERITANCE_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // EntityImpl
