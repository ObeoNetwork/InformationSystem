package org.obeonetwork.dsl.environment.design.ui.menu;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

public class PartialViewExtension {

	private static final String PARTIAL_VIEW_EXTENSION_ID = "org.obeonetwork.dsl.environment.design.partialView";
	private static final String DESCRIPTION_NAME_ATTRIBUTE = "descriptionName";
	
	private static Set<String> partialViewDescriptionNames = null;
	
	public static Set<String> getPartialViewDescriptionNames() {
		if(partialViewDescriptionNames == null) {
			initPartialViewDescriptionNames();
		}
		return partialViewDescriptionNames;
	}

	private static void initPartialViewDescriptionNames() {
		
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(PARTIAL_VIEW_EXTENSION_ID).getExtensions();
		
		partialViewDescriptionNames = Arrays.stream(extensions)
				.map(IExtension::getConfigurationElements)
				.flatMap(Arrays::stream)
				.map(configurationElement -> configurationElement.getAttribute(DESCRIPTION_NAME_ATTRIBUTE))
				.collect(Collectors.toSet());
	}
	
}
