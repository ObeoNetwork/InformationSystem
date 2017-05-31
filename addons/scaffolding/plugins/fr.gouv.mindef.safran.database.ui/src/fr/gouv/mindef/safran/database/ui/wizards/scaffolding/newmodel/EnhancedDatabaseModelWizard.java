/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.scaffolding.newmodel;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.obeonetwork.dsl.database.presentation.DatabaseEditorPlugin;
import org.obeonetwork.dsl.database.presentation.DatabaseModelWizard;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2_13;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL_5;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE_11G;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES_9;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER_2008;

public class EnhancedDatabaseModelWizard extends DatabaseModelWizard implements INewModelWizard {
	private IFile createdFile = null;
	
	private static final String DB_LOGICAL_TYPES = "Logical Types";
	
	TypesLibraryKind requiredTypesLibrary;
	
	public EnhancedDatabaseModelWizard(TypesLibraryKind requiredTypesLibrary) {
		this.requiredTypesLibrary = requiredTypesLibrary;
	}
	
	@Override
	public boolean performFinish() {
		createdFile = getModelFile();
		return super.performFinish();
	}

	public IFile getCreatedFile() {
		return createdFile;
	}

	@Override
	public void addPages() {

		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new DatabaseModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseModelWizard_label"));
		newFileCreationPage.setDescription(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseModelWizard_description"));
		newFileCreationPage.setFileName(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new DatabaseModelWizardInitialObjectCreationPage("Whatever2") {

			@Override
			protected Collection<String> getDBVendors() {
				if (dbVendors == null) {
					dbVendors = new ArrayList<String>();
					if (requiredTypesLibrary != null) {
						if (TypesLibraryKind.LOGICAL_TYPES.equals(requiredTypesLibrary)) {
							dbVendors.add(DB_LOGICAL_TYPES);	
						} else if (TypesLibraryKind.PHYSICAL_TYPES.equals(requiredTypesLibrary)) {
							dbVendors.add(DB_MYSQL_5);
							dbVendors.add(DB_ORACLE_11G);
							dbVendors.add(DB_H2_13);
							dbVendors.add(DB_POSTGRES_9);
							dbVendors.add(DB_SQLSERVER_2008);
						}
					} else {
						dbVendors.add(DB_LOGICAL_TYPES);
						dbVendors.add(DB_MYSQL_5);
						dbVendors.add(DB_ORACLE_11G);
						dbVendors.add(DB_H2_13);
						dbVendors.add(DB_POSTGRES_9);
						dbVendors.add(DB_SQLSERVER_2008);
					}
				}
				return dbVendors;
			}
			
		};
		initialObjectCreationPage.setTitle(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseModelWizard_label"));
		initialObjectCreationPage.setDescription(DatabaseEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}
	
	
}
