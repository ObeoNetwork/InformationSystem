/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.wizards;

import java.util.ArrayList;
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
import org.obeonetwork.dsl.cinematic.CinematicFactory;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowFactory;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;

public class NewCinematicModelWizard extends AbstractISNewModelWizard {

	private static final String DESC_ID_PACKAGE_DIAGRAM = "Package Diagram";
	private static final String DESC_ID_MOCKUP_DIAGRAM = "View Container Mockup";
	private static final String DESC_ID_FLOW_DIAGRAM = "Flow Diagram";
	private static final String DESC_ID_UI_STRUCTURE_TREE = "UI Structure";
	private static final String CINEMATIC_RESOURCE_FILE_EXTENSION = ".cinematic";

	private NewModelCreationWithMockupPage mockupPage;

	public NewCinematicModelWizard() {
		super("New Cinematic model",
				Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewCinematic.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		Collection<EObject> initialObjects = new ArrayList<EObject>();

		CinematicRoot cinematicRoot = CinematicFactory.eINSTANCE.createCinematicRoot();
		cinematicRoot.setCreatedOn(new Date());
		cinematicRoot.setName(getProjectName());
		initialObjects.add(cinematicRoot);

		if (mockupPage.isCreatesMockupRepresentation() && mockupPage.getToolkit() != null
				&& mockupPage.getWidgetContainer() != null) {
			Widget widget = mockupPage.getWidgetContainer();
			ViewContainer container = ViewFactory.eINSTANCE.createViewContainer();
			container.setWidget(widget);

			if (mockupPage.getViewContainerName() != null)
				container.setName(mockupPage.getViewContainerName());
			else
				container.setName(String.format("%s_1", widget.getName()));

			cinematicRoot.getViewContainers().add(container);
			cinematicRoot.getToolkits().add(mockupPage.getToolkit());

			initialObjects.add(container);
		}

		if (mockupPage.isCreatesFlowRepresentation()) {
			Flow flow = FlowFactory.eINSTANCE.createFlow();
			if (mockupPage.getFlowName() != null) {
				flow.setName(mockupPage.getFlowName());
			}
			cinematicRoot.getFlows().add(flow);
			initialObjects.add(flow);
		}

		return initialObjects;
	}

	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, CINEMATIC_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new cinematic model");
		modelCreationPage.setDescription("Choose the new cinematic model name and path.");

		mockupPage = new NewModelCreationWithMockupPage("ModelCreationMockup");

		addPage(modelCreationPage);
		addPage(mockupPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Cinematic model";
	}

	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return Arrays.asList(URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"),
				URI.createURI("viewpoint:/org.obeonetwork.dsl.cinematic.design/Cinematic Views"));
	}

	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(CinematicPackage.Literals.CINEMATIC_ROOT,
				Arrays.asList(DESC_ID_UI_STRUCTURE_TREE, DESC_ID_PACKAGE_DIAGRAM));
		descs.put(ViewPackage.Literals.VIEW_CONTAINER, Arrays.asList(DESC_ID_MOCKUP_DIAGRAM));
		descs.put(FlowPackage.Literals.FLOW, Arrays.asList(DESC_ID_FLOW_DIAGRAM));
		return descs;
	}

	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		String repDescName = representationDescription.getName();

		if (object instanceof CinematicRoot) {
			if (DESC_ID_PACKAGE_DIAGRAM.equals(repDescName)) {
				return String.format("%1$s %2$s", this.getProjectName(), DESC_ID_PACKAGE_DIAGRAM);
			} else if (DESC_ID_UI_STRUCTURE_TREE.equals(repDescName)) {
				return String.format("%1$s %2$s", this.getProjectName(), DESC_ID_UI_STRUCTURE_TREE);
			}
		} else if (object instanceof ViewContainer && DESC_ID_MOCKUP_DIAGRAM.equals(repDescName)) {
			return String.format("%1$s %2$s", this.getProjectName(), DESC_ID_MOCKUP_DIAGRAM);
		} else if (object instanceof Flow && DESC_ID_FLOW_DIAGRAM.equals(repDescName)) {
			return String.format("%1$s %2$s", this.getProjectName(), DESC_ID_FLOW_DIAGRAM);
		}
		return null;
	}

	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			String repDescName = ((DDiagram) representation).getDescription().getName();
			if (mockupPage.isCreatesMockupRepresentation() && (DESC_ID_MOCKUP_DIAGRAM.equals(repDescName))) {
				return true;
			} else if (mockupPage.isCreatesFlowRepresentation() && (DESC_ID_FLOW_DIAGRAM.equals(repDescName))) {
				return true;
			} else
				return DESC_ID_PACKAGE_DIAGRAM.equals(repDescName) && !mockupPage.isCreatesMockupRepresentation()
						&& !mockupPage.isCreatesFlowRepresentation();
		}
		return false;
	}

}
