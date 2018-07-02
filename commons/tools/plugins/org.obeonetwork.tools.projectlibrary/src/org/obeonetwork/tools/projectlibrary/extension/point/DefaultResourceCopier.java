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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
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
public class DefaultResourceCopier implements IResourceCopier {

	@Override
	public boolean isEnabled(Session session) {
		return true;
	}

	@Override
	public int getPriority() {
		return Integer.MAX_VALUE;
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
