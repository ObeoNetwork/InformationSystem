/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Behaviour;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Filter;
import org.obeonetwork.dsl.environment.FilterContainer;
import org.obeonetwork.dsl.environment.InterDSMLink;
import org.obeonetwork.dsl.environment.Literal;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.Priority;
import org.obeonetwork.dsl.environment.PriorityDefinition;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentPackageImpl extends EPackageImpl implements EnvironmentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass environmentEClass = null;

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
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interDSMLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass obeoDSMObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typesDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dtoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespacesContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplicityKindEEnum = null;

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
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnvironmentPackageImpl() {
		super(eNS_URI, EnvironmentFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EnvironmentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnvironmentPackage init() {
		if (isInited)
			return (EnvironmentPackage) EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Obtain or create and register package
		EnvironmentPackageImpl theEnvironmentPackage = (EnvironmentPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof EnvironmentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new EnvironmentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TechnicalIDPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEnvironmentPackage.createPackageContents();

		// Initialize created meta-data
		theEnvironmentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnvironmentPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EnvironmentPackage.eNS_URI, theEnvironmentPackage);
		return theEnvironmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnvironment() {
		return environmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Name() {
		return (EAttribute) environmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Actions() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Links() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_PriorityDefinitions() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_TypesDefinition() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(4);
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
	public EAttribute getType_Name() {
		return (EAttribute) typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_TypeDefinition() {
		return (EReference) typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_Literals() {
		return (EReference) enumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiteral_Name() {
		return (EAttribute) literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Name() {
		return (EAttribute) actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterDSMLink() {
		return interDSMLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterDSMLink_Name() {
		return (EAttribute) interDSMLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterDSMLink_Target() {
		return (EReference) interDSMLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObeoDSMObject() {
		return obeoDSMObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObeoDSMObject_Metadatas() {
		return (EReference) obeoDSMObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObeoDSMObject_Description() {
		return (EAttribute) obeoDSMObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObeoDSMObject_Keywords() {
		return (EAttribute) obeoDSMObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObeoDSMObject_Behaviours() {
		return (EReference) obeoDSMObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObeoDSMObject_BindingRegistries() {
		return (EReference) obeoDSMObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObeoDSMObject_Version() {
		return (EAttribute) obeoDSMObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObeoDSMObject_CreatedOn() {
		return (EAttribute) obeoDSMObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObeoDSMObject_ModifiedOn() {
		return (EAttribute) obeoDSMObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaDataContainer() {
		return metaDataContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetaDataContainer_Metadatas() {
		return (EReference) metaDataContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Title() {
		return (EAttribute) annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Body() {
		return (EAttribute) annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriorityDefinition() {
		return priorityDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPriorityDefinition_Priorities() {
		return (EReference) priorityDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriority() {
		return priorityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriority_Name() {
		return (EAttribute) priorityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaData() {
		return metaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypesDefinition() {
		return typesDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypesDefinition_Types() {
		return (EReference) typesDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviour() {
		return behaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredType() {
		return structuredTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredType_Supertype() {
		return (EReference) structuredTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredType_AssociatedTypes() {
		return (EReference) structuredTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredType_OwnedAttributes() {
		return (EReference) structuredTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredType_Attributes() {
		return (EReference) structuredTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredType_OwnedReferences() {
		return (EReference) structuredTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredType_References() {
		return (EReference) structuredTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredType_Properties() {
		return (EReference) structuredTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDTO() {
		return dtoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTO_OwnedContainer() {
		return (EReference) dtoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterContainer() {
		return filterContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterContainer_OwnedFilters() {
		return (EReference) filterContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilter() {
		return filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespace() {
		return namespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespace_Owner() {
		return (EReference) namespaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespace_Name() {
		return (EAttribute) namespaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Type() {
		return (EReference) attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_ContainingType() {
		return (EReference) attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReference_IsComposite() {
		return (EAttribute) referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReference_Navigable() {
		return (EAttribute) referenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_OppositeOf() {
		return (EReference) referenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_ContainingType() {
		return (EReference) referenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_ReferencedType() {
		return (EReference) referenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Multiplicity() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_IsIdentifier() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingInfo() {
		return bindingInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInfo_References() {
		return (EReference) bindingInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInfo_Left() {
		return (EReference) bindingInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInfo_Right() {
		return (EReference) bindingInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInfo_SubBindingInfos() {
		return (EReference) bindingInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInfo_Targets() {
		return (EReference) bindingInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInfo_Elements() {
		return (EReference) bindingInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingReference() {
		return bindingReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingReference_Left() {
		return (EReference) bindingReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingReference_Right() {
		return (EReference) bindingReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingElement() {
		return bindingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingElement_BoundElement() {
		return (EReference) bindingElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingElement_BindingExpression() {
		return (EAttribute) bindingElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingElement_ReferencedByAsLeft() {
		return (EReference) bindingElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingElement_ReferencedByAsRight() {
		return (EReference) bindingElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingElement_ReferencedBy() {
		return (EReference) bindingElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingElement_PathReferences() {
		return (EReference) bindingElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingRegistry() {
		return bindingRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingRegistry_BindingInfos() {
		return (EReference) bindingRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundableElement() {
		return boundableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespacesContainer() {
		return namespacesContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespacesContainer_OwnedNamespaces() {
		return (EReference) namespacesContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiplicityKind() {
		return multiplicityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentFactory getEnvironmentFactory() {
		return (EnvironmentFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		environmentEClass = createEClass(ENVIRONMENT);
		createEAttribute(environmentEClass, ENVIRONMENT__NAME);
		createEReference(environmentEClass, ENVIRONMENT__ACTIONS);
		createEReference(environmentEClass, ENVIRONMENT__LINKS);
		createEReference(environmentEClass, ENVIRONMENT__PRIORITY_DEFINITIONS);
		createEReference(environmentEClass, ENVIRONMENT__TYPES_DEFINITION);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__NAME);
		createEReference(typeEClass, TYPE__TYPE_DEFINITION);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		enumerationEClass = createEClass(ENUMERATION);
		createEReference(enumerationEClass, ENUMERATION__LITERALS);

		literalEClass = createEClass(LITERAL);
		createEAttribute(literalEClass, LITERAL__NAME);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__NAME);

		interDSMLinkEClass = createEClass(INTER_DSM_LINK);
		createEAttribute(interDSMLinkEClass, INTER_DSM_LINK__NAME);
		createEReference(interDSMLinkEClass, INTER_DSM_LINK__TARGET);

		obeoDSMObjectEClass = createEClass(OBEO_DSM_OBJECT);
		createEReference(obeoDSMObjectEClass, OBEO_DSM_OBJECT__METADATAS);
		createEAttribute(obeoDSMObjectEClass, OBEO_DSM_OBJECT__DESCRIPTION);
		createEAttribute(obeoDSMObjectEClass, OBEO_DSM_OBJECT__KEYWORDS);
		createEReference(obeoDSMObjectEClass, OBEO_DSM_OBJECT__BEHAVIOURS);
		createEReference(obeoDSMObjectEClass, OBEO_DSM_OBJECT__BINDING_REGISTRIES);
		createEAttribute(obeoDSMObjectEClass, OBEO_DSM_OBJECT__VERSION);
		createEAttribute(obeoDSMObjectEClass, OBEO_DSM_OBJECT__CREATED_ON);
		createEAttribute(obeoDSMObjectEClass, OBEO_DSM_OBJECT__MODIFIED_ON);

		metaDataContainerEClass = createEClass(META_DATA_CONTAINER);
		createEReference(metaDataContainerEClass, META_DATA_CONTAINER__METADATAS);

		annotationEClass = createEClass(ANNOTATION);
		createEAttribute(annotationEClass, ANNOTATION__TITLE);
		createEAttribute(annotationEClass, ANNOTATION__BODY);

		priorityDefinitionEClass = createEClass(PRIORITY_DEFINITION);
		createEReference(priorityDefinitionEClass, PRIORITY_DEFINITION__PRIORITIES);

		priorityEClass = createEClass(PRIORITY);
		createEAttribute(priorityEClass, PRIORITY__NAME);

		metaDataEClass = createEClass(META_DATA);

		typesDefinitionEClass = createEClass(TYPES_DEFINITION);
		createEReference(typesDefinitionEClass, TYPES_DEFINITION__TYPES);

		behaviourEClass = createEClass(BEHAVIOUR);

		structuredTypeEClass = createEClass(STRUCTURED_TYPE);
		createEReference(structuredTypeEClass, STRUCTURED_TYPE__SUPERTYPE);
		createEReference(structuredTypeEClass, STRUCTURED_TYPE__ASSOCIATED_TYPES);
		createEReference(structuredTypeEClass, STRUCTURED_TYPE__OWNED_ATTRIBUTES);
		createEReference(structuredTypeEClass, STRUCTURED_TYPE__ATTRIBUTES);
		createEReference(structuredTypeEClass, STRUCTURED_TYPE__OWNED_REFERENCES);
		createEReference(structuredTypeEClass, STRUCTURED_TYPE__REFERENCES);
		createEReference(structuredTypeEClass, STRUCTURED_TYPE__PROPERTIES);

		dtoEClass = createEClass(DTO);
		createEReference(dtoEClass, DTO__OWNED_CONTAINER);

		filterContainerEClass = createEClass(FILTER_CONTAINER);
		createEReference(filterContainerEClass, FILTER_CONTAINER__OWNED_FILTERS);

		filterEClass = createEClass(FILTER);

		namespaceEClass = createEClass(NAMESPACE);
		createEReference(namespaceEClass, NAMESPACE__OWNER);
		createEAttribute(namespaceEClass, NAMESPACE__NAME);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__TYPE);
		createEReference(attributeEClass, ATTRIBUTE__CONTAINING_TYPE);

		referenceEClass = createEClass(REFERENCE);
		createEAttribute(referenceEClass, REFERENCE__IS_COMPOSITE);
		createEAttribute(referenceEClass, REFERENCE__NAVIGABLE);
		createEReference(referenceEClass, REFERENCE__OPPOSITE_OF);
		createEReference(referenceEClass, REFERENCE__CONTAINING_TYPE);
		createEReference(referenceEClass, REFERENCE__REFERENCED_TYPE);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__MULTIPLICITY);
		createEAttribute(propertyEClass, PROPERTY__IS_IDENTIFIER);

		bindingInfoEClass = createEClass(BINDING_INFO);
		createEReference(bindingInfoEClass, BINDING_INFO__REFERENCES);
		createEReference(bindingInfoEClass, BINDING_INFO__LEFT);
		createEReference(bindingInfoEClass, BINDING_INFO__RIGHT);
		createEReference(bindingInfoEClass, BINDING_INFO__SUB_BINDING_INFOS);
		createEReference(bindingInfoEClass, BINDING_INFO__TARGETS);
		createEReference(bindingInfoEClass, BINDING_INFO__ELEMENTS);

		bindingReferenceEClass = createEClass(BINDING_REFERENCE);
		createEReference(bindingReferenceEClass, BINDING_REFERENCE__LEFT);
		createEReference(bindingReferenceEClass, BINDING_REFERENCE__RIGHT);

		bindingElementEClass = createEClass(BINDING_ELEMENT);
		createEReference(bindingElementEClass, BINDING_ELEMENT__BOUND_ELEMENT);
		createEAttribute(bindingElementEClass, BINDING_ELEMENT__BINDING_EXPRESSION);
		createEReference(bindingElementEClass, BINDING_ELEMENT__REFERENCED_BY_AS_LEFT);
		createEReference(bindingElementEClass, BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT);
		createEReference(bindingElementEClass, BINDING_ELEMENT__REFERENCED_BY);
		createEReference(bindingElementEClass, BINDING_ELEMENT__PATH_REFERENCES);

		bindingRegistryEClass = createEClass(BINDING_REGISTRY);
		createEReference(bindingRegistryEClass, BINDING_REGISTRY__BINDING_INFOS);

		boundableElementEClass = createEClass(BOUNDABLE_ELEMENT);

		dataTypeEClass = createEClass(DATA_TYPE);

		namespacesContainerEClass = createEClass(NAMESPACES_CONTAINER);
		createEReference(namespacesContainerEClass, NAMESPACES_CONTAINER__OWNED_NAMESPACES);

		// Create enums
		multiplicityKindEEnum = createEEnum(MULTIPLICITY_KIND);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TechnicalIDPackage theTechnicalIDPackage = (TechnicalIDPackage) EPackage.Registry.INSTANCE
				.getEPackage(TechnicalIDPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		environmentEClass.getESuperTypes().add(this.getObeoDSMObject());
		environmentEClass.getESuperTypes().add(this.getNamespacesContainer());
		typeEClass.getESuperTypes().add(this.getObeoDSMObject());
		typeEClass.getESuperTypes().add(this.getBoundableElement());
		primitiveTypeEClass.getESuperTypes().add(this.getDataType());
		enumerationEClass.getESuperTypes().add(this.getDataType());
		literalEClass.getESuperTypes().add(this.getObeoDSMObject());
		actionEClass.getESuperTypes().add(this.getObeoDSMObject());
		interDSMLinkEClass.getESuperTypes().add(this.getObeoDSMObject());
		obeoDSMObjectEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		metaDataContainerEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		annotationEClass.getESuperTypes().add(this.getMetaData());
		priorityDefinitionEClass.getESuperTypes().add(this.getObeoDSMObject());
		priorityEClass.getESuperTypes().add(this.getObeoDSMObject());
		metaDataEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		typesDefinitionEClass.getESuperTypes().add(this.getObeoDSMObject());
		behaviourEClass.getESuperTypes().add(this.getObeoDSMObject());
		structuredTypeEClass.getESuperTypes().add(this.getType());
		dtoEClass.getESuperTypes().add(this.getStructuredType());
		filterContainerEClass.getESuperTypes().add(this.getObeoDSMObject());
		filterEClass.getESuperTypes().add(this.getObeoDSMObject());
		namespaceEClass.getESuperTypes().add(this.getTypesDefinition());
		namespaceEClass.getESuperTypes().add(this.getNamespacesContainer());
		attributeEClass.getESuperTypes().add(this.getProperty());
		referenceEClass.getESuperTypes().add(this.getProperty());
		propertyEClass.getESuperTypes().add(this.getObeoDSMObject());
		propertyEClass.getESuperTypes().add(this.getBoundableElement());
		bindingInfoEClass.getESuperTypes().add(this.getObeoDSMObject());
		bindingReferenceEClass.getESuperTypes().add(this.getObeoDSMObject());
		bindingElementEClass.getESuperTypes().add(this.getObeoDSMObject());
		bindingRegistryEClass.getESuperTypes().add(this.getObeoDSMObject());
		boundableElementEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		dataTypeEClass.getESuperTypes().add(this.getType());
		namespacesContainerEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());

		// Initialize classes and features; add operations and parameters
		initEClass(environmentEClass, Environment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnvironment_Name(), ecorePackage.getEString(), "name", null, 1, 1, Environment.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnvironment_Actions(), this.getAction(), null, "actions", null, 0, -1, Environment.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getEnvironment_Links(), this.getInterDSMLink(), null, "links", null, 0, -1, Environment.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getEnvironment_PriorityDefinitions(), this.getPriorityDefinition(), null, "priorityDefinitions",
				null, 0, 1, Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnvironment_TypesDefinition(), this.getTypesDefinition(), null, "typesDefinition", null, 0, 1,
				Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_Name(), ecorePackage.getEString(), "name", null, 1, 1, Type.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getType_TypeDefinition(), this.getTypesDefinition(), this.getTypesDefinition_Types(),
				"typeDefinition", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeration_Literals(), this.getLiteral(), null, "literals", null, 1, -1, Enumeration.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteral_Name(), ecorePackage.getEString(), "name", null, 1, 1, Literal.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_Name(), ecorePackage.getEString(), "name", null, 1, 1, Action.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interDSMLinkEClass, InterDSMLink.class, "InterDSMLink", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterDSMLink_Name(), ecorePackage.getEString(), "name", null, 1, 1, InterDSMLink.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterDSMLink_Target(), ecorePackage.getEObject(), null, "target", null, 1, 1,
				InterDSMLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(obeoDSMObjectEClass, ObeoDSMObject.class, "ObeoDSMObject", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObeoDSMObject_Metadatas(), this.getMetaDataContainer(), null, "metadatas", null, 0, 1,
				ObeoDSMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObeoDSMObject_Description(), ecorePackage.getEString(), "description", null, 0, 1,
				ObeoDSMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getObeoDSMObject_Keywords(), ecorePackage.getEString(), "keywords", null, 0, -1,
				ObeoDSMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getObeoDSMObject_Behaviours(), this.getBehaviour(), null, "behaviours", null, 0, -1,
				ObeoDSMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObeoDSMObject_BindingRegistries(), this.getBindingRegistry(), null, "bindingRegistries", null,
				0, -1, ObeoDSMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObeoDSMObject_Version(), ecorePackage.getEInt(), "version", "1", 0, 1, ObeoDSMObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObeoDSMObject_CreatedOn(), ecorePackage.getEDate(), "createdOn", null, 0, 1,
				ObeoDSMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getObeoDSMObject_ModifiedOn(), ecorePackage.getEDate(), "modifiedOn", null, 0, 1,
				ObeoDSMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(metaDataContainerEClass, MetaDataContainer.class, "MetaDataContainer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaDataContainer_Metadatas(), this.getMetaData(), null, "metadatas", null, 0, -1,
				MetaDataContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotation_Title(), ecorePackage.getEString(), "title", null, 1, 1, Annotation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Body(), ecorePackage.getEString(), "body", null, 0, 1, Annotation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(priorityDefinitionEClass, PriorityDefinition.class, "PriorityDefinition", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPriorityDefinition_Priorities(), this.getPriority(), null, "priorities", null, 1, -1,
				PriorityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(priorityEClass, Priority.class, "Priority", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPriority_Name(), ecorePackage.getEString(), "name", null, 1, 1, Priority.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaDataEClass, MetaData.class, "MetaData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typesDefinitionEClass, TypesDefinition.class, "TypesDefinition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypesDefinition_Types(), this.getType(), this.getType_TypeDefinition(), "types", null, 0, -1,
				TypesDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviourEClass, Behaviour.class, "Behaviour", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(structuredTypeEClass, StructuredType.class, "StructuredType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredType_Supertype(), this.getStructuredType(), null, "supertype", null, 0, 1,
				StructuredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredType_AssociatedTypes(), this.getStructuredType(), null, "associatedTypes", null, 0,
				-1, StructuredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredType_OwnedAttributes(), this.getAttribute(), this.getAttribute_ContainingType(),
				"ownedAttributes", null, 0, -1, StructuredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredType_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1,
				StructuredType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredType_OwnedReferences(), this.getReference(), this.getReference_ContainingType(),
				"ownedReferences", null, 0, -1, StructuredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredType_References(), this.getReference(), null, "references", null, 0, -1,
				StructuredType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredType_Properties(), this.getProperty(), null, "properties", null, 0, -1,
				StructuredType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(structuredTypeEClass, ecorePackage.getEBoolean(), "isSubtypeOf", 1, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getStructuredType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dtoEClass, org.obeonetwork.dsl.environment.DTO.class, "DTO", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDTO_OwnedContainer(), this.getFilterContainer(), null, "ownedContainer", null, 0, 1,
				org.obeonetwork.dsl.environment.DTO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterContainerEClass, FilterContainer.class, "FilterContainer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilterContainer_OwnedFilters(), this.getFilter(), null, "ownedFilters", null, 0, -1,
				FilterContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterEClass, Filter.class, "Filter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namespaceEClass, Namespace.class, "Namespace", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamespace_Owner(), this.getNamespacesContainer(),
				this.getNamespacesContainer_OwnedNamespaces(), "owner", null, 0, 1, Namespace.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getNamespace_Name(), ecorePackage.getEString(), "name", null, 0, 1, Namespace.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_Type(), this.getDataType(), null, "type", null, 1, 1, Attribute.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_ContainingType(), this.getStructuredType(),
				this.getStructuredType_OwnedAttributes(), "containingType", null, 1, 1, Attribute.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReference_IsComposite(), ecorePackage.getEBoolean(), "isComposite", null, 1, 1,
				Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getReference_Navigable(), ecorePackage.getEBoolean(), "navigable", "true", 1, 1, Reference.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReference_OppositeOf(), this.getReference(), null, "oppositeOf", null, 0, 1, Reference.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReference_ContainingType(), this.getStructuredType(),
				this.getStructuredType_OwnedReferences(), "containingType", null, 1, 1, Reference.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getReference_ReferencedType(), this.getStructuredType(), null, "referencedType", null, 1, 1,
				Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(referenceEClass, ecorePackage.getEBoolean(), "canBeOppositeOf", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getReference(), "opposite", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Multiplicity(), this.getMultiplicityKind(), "multiplicity", null, 0, 1,
				Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsIdentifier(), ecorePackage.getEBoolean(), "isIdentifier", null, 0, 1,
				Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(bindingInfoEClass, BindingInfo.class, "BindingInfo", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingInfo_References(), this.getBindingReference(), null, "references", null, 0, -1,
				BindingInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingInfo_Left(), this.getBoundableElement(), null, "left", null, 0, 1, BindingInfo.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingInfo_Right(), this.getBoundableElement(), null, "right", null, 0, 1, BindingInfo.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingInfo_SubBindingInfos(), this.getBindingInfo(), null, "subBindingInfos", null, 0, -1,
				BindingInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingInfo_Targets(), this.getBoundableElement(), null, "targets", null, 0, -1,
				BindingInfo.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBindingInfo_Elements(), this.getBindingElement(), null, "elements", null, 0, -1,
				BindingInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingReferenceEClass, BindingReference.class, "BindingReference", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingReference_Left(), this.getBindingElement(),
				this.getBindingElement_ReferencedByAsLeft(), "left", null, 1, 1, BindingReference.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getBindingReference_Right(), this.getBindingElement(),
				this.getBindingElement_ReferencedByAsRight(), "right", null, 1, 1, BindingReference.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bindingReferenceEClass, this.getBindingElement(), "getOppositeBindingElement", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBindingElement(), "bindingElement", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bindingElementEClass, BindingElement.class, "BindingElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingElement_BoundElement(), this.getBoundableElement(), null, "boundElement", null, 0, 1,
				BindingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingElement_BindingExpression(), ecorePackage.getEString(), "bindingExpression", null, 0,
				1, BindingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getBindingElement_ReferencedByAsLeft(), this.getBindingReference(),
				this.getBindingReference_Left(), "referencedByAsLeft", null, 0, -1, BindingElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getBindingElement_ReferencedByAsRight(), this.getBindingReference(),
				this.getBindingReference_Right(), "referencedByAsRight", null, 0, -1, BindingElement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingElement_ReferencedBy(), this.getBindingReference(), null, "referencedBy", null, 0, -1,
				BindingElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBindingElement_PathReferences(), this.getBoundableElement(), null, "pathReferences", null, 0,
				-1, BindingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingRegistryEClass, BindingRegistry.class, "BindingRegistry", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingRegistry_BindingInfos(), this.getBindingInfo(), null, "bindingInfos", null, 0, -1,
				BindingRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boundableElementEClass, BoundableElement.class, "BoundableElement", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(boundableElementEClass, ecorePackage.getEBoolean(), "isPathValid", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getBoundableElement(), "root", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namespacesContainerEClass, NamespacesContainer.class, "NamespacesContainer", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamespacesContainer_OwnedNamespaces(), this.getNamespace(), this.getNamespace_Owner(),
				"ownedNamespaces", null, 0, -1, NamespacesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(multiplicityKindEEnum, MultiplicityKind.class, "MultiplicityKind");
		addEEnumLiteral(multiplicityKindEEnum, MultiplicityKind.ZERO_ONE_LITERAL);
		addEEnumLiteral(multiplicityKindEEnum, MultiplicityKind.ONE_LITERAL);
		addEEnumLiteral(multiplicityKindEEnum, MultiplicityKind.ZERO_STAR_LITERAL);
		addEEnumLiteral(multiplicityKindEEnum, MultiplicityKind.ONE_STAR_LITERAL);

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
		addAnnotation(getEnvironment_Name(), source, new String[] { "documentation", "The name of the environment." });
		addAnnotation(getEnvironment_Actions(), source, new String[] { "documentation", "The list of actions." });
		addAnnotation(getEnvironment_Links(), source, new String[] { "documentation", "The list of links." });
		addAnnotation(getEnvironment_PriorityDefinitions(), source, new String[] { "documentation", "The priority." });
		addAnnotation(getEnvironment_TypesDefinition(), source,
				new String[] { "documentation", "The types definitions." });
		addAnnotation(getType_Name(), source, new String[] { "documentation", "The name of the type." });
		addAnnotation(getType_TypeDefinition(), source, new String[] { "documentation", "The type definition." });
		addAnnotation(getEnumeration_Literals(), source,
				new String[] { "documentation", "The list of literals for this enumeration." });
		addAnnotation(getLiteral_Name(), source, new String[] { "documentation", "The name of the literal." });
		addAnnotation(getAction_Name(), source, new String[] { "documentation", "The name of the action." });
		addAnnotation(getInterDSMLink_Name(), source, new String[] { "documentation", "The name of the link." });
		addAnnotation(getInterDSMLink_Target(), source, new String[] { "documentation", "The target of the link." });
		addAnnotation(getObeoDSMObject_Metadatas(), source,
				new String[] { "documentation", "The metadatas defined on this object." });
		addAnnotation(getObeoDSMObject_Description(), source,
				new String[] { "documentation", "The description of this object." });
		addAnnotation(getObeoDSMObject_Keywords(), source,
				new String[] { "documentation", "The list of keywords applied to this object." });
		addAnnotation(getObeoDSMObject_Behaviours(), source,
				new String[] { "documentation", "The Behaviours owned by this object." });
		addAnnotation(getObeoDSMObject_BindingRegistries(), source,
				new String[] { "documentation", "The binding registries of this object." });
		addAnnotation(getObeoDSMObject_Version(), source,
				new String[] { "documentation", "The version of this object." });
		addAnnotation(getObeoDSMObject_CreatedOn(), source,
				new String[] { "documentation", "The creation date of this object." });
		addAnnotation(getObeoDSMObject_ModifiedOn(), source,
				new String[] { "documentation", "The modification date of this obect." });
		addAnnotation(getMetaDataContainer_Metadatas(), source,
				new String[] { "documentation", "The list of metadata." });
		addAnnotation(getAnnotation_Title(), source, new String[] { "documentation", "The title of the annotation." });
		addAnnotation(getAnnotation_Body(), source, new String[] { "documentation", "The body of the annotation." });
		addAnnotation(getPriorityDefinition_Priorities(), source,
				new String[] { "documentation", "The list of priorities." });
		addAnnotation(getPriority_Name(), source, new String[] { "documentation", "The name of the priority." });
		addAnnotation(getTypesDefinition_Types(), source, new String[] { "documentation", "The list of types." });
		addAnnotation(getStructuredType_Supertype(), source,
				new String[] { "documentation", "The super structuredtype." });
		addAnnotation(getStructuredType_AssociatedTypes(), source,
				new String[] { "documentation", "The list of associated structured types." });
		addAnnotation(getStructuredType_OwnedAttributes(), source,
				new String[] { "documentation", "The list of owned attributes." });
		addAnnotation(getStructuredType_Attributes(), source,
				new String[] { "documentation", "The list of attributes." });
		addAnnotation(getStructuredType_OwnedReferences(), source,
				new String[] { "documentation", "The list of owned references." });
		addAnnotation(getStructuredType_References(), source,
				new String[] { "documentation", "The list of references." });
		addAnnotation(getStructuredType_Properties(), source,
				new String[] { "documentation", "The list of priorities." });
		addAnnotation(getDTO_OwnedContainer(), source, new String[] { "documentation", "The owned filter container." });
		addAnnotation(getFilterContainer_OwnedFilters(), source,
				new String[] { "documentation", "The list of owned filters." });
		addAnnotation(getNamespace_Owner(), source,
				new String[] { "documentation", "The containing namespace container." });
		addAnnotation(getNamespace_Name(), source, new String[] { "documentation", "The name of the namespace." });
		addAnnotation(getAttribute_Type(), source, new String[] { "documentation", "The type of the attribute." });
		addAnnotation(getAttribute_ContainingType(), source,
				new String[] { "documentation", "The containing structured type." });
		addAnnotation(getReference_IsComposite(), source,
				new String[] { "documentation", "Tells if the reference is composite." });
		addAnnotation(getReference_Navigable(), source,
				new String[] { "documentation", "Tells if the reference is navigable." });
		addAnnotation(getReference_OppositeOf(), source, new String[] { "documentation", "The opposite relation." });
		addAnnotation(getReference_ContainingType(), source,
				new String[] { "documentation", "The containing structured type." });
		addAnnotation(getReference_ReferencedType(), source,
				new String[] { "documentation", "The type of the reference." });
		addAnnotation(getProperty_Name(), source, new String[] { "documentation", "The name of the property." });
		addAnnotation(getProperty_Multiplicity(), source,
				new String[] { "documentation", "The multiplicity of the property." });
		addAnnotation(getProperty_IsIdentifier(), source,
				new String[] { "documentation", "Tells if the property is an identifier." });
		addAnnotation(getBindingInfo_References(), source,
				new String[] { "documentation", "The list of binding references." });
		addAnnotation(getBindingInfo_Left(), source, new String[] { "documentation", "The left boundable element." });
		addAnnotation(getBindingInfo_Right(), source, new String[] { "documentation", "The right boundable element." });
		addAnnotation(getBindingInfo_SubBindingInfos(), source,
				new String[] { "documentation", "The list of sub binding infos." });
		addAnnotation(getBindingInfo_Targets(), source,
				new String[] { "documentation", "The list of targeted boundable elements." });
		addAnnotation(getBindingInfo_Elements(), source,
				new String[] { "documentation", "The list of binding elements." });
		addAnnotation(getBindingReference_Left(), source,
				new String[] { "documentation", "The left binding element." });
		addAnnotation(getBindingReference_Right(), source,
				new String[] { "documentation", "The right binding element." });
		addAnnotation(getBindingElement_BoundElement(), source, new String[] { "documentation", "The bound element." });
		addAnnotation(getBindingElement_BindingExpression(), source,
				new String[] { "documentation", "The binding expression." });
		addAnnotation(getBindingElement_ReferencedByAsLeft(), source,
				new String[] { "documentation", "The referenced by as left binding reference." });
		addAnnotation(getBindingElement_ReferencedByAsRight(), source,
				new String[] { "documentation", "The referenced by as right binding reference." });
		addAnnotation(getBindingElement_ReferencedBy(), source,
				new String[] { "documentation", "The referenced by binding reference." });
		addAnnotation(getBindingElement_PathReferences(), source,
				new String[] { "documentation", "The list of boundable elements path." });
		addAnnotation(getBindingRegistry_BindingInfos(), source,
				new String[] { "documentation", "The list of binding infos." });
		addAnnotation(getNamespacesContainer_OwnedNamespaces(), source,
				new String[] { "documentation", "The list of owned namespaces." });
	}

} //EnvironmentPackageImpl
