/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.filter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.IFilter;
import org.obeonetwork.graal.GraalPackage;

/**
 * Filter class used to display Version and Risk properties view only for Graal's use cases, tasks and user stories
 * @author Obeo
 *
 */
public class GraalExtensionsFilter implements IFilter {

	public boolean select(Object toTest) {
		EObject target = EEFUtils.resolveSemanticObject(toTest);
		return isPerimeterUnit(target);
	}
	
	public static boolean isPerimeterUnit(Object toTest) {
		return (GraalPackage.Literals.USE_CASE.isInstance(toTest)
				|| GraalPackage.Literals.TASK.isInstance(toTest)
				|| GraalPackage.Literals.USER_STORY.isInstance(toTest));
	}
	
}
