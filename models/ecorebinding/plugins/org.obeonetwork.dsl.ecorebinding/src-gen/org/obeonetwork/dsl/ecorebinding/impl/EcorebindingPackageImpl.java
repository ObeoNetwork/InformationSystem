/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.ecorebinding.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.obeonetwork.dsl.ecorebinding.BBase;
import org.obeonetwork.dsl.ecorebinding.BClass;
import org.obeonetwork.dsl.ecorebinding.BClassifier;
import org.obeonetwork.dsl.ecorebinding.BDataType;
import org.obeonetwork.dsl.ecorebinding.BEnum;
import org.obeonetwork.dsl.ecorebinding.BEnumLiteral;
import org.obeonetwork.dsl.ecorebinding.BFeature;
import org.obeonetwork.dsl.ecorebinding.BModel;
import org.obeonetwork.dsl.ecorebinding.BOperation;
import org.obeonetwork.dsl.ecorebinding.BPackage;
import org.obeonetwork.dsl.ecorebinding.BParameter;
import org.obeonetwork.dsl.ecorebinding.BTypeParameter;
import org.obeonetwork.dsl.ecorebinding.BTypedElement;
import org.obeonetwork.dsl.ecorebinding.EcorebindingFactory;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorebindingPackageImpl extends EPackageImpl implements EcorebindingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bEnumLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bTypedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bTypeParameterEClass = null;

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
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcorebindingPackageImpl() {
		super(eNS_URI, EcorebindingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcorebindingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcorebindingPackage init() {
		if (isInited) return (EcorebindingPackage)EPackage.Registry.INSTANCE.getEPackage(EcorebindingPackage.eNS_URI);

		// Obtain or create and register package
		EcorebindingPackageImpl theEcorebindingPackage = (EcorebindingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcorebindingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcorebindingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		EnvironmentPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEcorebindingPackage.createPackageContents();

		// Initialize created meta-data
		theEcorebindingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcorebindingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcorebindingPackage.eNS_URI, theEcorebindingPackage);
		return theEcorebindingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBBase() {
		return bBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBModel() {
		return bModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBModel_BPackages() {
		return (EReference)bModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPackage() {
		return bPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPackage_EcorePackage() {
		return (EReference)bPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPackage_BModel() {
		return (EReference)bPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPackage_BEnums() {
		return (EReference)bPackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPackage_BDataTypes() {
		return (EReference)bPackageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPackage_BClasses() {
		return (EReference)bPackageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPackage_NestedBPackages() {
		return (EReference)bPackageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPackage_BClassifiers() {
		return (EReference)bPackageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBClass() {
		return bClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBClass_EcoreClass() {
		return (EReference)bClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBClass_BFeatures() {
		return (EReference)bClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBClass_BOperations() {
		return (EReference)bClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBFeature() {
		return bFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFeature_BClass() {
		return (EReference)bFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFeature_EcoreFeature() {
		return (EReference)bFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBEnum() {
		return bEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBEnum_EcoreEnum() {
		return (EReference)bEnumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBEnum_BEnumLiterals() {
		return (EReference)bEnumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBEnumLiteral() {
		return bEnumLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBEnumLiteral_BEnum() {
		return (EReference)bEnumLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBEnumLiteral_EcoreEnumLiteral() {
		return (EReference)bEnumLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBClassifier() {
		return bClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBClassifier_BPackage() {
		return (EReference)bClassifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBClassifier_BTypeParameters() {
		return (EReference)bClassifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBDataType() {
		return bDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBDataType_EcoreDataType() {
		return (EReference)bDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBOperation() {
		return bOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBOperation_BClass() {
		return (EReference)bOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBOperation_EcoreOperation() {
		return (EReference)bOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBOperation_BParameters() {
		return (EReference)bOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBOperation_BTypeParameters() {
		return (EReference)bOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBParameter() {
		return bParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBParameter_BOperation() {
		return (EReference)bParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBParameter_EcoreParameter() {
		return (EReference)bParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBTypedElement() {
		return bTypedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBTypeParameter() {
		return bTypeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBTypeParameter_EcoreTypeParameter() {
		return (EReference)bTypeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorebindingFactory getEcorebindingFactory() {
		return (EcorebindingFactory)getEFactoryInstance();
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
		bBaseEClass = createEClass(BBASE);

		bModelEClass = createEClass(BMODEL);
		createEReference(bModelEClass, BMODEL__BPACKAGES);

		bPackageEClass = createEClass(BPACKAGE);
		createEReference(bPackageEClass, BPACKAGE__ECORE_PACKAGE);
		createEReference(bPackageEClass, BPACKAGE__BMODEL);
		createEReference(bPackageEClass, BPACKAGE__BENUMS);
		createEReference(bPackageEClass, BPACKAGE__BDATA_TYPES);
		createEReference(bPackageEClass, BPACKAGE__BCLASSES);
		createEReference(bPackageEClass, BPACKAGE__NESTED_BPACKAGES);
		createEReference(bPackageEClass, BPACKAGE__BCLASSIFIERS);

		bClassEClass = createEClass(BCLASS);
		createEReference(bClassEClass, BCLASS__ECORE_CLASS);
		createEReference(bClassEClass, BCLASS__BFEATURES);
		createEReference(bClassEClass, BCLASS__BOPERATIONS);

		bFeatureEClass = createEClass(BFEATURE);
		createEReference(bFeatureEClass, BFEATURE__BCLASS);
		createEReference(bFeatureEClass, BFEATURE__ECORE_FEATURE);

		bEnumEClass = createEClass(BENUM);
		createEReference(bEnumEClass, BENUM__ECORE_ENUM);
		createEReference(bEnumEClass, BENUM__BENUM_LITERALS);

		bEnumLiteralEClass = createEClass(BENUM_LITERAL);
		createEReference(bEnumLiteralEClass, BENUM_LITERAL__BENUM);
		createEReference(bEnumLiteralEClass, BENUM_LITERAL__ECORE_ENUM_LITERAL);

		bClassifierEClass = createEClass(BCLASSIFIER);
		createEReference(bClassifierEClass, BCLASSIFIER__BTYPE_PARAMETERS);
		createEReference(bClassifierEClass, BCLASSIFIER__BPACKAGE);

		bDataTypeEClass = createEClass(BDATA_TYPE);
		createEReference(bDataTypeEClass, BDATA_TYPE__ECORE_DATA_TYPE);

		bOperationEClass = createEClass(BOPERATION);
		createEReference(bOperationEClass, BOPERATION__BCLASS);
		createEReference(bOperationEClass, BOPERATION__ECORE_OPERATION);
		createEReference(bOperationEClass, BOPERATION__BPARAMETERS);
		createEReference(bOperationEClass, BOPERATION__BTYPE_PARAMETERS);

		bParameterEClass = createEClass(BPARAMETER);
		createEReference(bParameterEClass, BPARAMETER__BOPERATION);
		createEReference(bParameterEClass, BPARAMETER__ECORE_PARAMETER);

		bTypedElementEClass = createEClass(BTYPED_ELEMENT);

		bTypeParameterEClass = createEClass(BTYPE_PARAMETER);
		createEReference(bTypeParameterEClass, BTYPE_PARAMETER__ECORE_TYPE_PARAMETER);
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

		// Obtain other dependent packages
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bBaseEClass.getESuperTypes().add(theEnvironmentPackage.getBoundableElement());
		bModelEClass.getESuperTypes().add(this.getBBase());
		bPackageEClass.getESuperTypes().add(this.getBBase());
		bClassEClass.getESuperTypes().add(this.getBClassifier());
		bFeatureEClass.getESuperTypes().add(this.getBTypedElement());
		bEnumEClass.getESuperTypes().add(this.getBDataType());
		bEnumLiteralEClass.getESuperTypes().add(this.getBBase());
		bClassifierEClass.getESuperTypes().add(this.getBBase());
		bDataTypeEClass.getESuperTypes().add(this.getBClassifier());
		bOperationEClass.getESuperTypes().add(this.getBTypedElement());
		bParameterEClass.getESuperTypes().add(this.getBTypedElement());
		bTypedElementEClass.getESuperTypes().add(this.getBBase());
		bTypeParameterEClass.getESuperTypes().add(this.getBBase());

		// Initialize classes and features; add operations and parameters
		initEClass(bBaseEClass, BBase.class, "BBase", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bModelEClass, BModel.class, "BModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBModel_BPackages(), this.getBPackage(), this.getBPackage_BModel(), "bPackages", null, 0, -1, BModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bPackageEClass, BPackage.class, "BPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBPackage_EcorePackage(), theEcorePackage.getEPackage(), null, "ecorePackage", null, 1, 1, BPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBPackage_BModel(), this.getBModel(), this.getBModel_BPackages(), "bModel", null, 0, 1, BPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBPackage_BEnums(), this.getBEnum(), null, "bEnums", null, 0, -1, BPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBPackage_BDataTypes(), this.getBDataType(), null, "bDataTypes", null, 0, -1, BPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBPackage_BClasses(), this.getBClass(), null, "bClasses", null, 0, -1, BPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBPackage_NestedBPackages(), this.getBPackage(), null, "nestedBPackages", null, 0, -1, BPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBPackage_BClassifiers(), this.getBClassifier(), this.getBClassifier_BPackage(), "bClassifiers", null, 0, -1, BPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bClassEClass, BClass.class, "BClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBClass_EcoreClass(), theEcorePackage.getEClass(), null, "ecoreClass", null, 1, 1, BClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBClass_BFeatures(), this.getBFeature(), this.getBFeature_BClass(), "bFeatures", null, 0, -1, BClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBClass_BOperations(), this.getBOperation(), this.getBOperation_BClass(), "bOperations", null, 0, -1, BClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bFeatureEClass, BFeature.class, "BFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBFeature_BClass(), this.getBClass(), this.getBClass_BFeatures(), "bClass", null, 1, 1, BFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBFeature_EcoreFeature(), theEcorePackage.getEStructuralFeature(), null, "ecoreFeature", null, 1, 1, BFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bEnumEClass, BEnum.class, "BEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBEnum_EcoreEnum(), theEcorePackage.getEEnum(), null, "ecoreEnum", null, 1, 1, BEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBEnum_BEnumLiterals(), this.getBEnumLiteral(), this.getBEnumLiteral_BEnum(), "bEnumLiterals", null, 0, -1, BEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bEnumLiteralEClass, BEnumLiteral.class, "BEnumLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBEnumLiteral_BEnum(), this.getBEnum(), this.getBEnum_BEnumLiterals(), "bEnum", null, 1, 1, BEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBEnumLiteral_EcoreEnumLiteral(), theEcorePackage.getEEnumLiteral(), null, "ecoreEnumLiteral", null, 1, 1, BEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bClassifierEClass, BClassifier.class, "BClassifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBClassifier_BTypeParameters(), this.getBTypeParameter(), null, "bTypeParameters", null, 0, -1, BClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBClassifier_BPackage(), this.getBPackage(), this.getBPackage_BClassifiers(), "bPackage", null, 1, 1, BClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bDataTypeEClass, BDataType.class, "BDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBDataType_EcoreDataType(), theEcorePackage.getEDataType(), null, "ecoreDataType", null, 1, 1, BDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bOperationEClass, BOperation.class, "BOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBOperation_BClass(), this.getBClass(), this.getBClass_BOperations(), "bClass", null, 1, 1, BOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBOperation_EcoreOperation(), theEcorePackage.getEOperation(), null, "ecoreOperation", null, 1, 1, BOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBOperation_BParameters(), this.getBParameter(), this.getBParameter_BOperation(), "bParameters", null, 0, -1, BOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBOperation_BTypeParameters(), this.getBTypeParameter(), null, "bTypeParameters", null, 0, -1, BOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bParameterEClass, BParameter.class, "BParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBParameter_BOperation(), this.getBOperation(), this.getBOperation_BParameters(), "bOperation", null, 1, 1, BParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBParameter_EcoreParameter(), theEcorePackage.getEParameter(), null, "ecoreParameter", null, 1, 1, BParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bTypedElementEClass, BTypedElement.class, "BTypedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bTypeParameterEClass, BTypeParameter.class, "BTypeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBTypeParameter_EcoreTypeParameter(), theEcorePackage.getETypeParameter(), null, "ecoreTypeParameter", null, 1, 1, BTypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EcorebindingPackageImpl
