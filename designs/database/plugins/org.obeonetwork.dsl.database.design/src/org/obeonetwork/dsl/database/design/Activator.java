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
package org.obeonetwork.dsl.database.design;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.triggers.DeleteColumnChangeTrigger;
import org.obeonetwork.dsl.database.triggers.ViewQueryChangeTrigger;
import org.obeonetwork.dsl.environment.design.services.RepresentationCreationPolicyRegistry;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.database.design";

	// The shared instance
	private static Activator plugin;

	private static Set<Viewpoint> viewpoints; 

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		viewpoints = new HashSet<Viewpoint>();
		viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/description/database.odesign"));
		
		// Add a trigger on Query modification
		SessionManager.INSTANCE.addSessionsListener(
				new SessionManagerListener.Stub() {
					@Override
					public void notifyAddSession(Session newSession) {
						newSession.getEventBroker().addLocalTrigger(NotificationFilter.NOT_TOUCH, new ViewQueryChangeTrigger());
						newSession.getEventBroker().addLocalTrigger(DeleteColumnChangeTrigger.IS_DELETE_COLUMN, new DeleteColumnChangeTrigger());
						
					}
				});
		
		// Register the policies to disable the creation of Statemachine and Interaction on Database elements
		RepresentationCreationPolicyRegistry.registerStatemachineCreationPolicy(e -> e.eClass().getEPackage() != DatabasePackage.eINSTANCE);
		RepresentationCreationPolicyRegistry.registerInteractionCreationPolicy(e -> e.eClass().getEPackage() != DatabasePackage.eINSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (viewpoints != null) {
			for (final Viewpoint viewpoint: viewpoints) {
				ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
			}
			viewpoints.clear();
			viewpoints = null; 
		}
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
}

