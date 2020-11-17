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
package org.obeonetwork.dsl.environment.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.tools.migration.BasicMigrationHelper;

public class EnvironmentMigrationHelper extends BasicMigrationHelper {
	
	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		if (eClass == EnvironmentPackage.eINSTANCE.getEnumeration()) {
			// Enumeration.fields => Enumeration.literals
			if ("fields".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getEnumeration_Literals();
			}
		}
		return found;
	}
}
