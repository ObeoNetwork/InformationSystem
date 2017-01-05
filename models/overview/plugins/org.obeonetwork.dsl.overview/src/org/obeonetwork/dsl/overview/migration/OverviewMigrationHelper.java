/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
