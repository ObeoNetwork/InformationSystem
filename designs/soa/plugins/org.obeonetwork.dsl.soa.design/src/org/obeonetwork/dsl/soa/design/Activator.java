/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.design;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.obeonetwork.dsl.soa.design.triggers.CreateOrRemoveInputParameterChangeTrigger;
import org.obeonetwork.dsl.soa.design.triggers.OperationRestExpositionChangeTrigger;
import org.obeonetwork.dsl.soa.design.triggers.RemoveSecuritySchemeChangeTrigger;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
    // The plug-in ID
    public static final String PLUGIN_ID = "org.obeonetwork.dsl.soa.design";

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
	  viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/description/soa.odesign")); 
	  
		// Add the Sirius session triggers ensuring the semantic model consistency
		SessionManager.INSTANCE.addSessionsListener(
				new SessionManagerListener.Stub() {
					@Override
					public void notifyAddSession(Session newSession) {
						// Manage the soa::ParameterRestData lifecycle regarding creation and removal of input parameters
						newSession.getEventBroker().addLocalTrigger(
								CreateOrRemoveInputParameterChangeTrigger.IS_CREATE_OR_REMOVE_INPUT_PARAMETER, 
								new CreateOrRemoveInputParameterChangeTrigger());
						
						// Manage the soa::ParameterRestData lifecycle regarding operation exposition change 
						newSession.getEventBroker().addLocalTrigger(
								OperationRestExpositionChangeTrigger.IS_OPERATION_REST_EXPOSITION_CHANGE, 
								new OperationRestExpositionChangeTrigger());
						
						// Manage the soa::SecurityApplication lifecycle regarding removal of SecuritySchemes
						newSession.getTransactionalEditingDomain().addResourceSetListener(new RemoveSecuritySchemeChangeTrigger());
					}
				});
		
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
