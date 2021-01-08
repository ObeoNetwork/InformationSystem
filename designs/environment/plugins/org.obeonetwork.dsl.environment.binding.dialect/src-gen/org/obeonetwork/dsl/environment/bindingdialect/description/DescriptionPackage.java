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
package org.obeonetwork.dsl.environment.bindingdialect.description;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;

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
 * @see org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionFactory
 * @model kind="package"
 * @generated
 */
public interface DescriptionPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2021 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "description";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/environment/binding/dialect/description/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "description";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DescriptionPackage eINSTANCE = org.obeonetwork.dsl.environment.bindingdialect.description.impl.DescriptionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorDescriptionImpl <em>DBinding Editor Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorDescriptionImpl
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DescriptionPackageImpl#getDBindingEditorDescription()
	 * @generated
	 */
	int DBINDING_EDITOR_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__DOCUMENTATION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>End User Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__END_USER_DOCUMENTATION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__END_USER_DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__NAME = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__LABEL = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__LABEL;

	/**
	 * The feature id for the '<em><b>Title Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__TITLE_EXPRESSION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__TITLE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Initialisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__INITIALISATION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__INITIALISATION;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__METAMODEL = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__METAMODEL;

	/**
	 * The feature id for the '<em><b>Show On Startup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION__SHOW_ON_STARTUP = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__SHOW_ON_STARTUP;

	/**
	 * The number of structural features of the '<em>DBinding Editor Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_DESCRIPTION_FEATURE_COUNT = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorCreationDescriptionImpl <em>DBinding Editor Creation Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorCreationDescriptionImpl
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DescriptionPackageImpl#getDBindingEditorCreationDescription()
	 * @generated
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__DOCUMENTATION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__NAME = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__LABEL = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__LABEL;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__PRECONDITION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Force Refresh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__FORCE_REFRESH = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__FORCE_REFRESH;

	/**
	 * The feature id for the '<em><b>Filters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__FILTERS = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__FILTERS;

	/**
	 * The feature id for the '<em><b>Elements To Select</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__ELEMENTS_TO_SELECT = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__ELEMENTS_TO_SELECT;

	/**
	 * The feature id for the '<em><b>Inverse Selection Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__INVERSE_SELECTION_ORDER = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__INVERSE_SELECTION_ORDER;

	/**
	 * The feature id for the '<em><b>Title Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__TITLE_EXPRESSION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__TITLE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Browse Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__BROWSE_EXPRESSION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__BROWSE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Representation Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__REPRESENTATION_DESCRIPTION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__REPRESENTATION_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Initial Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__INITIAL_OPERATION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__INITIAL_OPERATION;

	/**
	 * The feature id for the '<em><b>Container View Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__CONTAINER_VIEW_VARIABLE = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__CONTAINER_VIEW_VARIABLE;

	/**
	 * The feature id for the '<em><b>Representation Name Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__REPRESENTATION_NAME_VARIABLE = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__REPRESENTATION_NAME_VARIABLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DBinding Editor Creation Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBINDING_EDITOR_CREATION_DESCRIPTION_FEATURE_COUNT = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorDescription <em>DBinding Editor Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DBinding Editor Description</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorDescription
	 * @generated
	 */
	EClass getDBindingEditorDescription();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription <em>DBinding Editor Creation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DBinding Editor Creation Description</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription
	 * @generated
	 */
	EClass getDBindingEditorCreationDescription();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Description</em>'.
	 * @see org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription#getDescription()
	 * @see #getDBindingEditorCreationDescription()
	 * @generated
	 */
	EReference getDBindingEditorCreationDescription_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DescriptionFactory getDescriptionFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorDescriptionImpl <em>DBinding Editor Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorDescriptionImpl
		 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DescriptionPackageImpl#getDBindingEditorDescription()
		 * @generated
		 */
		EClass DBINDING_EDITOR_DESCRIPTION = eINSTANCE.getDBindingEditorDescription();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorCreationDescriptionImpl <em>DBinding Editor Creation Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DBindingEditorCreationDescriptionImpl
		 * @see org.obeonetwork.dsl.environment.bindingdialect.description.impl.DescriptionPackageImpl#getDBindingEditorCreationDescription()
		 * @generated
		 */
		EClass DBINDING_EDITOR_CREATION_DESCRIPTION = eINSTANCE.getDBindingEditorCreationDescription();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBINDING_EDITOR_CREATION_DESCRIPTION__DESCRIPTION = eINSTANCE.getDBindingEditorCreationDescription_Description();

	}

} //DescriptionPackage
