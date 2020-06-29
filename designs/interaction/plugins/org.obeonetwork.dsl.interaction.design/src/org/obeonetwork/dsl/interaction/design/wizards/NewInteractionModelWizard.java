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
package org.obeonetwork.dsl.interaction.design.wizards;

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
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionFactory;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.design.Activator;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;

public class NewInteractionModelWizard extends AbstractISNewModelWizard {

	private static final String INTERACTION_RESOURCE_FILE_EXTENSION = ".interaction";
	private static final String DESC_ID_INTERACTION_DIAGRAM = "Sequence Diagram";

	public NewInteractionModelWizard() {
		super("New Interaction Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewInteraction.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		Interaction rootObject = InteractionFactory.eINSTANCE.createInteraction();
		rootObject.setCreatedOn(new Date());
		return Arrays.asList(rootObject);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, INTERACTION_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new interaction model");
		modelCreationPage.setDescription("Choose the new interaction model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected
	String getWizardTitle() {
		return "New Interaction model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(
					URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
					URI.createURI("viewpoint:/org.obeonetwork.dsl.interaction.design/Interaction")
		);
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(InteractionPackage.Literals.INTERACTION, Arrays.asList(DESC_ID_INTERACTION_DIAGRAM));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof Interaction) {
			if (DESC_ID_INTERACTION_DIAGRAM.equals(representationDescription.getName())) {
				return String.format("%1$s - %2$s", this.getProjectName(), DESC_ID_INTERACTION_DIAGRAM);
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			if (DESC_ID_INTERACTION_DIAGRAM.equals(((DDiagram) representation).getDescription().getName())) {
				return true;
			}
		}
		return false;
	}
}
