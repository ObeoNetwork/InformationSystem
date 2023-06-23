/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.toolkits.impl;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.cinematic.toolkits.MetaDataDefinition;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;

import org.obeonetwork.dsl.environment.impl.AnnotationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Data Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.impl.MetaDataDefinitionImpl#getHelp <em>Help</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaDataDefinitionImpl extends AnnotationImpl implements MetaDataDefinition {
	/**
	 * The default value of the '{@link #getHelp() <em>Help</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelp()
	 * @generated
	 * @ordered
	 */
	protected static final String HELP_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaDataDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolkitsPackage.Literals.META_DATA_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHelp() {
		return (String)eDynamicGet(ToolkitsPackage.META_DATA_DEFINITION__HELP, ToolkitsPackage.Literals.META_DATA_DEFINITION__HELP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelp(String newHelp) {
		eDynamicSet(ToolkitsPackage.META_DATA_DEFINITION__HELP, ToolkitsPackage.Literals.META_DATA_DEFINITION__HELP, newHelp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToolkitsPackage.META_DATA_DEFINITION__HELP:
				return getHelp();
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
			case ToolkitsPackage.META_DATA_DEFINITION__HELP:
				setHelp((String)newValue);
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
			case ToolkitsPackage.META_DATA_DEFINITION__HELP:
				setHelp(HELP_EDEFAULT);
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
			case ToolkitsPackage.META_DATA_DEFINITION__HELP:
				return HELP_EDEFAULT == null ? getHelp() != null : !HELP_EDEFAULT.equals(getHelp());
		}
		return super.eIsSet(featureID);
	}

} //MetaDataDefinitionImpl
