package org.obeonetwork.dsl.typeslibrary.providers;

import org.eclipse.emf.common.notify.Adapter;

public class CustomTypeslibraryEEFAdapterFactory extends TypeslibraryEEFAdapterFactory {

	@Override
	public Adapter createTypeInstanceAdapter() {
		return new CustomTypeInstancePropertiesEditionProvider();
	}
}
