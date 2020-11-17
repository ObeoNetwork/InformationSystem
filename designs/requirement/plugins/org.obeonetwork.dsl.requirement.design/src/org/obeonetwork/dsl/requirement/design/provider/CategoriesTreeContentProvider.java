/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.design.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.design.comparators.CategoryComparator;

/**
 * Content provider to get all categories in a Sirius session.
 * Some categories can be hidden
 * @author sthibaudeau
 *
 */
public class CategoriesTreeContentProvider implements ITreeContentProvider{
	private Collection<Category> hiddenCategories;
	
	public CategoriesTreeContentProvider(Collection<Category> hiddenCategories) {
		this.hiddenCategories = hiddenCategories;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Session) {
			return getRootCategoriesContainers((Session)inputElement).toArray();
		}
		return new Object[]{};
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof CategoriesContainer) {
			CategoriesContainer categoriesContainer = (CategoriesContainer)parentElement;
			List<Category> ownedCategories = new ArrayList<Category>(categoriesContainer.getOwnedCategories());
			ownedCategories.removeAll(hiddenCategories);
			
			Collections.sort(ownedCategories, CategoryComparator.INSTANCE);
			
			return ownedCategories.toArray();
		}
		return new Object[]{};
	}
	
	public boolean hasChildren(Object element) {
		if (element instanceof CategoriesContainer) {
			return getChildren(element).length > 0;
		}
		return false;
	}

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject)element).eContainer();
		}
		return null;
	}
	
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}
	
	private Collection<CategoriesContainer> getRootCategoriesContainers(Session session) {
		Collection<CategoriesContainer> categoriesContainers = new ArrayList<CategoriesContainer>();
		Collection<EObject> roots = getRootObjects(session);
		for (EObject root : roots) {
			if (root instanceof CategoriesContainer) {
				categoriesContainers.add((CategoriesContainer)root);
			}
		}
		return categoriesContainers;
	}
	
	private Collection<EObject> getRootObjects(Session session) {
		Collection<EObject> roots = new ArrayList<EObject>();
		for (Resource semanticResource : session.getSemanticResources()) {
			roots.addAll(semanticResource.getContents());
		}
		return roots;
	}
	
}
