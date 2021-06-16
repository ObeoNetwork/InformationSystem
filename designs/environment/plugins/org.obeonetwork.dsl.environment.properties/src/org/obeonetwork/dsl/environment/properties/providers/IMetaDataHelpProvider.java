package org.obeonetwork.dsl.environment.properties.providers;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
public interface IMetaDataHelpProvider {
	
	/**
	 * Returns an help message provided by the {@link ObeoDSMObject} 
	 * @param dsmObject a {@link ObeoDSMObject}
	 * @return a {@link String}
	 * 
	 * Make sure to return an empty {@link String} or <code>null</code>, 
	 * if the {@link ObeoDSMObject} provided is not conforming to the expected class.
	 */
	public String getHelpMessage(ObeoDSMObject dsmObject);	
	
}
