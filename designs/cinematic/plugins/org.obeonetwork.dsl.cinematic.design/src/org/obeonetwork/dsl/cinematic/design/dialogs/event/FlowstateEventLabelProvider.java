package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import java.util.AbstractMap;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;


/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class FlowstateEventLabelProvider extends LabelProvider {
	private AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new  ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	@Override
	public Image getImage(Object element) {
		if (element instanceof AbstractMap.SimpleEntry) {
			element = ((AbstractMap.SimpleEntry<?,?>) element).getValue();
		}
		
		return labelProvider.getImage(element);
	
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Flow) {
			return "Flow Events";
		}
		
		if (element instanceof NamedElement) {
			return ((NamedElement) element).getName();
		}
		
		if (element instanceof AbstractMap.SimpleEntry) {
			if (((AbstractMap.SimpleEntry<?, ?>) element).getValue() instanceof WidgetEventType) {				
				return ((WidgetEventType) ((AbstractMap.SimpleEntry<?, ?>) element).getValue()).getName();
			}
		}
		
		return super.getText(element);
	}
}
