package org.obeonetwork.dsl.cinematic.design.dialogs.viewcontainer;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a> 
 */
public class ViewContainerLabelProvider extends LabelProvider {
	private AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new  ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	@Override
	public Image getImage(Object element) { 
		return labelProvider.getImage(element);
	}

	@Override
	public String getText(Object element) {
		return ((ViewContainer) element).getName(); 		
	}
	
	

}
