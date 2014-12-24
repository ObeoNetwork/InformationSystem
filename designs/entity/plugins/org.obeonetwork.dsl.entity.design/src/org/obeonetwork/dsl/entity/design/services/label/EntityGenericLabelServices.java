package org.obeonetwork.dsl.entity.design.services.label;

import org.obeonetwork.dsl.entity.design.services.label.specific.EntityLabelServices;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.design.services.EnvironmentLabelServices;
import org.obeonetwork.dsl.environment.util.ComposedSwitchWithFallback;

public class EntityGenericLabelServices extends ComposedSwitchWithFallback<String> {

	public EntityGenericLabelServices() {
		super();
		addSwitch(new EntityLabelServices());
		setFallbackSwitch(new EnvironmentLabelServices());
	}
	
	public String getEntityLabel(ObeoDSMObject object) {
		return doSwitch(object);
	}
	
	public String getEntityQualifiedName(ObeoDSMObject object) {
		if (object.eContainer() instanceof Namespace) {
			return getEntityQualifiedName((Namespace)object.eContainer()) + ":" + getEntityLabel(object);
		} else {
			return getEntityLabel(object);
		}
	}
}
