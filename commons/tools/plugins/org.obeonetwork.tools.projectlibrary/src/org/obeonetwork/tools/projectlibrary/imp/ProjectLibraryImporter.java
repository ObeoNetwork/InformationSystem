/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.imp;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.ViewpointQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionStatus;
import org.eclipse.sirius.business.api.session.ViewpointSelector;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.provider.Messages;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.extension.point.IResourceCopier;
import org.obeonetwork.tools.projectlibrary.extension.point.ResourceCopierFactory;
import org.obeonetwork.tools.projectlibrary.util.ProjectLibraryUtils;
import org.obeonetwork.tools.projectlibrary.util.SessionUtils;
import org.obeonetwork.tools.projectlibrary.util.ZipUtils;

import fr.obeo.dsl.viewpoint.collab.api.CDOImporter;
import fr.obeo.dsl.viewpoint.collab.api.CDORepositoryManager;
import fr.obeo.dsl.viewpoint.collab.api.RepositoryConnectionException;
import fr.obeo.dsl.viewpoint.collab.api.remotesession.CollaborativeSession;

/**
 * Import a zipped library into a modeling project 
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ProjectLibraryImporter {
	
	private static final String TMP_PROJECT_PREFIX = "tmpImportLibrary";

	public static final String IMPORT_FOLDER_NAME = "libraries";
	
	private ManifestServices manifestServices = new ManifestServices();

	private ProjectLibraryUtils projectLibraryUtils = new ProjectLibraryUtils();
	
	private ImportData importData;

	private IResourceCopier resourceCopier;
	
	/**
	 * Import MAR file into modeling project
	 * @param targetProject
	 * @param marFile
	 */
	public void importIntoProject(final ModelingProject targetProject, final File marFile) {
		Manifest importedManifest = null;
		try {
			importedManifest = manifestServices.getManifestFromArchive(marFile);
		} catch (IOException e1) {
			// TODO handle error
			return;
		}
		
		MManifest importedManifestModel = manifestServices.getModelFromMarManifest(importedManifest);
		if (importedManifestModel == null) {
			// TODO handle error
			return;
		}
		
		String libraryProjectName = manifestServices.getLibraryProjectName(importedManifestModel);
		if (libraryProjectName == null) {
			// TODO handle error
			return;
		}
		
		// First, let's create a temporary modeling project
		ModelingProject sourceProject = createTempModelingProjectFromMAR(marFile);

		// Create ImportData used to do the import
		importData = new ImportData(libraryProjectName, sourceProject, targetProject);
		importData.setResourceCopier(getResourceCopier());

		// Check if references could be restored when we import a project for the second time
		Collection<Setting> restorableReferences = new ArrayList<>();
		MManifest previousVersion = getPreviousImportedVersion(importedManifestModel, importData.getTargetSession());
		if (previousVersion != null) {
			Collection<Resource> resourcesToDelete = projectLibraryUtils.getResourcesFromManifest(importData.getTargetProject(), previousVersion);
			Collection<Setting> externalReferences = projectLibraryUtils.getExternalReferences(importData.getTargetSession(), resourcesToDelete);
			if (!externalReferences.isEmpty()) {
				restorableReferences = projectLibraryUtils.getRestorableReferences(externalReferences, resourcesToDelete, importData.getSourceSession());
	
				boolean continueImport = true;
				if (!restorableReferences.isEmpty()) {
					// Some references will not be restored, we have to warn the user
					// TODO extract this
//					MessageDialog.openConfirm(null, "", "");
				}
				if (continueImport == true) {
					// Delete previous version
					
				}
		}
		}
		
		// Save target project and close editors if needed
		// TODO monitor
		try {
			saveAndCloseEditorsOnTargetProject(targetProject.getSession(), new NullProgressMonitor());
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Copy all resources by changing their URI
		final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				executeInRecordingCommand(importData.getTargetSession(), () -> copyAllObjects());
			}
		};
		try {
			op.run(new NullProgressMonitor());
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Restore external references
		if (!restorableReferences.isEmpty()) {
//			projectLibraryUtils.restoreReferences(externalReferences, resourcesToDelete, importData.getSourceSession());
		}
		
		// Save imported manifest into AIRD for future references
		importedManifestModel.setImportDate(new Date());
		manifestServices.addImportedManifestToSession(importData.getTargetSession(), importedManifestModel);
		importData.getTargetSession().save(new NullProgressMonitor());
		
		// Finally, remove temp project
		// TODO monitor
		try {
			sourceProject.getProject().delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void exportRessourcesToProject() {
		Set<URI> localResourceToExports = new HashSet<>();
		CDORepositoryManager repositoryManager = null;
		Map<String, String> localToRemoteResourceURIMapping = new HashMap<>();
		
		String remoteProjectName = "d";
		
		for (Resource semanticResource : importData.getSourceSemanticResources()) {
			localResourceToExports.add(semanticResource.getURI());
			localToRemoteResourceURIMapping.put(semanticResource.getURI().toString(), getTargetResourcePath(importData, remoteProjectName, semanticResource.getURI()));
		}
		for (Resource graphicalResource : importData.getSourceGraphicalResources()) {
			localResourceToExports.add(graphicalResource.getURI());
			localToRemoteResourceURIMapping.put(graphicalResource.getURI().toString(), getTargetResourcePath(importData, remoteProjectName, graphicalResource.getURI()));
		}
		Session session = importData.getTargetSession();
		if (session instanceof CollaborativeSession) {
			CollaborativeSession collabSession = (CollaborativeSession)session;
			repositoryManager = collabSession.getRepositoryManager();
		}
		
		try {
			new CDOImporter().importLocalFilesIntoRepository(localResourceToExports , repositoryManager, false, false, localToRemoteResourceURIMapping, false, new NullProgressMonitor());
		} catch (RepositoryConnectionException | CommitException | CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getTargetResourcePath(ImportData importData, String remoteProjectName, URI sourceURI) {
		List<String> segments = new ArrayList<String>(sourceURI.segmentsList());

		if (sourceURI.isPlatformResource()) {
			// Remove "resource" and project's name
			segments.remove(0);
			segments.remove(0);
			
			// Add destination folder to the resource path segments
			segments.add(0, "librairievirtuelle");
			segments.add(0, ProjectLibraryImporter.IMPORT_FOLDER_NAME);
			segments.add(0, remoteProjectName);
			return String.join("/", segments);
		}
		
		return null;
	}
	
	private IResourceCopier getResourceCopier() {
		if (resourceCopier == null) {
			resourceCopier = ResourceCopierFactory.getInstance().getResourceCopier(importData.getTargetSession());
		}
		return resourceCopier;
	}
		
	private void copyAllObjects() {
		Collection<Resource> targetSemanticResources = new ArrayList<>();
		Collection<Resource> targetGraphicalResources = new ArrayList<>();
		
		// Copy semantic resources
		for (Resource semanticResource : importData.getSourceSemanticResources()) {
			Resource copiedResource = getResourceCopier().copyResource(importData, semanticResource);
			if (copiedResource != null) {
				targetSemanticResources.add(copiedResource);
			}
		}
		
		// Copy graphical resources
		for (Resource graphicalResource : importData.getSourceGraphicalResources()) {
			Resource copiedResource = getResourceCopier().copyResource(importData, graphicalResource);
			if (copiedResource != null) {
				targetGraphicalResources.add(copiedResource);
			}
		}

//		targetSemanticResources.addAll(copier.copyResources(importData, importData.getSourceSemanticResources()));
		
		// Save new resources
		saveResources(targetSemanticResources);
		saveResources(targetGraphicalResources);
		
		// Add semantic resources to session
		for (Resource targetResource : targetSemanticResources) {
			importData.getTargetSession().addSemanticResource(targetResource.getURI(), new NullProgressMonitor());			
		}
		
		// Add the main AIRD as a referenced analysis
		addReferencedAnalysis();
		// and save session
		importData.getTargetSession().save(new NullProgressMonitor());
	}
	
	private void saveResources(Collection<Resource> resources) {
		for (Resource resource : resources) {
			try {
				resource.save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void addReferencedAnalysis() {
		// Get main analysis
		Session sourceSession = importData.getSourceSession();
		Session targetSession = importData.getTargetSession();
		DAnalysis sourceMainAnalysis = new SessionUtils().getMainAnalysis(sourceSession);
		
		// Add the copied analysis as a referenced analysis
		if (sourceMainAnalysis != null) {
			EObject targetMainAnalysis = importData.getCopyEObject(sourceMainAnalysis);
			if (targetMainAnalysis instanceof DAnalysis && targetSession instanceof DAnalysisSession) {
				((DAnalysisSession)targetSession).addReferencedAnalysis((DAnalysis)targetMainAnalysis);
			}
		}
		
		// Add required viewpoints
		for (DView view : sourceMainAnalysis.getOwnedViews()) {
			Viewpoint viewpoint = view.getViewpoint();
			Option<URI> viewpointURI = new ViewpointQuery(viewpoint).getViewpointURI();
			if (viewpointURI.some()) {
				Viewpoint sessionVP = ViewpointRegistry.getInstance().getViewpoint(viewpointURI.get());
				if (sessionVP != null){
					if (!SiriusResourceHelper.isViewExistForSirius(targetSession, sessionVP)) {
						// We have to add the viewpoint
						// TODO Monitor
						new ViewpointSelector(targetSession).selectViewpoint(sessionVP, false, new NullProgressMonitor());
					}
				}
			}
		}
		
	}
	
	private ModelingProject createTempModelingProjectFromMAR(File marFile) {
		ModelingProject project = null;
		
		final String projectName = getTempProjectName();
		
		final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				try {
                    monitor.beginTask(MessageFormat.format(Messages.ModelingProjectManagerImpl_createModelingProjectTask, projectName), 3);
                    final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
                    if (!project.exists()) {
                        
                    	// Create project
                    	final IProjectDescription desc = project.getWorkspace().newProjectDescription(projectName);
                        desc.setLocation(null);

                        monitor.subTask("Create temp modeling project to import library");
                        project.create(desc, new SubProgressMonitor(monitor, 1));
                        
                        // Copy zip files into project
                        final File targetProjectFolder = project.getLocation().toFile();
						ZipUtils.unzipIntoFolder(marFile, targetProjectFolder, new FilenameFilter() {
							@Override
							public boolean accept(File dir, String name) {
								// We filter the .project file at the zip root
								return !(".project".equals(name) && targetProjectFolder.equals(dir));
							}
						});
              
						
						// Open project
						monitor.subTask(Messages.ModelingProjectManagerImpl_openProjectTask);
						project.getProject().open(new SubProgressMonitor(monitor, 1));
						
						// Convert to modeling project
						ModelingProjectManager.INSTANCE.convertToModelingProject(project, monitor);
                    }
                } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
                    monitor.done();
                }
			}
		};
		try {
			op.run(new NullProgressMonitor());
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        project = ModelingProject.asModelingProject(iProject).get();
		return project;
	}
	
	private void saveAndCloseEditorsOnTargetProject(Session session, IProgressMonitor parentMonitor) throws CoreException {
		SubMonitor monitor = SubMonitor.convert(parentMonitor, 3);
		if (shouldSaveAndCloseEditorsOnProject(session)) {
			// Save session if needed
			if (session.getStatus().equals(SessionStatus.DIRTY)) {
				session.save(monitor.newChild(1));
			}
			
			// Close diagrams
			IEditingSession uiSession = SessionUIManager.INSTANCE.getUISession(session);
			if (uiSession != null) {
				Collection<DialectEditor> editors = uiSession.getEditors();
				if  (!editors.isEmpty()) {
					uiSession.closeEditors(true, editors);
				}
			}
		}
	}
	
	public boolean shouldSaveAndCloseEditorsOnProject(Session targetSession) {
		if (targetSession == null) {
			return false;
		}
		if (SessionStatus.DIRTY.equals(targetSession.getStatus())) {
			return true;
		}
		IEditingSession uiSession = SessionUIManager.INSTANCE.getUISession(targetSession);
		if (uiSession != null) {
			return !uiSession.getEditors().isEmpty();
		}
		return false;
	}

	private String getTempProjectName() {
		SimpleDateFormat sdf = new SimpleDateFormat("_yyyyMMdd_HHmmss");
		String name = null;
		// Loop until we find a name that does not correspond to an already existing project
		while (name == null) {
			String projectName = TMP_PROJECT_PREFIX + sdf.format(new Date());
			// Check if a project with this name already exists
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (project == null || !project.exists()) {
				name = projectName;
			}
		}
		return name;
	}
	
	private void executeInRecordingCommand(final Session session, final Runnable runnable) {
		final TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
		ted.getCommandStack().execute(new RecordingCommand(ted) {
			
			@Override
			protected void doExecute() {
				runnable.run();
			}
		});
	}

	private MManifest getPreviousImportedVersion(MManifest manifest, Session session) {
		List<MManifest> importedManifests = manifestServices.getImportedManifests(session);
		for (MManifest importedManifest : importedManifests) {
			if (importedManifest.getProjectId().equals(manifest.getProjectId())) {
				return importedManifest;
			}
		}
		return null;
	}
}
