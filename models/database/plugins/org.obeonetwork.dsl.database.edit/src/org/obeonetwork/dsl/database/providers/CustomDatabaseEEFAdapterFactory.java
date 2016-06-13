package org.obeonetwork.dsl.database.providers;

import org.eclipse.emf.common.notify.Adapter;

public class CustomDatabaseEEFAdapterFactory extends DatabaseEEFAdapterFactory {

	@Override
	public Adapter createColumnAdapter() {
		return new CustomColumnPropertiesEditionProvider();
	}
}
