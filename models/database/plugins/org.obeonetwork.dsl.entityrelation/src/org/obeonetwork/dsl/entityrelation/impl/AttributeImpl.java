/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.EntityRelationFactory;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.Identifier;
import org.obeonetwork.dsl.typeslibrary.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.AttributeImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.AttributeImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.AttributeImpl#getUsedInIdentifier <em>Used In Identifier</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.AttributeImpl#isInPrimaryIdentifier <em>In Primary Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends NamedElementImpl implements Attribute {
	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isInPrimaryIdentifier() <em>In Primary Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInPrimaryIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_PRIMARY_IDENTIFIER_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityRelationPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getOwner() {
		return (Entity)eDynamicGet(EntityRelationPackage.ATTRIBUTE__OWNER, EntityRelationPackage.Literals.ATTRIBUTE__OWNER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Entity newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, EntityRelationPackage.ATTRIBUTE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Entity newOwner) {
		eDynamicSet(EntityRelationPackage.ATTRIBUTE__OWNER, EntityRelationPackage.Literals.ATTRIBUTE__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eDynamicGet(EntityRelationPackage.ATTRIBUTE__TYPE, EntityRelationPackage.Literals.ATTRIBUTE__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newType, EntityRelationPackage.ATTRIBUTE__TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eDynamicSet(EntityRelationPackage.ATTRIBUTE__TYPE, EntityRelationPackage.Literals.ATTRIBUTE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return (Boolean)eDynamicGet(EntityRelationPackage.ATTRIBUTE__REQUIRED, EntityRelationPackage.Literals.ATTRIBUTE__REQUIRED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		eDynamicSet(EntityRelationPackage.ATTRIBUTE__REQUIRED, EntityRelationPackage.Literals.ATTRIBUTE__REQUIRED, newRequired);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getUsedInIdentifier() {
		return (Identifier)eDynamicGet(EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER, EntityRelationPackage.Literals.ATTRIBUTE__USED_IN_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetUsedInIdentifier() {
		return (Identifier)eDynamicGet(EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER, EntityRelationPackage.Literals.ATTRIBUTE__USED_IN_IDENTIFIER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsedInIdentifier(Identifier newUsedInIdentifier, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newUsedInIdentifier, EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedInIdentifier(Identifier newUsedInIdentifier) {
		eDynamicSet(EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER, EntityRelationPackage.Literals.ATTRIBUTE__USED_IN_IDENTIFIER, newUsedInIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isInPrimaryIdentifier() {
		if (getOwner() != null) {
			Identifier primaryIdentifier = getOwner().getPrimaryIdentifier();
			if (primaryIdentifier != null) {
				return primaryIdentifier.getAttributes().contains(this);
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addToPrimaryIdentifier() {
		// Do nothing if the attribute is already in the primary identifier or if it does not belong to a table
		if (isInPrimaryIdentifier() == false
				&& getOwner() != null) {
			Entity entity = getOwner();
			// First, ensure there is a primary identifier defined on this entity
			Identifier primaryIdentifier = entity.getPrimaryIdentifier();
			if (primaryIdentifier == null) {
				// Create a primary identifier
				primaryIdentifier = EntityRelationFactory.eINSTANCE.createIdentifier();
				primaryIdentifier.setName(entity.getName() + "_ID");
				entity.getIdentifiers().add(primaryIdentifier);
				entity.setPrimaryIdentifier(primaryIdentifier);
			}
			
			// Then attach the attribute to the primary identifier
			primaryIdentifier.getAttributes().add(this);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeFromPrimaryIdentifier() {
		if (isInPrimaryIdentifier() == true) {
			getOwner().getPrimaryIdentifier().getAttributes().remove(this);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityRelationPackage.ATTRIBUTE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Entity)otherEnd, msgs);
			case EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER:
				Identifier usedInIdentifier = basicGetUsedInIdentifier();
				if (usedInIdentifier != null)
					msgs = ((InternalEObject)usedInIdentifier).eInverseRemove(this, EntityRelationPackage.IDENTIFIER__ATTRIBUTES, Identifier.class, msgs);
				return basicSetUsedInIdentifier((Identifier)otherEnd, msgs);
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
			case EntityRelationPackage.ATTRIBUTE__OWNER:
				return basicSetOwner(null, msgs);
			case EntityRelationPackage.ATTRIBUTE__TYPE:
				return basicSetType(null, msgs);
			case EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER:
				return basicSetUsedInIdentifier(null, msgs);
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
			case EntityRelationPackage.ATTRIBUTE__OWNER:
				return eInternalContainer().eInverseRemove(this, EntityRelationPackage.ENTITY__ATTRIBUTES, Entity.class, msgs);
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
			case EntityRelationPackage.ATTRIBUTE__OWNER:
				return getOwner();
			case EntityRelationPackage.ATTRIBUTE__TYPE:
				return getType();
			case EntityRelationPackage.ATTRIBUTE__REQUIRED:
				return isRequired();
			case EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER:
				if (resolve) return getUsedInIdentifier();
				return basicGetUsedInIdentifier();
			case EntityRelationPackage.ATTRIBUTE__IN_PRIMARY_IDENTIFIER:
				return isInPrimaryIdentifier();
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
			case EntityRelationPackage.ATTRIBUTE__OWNER:
				setOwner((Entity)newValue);
				return;
			case EntityRelationPackage.ATTRIBUTE__TYPE:
				setType((Type)newValue);
				return;
			case EntityRelationPackage.ATTRIBUTE__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER:
				setUsedInIdentifier((Identifier)newValue);
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
			case EntityRelationPackage.ATTRIBUTE__OWNER:
				setOwner((Entity)null);
				return;
			case EntityRelationPackage.ATTRIBUTE__TYPE:
				setType((Type)null);
				return;
			case EntityRelationPackage.ATTRIBUTE__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER:
				setUsedInIdentifier((Identifier)null);
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
			case EntityRelationPackage.ATTRIBUTE__OWNER:
				return getOwner() != null;
			case EntityRelationPackage.ATTRIBUTE__TYPE:
				return getType() != null;
			case EntityRelationPackage.ATTRIBUTE__REQUIRED:
				return isRequired() != REQUIRED_EDEFAULT;
			case EntityRelationPackage.ATTRIBUTE__USED_IN_IDENTIFIER:
				return basicGetUsedInIdentifier() != null;
			case EntityRelationPackage.ATTRIBUTE__IN_PRIMARY_IDENTIFIER:
				return isInPrimaryIdentifier() != IN_PRIMARY_IDENTIFIER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //AttributeImpl
