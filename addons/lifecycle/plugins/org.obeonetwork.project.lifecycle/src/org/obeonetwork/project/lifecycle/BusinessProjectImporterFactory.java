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
package org.obeonetwork.project.lifecycle;

import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;

public class BusinessProjectImporterFactory {

	public static BusinessProjectImporter getBusinessProjectImporter(ModelingProject sourceProject, ModelingProject targetProject) {
		Session targetSession = ImporterUtil.getSession(targetProject);
		
		// Check if we are on a collaborative Sirius or not
		boolean collaborativeSession = false;
		try {
			collaborativeSession = Class.forName("fr.obeo.dsl.viewpoint.collab.api.remotesession.CollaborativeSession").isInstance(targetSession);
		} catch (ClassNotFoundException e) {
			collaborativeSession = false;
		}
		
		return collaborativeSession ? new CollaborativeBusinessProjectImporter(sourceProject, targetProject) : new BusinessProjectImporter(sourceProject, targetProject);
	}
}
