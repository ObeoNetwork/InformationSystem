package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.services;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;


public class SearchService {

	public static String widgetSuffix (Widget reference, EObject root) {
		
		TreeIterator<EObject> iterator = root.eAllContents();
		boolean found = false;
		int count = 0;
		while (iterator.hasNext() && !found) {
			Object o = iterator.next();
			if (o instanceof Widget) {
				Widget widget = (Widget) o;
				if (widget != reference) {
					if (widget.getName().equals(reference.getName())){
						count ++;
					}
				} else {
					found = true;
				}
			}
		}
		String result = "";
		
		String name = reference.getName();
		if (name == null || name.trim().length() == 0) {
			result += result+"unnamed";
		}
		if (count > 0) {
			result += String.valueOf(count);
		}
		return result;
	}
	
	public static String actionSuffix (ActionState reference, EObject root) {
		
		TreeIterator<EObject> iterator = root.eAllContents();
		boolean found = false;
		int count = 0;
		while (iterator.hasNext() && !found) {
			Object o = iterator.next();
			if (o instanceof ActionState) {
				ActionState action = (ActionState) o;
				if (action != reference) {
					if (action.getName().equals(reference.getName())){
						count ++;
					}
				} else {
					found = true;
				}
			}
		}
		String result = "";
		
		String name = reference.getName();
		if (name == null || name.trim().length() == 0) {
			result += result+"unnamed";
		}
		if (count > 0) {
			result += String.valueOf(count);
		}
		return result;
	}
}
