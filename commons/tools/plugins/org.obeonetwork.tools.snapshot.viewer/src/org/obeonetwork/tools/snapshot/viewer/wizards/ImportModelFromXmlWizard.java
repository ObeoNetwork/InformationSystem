/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.snapshot.viewer.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.obeonetwork.tools.snapshot.viewer.Activator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
/**
 * Wizard allowing one to import a CDO XML file into workspace
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ImportModelFromXmlWizard extends Wizard implements IImportWizard {
	
	ImportXMLSnapshotWizardPage mainPage;

	public ImportModelFromXmlWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		final URI remoteProjectURI = mainPage.getInputData().getRemoteProjectURI();
		String remoteProjectName = mainPage.getProjectNameFromURI(remoteProjectURI); 
		final String localProjectName = mainPage.getInputData().getLocalProjectName();
		
		if (localProjectName == null || remoteProjectURI == null) {
			return false;
		}
		
		final Map<String, String> remoteToLocalProjectNameMapping = new HashMap<String, String>();
		remoteToLocalProjectNameMapping.put(remoteProjectName, localProjectName);
		
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor parentMonitor) throws InvocationTargetException, InterruptedException {
					SubMonitor monitor = SubMonitor.convert(parentMonitor, 100);
					try {
						mainPage.getServer().importProjectFromRepository(remoteProjectURI, remoteToLocalProjectNameMapping, monitor.newChild(80));
					} catch (Exception e) {
						MessageDialog.openError(getShell(), "Import XML snapshot",
								"The project could not be imported. See error log for more informations.");
						Activator.logError("The project could not be imported.", e);
					}

					// Stop server
					mainPage.getServer().stop();

					// Ensure the project can be used (open with modeling nature)
					try {
						finalizeProject(localProjectName, monitor.newChild(20));
					} catch (CoreException e) {
						Activator.logWarning("An error occured when refreshing the new project.", e);
					}
				}
				});
		} catch (Exception e) {
			Activator.logWarning("The project could not be imported.", e);
		}
		
		return true;
	}
	
	protected void finalizeProject(String projectName, IProgressMonitor parentMonitor) throws CoreException {
		SubMonitor monitor = SubMonitor.convert(parentMonitor);
        try {
        	monitor.setTaskName("Project finalization");

            IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

            // Create project if needed
            if (!project.exists()) {
                project.create(new SubProgressMonitor(monitor, 1));
            }

            // Open project if needed
            if (!project.isOpen()) {
                project.open(new SubProgressMonitor(monitor, 1));
            }
            // Refreshing project
            project.refreshLocal(IResource.DEPTH_ONE, new SubProgressMonitor(monitor, 1));

            // Add modeling nature
            IProjectDescription description = project.getDescription();
            Set<String> natures = Sets.newLinkedHashSet(Lists.newArrayList(description.getNatureIds()));
            natures.add(ModelingProject.NATURE_ID);
            String[] naturesAsArray = natures.toArray(new String[natures.size()]);
            description.setNatureIds(naturesAsArray);
            project.setDescription(description, new SubProgressMonitor(monitor, 1));
        } finally {
            monitor.done();
        }
    }
	
	@Override
	public boolean performCancel() {
		// Stop server
		mainPage.getServer().stop();
		return super.performCancel();
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("File Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		mainPage = new ImportXMLSnapshotWizardPage();
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);        
    }

}
