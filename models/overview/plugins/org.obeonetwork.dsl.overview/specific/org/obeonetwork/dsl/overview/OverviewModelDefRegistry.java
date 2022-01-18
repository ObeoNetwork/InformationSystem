/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.overview;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

public class OverviewModelDefRegistry {
	
	 private HashSet<OverviewModelDef> overviewModelDefs;
	
	 private static OverviewModelDefRegistry instance = new OverviewModelDefRegistry();
	 
	 private OverviewModelDefRegistry(){
		 this.overviewModelDefs=new HashSet<OverviewModelDef>();
		 loadOverviewModelDefs();
		 
	 }
	 
	 public static Collection<OverviewModelDef> getOverviewModelDefs(){
		 return instance.overviewModelDefs;
	 }
	 
	 private void loadOverviewModelDefs(){
		 for(OverviewModelDefExtensionDescriptor descriptor : parseOverviewModelDefExtensionMetadatas()){
			 OverviewModelDef overviewModelDef = descriptor.createOverviewModelDef();
			 overviewModelDefs.add(overviewModelDef);
		 }
	 }
	 
	 private HashSet<OverviewModelDefExtensionDescriptor> parseOverviewModelDefExtensionMetadatas() {
		 	HashSet<OverviewModelDefExtensionDescriptor> overviewModelDefExtensionDescriptors = new HashSet<OverviewModelDefExtensionDescriptor>();
	        final IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(
	        		OverviewModelDef.EXTENSION_POINT).getExtensions();
	        for (int i = 0; i < extensions.length; i++) {
	            final IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
	            for (int j = 0; j < configElements.length; j++) {
	                final OverviewModelDefExtensionDescriptor descriptor = new OverviewModelDefExtensionDescriptor(
	                        configElements[j]);
	                overviewModelDefExtensionDescriptors.add(descriptor);
	            }
	        }
	        return overviewModelDefExtensionDescriptors;
	    }
}
