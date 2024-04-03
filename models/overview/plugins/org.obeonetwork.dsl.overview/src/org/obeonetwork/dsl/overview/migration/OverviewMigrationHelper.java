/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.overview.migration;

import org.obeonetwork.dsl.entity.migration.EntityMigrationHelper;
import org.obeonetwork.dsl.environment.migration.EnvironmentMigrationHelper;
import org.obeonetwork.dsl.soa.migration.SoaMigrationHelper;
import org.obeonetwork.tools.migration.ComposedMigrationHelper;

public class OverviewMigrationHelper extends ComposedMigrationHelper {

	public OverviewMigrationHelper() {
		super(new EnvironmentMigrationHelper(), new SoaMigrationHelper(), new EntityMigrationHelper());
	}
}
