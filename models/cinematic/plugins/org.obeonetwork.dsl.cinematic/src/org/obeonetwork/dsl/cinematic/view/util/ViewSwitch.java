/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.view.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.NamedElement;

import org.obeonetwork.dsl.cinematic.view.*;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

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
 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage
 * @generated
 */
public class ViewSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ViewPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewSwitch() {
		if (modelPackage == null) {
			modelPackage = ViewPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ViewPackage.ABSTRACT_VIEW_ELEMENT: {
				AbstractViewElement abstractViewElement = (AbstractViewElement)theEObject;
				T result = caseAbstractViewElement(abstractViewElement);
				if (result == null) result = caseNamedElement(abstractViewElement);
				if (result == null) result = caseCinematicElement(abstractViewElement);
				if (result == null) result = caseObeoDSMObject(abstractViewElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_CONTAINER: {
				ViewContainer viewContainer = (ViewContainer)theEObject;
				T result = caseViewContainer(viewContainer);
				if (result == null) result = caseAbstractViewElement(viewContainer);
				if (result == null) result = caseNamedElement(viewContainer);
				if (result == null) result = caseCinematicElement(viewContainer);
				if (result == null) result = caseObeoDSMObject(viewContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_ELEMENT: {
				ViewElement viewElement = (ViewElement)theEObject;
				T result = caseViewElement(viewElement);
				if (result == null) result = caseAbstractViewElement(viewElement);
				if (result == null) result = caseNamedElement(viewElement);
				if (result == null) result = caseCinematicElement(viewElement);
				if (result == null) result = caseObeoDSMObject(viewElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_ACTION: {
				ViewAction viewAction = (ViewAction)theEObject;
				T result = caseViewAction(viewAction);
				if (result == null) result = caseNamedElement(viewAction);
				if (result == null) result = caseCinematicElement(viewAction);
				if (result == null) result = caseObeoDSMObject(viewAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_EVENT: {
				ViewEvent viewEvent = (ViewEvent)theEObject;
				T result = caseViewEvent(viewEvent);
				if (result == null) result = caseEvent(viewEvent);
				if (result == null) result = caseNamedElement(viewEvent);
				if (result == null) result = caseCinematicElement(viewEvent);
				if (result == null) result = caseObeoDSMObject(viewEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.ENTITY_BINDING: {
				EntityBinding entityBinding = (EntityBinding)theEObject;
				T result = caseEntityBinding(entityBinding);
				if (result == null) result = caseDataBinding(entityBinding);
				if (result == null) result = caseCinematicElement(entityBinding);
				if (result == null) result = caseObeoDSMObject(entityBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.ENTITY_PROPERTY_BINDING: {
				EntityPropertyBinding entityPropertyBinding = (EntityPropertyBinding)theEObject;
				T result = caseEntityPropertyBinding(entityPropertyBinding);
				if (result == null) result = caseDataBinding(entityPropertyBinding);
				if (result == null) result = caseCinematicElement(entityPropertyBinding);
				if (result == null) result = caseObeoDSMObject(entityPropertyBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.DTO_PROPERTY_BINDING: {
				DTOPropertyBinding dtoPropertyBinding = (DTOPropertyBinding)theEObject;
				T result = caseDTOPropertyBinding(dtoPropertyBinding);
				if (result == null) result = caseDataBinding(dtoPropertyBinding);
				if (result == null) result = caseCinematicElement(dtoPropertyBinding);
				if (result == null) result = caseObeoDSMObject(dtoPropertyBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.DTO_BINDING: {
				DTOBinding dtoBinding = (DTOBinding)theEObject;
				T result = caseDTOBinding(dtoBinding);
				if (result == null) result = caseDataBinding(dtoBinding);
				if (result == null) result = caseCinematicElement(dtoBinding);
				if (result == null) result = caseObeoDSMObject(dtoBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.DATA_BINDING: {
				DataBinding dataBinding = (DataBinding)theEObject;
				T result = caseDataBinding(dataBinding);
				if (result == null) result = caseCinematicElement(dataBinding);
				if (result == null) result = caseObeoDSMObject(dataBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_CONTAINER_REFERENCE: {
				ViewContainerReference viewContainerReference = (ViewContainerReference)theEObject;
				T result = caseViewContainerReference(viewContainerReference);
				if (result == null) result = caseAbstractViewElement(viewContainerReference);
				if (result == null) result = caseNamedElement(viewContainerReference);
				if (result == null) result = caseCinematicElement(viewContainerReference);
				if (result == null) result = caseObeoDSMObject(viewContainerReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract View Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract View Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractViewElement(AbstractViewElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewContainer(ViewContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewElement(ViewElement object) {
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
	public T caseViewAction(ViewAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewEvent(ViewEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityBinding(EntityBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Property Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Property Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityPropertyBinding(EntityPropertyBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTO Property Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTO Property Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTOPropertyBinding(DTOPropertyBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTO Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTO Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDTOBinding(DTOBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataBinding(DataBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewContainerReference(ViewContainerReference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCinematicElement(CinematicElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //ViewSwitch
