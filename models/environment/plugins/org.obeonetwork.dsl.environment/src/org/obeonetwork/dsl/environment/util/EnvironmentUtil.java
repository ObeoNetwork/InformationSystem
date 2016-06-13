/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.util;

import org.eclipse.emf.cdo.eresource.impl.CDOResourceImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

public class EnvironmentUtil {

	public static boolean shouldUpdateModifiedOn(EObject element) {
		if (isResourceLoading(element)) {
			return false;
		}
		return true;
	}
	
	public static boolean isResourceLoading(EObject element) {
		if (element.eResource() != null) {
			if (element.eResource() instanceof ResourceImpl) {
				return ((ResourceImpl)element.eResource()).isLoading();
			} else if (element.eResource() instanceof CDOResourceImpl) {
				return ((CDOResourceImpl)element.eResource()).isLoading();
			}
		} else {
			return true;
		}
		return false;
	}
}
