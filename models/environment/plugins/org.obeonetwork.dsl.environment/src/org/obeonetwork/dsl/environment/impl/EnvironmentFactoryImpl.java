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
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.obeonetwork.dsl.environment.*;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.FilterContainer;
import org.obeonetwork.dsl.environment.InterDSMLink;
import org.obeonetwork.dsl.environment.Literal;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.Priority;
import org.obeonetwork.dsl.environment.PriorityDefinition;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.spec.ReferenceSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentFactoryImpl extends EFactoryImpl implements EnvironmentFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnvironmentFactory init() {
		try {
			EnvironmentFactory theEnvironmentFactory = (EnvironmentFactory) EPackage.Registry.INSTANCE
					.getEFactory(EnvironmentPackage.eNS_URI);
			if (theEnvironmentFactory != null) {
				return theEnvironmentFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EnvironmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentFactoryImpl() {
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
		case EnvironmentPackage.ENVIRONMENT:
			return (EObject) createEnvironment();
		case EnvironmentPackage.PRIMITIVE_TYPE:
			return (EObject) createPrimitiveType();
		case EnvironmentPackage.ENUMERATION:
			return (EObject) createEnumeration();
		case EnvironmentPackage.LITERAL:
			return (EObject) createLiteral();
		case EnvironmentPackage.INTER_DSM_LINK:
			return (EObject) createInterDSMLink();
		case EnvironmentPackage.META_DATA_CONTAINER:
			return (EObject) createMetaDataContainer();
		case EnvironmentPackage.ANNOTATION:
			return (EObject) createAnnotation();
		case EnvironmentPackage.PRIORITY_DEFINITION:
			return (EObject) createPriorityDefinition();
		case EnvironmentPackage.PRIORITY:
			return (EObject) createPriority();
		case EnvironmentPackage.TYPES_DEFINITION:
			return (EObject) createTypesDefinition();
		case EnvironmentPackage.DTO:
			return (EObject) createDTO();
		case EnvironmentPackage.FILTER_CONTAINER:
			return (EObject) createFilterContainer();
		case EnvironmentPackage.NAMESPACE:
			return (EObject) createNamespace();
		case EnvironmentPackage.ATTRIBUTE:
			return (EObject) createAttribute();
		case EnvironmentPackage.REFERENCE:
			return (EObject) createReference();
		case EnvironmentPackage.BINDING_INFO:
			return (EObject) createBindingInfo();
		case EnvironmentPackage.BINDING_REFERENCE:
			return (EObject) createBindingReference();
		case EnvironmentPackage.BINDING_ELEMENT:
			return (EObject) createBindingElement();
		case EnvironmentPackage.BINDING_REGISTRY:
			return (EObject) createBindingRegistry();
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
		case EnvironmentPackage.MULTIPLICITY_KIND:
			return createMultiplicityKindFromString(eDataType, initialValue);
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
		case EnvironmentPackage.MULTIPLICITY_KIND:
			return convertMultiplicityKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment createEnvironment() {
		EnvironmentImpl environment = new EnvironmentImpl();
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterDSMLink createInterDSMLink() {
		InterDSMLinkImpl interDSMLink = new InterDSMLinkImpl();
		return interDSMLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataContainer createMetaDataContainer() {
		MetaDataContainerImpl metaDataContainer = new MetaDataContainerImpl();
		return metaDataContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityDefinition createPriorityDefinition() {
		PriorityDefinitionImpl priorityDefinition = new PriorityDefinitionImpl();
		return priorityDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority createPriority() {
		PriorityImpl priority = new PriorityImpl();
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesDefinition createTypesDefinition() {
		TypesDefinitionImpl typesDefinition = new TypesDefinitionImpl();
		return typesDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTO createDTO() {
		DTOImpl dto = new DTOImpl();
		return dto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterContainer createFilterContainer() {
		FilterContainerImpl filterContainer = new FilterContainerImpl();
		return filterContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace createNamespace() {
		NamespaceImpl namespace = new NamespaceImpl();
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Reference createReference() {
		Reference reference = new ReferenceSpec();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingInfo createBindingInfo() {
		BindingInfoImpl bindingInfo = new BindingInfoImpl();
		return bindingInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingReference createBindingReference() {
		BindingReferenceImpl bindingReference = new BindingReferenceImpl();
		return bindingReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingElement createBindingElement() {
		BindingElementImpl bindingElement = new BindingElementImpl();
		return bindingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingRegistry createBindingRegistry() {
		BindingRegistryImpl bindingRegistry = new BindingRegistryImpl();
		return bindingRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityKind createMultiplicityKindFromString(EDataType eDataType, String initialValue) {
		MultiplicityKind result = MultiplicityKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentPackage getEnvironmentPackage() {
		return (EnvironmentPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EnvironmentPackage getPackage() {
		return EnvironmentPackage.eINSTANCE;
	}

} //EnvironmentFactoryImpl
