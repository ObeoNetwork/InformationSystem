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
package org.obeonetwork.dsl.requirement.design;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.api.helper.decoration.DecorationHelper;
import org.eclipse.sirius.diagram.description.AdditionalLayer;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.ui.business.api.editor.ISiriusEditor;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.Decoration;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.tools.requirement.ui.decorators.ObjectWithRequirement;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	private static final String REQUIREMENTS_DECORATION_LAYER_NAME = "EObjectWithRequirement";
	private static final String REQUIREMENTS_DECORATION_NAME = "EObjectWithRequirement";

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.requirement.design";

	// The shared instance
	private static Activator plugin;

	private static Set<Viewpoint> viewpoints; 
 	
	// Cache value for decorator enablement
	private boolean requirementsDecoratorEnabled = ObjectWithRequirement.isDecoratorEnabled();
	
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		viewpoints = new HashSet<Viewpoint>();
		viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/description/requirement.odesign"));
				
		installAllDecoratorListeners();
	}

	/*
	 * (non-Javadoc)
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

	
	private void installDecoratorListenerOnSession(final Session session) {
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
							refreshDecorationsOnSession(session, false);
						}
					});
				}
				
			});
		}
	}
	
	private void refreshDecorationsOnAllSessions() {
		for (Session session : SessionManager.INSTANCE.getSessions()) {
			if (session.isOpen()) {
				refreshDecorationsOnSession(session, true);
			}
		}
	}
	
	private void refreshDecorationsOnSession(final Session session, boolean forceRefresh) {
		if (!forceRefresh) {
			// Fail fast the decoration is disabled
			if (!ObjectWithRequirement.isDecoratorEnabled()) {
				return;
			}
		}
		
		IEditingSession uiSession = SessionUIManager.INSTANCE.getUISession(session);
		// We look for open diagram editors to refresh the diagrams
		if (uiSession != null) {
			Collection<ISiriusEditor> editors = uiSession.getSiriusEditors();
			for (ISiriusEditor siriusEditor : editors) {
				if (siriusEditor instanceof DDiagramEditor) {
					DDiagramEditor diagramEditor = (DDiagramEditor)siriusEditor;
					DRepresentation representation = diagramEditor.getRepresentation();
					if (representation instanceof DSemanticDiagram) {
						DSemanticDiagram diagram = (DSemanticDiagram)representation;
						refreshDecorationsOnDiagram(diagram, session);
					}
				}
			}			
		}
	}
	
	private void refreshDecorationsOnDiagram(final DSemanticDiagram diagram, final Session session) {
		EList<AdditionalLayer> activatedTransientLayers = diagram.getActivatedTransientLayers();
		for (final AdditionalLayer additionalLayer : activatedTransientLayers) {
			// We want the "EObjectWithRequirement" layer
			if (REQUIREMENTS_DECORATION_LAYER_NAME.equals(additionalLayer.getName())) {
			
				TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
				ted.getCommandStack().execute(new RecordingCommand(ted) {
					
					@Override
					protected void doExecute() {
						// Due to a bug in Sirius we have to remove the existing decorations before calling the update method
						for (DDiagramElement diagElement : diagram.getDiagramElements()) {
							Iterator<Decoration> it = diagElement.getTransientDecorations().iterator();
							while (it.hasNext()) {
								Decoration decoration = it.next();
								if (REQUIREMENTS_DECORATION_NAME.equals(decoration.getDescription().getName())) {
									it.remove();
								}
							}
						}
						
						List<Layer> layersToRefresh = Arrays.asList((Layer)additionalLayer);
						new DecorationHelper(diagram).updateDecorations(layersToRefresh);
					}
				});
				
			}
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
		
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		decoratorManager.addListener(new ILabelProviderListener() {
			
			public void labelProviderChanged(LabelProviderChangedEvent event) {
				boolean decoratorEnabled = ObjectWithRequirement.isDecoratorEnabled();
				if (requirementsDecoratorEnabled != decoratorEnabled) {
					// Value changed, we have to refresh diagrams
					refreshDecorationsOnAllSessions();
					requirementsDecoratorEnabled = decoratorEnabled;
				}
			}
		});
	}
	
		
	
}