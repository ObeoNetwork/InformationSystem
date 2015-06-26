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
