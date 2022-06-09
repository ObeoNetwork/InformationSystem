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
package org.obeonetwork.dsl.soa.gen.swagger.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.ui.wizards.SwaggerExportWizard;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

public class SwaggerExportHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		List<ObeoDSMObject> selectedElements = EventHelper.uwrapMultipleSelection(event, ObeoDSMObject.class);
		
		List<Component> components = new ArrayList<>();
		for(ObeoDSMObject selectedElement : selectedElements) {
			if(selectedElement instanceof Component) {
				components.add((Component) selectedElement);
			} else if(selectedElement instanceof System) {
				components.addAll(((System)selectedElement).getOwnedComponents());
			}
		}
		
		Shell shell = HandlerUtil.getActiveShell(event);
		WizardDialog dialog = new WizardDialog(shell, new SwaggerExportWizard(components));
		dialog.open();
		
		return null;
		
	}
}
