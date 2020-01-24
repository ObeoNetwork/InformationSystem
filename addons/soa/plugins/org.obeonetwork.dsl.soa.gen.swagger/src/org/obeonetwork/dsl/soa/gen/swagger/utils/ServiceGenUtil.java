package org.obeonetwork.dsl.soa.gen.swagger.utils;

import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Service;

public class ServiceGenUtil {

	public static Component getComponent(Service service) {
		return (Component) service.eContainer();
	}

}
