/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.ui.selector;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.cdo.common.protocol.CDOProtocolConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelector;
import org.eclipse.sirius.table.metamodel.table.DTable;
import org.eclipse.sirius.tree.DTree;

/**
 * A {@link DAnalysisSelector} to have {@link DRepresentation} creation done
 * only on remote DAnalysis expect for {@link DTable} and {@link DTree}, which will be created
 * locally .
 * 
 * @author Obeo
 */
public class CreateTablesAndTreesLocallyDAnalysisSelector implements DAnalysisSelector {

	private static final String LIBRARIES_FOLDER = "libraries";
	
    private DAnalysisSelector originalDAnalysisSelector;

    /**
     * Default constructor.
     * 
     * @param originalDAnalysisSelector
     *            the original {@link DAnalysisSelector}
     * @param mainDAnalysis
     *            the main {@link DAnalysis} the {@link DAnalysis} of the root
     *            local session resource
     */
    public CreateTablesAndTreesLocallyDAnalysisSelector(DAnalysisSelector originalDAnalysisSelector) {
        this.originalDAnalysisSelector = originalDAnalysisSelector;
    }

    /**
     * Overridden to delegate {@link DAnalysis} selection to the original
     * {@link DAnalysisSelector}.
     * 
     * {@inheritDoc}
     */
    public DAnalysis selectSmartlyAnalysisForAddedResource(Resource resource, Collection<DAnalysis> allAnalysis) {
        return originalDAnalysisSelector.selectSmartlyAnalysisForAddedResource(resource, allAnalysis);
    }

    /**
     * Overridden to restrict {@link DAnalysis} selection for
     * {@link DRepresentation} creation only on remote {@link DAnalysis} if
     * {@link CDOViewpointPreferenceKeys#PREF_ENABLE_LOCAL_REPRESENTATION_CREATION}
     * preference is at false.
     * 
     * {@inheritDoc}
     */
    public DAnalysis selectSmartlyAnalysisForAddedRepresentation(DRepresentation createdDRepresentation, Collection<DAnalysis> allDAnalysis) {
    	
    	Collection<DAnalysis> filteredAnalysis = getNonLibraryDAnalyses(allDAnalysis);
    	
        // Tables and trees are created locally
    	if (createdDRepresentation instanceof DTable || createdDRepresentation instanceof DTree) {
    		Collection<DAnalysis> localDAnalysis = getAllLocalDAnalyses(filteredAnalysis);
    		return selectAnalysis(createdDRepresentation, localDAnalysis);
    	} else {
    		// other representations are created as before
    		return selectAnalysis(createdDRepresentation, filteredAnalysis);
    	}
    }
    
    private DAnalysis selectAnalysis(DRepresentation createdDRepresentation, Collection<DAnalysis> availableAnalysis) {
    	if (availableAnalysis.size() == 1) {
            return availableAnalysis.iterator().next();
        } else {
        	return originalDAnalysisSelector.selectSmartlyAnalysisForAddedRepresentation(createdDRepresentation, availableAnalysis);
        }
    }
    
    /**
     * Filter analyses to keep only local ones
     * @param allAnalyses
     * @return
     */
    private Collection<DAnalysis> getAllLocalDAnalyses(Collection<DAnalysis> allAnalyses) {
    	Collection<DAnalysis> localAnalyses = new ArrayList<DAnalysis>();
    	for (DAnalysis dAnalysis : allAnalyses) {
            if (!CDOProtocolConstants.PROTOCOL_NAME.equals(dAnalysis.eResource().getURI().scheme())) {
            	localAnalyses.add(dAnalysis);
            }
    	}
    	return localAnalyses;
    }
    
    /**
     * Filter analyses to keep only those which are not contained in a library project
     * @param allAnalyses
     * @return
     */
    private Collection<DAnalysis> getNonLibraryDAnalyses(Collection<DAnalysis> allAnalyses) {
    	Collection<DAnalysis> result = new ArrayList<DAnalysis>();
    	for (DAnalysis dAnalysis : allAnalyses) {
            URI uri = dAnalysis.eResource().getURI();
			if (CDOProtocolConstants.PROTOCOL_NAME.equals(uri.scheme())) {
				// CDO URI, we have to check if the second segment is not the libraries folder
				if (uri.segmentCount() < 2 || !LIBRARIES_FOLDER.equals(uri.segment(1))) {					
					result.add(dAnalysis);
				}
            } else if (uri.isPlatform()){
            	// We have to check the third segment here, because first segment is either 'resource' or 'plugin'
            	if (uri.segmentCount() < 3 || !LIBRARIES_FOLDER.equals(uri.segment(2))) {					
					result.add(dAnalysis);
				}
            }
    	}
    	return result;
    }
    

}
    
