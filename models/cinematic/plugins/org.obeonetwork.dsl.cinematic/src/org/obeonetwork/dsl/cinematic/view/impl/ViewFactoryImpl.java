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
package org.obeonetwork.dsl.cinematic.view.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.obeonetwork.dsl.cinematic.view.*;
import org.obeonetwork.dsl.cinematic.view.DTOBinding;
import org.obeonetwork.dsl.cinematic.view.DTOPropertyBinding;
import org.obeonetwork.dsl.cinematic.view.EntityBinding;
import org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding;
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.spec.ViewContainerSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewFactoryImpl extends EFactoryImpl implements ViewFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ViewFactory init() {
		try {
			ViewFactory theViewFactory = (ViewFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.obeonetwork.org/dsl/cinematic/view/1.0.0"); 
			if (theViewFactory != null) {
				return theViewFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ViewFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewFactoryImpl() {
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
			case ViewPackage.VIEW_CONTAINER: return (EObject)createViewContainer();
			case ViewPackage.VIEW_ELEMENT: return (EObject)createViewElement();
			case ViewPackage.VIEW_ACTION: return (EObject)createViewAction();
			case ViewPackage.VIEW_EVENT: return (EObject)createViewEvent();
			case ViewPackage.ENTITY_BINDING: return (EObject)createEntityBinding();
			case ViewPackage.ENTITY_PROPERTY_BINDING: return (EObject)createEntityPropertyBinding();
			case ViewPackage.DTO_PROPERTY_BINDING: return (EObject)createDTOPropertyBinding();
			case ViewPackage.DTO_BINDING: return (EObject)createDTOBinding();
			case ViewPackage.VIEW_CONTAINER_REFERENCE: return (EObject)createViewContainerReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated Not
	 */
	public ViewContainer createViewContainer() {
		ViewContainerImpl viewContainer = new ViewContainerSpec();
		return viewContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewElement createViewElement() {
		ViewElementImpl viewElement = new ViewElementImpl();
		return viewElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewAction createViewAction() {
		ViewActionImpl viewAction = new ViewActionImpl();
		return viewAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewEvent createViewEvent() {
		ViewEventImpl viewEvent = new ViewEventImpl();
		return viewEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityBinding createEntityBinding() {
		EntityBindingImpl entityBinding = new EntityBindingImpl();
		return entityBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityPropertyBinding createEntityPropertyBinding() {
		EntityPropertyBindingImpl entityPropertyBinding = new EntityPropertyBindingImpl();
		return entityPropertyBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTOPropertyBinding createDTOPropertyBinding() {
		DTOPropertyBindingImpl dtoPropertyBinding = new DTOPropertyBindingImpl();
		return dtoPropertyBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTOBinding createDTOBinding() {
		DTOBindingImpl dtoBinding = new DTOBindingImpl();
		return dtoBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewContainerReference createViewContainerReference() {
		ViewContainerReferenceImpl viewContainerReference = new ViewContainerReferenceImpl();
		return viewContainerReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewPackage getViewPackage() {
		return (ViewPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ViewPackage getPackage() {
		return ViewPackage.eINSTANCE;
	}

} //ViewFactoryImpl
