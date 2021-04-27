package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.services.flows.FlowsUtil;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class FlowstateEventContentProvider implements ITreeContentProvider {

	@Override
	public boolean hasChildren(Object element) {
		return (element instanceof Flow || element instanceof AbstractViewElement);				
	}
	
	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object[] getElements(Object root) {
		ArrayList<Object> elements = new ArrayList<Object>();
		
		if (root instanceof Transition) {
			elements.add(((Transition) root).eContainer());
			CinematicRoot cinematicRoot = FlowsUtil.getCinematicRoot((EObject) root);
			elements.addAll(FlowsUtil.getAllPackagesFromRoot(cinematicRoot).stream()
				.flatMap(abstractPackage -> abstractPackage.getViewContainers().stream())
				.collect(Collectors.toList()));
		}
		
		return elements.toArray();
		
	}
	
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Flow) {
			return ((Flow) parentElement).getEvents().toArray();
		}
		
		if (parentElement instanceof AbstractViewElement) {
			Collection<Object> objects = new ArrayList<>();
			Collection<WidgetEventType> possibleWidgetEvents = ((AbstractViewElement) parentElement).getWidget().getPossibleEvents();
			
			objects.addAll(possibleWidgetEvents.stream()
				.map(possibleEvent -> {
						return new AbstractMap.SimpleEntry<>(parentElement, possibleEvent);
					})
				.collect(Collectors.toList()));			
			
			if (parentElement instanceof ViewContainer) {
				objects.addAll(((ViewContainer) parentElement).getViewElements());
			}
			
			return objects.toArray();
		}
		
		return null;
	}

}
