/**
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

import fr.gouv.mindef.safran.graalextensions.BenefitsLevel;
import fr.gouv.mindef.safran.graalextensions.DrawbacksLevel;
import fr.gouv.mindef.safran.graalextensions.GraalExtensionsFactory;
import fr.gouv.mindef.safran.graalextensions.GraalExtensionsPackage;
import fr.gouv.mindef.safran.graalextensions.Risk;
import fr.gouv.mindef.safran.graalextensions.RiskLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraalExtensionsPackageImpl extends EPackageImpl implements GraalExtensionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2012 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass riskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum benefitsLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum drawbacksLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum riskLevelEEnum = null;

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
	 * @see fr.gouv.mindef.safran.graalextensions.GraalExtensionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraalExtensionsPackageImpl() {
		super(eNS_URI, GraalExtensionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraalExtensionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraalExtensionsPackage init() {
		if (isInited) return (GraalExtensionsPackage)EPackage.Registry.INSTANCE.getEPackage(GraalExtensionsPackage.eNS_URI);

		// Obtain or create and register package
		GraalExtensionsPackageImpl theGraalExtensionsPackage = (GraalExtensionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraalExtensionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraalExtensionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraalExtensionsPackage.createPackageContents();

		// Initialize created meta-data
		theGraalExtensionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraalExtensionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraalExtensionsPackage.eNS_URI, theGraalExtensionsPackage);
		return theGraalExtensionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRisk() {
		return riskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRisk_Benefits() {
		return (EAttribute)riskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRisk_Drawbacks() {
		return (EAttribute)riskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRisk_Risk() {
		return (EAttribute)riskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBenefitsLevel() {
		return benefitsLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDrawbacksLevel() {
		return drawbacksLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRiskLevel() {
		return riskLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalExtensionsFactory getGraalExtensionsFactory() {
		return (GraalExtensionsFactory)getEFactoryInstance();
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
		riskEClass = createEClass(RISK);
		createEAttribute(riskEClass, RISK__BENEFITS);
		createEAttribute(riskEClass, RISK__DRAWBACKS);
		createEAttribute(riskEClass, RISK__RISK);

		// Create enums
		benefitsLevelEEnum = createEEnum(BENEFITS_LEVEL);
		drawbacksLevelEEnum = createEEnum(DRAWBACKS_LEVEL);
		riskLevelEEnum = createEEnum(RISK_LEVEL);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		riskEClass.getESuperTypes().add(theEnvironmentPackage.getMetaData());

		// Initialize classes and features; add operations and parameters
		initEClass(riskEClass, Risk.class, "Risk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRisk_Benefits(), this.getBenefitsLevel(), "benefits", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRisk_Drawbacks(), this.getDrawbacksLevel(), "drawbacks", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRisk_Risk(), this.getRiskLevel(), "risk", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(benefitsLevelEEnum, BenefitsLevel.class, "BenefitsLevel");
		addEEnumLiteral(benefitsLevelEEnum, BenefitsLevel.UNDEFINED);
		addEEnumLiteral(benefitsLevelEEnum, BenefitsLevel._1);
		addEEnumLiteral(benefitsLevelEEnum, BenefitsLevel._2);
		addEEnumLiteral(benefitsLevelEEnum, BenefitsLevel._3);
		addEEnumLiteral(benefitsLevelEEnum, BenefitsLevel._4);
		addEEnumLiteral(benefitsLevelEEnum, BenefitsLevel._5);

		initEEnum(drawbacksLevelEEnum, DrawbacksLevel.class, "DrawbacksLevel");
		addEEnumLiteral(drawbacksLevelEEnum, DrawbacksLevel.UNDEFINED);
		addEEnumLiteral(drawbacksLevelEEnum, DrawbacksLevel._1);
		addEEnumLiteral(drawbacksLevelEEnum, DrawbacksLevel._2);
		addEEnumLiteral(drawbacksLevelEEnum, DrawbacksLevel._3);
		addEEnumLiteral(drawbacksLevelEEnum, DrawbacksLevel._4);
		addEEnumLiteral(drawbacksLevelEEnum, DrawbacksLevel._5);

		initEEnum(riskLevelEEnum, RiskLevel.class, "RiskLevel");
		addEEnumLiteral(riskLevelEEnum, RiskLevel.UNDEFINED);
		addEEnumLiteral(riskLevelEEnum, RiskLevel._1);
		addEEnumLiteral(riskLevelEEnum, RiskLevel._2);
		addEEnumLiteral(riskLevelEEnum, RiskLevel._3);
		addEEnumLiteral(riskLevelEEnum, RiskLevel._4);
		addEEnumLiteral(riskLevelEEnum, RiskLevel._5);

		// Create resource
		createResource(eNS_URI);
	}

} //GraalExtensionsPackageImpl
