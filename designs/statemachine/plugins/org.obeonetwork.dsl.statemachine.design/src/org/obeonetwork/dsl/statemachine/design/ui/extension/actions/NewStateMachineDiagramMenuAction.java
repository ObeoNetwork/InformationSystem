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
package org.obeonetwork.dsl.statemachine.design.ui.extension.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

public class NewStateMachineDiagramMenuAction extends Action implements IMenuCreator {

	private Menu fMenu;
	private ObeoDSMObject context;
	
	public NewStateMachineDiagramMenuAction(ObeoDSMObject context) {
		setText("New state machine");
		setId("1");
		setMenuCreator(this);
		this.context = context;
	}
	
	public void dispose() {
		if (fMenu != null) {
			fMenu.dispose();
			fMenu = null;
		}
	}

	public Menu getMenu(Control parent) {
		return null;
	}

	public Menu getMenu(Menu parent) {
		if (fMenu != null) {
			fMenu.dispose();
		}
		fMenu = new Menu(parent);
		addActionToMenu(fMenu, new CreateStateMachineDiagramAction(context));

		return fMenu;
	}
	
	protected void addActionToMenu(Menu parent, Action action) {
		ActionContributionItem item= new ActionContributionItem(action);
		item.fill(parent, -1);
	}
}
