/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BFeature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BFeature#getBClass <em>BClass</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BFeature#getEcoreFeature <em>Ecore Feature</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBFeature()
 * @model
 * @generated
 */
public interface BFeature extends BTypedElement {
	/**
	 * Returns the value of the '<em><b>BClass</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BClass#getBFeatures <em>BFeatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BClass</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BClass</em>' container reference.
	 * @see #setBClass(BClass)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBFeature_BClass()
	 * @see org.obeonetwork.dsl.ecorebinding.BClass#getBFeatures
	 * @model opposite="bFeatures" required="true" transient="false"
	 * @generated
	 */
	BClass getBClass();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BFeature#getBClass <em>BClass</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BClass</em>' container reference.
	 * @see #getBClass()
	 * @generated
	 */
	void setBClass(BClass value);

	/**
	 * Returns the value of the '<em><b>Ecore Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Feature</em>' reference.
	 * @see #setEcoreFeature(EStructuralFeature)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBFeature_EcoreFeature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getEcoreFeature();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BFeature#getEcoreFeature <em>Ecore Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Feature</em>' reference.
	 * @see #getEcoreFeature()
	 * @generated
	 */
	void setEcoreFeature(EStructuralFeature value);

} // BFeature
