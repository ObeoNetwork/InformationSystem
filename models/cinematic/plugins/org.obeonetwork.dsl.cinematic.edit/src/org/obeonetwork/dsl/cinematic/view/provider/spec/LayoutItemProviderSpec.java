package org.obeonetwork.dsl.cinematic.view.provider.spec;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.provider.LayoutItemProvider;

public class LayoutItemProviderSpec extends LayoutItemProvider {

	public LayoutItemProviderSpec(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		Layout layout = (Layout)object;
		String viewElementName = "Virtual";
		if(layout.getViewElement() != null) {
			viewElementName = layout.getViewElement().getName();
		}
		return getString("_UI_Layout_type") + " " + viewElementName + " (" + layout.getX() + ", " + layout.getY() + ")";
	}

	
}
