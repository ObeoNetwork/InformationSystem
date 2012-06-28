/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.typeslibrary;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage
 * @generated
 */
public interface TypesLibraryFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesLibraryFactory eINSTANCE = org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Native Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Native Types Library</em>'.
	 * @generated
	 */
	NativeTypesLibrary createNativeTypesLibrary();

	/**
	 * Returns a new object of class '<em>Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Instance</em>'.
	 * @generated
	 */
	TypeInstance createTypeInstance();

	/**
	 * Returns a new object of class '<em>Native Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Native Type</em>'.
	 * @generated
	 */
	NativeType createNativeType();

	/**
	 * Returns a new object of class '<em>Complex Named Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Named Type</em>'.
	 * @generated
	 */
	ComplexNamedType createComplexNamedType();

	/**
	 * Returns a new object of class '<em>Simple Named Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Named Type</em>'.
	 * @generated
	 */
	SimpleNamedType createSimpleNamedType();

	/**
	 * Returns a new object of class '<em>User Defined Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Defined Type Ref</em>'.
	 * @generated
	 */
	UserDefinedTypeRef createUserDefinedTypeRef();

	/**
	 * Returns a new object of class '<em>User Defined Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Defined Types Library</em>'.
	 * @generated
	 */
	UserDefinedTypesLibrary createUserDefinedTypesLibrary();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesLibraryPackage getTypesLibraryPackage();

} //TypesLibraryFactory
