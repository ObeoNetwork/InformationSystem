/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.extensions.services;

import java.util.regex.Pattern;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.postprocessor.BasicPostProcessorDescriptorImpl;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.postprocessor.PostProcessorDescriptorRegistryImpl;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.extensions.match.DatabaseMatchEngineFactory;
import org.obeonetwork.dsl.database.compare.extensions.policy.DependenciesLoadOnDemandPolicy;
import org.obeonetwork.dsl.database.compare.extensions.processor.DatabasePostProcessor;

public class DatabaseCompareService {

	private final static Pattern NS_URI_PATTERN_FOR_POST_PROCESSOR = Pattern.compile("http://www.obeonetwork.org/dsl/.*");
	
	public static Comparison compare(TableContainer source, TableContainer target) throws Exception {				
		
		// Prepare using specific match engine
		IMatchEngine.Factory matchEngineFactory = new DatabaseMatchEngineFactory();
        matchEngineFactory.setRanking(20);
        IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
        matchEngineRegistry.add(matchEngineFactory);
        
        // Prepare using post processor
        IPostProcessor customPostProcessor = new DatabasePostProcessor();
        IPostProcessor.Descriptor descriptor = new BasicPostProcessorDescriptorImpl(customPostProcessor, NS_URI_PATTERN_FOR_POST_PROCESSOR , null);
        IPostProcessor.Descriptor.Registry<Object> postProcessorRegistry = new PostProcessorDescriptorRegistryImpl<Object>();
        postProcessorRegistry.put(DatabasePostProcessor.class.getName(), descriptor);
        
        EMFCompare comparator = EMFCompare.builder()
        		// Set the post processor to build DBDiffs.
        		.setPostProcessorRegistry(postProcessorRegistry)
        		// Set the specific match engine.
        		.setMatchEngineFactoryRegistry(matchEngineRegistry).build();

        // Set the "load on demand policy" registry to resolve dependencies to external libraries.
        EMFCompareRCPPlugin.getDefault().getLoadOnDemandPolicyRegistry().addPolicy(new DependenciesLoadOnDemandPolicy());
        
		// Compare the two models
		IComparisonScope scope = new DefaultComparisonScope(source, target, null);
		return comparator.compare(scope);	
	}

}
