package org.obeonetwork.dsl.cinematic.design.extension;

import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.properties.providers.IMetaDataHelpProvider;

public class AbstractViewElementMetadataProvider implements IMetaDataHelpProvider{
	
	@Override
	public String getHelpMessage(ObeoDSMObject dsmObject) {
		if (dsmObject instanceof AbstractViewElement)
			return ((AbstractViewElement) dsmObject).getWidget().getMetadataHelp();
		else 
			return null;
	}

}
