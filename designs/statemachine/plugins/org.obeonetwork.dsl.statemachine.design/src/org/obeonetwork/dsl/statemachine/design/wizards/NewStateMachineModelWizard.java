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
package org.obeonetwork.dsl.statemachine.design.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;
import org.obeonetwork.dsl.statemachine.StateMachine;
import org.obeonetwork.dsl.statemachine.StateMachineFactory;
import org.obeonetwork.dsl.statemachine.StateMachinePackage;
import org.obeonetwork.dsl.statemachine.design.Activator;

public class NewStateMachineModelWizard extends AbstractISNewModelWizard {

	private static final String STATEMACHINE_RESOURCE_FILE_EXTENSION = ".statemachine";
	private static final String DESC_ID_STATE_MACHINE_DIAGRAM = "State Machine Diagram";

	public NewStateMachineModelWizard() {
		super("New State machine Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewStateMachine.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		StateMachine rootObject = StateMachineFactory.eINSTANCE.createStateMachine();
		rootObject.setCreatedOn(new Date());
		return Arrays.asList(rootObject);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, STATEMACHINE_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new state machine model");
		modelCreationPage.setDescription("Choose the new state machine model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected
	String getWizardTitle() {
		return "New State Machine model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(
					URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
					URI.createURI("viewpoint:/org.obeonetwork.dsl.statemachine.design/State Machine")
		);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(StateMachinePackage.Literals.STATE_MACHINE, Arrays.asList(DESC_ID_STATE_MACHINE_DIAGRAM));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof StateMachine) {
			if (DESC_ID_STATE_MACHINE_DIAGRAM.equals(representationDescription.getName())) {
				return String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_STATE_MACHINE_DIAGRAM);
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			if (DESC_ID_STATE_MACHINE_DIAGRAM.equals(((DDiagram) representation).getDescription().getName())) {
				return true;
			}
		}
		return false;
	}
}
