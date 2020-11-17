/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.IFilter;
import org.obeonetwork.dsl.soa.System;

public class SystemTabPropertiesEditionSection implements IFilter {

	 
	public boolean select(Object toTest) {
		EObject eObj = EEFUtils.resolveSemanticObject(toTest);
		return (eObj != null && eObj instanceof System);
	}
}
