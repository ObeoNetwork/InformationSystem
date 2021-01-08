/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.cdo.CDONotification;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.Behaviour;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.util.EnvironmentUtil;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Obeo DSM Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getMetadatas <em>Metadatas</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getBehaviours <em>Behaviours</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getBindingRegistries <em>Binding Registries</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getCreatedOn <em>Created On</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl#getModifiedOn <em>Modified On</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ObeoDSMObjectImpl extends IdentifiableImpl implements ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_EDEFAULT = 1;

	/**
	 * The default value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedOn()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_ON_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getModifiedOn() <em>Modified On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedOn()
	 * @generated
	 * @ordered
	 */
	protected static final Date MODIFIED_ON_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ObeoDSMObjectImpl() {
		super();
		eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				// We don't handle CDONotifications because it would mean setting an attribute outside a transaction
				// When 2 clients are on the same shared projects :
				// - the one who actually does the modification receives instances of EMF classic notifications
				// - the one who is just listening to changes receives instances of CDO notifications
				// With that test, it is the first client who sets the modifiedOn attribute
				if (msg instanceof CDONotification) {
					return;
				}
				if (msg.getNotifier() instanceof ObeoDSMObject) {
					ObeoDSMObject notifier = (ObeoDSMObject) msg.getNotifier();

					if (!EnvironmentUtil.isResourceLoading(notifier)) {
						Date currentDate = new Date();
						if (msg != null && msg.getFeature() != null
								&& !msg.getFeature().equals(EnvironmentPackage.Literals.OBEO_DSM_OBJECT__MODIFIED_ON)
								&& !msg.getFeature().equals(EnvironmentPackage.Literals.OBEO_DSM_OBJECT__CREATED_ON)) {
							switch (msg.getEventType()) {
							case Notification.MOVE:
							case Notification.SET:
							case Notification.UNSET:
							case Notification.ADD:
							case Notification.ADD_MANY:
							case Notification.REMOVE:
							case Notification.REMOVE_MANY:
								notifier.setModifiedOn(currentDate);
								if (notifier.getCreatedOn() == null) {
									notifier.setCreatedOn(currentDate);
								}
								break;
							}
						} /* Disabling this functionnality because it causes problems with CDO
							everytime an object is modifed all its containers are modified too
							and then CDO objects are locked
							
							else if (msg.getFeature().equals(EnvironmentPackage.Literals.OBEO_DSM_OBJECT__MODIFIED_ON)) {
							if (msg.isTouch() == false) {
								// When an object is modified, last modification date is set on its container too
								if (msg.getEventType() == Notification.SET) {
									if (notifier.eContainer() != null && notifier.eContainer() instanceof ObeoDSMObject) {
										((ObeoDSMObject) notifier.eContainer()).setModifiedOn(currentDate);
									}
								}
							}
							}*/
					}
				}
			}
		});
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
	public MetaDataContainer getMetadatas() {
		return (MetaDataContainer) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__METADATAS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataContainer basicGetMetadatas() {
		return (MetaDataContainer) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__METADATAS, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetadatas(MetaDataContainer newMetadatas, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newMetadatas, EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetadatas(MetaDataContainer newMetadatas) {
		eDynamicSet(EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__METADATAS, newMetadatas);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getKeywords() {
		return (EList<String>) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__KEYWORDS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Behaviour> getBehaviours() {
		return (EList<Behaviour>) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__BEHAVIOURS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BindingRegistry> getBindingRegistries() {
		return (EList<BindingRegistry>) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__BINDING_REGISTRIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVersion() {
		return (Integer) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__VERSION,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__VERSION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(int newVersion) {
		eDynamicSet(EnvironmentPackage.OBEO_DSM_OBJECT__VERSION, EnvironmentPackage.Literals.OBEO_DSM_OBJECT__VERSION,
				newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreatedOn() {
		return (Date) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__CREATED_ON, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedOn(Date newCreatedOn) {
		eDynamicSet(EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__CREATED_ON, newCreatedOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getModifiedOn() {
		return (Date) eDynamicGet(EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__MODIFIED_ON, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedOn(Date newModifiedOn) {
		eDynamicSet(EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON,
				EnvironmentPackage.Literals.OBEO_DSM_OBJECT__MODIFIED_ON, newModifiedOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS:
			return basicSetMetadatas(null, msgs);
		case EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS:
			return ((InternalEList<?>) getBehaviours()).basicRemove(otherEnd, msgs);
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
		case EnvironmentPackage.OBEO_DSM_OBJECT__VERSION:
			return getVersion();
		case EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON:
			return getCreatedOn();
		case EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON:
			return getModifiedOn();
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
			getBindingRegistries().addAll((Collection<? extends BindingRegistry>) newValue);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__VERSION:
			setVersion((Integer) newValue);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON:
			setCreatedOn((Date) newValue);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON:
			setModifiedOn((Date) newValue);
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
		case EnvironmentPackage.OBEO_DSM_OBJECT__VERSION:
			setVersion(VERSION_EDEFAULT);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON:
			setCreatedOn(CREATED_ON_EDEFAULT);
			return;
		case EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON:
			setModifiedOn(MODIFIED_ON_EDEFAULT);
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
		case EnvironmentPackage.OBEO_DSM_OBJECT__VERSION:
			return getVersion() != VERSION_EDEFAULT;
		case EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON:
			return CREATED_ON_EDEFAULT == null ? getCreatedOn() != null : !CREATED_ON_EDEFAULT.equals(getCreatedOn());
		case EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON:
			return MODIFIED_ON_EDEFAULT == null ? getModifiedOn() != null
					: !MODIFIED_ON_EDEFAULT.equals(getModifiedOn());
		}
		return super.eIsSet(featureID);
	}

} //ObeoDSMObjectImpl