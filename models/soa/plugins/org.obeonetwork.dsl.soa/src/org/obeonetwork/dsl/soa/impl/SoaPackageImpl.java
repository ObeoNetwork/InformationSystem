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
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.soa.ApiKeyLocation;
import org.obeonetwork.dsl.soa.Binding;
import org.obeonetwork.dsl.soa.BindingKind;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.ImplementationComponent;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.OperationKind;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.ParameterRestData;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.SynchronizationKind;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.Wire;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SoaPackageImpl extends EPackageImpl implements SoaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterRestDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securitySchemeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interfaceKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum synchronizationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bindingKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum verbEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum parameterPassingModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum expositionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum securitySchemeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum apiKeyLocationEEnum = null;

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
	 * @see org.obeonetwork.dsl.soa.SoaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SoaPackageImpl() {
		super(eNS_URI, SoaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SoaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SoaPackage init() {
		if (isInited) return (SoaPackage)EPackage.Registry.INSTANCE.getEPackage(SoaPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSoaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SoaPackageImpl theSoaPackage = registeredSoaPackage instanceof SoaPackageImpl ? (SoaPackageImpl)registeredSoaPackage : new SoaPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSoaPackage.createPackageContents();

		// Initialize created meta-data
		theSoaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSoaPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SoaPackage.eNS_URI, theSoaPackage);
		return theSoaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_OwnedComponents() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_OwnedWires() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_OwnedServices() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_RequiredServices() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ProvidedServices() {
		return (EReference)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Implementations() {
		return (EReference)componentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Name() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_OwnedBinding() {
		return (EReference)componentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Block() {
		return (EReference)componentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_URI() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_URL() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_ApiVersion() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Deprecated() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_SecuritySchemes() {
		return (EReference)componentEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_OwnedInterface() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Synchronization() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Kind() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ReferencedInterface() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Bindings() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Name() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_UsedTypes() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_URI() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWire() {
		return wireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWire_Source() {
		return (EReference)wireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWire_Dest() {
		return (EReference)wireEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinding_Technology() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_OwnedOperations() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_Name() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Input() {
		return (EReference)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Output() {
		return (EReference)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Kind() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Public() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Fault() {
		return (EReference)operationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_URI() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Verb() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Exposition() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Paged() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_SecuritySchemes() {
		return (EReference)operationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationComponent() {
		return implementationComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationComponent_Implement() {
		return (EReference)implementationComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationComponent_Entities() {
		return (EReference)implementationComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Type() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Multiplicity() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_IsUnique() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_IsOrdered() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_StatusCode() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_StatusMessage() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_RestData() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterRestData() {
		return parameterRestDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterRestData_PassingMode() {
		return (EAttribute)parameterRestDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterRestData_RestId() {
		return (EAttribute)parameterRestDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityScheme() {
		return securitySchemeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecurityScheme_Key() {
		return (EAttribute)securitySchemeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecurityScheme_Type() {
		return (EAttribute)securitySchemeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecurityScheme_Name() {
		return (EAttribute)securitySchemeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecurityScheme_ApiKeyLocation() {
		return (EAttribute)securitySchemeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInterfaceKind() {
		return interfaceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSynchronizationKind() {
		return synchronizationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBindingKind() {
		return bindingKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperationKind() {
		return operationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVerb() {
		return verbEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterPassingMode() {
		return parameterPassingModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExpositionKind() {
		return expositionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSecuritySchemeType() {
		return securitySchemeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getApiKeyLocation() {
		return apiKeyLocationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoaFactory getSoaFactory() {
		return (SoaFactory)getEFactoryInstance();
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
		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__OWNED_COMPONENTS);
		createEReference(systemEClass, SYSTEM__OWNED_WIRES);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__OWNED_SERVICES);
		createEReference(componentEClass, COMPONENT__REQUIRED_SERVICES);
		createEReference(componentEClass, COMPONENT__PROVIDED_SERVICES);
		createEReference(componentEClass, COMPONENT__IMPLEMENTATIONS);
		createEAttribute(componentEClass, COMPONENT__NAME);
		createEReference(componentEClass, COMPONENT__OWNED_BINDING);
		createEReference(componentEClass, COMPONENT__BLOCK);
		createEAttribute(componentEClass, COMPONENT__URI);
		createEAttribute(componentEClass, COMPONENT__URL);
		createEAttribute(componentEClass, COMPONENT__API_VERSION);
		createEAttribute(componentEClass, COMPONENT__DEPRECATED);
		createEReference(componentEClass, COMPONENT__SECURITY_SCHEMES);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__OWNED_INTERFACE);
		createEAttribute(serviceEClass, SERVICE__SYNCHRONIZATION);
		createEAttribute(serviceEClass, SERVICE__KIND);
		createEReference(serviceEClass, SERVICE__REFERENCED_INTERFACE);
		createEReference(serviceEClass, SERVICE__BINDINGS);
		createEAttribute(serviceEClass, SERVICE__NAME);
		createEReference(serviceEClass, SERVICE__USED_TYPES);
		createEAttribute(serviceEClass, SERVICE__URI);

		wireEClass = createEClass(WIRE);
		createEReference(wireEClass, WIRE__SOURCE);
		createEReference(wireEClass, WIRE__DEST);

		bindingEClass = createEClass(BINDING);
		createEAttribute(bindingEClass, BINDING__TECHNOLOGY);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__OWNED_OPERATIONS);
		createEAttribute(interfaceEClass, INTERFACE__NAME);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__INPUT);
		createEReference(operationEClass, OPERATION__OUTPUT);
		createEAttribute(operationEClass, OPERATION__KIND);
		createEAttribute(operationEClass, OPERATION__PUBLIC);
		createEReference(operationEClass, OPERATION__FAULT);
		createEAttribute(operationEClass, OPERATION__URI);
		createEAttribute(operationEClass, OPERATION__VERB);
		createEAttribute(operationEClass, OPERATION__EXPOSITION);
		createEAttribute(operationEClass, OPERATION__PAGED);
		createEReference(operationEClass, OPERATION__SECURITY_SCHEMES);

		implementationComponentEClass = createEClass(IMPLEMENTATION_COMPONENT);
		createEReference(implementationComponentEClass, IMPLEMENTATION_COMPONENT__IMPLEMENT);
		createEReference(implementationComponentEClass, IMPLEMENTATION_COMPONENT__ENTITIES);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__TYPE);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__MULTIPLICITY);
		createEAttribute(parameterEClass, PARAMETER__IS_UNIQUE);
		createEAttribute(parameterEClass, PARAMETER__IS_ORDERED);
		createEAttribute(parameterEClass, PARAMETER__STATUS_CODE);
		createEAttribute(parameterEClass, PARAMETER__STATUS_MESSAGE);
		createEReference(parameterEClass, PARAMETER__REST_DATA);

		parameterRestDataEClass = createEClass(PARAMETER_REST_DATA);
		createEAttribute(parameterRestDataEClass, PARAMETER_REST_DATA__PASSING_MODE);
		createEAttribute(parameterRestDataEClass, PARAMETER_REST_DATA__REST_ID);

		securitySchemeEClass = createEClass(SECURITY_SCHEME);
		createEAttribute(securitySchemeEClass, SECURITY_SCHEME__KEY);
		createEAttribute(securitySchemeEClass, SECURITY_SCHEME__TYPE);
		createEAttribute(securitySchemeEClass, SECURITY_SCHEME__NAME);
		createEAttribute(securitySchemeEClass, SECURITY_SCHEME__API_KEY_LOCATION);

		// Create enums
		interfaceKindEEnum = createEEnum(INTERFACE_KIND);
		synchronizationKindEEnum = createEEnum(SYNCHRONIZATION_KIND);
		bindingKindEEnum = createEEnum(BINDING_KIND);
		operationKindEEnum = createEEnum(OPERATION_KIND);
		verbEEnum = createEEnum(VERB);
		parameterPassingModeEEnum = createEEnum(PARAMETER_PASSING_MODE);
		expositionKindEEnum = createEEnum(EXPOSITION_KIND);
		securitySchemeTypeEEnum = createEEnum(SECURITY_SCHEME_TYPE);
		apiKeyLocationEEnum = createEEnum(API_KEY_LOCATION);
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
		TechnicalIDPackage theTechnicalIDPackage = (TechnicalIDPackage)EPackage.Registry.INSTANCE.getEPackage(TechnicalIDPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		systemEClass.getESuperTypes().add(theEnvironmentPackage.getNamespace());
		componentEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		serviceEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		wireEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		bindingEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		interfaceEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		operationEClass.getESuperTypes().add(theEnvironmentPackage.getAction());
		implementationComponentEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		parameterEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		parameterRestDataEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		securitySchemeEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());

		// Initialize classes and features; add operations and parameters
		initEClass(systemEClass, org.obeonetwork.dsl.soa.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_OwnedComponents(), this.getComponent(), null, "ownedComponents", null, 0, -1, org.obeonetwork.dsl.soa.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_OwnedWires(), this.getWire(), null, "ownedWires", null, 0, -1, org.obeonetwork.dsl.soa.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_OwnedServices(), this.getService(), null, "ownedServices", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_RequiredServices(), this.getService(), null, "requiredServices", null, 0, -1, Component.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ProvidedServices(), this.getService(), null, "providedServices", null, 0, -1, Component.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Implementations(), this.getImplementationComponent(), null, "implementations", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Name(), ecorePackage.getEString(), "name", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_OwnedBinding(), this.getBinding(), null, "ownedBinding", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Block(), theEnvironmentPackage.getTypesDefinition(), null, "block", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_URI(), ecorePackage.getEString(), "URI", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_URL(), ecorePackage.getEString(), "URL", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_ApiVersion(), ecorePackage.getEString(), "apiVersion", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Deprecated(), ecorePackage.getEBoolean(), "deprecated", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_SecuritySchemes(), this.getSecurityScheme(), null, "securitySchemes", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_OwnedInterface(), this.getInterface(), null, "ownedInterface", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Synchronization(), this.getSynchronizationKind(), "synchronization", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Kind(), this.getInterfaceKind(), "kind", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_ReferencedInterface(), this.getInterface(), null, "referencedInterface", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Bindings(), this.getBinding(), null, "bindings", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Name(), ecorePackage.getEString(), "name", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_UsedTypes(), theEnvironmentPackage.getType(), null, "usedTypes", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_URI(), ecorePackage.getEString(), "URI", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wireEClass, Wire.class, "Wire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWire_Source(), this.getService(), null, "source", null, 0, 1, Wire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWire_Dest(), this.getService(), null, "dest", null, 0, 1, Wire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingEClass, Binding.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinding_Technology(), this.getBindingKind(), "technology", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_OwnedOperations(), this.getOperation(), null, "ownedOperations", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_Name(), ecorePackage.getEString(), "name", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Input(), this.getParameter(), null, "input", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Output(), this.getParameter(), null, "output", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Kind(), this.getOperationKind(), "kind", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Public(), ecorePackage.getEBoolean(), "public", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Fault(), this.getParameter(), null, "fault", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_URI(), ecorePackage.getEString(), "URI", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Verb(), this.getVerb(), "verb", "GET", 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Exposition(), this.getExpositionKind(), "exposition", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Paged(), ecorePackage.getEBoolean(), "paged", "false", 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_SecuritySchemes(), this.getSecurityScheme(), null, "securitySchemes", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementationComponentEClass, ImplementationComponent.class, "ImplementationComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImplementationComponent_Implement(), this.getInterface(), null, "implement", null, 0, 1, ImplementationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImplementationComponent_Entities(), theEnvironmentPackage.getTypesDefinition(), null, "entities", null, 0, 1, ImplementationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Type(), theEnvironmentPackage.getType(), null, "type", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Multiplicity(), theEnvironmentPackage.getMultiplicityKind(), "multiplicity", "1", 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_IsUnique(), ecorePackage.getEBoolean(), "isUnique", "false", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", "false", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_StatusCode(), ecorePackage.getEString(), "statusCode", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_StatusMessage(), ecorePackage.getEString(), "statusMessage", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_RestData(), this.getParameterRestData(), null, "restData", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterRestDataEClass, ParameterRestData.class, "ParameterRestData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterRestData_PassingMode(), this.getParameterPassingMode(), "passingMode", null, 0, 1, ParameterRestData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterRestData_RestId(), ecorePackage.getEString(), "restId", null, 0, 1, ParameterRestData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securitySchemeEClass, SecurityScheme.class, "SecurityScheme", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecurityScheme_Key(), ecorePackage.getEString(), "key", null, 0, 1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecurityScheme_Type(), this.getSecuritySchemeType(), "type", null, 0, 1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecurityScheme_Name(), ecorePackage.getEString(), "name", null, 0, 1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecurityScheme_ApiKeyLocation(), this.getApiKeyLocation(), "apiKeyLocation", null, 0, 1, SecurityScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(interfaceKindEEnum, InterfaceKind.class, "InterfaceKind");
		addEEnumLiteral(interfaceKindEEnum, InterfaceKind.PROVIDED_LITERAL);
		addEEnumLiteral(interfaceKindEEnum, InterfaceKind.REQUIRED_LITERAL);

		initEEnum(synchronizationKindEEnum, SynchronizationKind.class, "SynchronizationKind");
		addEEnumLiteral(synchronizationKindEEnum, SynchronizationKind.SYNCHRONOUS_LITERAL);
		addEEnumLiteral(synchronizationKindEEnum, SynchronizationKind.ASYNCHRONOUS_LITERAL);

		initEEnum(bindingKindEEnum, BindingKind.class, "BindingKind");
		addEEnumLiteral(bindingKindEEnum, BindingKind.WEBSERVICE_LITERAL);
		addEEnumLiteral(bindingKindEEnum, BindingKind.RMI_LITERAL);
		addEEnumLiteral(bindingKindEEnum, BindingKind.CORBA_LITERAL);
		addEEnumLiteral(bindingKindEEnum, BindingKind.EJB_LITERAL);
		addEEnumLiteral(bindingKindEEnum, BindingKind.JAVA_LITERAL);

		initEEnum(operationKindEEnum, OperationKind.class, "OperationKind");
		addEEnumLiteral(operationKindEEnum, OperationKind.REQUEST_RESPONSE_LITERAL);
		addEEnumLiteral(operationKindEEnum, OperationKind.ONE_WAY_LITERAL);

		initEEnum(verbEEnum, Verb.class, "Verb");
		addEEnumLiteral(verbEEnum, Verb.GET);
		addEEnumLiteral(verbEEnum, Verb.POST);
		addEEnumLiteral(verbEEnum, Verb.PUT);
		addEEnumLiteral(verbEEnum, Verb.DELETE);
		addEEnumLiteral(verbEEnum, Verb.HEAD);
		addEEnumLiteral(verbEEnum, Verb.OPTIONS);
		addEEnumLiteral(verbEEnum, Verb.PATCH);
		addEEnumLiteral(verbEEnum, Verb.TRACE);

		initEEnum(parameterPassingModeEEnum, ParameterPassingMode.class, "ParameterPassingMode");
		addEEnumLiteral(parameterPassingModeEEnum, ParameterPassingMode.BODY);
		addEEnumLiteral(parameterPassingModeEEnum, ParameterPassingMode.PATH);
		addEEnumLiteral(parameterPassingModeEEnum, ParameterPassingMode.QUERY);
		addEEnumLiteral(parameterPassingModeEEnum, ParameterPassingMode.COOKIE);
		addEEnumLiteral(parameterPassingModeEEnum, ParameterPassingMode.HEADER);

		initEEnum(expositionKindEEnum, ExpositionKind.class, "ExpositionKind");
		addEEnumLiteral(expositionKindEEnum, ExpositionKind.NONE);
		addEEnumLiteral(expositionKindEEnum, ExpositionKind.REST);
		addEEnumLiteral(expositionKindEEnum, ExpositionKind.SOAP);

		initEEnum(securitySchemeTypeEEnum, SecuritySchemeType.class, "SecuritySchemeType");
		addEEnumLiteral(securitySchemeTypeEEnum, SecuritySchemeType.API_KEY);
		addEEnumLiteral(securitySchemeTypeEEnum, SecuritySchemeType.HTTP);
		addEEnumLiteral(securitySchemeTypeEEnum, SecuritySchemeType.OAUTH2);
		addEEnumLiteral(securitySchemeTypeEEnum, SecuritySchemeType.OPEN_ID_CONNECT);

		initEEnum(apiKeyLocationEEnum, ApiKeyLocation.class, "ApiKeyLocation");
		addEEnumLiteral(apiKeyLocationEEnum, ApiKeyLocation.QUERY);
		addEEnumLiteral(apiKeyLocationEEnum, ApiKeyLocation.HEADER);
		addEEnumLiteral(apiKeyLocationEEnum, ApiKeyLocation.COOKIE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";
		addAnnotation
		  (getSystem_OwnedComponents(),
		   source,
		   new String[] {
			   "documentation", "The list of owned components."
		   });
		addAnnotation
		  (getSystem_OwnedWires(),
		   source,
		   new String[] {
			   "documentation", "The list of owned wires."
		   });
		addAnnotation
		  (getComponent_OwnedServices(),
		   source,
		   new String[] {
			   "documentation", "The list of owned services."
		   });
		addAnnotation
		  (getComponent_RequiredServices(),
		   source,
		   new String[] {
			   "documentation", "The list of required services."
		   });
		addAnnotation
		  (getComponent_ProvidedServices(),
		   source,
		   new String[] {
			   "documentation", "The list of provided services."
		   });
		addAnnotation
		  (getComponent_Implementations(),
		   source,
		   new String[] {
			   "documentation", "The list of implementations."
		   });
		addAnnotation
		  (getComponent_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of the component."
		   });
		addAnnotation
		  (getComponent_OwnedBinding(),
		   source,
		   new String[] {
			   "documentation", "The list of owned bindings."
		   });
		addAnnotation
		  (getComponent_Block(),
		   source,
		   new String[] {
			   "documentation", "The list of block type definitions."
		   });
		addAnnotation
		  (getComponent_URI(),
		   source,
		   new String[] {
			   "documentation", "The exposition URI of this component."
		   });
		addAnnotation
		  (getComponent_URL(),
		   source,
		   new String[] {
			   "documentation", "The exposition URL of this component."
		   });
		addAnnotation
		  (getComponent_Deprecated(),
		   source,
		   new String[] {
			   "documentation", "Tells if this Component is deprecated."
		   });
		addAnnotation
		  (getService_OwnedInterface(),
		   source,
		   new String[] {
			   "documentation", "The owned interface."
		   });
		addAnnotation
		  (getService_Synchronization(),
		   source,
		   new String[] {
			   "documentation", "The kind of synchronization."
		   });
		addAnnotation
		  (getService_Kind(),
		   source,
		   new String[] {
			   "documentation", "The kind of interface."
		   });
		addAnnotation
		  (getService_ReferencedInterface(),
		   source,
		   new String[] {
			   "documentation", "The referenced interface."
		   });
		addAnnotation
		  (getService_Bindings(),
		   source,
		   new String[] {
			   "documentation", "The binding."
		   });
		addAnnotation
		  (getService_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of the service."
		   });
		addAnnotation
		  (getService_UsedTypes(),
		   source,
		   new String[] {
			   "documentation", "The list of used types."
		   });
		addAnnotation
		  (getService_URI(),
		   source,
		   new String[] {
			   "documentation", "The exposition URI of this service."
		   });
		addAnnotation
		  (getWire_Source(),
		   source,
		   new String[] {
			   "documentation", "The source service."
		   });
		addAnnotation
		  (getWire_Dest(),
		   source,
		   new String[] {
			   "documentation", "The target service."
		   });
		addAnnotation
		  (getBinding_Technology(),
		   source,
		   new String[] {
			   "documentation", "The binding kind."
		   });
		addAnnotation
		  (getInterface_OwnedOperations(),
		   source,
		   new String[] {
			   "documentation", "The list of owned operations."
		   });
		addAnnotation
		  (getInterface_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of the interface."
		   });
		addAnnotation
		  (getOperation_Input(),
		   source,
		   new String[] {
			   "documentation", "The list of input parameters."
		   });
		addAnnotation
		  (getOperation_Output(),
		   source,
		   new String[] {
			   "documentation", "The list of output parameters"
		   });
		addAnnotation
		  (getOperation_Kind(),
		   source,
		   new String[] {
			   "documentation", "The kind of operation."
		   });
		addAnnotation
		  (getOperation_Public(),
		   source,
		   new String[] {
			   "documentation", "Tells if the operation is public."
		   });
		addAnnotation
		  (getOperation_Fault(),
		   source,
		   new String[] {
			   "documentation", "The list of fault parameters."
		   });
		addAnnotation
		  (getOperation_URI(),
		   source,
		   new String[] {
			   "documentation", "The exposition URI of this operation."
		   });
		addAnnotation
		  (getOperation_Verb(),
		   source,
		   new String[] {
			   "documentation", "The HTTP verb of this operation."
		   });
		addAnnotation
		  (getOperation_Exposition(),
		   source,
		   new String[] {
			   "documentation", "The kind of exposition or NONE if not exposed."
		   });
		addAnnotation
		  (getOperation_Paged(),
		   source,
		   new String[] {
			   "documentation", "Tells if this operation is paged."
		   });
		addAnnotation
		  (getImplementationComponent_Implement(),
		   source,
		   new String[] {
			   "documentation", "The implemented interface."
		   });
		addAnnotation
		  (getImplementationComponent_Entities(),
		   source,
		   new String[] {
			   "documentation", "The type definition."
		   });
		addAnnotation
		  (getParameter_Type(),
		   source,
		   new String[] {
			   "documentation", "The type of the parameter."
		   });
		addAnnotation
		  (getParameter_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of the parameter."
		   });
		addAnnotation
		  (getParameter_Multiplicity(),
		   source,
		   new String[] {
			   "documentation", "The multiplicity of the parameter."
		   });
		addAnnotation
		  (getParameter_IsUnique(),
		   source,
		   new String[] {
			   "documentation", "Tells if the parameter contains duplicates."
		   });
		addAnnotation
		  (getParameter_IsOrdered(),
		   source,
		   new String[] {
			   "documentation", "Tells if the parameter is ordered."
		   });
		addAnnotation
		  (getParameter_StatusCode(),
		   source,
		   new String[] {
			   "documentation", "The status code associated with this parameter."
		   });
		addAnnotation
		  (getParameter_StatusMessage(),
		   source,
		   new String[] {
			   "documentation", "The status message associated with this parameter."
		   });
		addAnnotation
		  (getParameterRestData_PassingMode(),
		   source,
		   new String[] {
			   "documentation", "The parameter passing mode."
		   });
		addAnnotation
		  (getSecurityScheme_Key(),
		   source,
		   new String[] {
			   "documentation", "The unique id of the Security Scheme, used in the OpenAPI serialization format."
		   });
		addAnnotation
		  (getSecurityScheme_Type(),
		   source,
		   new String[] {
			   "documentation", "The type of the security scheme."
		   });
		addAnnotation
		  (getSecurityScheme_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of the header, query or cookie parameter to be used."
		   });
		addAnnotation
		  (getSecurityScheme_ApiKeyLocation(),
		   source,
		   new String[] {
			   "documentation", "The location of the API key. (Named \"in\" in the OpenAPI specification)."
		   });
	}

} //SoaPackageImpl
