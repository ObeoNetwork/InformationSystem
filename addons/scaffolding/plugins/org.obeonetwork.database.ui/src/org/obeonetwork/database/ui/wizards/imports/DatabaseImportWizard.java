/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.ui.wizards.imports;

import static java.util.stream.Collectors.toList;
import static org.obeonetwork.database.ui.Activator.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.design.IDatabaseViewpointConstants;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.utils.common.ui.services.SiriusUIUtils;

public class DatabaseImportWizard extends Wizard implements IImportWizard {
	
	DatabaseImportWizardPage mainPage;
	
	private DatabaseInfos databaseInfos;

	public DatabaseImportWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		// First, check if a connection to the database can be established
		if (databaseInfos != null) {
			Connection connection = null;
			DataSource dataSource = databaseInfos.getDataSource();
			if (dataSource != null) {
				try {
					connection = dataSource.getConnection();
				} catch (DataSourceException e) {
					// Unable to connect
					String message = "Unable to connect to database.\n\nReason : " + e.getCause().getMessage(); 
					MessageDialog.openError(getShell(), "Import database...", message);
					return false;
				} finally {
					JdbcUtils.closeConnection(connection);
				}
			}
		}
		
		String filename = mainPage.getModelFilePath();
		boolean result = DatabaseImportHelper.importDatabaseIntoModel(databaseInfos, filename, mainPage.getReferencedFiles());
		if (result == true) {
			MessageDialog.openInformation(getShell(), "Database imported", "The database has been imported.\nThe model file '" + filename + "' has been created.");
			IViewPart explorer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(ProjectExplorer.VIEW_ID);
			final IFile generatedFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filename));
			if (explorer != null) {
				if (explorer instanceof ProjectExplorer) {
					ProjectExplorer projectExplorer = (ProjectExplorer)explorer;
					
					// Create a selection to point on the generated file
					projectExplorer.selectReveal(new StructuredSelection(generatedFile));
				}
			}
			
			// Convert containing project to modeling project, activate viewpoints and create representations.
			IProject enclosingProject = generatedFile.getProject();
	        try {
				PlatformUI.getWorkbench().getProgressService().run(false, false, new WorkspaceModifyOperation(ResourcesPlugin.getWorkspace().getRoot()) {
				    @Override
				    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
						convertToModelingProject(enclosingProject, monitor);
				    }
				});
				PlatformUI.getWorkbench().getProgressService().run(false, false, new WorkspaceModifyOperation(ResourcesPlugin.getWorkspace().getRoot()) {
					@Override
				    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
					    @SuppressWarnings("deprecation")
						ModelingProject enclosingModelingProject = ModelingProject.asModelingProject(enclosingProject).get();
						activateViewpoints(enclosingModelingProject, monitor);
				    }
				});
				PlatformUI.getWorkbench().getProgressService().run(false, false, new WorkspaceModifyOperation(ResourcesPlugin.getWorkspace().getRoot()) {
				    @Override
				    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
						@SuppressWarnings("deprecation")
						ModelingProject enclosingModelingProject = ModelingProject.asModelingProject(enclosingProject).get();
						Session session = enclosingModelingProject.getSession();
						logInfo("Creating representations.");
						List<DRepresentation> representations = createRepresentations(session, generatedFile, monitor);
						logInfo(String.format("%d representations created.", representations.size()));
						// Open representations
						logInfo("Opening representations.");
						for (DRepresentation representation : representations) {
							DialectUIManager.INSTANCE.openEditor(session, representation, monitor);
						}
						logInfo("Done opening representations.");
				    }
				});
			} catch (InvocationTargetException e) {
	            if (e.getCause() instanceof RuntimeException) {
	                throw (RuntimeException) e.getCause();
	            }
	            throw new RuntimeException(e);
	        } catch (final InterruptedException e) {
	            throw new RuntimeException(e);
	        }
	        
		} else {
			MessageDialog.openError(getShell(), "Error while importing database", "The database could not be imported.");
		}
		return result;
	}
	 
	private void convertToModelingProject(IProject enclosingProject, IProgressMonitor monitor) throws CoreException {
        if (!ModelingProject.hasModelingProjectNature(enclosingProject)) {
            ModelingProjectManager.INSTANCE.convertToModelingProject(enclosingProject, monitor);
        }
	}

	private void activateViewpoints(ModelingProject enclosingModelingProject, IProgressMonitor monitor) {
        Session session = enclosingModelingProject.getSession();
		if (session != null) {
			for (URI viewpointURI : IDatabaseViewpointConstants.VIEWPOINT_DEPENDENCIES) {
				SiriusUIUtils.activateViewpoint(session, viewpointURI, monitor);
			}
		}
	}

	private List<DRepresentation> createRepresentations(Session session, IFile semanticResourceFile, IProgressMonitor monitor) {
		URI semanticResourceURI = URI.createPlatformResourceURI(semanticResourceFile.getFullPath().toString(), true);
		Resource semanticResource = session.getSemanticResources().stream().filter(r -> r.getURI() == semanticResourceURI).findAny().orElse(null);
		
		List<EObject> contexts = new ArrayList<>();
		List<String> representationDescriptionIds = new ArrayList<>();
		
		List<DataBase> databases = semanticResource.getContents().stream()
				.filter(DataBase.class::isInstance).map(DataBase.class::cast)
				.collect(toList());
		for(DataBase database : databases) {
			contexts.add(database);
			representationDescriptionIds.add(IDatabaseViewpointConstants.DATABASE_DIAGRAM_ID);
		}
		
		List<Schema> schemas = databases.stream()
				.flatMap(db -> db.getSchemas().stream())
				.collect(toList());
		for(Schema schema : schemas) {
			contexts.add(schema);
			representationDescriptionIds.add(IDatabaseViewpointConstants.SCHEMA_DIAGRAM_ID);
		}
		
		return SiriusUIUtils.createRepresentations(session, contexts, representationDescriptionIds, monitor);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("File Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		databaseInfos = new DatabaseInfos();
		databaseInfos.computeUrl();
		
		Object selectedObject = selection.getFirstElement();
		IProject selectedProject = null;
		if(selectedObject instanceof  IJavaProject) {
			 IJavaProject jProject = (IJavaProject) selectedObject;
			 selectedProject = jProject.getProject();
		}
		if(selectedObject instanceof IProject) {
			selectedProject = (IProject) selectedObject;
		}
		
		mainPage = new DatabaseImportWizardPage("Database configuration", databaseInfos, selectedProject); //NON-NLS-1
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);
    }

	@Override
	public boolean canFinish() {
		return mainPage.checkStatus();
	}
    
	
}
