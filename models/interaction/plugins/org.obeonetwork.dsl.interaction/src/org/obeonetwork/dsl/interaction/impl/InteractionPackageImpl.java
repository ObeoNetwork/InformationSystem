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
package org.obeonetwork.dsl.interaction.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.CompoundEnd;
import org.obeonetwork.dsl.interaction.CreateParticipantMessage;
import org.obeonetwork.dsl.interaction.DestroyParticipantMessage;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.Execution;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionFactory;
import org.obeonetwork.dsl.interaction.InteractionFragment;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.Message;
import org.obeonetwork.dsl.interaction.NamedElement;
import org.obeonetwork.dsl.interaction.Operand;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.interaction.ReturnMessage;
import org.obeonetwork.dsl.interaction.StateInvariant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InteractionPackageImpl extends EPackageImpl implements InteractionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createParticipantMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass destroyParticipantMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateInvariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionUseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combinedFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundEndEClass = null;

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
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InteractionPackageImpl() {
		super(eNS_URI, InteractionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InteractionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InteractionPackage init() {
		if (isInited) return (InteractionPackage)EPackage.Registry.INSTANCE.getEPackage(InteractionPackage.eNS_URI);

		// Obtain or create and register package
		InteractionPackageImpl theInteractionPackage = (InteractionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InteractionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InteractionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInteractionPackage.createPackageContents();

		// Initialize created meta-data
		theInteractionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInteractionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InteractionPackage.eNS_URI, theInteractionPackage);
		return theInteractionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteraction() {
		return interactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Participants() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Messages() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Executions() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_StateInvariants() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_InteractionUses() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Ends() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_CombinedFragments() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipant() {
		return participantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_Type() {
		return (EReference)participantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecution() {
		return executionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecution_Owner() {
		return (EReference)executionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateParticipantMessage() {
		return createParticipantMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDestroyParticipantMessage() {
		return destroyParticipantMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnMessage() {
		return returnMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnMessage_InvocationMessage() {
		return (EReference)returnMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateInvariant() {
		return stateInvariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateInvariant_Owner() {
		return (EReference)stateInvariantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteractionUse() {
		return interactionUseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteractionUse_Type() {
		return (EAttribute)interactionUseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionUse_Interaction() {
		return (EReference)interactionUseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionUse_CoveredParticipants() {
		return (EReference)interactionUseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnd() {
		return endEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnd_Context() {
		return (EReference)endEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnd_Owner() {
		return (EReference)endEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteractionFragment() {
		return interactionFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionFragment_StartingEnd() {
		return (EReference)interactionFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionFragment_FinishingEnd() {
		return (EReference)interactionFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombinedFragment() {
		return combinedFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedFragment_Operator() {
		return (EAttribute)combinedFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedFragment_CoveredParticipants() {
		return (EReference)combinedFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedFragment_OwnedOperands() {
		return (EReference)combinedFragmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperand() {
		return operandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallMessage() {
		return callMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundEnd() {
		return compoundEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundEnd_OtherOwner() {
		return (EReference)compoundEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionFactory getInteractionFactory() {
		return (InteractionFactory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		interactionEClass = createEClass(INTERACTION);
		createEReference(interactionEClass, INTERACTION__PARTICIPANTS);
		createEReference(interactionEClass, INTERACTION__MESSAGES);
		createEReference(interactionEClass, INTERACTION__EXECUTIONS);
		createEReference(interactionEClass, INTERACTION__STATE_INVARIANTS);
		createEReference(interactionEClass, INTERACTION__INTERACTION_USES);
		createEReference(interactionEClass, INTERACTION__ENDS);
		createEReference(interactionEClass, INTERACTION__COMBINED_FRAGMENTS);

		participantEClass = createEClass(PARTICIPANT);
		createEReference(participantEClass, PARTICIPANT__TYPE);

		messageEClass = createEClass(MESSAGE);

		executionEClass = createEClass(EXECUTION);
		createEReference(executionEClass, EXECUTION__OWNER);

		createParticipantMessageEClass = createEClass(CREATE_PARTICIPANT_MESSAGE);

		destroyParticipantMessageEClass = createEClass(DESTROY_PARTICIPANT_MESSAGE);

		returnMessageEClass = createEClass(RETURN_MESSAGE);
		createEReference(returnMessageEClass, RETURN_MESSAGE__INVOCATION_MESSAGE);

		stateInvariantEClass = createEClass(STATE_INVARIANT);
		createEReference(stateInvariantEClass, STATE_INVARIANT__OWNER);

		interactionUseEClass = createEClass(INTERACTION_USE);
		createEAttribute(interactionUseEClass, INTERACTION_USE__TYPE);
		createEReference(interactionUseEClass, INTERACTION_USE__INTERACTION);
		createEReference(interactionUseEClass, INTERACTION_USE__COVERED_PARTICIPANTS);

		endEClass = createEClass(END);
		createEReference(endEClass, END__CONTEXT);
		createEReference(endEClass, END__OWNER);

		interactionFragmentEClass = createEClass(INTERACTION_FRAGMENT);
		createEReference(interactionFragmentEClass, INTERACTION_FRAGMENT__STARTING_END);
		createEReference(interactionFragmentEClass, INTERACTION_FRAGMENT__FINISHING_END);

		combinedFragmentEClass = createEClass(COMBINED_FRAGMENT);
		createEAttribute(combinedFragmentEClass, COMBINED_FRAGMENT__OPERATOR);
		createEReference(combinedFragmentEClass, COMBINED_FRAGMENT__COVERED_PARTICIPANTS);
		createEReference(combinedFragmentEClass, COMBINED_FRAGMENT__OWNED_OPERANDS);

		operandEClass = createEClass(OPERAND);

		callMessageEClass = createEClass(CALL_MESSAGE);

		compoundEndEClass = createEClass(COMPOUND_END);
		createEReference(compoundEndEClass, COMPOUND_END__OTHER_OWNER);
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
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namedElementEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		interactionEClass.getESuperTypes().add(this.getNamedElement());
		interactionEClass.getESuperTypes().add(theEnvironmentPackage.getBehaviour());
		participantEClass.getESuperTypes().add(this.getNamedElement());
		messageEClass.getESuperTypes().add(this.getInteractionFragment());
		executionEClass.getESuperTypes().add(this.getInteractionFragment());
		createParticipantMessageEClass.getESuperTypes().add(this.getMessage());
		destroyParticipantMessageEClass.getESuperTypes().add(this.getMessage());
		returnMessageEClass.getESuperTypes().add(this.getMessage());
		stateInvariantEClass.getESuperTypes().add(this.getInteractionFragment());
		interactionUseEClass.getESuperTypes().add(this.getInteractionFragment());
		endEClass.getESuperTypes().add(this.getNamedElement());
		interactionFragmentEClass.getESuperTypes().add(this.getNamedElement());
		combinedFragmentEClass.getESuperTypes().add(this.getInteractionFragment());
		operandEClass.getESuperTypes().add(this.getInteractionFragment());
		callMessageEClass.getESuperTypes().add(this.getMessage());
		compoundEndEClass.getESuperTypes().add(this.getEnd());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionEClass, Interaction.class, "Interaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteraction_Participants(), this.getParticipant(), null, "participants", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_Messages(), this.getMessage(), null, "messages", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_Executions(), this.getExecution(), null, "executions", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_StateInvariants(), this.getStateInvariant(), null, "stateInvariants", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_InteractionUses(), this.getInteractionUse(), null, "interactionUses", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_Ends(), this.getEnd(), null, "ends", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_CombinedFragments(), this.getCombinedFragment(), null, "combinedFragments", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(participantEClass, Participant.class, "Participant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParticipant_Type(), theEnvironmentPackage.getObeoDSMObject(), null, "type", null, 0, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(executionEClass, Execution.class, "Execution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecution_Owner(), this.getParticipant(), null, "owner", null, 1, 1, Execution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createParticipantMessageEClass, CreateParticipantMessage.class, "CreateParticipantMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(destroyParticipantMessageEClass, DestroyParticipantMessage.class, "DestroyParticipantMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(returnMessageEClass, ReturnMessage.class, "ReturnMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnMessage_InvocationMessage(), this.getMessage(), null, "invocationMessage", null, 1, 1, ReturnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateInvariantEClass, StateInvariant.class, "StateInvariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateInvariant_Owner(), this.getParticipant(), null, "owner", null, 1, 1, StateInvariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionUseEClass, InteractionUse.class, "InteractionUse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteractionUse_Type(), ecorePackage.getEString(), "type", null, 1, 1, InteractionUse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteractionUse_Interaction(), this.getInteraction(), null, "interaction", null, 1, 1, InteractionUse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteractionUse_CoveredParticipants(), this.getParticipant(), null, "coveredParticipants", null, 1, -1, InteractionUse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endEClass, End.class, "End", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnd_Context(), this.getParticipant(), null, "context", null, 0, 1, End.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnd_Owner(), this.getInteractionFragment(), null, "owner", null, 1, 1, End.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isStartingEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isFinishingEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isMessageEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, this.getMessage(), "getMessage", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isExecutionEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, this.getExecution(), "getExecution", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isStateInvariantEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, this.getStateInvariant(), "getStateInvariant", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isInteractionUseEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, this.getInteractionUse(), "getInteractionUse", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isCombinedFragmentEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, this.getCombinedFragment(), "getCombinedFragment", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, ecorePackage.getEBoolean(), "isOperandEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(endEClass, this.getOperand(), "getOperand", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(interactionFragmentEClass, InteractionFragment.class, "InteractionFragment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteractionFragment_StartingEnd(), this.getEnd(), null, "startingEnd", null, 1, 1, InteractionFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteractionFragment_FinishingEnd(), this.getEnd(), null, "finishingEnd", null, 1, 1, InteractionFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(combinedFragmentEClass, CombinedFragment.class, "CombinedFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCombinedFragment_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, CombinedFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombinedFragment_CoveredParticipants(), this.getParticipant(), null, "coveredParticipants", null, 0, -1, CombinedFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombinedFragment_OwnedOperands(), this.getOperand(), null, "ownedOperands", null, 0, -1, CombinedFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operandEClass, Operand.class, "Operand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callMessageEClass, CallMessage.class, "CallMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundEndEClass, CompoundEnd.class, "CompoundEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundEnd_OtherOwner(), this.getMessage(), null, "otherOwner", null, 0, 1, CompoundEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InteractionPackageImpl
