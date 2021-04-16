package org.obeonetwork.dsl.cinematic.design.services.flows.providers;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.design.services.flows.FlowsUtil;
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
			Stream<ViewContainer> viewContainerStream = FlowsUtil.getAllPackagesFromRoot((AbstractPackage) inputElement)
				.stream()
				.map(abstractPackage -> abstractPackage.getViewContainers())				
				.flatMap(Collection::stream); 					
				
			viewContainerCollection = viewContainerStream.collect(Collectors.toList());
			
			if (hideContainersBoundToOtherViewStates) {
				// do not return viewContainers related to an other ViewState than the current one.
				// FIXME @VRI: is there a way to do eOpposite() on the viewContainer instead, to easily remove the elements ?
				
				Collection<ViewState> collectionViewStates = FlowsUtil.getAllViewStateInPackage((AbstractPackage)inputElement);
				collectionViewStates.remove(viewState);			
				viewContainerCollection.removeAll(collectionViewStates.stream().flatMap(vs -> vs.getViewContainers().stream()).collect(Collectors.toList()));
			}
			
		} else {
			viewContainerCollection = Collections.emptyList();
		}
		
		if (hideContainersBoundToOtherViewStates) {
			
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
