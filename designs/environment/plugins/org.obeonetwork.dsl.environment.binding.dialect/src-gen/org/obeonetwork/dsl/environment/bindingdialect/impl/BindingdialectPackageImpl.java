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
package org.obeonetwork.dsl.environment.bindingdialect.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectFactory;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;
import org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionPackage;
import org.obeonetwork.dsl.environment.bindingdialect.description.impl.DescriptionPackageImpl;

import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BindingdialectPackageImpl extends EPackageImpl implements BindingdialectPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dBindingEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dBindingEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dBoundElementEClass = null;

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
	 * @see org.obeonetwork.dsl.environment.bindingdialect.BindingdialectPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BindingdialectPackageImpl() {
		super(eNS_URI, BindingdialectFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BindingdialectPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BindingdialectPackage init() {
		if (isInited) return (BindingdialectPackage)EPackage.Registry.INSTANCE.getEPackage(BindingdialectPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBindingdialectPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BindingdialectPackageImpl theBindingdialectPackage = registeredBindingdialectPackage instanceof BindingdialectPackageImpl ? (BindingdialectPackageImpl)registeredBindingdialectPackage : new BindingdialectPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ViewpointPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DescriptionPackage.eNS_URI);
		DescriptionPackageImpl theDescriptionPackage = (DescriptionPackageImpl)(registeredPackage instanceof DescriptionPackageImpl ? registeredPackage : DescriptionPackage.eINSTANCE);

		// Create package meta-data objects
		theBindingdialectPackage.createPackageContents();
		theDescriptionPackage.createPackageContents();

		// Initialize created meta-data
		theBindingdialectPackage.initializePackageContents();
		theDescriptionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBindingdialectPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BindingdialectPackage.eNS_URI, theBindingdialectPackage);
		return theBindingdialectPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBindingEditor() {
		return dBindingEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBindingEditor_Description() {
		return (EReference)dBindingEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBindingEditor_BoundElements() {
		return (EReference)dBindingEditorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBindingEditor_BindingEdges() {
		return (EReference)dBindingEditorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBindingEdge() {
		return dBindingEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBindingEdge_Left() {
		return (EReference)dBindingEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBindingEdge_Right() {
		return (EReference)dBindingEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBoundElement() {
		return dBoundElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBoundElement_Parent() {
		return (EReference)dBoundElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBoundElement_Children() {
		return (EReference)dBoundElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBoundElement_EdgesAsLeft() {
		return (EReference)dBoundElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBoundElement_EdgesAsRight() {
		return (EReference)dBoundElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBoundElement_Edges() {
		return (EReference)dBoundElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingdialectFactory getBindingdialectFactory() {
		return (BindingdialectFactory)getEFactoryInstance();
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
		dBindingEditorEClass = createEClass(DBINDING_EDITOR);
		createEReference(dBindingEditorEClass, DBINDING_EDITOR__DESCRIPTION);
		createEReference(dBindingEditorEClass, DBINDING_EDITOR__BOUND_ELEMENTS);
		createEReference(dBindingEditorEClass, DBINDING_EDITOR__BINDING_EDGES);

		dBindingEdgeEClass = createEClass(DBINDING_EDGE);
		createEReference(dBindingEdgeEClass, DBINDING_EDGE__LEFT);
		createEReference(dBindingEdgeEClass, DBINDING_EDGE__RIGHT);

		dBoundElementEClass = createEClass(DBOUND_ELEMENT);
		createEReference(dBoundElementEClass, DBOUND_ELEMENT__PARENT);
		createEReference(dBoundElementEClass, DBOUND_ELEMENT__CHILDREN);
		createEReference(dBoundElementEClass, DBOUND_ELEMENT__EDGES_AS_LEFT);
		createEReference(dBoundElementEClass, DBOUND_ELEMENT__EDGES_AS_RIGHT);
		createEReference(dBoundElementEClass, DBOUND_ELEMENT__EDGES);
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
		DescriptionPackage theDescriptionPackage = (DescriptionPackage)EPackage.Registry.INSTANCE.getEPackage(DescriptionPackage.eNS_URI);
		ViewpointPackage theViewpointPackage = (ViewpointPackage)EPackage.Registry.INSTANCE.getEPackage(ViewpointPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theDescriptionPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dBindingEditorEClass.getESuperTypes().add(theViewpointPackage.getDRepresentation());
		dBindingEditorEClass.getESuperTypes().add(theViewpointPackage.getDSemanticDecorator());
		dBindingEdgeEClass.getESuperTypes().add(theViewpointPackage.getDRepresentationElement());
		dBoundElementEClass.getESuperTypes().add(theViewpointPackage.getDRepresentationElement());

		// Initialize classes and features; add operations and parameters
		initEClass(dBindingEditorEClass, DBindingEditor.class, "DBindingEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDBindingEditor_Description(), theDescriptionPackage.getDBindingEditorDescription(), null, "description", null, 1, 1, DBindingEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBindingEditor_BoundElements(), this.getDBoundElement(), null, "boundElements", null, 0, -1, DBindingEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBindingEditor_BindingEdges(), this.getDBindingEdge(), null, "bindingEdges", null, 0, -1, DBindingEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dBindingEdgeEClass, DBindingEdge.class, "DBindingEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDBindingEdge_Left(), this.getDBoundElement(), this.getDBoundElement_EdgesAsLeft(), "left", null, 1, 1, DBindingEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBindingEdge_Right(), this.getDBoundElement(), this.getDBoundElement_EdgesAsRight(), "right", null, 1, 1, DBindingEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dBoundElementEClass, DBoundElement.class, "DBoundElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDBoundElement_Parent(), this.getDBoundElement(), this.getDBoundElement_Children(), "parent", null, 0, 1, DBoundElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBoundElement_Children(), this.getDBoundElement(), this.getDBoundElement_Parent(), "children", null, 0, -1, DBoundElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBoundElement_EdgesAsLeft(), this.getDBindingEdge(), this.getDBindingEdge_Left(), "edgesAsLeft", null, 0, -1, DBoundElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBoundElement_EdgesAsRight(), this.getDBindingEdge(), this.getDBindingEdge_Right(), "edgesAsRight", null, 0, -1, DBoundElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBoundElement_Edges(), this.getDBindingEdge(), null, "edges", null, 0, -1, DBoundElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(dBoundElementEClass, ecorePackage.getEString(), "getPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BindingdialectPackageImpl
