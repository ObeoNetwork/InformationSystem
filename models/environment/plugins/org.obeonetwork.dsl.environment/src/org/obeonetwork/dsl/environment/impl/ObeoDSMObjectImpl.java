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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.Behaviour;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Obeo DSM Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getMetadatas <em>Metadatas</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getBehaviours <em>Behaviours</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getBindingRegistries <em>Binding Registries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ObeoDSMObjectImpl extends CDOObjectImpl implements
		ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObeoDSMObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.OBEO_DSM_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataContainer getMetadatas() {
		return (MetaDataContainer) eDynamicGet(
				EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__METADATAS, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataContainer basicGetMetadatas() {
		return (MetaDataContainer) eDynamicGet(
				EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__METADATAS, false,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetadatas(MetaDataContainer newMetadatas,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newMetadatas,
				EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetadatas(MetaDataContainer newMetadatas) {
		eDynamicSet(EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__METADATAS,
				newMetadatas);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eDynamicGet(
				EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__DESCRIPTION, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__DESCRIPTION,
				newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getKeywords() {
		return (EList<String>) eDynamicGet(
				EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__KEYWORDS, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Behaviour> getBehaviours() {
		return (EList<Behaviour>) eDynamicGet(
				EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__BEHAVIOURS, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BindingRegistry> getBindingRegistries() {
		return (EList<BindingRegistry>) eDynamicGet(
				EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__BINDING_REGISTRIES,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS:
			return basicSetMetadatas(null, msgs);
		case EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS:
			return ((InternalEList<?>) getBehaviours()).basicRemove(otherEnd,
					msgs);
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
		case EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS:
			if (resolve)
				return getMetadatas();
			return basicGetMetadatas();
		case EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION:
			return getDescription();
		case EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS:
			return getKeywords();
		case EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS:
			return getBehaviours();
		case EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES:
			return getBindingRegistries();
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
		case EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS:
			setMetadatas((MetaDataContainer) newValue);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS:
			getKeywords().clear();
			getKeywords().addAll((Collection<? extends String>) newValue);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS:
			getBehaviours().clear();
			getBehaviours().addAll((Collection<? extends Behaviour>) newValue);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES:
			getBindingRegistries().clear();
			getBindingRegistries().addAll(
					(Collection<? extends BindingRegistry>) newValue);
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
		case EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS:
			setMetadatas((MetaDataContainer) null);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS:
			getKeywords().clear();
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS:
			getBehaviours().clear();
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES:
			getBindingRegistries().clear();
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
		case EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS:
			return basicGetMetadatas() != null;
		case EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? getDescription() != null
					: !DESCRIPTION_EDEFAULT.equals(getDescription());
		case EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS:
			return !getKeywords().isEmpty();
		case EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS:
			return !getBehaviours().isEmpty();
		case EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES:
			return !getBindingRegistries().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObeoDSMObjectImpl