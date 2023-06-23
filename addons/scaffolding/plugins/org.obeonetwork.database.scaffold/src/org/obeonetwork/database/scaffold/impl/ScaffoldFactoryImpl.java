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
package org.obeonetwork.database.scaffold.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.obeonetwork.database.scaffold.ScaffoldFactory;
import org.obeonetwork.database.scaffold.ScaffoldInfo;
import org.obeonetwork.database.scaffold.ScaffoldPackage;
import org.obeonetwork.database.scaffold.ScaffoldType;
import org.obeonetwork.database.scaffold.TraceabilityInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScaffoldFactoryImpl extends EFactoryImpl implements ScaffoldFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaffoldFactory init() {
		try {
			ScaffoldFactory theScaffoldFactory = (ScaffoldFactory)EPackage.Registry.INSTANCE.getEFactory("http://mindef.gouv.fr/dsl/scaffold/1.0.0"); 
			if (theScaffoldFactory != null) {
				return theScaffoldFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScaffoldFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaffoldFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ScaffoldPackage.SCAFFOLD_INFO: return (EObject)createScaffoldInfo();
			case ScaffoldPackage.TRACEABILITY_INFO: return (EObject)createTraceabilityInfo();
			case ScaffoldPackage.EOBJECT_TO_EOBJECT_MAP: return (EObject)createEObjectToEObjectMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ScaffoldPackage.SCAFFOLD_TYPE:
				return createScaffoldTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ScaffoldPackage.SCAFFOLD_TYPE:
				return convertScaffoldTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaffoldInfo createScaffoldInfo() {
		ScaffoldInfoImpl scaffoldInfo = new ScaffoldInfoImpl();
		return scaffoldInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityInfo createTraceabilityInfo() {
		TraceabilityInfoImpl traceabilityInfo = new TraceabilityInfoImpl();
		return traceabilityInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EObject, EObject> createEObjectToEObjectMap() {
		EObjectToEObjectMapImpl eObjectToEObjectMap = new EObjectToEObjectMapImpl();
		return eObjectToEObjectMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaffoldType createScaffoldTypeFromString(EDataType eDataType, String initialValue) {
		ScaffoldType result = ScaffoldType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScaffoldTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaffoldPackage getScaffoldPackage() {
		return (ScaffoldPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ScaffoldPackage getPackage() {
		return ScaffoldPackage.eINSTANCE;
	}

} //ScaffoldFactoryImpl
