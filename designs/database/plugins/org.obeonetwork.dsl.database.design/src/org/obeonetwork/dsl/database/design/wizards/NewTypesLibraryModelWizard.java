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
package org.obeonetwork.dsl.database.design.wizards;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.design.Activator;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;

public class NewTypesLibraryModelWizard extends AbstractISNewModelWizard {
	
	private static final String TYPESLIBRARY_RESOURCE_FILE_EXTENSION = ".typeslibrary";

	public NewTypesLibraryModelWizard() {
		super("New Types library Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewTypesLibrary.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		NativeTypesLibrary nativeTypesLibrary = TypesLibraryFactory.eINSTANCE.createNativeTypesLibrary();
		return Arrays.asList(nativeTypesLibrary);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, TYPESLIBRARY_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new typeslibrary model");
		modelCreationPage.setDescription("Choose the new typeslibrary model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Types Library model";
	}

}
