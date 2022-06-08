/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.database.scaffold;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.database.scaffold.ScaffoldInfo#getLeftObject <em>Left Object</em>}</li>
 *   <li>{@link org.obeonetwork.database.scaffold.ScaffoldInfo#getRightObject <em>Right Object</em>}</li>
 *   <li>{@link org.obeonetwork.database.scaffold.ScaffoldInfo#getLeftToRightAdditionalObjects <em>Left To Right Additional Objects</em>}</li>
 *   <li>{@link org.obeonetwork.database.scaffold.ScaffoldInfo#getRightToLeftAdditionalObjects <em>Right To Left Additional Objects</em>}</li>
 *   <li>{@link org.obeonetwork.database.scaffold.ScaffoldInfo#getTraceabilityInfos <em>Traceability Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.database.scaffold.ScaffoldPackage#getScaffoldInfo()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ScaffoldInfo extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2022 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Left Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Object</em>' reference.
	 * @see #setLeftObject(EObject)
	 * @see org.obeonetwork.database.scaffold.ScaffoldPackage#getScaffoldInfo_LeftObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getLeftObject();

	/**
	 * Sets the value of the '{@link org.obeonetwork.database.scaffold.ScaffoldInfo#getLeftObject <em>Left Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Object</em>' reference.
	 * @see #getLeftObject()
	 * @generated
	 */
	void setLeftObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Right Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Object</em>' reference.
	 * @see #setRightObject(EObject)
	 * @see org.obeonetwork.database.scaffold.ScaffoldPackage#getScaffoldInfo_RightObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getRightObject();

	/**
	 * Sets the value of the '{@link org.obeonetwork.database.scaffold.ScaffoldInfo#getRightObject <em>Right Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Object</em>' reference.
	 * @see #getRightObject()
	 * @generated
	 */
	void setRightObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Left To Right Additional Objects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left To Right Additional Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left To Right Additional Objects</em>' reference list.
	 * @see org.obeonetwork.database.scaffold.ScaffoldPackage#getScaffoldInfo_LeftToRightAdditionalObjects()
	 * @model
	 * @generated
	 */
	EList<EObject> getLeftToRightAdditionalObjects();

	/**
	 * Returns the value of the '<em><b>Right To Left Additional Objects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right To Left Additional Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right To Left Additional Objects</em>' reference list.
	 * @see org.obeonetwork.database.scaffold.ScaffoldPackage#getScaffoldInfo_RightToLeftAdditionalObjects()
	 * @model
	 * @generated
	 */
	EList<EObject> getRightToLeftAdditionalObjects();

	/**
	 * Returns the value of the '<em><b>Traceability Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.database.scaffold.TraceabilityInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceability Infos</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceability Infos</em>' containment reference list.
	 * @see org.obeonetwork.database.scaffold.ScaffoldPackage#getScaffoldInfo_TraceabilityInfos()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ti'"
	 * @generated
	 */
	EList<TraceabilityInfo> getTraceabilityInfos();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	ScaffoldType getLeftToRightTransformationType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	ScaffoldType getRightToLeftTransformationType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model scaffoldTypeRequired="true"
	 * @generated
	 */
	EObject getStartingObjectForTransformation(ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model scaffoldTypeRequired="true"
	 * @generated
	 */
	EObject getEndingObjectForTransformation(ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model scaffoldTypeRequired="true"
	 * @generated
	 */
	EList<EObject> getAdditionalObjectsForTransformation(ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model objectRequired="true" scaffoldTypeRequired="true"
	 * @generated
	 */
	void setStartingObjectForTransformation(EObject object, ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model objectRequired="true" scaffoldTypeRequired="true"
	 * @generated
	 */
	void setEndingObjectForTransformation(EObject object, ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model scaffoldTypeRequired="true"
	 * @generated
	 */
	void clearAdditionalObjectsForTransformation(ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model objectRequired="true" scaffoldTypeRequired="true"
	 * @generated
	 */
	void addAdditionalObjectsForTransformation(EObject object, ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model mapType="org.obeonetwork.database.scaffold.EObjectToEObjectMap<org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject>" scaffoldTypeRequired="true"
	 * @generated
	 */
	EMap<EObject, EObject> getTraceabilityMap(ScaffoldType scaffoldType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model scaffoldTypeRequired="true" infosMapType="org.obeonetwork.database.scaffold.EObjectToEObjectMap<org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	void replaceTraceabilityInfos(ScaffoldType scaffoldType, EMap<EObject, EObject> infos);

} // ScaffoldInfo
