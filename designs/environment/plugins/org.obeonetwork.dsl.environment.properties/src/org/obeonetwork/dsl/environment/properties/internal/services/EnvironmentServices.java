/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.properties.internal.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.properties.providers.IMetaDataHelpProvider;

/**
 * Services for environment models
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class EnvironmentServices {
	
	static final List<IMetaDataHelpProvider> METADATA_HELP_PROVIDERS = new ArrayList<>();
	
	static {				
		IConfigurationElement[] config =
				 Platform.getExtensionRegistry().getConfigurationElementsFor("org.obeonetwork.dsl.environment.properties.metadataHelpProvider");		
		Arrays.asList(config).forEach(configurationElement -> {
			try {
				final Object object = configurationElement.createExecutableExtension("class");
				if (object instanceof IMetaDataHelpProvider) {
					METADATA_HELP_PROVIDERS.add((IMetaDataHelpProvider) object);
				}
			} catch (CoreException | ClassCastException e) {			
				e.printStackTrace();
			}
		});
	}
	
	public MetaDataContainer getMetadataContainer(EObject self) {
		MetaDataContainer metadatas = null;
		if (self instanceof ObeoDSMObject) {
			metadatas = ((ObeoDSMObject) self).getMetadatas();
			if (metadatas == null) {
				metadatas = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
				((ObeoDSMObject) self).setMetadatas(metadatas);
			}
		}
		return metadatas;
	}
	
	/**
	 * Return a help label to display in the metadata tooltip, as provided by a {@link MetaDataExtension} 
	 * @param self an {@link ObeoDSMObject} 
	 * @return a {@link String} to be displayed as a tooltip, in the 'metadatas' view property. 
	 */
	public String getMetadatasHelpExpression(ObeoDSMObject self) {
		return METADATA_HELP_PROVIDERS
				.stream()
				.map(provider -> provider.getHelpMessage(self))
				.filter(s -> s != null && !s.isEmpty())
				.findAny()
				.orElse(null);
	}
}
