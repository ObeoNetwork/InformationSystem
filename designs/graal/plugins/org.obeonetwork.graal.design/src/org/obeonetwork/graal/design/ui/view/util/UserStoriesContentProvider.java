/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.UserStory;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class UserStoriesContentProvider implements ITreeContentProvider {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>) {
			return availableStories((Collection<?>) inputElement).toArray();
		} else if (inputElement instanceof EObject) {
			return availableStories((EObject) inputElement).toArray();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		return false;
	}

	/**
	 * @param eObject
	 * @return
	 */
	private List<UserStory> availableStories(Collection<?> eObjects) {
		List<EObject> treatedRoots = new ArrayList<EObject>();
		List<UserStory> result = new ArrayList<UserStory>();
		for (Object next : eObjects) {
			if (next instanceof EObject) {
				EObject eObject = (EObject) next;
				EObject rootContainer = EcoreUtil.getRootContainer(eObject);
				if (!treatedRoots.contains(rootContainer)) {
					if (rootContainer instanceof System) {
						result.addAll(((System) rootContainer).getUserStories());
					}
					treatedRoots.add(rootContainer);
				}				
			}

		}
		return result;
	}

	/**
	 * @param eObject
	 * @return
	 */
	private List<UserStory> availableStories(EObject eObject) {
		EObject rootContainer = EcoreUtil.getRootContainer(eObject);
		if (rootContainer instanceof System) {
			return ((System) rootContainer).getUserStories();
		}
		return Collections.emptyList();
	}

}
