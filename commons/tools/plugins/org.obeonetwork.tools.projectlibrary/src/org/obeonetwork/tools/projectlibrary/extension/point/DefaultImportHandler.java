/*******************************************************************************
 * Copyright (c) 2018 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	@Override
	public boolean removeImportedProjectAndResources(ModelingProject project, Collection<Resource> resourcesToDelete, MManifest projectToRemove) {
		// Remove the resources
		boolean removed = removeResources(project.getSession(), resourcesToDelete);
		
		if (removed == true) { 
			// Clean empty folders
			IFolder librariesFolder = project.getProject().getFolder(ProjectLibraryImporter.IMPORT_FOLDER_NAME);
			if (librariesFolder != null) {
				IFolder projectFolder = librariesFolder.getFolder(new ManifestServices().getLibraryProjectName(projectToRemove));
				// TODO ProgressMonitor
				try {
					projectFolder.delete(true, new NullProgressMonitor());
				} catch (CoreException e) {
					// Do nothing
				}
			}
		}
		return removed;
	}
	
	private boolean removeResources(Session session, Collection<Resource> resources) {
		Collection<Resource> deletedResource = new ArrayList<>();
		if (session instanceof DAnalysisSession) {
			final DAnalysisSession analysisSession = (DAnalysisSession)session;
			analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(analysisSession.getTransactionalEditingDomain()) {
				
				@Override
				protected void doExecute() {
					deletedResource.addAll(removeResourcesFromSession(analysisSession, resources));
				}
			});
		}
		
		return deletedResource.size() == resources.size();
	}
	
	private Collection<Resource> removeResourcesFromSession(DAnalysisSession analysisSession, Collection<Resource> resources) {
		Collection<Resource> deletedResources = new ArrayList<>();
		for (Resource resource : resources) {
			if (analysisSession.getSemanticResources().contains(resource)) {
				analysisSession.getTransactionalEditingDomain().getCommandStack().execute(new RemoveSemanticResourceCommand(analysisSession, resource, new NullProgressMonitor(), false));
			} else if (analysisSession.getAllSessionResources().contains(resource)) {
				analysisSession.removeAnalysis(resource);
			}
		}
		for (Resource resource : resources) {
			for (EObject rootObject : new ArrayList<>(resource.getContents())) {
				SiriusUtil.delete(rootObject, analysisSession);
			}
			try {
				resource.delete(null);
				deletedResources.add(resource);
			} catch (IOException e) {
				// Do nothing
			}
		}
		return deletedResources;
		
	}
	
	@Override
	public Collection<Resource> getResourcesForImportedProject(ModelingProject modelingProject, MManifest manifest) {
		Collection<Resource> resources = new ArrayList<>();
		
		Session session = modelingProject.getSession();
		
		String folderPath = ProjectLibraryImporter.IMPORT_FOLDER_NAME + '/'
				+ new ManifestServices().getLibraryProjectName(manifest);
		
		IProject project = modelingProject.getProject();
		IFolder folder = project.getFolder(new Path(folderPath));
		
		URI folderURI = URI.createPlatformResourceURI(folder.getFullPath().toString(), true);
		String folderURIAsString = folderURI.toString() + "/";
		
		// Check resources starting with this URI
		ResourceSet set = session.getTransactionalEditingDomain().getResourceSet();
		if (set != null) {
			for (Resource resource : set.getResources()) {
				if (resource.getURI() != null && resource.getURI().toString().startsWith(folderURIAsString)) {
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
