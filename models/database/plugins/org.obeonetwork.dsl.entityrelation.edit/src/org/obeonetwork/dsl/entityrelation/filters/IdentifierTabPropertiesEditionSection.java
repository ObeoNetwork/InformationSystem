package org.obeonetwork.dsl.entityrelation.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.IFilter;
import org.obeonetwork.dsl.entityrelation.Identifier;


public class IdentifierTabPropertiesEditionSection implements IFilter {

	 
	public boolean select(Object toTest) {
		EObject eObj = EEFUtils.resolveSemanticObject(toTest);
		return (eObj != null && eObj instanceof Identifier);
	}
}
