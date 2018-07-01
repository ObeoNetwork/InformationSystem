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

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.imp.ImportData;

/**
 * Interface used to define specific code to copy resources when importing a project library
 * @author S. Thibaudeau
 *
 */
public interface IResourceCopier {

	/**
	 * Returns true if the resource copier is enabled given the target session
	 * @param session
	 * @return
	 */
	public boolean isEnabled(Session targetSession);
	
	/**
	 * Returns the priority to choose between 2 different copiers which would be both enabled
	 * Lowest number comes first
	 * @return
	 */
	public int getPriority();
	
	/**
	 * Copies a resource into the target project
	 * @param importData
	 * @param sourceResource
	 * @return
	 */
	public Resource copyResource(final ImportData importData, final Resource sourceResource);
	
	/**
	 * Returns the target URI corresponding to a source resource
	 * @param importData
	 * @param sourceResourceURI
	 * @return
	 */
	public URI getTargetResourceURI(final ImportData importData, final URI sourceResourceURI);
	
	/**
	 * Returns the resources in the modeling project corresponding to the imported project
	 * @param modelingProject
	 * @param manifest
	 * @return
	 */
	public Collection<Resource> getResourcesForImportedProject(ModelingProject modelingProject, MManifest manifest);
}
