/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.IFilter;
import org.obeonetwork.dsl.requirement.Requirement;

import org.eclipse.sirius.viewpoint.DSemanticDecorator;
	
public class RequirementTabPropertiesEditionSection implements IFilter {

	 
	public boolean select(Object toTest) {
		if (toTest instanceof DSemanticDecorator) {
			EObject target = ((DSemanticDecorator)toTest).getTarget();
			if (target != null && target instanceof Requirement) {
				return true;
			}
		}
		EObject eObj = EEFUtils.resolveSemanticObject(toTest);
		return (eObj != null && eObj instanceof Requirement) ;
	}
}
