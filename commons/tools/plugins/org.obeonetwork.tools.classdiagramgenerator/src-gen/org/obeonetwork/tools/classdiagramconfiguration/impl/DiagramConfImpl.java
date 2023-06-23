/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 */
package org.obeonetwork.tools.classdiagramconfiguration.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage;
import org.obeonetwork.tools.classdiagramconfiguration.DiagramConf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Conf</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl#getDescriptionId <em>Description Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl#getMetamodels <em>Metamodels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramConfImpl extends ConfigurationElementImpl implements DiagramConf {
	/**
	 * The default value of the '{@link #getDescriptionId() <em>Description Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionId()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionId() <em>Description Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionId()
	 * @generated
	 * @ordered
	 */
	protected String descriptionId = DESCRIPTION_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getMetamodels() <em>Metamodels</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodels()
	 * @generated
	 * @ordered
	 */
	protected EList<String> metamodels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramConfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramConfigurationPackage.Literals.DIAGRAM_CONF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionId() {
		return descriptionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionId(String newDescriptionId) {
		String oldDescriptionId = descriptionId;
		descriptionId = newDescriptionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID, oldDescriptionId, descriptionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getMetamodels() {
		if (metamodels == null) {
			metamodels = new EDataTypeUniqueEList<String>(String.class, this, ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS);
		}
		return metamodels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				return getDescriptionId();
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				return getMetamodels();
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
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				setDescriptionId((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				getMetamodels().clear();
				getMetamodels().addAll((Collection<? extends String>)newValue);
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
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				setDescriptionId(DESCRIPTION_ID_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				getMetamodels().clear();
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
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				return DESCRIPTION_ID_EDEFAULT == null ? descriptionId != null : !DESCRIPTION_ID_EDEFAULT.equals(descriptionId);
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				return metamodels != null && !metamodels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (descriptionId: ");
		result.append(descriptionId);
		result.append(", metamodels: ");
		result.append(metamodels);
		result.append(')');
		return result.toString();
	}

} //DiagramConfImpl
