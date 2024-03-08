package org.obeonetwork.graal.design.ui.view.explorer.system;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Obeo
 *
 */
public class SystemTreeContentLabelProvider extends BaseLabelProvider implements ILabelProvider {
	private final AdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	private final AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			adapterFactory);

	@Override
	public Image getImage(final Object element) {
		return adapterFactoryLabelProvider.getImage(element);
	}

	@Override
	public String getText(final Object element) {
		return adapterFactoryLabelProvider.getText(element);
	}

}
