package org.obeonetwork.dsl.graal.m2doc.services;

import org.obeonetwork.m2doc.services.IServiceHolder;

public class UseCaseServicesHolder implements IServiceHolder {

	@Override
	public Class<?> getServiceClass() {
		return UseCaseServices.class;
	}

}
