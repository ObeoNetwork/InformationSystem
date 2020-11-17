/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BPackage#getEcorePackage <em>Ecore Package</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBModel <em>BModel</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBEnums <em>BEnums</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBDataTypes <em>BData Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBClasses <em>BClasses</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BPackage#getNestedBPackages <em>Nested BPackages</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBClassifiers <em>BClassifiers</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage()
 * @model
 * @generated
 */
public interface BPackage extends BBase {
	/**
	 * Returns the value of the '<em><b>Ecore Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Package</em>' reference.
	 * @see #setEcorePackage(EPackage)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage_EcorePackage()
	 * @model required="true"
	 * @generated
	 */
	EPackage getEcorePackage();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getEcorePackage <em>Ecore Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Package</em>' reference.
	 * @see #getEcorePackage()
	 * @generated
	 */
	void setEcorePackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>BModel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BModel#getBPackages <em>BPackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BModel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BModel</em>' container reference.
	 * @see #setBModel(BModel)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage_BModel()
	 * @see org.obeonetwork.dsl.ecorebinding.BModel#getBPackages
	 * @model opposite="bPackages" transient="false"
	 * @generated
	 */
	BModel getBModel();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBModel <em>BModel</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BModel</em>' container reference.
	 * @see #getBModel()
	 * @generated
	 */
	void setBModel(BModel value);

	/**
	 * Returns the value of the '<em><b>BEnums</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BEnums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BEnums</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage_BEnums()
	 * @model containment="true"
	 * @generated
	 */
	EList<BEnum> getBEnums();

	/**
	 * Returns the value of the '<em><b>BData Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BData Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BData Types</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage_BDataTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<BDataType> getBDataTypes();

	/**
	 * Returns the value of the '<em><b>BClasses</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BClasses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BClasses</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage_BClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<BClass> getBClasses();

	/**
	 * Returns the value of the '<em><b>Nested BPackages</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested BPackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested BPackages</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage_NestedBPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<BPackage> getNestedBPackages();

	/**
	 * Returns the value of the '<em><b>BClassifiers</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BClassifier}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BClassifier#getBPackage <em>BPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BClassifiers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BClassifiers</em>' reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBPackage_BClassifiers()
	 * @see org.obeonetwork.dsl.ecorebinding.BClassifier#getBPackage
	 * @model opposite="bPackage"
	 * @generated
	 */
	EList<BClassifier> getBClassifiers();

} // BPackage
