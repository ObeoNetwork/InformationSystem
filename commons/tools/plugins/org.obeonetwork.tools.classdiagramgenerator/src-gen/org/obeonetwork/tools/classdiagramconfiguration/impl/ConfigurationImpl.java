/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage;
import org.obeonetwork.tools.classdiagramconfiguration.ColorInfo;
import org.obeonetwork.tools.classdiagramconfiguration.Configuration;
import org.obeonetwork.tools.classdiagramconfiguration.DiagramConf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getViewpoint <em>Viewpoint</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getColors <em>Colors</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getJavaExtensions <em>Java Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getViewpoint() <em>Viewpoint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpoint()
	 * @generated
	 * @ordered
	 */
	protected Viewpoint viewpoint;

	/**
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramConf> diagrams;

	/**
	 * The cached value of the '{@link #getColors() <em>Colors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColors()
	 * @generated
	 * @ordered
	 */
	protected EList<ColorInfo> colors;

	/**
	 * The cached value of the '{@link #getJavaExtensions() <em>Java Extensions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> javaExtensions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramConfigurationPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramConfigurationPackage.CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Viewpoint getViewpoint() {
		if (viewpoint != null && viewpoint.eIsProxy()) {
			InternalEObject oldViewpoint = (InternalEObject)viewpoint;
			viewpoint = (Viewpoint)eResolveProxy(oldViewpoint);
			if (viewpoint != oldViewpoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT, oldViewpoint, viewpoint));
			}
		}
		return viewpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Viewpoint basicGetViewpoint() {
		return viewpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewpoint(Viewpoint newViewpoint) {
		Viewpoint oldViewpoint = viewpoint;
		viewpoint = newViewpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT, oldViewpoint, viewpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DiagramConf> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList<DiagramConf>(DiagramConf.class, this, ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ColorInfo> getColors() {
		if (colors == null) {
			colors = new EObjectContainmentEList<ColorInfo>(ColorInfo.class, this, ClassDiagramConfigurationPackage.CONFIGURATION__COLORS);
		}
		return colors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getJavaExtensions() {
		if (javaExtensions == null) {
			javaExtensions = new EDataTypeUniqueEList<String>(String.class, this, ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS);
		}
		return javaExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				return ((InternalEList<?>)getColors()).basicRemove(otherEnd, msgs);
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				return getName();
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				return getDescription();
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				if (resolve) return getViewpoint();
				return basicGetViewpoint();
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				return getDiagrams();
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				return getColors();
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				return getJavaExtensions();
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				setViewpoint((Viewpoint)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramConf>)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				getColors().clear();
				getColors().addAll((Collection<? extends ColorInfo>)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				getJavaExtensions().clear();
				getJavaExtensions().addAll((Collection<? extends String>)newValue);
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				setViewpoint((Viewpoint)null);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				getDiagrams().clear();
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				getColors().clear();
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				getJavaExtensions().clear();
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				return viewpoint != null;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				return colors != null && !colors.isEmpty();
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				return javaExtensions != null && !javaExtensions.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", javaExtensions: ");
		result.append(javaExtensions);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
