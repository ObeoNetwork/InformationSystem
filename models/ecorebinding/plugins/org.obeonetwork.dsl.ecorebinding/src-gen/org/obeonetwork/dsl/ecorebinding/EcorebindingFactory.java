/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage
 * @generated
 */
public interface EcorebindingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcorebindingFactory eINSTANCE = org.obeonetwork.dsl.ecorebinding.impl.EcorebindingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>BModel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BModel</em>'.
	 * @generated
	 */
	BModel createBModel();

	/**
	 * Returns a new object of class '<em>BPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BPackage</em>'.
	 * @generated
	 */
	BPackage createBPackage();

	/**
	 * Returns a new object of class '<em>BClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BClass</em>'.
	 * @generated
	 */
	BClass createBClass();

	/**
	 * Returns a new object of class '<em>BFeature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BFeature</em>'.
	 * @generated
	 */
	BFeature createBFeature();

	/**
	 * Returns a new object of class '<em>BEnum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BEnum</em>'.
	 * @generated
	 */
	BEnum createBEnum();

	/**
	 * Returns a new object of class '<em>BEnum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BEnum Literal</em>'.
	 * @generated
	 */
	BEnumLiteral createBEnumLiteral();

	/**
	 * Returns a new object of class '<em>BClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BClassifier</em>'.
	 * @generated
	 */
	BClassifier createBClassifier();

	/**
	 * Returns a new object of class '<em>BData Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BData Type</em>'.
	 * @generated
	 */
	BDataType createBDataType();

	/**
	 * Returns a new object of class '<em>BOperation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BOperation</em>'.
	 * @generated
	 */
	BOperation createBOperation();

	/**
	 * Returns a new object of class '<em>BParameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BParameter</em>'.
	 * @generated
	 */
	BParameter createBParameter();

	/**
	 * Returns a new object of class '<em>BTyped Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BTyped Element</em>'.
	 * @generated
	 */
	BTypedElement createBTypedElement();

	/**
	 * Returns a new object of class '<em>BType Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BType Parameter</em>'.
	 * @generated
	 */
	BTypeParameter createBTypeParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcorebindingPackage getEcorebindingPackage();

} //EcorebindingFactory
