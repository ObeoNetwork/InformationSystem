/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.ImplementationComponent;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl#getImplement <em>Implement</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationComponentImpl extends ObeoDSMObjectImpl implements ImplementationComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getImplement() <em>Implement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplement()
	 * @generated
	 * @ordered
	 */
	protected Interface implement;
	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected TypesDefinition entities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.IMPLEMENTATION_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getImplement() {
		if (implement != null && implement.eIsProxy()) {
			InternalEObject oldImplement = (InternalEObject)implement;
			implement = (Interface)eResolveProxy(oldImplement);
			if (implement != oldImplement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT, oldImplement, implement));
			}
		}
		return implement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetImplement() {
		return implement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplement(Interface newImplement) {
		Interface oldImplement = implement;
		implement = newImplement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT, oldImplement, implement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesDefinition getEntities() {
		if (entities != null && entities.eIsProxy()) {
			InternalEObject oldEntities = (InternalEObject)entities;
			entities = (TypesDefinition)eResolveProxy(oldEntities);
			if (entities != oldEntities) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES, oldEntities, entities));
			}
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesDefinition basicGetEntities() {
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntities(TypesDefinition newEntities) {
		TypesDefinition oldEntities = entities;
		entities = newEntities;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES, oldEntities, entities));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				if (resolve) return getImplement();
				return basicGetImplement();
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				if (resolve) return getEntities();
				return basicGetEntities();
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
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				setImplement((Interface)newValue);
				return;
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				setEntities((TypesDefinition)newValue);
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
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				setImplement((Interface)null);
				return;
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				setEntities((TypesDefinition)null);
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
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				return implement != null;
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				return entities != null;
		}
		return super.eIsSet(featureID);
	}

} //ImplementationComponentImpl