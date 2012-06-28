package org.obeonetwork.dsl.entityrelation.providers;

import org.eclipse.emf.common.notify.Adapter;

public class CustomEntityrelationEEFAdapterFactory extends EntityrelationEEFAdapterFactory {

	@Override
	public Adapter createAttributeAdapter() {
		return new CustomAttributePropertiesEditionProvider();
	}

}
