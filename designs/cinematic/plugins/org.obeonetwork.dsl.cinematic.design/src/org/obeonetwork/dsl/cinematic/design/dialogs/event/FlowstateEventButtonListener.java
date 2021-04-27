package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import java.util.Collection;
import java.util.Map;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.obeonetwork.dsl.cinematic.design.services.view.ViewUtil;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
public class FlowstateEventButtonListener implements Listener {
	
	private Transition transition;
	private Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidgetMap;
	private Collection<FlowEvent> flowEventsCollection;
	
	
	public FlowstateEventButtonListener(Transition transition,
			Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidgetMap,
			Collection<FlowEvent> flowEventsCollection) {
		this.transition = transition;
		this.viewElementWidgetMap = viewElementWidgetMap;
		this.flowEventsCollection = flowEventsCollection;
	}


	@Override
	public void handleEvent(Event event) {
		transition.getOn().clear();			
		transition.getOn().addAll(flowEventsCollection);			
		viewElementWidgetMap.forEach((abstractViewElement,widgetEventTypes) -> {
			widgetEventTypes.forEach(type -> {
				transition.getOn().add(ViewUtil.getOrCreateViewEvent(abstractViewElement, type));
			});
		});		
	}


}
