/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.imp.ImportData;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;

/**
 * Interface used to define specific code to copy resources when importing a project library
 * @author S. Thibaudeau
 *
 */
public abstract class AbstractImportHandler {
	
	/**
	 * Do something before import
	 * @param targetProject 
	 * @param importedManifestModel 
	 * @return
	 */
	public boolean doPreImport(ModelingProject targetProject, MManifest importedManifestModel) throws LibraryImportException {
		return true;
	}
	
	/**
	 * Do something after import
	 * @param importDate
	 * @return
	 */
	public boolean doPostImport(ImportData importData) throws LibraryImportException {
		return true;
	}

	/**
	 * Returns true if the resource copier is enabled given the target session
	 * @param session
	 * @return
	 */
	abstract public boolean isEnabled(Session targetSession);
	
	/**
	 * Returns the priority to choose between 2 different copiers which would be both enabled
	 * Lowest number comes first
	 * @return
	 */
	abstract public int getPriority();
	
	/**
	 * Copies a resource into the target project
	 * @param importData
	 * @param sourceResource
	 * @return
	 */
	abstract public Resource copyResource(final ImportData importData, final Resource sourceResource);
	
	/**
	 * Returns the target URI corresponding to a source resource
	 * @param importData
	 * @param sourceResourceURI
	 * @return
	 */
	abstract public URI getTargetResourceURI(final ImportData importData, final URI sourceResourceURI);
	
	/**
	 * Returns the resources in the modeling project corresponding to the imported project
	 * @param modelingProject
	 * @param manifest
	 * @return
	 */
	abstract public Collection<Resource> getResourcesForImportedProject(IProject modelingProject, MManifest manifest);
	
	/**
	 * Removes the specified resources from the project
	 * @param project
	 * @param resourcesToDelete
	 * @param projectToRemove
	 * @return True if all resources have been removed
	 */
	abstract public boolean removeImportedProjectAndResources(IProject project, Collection<Resource> resourcesToDelete, MManifest projectToRemove) throws LibraryImportException;
}
