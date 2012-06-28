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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.entity.Attribute;
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Finder;
import org.obeonetwork.dsl.entity.InheritanceKind;
import org.obeonetwork.dsl.entity.Property;
import org.obeonetwork.dsl.entity.Reference;
import org.obeonetwork.dsl.environment.impl.StructuredTypeImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getEstimatedVolumetry <em>Estimated Volumetry</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getEstimatedAccess <em>Estimated Access</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#isHistorized <em>Historized</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getOwnedFinders <em>Owned Finders</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.EntityImpl#getInheritanceKind <em>Inheritance Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityImpl extends StructuredTypeImpl implements Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	@SuppressWarnings("unchecked")
	public EList<Attribute> getOwnedAttributes() {
		return (EList<Attribute>)eDynamicGet(EntityPackage.ENTITY__OWNED_ATTRIBUTES, EntityPackage.Literals.ENTITY__OWNED_ATTRIBUTES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Reference> getOwnedReferences() {
		return (EList<Reference>)eDynamicGet(EntityPackage.ENTITY__OWNED_REFERENCES, EntityPackage.Literals.ENTITY__OWNED_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getSupertype() {
		return (Entity)eDynamicGet(EntityPackage.ENTITY__SUPERTYPE, EntityPackage.Literals.ENTITY__SUPERTYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetSupertype() {
		return (Entity)eDynamicGet(EntityPackage.ENTITY__SUPERTYPE, EntityPackage.Literals.ENTITY__SUPERTYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupertype(Entity newSupertype) {
		eDynamicSet(EntityPackage.ENTITY__SUPERTYPE, EntityPackage.Literals.ENTITY__SUPERTYPE, newSupertype);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList getAttributes() {
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
				this, EntityPackage.eINSTANCE.getEntity_Attributes(), result
						.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList getReferences() {
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
				this, EntityPackage.eINSTANCE.getEntity_References(), result
						.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList getProperties() {
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
				this, EntityPackage.eINSTANCE.getEntity_Attributes(), result
						.size(), result.data());
		return unmodifiableResult;
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
	public Block getBlock() {
		return (Block)eDynamicGet(EntityPackage.ENTITY__BLOCK, EntityPackage.Literals.ENTITY__BLOCK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block basicGetBlock() {
		return (Block)eDynamicGet(EntityPackage.ENTITY__BLOCK, EntityPackage.Literals.ENTITY__BLOCK, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBlock, EntityPackage.ENTITY__BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlock(Block newBlock) {
		eDynamicSet(EntityPackage.ENTITY__BLOCK, EntityPackage.Literals.ENTITY__BLOCK, newBlock);
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
	 * @generated NOT
	 */
	public boolean isSubtypeOf(Entity entity) {
		// An entity A is a subtype of an entity B
		// - A and B are both the same entity
		// - the supertype of A is B
		// - the supertype of A is a subtype of B
		return (EcoreUtil.equals(this, entity)
				|| (getSupertype() != null
						&& (EcoreUtil.equals(getSupertype(), entity) || getSupertype().isSubtypeOf(entity))));
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
			case EntityPackage.ENTITY__OWNED_ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttributes()).basicAdd(otherEnd, msgs);
			case EntityPackage.ENTITY__OWNED_REFERENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedReferences()).basicAdd(otherEnd, msgs);
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedFinders()).basicAdd(otherEnd, msgs);
			case EntityPackage.ENTITY__BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBlock((Block)otherEnd, msgs);
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
			case EntityPackage.ENTITY__OWNED_ATTRIBUTES:
				return ((InternalEList<?>)getOwnedAttributes()).basicRemove(otherEnd, msgs);
			case EntityPackage.ENTITY__OWNED_REFERENCES:
				return ((InternalEList<?>)getOwnedReferences()).basicRemove(otherEnd, msgs);
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return ((InternalEList<?>)getOwnedFinders()).basicRemove(otherEnd, msgs);
			case EntityPackage.ENTITY__BLOCK:
				return basicSetBlock(null, msgs);
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
			case EntityPackage.ENTITY__BLOCK:
				return eInternalContainer().eInverseRemove(this, EntityPackage.BLOCK__ENTITIES, Block.class, msgs);
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
			case EntityPackage.ENTITY__OWNED_ATTRIBUTES:
				return getOwnedAttributes();
			case EntityPackage.ENTITY__OWNED_REFERENCES:
				return getOwnedReferences();
			case EntityPackage.ENTITY__SUPERTYPE:
				if (resolve) return getSupertype();
				return basicGetSupertype();
			case EntityPackage.ENTITY__ATTRIBUTES:
				return getAttributes();
			case EntityPackage.ENTITY__REFERENCES:
				return getReferences();
			case EntityPackage.ENTITY__PROPERTIES:
				return getProperties();
			case EntityPackage.ENTITY__ESTIMATED_VOLUMETRY:
				return getEstimatedVolumetry();
			case EntityPackage.ENTITY__ESTIMATED_ACCESS:
				return getEstimatedAccess();
			case EntityPackage.ENTITY__HISTORIZED:
				return isHistorized();
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return getOwnedFinders();
			case EntityPackage.ENTITY__BLOCK:
				if (resolve) return getBlock();
				return basicGetBlock();
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
			case EntityPackage.ENTITY__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case EntityPackage.ENTITY__OWNED_REFERENCES:
				getOwnedReferences().clear();
				getOwnedReferences().addAll((Collection<? extends Reference>)newValue);
				return;
			case EntityPackage.ENTITY__SUPERTYPE:
				setSupertype((Entity)newValue);
				return;
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
			case EntityPackage.ENTITY__BLOCK:
				setBlock((Block)newValue);
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
			case EntityPackage.ENTITY__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				return;
			case EntityPackage.ENTITY__OWNED_REFERENCES:
				getOwnedReferences().clear();
				return;
			case EntityPackage.ENTITY__SUPERTYPE:
				setSupertype((Entity)null);
				return;
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
			case EntityPackage.ENTITY__BLOCK:
				setBlock((Block)null);
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
			case EntityPackage.ENTITY__OWNED_ATTRIBUTES:
				return !getOwnedAttributes().isEmpty();
			case EntityPackage.ENTITY__OWNED_REFERENCES:
				return !getOwnedReferences().isEmpty();
			case EntityPackage.ENTITY__SUPERTYPE:
				return basicGetSupertype() != null;
			case EntityPackage.ENTITY__ATTRIBUTES:
				return !getAttributes().isEmpty();
			case EntityPackage.ENTITY__REFERENCES:
				return !getReferences().isEmpty();
			case EntityPackage.ENTITY__PROPERTIES:
				return !getProperties().isEmpty();
			case EntityPackage.ENTITY__ESTIMATED_VOLUMETRY:
				return getEstimatedVolumetry() != ESTIMATED_VOLUMETRY_EDEFAULT;
			case EntityPackage.ENTITY__ESTIMATED_ACCESS:
				return getEstimatedAccess() != ESTIMATED_ACCESS_EDEFAULT;
			case EntityPackage.ENTITY__HISTORIZED:
				return isHistorized() != HISTORIZED_EDEFAULT;
			case EntityPackage.ENTITY__OWNED_FINDERS:
				return !getOwnedFinders().isEmpty();
			case EntityPackage.ENTITY__BLOCK:
				return basicGetBlock() != null;
			case EntityPackage.ENTITY__INHERITANCE_KIND:
				return getInheritanceKind() != INHERITANCE_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // EntityImpl
