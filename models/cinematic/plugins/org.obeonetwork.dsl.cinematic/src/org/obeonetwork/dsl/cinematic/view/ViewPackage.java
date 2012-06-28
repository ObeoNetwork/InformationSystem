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
package org.obeonetwork.dsl.cinematic.view;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.cinematic.CinematicPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.cinematic.view.ViewFactory
 * @model kind="package"
 * @generated
 */
public interface ViewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "view";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/cinematic/view/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cinematic-view";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ViewPackage eINSTANCE = org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl <em>Abstract View Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getAbstractViewElement()
	 * @generated
	 */
	int ABSTRACT_VIEW_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__METADATAS = CinematicPackage.NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__DESCRIPTION = CinematicPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__KEYWORDS = CinematicPackage.NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__BEHAVIOURS = CinematicPackage.NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__BINDING_REGISTRIES = CinematicPackage.NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__NAME = CinematicPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__WIDGET = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__ACTIONS = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__EVENTS = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__LABEL = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT__DATA_BINDINGS = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Abstract View Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewContainer()
	 * @generated
	 */
	int VIEW_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__METADATAS = ABSTRACT_VIEW_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__DESCRIPTION = ABSTRACT_VIEW_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__KEYWORDS = ABSTRACT_VIEW_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__BEHAVIOURS = ABSTRACT_VIEW_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__BINDING_REGISTRIES = ABSTRACT_VIEW_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__NAME = ABSTRACT_VIEW_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__WIDGET = ABSTRACT_VIEW_ELEMENT__WIDGET;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__ACTIONS = ABSTRACT_VIEW_ELEMENT__ACTIONS;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__EVENTS = ABSTRACT_VIEW_ELEMENT__EVENTS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__LABEL = ABSTRACT_VIEW_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Data Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__DATA_BINDINGS = ABSTRACT_VIEW_ELEMENT__DATA_BINDINGS;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__OWNED_ELEMENTS = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>View Containers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__VIEW_CONTAINERS = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>View Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__VIEW_ELEMENTS = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>View Container References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER__VIEW_CONTAINER_REFERENCES = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_FEATURE_COUNT = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewElementImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewElement()
	 * @generated
	 */
	int VIEW_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__METADATAS = ABSTRACT_VIEW_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__DESCRIPTION = ABSTRACT_VIEW_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__KEYWORDS = ABSTRACT_VIEW_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__BEHAVIOURS = ABSTRACT_VIEW_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__BINDING_REGISTRIES = ABSTRACT_VIEW_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__NAME = ABSTRACT_VIEW_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__WIDGET = ABSTRACT_VIEW_ELEMENT__WIDGET;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__ACTIONS = ABSTRACT_VIEW_ELEMENT__ACTIONS;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__EVENTS = ABSTRACT_VIEW_ELEMENT__EVENTS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__LABEL = ABSTRACT_VIEW_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Data Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__DATA_BINDINGS = ABSTRACT_VIEW_ELEMENT__DATA_BINDINGS;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__REQUIRED = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT__TYPE = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ELEMENT_FEATURE_COUNT = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewActionImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewAction()
	 * @generated
	 */
	int VIEW_ACTION = 3;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION__METADATAS = CinematicPackage.NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION__DESCRIPTION = CinematicPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION__KEYWORDS = CinematicPackage.NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION__BEHAVIOURS = CinematicPackage.NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION__BINDING_REGISTRIES = CinematicPackage.NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION__NAME = CinematicPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION_FEATURE_COUNT = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewEventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewEventImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewEvent()
	 * @generated
	 */
	int VIEW_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT__METADATAS = CinematicPackage.EVENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT__DESCRIPTION = CinematicPackage.EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT__KEYWORDS = CinematicPackage.EVENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT__BEHAVIOURS = CinematicPackage.EVENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT__BINDING_REGISTRIES = CinematicPackage.EVENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT__NAME = CinematicPackage.EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT__TYPE = CinematicPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_EVENT_FEATURE_COUNT = CinematicPackage.EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.DataBindingImpl <em>Data Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.DataBindingImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getDataBinding()
	 * @generated
	 */
	int DATA_BINDING = 9;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BINDING__METADATAS = CinematicPackage.CINEMATIC_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BINDING__DESCRIPTION = CinematicPackage.CINEMATIC_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BINDING__KEYWORDS = CinematicPackage.CINEMATIC_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BINDING__BEHAVIOURS = CinematicPackage.CINEMATIC_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BINDING__BINDING_REGISTRIES = CinematicPackage.CINEMATIC_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The number of structural features of the '<em>Data Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BINDING_FEATURE_COUNT = CinematicPackage.CINEMATIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.EntityBindingImpl <em>Entity Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.EntityBindingImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getEntityBinding()
	 * @generated
	 */
	int ENTITY_BINDING = 5;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING__METADATAS = DATA_BINDING__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING__DESCRIPTION = DATA_BINDING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING__KEYWORDS = DATA_BINDING__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING__BEHAVIOURS = DATA_BINDING__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING__BINDING_REGISTRIES = DATA_BINDING__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING__ENTITY = DATA_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING_FEATURE_COUNT = DATA_BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.EntityPropertyBindingImpl <em>Entity Property Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.EntityPropertyBindingImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getEntityPropertyBinding()
	 * @generated
	 */
	int ENTITY_PROPERTY_BINDING = 6;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PROPERTY_BINDING__METADATAS = DATA_BINDING__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PROPERTY_BINDING__DESCRIPTION = DATA_BINDING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PROPERTY_BINDING__KEYWORDS = DATA_BINDING__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PROPERTY_BINDING__BEHAVIOURS = DATA_BINDING__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PROPERTY_BINDING__BINDING_REGISTRIES = DATA_BINDING__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PROPERTY_BINDING__PROPERTY = DATA_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PROPERTY_BINDING_FEATURE_COUNT = DATA_BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.DTOPropertyBindingImpl <em>DTO Property Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.DTOPropertyBindingImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getDTOPropertyBinding()
	 * @generated
	 */
	int DTO_PROPERTY_BINDING = 7;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_PROPERTY_BINDING__METADATAS = DATA_BINDING__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_PROPERTY_BINDING__DESCRIPTION = DATA_BINDING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_PROPERTY_BINDING__KEYWORDS = DATA_BINDING__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_PROPERTY_BINDING__BEHAVIOURS = DATA_BINDING__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_PROPERTY_BINDING__BINDING_REGISTRIES = DATA_BINDING__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_PROPERTY_BINDING__PROPERTY = DATA_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DTO Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_PROPERTY_BINDING_FEATURE_COUNT = DATA_BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.DTOBindingImpl <em>DTO Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.DTOBindingImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getDTOBinding()
	 * @generated
	 */
	int DTO_BINDING = 8;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_BINDING__METADATAS = DATA_BINDING__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_BINDING__DESCRIPTION = DATA_BINDING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_BINDING__KEYWORDS = DATA_BINDING__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_BINDING__BEHAVIOURS = DATA_BINDING__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_BINDING__BINDING_REGISTRIES = DATA_BINDING__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Dto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_BINDING__DTO = DATA_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DTO Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_BINDING_FEATURE_COUNT = DATA_BINDING_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerReferenceImpl <em>Container Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewContainerReferenceImpl
	 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewContainerReference()
	 * @generated
	 */
	int VIEW_CONTAINER_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__METADATAS = ABSTRACT_VIEW_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__DESCRIPTION = ABSTRACT_VIEW_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__KEYWORDS = ABSTRACT_VIEW_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__BEHAVIOURS = ABSTRACT_VIEW_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__BINDING_REGISTRIES = ABSTRACT_VIEW_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__NAME = ABSTRACT_VIEW_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__WIDGET = ABSTRACT_VIEW_ELEMENT__WIDGET;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__ACTIONS = ABSTRACT_VIEW_ELEMENT__ACTIONS;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__EVENTS = ABSTRACT_VIEW_ELEMENT__EVENTS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__LABEL = ABSTRACT_VIEW_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Data Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__DATA_BINDINGS = ABSTRACT_VIEW_ELEMENT__DATA_BINDINGS;

	/**
	 * The feature id for the '<em><b>View Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CONTAINER_REFERENCE_FEATURE_COUNT = ABSTRACT_VIEW_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement <em>Abstract View Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract View Element</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.AbstractViewElement
	 * @generated
	 */
	EClass getAbstractViewElement();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getWidget()
	 * @see #getAbstractViewElement()
	 * @generated
	 */
	EReference getAbstractViewElement_Widget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getActions()
	 * @see #getAbstractViewElement()
	 * @generated
	 */
	EReference getAbstractViewElement_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getEvents()
	 * @see #getAbstractViewElement()
	 * @generated
	 */
	EReference getAbstractViewElement_Events();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getLabel()
	 * @see #getAbstractViewElement()
	 * @generated
	 */
	EAttribute getAbstractViewElement_Label();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getDataBindings <em>Data Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Bindings</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.AbstractViewElement#getDataBindings()
	 * @see #getAbstractViewElement()
	 * @generated
	 */
	EReference getAbstractViewElement_DataBindings();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.ViewContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewContainer
	 * @generated
	 */
	EClass getViewContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Elements</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewContainer#getOwnedElements()
	 * @see #getViewContainer()
	 * @generated
	 */
	EReference getViewContainer_OwnedElements();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewContainers <em>View Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>View Containers</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewContainers()
	 * @see #getViewContainer()
	 * @generated
	 */
	EReference getViewContainer_ViewContainers();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewElements <em>View Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>View Elements</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewElements()
	 * @see #getViewContainer()
	 * @generated
	 */
	EReference getViewContainer_ViewElements();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewContainerReferences <em>View Container References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>View Container References</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewContainer#getViewContainerReferences()
	 * @see #getViewContainer()
	 * @generated
	 */
	EReference getViewContainer_ViewContainerReferences();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.ViewElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewElement
	 * @generated
	 */
	EClass getViewElement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.view.ViewElement#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewElement#isRequired()
	 * @see #getViewElement()
	 * @generated
	 */
	EAttribute getViewElement_Required();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.ViewElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewElement#getType()
	 * @see #getViewElement()
	 * @generated
	 */
	EReference getViewElement_Type();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.ViewAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewAction
	 * @generated
	 */
	EClass getViewAction();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.ViewEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewEvent
	 * @generated
	 */
	EClass getViewEvent();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.ViewEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewEvent#getType()
	 * @see #getViewEvent()
	 * @generated
	 */
	EReference getViewEvent_Type();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.EntityBinding <em>Entity Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Binding</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.EntityBinding
	 * @generated
	 */
	EClass getEntityBinding();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.EntityBinding#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.EntityBinding#getEntity()
	 * @see #getEntityBinding()
	 * @generated
	 */
	EReference getEntityBinding_Entity();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding <em>Entity Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Property Binding</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding
	 * @generated
	 */
	EClass getEntityPropertyBinding();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding#getProperty()
	 * @see #getEntityPropertyBinding()
	 * @generated
	 */
	EReference getEntityPropertyBinding_Property();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.DTOPropertyBinding <em>DTO Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DTO Property Binding</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.DTOPropertyBinding
	 * @generated
	 */
	EClass getDTOPropertyBinding();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.DTOPropertyBinding#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.DTOPropertyBinding#getProperty()
	 * @see #getDTOPropertyBinding()
	 * @generated
	 */
	EReference getDTOPropertyBinding_Property();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.DTOBinding <em>DTO Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DTO Binding</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.DTOBinding
	 * @generated
	 */
	EClass getDTOBinding();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.DTOBinding#getDto <em>Dto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dto</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.DTOBinding#getDto()
	 * @see #getDTOBinding()
	 * @generated
	 */
	EReference getDTOBinding_Dto();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.DataBinding <em>Data Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Binding</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.DataBinding
	 * @generated
	 */
	EClass getDataBinding();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.view.ViewContainerReference <em>Container Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Reference</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewContainerReference
	 * @generated
	 */
	EClass getViewContainerReference();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.view.ViewContainerReference#getViewContainer <em>View Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View Container</em>'.
	 * @see org.obeonetwork.dsl.cinematic.view.ViewContainerReference#getViewContainer()
	 * @see #getViewContainerReference()
	 * @generated
	 */
	EReference getViewContainerReference_ViewContainer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ViewFactory getViewFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl <em>Abstract View Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.AbstractViewElementImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getAbstractViewElement()
		 * @generated
		 */
		EClass ABSTRACT_VIEW_ELEMENT = eINSTANCE.getAbstractViewElement();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VIEW_ELEMENT__WIDGET = eINSTANCE.getAbstractViewElement_Widget();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VIEW_ELEMENT__ACTIONS = eINSTANCE.getAbstractViewElement_Actions();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VIEW_ELEMENT__EVENTS = eINSTANCE.getAbstractViewElement_Events();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VIEW_ELEMENT__LABEL = eINSTANCE.getAbstractViewElement_Label();

		/**
		 * The meta object literal for the '<em><b>Data Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VIEW_ELEMENT__DATA_BINDINGS = eINSTANCE.getAbstractViewElement_DataBindings();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewContainer()
		 * @generated
		 */
		EClass VIEW_CONTAINER = eINSTANCE.getViewContainer();

		/**
		 * The meta object literal for the '<em><b>Owned Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_CONTAINER__OWNED_ELEMENTS = eINSTANCE.getViewContainer_OwnedElements();

		/**
		 * The meta object literal for the '<em><b>View Containers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_CONTAINER__VIEW_CONTAINERS = eINSTANCE.getViewContainer_ViewContainers();

		/**
		 * The meta object literal for the '<em><b>View Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_CONTAINER__VIEW_ELEMENTS = eINSTANCE.getViewContainer_ViewElements();

		/**
		 * The meta object literal for the '<em><b>View Container References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_CONTAINER__VIEW_CONTAINER_REFERENCES = eINSTANCE.getViewContainer_ViewContainerReferences();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewElementImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewElement()
		 * @generated
		 */
		EClass VIEW_ELEMENT = eINSTANCE.getViewElement();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_ELEMENT__REQUIRED = eINSTANCE.getViewElement_Required();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_ELEMENT__TYPE = eINSTANCE.getViewElement_Type();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewActionImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewAction()
		 * @generated
		 */
		EClass VIEW_ACTION = eINSTANCE.getViewAction();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewEventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewEventImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewEvent()
		 * @generated
		 */
		EClass VIEW_EVENT = eINSTANCE.getViewEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_EVENT__TYPE = eINSTANCE.getViewEvent_Type();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.EntityBindingImpl <em>Entity Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.EntityBindingImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getEntityBinding()
		 * @generated
		 */
		EClass ENTITY_BINDING = eINSTANCE.getEntityBinding();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_BINDING__ENTITY = eINSTANCE.getEntityBinding_Entity();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.EntityPropertyBindingImpl <em>Entity Property Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.EntityPropertyBindingImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getEntityPropertyBinding()
		 * @generated
		 */
		EClass ENTITY_PROPERTY_BINDING = eINSTANCE.getEntityPropertyBinding();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_PROPERTY_BINDING__PROPERTY = eINSTANCE.getEntityPropertyBinding_Property();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.DTOPropertyBindingImpl <em>DTO Property Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.DTOPropertyBindingImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getDTOPropertyBinding()
		 * @generated
		 */
		EClass DTO_PROPERTY_BINDING = eINSTANCE.getDTOPropertyBinding();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTO_PROPERTY_BINDING__PROPERTY = eINSTANCE.getDTOPropertyBinding_Property();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.DTOBindingImpl <em>DTO Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.DTOBindingImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getDTOBinding()
		 * @generated
		 */
		EClass DTO_BINDING = eINSTANCE.getDTOBinding();

		/**
		 * The meta object literal for the '<em><b>Dto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DTO_BINDING__DTO = eINSTANCE.getDTOBinding_Dto();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.DataBindingImpl <em>Data Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.DataBindingImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getDataBinding()
		 * @generated
		 */
		EClass DATA_BINDING = eINSTANCE.getDataBinding();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerReferenceImpl <em>Container Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewContainerReferenceImpl
		 * @see org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl#getViewContainerReference()
		 * @generated
		 */
		EClass VIEW_CONTAINER_REFERENCE = eINSTANCE.getViewContainerReference();

		/**
		 * The meta object literal for the '<em><b>View Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER = eINSTANCE.getViewContainerReference_ViewContainer();

	}

} //ViewPackage
