package org.obeonetwork.dsl.graal.m2doc.services;

import org.obeonetwork.m2doc.services.IServiceHolder;

/**
 * Service holder that returns the domain class service class.
 * 
 * @author Romain Guider
 *
 */
public class DomainClassServiceHolder implements IServiceHolder {
	@Override
	public Class<?> getServiceClass() {
		return DomainClassServices.class;
	}

}
