/**
 * Copyright (c) 2010, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
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
import org.obeonetwork.dsl.requirement.Requirement;

public class RequirementsRepositoriesContentProvider extends AdapterFactoryContentProvider implements ITreeContentProvider{

	public RequirementsRepositoriesContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public Object[] getElements(Object object) {
		if(object instanceof Collection<?>){
			@SuppressWarnings("unchecked")
			Collection<Resource> requirementsRepositories = (Collection<Resource>)object;
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
					repositories.add((Repository)child);
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
			List<Requirement> requirements = ((Category) object).getOwnedRequirements();
			return requirements.toArray();
		}
		return new Object[]{};
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
	}
	
}
