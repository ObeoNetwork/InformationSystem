package org.obeonetwork.dsl.requirement.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.IFilter;
import org.obeonetwork.dsl.requirement.Category;

import org.eclipse.sirius.viewpoint.DSemanticDecorator;

public class CategoryTabPropertiesEditionSection implements IFilter {

	 
	public boolean select(Object toTest) {
		if (toTest instanceof DSemanticDecorator) {
			EObject target = ((DSemanticDecorator)toTest).getTarget();
			if (target != null && target instanceof Category) {
				return true;
			}
		}
		EObject eObj = EEFUtils.resolveSemanticObject(toTest);
		return (eObj != null && eObj instanceof Category);
	}
}
