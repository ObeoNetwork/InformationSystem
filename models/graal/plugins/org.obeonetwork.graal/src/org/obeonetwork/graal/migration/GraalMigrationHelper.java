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
package org.obeonetwork.graal.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.entity.migration.EntityMigrationHelper;
import org.obeonetwork.dsl.environment.migration.EnvironmentMigrationHelper;
import org.obeonetwork.dsl.soa.migration.SoaMigrationHelper;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.tools.migration.ComposedMigrationHelper;

public class GraalMigrationHelper extends ComposedMigrationHelper {

	public GraalMigrationHelper() {
		super(new EnvironmentMigrationHelper(), new SoaMigrationHelper(), new EntityMigrationHelper());
	}
	
	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		EStructuralFeature feature = super.findEStructuralFeature(eClass, name, found);
		if (feature == null) {
			if (GraalPackage.Literals.DOMAIN_MODEL_REGISTRY.isSuperTypeOf(eClass)) {
				if ("entities".equals(name)) {
					return GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__TYPES;
				} else if ("dtos".equals(name)) {
					return GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__TYPES;
				} else if ("entityBlocks".equals(name)) {
					return GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__NAMESPACES;
				} else if ("dtoCategories".equals(name)) {
					return GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__NAMESPACES;
				}
			}
		}
		
		return feature;
	}
}
