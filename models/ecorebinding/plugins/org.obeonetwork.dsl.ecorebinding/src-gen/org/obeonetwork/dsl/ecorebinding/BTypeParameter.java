/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.ecore.ETypeParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BType Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BTypeParameter#getEcoreTypeParameter <em>Ecore Type Parameter</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBTypeParameter()
 * @model
 * @generated
 */
public interface BTypeParameter extends BBase {
	/**
	 * Returns the value of the '<em><b>Ecore Type Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Type Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Type Parameter</em>' reference.
	 * @see #setEcoreTypeParameter(ETypeParameter)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBTypeParameter_EcoreTypeParameter()
	 * @model required="true"
	 * @generated
	 */
	ETypeParameter getEcoreTypeParameter();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BTypeParameter#getEcoreTypeParameter <em>Ecore Type Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Type Parameter</em>' reference.
	 * @see #getEcoreTypeParameter()
	 * @generated
	 */
	void setEcoreTypeParameter(ETypeParameter value);

} // BTypeParameter
