package org.obeonetwork.dsl.cinematic.design.services;

import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.utils.common.StringUtils;

public class CinematicVCDLabelServices {

	public static String getVCDLabel(ViewElement viewElement) {
		
		if(!StringUtils.isNullOrWhite(viewElement.getExample())) {
			return viewElement.getExample();
		}
		
		if(!StringUtils.isNullOrWhite(viewElement.getLabel())) {
			return viewElement.getLabel();
		}
		
		if(!StringUtils.isNullOrWhite(viewElement.getName())) {
			return viewElement.getName();
		}
		
		return StringUtils.EMPTY_STRING;
		
	}
	
	public static String getVCDLabel(ViewContainer viewContainer) {
		
		if(!StringUtils.isNullOrWhite(viewContainer.getLabel())) {
			return viewContainer.getLabel();
		}
		
		if(!StringUtils.isNullOrWhite(viewContainer.getName())) {
			return viewContainer.getName();
		}
		
		return StringUtils.EMPTY_STRING;
	}
	
	public static String getVCDLabel(ViewContainerReference viewContainerReference) {
		
		if(!StringUtils.isNullOrWhite(viewContainerReference.getLabel())) {
			return viewContainerReference.getLabel();
		}
		
		if(!StringUtils.isNullOrWhite(viewContainerReference.getName())) {
			return viewContainerReference.getName();
		}
		
		return getVCDLabel(viewContainerReference.getViewContainer());
	}
		
}
