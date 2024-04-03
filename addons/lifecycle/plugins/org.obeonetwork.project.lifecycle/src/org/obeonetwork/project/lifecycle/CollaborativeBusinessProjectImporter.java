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
package org.obeonetwork.project.lifecycle;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;

import fr.obeo.dsl.viewpoint.collab.api.RepositoryConnectionException;
import fr.obeo.dsl.viewpoint.collab.api.remotesession.CollaborativeSession;

/**
 * Business project importer based on collaborative sirius session 
 *
 */
public class CollaborativeBusinessProjectImporter extends BusinessProjectImporter {
	
	private boolean isRemoteTargetSession;

	public CollaborativeBusinessProjectImporter(ModelingProject sourceProject, ModelingProject targetProject) {
		super(sourceProject, targetProject);
	}
	
	@Override
	protected void initializeImportData() {
		super.initializeImportData();
		isRemoteTargetSession = isRemoteSession(getTargetSession());
	}
	
	private boolean isRemoteSession(Session session) {
		if (session instanceof CollaborativeSession) {
			try {
				return ((CollaborativeSession) session).getRepositoryManager() != null;
			} catch (RepositoryConnectionException e) {
				return false;
			}
		}
		return false;
	}
	
	@Override
	protected void addToSemanticResource(EObject copyObject, String targetPath) {
		if (isRemoteTargetSession) {
			addToRemoteSemanticResource(copyObject, targetPath);
		} else {
			super.addToSemanticResource(copyObject, targetPath);
		}
	}
	
	private void addToRemoteSemanticResource(final EObject copyObject, final String targetPath) {
		CDOTransaction transaction = getTransactionOnSession(getTargetSession());
		if (transaction != null) {
			CDOResource targetResource = transaction.getOrCreateResource(targetPath);
			targetResource.getContents().add(copyObject);
			if (!existsTargetSemanticResource(targetResource.getURI())) {
				addToSemanticResources(getTargetSession(), targetResource.getURI(), new NullProgressMonitor());
			}
		}
	}

	
	private CDOTransaction getTransactionOnSession(Session session) {
		CDOTransaction transaction = null;
		try {
			transaction = ((CollaborativeSession)getTargetSession()).getRepositoryManager().getOrCreateTransaction(getTargetSession());
		} catch (Exception e) {
			return null;
		}
		return transaction;
	}
	
	private Resource addToSemanticResources(Session session, URI uri, IProgressMonitor monitor) {
		// Add the semantic resource to the given session
        session.addSemanticResource(uri, monitor);

        // If the semantic resource addition is successful returns the added Resource
        Resource addedResource = session.getTransactionalEditingDomain().getResourceSet().getResource(uri, false);
        if (addedResource != null) {
            return addedResource;
        }
        
        return null;
	}
	
	@Override
	protected String getTargetProjectName() {
		if (isRemoteTargetSession) {
			for (Resource referencedSessionResource : getTargetSession().getReferencedSessionResources()) {
				if (referencedSessionResource instanceof CDOResource) {
					return referencedSessionResource.getURI().segment(0);
				}
			}
			return null;
		} else {
			return super.getTargetProjectName();
		}
	}

	@Override
	protected Resource getTargetResource(String targetResourcePath) {
		if (isRemoteTargetSession) {
			return getTargetRemoteResource(targetResourcePath);
		} else {
			return super.getTargetResource(targetResourcePath);
		}
	}
	
	private CDOResource getTargetRemoteResource(String targetResourcePath) {
		CDOResource targetResource = null;
		
		CDOTransaction transaction = getTransactionOnSession(getTargetSession());
		if (transaction != null && transaction.hasResource(targetResourcePath)) {
			try {
				targetResource = transaction.getResource(targetResourcePath);
			} catch (Exception e) {
				// unable to get resource, it probably doesn't exist
			}
		}
		return targetResource;
	}
	
}
