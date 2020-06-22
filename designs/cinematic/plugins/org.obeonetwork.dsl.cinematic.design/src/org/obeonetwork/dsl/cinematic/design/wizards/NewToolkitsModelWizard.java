/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.wizards;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsFactory;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;

public class NewToolkitsModelWizard extends AbstractISNewModelWizard {
	
	private static final String TOOLKITS_RESOURCE_FILE_EXTENSION = ".cinematic_toolkits";

	public NewToolkitsModelWizard() {
		super("New Toolkits Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewToolkits.gif"));
	}
	
	@Override
	protected Collection<EObject> createInitialObjects() {
		Toolkit toolkit = ToolkitsFactory.eINSTANCE.createToolkit();
		toolkit.setName(extractNameFromTargetResourceName(TOOLKITS_RESOURCE_FILE_EXTENSION));
		return Arrays.asList(toolkit);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, TOOLKITS_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new toolkit model");
		modelCreationPage.setDescription("Choose the new toolkit model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Toolkits model";
	}
}
