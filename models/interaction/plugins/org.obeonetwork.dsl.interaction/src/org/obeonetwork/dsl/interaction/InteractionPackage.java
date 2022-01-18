/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

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
 * @see org.obeonetwork.dsl.interaction.InteractionFactory
 * @model kind="package"
 * @generated
 */
public interface InteractionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "interaction";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/interaction/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "interaction";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InteractionPackage eINSTANCE = org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.NamedElementImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__TECHNICALID = NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__METADATAS = NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__KEYWORDS = NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__BEHAVIOURS = NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__BINDING_REGISTRIES = NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__CREATED_ON = NAMED_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__MODIFIED_ON = NAMED_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__PARTICIPANTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__MESSAGES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Executions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__EXECUTIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__STATE_INVARIANTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Interaction Uses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__INTERACTION_USES = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__ENDS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Combined Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__COMBINED_FRAGMENTS = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.ParticipantImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__TECHNICALID = NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__METADATAS = NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__KEYWORDS = NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__BEHAVIOURS = NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__BINDING_REGISTRIES = NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__CREATED_ON = NAMED_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__MODIFIED_ON = NAMED_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.EndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.EndImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getEnd()
	 * @generated
	 */
	int END = 10;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.MessageImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.InteractionFragmentImpl <em>Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionFragmentImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getInteractionFragment()
	 * @generated
	 */
	int INTERACTION_FRAGMENT = 11;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__TECHNICALID = NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__METADATAS = NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__KEYWORDS = NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__BEHAVIOURS = NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__BINDING_REGISTRIES = NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__CREATED_ON = NAMED_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__MODIFIED_ON = NAMED_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__STARTING_END = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT__FINISHING_END = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FRAGMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TECHNICALID = INTERACTION_FRAGMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__METADATAS = INTERACTION_FRAGMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__DESCRIPTION = INTERACTION_FRAGMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__KEYWORDS = INTERACTION_FRAGMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__BEHAVIOURS = INTERACTION_FRAGMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__BINDING_REGISTRIES = INTERACTION_FRAGMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__VERSION = INTERACTION_FRAGMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__CREATED_ON = INTERACTION_FRAGMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__MODIFIED_ON = INTERACTION_FRAGMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__NAME = INTERACTION_FRAGMENT__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__STARTING_END = INTERACTION_FRAGMENT__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__FINISHING_END = INTERACTION_FRAGMENT__FINISHING_END;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = INTERACTION_FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.ExecutionImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getExecution()
	 * @generated
	 */
	int EXECUTION = 4;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__TECHNICALID = INTERACTION_FRAGMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__METADATAS = INTERACTION_FRAGMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__DESCRIPTION = INTERACTION_FRAGMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__KEYWORDS = INTERACTION_FRAGMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__BEHAVIOURS = INTERACTION_FRAGMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__BINDING_REGISTRIES = INTERACTION_FRAGMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__VERSION = INTERACTION_FRAGMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__CREATED_ON = INTERACTION_FRAGMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__MODIFIED_ON = INTERACTION_FRAGMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__NAME = INTERACTION_FRAGMENT__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__STARTING_END = INTERACTION_FRAGMENT__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__FINISHING_END = INTERACTION_FRAGMENT__FINISHING_END;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__OWNER = INTERACTION_FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_COUNT = INTERACTION_FRAGMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.CreateParticipantMessageImpl <em>Create Participant Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.CreateParticipantMessageImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCreateParticipantMessage()
	 * @generated
	 */
	int CREATE_PARTICIPANT_MESSAGE = 5;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__TECHNICALID = MESSAGE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__METADATAS = MESSAGE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__DESCRIPTION = MESSAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__KEYWORDS = MESSAGE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__BEHAVIOURS = MESSAGE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__BINDING_REGISTRIES = MESSAGE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__VERSION = MESSAGE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__CREATED_ON = MESSAGE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__MODIFIED_ON = MESSAGE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__NAME = MESSAGE__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__STARTING_END = MESSAGE__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE__FINISHING_END = MESSAGE__FINISHING_END;

	/**
	 * The number of structural features of the '<em>Create Participant Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PARTICIPANT_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.DestroyParticipantMessageImpl <em>Destroy Participant Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.DestroyParticipantMessageImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getDestroyParticipantMessage()
	 * @generated
	 */
	int DESTROY_PARTICIPANT_MESSAGE = 6;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__TECHNICALID = MESSAGE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__METADATAS = MESSAGE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__DESCRIPTION = MESSAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__KEYWORDS = MESSAGE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__BEHAVIOURS = MESSAGE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__BINDING_REGISTRIES = MESSAGE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__VERSION = MESSAGE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__CREATED_ON = MESSAGE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__MODIFIED_ON = MESSAGE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__NAME = MESSAGE__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__STARTING_END = MESSAGE__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE__FINISHING_END = MESSAGE__FINISHING_END;

	/**
	 * The number of structural features of the '<em>Destroy Participant Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTROY_PARTICIPANT_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.ReturnMessageImpl <em>Return Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.ReturnMessageImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getReturnMessage()
	 * @generated
	 */
	int RETURN_MESSAGE = 7;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__TECHNICALID = MESSAGE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__METADATAS = MESSAGE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__DESCRIPTION = MESSAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__KEYWORDS = MESSAGE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__BEHAVIOURS = MESSAGE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__BINDING_REGISTRIES = MESSAGE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__VERSION = MESSAGE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__CREATED_ON = MESSAGE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__MODIFIED_ON = MESSAGE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__NAME = MESSAGE__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__STARTING_END = MESSAGE__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__FINISHING_END = MESSAGE__FINISHING_END;

	/**
	 * The feature id for the '<em><b>Invocation Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE__INVOCATION_MESSAGE = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.StateInvariantImpl <em>State Invariant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.StateInvariantImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getStateInvariant()
	 * @generated
	 */
	int STATE_INVARIANT = 8;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__TECHNICALID = INTERACTION_FRAGMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__METADATAS = INTERACTION_FRAGMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__DESCRIPTION = INTERACTION_FRAGMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__KEYWORDS = INTERACTION_FRAGMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__BEHAVIOURS = INTERACTION_FRAGMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__BINDING_REGISTRIES = INTERACTION_FRAGMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__VERSION = INTERACTION_FRAGMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__CREATED_ON = INTERACTION_FRAGMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__MODIFIED_ON = INTERACTION_FRAGMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__NAME = INTERACTION_FRAGMENT__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__STARTING_END = INTERACTION_FRAGMENT__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__FINISHING_END = INTERACTION_FRAGMENT__FINISHING_END;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT__OWNER = INTERACTION_FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Invariant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INVARIANT_FEATURE_COUNT = INTERACTION_FRAGMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.InteractionUseImpl <em>Use</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionUseImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getInteractionUse()
	 * @generated
	 */
	int INTERACTION_USE = 9;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__TECHNICALID = INTERACTION_FRAGMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__METADATAS = INTERACTION_FRAGMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__DESCRIPTION = INTERACTION_FRAGMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__KEYWORDS = INTERACTION_FRAGMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__BEHAVIOURS = INTERACTION_FRAGMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__BINDING_REGISTRIES = INTERACTION_FRAGMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__VERSION = INTERACTION_FRAGMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__CREATED_ON = INTERACTION_FRAGMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__MODIFIED_ON = INTERACTION_FRAGMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__NAME = INTERACTION_FRAGMENT__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__STARTING_END = INTERACTION_FRAGMENT__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__FINISHING_END = INTERACTION_FRAGMENT__FINISHING_END;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__TYPE = INTERACTION_FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__INTERACTION = INTERACTION_FRAGMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Covered Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE__COVERED_PARTICIPANTS = INTERACTION_FRAGMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_USE_FEATURE_COUNT = INTERACTION_FRAGMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__TECHNICALID = NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__METADATAS = NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__KEYWORDS = NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__BEHAVIOURS = NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__BINDING_REGISTRIES = NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__CREATED_ON = NAMED_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__MODIFIED_ON = NAMED_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__CONTEXT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.CombinedFragmentImpl <em>Combined Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.CombinedFragmentImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCombinedFragment()
	 * @generated
	 */
	int COMBINED_FRAGMENT = 12;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__TECHNICALID = INTERACTION_FRAGMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__METADATAS = INTERACTION_FRAGMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__DESCRIPTION = INTERACTION_FRAGMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__KEYWORDS = INTERACTION_FRAGMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__BEHAVIOURS = INTERACTION_FRAGMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__BINDING_REGISTRIES = INTERACTION_FRAGMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__VERSION = INTERACTION_FRAGMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__CREATED_ON = INTERACTION_FRAGMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__MODIFIED_ON = INTERACTION_FRAGMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__NAME = INTERACTION_FRAGMENT__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__STARTING_END = INTERACTION_FRAGMENT__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__FINISHING_END = INTERACTION_FRAGMENT__FINISHING_END;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__OPERATOR = INTERACTION_FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Covered Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__COVERED_PARTICIPANTS = INTERACTION_FRAGMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT__OWNED_OPERANDS = INTERACTION_FRAGMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Combined Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_FRAGMENT_FEATURE_COUNT = INTERACTION_FRAGMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.OperandImpl <em>Operand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.OperandImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getOperand()
	 * @generated
	 */
	int OPERAND = 13;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__TECHNICALID = INTERACTION_FRAGMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__METADATAS = INTERACTION_FRAGMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__DESCRIPTION = INTERACTION_FRAGMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__KEYWORDS = INTERACTION_FRAGMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__BEHAVIOURS = INTERACTION_FRAGMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__BINDING_REGISTRIES = INTERACTION_FRAGMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__VERSION = INTERACTION_FRAGMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__CREATED_ON = INTERACTION_FRAGMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__MODIFIED_ON = INTERACTION_FRAGMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__NAME = INTERACTION_FRAGMENT__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__STARTING_END = INTERACTION_FRAGMENT__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND__FINISHING_END = INTERACTION_FRAGMENT__FINISHING_END;

	/**
	 * The number of structural features of the '<em>Operand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERAND_FEATURE_COUNT = INTERACTION_FRAGMENT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.CallMessageImpl <em>Call Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.CallMessageImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCallMessage()
	 * @generated
	 */
	int CALL_MESSAGE = 14;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__TECHNICALID = MESSAGE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__METADATAS = MESSAGE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__DESCRIPTION = MESSAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__KEYWORDS = MESSAGE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__BEHAVIOURS = MESSAGE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__BINDING_REGISTRIES = MESSAGE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__VERSION = MESSAGE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__CREATED_ON = MESSAGE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__MODIFIED_ON = MESSAGE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__NAME = MESSAGE__NAME;

	/**
	 * The feature id for the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__STARTING_END = MESSAGE__STARTING_END;

	/**
	 * The feature id for the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE__FINISHING_END = MESSAGE__FINISHING_END;

	/**
	 * The number of structural features of the '<em>Call Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.interaction.impl.CompoundEndImpl <em>Compound End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.interaction.impl.CompoundEndImpl
	 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCompoundEnd()
	 * @generated
	 */
	int COMPOUND_END = 15;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__TECHNICALID = END__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__METADATAS = END__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__DESCRIPTION = END__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__KEYWORDS = END__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__BEHAVIOURS = END__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__BINDING_REGISTRIES = END__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__VERSION = END__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__CREATED_ON = END__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__MODIFIED_ON = END__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__NAME = END__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__CONTEXT = END__CONTEXT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__OWNER = END__OWNER;

	/**
	 * The feature id for the '<em><b>Other Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END__OTHER_OWNER = END_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_END_FEATURE_COUNT = END_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.obeonetwork.dsl.interaction.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.interaction.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.interaction.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.Interaction#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Participants</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction#getParticipants()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Participants();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.Interaction#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction#getMessages()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Messages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.Interaction#getExecutions <em>Executions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Executions</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction#getExecutions()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Executions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.Interaction#getStateInvariants <em>State Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Invariants</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction#getStateInvariants()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_StateInvariants();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.Interaction#getInteractionUses <em>Interaction Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interaction Uses</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction#getInteractionUses()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_InteractionUses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.Interaction#getEnds <em>Ends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ends</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction#getEnds()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Ends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.Interaction#getCombinedFragments <em>Combined Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Combined Fragments</em>'.
	 * @see org.obeonetwork.dsl.interaction.Interaction#getCombinedFragments()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_CombinedFragments();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see org.obeonetwork.dsl.interaction.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.Participant#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.interaction.Participant#getType()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_Type();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see org.obeonetwork.dsl.interaction.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution</em>'.
	 * @see org.obeonetwork.dsl.interaction.Execution
	 * @generated
	 */
	EClass getExecution();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.Execution#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.obeonetwork.dsl.interaction.Execution#getOwner()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Owner();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.CreateParticipantMessage <em>Create Participant Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Participant Message</em>'.
	 * @see org.obeonetwork.dsl.interaction.CreateParticipantMessage
	 * @generated
	 */
	EClass getCreateParticipantMessage();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.DestroyParticipantMessage <em>Destroy Participant Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Destroy Participant Message</em>'.
	 * @see org.obeonetwork.dsl.interaction.DestroyParticipantMessage
	 * @generated
	 */
	EClass getDestroyParticipantMessage();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.ReturnMessage <em>Return Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Message</em>'.
	 * @see org.obeonetwork.dsl.interaction.ReturnMessage
	 * @generated
	 */
	EClass getReturnMessage();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.ReturnMessage#getInvocationMessage <em>Invocation Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invocation Message</em>'.
	 * @see org.obeonetwork.dsl.interaction.ReturnMessage#getInvocationMessage()
	 * @see #getReturnMessage()
	 * @generated
	 */
	EReference getReturnMessage_InvocationMessage();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.StateInvariant <em>State Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Invariant</em>'.
	 * @see org.obeonetwork.dsl.interaction.StateInvariant
	 * @generated
	 */
	EClass getStateInvariant();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.StateInvariant#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.obeonetwork.dsl.interaction.StateInvariant#getOwner()
	 * @see #getStateInvariant()
	 * @generated
	 */
	EReference getStateInvariant_Owner();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.InteractionUse <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use</em>'.
	 * @see org.obeonetwork.dsl.interaction.InteractionUse
	 * @generated
	 */
	EClass getInteractionUse();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.interaction.InteractionUse#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.interaction.InteractionUse#getType()
	 * @see #getInteractionUse()
	 * @generated
	 */
	EAttribute getInteractionUse_Type();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.InteractionUse#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interaction</em>'.
	 * @see org.obeonetwork.dsl.interaction.InteractionUse#getInteraction()
	 * @see #getInteractionUse()
	 * @generated
	 */
	EReference getInteractionUse_Interaction();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.interaction.InteractionUse#getCoveredParticipants <em>Covered Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Covered Participants</em>'.
	 * @see org.obeonetwork.dsl.interaction.InteractionUse#getCoveredParticipants()
	 * @see #getInteractionUse()
	 * @generated
	 */
	EReference getInteractionUse_CoveredParticipants();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see org.obeonetwork.dsl.interaction.End
	 * @generated
	 */
	EClass getEnd();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.End#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.obeonetwork.dsl.interaction.End#getContext()
	 * @see #getEnd()
	 * @generated
	 */
	EReference getEnd_Context();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.End#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.obeonetwork.dsl.interaction.End#getOwner()
	 * @see #getEnd()
	 * @generated
	 */
	EReference getEnd_Owner();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.InteractionFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment</em>'.
	 * @see org.obeonetwork.dsl.interaction.InteractionFragment
	 * @generated
	 */
	EClass getInteractionFragment();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.InteractionFragment#getStartingEnd <em>Starting End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Starting End</em>'.
	 * @see org.obeonetwork.dsl.interaction.InteractionFragment#getStartingEnd()
	 * @see #getInteractionFragment()
	 * @generated
	 */
	EReference getInteractionFragment_StartingEnd();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.InteractionFragment#getFinishingEnd <em>Finishing End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Finishing End</em>'.
	 * @see org.obeonetwork.dsl.interaction.InteractionFragment#getFinishingEnd()
	 * @see #getInteractionFragment()
	 * @generated
	 */
	EReference getInteractionFragment_FinishingEnd();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.CombinedFragment <em>Combined Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combined Fragment</em>'.
	 * @see org.obeonetwork.dsl.interaction.CombinedFragment
	 * @generated
	 */
	EClass getCombinedFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.interaction.CombinedFragment#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.obeonetwork.dsl.interaction.CombinedFragment#getOperator()
	 * @see #getCombinedFragment()
	 * @generated
	 */
	EAttribute getCombinedFragment_Operator();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.interaction.CombinedFragment#getCoveredParticipants <em>Covered Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Covered Participants</em>'.
	 * @see org.obeonetwork.dsl.interaction.CombinedFragment#getCoveredParticipants()
	 * @see #getCombinedFragment()
	 * @generated
	 */
	EReference getCombinedFragment_CoveredParticipants();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.interaction.CombinedFragment#getOwnedOperands <em>Owned Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operands</em>'.
	 * @see org.obeonetwork.dsl.interaction.CombinedFragment#getOwnedOperands()
	 * @see #getCombinedFragment()
	 * @generated
	 */
	EReference getCombinedFragment_OwnedOperands();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.Operand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operand</em>'.
	 * @see org.obeonetwork.dsl.interaction.Operand
	 * @generated
	 */
	EClass getOperand();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.CallMessage <em>Call Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Message</em>'.
	 * @see org.obeonetwork.dsl.interaction.CallMessage
	 * @generated
	 */
	EClass getCallMessage();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.interaction.CompoundEnd <em>Compound End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound End</em>'.
	 * @see org.obeonetwork.dsl.interaction.CompoundEnd
	 * @generated
	 */
	EClass getCompoundEnd();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.interaction.CompoundEnd#getOtherOwner <em>Other Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other Owner</em>'.
	 * @see org.obeonetwork.dsl.interaction.CompoundEnd#getOtherOwner()
	 * @see #getCompoundEnd()
	 * @generated
	 */
	EReference getCompoundEnd_OtherOwner();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InteractionFactory getInteractionFactory();

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
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.NamedElementImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__PARTICIPANTS = eINSTANCE.getInteraction_Participants();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__MESSAGES = eINSTANCE.getInteraction_Messages();

		/**
		 * The meta object literal for the '<em><b>Executions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__EXECUTIONS = eINSTANCE.getInteraction_Executions();

		/**
		 * The meta object literal for the '<em><b>State Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__STATE_INVARIANTS = eINSTANCE.getInteraction_StateInvariants();

		/**
		 * The meta object literal for the '<em><b>Interaction Uses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__INTERACTION_USES = eINSTANCE.getInteraction_InteractionUses();

		/**
		 * The meta object literal for the '<em><b>Ends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__ENDS = eINSTANCE.getInteraction_Ends();

		/**
		 * The meta object literal for the '<em><b>Combined Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__COMBINED_FRAGMENTS = eINSTANCE.getInteraction_CombinedFragments();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.ParticipantImpl <em>Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.ParticipantImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getParticipant()
		 * @generated
		 */
		EClass PARTICIPANT = eINSTANCE.getParticipant();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__TYPE = eINSTANCE.getParticipant_Type();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.MessageImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.ExecutionImpl <em>Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.ExecutionImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getExecution()
		 * @generated
		 */
		EClass EXECUTION = eINSTANCE.getExecution();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__OWNER = eINSTANCE.getExecution_Owner();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.CreateParticipantMessageImpl <em>Create Participant Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.CreateParticipantMessageImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCreateParticipantMessage()
		 * @generated
		 */
		EClass CREATE_PARTICIPANT_MESSAGE = eINSTANCE.getCreateParticipantMessage();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.DestroyParticipantMessageImpl <em>Destroy Participant Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.DestroyParticipantMessageImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getDestroyParticipantMessage()
		 * @generated
		 */
		EClass DESTROY_PARTICIPANT_MESSAGE = eINSTANCE.getDestroyParticipantMessage();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.ReturnMessageImpl <em>Return Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.ReturnMessageImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getReturnMessage()
		 * @generated
		 */
		EClass RETURN_MESSAGE = eINSTANCE.getReturnMessage();

		/**
		 * The meta object literal for the '<em><b>Invocation Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_MESSAGE__INVOCATION_MESSAGE = eINSTANCE.getReturnMessage_InvocationMessage();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.StateInvariantImpl <em>State Invariant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.StateInvariantImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getStateInvariant()
		 * @generated
		 */
		EClass STATE_INVARIANT = eINSTANCE.getStateInvariant();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_INVARIANT__OWNER = eINSTANCE.getStateInvariant_Owner();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.InteractionUseImpl <em>Use</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionUseImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getInteractionUse()
		 * @generated
		 */
		EClass INTERACTION_USE = eINSTANCE.getInteractionUse();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION_USE__TYPE = eINSTANCE.getInteractionUse_Type();

		/**
		 * The meta object literal for the '<em><b>Interaction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION_USE__INTERACTION = eINSTANCE.getInteractionUse_Interaction();

		/**
		 * The meta object literal for the '<em><b>Covered Participants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION_USE__COVERED_PARTICIPANTS = eINSTANCE.getInteractionUse_CoveredParticipants();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.EndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.EndImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getEnd()
		 * @generated
		 */
		EClass END = eINSTANCE.getEnd();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END__CONTEXT = eINSTANCE.getEnd_Context();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END__OWNER = eINSTANCE.getEnd_Owner();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.InteractionFragmentImpl <em>Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionFragmentImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getInteractionFragment()
		 * @generated
		 */
		EClass INTERACTION_FRAGMENT = eINSTANCE.getInteractionFragment();

		/**
		 * The meta object literal for the '<em><b>Starting End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION_FRAGMENT__STARTING_END = eINSTANCE.getInteractionFragment_StartingEnd();

		/**
		 * The meta object literal for the '<em><b>Finishing End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION_FRAGMENT__FINISHING_END = eINSTANCE.getInteractionFragment_FinishingEnd();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.CombinedFragmentImpl <em>Combined Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.CombinedFragmentImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCombinedFragment()
		 * @generated
		 */
		EClass COMBINED_FRAGMENT = eINSTANCE.getCombinedFragment();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBINED_FRAGMENT__OPERATOR = eINSTANCE.getCombinedFragment_Operator();

		/**
		 * The meta object literal for the '<em><b>Covered Participants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMBINED_FRAGMENT__COVERED_PARTICIPANTS = eINSTANCE.getCombinedFragment_CoveredParticipants();

		/**
		 * The meta object literal for the '<em><b>Owned Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMBINED_FRAGMENT__OWNED_OPERANDS = eINSTANCE.getCombinedFragment_OwnedOperands();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.OperandImpl <em>Operand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.OperandImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getOperand()
		 * @generated
		 */
		EClass OPERAND = eINSTANCE.getOperand();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.CallMessageImpl <em>Call Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.CallMessageImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCallMessage()
		 * @generated
		 */
		EClass CALL_MESSAGE = eINSTANCE.getCallMessage();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.interaction.impl.CompoundEndImpl <em>Compound End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.interaction.impl.CompoundEndImpl
		 * @see org.obeonetwork.dsl.interaction.impl.InteractionPackageImpl#getCompoundEnd()
		 * @generated
		 */
		EClass COMPOUND_END = eINSTANCE.getCompoundEnd();

		/**
		 * The meta object literal for the '<em><b>Other Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_END__OTHER_OWNER = eINSTANCE.getCompoundEnd_OtherOwner();

	}

} //InteractionPackage
