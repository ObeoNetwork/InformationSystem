/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.database.scaffold.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldFactory;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldPackage;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScaffoldPackageImpl extends EPackageImpl implements ScaffoldPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaffoldInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceabilityInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectToEObjectMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scaffoldTypeEEnum = null;

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
	 * @see fr.gouv.mindef.safran.database.scaffold.ScaffoldPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScaffoldPackageImpl() {
		super(eNS_URI, ScaffoldFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ScaffoldPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ScaffoldPackage init() {
		if (isInited) return (ScaffoldPackage)EPackage.Registry.INSTANCE.getEPackage(ScaffoldPackage.eNS_URI);

		// Obtain or create and register package
		ScaffoldPackageImpl theScaffoldPackage = (ScaffoldPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScaffoldPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScaffoldPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theScaffoldPackage.createPackageContents();

		// Initialize created meta-data
		theScaffoldPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScaffoldPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScaffoldPackage.eNS_URI, theScaffoldPackage);
		return theScaffoldPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScaffoldInfo() {
		return scaffoldInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScaffoldInfo_LeftObject() {
		return (EReference)scaffoldInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScaffoldInfo_RightObject() {
		return (EReference)scaffoldInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScaffoldInfo_LeftToRightAdditionalObjects() {
		return (EReference)scaffoldInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScaffoldInfo_RightToLeftAdditionalObjects() {
		return (EReference)scaffoldInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScaffoldInfo_TraceabilityInfos() {
		return (EReference)scaffoldInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceabilityInfo() {
		return traceabilityInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceabilityInfo_Left() {
		return (EReference)traceabilityInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceabilityInfo_Right() {
		return (EReference)traceabilityInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectToEObjectMap() {
		return eObjectToEObjectMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectToEObjectMap_Key() {
		return (EReference)eObjectToEObjectMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectToEObjectMap_Value() {
		return (EReference)eObjectToEObjectMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScaffoldType() {
		return scaffoldTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaffoldFactory getScaffoldFactory() {
		return (ScaffoldFactory)getEFactoryInstance();
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
		scaffoldInfoEClass = createEClass(SCAFFOLD_INFO);
		createEReference(scaffoldInfoEClass, SCAFFOLD_INFO__LEFT_OBJECT);
		createEReference(scaffoldInfoEClass, SCAFFOLD_INFO__RIGHT_OBJECT);
		createEReference(scaffoldInfoEClass, SCAFFOLD_INFO__LEFT_TO_RIGHT_ADDITIONAL_OBJECTS);
		createEReference(scaffoldInfoEClass, SCAFFOLD_INFO__RIGHT_TO_LEFT_ADDITIONAL_OBJECTS);
		createEReference(scaffoldInfoEClass, SCAFFOLD_INFO__TRACEABILITY_INFOS);

		traceabilityInfoEClass = createEClass(TRACEABILITY_INFO);
		createEReference(traceabilityInfoEClass, TRACEABILITY_INFO__LEFT);
		createEReference(traceabilityInfoEClass, TRACEABILITY_INFO__RIGHT);

		eObjectToEObjectMapEClass = createEClass(EOBJECT_TO_EOBJECT_MAP);
		createEReference(eObjectToEObjectMapEClass, EOBJECT_TO_EOBJECT_MAP__KEY);
		createEReference(eObjectToEObjectMapEClass, EOBJECT_TO_EOBJECT_MAP__VALUE);

		// Create enums
		scaffoldTypeEEnum = createEEnum(SCAFFOLD_TYPE);
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

		// Initialize classes and features; add operations and parameters
		initEClass(scaffoldInfoEClass, ScaffoldInfo.class, "ScaffoldInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScaffoldInfo_LeftObject(), ecorePackage.getEObject(), null, "leftObject", null, 1, 1, ScaffoldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScaffoldInfo_RightObject(), ecorePackage.getEObject(), null, "rightObject", null, 1, 1, ScaffoldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScaffoldInfo_LeftToRightAdditionalObjects(), ecorePackage.getEObject(), null, "leftToRightAdditionalObjects", null, 0, -1, ScaffoldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScaffoldInfo_RightToLeftAdditionalObjects(), ecorePackage.getEObject(), null, "rightToLeftAdditionalObjects", null, 0, -1, ScaffoldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScaffoldInfo_TraceabilityInfos(), this.getTraceabilityInfo(), null, "traceabilityInfos", null, 0, -1, ScaffoldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(scaffoldInfoEClass, this.getScaffoldType(), "getLeftToRightTransformationType", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(scaffoldInfoEClass, this.getScaffoldType(), "getRightToLeftTransformationType", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(scaffoldInfoEClass, ecorePackage.getEObject(), "getStartingObjectForTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, ecorePackage.getEObject(), "getEndingObjectForTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, ecorePackage.getEObject(), "getAdditionalObjectsForTransformation", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, null, "setStartingObjectForTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, null, "setEndingObjectForTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, null, "clearAdditionalObjectsForTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, null, "addAdditionalObjectsForTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, this.getEObjectToEObjectMap(), "getTraceabilityMap", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scaffoldInfoEClass, null, "replaceTraceabilityInfos", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScaffoldType(), "scaffoldType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEObjectToEObjectMap(), "infos", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(traceabilityInfoEClass, TraceabilityInfo.class, "TraceabilityInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceabilityInfo_Left(), ecorePackage.getEObject(), null, "left", null, 1, 1, TraceabilityInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceabilityInfo_Right(), ecorePackage.getEObject(), null, "right", null, 1, 1, TraceabilityInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectToEObjectMapEClass, Map.Entry.class, "EObjectToEObjectMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectToEObjectMap_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectToEObjectMap_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(scaffoldTypeEEnum, ScaffoldType.class, "ScaffoldType");
		addEEnumLiteral(scaffoldTypeEEnum, ScaffoldType.ENTITY_TO_MLD);
		addEEnumLiteral(scaffoldTypeEEnum, ScaffoldType.MLD_TO_ENTITY);
		addEEnumLiteral(scaffoldTypeEEnum, ScaffoldType.MPD_TO_MLD);
		addEEnumLiteral(scaffoldTypeEEnum, ScaffoldType.MLD_TO_MPD);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getScaffoldInfo_TraceabilityInfos(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ti"
		   });
	}

} //ScaffoldPackageImpl
