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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.entity.Criterion;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.ExternalCriterion;
import org.obeonetwork.dsl.entity.Finder;
import org.obeonetwork.dsl.entity.InternalCriterion;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Finder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.FinderImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.FinderImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.FinderImpl#getCustomizedName <em>Customized Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.FinderImpl#getCriterions <em>Criterions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.FinderImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FinderImpl extends ObeoDSMObjectImpl implements Finder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * The default value of the '{@link #getCustomizedName() <em>Customized Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomizedName()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMIZED_NAME_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final MultiplicityKind MULTIPLICITY_EDEFAULT = MultiplicityKind.ZERO_ONE_LITERAL;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FinderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.FINDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getName() {
		String result = "";
		String customizedName = getCustomizedName();
		if ((customizedName != null) && (!customizedName.equals(""))) {
			result = customizedName;
		} else {
			result = "finder : ";
			EList listCriterions = getCriterions();
			if (listCriterions != null) {
				for (Iterator iter = listCriterions.iterator(); iter.hasNext();) {
					Criterion criterion = (Criterion) iter.next();
					if (criterion instanceof InternalCriterion) {
						InternalCriterion internalCriterion = (InternalCriterion) criterion;
						result += internalCriterion.getName();

					} else if (criterion instanceof ExternalCriterion) {
						ExternalCriterion externalCriterion = (ExternalCriterion) criterion;
						result += externalCriterion.getName();
					} else
						result += criterion.toString();
					if (iter.hasNext())
						result += ", ";
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getEntity() {
		return (Entity)eDynamicGet(EntityPackage.FINDER__ENTITY, EntityPackage.Literals.FINDER__ENTITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetEntity() {
		return (Entity)eDynamicGet(EntityPackage.FINDER__ENTITY, EntityPackage.Literals.FINDER__ENTITY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntity(Entity newEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEntity, EntityPackage.FINDER__ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntity(Entity newEntity) {
		eDynamicSet(EntityPackage.FINDER__ENTITY, EntityPackage.Literals.FINDER__ENTITY, newEntity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomizedName() {
		return (String)eDynamicGet(EntityPackage.FINDER__CUSTOMIZED_NAME, EntityPackage.Literals.FINDER__CUSTOMIZED_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomizedName(String newCustomizedName) {
		eDynamicSet(EntityPackage.FINDER__CUSTOMIZED_NAME, EntityPackage.Literals.FINDER__CUSTOMIZED_NAME, newCustomizedName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Criterion> getCriterions() {
		return (EList<Criterion>)eDynamicGet(EntityPackage.FINDER__CRITERIONS, EntityPackage.Literals.FINDER__CRITERIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityKind getMultiplicity() {
		return (MultiplicityKind)eDynamicGet(EntityPackage.FINDER__MULTIPLICITY, EntityPackage.Literals.FINDER__MULTIPLICITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(MultiplicityKind newMultiplicity) {
		eDynamicSet(EntityPackage.FINDER__MULTIPLICITY, EntityPackage.Literals.FINDER__MULTIPLICITY, newMultiplicity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityPackage.FINDER__ENTITY:
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
			case EntityPackage.FINDER__ENTITY:
				return basicSetEntity(null, msgs);
			case EntityPackage.FINDER__CRITERIONS:
				return ((InternalEList<?>)getCriterions()).basicRemove(otherEnd, msgs);
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
			case EntityPackage.FINDER__ENTITY:
				return eInternalContainer().eInverseRemove(this, EntityPackage.ENTITY__OWNED_FINDERS, Entity.class, msgs);
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
			case EntityPackage.FINDER__NAME:
				return getName();
			case EntityPackage.FINDER__ENTITY:
				if (resolve) return getEntity();
				return basicGetEntity();
			case EntityPackage.FINDER__CUSTOMIZED_NAME:
				return getCustomizedName();
			case EntityPackage.FINDER__CRITERIONS:
				return getCriterions();
			case EntityPackage.FINDER__MULTIPLICITY:
				return getMultiplicity();
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
			case EntityPackage.FINDER__ENTITY:
				setEntity((Entity)newValue);
				return;
			case EntityPackage.FINDER__CUSTOMIZED_NAME:
				setCustomizedName((String)newValue);
				return;
			case EntityPackage.FINDER__CRITERIONS:
				getCriterions().clear();
				getCriterions().addAll((Collection<? extends Criterion>)newValue);
				return;
			case EntityPackage.FINDER__MULTIPLICITY:
				setMultiplicity((MultiplicityKind)newValue);
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
			case EntityPackage.FINDER__ENTITY:
				setEntity((Entity)null);
				return;
			case EntityPackage.FINDER__CUSTOMIZED_NAME:
				setCustomizedName(CUSTOMIZED_NAME_EDEFAULT);
				return;
			case EntityPackage.FINDER__CRITERIONS:
				getCriterions().clear();
				return;
			case EntityPackage.FINDER__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
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
			case EntityPackage.FINDER__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case EntityPackage.FINDER__ENTITY:
				return basicGetEntity() != null;
			case EntityPackage.FINDER__CUSTOMIZED_NAME:
				return CUSTOMIZED_NAME_EDEFAULT == null ? getCustomizedName() != null : !CUSTOMIZED_NAME_EDEFAULT.equals(getCustomizedName());
			case EntityPackage.FINDER__CRITERIONS:
				return !getCriterions().isEmpty();
			case EntityPackage.FINDER__MULTIPLICITY:
				return getMultiplicity() != MULTIPLICITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // FinderImpl
