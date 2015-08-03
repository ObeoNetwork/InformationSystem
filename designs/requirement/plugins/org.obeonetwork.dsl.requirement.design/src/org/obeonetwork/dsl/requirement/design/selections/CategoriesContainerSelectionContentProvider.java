package org.obeonetwork.dsl.requirement.design.selections;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.requirement.CategoriesContainer;

/**
 * @author atakarabt
 *
 */
public class CategoriesContainerSelectionContentProvider extends
		AbstractSelectionContentProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.
	 * Object)
	 */
	public Object[] getElements(Object inputElement) {
		EObject eObject = ((Resource)inputElement).getContents().get(0);
		return new Object[] { ((CategoriesContainer)eObject)};
	}

}
