/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.exp;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.obeonetwork.tools.projectlibrary.ui.wizard.WizardUtils;

/**
 * Wizard allowing one to export a modeling project as a library
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ExportProjectAsLibraryWizard extends Wizard implements IExportWizard {

	private ExportProjectAsLibraryProjectSelectionPage projectSelectionPage;
	private ExportProjectAsLibraryManifestPage manifestPage;
	
	private ExportProjectAsLibraryWizardModel model = new ExportProjectAsLibraryWizardModel();
	
	public ExportProjectAsLibraryWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("Export modeling project as library");
		setNeedsProgressMonitor(true);
		projectSelectionPage = new ExportProjectAsLibraryProjectSelectionPage(this);
		manifestPage = new ExportProjectAsLibraryManifestPage(this);

		// Initialize with selected project if it is a modeling project
		Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
		if (selectedObject instanceof IProject) {
			IProject project = (IProject)selectedObject;
			Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
			if (optionModelingProject.some()) {
				this.model.setSelectedModelingProject(optionModelingProject.get());
			}
		}
		
		// Initialize list of modeling projects
		model.setModelingProjects(WizardUtils.getAllModelingProjects());
		
	}

	@Override
	public boolean canFinish() {
		return super.canFinish() && projectSelectionPage.isPageComplete() && manifestPage.isPageComplete();
	}
	
	@Override
	public boolean performFinish() {
		ExportProjectAsLibraryRunnable runnable = new ExportProjectAsLibraryRunnable(model, manifestPage.getSelectedReferencingProjects(), getShell());
		try {
			getContainer().run(true, true, runnable);
		} catch (Exception e) {
			// Do nothing
		}
		return runnable.getResult();
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages();
        addPage(projectSelectionPage);
        addPage(manifestPage);
    }

	public ExportProjectAsLibraryWizardModel getModel() {
		return model;
	}
	
}
