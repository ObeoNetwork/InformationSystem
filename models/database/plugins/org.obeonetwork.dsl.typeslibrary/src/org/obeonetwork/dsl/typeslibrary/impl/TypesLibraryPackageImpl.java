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
package org.obeonetwork.dsl.typeslibrary.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.obeonetwork.dsl.typeslibrary.ComplexNamedType;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.SimpleNamedType;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryUser;
import org.obeonetwork.dsl.typeslibrary.UserDefinedType;
import org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef;
import org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesLibraryPackageImpl extends EPackageImpl implements TypesLibraryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nativeTypesLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nativeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexNamedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleNamedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDefinedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDefinedTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDefinedTypesLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typesLibraryUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typesLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nativeTypeKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typesLibraryKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesLibraryPackageImpl() {
		super(eNS_URI, TypesLibraryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TypesLibraryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesLibraryPackage init() {
		if (isInited) return (TypesLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(TypesLibraryPackage.eNS_URI);

		// Obtain or create and register package
		TypesLibraryPackageImpl theTypesLibraryPackage = (TypesLibraryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesLibraryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesLibraryPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTypesLibraryPackage.createPackageContents();

		// Initialize created meta-data
		theTypesLibraryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesLibraryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesLibraryPackage.eNS_URI, theTypesLibraryPackage);
		return theTypesLibraryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNativeTypesLibrary() {
		return nativeTypesLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNativeTypesLibrary_Name() {
		return (EAttribute)nativeTypesLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNativeTypesLibrary_NativeTypes() {
		return (EReference)nativeTypesLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeInstance() {
		return typeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeInstance_NativeType() {
		return (EReference)typeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeInstance_Length() {
		return (EAttribute)typeInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeInstance_Precision() {
		return (EAttribute)typeInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeInstance_Literals() {
		return (EAttribute)typeInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNativeType() {
		return nativeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNativeType_Name() {
		return (EAttribute)nativeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNativeType_Spec() {
		return (EAttribute)nativeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNativeType_MapsTo() {
		return (EReference)nativeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexNamedType() {
		return complexNamedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexNamedType_Types() {
		return (EReference)complexNamedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleNamedType() {
		return simpleNamedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleNamedType_Type() {
		return (EReference)simpleNamedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDefinedType() {
		return userDefinedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDefinedType_Name() {
		return (EAttribute)userDefinedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDefinedTypeRef() {
		return userDefinedTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserDefinedTypeRef_Type() {
		return (EReference)userDefinedTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDefinedTypesLibrary() {
		return userDefinedTypesLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDefinedTypesLibrary_Name() {
		return (EAttribute)userDefinedTypesLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserDefinedTypesLibrary_UserDefinedTypes() {
		return (EReference)userDefinedTypesLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypesLibraryUser() {
		return typesLibraryUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypesLibraryUser_UsedLibraries() {
		return (EReference)typesLibraryUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypesLibrary() {
		return typesLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypesLibrary_Kind() {
		return (EAttribute)typesLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNativeTypeKind() {
		return nativeTypeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypesLibraryKind() {
		return typesLibraryKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesLibraryFactory getTypesLibraryFactory() {
		return (TypesLibraryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		nativeTypesLibraryEClass = createEClass(NATIVE_TYPES_LIBRARY);
		createEAttribute(nativeTypesLibraryEClass, NATIVE_TYPES_LIBRARY__NAME);
		createEReference(nativeTypesLibraryEClass, NATIVE_TYPES_LIBRARY__NATIVE_TYPES);

		typeInstanceEClass = createEClass(TYPE_INSTANCE);
		createEReference(typeInstanceEClass, TYPE_INSTANCE__NATIVE_TYPE);
		createEAttribute(typeInstanceEClass, TYPE_INSTANCE__LENGTH);
		createEAttribute(typeInstanceEClass, TYPE_INSTANCE__PRECISION);
		createEAttribute(typeInstanceEClass, TYPE_INSTANCE__LITERALS);

		nativeTypeEClass = createEClass(NATIVE_TYPE);
		createEAttribute(nativeTypeEClass, NATIVE_TYPE__NAME);
		createEAttribute(nativeTypeEClass, NATIVE_TYPE__SPEC);
		createEReference(nativeTypeEClass, NATIVE_TYPE__MAPS_TO);

		complexNamedTypeEClass = createEClass(COMPLEX_NAMED_TYPE);
		createEReference(complexNamedTypeEClass, COMPLEX_NAMED_TYPE__TYPES);

		simpleNamedTypeEClass = createEClass(SIMPLE_NAMED_TYPE);
		createEReference(simpleNamedTypeEClass, SIMPLE_NAMED_TYPE__TYPE);

		typeEClass = createEClass(TYPE);

		userDefinedTypeEClass = createEClass(USER_DEFINED_TYPE);
		createEAttribute(userDefinedTypeEClass, USER_DEFINED_TYPE__NAME);

		userDefinedTypeRefEClass = createEClass(USER_DEFINED_TYPE_REF);
		createEReference(userDefinedTypeRefEClass, USER_DEFINED_TYPE_REF__TYPE);

		userDefinedTypesLibraryEClass = createEClass(USER_DEFINED_TYPES_LIBRARY);
		createEAttribute(userDefinedTypesLibraryEClass, USER_DEFINED_TYPES_LIBRARY__NAME);
		createEReference(userDefinedTypesLibraryEClass, USER_DEFINED_TYPES_LIBRARY__USER_DEFINED_TYPES);

		typesLibraryUserEClass = createEClass(TYPES_LIBRARY_USER);
		createEReference(typesLibraryUserEClass, TYPES_LIBRARY_USER__USED_LIBRARIES);

		typesLibraryEClass = createEClass(TYPES_LIBRARY);
		createEAttribute(typesLibraryEClass, TYPES_LIBRARY__KIND);

		// Create enums
		nativeTypeKindEEnum = createEEnum(NATIVE_TYPE_KIND);
		typesLibraryKindEEnum = createEEnum(TYPES_LIBRARY_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nativeTypesLibraryEClass.getESuperTypes().add(this.getTypesLibrary());
		typeInstanceEClass.getESuperTypes().add(this.getType());
		complexNamedTypeEClass.getESuperTypes().add(this.getUserDefinedType());
		simpleNamedTypeEClass.getESuperTypes().add(this.getUserDefinedType());
		userDefinedTypeRefEClass.getESuperTypes().add(this.getType());
		userDefinedTypesLibraryEClass.getESuperTypes().add(this.getTypesLibrary());

		// Initialize classes and features; add operations and parameters
		initEClass(nativeTypesLibraryEClass, NativeTypesLibrary.class, "NativeTypesLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNativeTypesLibrary_Name(), ecorePackage.getEString(), "name", null, 0, 1, NativeTypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNativeTypesLibrary_NativeTypes(), this.getNativeType(), null, "nativeTypes", null, 0, -1, NativeTypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(nativeTypesLibraryEClass, this.getNativeType(), "findTypeByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(typeInstanceEClass, TypeInstance.class, "TypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeInstance_NativeType(), this.getNativeType(), null, "nativeType", null, 1, 1, TypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeInstance_Length(), ecorePackage.getEInt(), "length", null, 0, 1, TypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeInstance_Precision(), ecorePackage.getEInt(), "precision", null, 0, 1, TypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeInstance_Literals(), ecorePackage.getEString(), "literals", null, 0, -1, TypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nativeTypeEClass, NativeType.class, "NativeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNativeType_Name(), ecorePackage.getEString(), "name", null, 0, 1, NativeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNativeType_Spec(), this.getNativeTypeKind(), "spec", null, 0, 1, NativeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNativeType_MapsTo(), this.getNativeType(), null, "mapsTo", null, 0, 1, NativeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexNamedTypeEClass, ComplexNamedType.class, "ComplexNamedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexNamedType_Types(), this.getUserDefinedType(), null, "types", null, 0, -1, ComplexNamedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleNamedTypeEClass, SimpleNamedType.class, "SimpleNamedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleNamedType_Type(), this.getTypeInstance(), null, "type", null, 1, 1, SimpleNamedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userDefinedTypeEClass, UserDefinedType.class, "UserDefinedType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserDefinedType_Name(), ecorePackage.getEString(), "name", null, 0, 1, UserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDefinedTypeRefEClass, UserDefinedTypeRef.class, "UserDefinedTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDefinedTypeRef_Type(), this.getUserDefinedType(), null, "type", null, 1, 1, UserDefinedTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDefinedTypesLibraryEClass, UserDefinedTypesLibrary.class, "UserDefinedTypesLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserDefinedTypesLibrary_Name(), ecorePackage.getEString(), "name", null, 0, 1, UserDefinedTypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserDefinedTypesLibrary_UserDefinedTypes(), this.getUserDefinedType(), null, "userDefinedTypes", null, 0, -1, UserDefinedTypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typesLibraryUserEClass, TypesLibraryUser.class, "TypesLibraryUser", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypesLibraryUser_UsedLibraries(), this.getTypesLibrary(), null, "usedLibraries", null, 0, -1, TypesLibraryUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typesLibraryEClass, TypesLibrary.class, "TypesLibrary", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypesLibrary_Kind(), this.getTypesLibraryKind(), "kind", null, 0, 1, TypesLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(nativeTypeKindEEnum, NativeTypeKind.class, "NativeTypeKind");
		addEEnumLiteral(nativeTypeKindEEnum, NativeTypeKind.SIMPLE);
		addEEnumLiteral(nativeTypeKindEEnum, NativeTypeKind.LENGTH);
		addEEnumLiteral(nativeTypeKindEEnum, NativeTypeKind.LENGTH_AND_PRECISION);
		addEEnumLiteral(nativeTypeKindEEnum, NativeTypeKind.ENUM);

		initEEnum(typesLibraryKindEEnum, TypesLibraryKind.class, "TypesLibraryKind");
		addEEnumLiteral(typesLibraryKindEEnum, TypesLibraryKind.LOGICAL_TYPES);
		addEEnumLiteral(typesLibraryKindEEnum, TypesLibraryKind.PHYSICAL_TYPES);

		// Create resource
		createResource(eNS_URI);
	}

} //TypesLibraryPackageImpl
