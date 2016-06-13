/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.Identifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.EntityImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.EntityImpl#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.EntityImpl#getPrimaryIdentifier <em>Primary Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityImpl extends NamedElementImpl implements Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityRelationPackage.Literals.ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Attribute> getAttributes() {
		return (EList<Attribute>)eDynamicGet(EntityRelationPackage.ENTITY__ATTRIBUTES, EntityRelationPackage.Literals.ENTITY__ATTRIBUTES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Identifier> getIdentifiers() {
		return (EList<Identifier>)eDynamicGet(EntityRelationPackage.ENTITY__IDENTIFIERS, EntityRelationPackage.Literals.ENTITY__IDENTIFIERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getPrimaryIdentifier() {
		return (Identifier)eDynamicGet(EntityRelationPackage.ENTITY__PRIMARY_IDENTIFIER, EntityRelationPackage.Literals.ENTITY__PRIMARY_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetPrimaryIdentifier() {
		return (Identifier)eDynamicGet(EntityRelationPackage.ENTITY__PRIMARY_IDENTIFIER, EntityRelationPackage.Literals.ENTITY__PRIMARY_IDENTIFIER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryIdentifier(Identifier newPrimaryIdentifier) {
		eDynamicSet(EntityRelationPackage.ENTITY__PRIMARY_IDENTIFIER, EntityRelationPackage.Literals.ENTITY__PRIMARY_IDENTIFIER, newPrimaryIdentifier);
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
			case EntityRelationPackage.ENTITY__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
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
			case EntityRelationPackage.ENTITY__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case EntityRelationPackage.ENTITY__IDENTIFIERS:
				return ((InternalEList<?>)getIdentifiers()).basicRemove(otherEnd, msgs);
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
			case EntityRelationPackage.ENTITY__ATTRIBUTES:
				return getAttributes();
			case EntityRelationPackage.ENTITY__IDENTIFIERS:
				return getIdentifiers();
			case EntityRelationPackage.ENTITY__PRIMARY_IDENTIFIER:
				if (resolve) return getPrimaryIdentifier();
				return basicGetPrimaryIdentifier();
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
			case EntityRelationPackage.ENTITY__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case EntityRelationPackage.ENTITY__IDENTIFIERS:
				getIdentifiers().clear();
				getIdentifiers().addAll((Collection<? extends Identifier>)newValue);
				return;
			case EntityRelationPackage.ENTITY__PRIMARY_IDENTIFIER:
				setPrimaryIdentifier((Identifier)newValue);
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
			case EntityRelationPackage.ENTITY__ATTRIBUTES:
				getAttributes().clear();
				return;
			case EntityRelationPackage.ENTITY__IDENTIFIERS:
				getIdentifiers().clear();
				return;
			case EntityRelationPackage.ENTITY__PRIMARY_IDENTIFIER:
				setPrimaryIdentifier((Identifier)null);
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
			case EntityRelationPackage.ENTITY__ATTRIBUTES:
				return !getAttributes().isEmpty();
			case EntityRelationPackage.ENTITY__IDENTIFIERS:
				return !getIdentifiers().isEmpty();
			case EntityRelationPackage.ENTITY__PRIMARY_IDENTIFIER:
				return basicGetPrimaryIdentifier() != null;
		}
		return super.eIsSet(featureID);
	}

} //EntityImpl
