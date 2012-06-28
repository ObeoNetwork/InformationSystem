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

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory
 * @model kind="package"
 * @generated
 */
public interface TypesLibraryPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "typeslibrary";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/typeslibrary/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "typeslibrary";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesLibraryPackage eINSTANCE = org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.TypesLibrary <em>Types Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibrary
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypesLibrary()
	 * @generated
	 */
	int TYPES_LIBRARY = 10;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_LIBRARY__KIND = 0;

	/**
	 * The number of structural features of the '<em>Types Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl <em>Native Types Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getNativeTypesLibrary()
	 * @generated
	 */
	int NATIVE_TYPES_LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPES_LIBRARY__KIND = TYPES_LIBRARY__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPES_LIBRARY__NAME = TYPES_LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Native Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPES_LIBRARY__NATIVE_TYPES = TYPES_LIBRARY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Native Types Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPES_LIBRARY_FEATURE_COUNT = TYPES_LIBRARY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypeImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 5;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl <em>Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypeInstance()
	 * @generated
	 */
	int TYPE_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Native Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__NATIVE_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__LENGTH = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__PRECISION = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__LITERALS = TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypeImpl <em>Native Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.NativeTypeImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getNativeType()
	 * @generated
	 */
	int NATIVE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Spec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__SPEC = 1;

	/**
	 * The feature id for the '<em><b>Maps To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__MAPS_TO = 2;

	/**
	 * The number of structural features of the '<em>Native Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeImpl <em>User Defined Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getUserDefinedType()
	 * @generated
	 */
	int USER_DEFINED_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>User Defined Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.ComplexNamedTypeImpl <em>Complex Named Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.ComplexNamedTypeImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getComplexNamedType()
	 * @generated
	 */
	int COMPLEX_NAMED_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_NAMED_TYPE__NAME = USER_DEFINED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_NAMED_TYPE__TYPES = USER_DEFINED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Named Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_NAMED_TYPE_FEATURE_COUNT = USER_DEFINED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.SimpleNamedTypeImpl <em>Simple Named Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.SimpleNamedTypeImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getSimpleNamedType()
	 * @generated
	 */
	int SIMPLE_NAMED_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_TYPE__NAME = USER_DEFINED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_TYPE__TYPE = USER_DEFINED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Named Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_TYPE_FEATURE_COUNT = USER_DEFINED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeRefImpl <em>User Defined Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeRefImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getUserDefinedTypeRef()
	 * @generated
	 */
	int USER_DEFINED_TYPE_REF = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE_REF__TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Defined Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE_REF_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypesLibraryImpl <em>User Defined Types Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypesLibraryImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getUserDefinedTypesLibrary()
	 * @generated
	 */
	int USER_DEFINED_TYPES_LIBRARY = 8;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPES_LIBRARY__KIND = TYPES_LIBRARY__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPES_LIBRARY__NAME = TYPES_LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Defined Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPES_LIBRARY__USER_DEFINED_TYPES = TYPES_LIBRARY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Defined Types Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPES_LIBRARY_FEATURE_COUNT = TYPES_LIBRARY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryUserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryUserImpl
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypesLibraryUser()
	 * @generated
	 */
	int TYPES_LIBRARY_USER = 9;

	/**
	 * The feature id for the '<em><b>Used Libraries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_LIBRARY_USER__USED_LIBRARIES = 0;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_LIBRARY_USER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.NativeTypeKind <em>Native Type Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.NativeTypeKind
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getNativeTypeKind()
	 * @generated
	 */
	int NATIVE_TYPE_KIND = 11;


	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.typeslibrary.TypesLibraryKind <em>Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryKind
	 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypesLibraryKind()
	 * @generated
	 */
	int TYPES_LIBRARY_KIND = 12;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary <em>Native Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native Types Library</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary
	 * @generated
	 */
	EClass getNativeTypesLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary#getName()
	 * @see #getNativeTypesLibrary()
	 * @generated
	 */
	EAttribute getNativeTypesLibrary_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary#getNativeTypes <em>Native Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Native Types</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary#getNativeTypes()
	 * @see #getNativeTypesLibrary()
	 * @generated
	 */
	EReference getNativeTypesLibrary_NativeTypes();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance <em>Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Instance</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypeInstance
	 * @generated
	 */
	EClass getTypeInstance();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getNativeType <em>Native Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Native Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypeInstance#getNativeType()
	 * @see #getTypeInstance()
	 * @generated
	 */
	EReference getTypeInstance_NativeType();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypeInstance#getLength()
	 * @see #getTypeInstance()
	 * @generated
	 */
	EAttribute getTypeInstance_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getPrecision <em>Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precision</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypeInstance#getPrecision()
	 * @see #getTypeInstance()
	 * @generated
	 */
	EAttribute getTypeInstance_Precision();

	/**
	 * Returns the meta object for the attribute list '{@link org.obeonetwork.dsl.typeslibrary.TypeInstance#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Literals</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypeInstance#getLiterals()
	 * @see #getTypeInstance()
	 * @generated
	 */
	EAttribute getTypeInstance_Literals();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.NativeType <em>Native Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeType
	 * @generated
	 */
	EClass getNativeType();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.NativeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeType#getName()
	 * @see #getNativeType()
	 * @generated
	 */
	EAttribute getNativeType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.NativeType#getSpec <em>Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spec</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeType#getSpec()
	 * @see #getNativeType()
	 * @generated
	 */
	EAttribute getNativeType_Spec();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.typeslibrary.NativeType#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Maps To</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeType#getMapsTo()
	 * @see #getNativeType()
	 * @generated
	 */
	EReference getNativeType_MapsTo();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.ComplexNamedType <em>Complex Named Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Named Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.ComplexNamedType
	 * @generated
	 */
	EClass getComplexNamedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.typeslibrary.ComplexNamedType#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.ComplexNamedType#getTypes()
	 * @see #getComplexNamedType()
	 * @generated
	 */
	EReference getComplexNamedType_Types();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.SimpleNamedType <em>Simple Named Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Named Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.SimpleNamedType
	 * @generated
	 */
	EClass getSimpleNamedType();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.typeslibrary.SimpleNamedType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.SimpleNamedType#getType()
	 * @see #getSimpleNamedType()
	 * @generated
	 */
	EReference getSimpleNamedType_Type();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedType <em>User Defined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Defined Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.UserDefinedType
	 * @generated
	 */
	EClass getUserDefinedType();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.UserDefinedType#getName()
	 * @see #getUserDefinedType()
	 * @generated
	 */
	EAttribute getUserDefinedType_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef <em>User Defined Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Defined Type Ref</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef
	 * @generated
	 */
	EClass getUserDefinedTypeRef();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef#getType()
	 * @see #getUserDefinedTypeRef()
	 * @generated
	 */
	EReference getUserDefinedTypeRef_Type();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary <em>User Defined Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Defined Types Library</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary
	 * @generated
	 */
	EClass getUserDefinedTypesLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary#getName()
	 * @see #getUserDefinedTypesLibrary()
	 * @generated
	 */
	EAttribute getUserDefinedTypesLibrary_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary#getUserDefinedTypes <em>User Defined Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Defined Types</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary#getUserDefinedTypes()
	 * @see #getUserDefinedTypesLibrary()
	 * @generated
	 */
	EReference getUserDefinedTypesLibrary_UserDefinedTypes();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.TypesLibraryUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryUser
	 * @generated
	 */
	EClass getTypesLibraryUser();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.typeslibrary.TypesLibraryUser#getUsedLibraries <em>Used Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used Libraries</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryUser#getUsedLibraries()
	 * @see #getTypesLibraryUser()
	 * @generated
	 */
	EReference getTypesLibraryUser_UsedLibraries();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.typeslibrary.TypesLibrary <em>Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Types Library</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibrary
	 * @generated
	 */
	EClass getTypesLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.typeslibrary.TypesLibrary#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibrary#getKind()
	 * @see #getTypesLibrary()
	 * @generated
	 */
	EAttribute getTypesLibrary_Kind();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.typeslibrary.NativeTypeKind <em>Native Type Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Native Type Kind</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.NativeTypeKind
	 * @generated
	 */
	EEnum getNativeTypeKind();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.typeslibrary.TypesLibraryKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Kind</em>'.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryKind
	 * @generated
	 */
	EEnum getTypesLibraryKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesLibraryFactory getTypesLibraryFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl <em>Native Types Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getNativeTypesLibrary()
		 * @generated
		 */
		EClass NATIVE_TYPES_LIBRARY = eINSTANCE.getNativeTypesLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NATIVE_TYPES_LIBRARY__NAME = eINSTANCE.getNativeTypesLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>Native Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NATIVE_TYPES_LIBRARY__NATIVE_TYPES = eINSTANCE.getNativeTypesLibrary_NativeTypes();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl <em>Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypeInstance()
		 * @generated
		 */
		EClass TYPE_INSTANCE = eINSTANCE.getTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Native Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_INSTANCE__NATIVE_TYPE = eINSTANCE.getTypeInstance_NativeType();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_INSTANCE__LENGTH = eINSTANCE.getTypeInstance_Length();

		/**
		 * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_INSTANCE__PRECISION = eINSTANCE.getTypeInstance_Precision();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_INSTANCE__LITERALS = eINSTANCE.getTypeInstance_Literals();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypeImpl <em>Native Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.NativeTypeImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getNativeType()
		 * @generated
		 */
		EClass NATIVE_TYPE = eINSTANCE.getNativeType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NATIVE_TYPE__NAME = eINSTANCE.getNativeType_Name();

		/**
		 * The meta object literal for the '<em><b>Spec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NATIVE_TYPE__SPEC = eINSTANCE.getNativeType_Spec();

		/**
		 * The meta object literal for the '<em><b>Maps To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NATIVE_TYPE__MAPS_TO = eINSTANCE.getNativeType_MapsTo();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.ComplexNamedTypeImpl <em>Complex Named Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.ComplexNamedTypeImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getComplexNamedType()
		 * @generated
		 */
		EClass COMPLEX_NAMED_TYPE = eINSTANCE.getComplexNamedType();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_NAMED_TYPE__TYPES = eINSTANCE.getComplexNamedType_Types();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.SimpleNamedTypeImpl <em>Simple Named Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.SimpleNamedTypeImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getSimpleNamedType()
		 * @generated
		 */
		EClass SIMPLE_NAMED_TYPE = eINSTANCE.getSimpleNamedType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_NAMED_TYPE__TYPE = eINSTANCE.getSimpleNamedType_Type();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypeImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeImpl <em>User Defined Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getUserDefinedType()
		 * @generated
		 */
		EClass USER_DEFINED_TYPE = eINSTANCE.getUserDefinedType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_DEFINED_TYPE__NAME = eINSTANCE.getUserDefinedType_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeRefImpl <em>User Defined Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeRefImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getUserDefinedTypeRef()
		 * @generated
		 */
		EClass USER_DEFINED_TYPE_REF = eINSTANCE.getUserDefinedTypeRef();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_TYPE_REF__TYPE = eINSTANCE.getUserDefinedTypeRef_Type();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypesLibraryImpl <em>User Defined Types Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypesLibraryImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getUserDefinedTypesLibrary()
		 * @generated
		 */
		EClass USER_DEFINED_TYPES_LIBRARY = eINSTANCE.getUserDefinedTypesLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_DEFINED_TYPES_LIBRARY__NAME = eINSTANCE.getUserDefinedTypesLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>User Defined Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_TYPES_LIBRARY__USER_DEFINED_TYPES = eINSTANCE.getUserDefinedTypesLibrary_UserDefinedTypes();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryUserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryUserImpl
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypesLibraryUser()
		 * @generated
		 */
		EClass TYPES_LIBRARY_USER = eINSTANCE.getTypesLibraryUser();

		/**
		 * The meta object literal for the '<em><b>Used Libraries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPES_LIBRARY_USER__USED_LIBRARIES = eINSTANCE.getTypesLibraryUser_UsedLibraries();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.TypesLibrary <em>Types Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.TypesLibrary
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypesLibrary()
		 * @generated
		 */
		EClass TYPES_LIBRARY = eINSTANCE.getTypesLibrary();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPES_LIBRARY__KIND = eINSTANCE.getTypesLibrary_Kind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.NativeTypeKind <em>Native Type Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.NativeTypeKind
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getNativeTypeKind()
		 * @generated
		 */
		EEnum NATIVE_TYPE_KIND = eINSTANCE.getNativeTypeKind();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.typeslibrary.TypesLibraryKind <em>Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryKind
		 * @see org.obeonetwork.dsl.typeslibrary.impl.TypesLibraryPackageImpl#getTypesLibraryKind()
		 * @generated
		 */
		EEnum TYPES_LIBRARY_KIND = eINSTANCE.getTypesLibraryKind();

	}

} //TypesLibraryPackage
