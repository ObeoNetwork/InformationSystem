package org.obeonetwork.dsl.cinematic.design.services.flows.dialog.viewcontainer;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a> 
 */
public class ViewContainerLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) { 
		return null;
	}

	@Override
	public String getText(Object element) {
		return ((ViewContainer) element).getName(); 		
	}
	
	

}
