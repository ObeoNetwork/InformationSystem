/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.AirDResouceQuery;
import org.eclipse.sirius.business.api.query.URIQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.resource.AirdResource;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;

/**
 * Utilities around Sirius session
 * @author Obeo
 *
 */
public class SessionUtils {
	
	/**
	 * Returns the main analysis for a session
	 * for a local project this is the root analysis
	 * for a remote project this is the first remote analysis referenced by the local root analysis
	 * @param session
	 * @return
	 */
	public DAnalysis getMainAnalysis(Session session) {
		if (session != null) {
			Resource airdResource = session.getSessionResource();
			if (airdResource instanceof AirdResource) {
				Option<DAnalysis> optionAnalysis = new AirDResouceQuery((AirdResource)airdResource).getDAnalysis();
				if (optionAnalysis.some()) {
					DAnalysis analysis = optionAnalysis.get();
					
					// Retrieve the first referenced analysis
					if (!analysis.getReferencedAnalysis().isEmpty()) {
						DAnalysis firstReferencedAnalysis = analysis.getReferencedAnalysis().get(0);
					
						// Test if remote resource
						if (isRemoteResource(firstReferencedAnalysis.eResource())) {
							return firstReferencedAnalysis;
						}
					}

					// No referenced analysis, the main analysis is the root one
					return analysis;
				}
			}
		}
		return null;
	}

	/**
	 * Checks if a session is a shared project by checking whether the main analysis is a CDO resource or not
	 * @param session
	 * @return
	 */
	public boolean isSharedSession(Session session) {
		DAnalysis mainAnalysis = getMainAnalysis(session);
		Resource resource = mainAnalysis.eResource();
		return isRemoteResource(resource);
	}
	
	private boolean isRemoteResource(Resource resource) {
		if (resource != null) {
			URI uri = resource.getURI();
			return uri != null && new URIQuery(uri).isCDOURI();
		}
		return false;
	}
	
	public static ModelingProject getModelingProjectFromSession(Session session) {
	    if (session == null || session.getSessionResource() == null) {
	        return null;
	    }
	    URI uri = session.getSessionResource().getURI();
	    if (!uri.isPlatformResource()) {
	        return null;
	    }
	    
	    IPath path = new Path(uri.toPlatformString(true));
	    IProject project = ResourcesPlugin.getWorkspace().getRoot().getFile(path).getProject();
	    
	    return ModelingProject.asModelingProject(project).get();
	}
	
	public static RepresentationDescription getRepresentationDescription(Session session, EObject context, String representationDescriptionId) {
		return DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false), context).stream()
				.filter(r -> representationDescriptionId.equals(r.getName()))
				.findAny().orElse(null);
	}
	
	/**
	 * Search for the first .aird file in {@link project}.
	 * 
	 * @return a Session corresponding to the first found .aird file, or Empty {@link Optional} if none.
	 */
	public static Optional<Session> getSession(IProject project) {
		List<IFile> candidateAirdFiles = new ArrayList<>();
		try {
			for(IResource member : project.members()) {
				if(member instanceof IFile) {
					IFile file = (IFile) member;
					if(file.getFileExtension().equals(SiriusUtil.SESSION_RESOURCE_EXTENSION)) {
						candidateAirdFiles.add(file);
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		if(!candidateAirdFiles.isEmpty()) {
			IFile iFile = candidateAirdFiles.get(0); //FIXME: do something like ModelingProjectQuery.computeMainRepresentationsFileURI()
			URI sessionResourceURI = URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
			return Optional.ofNullable(SessionManager.INSTANCE.getSession(sessionResourceURI, new NullProgressMonitor()));
		}
		
		return Optional.empty();
	}

}
