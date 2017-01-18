/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.database.scaffold;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldFactory
 * @model kind="package"
 * @generated
 */
public interface ScaffoldPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2012 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scaffold";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mindef.gouv.fr/dsl/scaffold/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scaffold";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScaffoldPackage eINSTANCE = fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl <em>Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl
	 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getScaffoldInfo()
	 * @generated
	 */
	int SCAFFOLD_INFO = 0;

	/**
	 * The feature id for the '<em><b>Left Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAFFOLD_INFO__LEFT_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Right Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAFFOLD_INFO__RIGHT_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Left To Right Additional Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAFFOLD_INFO__LEFT_TO_RIGHT_ADDITIONAL_OBJECTS = 2;

	/**
	 * The feature id for the '<em><b>Right To Left Additional Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAFFOLD_INFO__RIGHT_TO_LEFT_ADDITIONAL_OBJECTS = 3;

	/**
	 * The feature id for the '<em><b>Traceability Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAFFOLD_INFO__TRACEABILITY_INFOS = 4;

	/**
	 * The number of structural features of the '<em>Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAFFOLD_INFO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link fr.gouv.mindef.safran.database.scaffold.impl.TraceabilityInfoImpl <em>Traceability Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.gouv.mindef.safran.database.scaffold.impl.TraceabilityInfoImpl
	 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getTraceabilityInfo()
	 * @generated
	 */
	int TRACEABILITY_INFO = 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_INFO__LEFT = 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_INFO__RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Traceability Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link fr.gouv.mindef.safran.database.scaffold.impl.EObjectToEObjectMapImpl <em>EObject To EObject Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.gouv.mindef.safran.database.scaffold.impl.EObjectToEObjectMapImpl
	 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getEObjectToEObjectMap()
	 * @generated
	 */
	int EOBJECT_TO_EOBJECT_MAP = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_EOBJECT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_EOBJECT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EObject To EObject Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_EOBJECT_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldType <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldType
	 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getScaffoldType()
	 * @generated
	 */
	int SCAFFOLD_TYPE = 3;

	/**
	 * Returns the meta object for class '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo
	 * @generated
	 */
	EClass getScaffoldInfo();

	/**
	 * Returns the meta object for the reference '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getLeftObject <em>Left Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Object</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getLeftObject()
	 * @see #getScaffoldInfo()
	 * @generated
	 */
	EReference getScaffoldInfo_LeftObject();

	/**
	 * Returns the meta object for the reference '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getRightObject <em>Right Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Object</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getRightObject()
	 * @see #getScaffoldInfo()
	 * @generated
	 */
	EReference getScaffoldInfo_RightObject();

	/**
	 * Returns the meta object for the reference list '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getLeftToRightAdditionalObjects <em>Left To Right Additional Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Left To Right Additional Objects</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getLeftToRightAdditionalObjects()
	 * @see #getScaffoldInfo()
	 * @generated
	 */
	EReference getScaffoldInfo_LeftToRightAdditionalObjects();

	/**
	 * Returns the meta object for the reference list '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getRightToLeftAdditionalObjects <em>Right To Left Additional Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Right To Left Additional Objects</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getRightToLeftAdditionalObjects()
	 * @see #getScaffoldInfo()
	 * @generated
	 */
	EReference getScaffoldInfo_RightToLeftAdditionalObjects();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getTraceabilityInfos <em>Traceability Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traceability Infos</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo#getTraceabilityInfos()
	 * @see #getScaffoldInfo()
	 * @generated
	 */
	EReference getScaffoldInfo_TraceabilityInfos();

	/**
	 * Returns the meta object for class '{@link fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo <em>Traceability Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traceability Info</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo
	 * @generated
	 */
	EClass getTraceabilityInfo();

	/**
	 * Returns the meta object for the reference '{@link fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getLeft()
	 * @see #getTraceabilityInfo()
	 * @generated
	 */
	EReference getTraceabilityInfo_Left();

	/**
	 * Returns the meta object for the reference '{@link fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo#getRight()
	 * @see #getTraceabilityInfo()
	 * @generated
	 */
	EReference getTraceabilityInfo_Right();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EObject To EObject Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject To EObject Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.eclipse.emf.ecore.EObject"
	 *        valueType="org.eclipse.emf.ecore.EObject"
	 * @generated
	 */
	EClass getEObjectToEObjectMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToEObjectMap()
	 * @generated
	 */
	EReference getEObjectToEObjectMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToEObjectMap()
	 * @generated
	 */
	EReference getEObjectToEObjectMap_Value();

	/**
	 * Returns the meta object for enum '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldType
	 * @generated
	 */
	EEnum getScaffoldType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScaffoldFactory getScaffoldFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl <em>Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl
		 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getScaffoldInfo()
		 * @generated
		 */
		EClass SCAFFOLD_INFO = eINSTANCE.getScaffoldInfo();

		/**
		 * The meta object literal for the '<em><b>Left Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAFFOLD_INFO__LEFT_OBJECT = eINSTANCE.getScaffoldInfo_LeftObject();

		/**
		 * The meta object literal for the '<em><b>Right Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAFFOLD_INFO__RIGHT_OBJECT = eINSTANCE.getScaffoldInfo_RightObject();

		/**
		 * The meta object literal for the '<em><b>Left To Right Additional Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAFFOLD_INFO__LEFT_TO_RIGHT_ADDITIONAL_OBJECTS = eINSTANCE.getScaffoldInfo_LeftToRightAdditionalObjects();

		/**
		 * The meta object literal for the '<em><b>Right To Left Additional Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAFFOLD_INFO__RIGHT_TO_LEFT_ADDITIONAL_OBJECTS = eINSTANCE.getScaffoldInfo_RightToLeftAdditionalObjects();

		/**
		 * The meta object literal for the '<em><b>Traceability Infos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAFFOLD_INFO__TRACEABILITY_INFOS = eINSTANCE.getScaffoldInfo_TraceabilityInfos();

		/**
		 * The meta object literal for the '{@link fr.gouv.mindef.safran.database.scaffold.impl.TraceabilityInfoImpl <em>Traceability Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.gouv.mindef.safran.database.scaffold.impl.TraceabilityInfoImpl
		 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getTraceabilityInfo()
		 * @generated
		 */
		EClass TRACEABILITY_INFO = eINSTANCE.getTraceabilityInfo();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACEABILITY_INFO__LEFT = eINSTANCE.getTraceabilityInfo_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACEABILITY_INFO__RIGHT = eINSTANCE.getTraceabilityInfo_Right();

		/**
		 * The meta object literal for the '{@link fr.gouv.mindef.safran.database.scaffold.impl.EObjectToEObjectMapImpl <em>EObject To EObject Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.gouv.mindef.safran.database.scaffold.impl.EObjectToEObjectMapImpl
		 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getEObjectToEObjectMap()
		 * @generated
		 */
		EClass EOBJECT_TO_EOBJECT_MAP = eINSTANCE.getEObjectToEObjectMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_TO_EOBJECT_MAP__KEY = eINSTANCE.getEObjectToEObjectMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_TO_EOBJECT_MAP__VALUE = eINSTANCE.getEObjectToEObjectMap_Value();

		/**
		 * The meta object literal for the '{@link fr.gouv.mindef.safran.database.scaffold.ScaffoldType <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldType
		 * @see fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldPackageImpl#getScaffoldType()
		 * @generated
		 */
		EEnum SCAFFOLD_TYPE = eINSTANCE.getScaffoldType();

	}

} //ScaffoldPackage
