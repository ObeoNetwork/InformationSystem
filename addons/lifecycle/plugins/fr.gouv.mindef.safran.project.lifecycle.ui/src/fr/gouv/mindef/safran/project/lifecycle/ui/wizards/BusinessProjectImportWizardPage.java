/*******************************************************************************
 * Copyright (c) 2016-2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.project.lifecycle.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import fr.gouv.mindef.safran.project.lifecycle.BusinessProjectImporter;
import fr.gouv.mindef.safran.project.lifecycle.BusinessProjectImporterFactory;
import fr.gouv.mindef.safran.project.lifecycle.ReferenceData;
import fr.gouv.mindef.safran.project.lifecycle.ui.Activator;
import fr.gouv.mindef.safran.project.lifecycle.ui.dialogs.ReferencingElementsDialog;


public class BusinessProjectImportWizardPage extends WizardPage {
	private Text txtSource;
	private Text txtTarget;
	
	private IProject sourceProject = null;
	private IProject targetProject = null;
	
	private static final String ERROR_OCCURED_MSG = "An error occured during import.\nSee error log more for details.";
	public static final String DIALOG_TITLE = "Import business elements";
	private Collection<ReferenceData> existingReferences = new ArrayList<ReferenceData>();
	private Exception errorOccured = null;

	public BusinessProjectImportWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName);
		setTitle(pageName); //NON-NLS-1
		setDescription("Import a business project into the selected one"); //NON-NLS-1
		if (selection instanceof StructuredSelection) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IProject) {
				targetProject = (IProject)selectedElement;
			}
		}
	}
	
	public boolean doBusinessImport() {
		
		final ModelingProject sourceModelingProject = ModelingProject.asModelingProject(sourceProject).get();
		final ModelingProject targetModelingProject = ModelingProject.asModelingProject(targetProject).get();
		final BusinessProjectImporter importer = BusinessProjectImporterFactory.getBusinessProjectImporter(sourceModelingProject, targetModelingProject);

		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					boolean confirm = true;
					if (importer.shouldSaveAndCloseEditorsOnTargetProject()) {
						confirm = MessageDialog.openConfirm(getShell(), DIALOG_TITLE, "The project must be saved and editors must be closed before importing business elements.\n"
																					+ "Save and close the editors on " + targetProject.getName() + " ?");
					}
					if (confirm) {
						try {
							existingReferences = importer.getImpactedReferences(monitor);
						} catch (CoreException e) {
							errorOccured = e;
						}
					}
				}
			});
		} catch (Exception e) {
			reportError(e);
			return false;
		}
		
		if (errorOccured != null) {
			reportError(errorOccured);
			return false;
		}
		
		// Just ask whether we should continue
		if (!MessageDialog.openConfirm(getShell(), DIALOG_TITLE, "Previously imported elements will be removed and replaced by new ones.\nDo you want to continue ?")) {
			// Cancelled
			return false;
		}
		
		// If some references are going to be lost, present them for confirmation
		if (!existingReferences.isEmpty()) {
			ReferencingElementsDialog referencesDlg = new ReferencingElementsDialog(getShell(), existingReferences);
			if (referencesDlg.open() != Window.OK) {
				// User cancelled
				return false;
			}
		}
		
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						importer.importElementsIntoTargetProject(monitor);
					} catch (CoreException e) {
						errorOccured = e;
					}
				}
			});
		} catch (Exception e) {
			reportError(e);
			return false;
		}
		
		if (errorOccured != null) {
			reportError(errorOccured);
			return false;
		}
		
        return true;
	}
	
	private void reportError(Exception e) {
//		MessageDialog.openError(getShell(), DIALOG_TITLE, ERROR_OCCURED_MSG);
		setErrorMessage(ERROR_OCCURED_MSG);
		Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while importing business project.", e));
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblSource = new Label(container, SWT.NONE);
		lblSource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSource.setText("Import project");
		
		txtSource = new Text(container, SWT.BORDER);
		txtSource.setEditable(false);
		txtSource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (sourceProject != null) {
			txtSource.setText(sourceProject.getName());
		}
		
		Button btnChooseSource = new Button(container, SWT.NONE);
		btnChooseSource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectProject(true);
			}
		});
		btnChooseSource.setText("Choose...");
		
		Label lblTarget = new Label(container, SWT.NONE);
		lblTarget.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTarget.setText("into project");
		
		txtTarget = new Text(container, SWT.BORDER);
		txtTarget.setEditable(false);
		txtTarget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (targetProject != null) {
			txtTarget.setText(targetProject.getName());
		}
		
		Button btnChooseTarget = new Button(container, SWT.NONE);
		btnChooseTarget.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectProject(false);
			}
		});
		btnChooseTarget.setText("Choose...");
		
		initPageComplete();
	}
	
	private Collection<IProject> getModelingProjects() {
		Collection<IProject> projects = new ArrayList<IProject>();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		for (IProject project : root.getProjects()) {
			// We keep only open Modeling projects
			if (project.isOpen()) {
				boolean natureEnabled = false;
				try {
					natureEnabled = project.isNatureEnabled(ModelingProject.NATURE_ID);
				} catch (CoreException e) {
					// Do nothing special
					natureEnabled = false;
				}
				if (natureEnabled) {
					projects.add(project);
				}
			}
			
		}
		return projects;
	}
	
	private void selectProject(boolean source) {
		ElementListSelectionDialog dlg =new ElementListSelectionDialog(getShell(),
				WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
		dlg.setTitle("Modeling project selection");
		if (source) {
			dlg.setMessage("Select the source project");
		} else {
			dlg.setMessage("Select the target project");
		}
		dlg.setElements(getModelingProjects().toArray());
		dlg.setMultipleSelection(false);
		if (dlg.open() == Window.OK) {
			Object selection = dlg.getFirstResult();
			if (selection instanceof IProject) {
				if (source)	{
					setSourceProject((IProject)selection);
					txtSource.setText(getSourceProject().getName());
					updatePageComplete(getSourceProject());
				} else {
					setTargetProject((IProject)selection);
					txtTarget.setText(getTargetProject().getName());
					updatePageComplete(getTargetProject());
				}
			}
		}
	}
	
	private void updatePageComplete(IProject project) {
		if (project != null && !ModelingProject.asModelingProject(project).some()) {
			setErrorMessage("Project " + project.getName() + " is not a Modeling project");
		}
		setPageComplete(isProjectValid(sourceProject) && isProjectValid(targetProject));
	}
	
	private boolean isProjectValid(IProject project) {
		return project != null && ModelingProject.asModelingProject(project).some();
	}
	
	private void initPageComplete() {
		setPageComplete(true);
		if (sourceProject == null || targetProject == null) {
			setPageComplete(false);
		} else {
			updatePageComplete(sourceProject);
			updatePageComplete(targetProject);
		}
	}
	
	public IProject getSourceProject() {
		return sourceProject;
	}

	public void setSourceProject(IProject sourceProject) {
		this.sourceProject = sourceProject;
	}

	public IProject getTargetProject() {
		return targetProject;
	}

	public void setTargetProject(IProject targetProject) {
		this.targetProject = targetProject;
	}

	@Override
	public boolean canFlipToNextPage() {
		return false;
	}
}
