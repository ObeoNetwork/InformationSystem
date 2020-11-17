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
package org.obeonetwork.dsl.typeslibrary.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.obeonetwork.dsl.typeslibrary.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesLibraryFactoryImpl extends EFactoryImpl implements TypesLibraryFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypesLibraryFactory init() {
		try {
			TypesLibraryFactory theTypesLibraryFactory = (TypesLibraryFactory)EPackage.Registry.INSTANCE.getEFactory(TypesLibraryPackage.eNS_URI);
			if (theTypesLibraryFactory != null) {
				return theTypesLibraryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypesLibraryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesLibraryFactoryImpl() {
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
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY: return (EObject)createNativeTypesLibrary();
			case TypesLibraryPackage.TYPE_INSTANCE: return (EObject)createTypeInstance();
			case TypesLibraryPackage.NATIVE_TYPE: return (EObject)createNativeType();
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE: return (EObject)createComplexNamedType();
			case TypesLibraryPackage.SIMPLE_NAMED_TYPE: return (EObject)createSimpleNamedType();
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF: return (EObject)createUserDefinedTypeRef();
			case TypesLibraryPackage.USER_DEFINED_TYPES_LIBRARY: return (EObject)createUserDefinedTypesLibrary();
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
			case TypesLibraryPackage.NATIVE_TYPE_KIND:
				return createNativeTypeKindFromString(eDataType, initialValue);
			case TypesLibraryPackage.TYPES_LIBRARY_KIND:
				return createTypesLibraryKindFromString(eDataType, initialValue);
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
			case TypesLibraryPackage.NATIVE_TYPE_KIND:
				return convertNativeTypeKindToString(eDataType, instanceValue);
			case TypesLibraryPackage.TYPES_LIBRARY_KIND:
				return convertTypesLibraryKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeTypesLibrary createNativeTypesLibrary() {
		NativeTypesLibraryImpl nativeTypesLibrary = new NativeTypesLibraryImpl();
		return nativeTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeInstance createTypeInstance() {
		TypeInstanceImpl typeInstance = new TypeInstanceImpl();
		return typeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeType createNativeType() {
		NativeTypeImpl nativeType = new NativeTypeImpl();
		return nativeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexNamedType createComplexNamedType() {
		ComplexNamedTypeImpl complexNamedType = new ComplexNamedTypeImpl();
		return complexNamedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNamedType createSimpleNamedType() {
		SimpleNamedTypeImpl simpleNamedType = new SimpleNamedTypeImpl();
		return simpleNamedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedTypeRef createUserDefinedTypeRef() {
		UserDefinedTypeRefImpl userDefinedTypeRef = new UserDefinedTypeRefImpl();
		return userDefinedTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedTypesLibrary createUserDefinedTypesLibrary() {
		UserDefinedTypesLibraryImpl userDefinedTypesLibrary = new UserDefinedTypesLibraryImpl();
		return userDefinedTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeTypeKind createNativeTypeKindFromString(EDataType eDataType, String initialValue) {
		NativeTypeKind result = NativeTypeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNativeTypeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesLibraryKind createTypesLibraryKindFromString(EDataType eDataType, String initialValue) {
		TypesLibraryKind result = TypesLibraryKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypesLibraryKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesLibraryPackage getTypesLibraryPackage() {
		return (TypesLibraryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TypesLibraryPackage getPackage() {
		return TypesLibraryPackage.eINSTANCE;
	}

} //TypesLibraryFactoryImpl
