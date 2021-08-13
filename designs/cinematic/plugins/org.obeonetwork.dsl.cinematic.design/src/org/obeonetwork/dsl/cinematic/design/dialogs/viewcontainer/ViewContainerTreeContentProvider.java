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
package org.obeonetwork.dsl.cinematic.design.dialogs.viewcontainer;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.design.services.flows.FlowsUtil;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class ViewContainerTreeContentProvider implements ITreeContentProvider {
	
	private boolean hideContainersBoundToOtherViewStates;
	private ViewState viewState;
	
	public ViewContainerTreeContentProvider(ViewState viewState) {
		hideContainersBoundToOtherViewStates = false;
		this.viewState = viewState; 
	}

	@Override
	public Object[] getElements(Object inputElement) {
		Collection<ViewContainer> viewContainerCollection;
		
		if (inputElement instanceof AbstractPackage) {
				
			// we fetch all the viewContainers from the model
			viewContainerCollection = FlowsUtil.getAllPackagesFromRoot((AbstractPackage) inputElement)
					.stream()
					.map(abstractPackage -> abstractPackage.getViewContainers())				
					.flatMap(Collection::stream).collect(Collectors.toList());
			
			if (hideContainersBoundToOtherViewStates) {
				// do not return viewContainers related to an other ViewState than the current one.
				
				viewContainerCollection.removeIf(vc -> {					
					return new EObjectQuery(vc).getInverseReferences(FlowPackage.eINSTANCE.getViewState_ViewContainers()) // find all view states linked to view containers
							.stream()  // we are going to remove all viewContainers referenced by these viewStates
							.anyMatch(eObject -> eObject != viewState); // thus we remove when the references come from a different viewstate than the current one.							
				});			
			}
			
		} else {
			viewContainerCollection = Collections.emptyList();
		}
		
		return viewContainerCollection.toArray(); 
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ViewContainer) {
			return ((ViewContainer) parentElement).getViewContainers().toArray();
		} else {
			return null;	
		}
		
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof ViewContainer) {
			return ((ViewContainer) element).eContainer();
		} else {
			return null;	
		}
		
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ViewContainer) {
			return ! ((ViewContainer) element).getViewContainers().isEmpty();
		} else
			return false;
	}
	
	
	public void switchHideContainersBoundToOtherViewStates() {
		this.hideContainersBoundToOtherViewStates = !hideContainersBoundToOtherViewStates;
	}
}
