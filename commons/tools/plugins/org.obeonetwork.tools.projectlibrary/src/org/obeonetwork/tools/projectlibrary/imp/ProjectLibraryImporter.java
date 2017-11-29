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
import java.util.List;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.obeonetwork.tools.projectlibrary.util.ZipUtils;

import com.google.common.base.Joiner;

/**
 * Import a zipped library into a modeling project 
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ProjectLibraryImporter {
	
	private static final String TMP_PROJECT_PREFIX = "tmpImportLibrary";

	private static final String IMPORT_FOLDER_NAME = "libraries";
	
	private ManifestServices manifestServices = new ManifestServices();
	
	private ImportData importData;
	
	private String projectName = null;

	private String getProjectName(final File marFile) {
		String name = "";
		Manifest manifest = null;
		try {
			manifest = manifestServices.getManifestFromArchive(marFile);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if (manifest != null) {
			MManifest manifestModel = manifestServices.getModelFromMarManifest(manifest);
			name = manifestModel.getProjectId() + "-" + manifestModel.getVersion();
		}
		
		return name;
	}
	
	/**
	 * Import MAR file into modeling project
	 * @param targetProject
	 * @param marFile
	 */
	public void importIntoProject(final ModelingProject targetProject, final File marFile) {
		projectName = getProjectName(marFile);
		
		if (projectName == null) {
			// TODO handle error
			return;
		}
		
		// First, let's create a temporary modeling project
		ModelingProject sourceProject = createTempModelingProjectFromMAR(marFile);
		importData = new ImportData(sourceProject, targetProject);
		
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
		
	
		// Save target project
//		importData.getTargetSession().save(new NullProgressMonitor());
		
		// Finally, remove temp project
		// TODO monitor
		try {
			sourceProject.getProject().delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void copyAllObjects() {
		Collection<Resource> targetSemanticResources = new ArrayList<>();
		Collection<Resource> targetGraphicalResources = new ArrayList<>();
		
		// Copy semantic resources
		for (Resource semanticResource : importData.getSourceSemanticResources()) {
			targetSemanticResources.add(copyResource(semanticResource));
		}
		
		// Copy graphical resources
		for (Resource graphicalResource : importData.getSourceGraphicalResources()) {
			targetGraphicalResources.add(copyResource(graphicalResource));
		}
		
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
			}
		}
	}
	
	private Resource copyResource(final Resource sourceResource) {
		Collection<EObject> contents = sourceResource.getContents();
		Collection<EObject> copiedContents = new ArrayList<>();
		for (EObject object : contents) {
			EObject copiedObject = importData.getCopyEObject(object);
			copiedContents.add(copiedObject);
		}
		
		URI targetURI = getTargetResourceURI(sourceResource.getURI());
		Resource targetResource = createTargetResource(copiedContents, targetURI);
		return targetResource;
	}
	
	private Resource createTargetResource(final Collection<EObject> contents, final URI targetURI) {
		ResourceSet resourceSet = importData.getTargetSession().getTransactionalEditingDomain().getResourceSet();
		Resource resource = resourceSet.createResource(targetURI);
		resource.getContents().addAll(contents);
		return resource;
	}
	
	private URI getTargetResourceURI(final URI sourceURI) {
		if (sourceURI.isPlatformResource()) {
			final List<String> segments = getTargetResourcePathSegments(sourceURI);
			// Add Project name as URI first segment
			segments.add(0, importData.getTargetProject().getProject().getName());
			final String path = Joiner.on("/").join(segments);
			
			return URI.createPlatformResourceURI(path, true);
		}
		return null;
	}
	
	private List<String> getTargetResourcePathSegments(URI sourceURI) {
		List<String> segments = new ArrayList<String>(sourceURI.segmentsList());

		if (sourceURI.isPlatformResource()) {
			// Remove "resource" and project's name
			segments.remove(0);
			segments.remove(0);
			
			// Add destination folder to the resource path segments
			// TODO retrieve name from MAR File
			segments.add(0, projectName);
			segments.add(0, IMPORT_FOLDER_NAME);
		}
		
		return segments;
	}

	private void addReferencedAnalysis() {
		// Get main analysis
		Session sourceSession = importData.getSourceSession();
		Session targetSession = importData.getTargetSession();
		DAnalysis sourceMainAnalysis = getMainAnalysis(sourceSession);
		
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
	
	
	private DAnalysis getMainAnalysis(Session session) {
		Resource sessionResource = session.getSessionResource();
		if (sessionResource != null && !sessionResource.getContents().isEmpty()) {
			for (EObject content : sessionResource.getContents()) {
				if (content instanceof DAnalysis) {
					return (DAnalysis)content;
				}
			}
		}
		return null;
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
//                        String[] natures = { ModelingProject.NATURE_ID };
//                        desc.setNatureIds(natures);

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
}
