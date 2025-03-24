/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.ui.view.explorer.system;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.graal.design.Activator;

/**
 * @author Obeo
 *
 */
@SuppressWarnings("restriction")
public class SystemTreeContentLabelProvider extends BaseLabelProvider
		implements ILabelProvider, INotifyChangedListener {
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

	@Override
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof EObject) {
			if (hasSystemAncestor((EObject) notifier)) {
				refreshModelExplorer((EObject) notifier, notification);
			}
		}
	}

	public SystemTreeContentLabelProvider() {
		if (adapterFactory instanceof IChangeNotifier) {
			((IChangeNotifier) adapterFactory).addListener(this);
		}
	}

	private void refreshModelExplorer(EObject element, Notification notification) {
		try {
			ModelExplorerView mev = (ModelExplorerView) Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().findView("org.eclipse.sirius.ui.tools.views.model.explorer");//$NON-NLS-1$
			if (!notification.isTouch()) {
				boolean updateLabel = notification instanceof ViewerNotification
						? ((ViewerNotification) notification).isLabelUpdate()
						: true;
				mev.getCommonViewer().refresh(element, updateLabel);
			}

		} catch (NullPointerException npe) {
			// No refresh
		}
	}

	private static boolean hasSystemAncestor(EObject eObj) {
		return (eObj instanceof org.obeonetwork.graal.System) || (eObj != null && hasSystemAncestor(eObj.eContainer()));
	}

}
