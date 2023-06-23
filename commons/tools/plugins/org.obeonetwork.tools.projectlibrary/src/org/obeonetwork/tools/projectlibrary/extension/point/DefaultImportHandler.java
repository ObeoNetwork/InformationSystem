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
package org.obeonetwork.tools.projectlibrary.extension.point;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.tools.api.command.semantic.RemoveSemanticResourceCommand;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.imp.ImportData;
import org.obeonetwork.tools.projectlibrary.imp.ProjectLibraryImporter;
import org.obeonetwork.utils.common.SessionUtils;

import com.google.common.base.Joiner;

/**
 * Copies an imported resource into a local modeling project
 * @author Stéphane Thibaudeau
 *
 */
public class DefaultImportHandler extends AbstractImportHandler {

	@Override
	public boolean isEnabled(Session session) {
		return true;
	}

	@Override
	public int getPriority() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Removes the specified resources from the project
	 * @param project
	 * @param resourcesToDelete
	 * @param projectToRemove
	 * @ shouldDeleteResource
	 * @return True if all resources have been removed
	 */
	public boolean removeImportedProjectAndResources(IProject project, Collection<Resource> resourcesToDelete, MManifest projectToRemove, boolean shouldDeleteResource) {
		// Remove the resources
		Optional<Session> session = SessionUtils.getSession(project);
		
		boolean removed = false;
		if(session.isPresent()) {
			removed = removeResources(session.get(), resourcesToDelete, shouldDeleteResource);
			
			if (removed == true) { 
				// Clean empty folders
				IFolder librariesFolder = project.getFolder(ProjectLibraryImporter.IMPORT_FOLDER_NAME);
				if (librariesFolder != null) {
					IFolder projectFolder = librariesFolder.getFolder(new ManifestServices().getLibraryProjectName(projectToRemove));
					try {
						projectFolder.delete(true, new NullProgressMonitor());
					} catch (CoreException e) {
						// Do nothing
					}
				}
			}
			
		}
		return removed;
	}
	
	@Override
	public boolean removeImportedProjectAndResources(IProject project, Collection<Resource> resourcesToDelete, MManifest projectToRemove) {
		return removeImportedProjectAndResources(project, resourcesToDelete, projectToRemove, true);
	}
	
	private boolean removeResources(Session session, Collection<Resource> resources, boolean shouldDeleteResource) {
		Collection<Resource> deletedResource = new ArrayList<>();
		if (session instanceof DAnalysisSession) {
			final DAnalysisSession analysisSession = (DAnalysisSession)session;
			analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(analysisSession.getTransactionalEditingDomain()) {
				
				@Override
				protected void doExecute() {
					deletedResource.addAll(removeResourcesFromSession(analysisSession, resources, shouldDeleteResource));
				}
			});
		}
		
		return deletedResource.size() == resources.size();
	}
	
	private Collection<Resource> removeResourcesFromSession(DAnalysisSession analysisSession, Collection<Resource> resources, boolean shouldDeleteResource) {
		Collection<Resource> deletedResources = new ArrayList<>();
		for (Resource resource : resources) {
			if (analysisSession.getSemanticResources().contains(resource)) {
				analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RemoveSemanticResourceCommand(analysisSession, resource, new NullProgressMonitor(), false));
			} else if (analysisSession.getAllSessionResources().contains(resource)) {
				analysisSession.removeAnalysis(resource);
			}
		}
		for (Resource resource : resources) {
			if (shouldDeleteResource) {
				try {
					resource.delete(null);
					deletedResources.add(resource);
				} catch (IOException e) {
					// Do nothing
				}
			}
		}
		return deletedResources;
		
	}
	
	@Override
	public Collection<Resource> getResourcesForImportedProject(IProject project, MManifest manifest) {
		Collection<Resource> resources = new ArrayList<>();
		
		Optional<Session> session = SessionUtils.getSession(project);
		
		if(session.isPresent()) {
			String folderPath = ProjectLibraryImporter.IMPORT_FOLDER_NAME + '/'
					+ new ManifestServices().getLibraryProjectName(manifest);
			
			IFolder folder = project.getFolder(new Path(folderPath));
			
			URI folderURI = URI.createPlatformResourceURI(folder.getFullPath().toString(), true);
			String folderURIAsString = folderURI.toString() + "/";
			
			// Check resources starting with this URI
			ResourceSet set = session.get().getTransactionalEditingDomain().getResourceSet();
			if (set != null) {
				for (Resource resource : set.getResources()) {
					if (resource.getURI() != null && resource.getURI().toString().startsWith(folderURIAsString)) {
						resources.add(resource);
					}
				}
			}
		}
		
		return resources;
	}
	
	/**
	 * Returns the resources in the modeling project corresponding to the imported project.
	 * The resource is matched with a URI of type 'platform:/resource'.
	 * 
	 * @param modelingProject
	 * @param manifest the manifest of the imported project
	 * @return
	 */
	public Collection<Resource> getResourcesForImportedWsProject(Session session, MManifest manifest) {
		Collection<Resource> resources = new ArrayList<>();
		
		String matchingURI = "platform:/resource/" + manifest.getProjectId() + "/";
		
		// Check resources starting with this URI
		ResourceSet set = session.getTransactionalEditingDomain().getResourceSet();
		if (set != null) {
			for (Resource resource : set.getResources()) {
				if (resource.getURI() != null && resource.getURI().toString().startsWith(matchingURI)) {
					resources.add(resource);
				}
			}
		}
		
		return resources;
	}
	
	@Override
	public Resource copyResource(final ImportData importData, final Resource sourceResource) {
		Collection<EObject> contents = sourceResource.getContents();
		Collection<EObject> copiedContents = new ArrayList<>();
		for (EObject object : contents) {
			EObject copiedObject = importData.getCopyEObject(object);
			copiedContents.add(copiedObject);
		}
		
		URI targetURI = getTargetResourceURI(importData, sourceResource.getURI());
		Resource targetResource = createTargetResource(importData, copiedContents, targetURI);
		return targetResource;
	}

	
	private Resource createTargetResource(final ImportData importData, final Collection<EObject> contents, final URI targetURI) {
		ResourceSet resourceSet = importData.getTargetSession().getTransactionalEditingDomain().getResourceSet();
		Resource resource = resourceSet.createResource(targetURI);
		resource.getContents().addAll(contents);
		return resource;
	}
	
	public URI getTargetResourceURI(final ImportData importData, final URI sourceURI) {
		if (sourceURI.isPlatformResource()) {
			final List<String> segments = getTargetResourcePathSegments(importData, sourceURI);
			// Add Project name as URI first segment
			segments.add(0, encode(importData.getTargetProject().getProject().getName()));
			final String path = Joiner.on("/").join(segments);
			
			return URI.createPlatformResourceURI(path, false);
		}
		return null;
	}
	
	private List<String> getTargetResourcePathSegments(final ImportData importData, URI sourceURI) {
		List<String> segments = new ArrayList<String>(sourceURI.segmentsList());

		if (sourceURI.isPlatformResource()) {
			// Remove "resource" and project's name
			segments.remove(0);
			segments.remove(0);
			
			// Add destination folder to the resource path segments
			segments.add(0, encode(importData.getLibraryProjectName()));
			segments.add(0, encode(ProjectLibraryImporter.IMPORT_FOLDER_NAME));
		}
		
		return segments;
	}
	
	private String encode(String value) {
		try {
			return URLEncoder.encode(value, java.nio.charset.StandardCharsets.UTF_8.toString()).replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			return value;
		}
	}

}
