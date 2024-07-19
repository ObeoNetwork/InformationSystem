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
package org.obeonetwork.database.ui.actions.testers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DAnalysisSessionEObject;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryUser;

import org.obeonetwork.database.ui.util.ScaffoldingUtils;

/**
 * 
 * @author Obeo
 *
 */
public class TestIsLogical extends AbstractScaffoldingPropertyTester {

	public TestIsLogical() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) receiver;
			if (selection.size() == 1) {
				Object element = selection.getFirstElement();
				Resource resource = (element instanceof Resource) ? ((Resource) element)
						: getResourceFromSession(getModelURI(element));
				if (resource != null) {
					if (resource.getContents() != null && resource.getContents().isEmpty() == false) {
						EObject root = resource.getContents().get(0);
						if (root instanceof TypesLibraryUser) {
							return ScaffoldingUtils.isValidInputForMld(root);
						}
					}
				}
			}

		}
		return false;
	}

	private static Resource getResourceFromSession(URI semanticResourceURI) {
		if (semanticResourceURI != null) {
			for (Session session : SessionManager.INSTANCE.getSessions()) {
				for (Resource semanticResource : session.getSemanticResources()) {
					if (semanticResourceURI.equals(semanticResource.getURI())) {
						return semanticResource;
					}
				}
				if (session instanceof DAnalysisSessionEObject) {
					for (Resource controlledResource : ((DAnalysisSessionEObject) session).getControlledResources()) {
						if (semanticResourceURI.equals(controlledResource.getURI())) {
							return controlledResource;
						}
					}
				}
			}
		}
		return null;
	}
}
