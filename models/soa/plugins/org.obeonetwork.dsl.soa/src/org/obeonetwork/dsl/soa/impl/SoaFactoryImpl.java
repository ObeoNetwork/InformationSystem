/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.SynchronizationKind;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.Wire;
import org.obeonetwork.dsl.soa.spec.InterfaceSpec;
import org.obeonetwork.dsl.soa.spec.ServiceSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SoaFactoryImpl extends EFactoryImpl implements SoaFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SoaFactory init() {
		try {
			SoaFactory theSoaFactory = (SoaFactory)EPackage.Registry.INSTANCE.getEFactory(SoaPackage.eNS_URI);
			if (theSoaFactory != null) {
				return theSoaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SoaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoaFactoryImpl() {
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
			case SoaPackage.SYSTEM: return (EObject)createSystem();
			case SoaPackage.COMPONENT: return (EObject)createComponent();
			case SoaPackage.SERVICE: return (EObject)createService();
			case SoaPackage.WIRE: return (EObject)createWire();
			case SoaPackage.BINDING: return (EObject)createBinding();
			case SoaPackage.INTERFACE: return (EObject)createInterface();
			case SoaPackage.OPERATION: return (EObject)createOperation();
			case SoaPackage.IMPLEMENTATION_COMPONENT: return (EObject)createImplementationComponent();
			case SoaPackage.PARAMETER: return (EObject)createParameter();
			case SoaPackage.PARAMETER_REST_DATA: return (EObject)createParameterRestData();
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
			case SoaPackage.INTERFACE_KIND:
				return createInterfaceKindFromString(eDataType, initialValue);
			case SoaPackage.SYNCHRONIZATION_KIND:
				return createSynchronizationKindFromString(eDataType, initialValue);
			case SoaPackage.BINDING_KIND:
				return createBindingKindFromString(eDataType, initialValue);
			case SoaPackage.OPERATION_KIND:
				return createOperationKindFromString(eDataType, initialValue);
			case SoaPackage.VERB:
				return createVerbFromString(eDataType, initialValue);
			case SoaPackage.PARAMETER_PASSING_MODE:
				return createParameterPassingModeFromString(eDataType, initialValue);
			case SoaPackage.EXPOSITION_KIND:
				return createExpositionKindFromString(eDataType, initialValue);
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
			case SoaPackage.INTERFACE_KIND:
				return convertInterfaceKindToString(eDataType, instanceValue);
			case SoaPackage.SYNCHRONIZATION_KIND:
				return convertSynchronizationKindToString(eDataType, instanceValue);
			case SoaPackage.BINDING_KIND:
				return convertBindingKindToString(eDataType, instanceValue);
			case SoaPackage.OPERATION_KIND:
				return convertOperationKindToString(eDataType, instanceValue);
			case SoaPackage.VERB:
				return convertVerbToString(eDataType, instanceValue);
			case SoaPackage.PARAMETER_PASSING_MODE:
				return convertParameterPassingModeToString(eDataType, instanceValue);
			case SoaPackage.EXPOSITION_KIND:
				return convertExpositionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.obeonetwork.dsl.soa.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated Not
	 */
	public Service createService() {
		ServiceImpl service = new ServiceSpec();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wire createWire() {
		WireImpl wire = new WireImpl();
		return wire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding createBinding() {
		BindingImpl binding = new BindingImpl();
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated Not
	 */
	public Interface createInterface() {
		InterfaceImpl interface_ = new InterfaceSpec();
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationComponent createImplementationComponent() {
		ImplementationComponentImpl implementationComponent = new ImplementationComponentImpl();
		return implementationComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterRestData createParameterRestData() {
		ParameterRestDataImpl parameterRestData = new ParameterRestDataImpl();
		return parameterRestData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InterfaceKind createInterfaceKindFromString(EDataType eDataType, String initialValue) {
		InterfaceKind result = InterfaceKind.get(initialValue);
		if (result == null)
			return InterfaceKind.REQUIRED_LITERAL;
//			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInterfaceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationKind createSynchronizationKindFromString(EDataType eDataType, String initialValue) {
		SynchronizationKind result = SynchronizationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSynchronizationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingKind createBindingKindFromString(EDataType eDataType, String initialValue) {
		BindingKind result = BindingKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBindingKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationKind createOperationKindFromString(EDataType eDataType, String initialValue) {
		OperationKind result = OperationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verb createVerbFromString(EDataType eDataType, String initialValue) {
		Verb result = Verb.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVerbToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterPassingMode createParameterPassingModeFromString(EDataType eDataType, String initialValue) {
		ParameterPassingMode result = ParameterPassingMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParameterPassingModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpositionKind createExpositionKindFromString(EDataType eDataType, String initialValue) {
		ExpositionKind result = ExpositionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExpositionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoaPackage getSoaPackage() {
		return (SoaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SoaPackage getPackage() {
		return SoaPackage.eINSTANCE;
	}

} //SoaFactoryImpl
