/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.RelationElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationElementImpl#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationElementImpl#getTargetAttribute <em>Target Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationElementImpl extends LogicalElementImpl implements RelationElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityRelationPackage.Literals.RELATION_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getSourceAttribute() {
		return (Attribute)eDynamicGet(EntityRelationPackage.RELATION_ELEMENT__SOURCE_ATTRIBUTE, EntityRelationPackage.Literals.RELATION_ELEMENT__SOURCE_ATTRIBUTE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetSourceAttribute() {
		return (Attribute)eDynamicGet(EntityRelationPackage.RELATION_ELEMENT__SOURCE_ATTRIBUTE, EntityRelationPackage.Literals.RELATION_ELEMENT__SOURCE_ATTRIBUTE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceAttribute(Attribute newSourceAttribute) {
		eDynamicSet(EntityRelationPackage.RELATION_ELEMENT__SOURCE_ATTRIBUTE, EntityRelationPackage.Literals.RELATION_ELEMENT__SOURCE_ATTRIBUTE, newSourceAttribute);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getTargetAttribute() {
		return (Attribute)eDynamicGet(EntityRelationPackage.RELATION_ELEMENT__TARGET_ATTRIBUTE, EntityRelationPackage.Literals.RELATION_ELEMENT__TARGET_ATTRIBUTE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetTargetAttribute() {
		return (Attribute)eDynamicGet(EntityRelationPackage.RELATION_ELEMENT__TARGET_ATTRIBUTE, EntityRelationPackage.Literals.RELATION_ELEMENT__TARGET_ATTRIBUTE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAttribute(Attribute newTargetAttribute) {
		eDynamicSet(EntityRelationPackage.RELATION_ELEMENT__TARGET_ATTRIBUTE, EntityRelationPackage.Literals.RELATION_ELEMENT__TARGET_ATTRIBUTE, newTargetAttribute);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EntityRelationPackage.RELATION_ELEMENT__SOURCE_ATTRIBUTE:
				if (resolve) return getSourceAttribute();
				return basicGetSourceAttribute();
			case EntityRelationPackage.RELATION_ELEMENT__TARGET_ATTRIBUTE:
				if (resolve) return getTargetAttribute();
				return basicGetTargetAttribute();
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
			case EntityRelationPackage.RELATION_ELEMENT__SOURCE_ATTRIBUTE:
				setSourceAttribute((Attribute)newValue);
				return;
			case EntityRelationPackage.RELATION_ELEMENT__TARGET_ATTRIBUTE:
				setTargetAttribute((Attribute)newValue);
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
			case EntityRelationPackage.RELATION_ELEMENT__SOURCE_ATTRIBUTE:
				setSourceAttribute((Attribute)null);
				return;
			case EntityRelationPackage.RELATION_ELEMENT__TARGET_ATTRIBUTE:
				setTargetAttribute((Attribute)null);
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
			case EntityRelationPackage.RELATION_ELEMENT__SOURCE_ATTRIBUTE:
				return basicGetSourceAttribute() != null;
			case EntityRelationPackage.RELATION_ELEMENT__TARGET_ATTRIBUTE:
				return basicGetTargetAttribute() != null;
		}
		return super.eIsSet(featureID);
	}

} //RelationElementImpl
