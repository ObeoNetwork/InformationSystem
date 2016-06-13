package org.obeonetwork.dsl.environment.design.services;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.environment.StructuredType;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

public class DesignServices {

	public static Set<StructuredType> getDisplayedStructuredTypes(DSemanticDiagram diagram) {
		Set<StructuredType> result = Sets.newLinkedHashSet();
		Iterator<DSemanticDecorator> it = Iterators.filter(diagram.eAllContents(), DSemanticDecorator.class);
		while (it.hasNext()) {
			DSemanticDecorator dec = it.next();
			if (dec.getTarget() instanceof StructuredType) {
				result.add((StructuredType) dec.getTarget());
			}
		}
		return result;
	}
}
