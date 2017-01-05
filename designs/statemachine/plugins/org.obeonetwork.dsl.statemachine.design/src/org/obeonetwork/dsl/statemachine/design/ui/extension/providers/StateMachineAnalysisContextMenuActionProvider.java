/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.statemachine.design.ui.extension.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.statemachine.StateMachine;
import org.obeonetwork.dsl.statemachine.design.ui.extension.actions.CreateStateMachineDiagramAction;
import org.obeonetwork.dsl.statemachine.design.ui.extension.actions.NewStateMachineDiagramMenuAction;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.extension.IContextMenuActionProvider;

public class StateMachineAnalysisContextMenuActionProvider implements IContextMenuActionProvider {
	
	public Iterable<IAction> getContextMenuActions(ISelection selection) {
		List<IAction> actions = new ArrayList<IAction>();
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object selectedObject = structuredSelection.getFirstElement();
				if ((selectedObject instanceof ObeoDSMObject)
						&& !(selectedObject instanceof StateMachine)) {
					// Let's check if the "StateMachine" viewpoint is selected
					Session session = SessionManager.INSTANCE.getSession((ObeoDSMObject)selectedObject);
					if (session != null) {
						for (Viewpoint viewpoint : session.getSelectedViewpoints(false)) {
							if (isStateMachineViewpoint(viewpoint)) {
								IAction action = computeAction((ObeoDSMObject)selectedObject);
								if (action != null) {
									actions.add(action);
								}
								break;
							}
						}
					}
				}
			}
		}
		return actions;
	}
	
	
	
	public Iterable<IContributionItem> getContextualMenuContributionItems(ISelection selection) {
		return Collections.emptyList();
	}



	private IAction computeAction(ObeoDSMObject context) {
		// Try to get the "New ..." menu item provided by Viewpoint
		MenuManager menuManager = getModelContentMenuManager();
		if (menuManager != null) {
			// Reuse existing menu
			for (IContributionItem item : menuManager.getItems()) {
				if (item instanceof MenuManager) {
					MenuManager menuMgr = (MenuManager)item;
					if ("New ...".equals(menuMgr.getMenuText())) {
						// Add our action to the menu
						menuMgr.add(new CreateStateMachineDiagramAction(context));
						return null;
					}
				}
			}
		}
		// No "New ..." Menu provided by Viewpoint, let's add ours
		return new NewStateMachineDiagramMenuAction(context);
	}
	
	/**
	 * Retrieves the MenuManager for the Model Content view
	 * so we can provide our own action into the default Viewpoint menu
	 * @return
	 */
	private MenuManager getModelContentMenuManager() {
		// TODO Fix to retrieve existing "new representation" menu
		return null;
//		
//		IViewPart modelContentView = PlatformUI.getWorkbench()
//												.getActiveWorkbenchWindow()
//												.getActivePage()
//												.findView("fr.obeo.dsl.viewpoint.ui.tools.views.model.explorer");
////		.findView("fr.obeo.dsl.viewpoint.ui.tools.views.sessionview");
//		try {
//			Field f = DesignerSessionView.class.getDeclaredField("contextMenu");
//			f.setAccessible(true);
//			return (MenuManager)f.get(modelContentView);
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return null;
	}
	
	public static boolean isStateMachineViewpoint(Viewpoint viewpoint) {
		if (viewpoint == null || viewpoint.eResource() == null || viewpoint.eResource().getURI() == null) {
			return false;
		}
		return "platform:/plugin/org.obeonetwork.dsl.statemachine.design/description/statemachine.odesign".equals(viewpoint.eResource().getURI().toString())
				&& "State Machine".equals(viewpoint.getName());
	}
}
