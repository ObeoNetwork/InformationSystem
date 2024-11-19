package org.obeonetwork.dsl.cinematic.design.extension;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.util.ViewSwitch;

public class ViewContainerLabelsSwitch extends ViewSwitch<String> {

	private static final String TYPE_NAME_PATTERN = "%1s : %2s";

	public String getLabel(EObject eObject) {
		return doSwitch(eObject);
	}

	@Override
	public String caseViewContainer(ViewContainer object) {
		String typePattern = TYPE_NAME_PATTERN;
		return String.format(typePattern, object.getName(), object.eClass().getName());
	}

	@Override
	public String caseViewElement(ViewElement object) {
		String label = object.getName();
		if (object.getWidget() != null && object.getWidget().getName() != null) {
			label += " : " + object.getWidget().getName();
		}
		return label;
	}

	@Override
	public String defaultCase(EObject object) {
		return "";
	}
}
