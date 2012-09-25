/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BEnum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getBEnum <em>BEnum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getEcoreEnumLiteral <em>Ecore Enum Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBEnumLiteral()
 * @model
 * @generated
 */
public interface BEnumLiteral extends BBase {
	/**
	 * Returns the value of the '<em><b>BEnum</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BEnum#getBEnumLiterals <em>BEnum Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BEnum</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BEnum</em>' container reference.
	 * @see #setBEnum(BEnum)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBEnumLiteral_BEnum()
	 * @see org.obeonetwork.dsl.ecorebinding.BEnum#getBEnumLiterals
	 * @model opposite="bEnumLiterals" required="true" transient="false"
	 * @generated
	 */
	BEnum getBEnum();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getBEnum <em>BEnum</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BEnum</em>' container reference.
	 * @see #getBEnum()
	 * @generated
	 */
	void setBEnum(BEnum value);

	/**
	 * Returns the value of the '<em><b>Ecore Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Enum Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Enum Literal</em>' reference.
	 * @see #setEcoreEnumLiteral(EEnumLiteral)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBEnumLiteral_EcoreEnumLiteral()
	 * @model required="true"
	 * @generated
	 */
	EEnumLiteral getEcoreEnumLiteral();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getEcoreEnumLiteral <em>Ecore Enum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Enum Literal</em>' reference.
	 * @see #getEcoreEnumLiteral()
	 * @generated
	 */
	void setEcoreEnumLiteral(EEnumLiteral value);

} // BEnumLiteral
