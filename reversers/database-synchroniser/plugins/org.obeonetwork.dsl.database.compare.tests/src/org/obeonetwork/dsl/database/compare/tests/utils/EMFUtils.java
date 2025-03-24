/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.tests.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class EMFUtils {

	/**
	 * 
	 * @param type
	 * @param container
	 * @return all instances of {@code type} contained directly or indirectly by
	 *         {@code container}.
	 */
	public static Collection<EObject> getAllContentsOfType(EClass type, EObject container) {
		Collection<EObject> instances = new ArrayList<>();
		Iterator<EObject> iterator = container.eAllContents();
		while (iterator.hasNext()) {
			EObject eo = iterator.next();
			if (type.isInstance(eo)) {
				instances.add(eo);
			}
		}
		return instances;
	}
}
