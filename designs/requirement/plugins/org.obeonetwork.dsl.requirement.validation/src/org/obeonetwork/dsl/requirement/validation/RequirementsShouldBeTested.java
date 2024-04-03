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
package org.obeonetwork.dsl.requirement.validation;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.presentation.RequirementEditor;

public class RequirementsShouldBeTested extends PropertyTester {

	public RequirementsShouldBeTested() {
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IEditorPart) {
			if (receiver instanceof RequirementEditor) {
				return true;
			}
			IEditorInput editorInput = ((IEditorPart)receiver).getEditorInput();
			if (editorInput instanceof SessionEditorInput) {
				SessionEditorInput sessionEditorInput = (SessionEditorInput)editorInput;
				Session session = sessionEditorInput.getSession();
				if (session != null) {
					TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
					if (ted != null) {
						return containsRequirementsModel(ted.getResourceSet());
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Tests if the resource set contains at least one Requirements model
	 * @param set ResourceSet to be tested
	 * @return boolean
	 */
	private boolean containsRequirementsModel(ResourceSet set) {
		if (set != null) {
			for (Resource resource : set.getResources()) {
				for (EObject eObject : resource.getContents()) {
					if (eObject instanceof Repository
						|| eObject instanceof Category
						|| eObject instanceof Requirement) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
