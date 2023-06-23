/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.requirement.wizard.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;

public class RequirementsRepositoriesContentProvider extends AdapterFactoryContentProvider
		implements ITreeContentProvider {

	public RequirementsRepositoriesContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Object[] getElements(Object object) {
		if (object instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<Resource> requirementsRepositories = (Collection<Resource>) object;
			return requirementsRepositories.toArray(new Resource[requirementsRepositories.size()]);
		}
		return super.getElements(object);
	}

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof Resource) {
			List<Repository> repositories = new ArrayList<Repository>();
			// Get Repository instances
			for (EObject child : ((Resource) object).getContents()) {
				if (child instanceof Repository) {
					repositories.add((Repository) child);
				}
			}
			return repositories.toArray();
		} else if (object instanceof Repository) {
			Repository repository = (Repository) object;
			// Get categories
			List<Object> children = new ArrayList<Object>();
			children.addAll(repository.getOwnedCategories());
			// Get requirements
			children.addAll(repository.getOwnedRequirements());
			return children.toArray();
		} else if (object instanceof Category) {
			Category category = (Category) object;

			List<Object> children = new ArrayList<Object>();
			children.addAll(category.getOwnedCategories());
			children.addAll(category.getOwnedRequirements());
			return children.toArray();
		}
		return new Object[] {};
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
	}

}
