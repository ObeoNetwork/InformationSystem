/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.requirement;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.tools.requirement.ui.decorators.ObjectWithRequirement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class RequirementLinkerPlugin extends EclipsePlugin {

	private static final String ICONS_EXTENSION = ".gif"; //$NON-NLS-1$
	private static final String ICONS_FOLDER = "icons/"; //$NON-NLS-1$

	public static final String LINK = "Link"; //$NON-NLS-1$
	public static final String EDIT = "Edit"; //$NON-NLS-1$

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.tools.requirement"; //$NON-NLS-1$

	// The shared instance
	private static RequirementLinkerPlugin plugin;

	private ImageRegistry registry;

	/**
	 * The constructor
	 */
	public RequirementLinkerPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		installAllDecoratorListeners();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RequirementLinkerPlugin getInstance() {
		return plugin;
	}

	/**
	 * Returns the Platform UI workbench.
	 * <p>
	 * This method exists as a convenience for plugin implementors. The
	 * workbench can also be accessed by invoking
	 * <code>PlatformUI.getWorkbench()</code>.
	 * </p>
	 * 
	 * @return IWorkbench the workbench for this plug-in
	 */
	public IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 *
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor(String imageID) {
		ImageRegistry registry = getImageRegistry();
		if (registry.get(imageID) == null) {
			Bundle bundle = Platform.getBundle(PLUGIN_ID);
			IPath path = new Path(ICONS_FOLDER + imageID + ICONS_EXTENSION);
			URL url = FileLocator.find(bundle, path, null);
			ImageDescriptor desc = ImageDescriptor.createFromURL(url);
			registry.put(imageID, desc);
		}
		return ImageDescriptor.createFromImage(registry.get(imageID));
	}
	
	private ImageRegistry getImageRegistry() {
		if (registry == null) {
			registry = new ImageRegistry();
		}
		return registry;
	}
	
	private void installDecoratorListenerOnSession(Session session) {
		TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
		if (ted != null) {
			NotificationFilter notificationFilter = NotificationFilter.createFeatureFilter(RequirementPackage.Literals.REQUIREMENT__REFERENCED_OBJECT);
			ted.addResourceSetListener(new ResourceSetListenerImpl(notificationFilter) {
				@Override
				public boolean isPostcommitOnly() {
					return true;
				}
				
				@Override
				public void resourceSetChanged(ResourceSetChangeEvent event) {
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						public void run() {
							IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
							decoratorManager.update(ObjectWithRequirement.DECORATOR_ID);
						}
					});
				}
				
			});
		}
	}

	/**
	 * Installs a Session listener to refresh decorators for objects with requirements on all sessions
	 */
	private void installAllDecoratorListeners() {
		// Install the listener to already opened sessions
		// it could happen depending on the plugin starting order
		for (Session session : SessionManager.INSTANCE.getSessions()) {
			installDecoratorListenerOnSession(session);
		}
		
		SessionManager.INSTANCE.addSessionsListener(new SessionManagerListener() {

			public void notifyAddSession(Session newSession) {
				installDecoratorListenerOnSession(newSession);
			}
			
			public void viewpointSelected(Viewpoint selectedSirius) {
				// Do nothing
			}
			
			public void viewpointDeselected(Viewpoint deselectedSirius) {
				// Do nothing				
			}
			
			public void notifyRemoveSession(Session removedSession) {
				// Do nothing
			}
			
			public void notify(Session updated, int notification) {
				// Do nothing
			}
		});
	}
}
