package org.obeonetwork.dsl.requirement.design.selections;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;

/**
 * @author atakarabt
 *
 */
public class RequirementSelectionContentProvider extends
		AbstractSelectionContentProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.
	 * Object)
	 */
	public Object[] getElements(Object inputElement) {
		CategoriesContainer rootContainer = (CategoriesContainer) EcoreUtil
				.getRootContainer((EObject) inputElement);
		if (rootContainer instanceof Category) {
			return new Object[] { rootContainer };
		} else if (rootContainer instanceof Repository) {
			List<Category> ownedCategories = ((Repository) rootContainer)
					.getOwnedCategories();
			return ownedCategories.toArray();
		}
		return new Object[0];
	}

}
