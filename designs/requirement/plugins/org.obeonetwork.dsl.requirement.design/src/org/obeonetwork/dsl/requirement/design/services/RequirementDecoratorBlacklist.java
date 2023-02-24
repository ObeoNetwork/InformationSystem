/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.design.services;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.business.api.query.DDiagramElementQuery;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

/**
 * 
 * @author <a href="thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
public class RequirementDecoratorBlacklist {
	
	private Set<String> blacklistedSemanticDecoratorLabels; 
	private static final String BLACKLIST_SEMANTIC_DECORATOR_EXTENSION_ID = "org.obeonetwork.dsl.requirement.design.blacklistedRequirementDecorator";
	private static final String SEMANTIC_DECORATOR_NAME_ATTRIBUTE = "name";
	
	public RequirementDecoratorBlacklist() {					
		initialize();
	}
	
	/**
	 * Get the extensions and add the values to the blacklist collection 
	 */
	public void initialize() {
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(BLACKLIST_SEMANTIC_DECORATOR_EXTENSION_ID).getExtensions();
		
		blacklistedSemanticDecoratorLabels = Arrays.stream(extensions)
				.map(IExtension::getConfigurationElements)
				.flatMap(Arrays::stream)
				.map(configurationElement -> configurationElement.getAttribute(SEMANTIC_DECORATOR_NAME_ATTRIBUTE))
				.collect(Collectors.toSet());
	}
	
	/**
	 * Checks that the label of the {@link DSemanticDecorator} specified belongs to the blacklist. 
	 * @param semanticDecorator a Sirius {@link DSemanticDecorator}
	 * @return true if the semantic decorator mapping name is in the blacklist.
	 */
	public boolean isBlacklisted(DSemanticDecorator semanticDecorator) {
		if (semanticDecorator instanceof DDiagramElement) {
			Option<String> optionalMappingName = new DDiagramElementQuery((DDiagramElement)semanticDecorator).getMappingName();

			if (optionalMappingName.some()) {							
				String mappingName = optionalMappingName.get();
				if (blacklistedSemanticDecoratorLabels.contains(mappingName)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
