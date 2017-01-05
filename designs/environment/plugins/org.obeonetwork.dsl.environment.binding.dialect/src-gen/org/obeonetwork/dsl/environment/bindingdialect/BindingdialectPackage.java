/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.bindingdialect;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.sirius.viewpoint.ViewpointPackage;

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
 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectFactory
 * @model kind="package"
 * @generated
 */
public interface BindingdialectPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bindingdialect";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/environment/binding/dialect/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bindingdialect";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BindingdialectPackage eINSTANCE = org.obeonetwork.dsl.environment.bindingdialect.impl.BindingdialectPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl <em>DBinding Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl
	 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.BindingdialectPackageImpl#getDBindingEditor()
	 * @generated
	 */
	int DBINDING_EDITOR = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__DOCUMENTATION = ViewpointPackage.DREPRESENTATION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__EANNOTATIONS = ViewpointPackage.DREPRESENTATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Representation Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__OWNED_REPRESENTATION_ELEMENTS = ViewpointPackage.DREPRESENTATION__OWNED_REPRESENTATION_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Representation Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__REPRESENTATION_ELEMENTS = ViewpointPackage.DREPRESENTATION__REPRESENTATION_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__NAME = ViewpointPackage.DREPRESENTATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Annotation Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__OWNED_ANNOTATION_ENTRIES = ViewpointPackage.DREPRESENTATION__OWNED_ANNOTATION_ENTRIES;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__TARGET = ViewpointPackage.DREPRESENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__DESCRIPTION = ViewpointPackage.DREPRESENTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bound Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__BOUND_ELEMENTS = ViewpointPackage.DREPRESENTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Binding Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR__BINDING_EDGES = ViewpointPackage.DREPRESENTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>DBinding Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_FEATURE_COUNT = ViewpointPackage.DREPRESENTATION_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEdgeImpl <em>DBinding Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEdgeImpl
	 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.BindingdialectPackageImpl#getDBindingEdge()
	 * @generated
	 */
	int DBINDING_EDGE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDGE__TARGET = ViewpointPackage.DREPRESENTATION_ELEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDGE__NAME = ViewpointPackage.DREPRESENTATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Semantic Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDGE__SEMANTIC_ELEMENTS = ViewpointPackage.DREPRESENTATION_ELEMENT__SEMANTIC_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDGE__LEFT = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDGE__RIGHT = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DBinding Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDGE_FEATURE_COUNT = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl <em>DBound Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl
	 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.BindingdialectPackageImpl#getDBoundElement()
	 * @generated
	 */
	int DBOUND_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__TARGET = ViewpointPackage.DREPRESENTATION_ELEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__NAME = ViewpointPackage.DREPRESENTATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Semantic Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__SEMANTIC_ELEMENTS = ViewpointPackage.DREPRESENTATION_ELEMENT__SEMANTIC_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__PARENT = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__CHILDREN = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Edges As Left</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__EDGES_AS_LEFT = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Edges As Right</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__EDGES_AS_RIGHT = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT__EDGES = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>DBound Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBOUND_ELEMENT_FEATURE_COUNT = ViewpointPackage.DREPRESENTATION_ELEMENT_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor <em>DBinding Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DBinding Editor</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor
	 * @generated
	 */
	EClass getDBindingEditor();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Description</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getDescription()
	 * @see #getDBindingEditor()
	 * @generated
	 */
	EReference getDBindingEditor_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getBoundElements <em>Bound Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bound Elements</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getBoundElements()
	 * @see #getDBindingEditor()
	 * @generated
	 */
	EReference getDBindingEditor_BoundElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getBindingEdges <em>Binding Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Binding Edges</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor#getBindingEdges()
	 * @see #getDBindingEditor()
	 * @generated
	 */
	EReference getDBindingEditor_BindingEdges();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge <em>DBinding Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DBinding Edge</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge
	 * @generated
	 */
	EClass getDBindingEdge();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getLeft()
	 * @see #getDBindingEdge()
	 * @generated
	 */
	EReference getDBindingEdge_Left();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge#getRight()
	 * @see #getDBindingEdge()
	 * @generated
	 */
	EReference getDBindingEdge_Right();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement <em>DBound Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DBound Element</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement
	 * @generated
	 */
	EClass getDBoundElement();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getParent()
	 * @see #getDBoundElement()
	 * @generated
	 */
	EReference getDBoundElement_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getChildren()
	 * @see #getDBoundElement()
	 * @generated
	 */
	EReference getDBoundElement_Children();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsLeft <em>Edges As Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges As Left</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsLeft()
	 * @see #getDBoundElement()
	 * @generated
	 */
	EReference getDBoundElement_EdgesAsLeft();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsRight <em>Edges As Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges As Right</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdgesAsRight()
	 * @see #getDBoundElement()
	 * @generated
	 */
	EReference getDBoundElement_EdgesAsRight();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.DBoundElement#getEdges()
	 * @see #getDBoundElement()
	 * @generated
	 */
	EReference getDBoundElement_Edges();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BindingdialectFactory getBindingdialectFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl <em>DBinding Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEditorImpl
		 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.BindingdialectPackageImpl#getDBindingEditor()
		 * @generated
		 */
		EClass DBINDING_EDITOR = eINSTANCE.getDBindingEditor();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBINDING_EDITOR__DESCRIPTION = eINSTANCE.getDBindingEditor_Description();

		/**
		 * The meta object literal for the '<em><b>Bound Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBINDING_EDITOR__BOUND_ELEMENTS = eINSTANCE.getDBindingEditor_BoundElements();

		/**
		 * The meta object literal for the '<em><b>Binding Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBINDING_EDITOR__BINDING_EDGES = eINSTANCE.getDBindingEditor_BindingEdges();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEdgeImpl <em>DBinding Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.DBindingEdgeImpl
		 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.BindingdialectPackageImpl#getDBindingEdge()
		 * @generated
		 */
		EClass DBINDING_EDGE = eINSTANCE.getDBindingEdge();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBINDING_EDGE__LEFT = eINSTANCE.getDBindingEdge_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBINDING_EDGE__RIGHT = eINSTANCE.getDBindingEdge_Right();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl <em>DBound Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.DBoundElementImpl
		 * @see org.obeonetwork.dsl.environment.bindingdialect.impl.BindingdialectPackageImpl#getDBoundElement()
		 * @generated
		 */
		EClass DBOUND_ELEMENT = eINSTANCE.getDBoundElement();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBOUND_ELEMENT__PARENT = eINSTANCE.getDBoundElement_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBOUND_ELEMENT__CHILDREN = eINSTANCE.getDBoundElement_Children();

		/**
		 * The meta object literal for the '<em><b>Edges As Left</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBOUND_ELEMENT__EDGES_AS_LEFT = eINSTANCE.getDBoundElement_EdgesAsLeft();

		/**
		 * The meta object literal for the '<em><b>Edges As Right</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBOUND_ELEMENT__EDGES_AS_RIGHT = eINSTANCE.getDBoundElement_EdgesAsRight();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBOUND_ELEMENT__EDGES = eINSTANCE.getDBoundElement_Edges();

	}

} //BindingdialectPackage
