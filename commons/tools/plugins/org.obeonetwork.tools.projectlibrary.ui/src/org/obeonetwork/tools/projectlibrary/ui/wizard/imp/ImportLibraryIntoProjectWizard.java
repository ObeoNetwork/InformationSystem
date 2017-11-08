/**
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.imp;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.obeonetwork.tools.projectlibrary.imp.ProjectLibraryImporter;
import org.obeonetwork.tools.projectlibrary.ui.wizard.WizardUtils;

/**
 * Wizard used to import a project library into a modeling project
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ImportLibraryIntoProjectWizard extends Wizard implements IImportWizard {
	
	private ImportLibraryIntoProjectWizardModel model = new ImportLibraryIntoProjectWizardModel();
	
	private ImportLibraryIntoProjectFileSelectionPage fileSelectionPage = null;

	public ImportLibraryIntoProjectWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		fileSelectionPage = new ImportLibraryIntoProjectFileSelectionPage(this);
		
		// Initialize with selected project if it is a modeling project
		Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
		if (selectedObject instanceof IProject) {
			IProject project = (IProject)selectedObject;
			Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
			if (optionModelingProject.some()) {
				this.model.setModelingProject(optionModelingProject.get());
			}
		}
		
		// Initialize list of modeling projects
		model.setModelingProjects(WizardUtils.getAllModelingProjects());
	}

	@Override
	public boolean canFinish() {
		return super.canFinish() && fileSelectionPage.isPageComplete();
	}
	
	@Override
	public boolean performFinish() {
		ProjectLibraryImporter importer = new ProjectLibraryImporter();
		importer.importIntoProject(model.getModelingProject(), new File(model.getFilepath()));
		return true;
	}
	
	@Override
	public void addPages() {
		super.addPages();
		addPage(fileSelectionPage);
	}

	public ImportLibraryIntoProjectWizardModel getModel() {
		return model;
	}
	
}
