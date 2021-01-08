/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.obeonetwork.dsl.environment.*;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Behaviour;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Filter;
import org.obeonetwork.dsl.environment.FilterContainer;
import org.obeonetwork.dsl.environment.InterDSMLink;
import org.obeonetwork.dsl.environment.Literal;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
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
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage
 * @generated
 */
public class EnvironmentSwitch<T> extends Switch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EnvironmentPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentSwitch() {
		if (modelPackage == null) {
			modelPackage = EnvironmentPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case EnvironmentPackage.ENVIRONMENT: {
			Environment environment = (Environment) theEObject;
			T result = caseEnvironment(environment);
			if (result == null)
				result = caseObeoDSMObject(environment);
			if (result == null)
				result = caseNamespacesContainer(environment);
			if (result == null)
				result = caseIdentifiable(environment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.TYPE: {
			Type type = (Type) theEObject;
			T result = caseType(type);
			if (result == null)
				result = caseObeoDSMObject(type);
			if (result == null)
				result = caseBoundableElement(type);
			if (result == null)
				result = caseIdentifiable(type);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.PRIMITIVE_TYPE: {
			PrimitiveType primitiveType = (PrimitiveType) theEObject;
			T result = casePrimitiveType(primitiveType);
			if (result == null)
				result = caseDataType(primitiveType);
			if (result == null)
				result = caseType(primitiveType);
			if (result == null)
				result = caseObeoDSMObject(primitiveType);
			if (result == null)
				result = caseBoundableElement(primitiveType);
			if (result == null)
				result = caseIdentifiable(primitiveType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.ENUMERATION: {
			Enumeration enumeration = (Enumeration) theEObject;
			T result = caseEnumeration(enumeration);
			if (result == null)
				result = caseDataType(enumeration);
			if (result == null)
				result = caseType(enumeration);
			if (result == null)
				result = caseObeoDSMObject(enumeration);
			if (result == null)
				result = caseBoundableElement(enumeration);
			if (result == null)
				result = caseIdentifiable(enumeration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.LITERAL: {
			Literal literal = (Literal) theEObject;
			T result = caseLiteral(literal);
			if (result == null)
				result = caseObeoDSMObject(literal);
			if (result == null)
				result = caseIdentifiable(literal);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.ACTION: {
			Action action = (Action) theEObject;
			T result = caseAction(action);
			if (result == null)
				result = caseObeoDSMObject(action);
			if (result == null)
				result = caseIdentifiable(action);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.INTER_DSM_LINK: {
			InterDSMLink interDSMLink = (InterDSMLink) theEObject;
			T result = caseInterDSMLink(interDSMLink);
			if (result == null)
				result = caseObeoDSMObject(interDSMLink);
			if (result == null)
				result = caseIdentifiable(interDSMLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.OBEO_DSM_OBJECT: {
			ObeoDSMObject obeoDSMObject = (ObeoDSMObject) theEObject;
			T result = caseObeoDSMObject(obeoDSMObject);
			if (result == null)
				result = caseIdentifiable(obeoDSMObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.META_DATA_CONTAINER: {
			MetaDataContainer metaDataContainer = (MetaDataContainer) theEObject;
			T result = caseMetaDataContainer(metaDataContainer);
			if (result == null)
				result = caseIdentifiable(metaDataContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.ANNOTATION: {
			Annotation annotation = (Annotation) theEObject;
			T result = caseAnnotation(annotation);
			if (result == null)
				result = caseMetaData(annotation);
			if (result == null)
				result = caseIdentifiable(annotation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.PRIORITY_DEFINITION: {
			PriorityDefinition priorityDefinition = (PriorityDefinition) theEObject;
			T result = casePriorityDefinition(priorityDefinition);
			if (result == null)
				result = caseObeoDSMObject(priorityDefinition);
			if (result == null)
				result = caseIdentifiable(priorityDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.PRIORITY: {
			Priority priority = (Priority) theEObject;
			T result = casePriority(priority);
			if (result == null)
				result = caseObeoDSMObject(priority);
			if (result == null)
				result = caseIdentifiable(priority);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.META_DATA: {
			MetaData metaData = (MetaData) theEObject;
			T result = caseMetaData(metaData);
			if (result == null)
				result = caseIdentifiable(metaData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.TYPES_DEFINITION: {
			TypesDefinition typesDefinition = (TypesDefinition) theEObject;
			T result = caseTypesDefinition(typesDefinition);
			if (result == null)
				result = caseObeoDSMObject(typesDefinition);
			if (result == null)
				result = caseIdentifiable(typesDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.BEHAVIOUR: {
			Behaviour behaviour = (Behaviour) theEObject;
			T result = caseBehaviour(behaviour);
			if (result == null)
				result = caseObeoDSMObject(behaviour);
			if (result == null)
				result = caseIdentifiable(behaviour);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.STRUCTURED_TYPE: {
			StructuredType structuredType = (StructuredType) theEObject;
			T result = caseStructuredType(structuredType);
			if (result == null)
				result = caseType(structuredType);
			if (result == null)
				result = caseObeoDSMObject(structuredType);
			if (result == null)
				result = caseBoundableElement(structuredType);
			if (result == null)
				result = caseIdentifiable(structuredType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.DTO: {
			DTO dto = (DTO) theEObject;
			T result = caseDTO(dto);
			if (result == null)
				result = caseStructuredType(dto);
			if (result == null)
				result = caseType(dto);
			if (result == null)
				result = caseObeoDSMObject(dto);
			if (result == null)
				result = caseBoundableElement(dto);
			if (result == null)
				result = caseIdentifiable(dto);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.FILTER_CONTAINER: {
			FilterContainer filterContainer = (FilterContainer) theEObject;
			T result = caseFilterContainer(filterContainer);
			if (result == null)
				result = caseObeoDSMObject(filterContainer);
			if (result == null)
				result = caseIdentifiable(filterContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.FILTER: {
			Filter filter = (Filter) theEObject;
			T result = caseFilter(filter);
			if (result == null)
				result = caseObeoDSMObject(filter);
			if (result == null)
				result = caseIdentifiable(filter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.NAMESPACE: {
			Namespace namespace = (Namespace) theEObject;
			T result = caseNamespace(namespace);
			if (result == null)
				result = caseTypesDefinition(namespace);
			if (result == null)
				result = caseNamespacesContainer(namespace);
			if (result == null)
				result = caseObeoDSMObject(namespace);
			if (result == null)
				result = caseIdentifiable(namespace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.ATTRIBUTE: {
			Attribute attribute = (Attribute) theEObject;
			T result = caseAttribute(attribute);
			if (result == null)
				result = caseProperty(attribute);
			if (result == null)
				result = caseObeoDSMObject(attribute);
			if (result == null)
				result = caseBoundableElement(attribute);
			if (result == null)
				result = caseIdentifiable(attribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.REFERENCE: {
			Reference reference = (Reference) theEObject;
			T result = caseReference(reference);
			if (result == null)
				result = caseProperty(reference);
			if (result == null)
				result = caseObeoDSMObject(reference);
			if (result == null)
				result = caseBoundableElement(reference);
			if (result == null)
				result = caseIdentifiable(reference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.PROPERTY: {
			Property property = (Property) theEObject;
			T result = caseProperty(property);
			if (result == null)
				result = caseObeoDSMObject(property);
			if (result == null)
				result = caseBoundableElement(property);
			if (result == null)
				result = caseIdentifiable(property);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.BINDING_INFO: {
			BindingInfo bindingInfo = (BindingInfo) theEObject;
			T result = caseBindingInfo(bindingInfo);
			if (result == null)
				result = caseObeoDSMObject(bindingInfo);
			if (result == null)
				result = caseIdentifiable(bindingInfo);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.BINDING_REFERENCE: {
			BindingReference bindingReference = (BindingReference) theEObject;
			T result = caseBindingReference(bindingReference);
			if (result == null)
				result = caseObeoDSMObject(bindingReference);
			if (result == null)
				result = caseIdentifiable(bindingReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.BINDING_ELEMENT: {
			BindingElement bindingElement = (BindingElement) theEObject;
			T result = caseBindingElement(bindingElement);
			if (result == null)
				result = caseObeoDSMObject(bindingElement);
			if (result == null)
				result = caseIdentifiable(bindingElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.BINDING_REGISTRY: {
			BindingRegistry bindingRegistry = (BindingRegistry) theEObject;
			T result = caseBindingRegistry(bindingRegistry);
			if (result == null)
				result = caseObeoDSMObject(bindingRegistry);
			if (result == null)
				result = caseIdentifiable(bindingRegistry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.BOUNDABLE_ELEMENT: {
			BoundableElement boundableElement = (BoundableElement) theEObject;
			T result = caseBoundableElement(boundableElement);
			if (result == null)
				result = caseIdentifiable(boundableElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.DATA_TYPE: {
			DataType dataType = (DataType) theEObject;
			T result = caseDataType(dataType);
			if (result == null)
				result = caseType(dataType);
			if (result == null)
				result = caseObeoDSMObject(dataType);
			if (result == null)
				result = caseBoundableElement(dataType);
			if (result == null)
				result = caseIdentifiable(dataType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EnvironmentPackage.NAMESPACES_CONTAINER: {
			NamespacesContainer namespacesContainer = (NamespacesContainer) theEObject;
			T result = caseNamespacesContainer(namespacesContainer);
			if (result == null)
				result = caseIdentifiable(namespacesContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnvironment(Environment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeration(Enumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inter DSM Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inter DSM Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterDSMLink(InterDSMLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Obeo DSM Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Obeo DSM Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObeoDSMObject(ObeoDSMObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Data Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Data Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaDataContainer(MetaDataContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriorityDefinition(PriorityDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriority(Priority object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaData(MetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Types Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Types Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypesDefinition(TypesDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviour(Behaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredType(StructuredType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTO</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTO</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTO(DTO object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterContainer(FilterContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilter(Filter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingInfo(BindingInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingReference(BindingReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingElement(BindingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingRegistry(BindingRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boundable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boundable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundableElement(BoundableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespaces Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespaces Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespacesContainer(NamespacesContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EnvironmentSwitch
