package org.obeonetwork.requirement.m2doc.services;

import org.obeonetwork.m2doc.services.IServiceHolder;

/**
 * Holder class for requirement services.
 * 
 * @author Romain Guider
 *
 */
public class RequirementServicesHolder implements IServiceHolder {

	@Override
	public Class<?> getServiceClass() {
		return RequirementServices.class;
	}

}
