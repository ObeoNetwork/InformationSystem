/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.common;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.AirDResouceQuery;
import org.eclipse.sirius.business.api.query.URIQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.resource.AirdResource;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;

/**
 * Utilities around Sirius session
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
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

}
