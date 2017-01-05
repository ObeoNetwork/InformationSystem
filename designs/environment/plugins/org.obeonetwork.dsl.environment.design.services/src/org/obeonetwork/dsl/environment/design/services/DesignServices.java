/*******************************************************************************
 * Copyright (c) 2015, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
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
