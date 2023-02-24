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
package org.obeonetwork.dsl.cinematic.design.services.label;

import java.net.URL;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.design.services.flows.FlowsUtil;
import org.obeonetwork.dsl.cinematic.design.services.ui.UiUtil;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.util.FlowSwitch;
import org.obeonetwork.dsl.cinematic.provider.CinematicEditPlugin;


public class FlowEditLabelSwitch extends FlowSwitch<EObject> implements EditLabelSwitch {
	private String newLabel;
	
	public EObject editLabel(EObject eObject, String newLabel) {
		this.newLabel = newLabel;
		doSwitch(eObject);
		return eObject;
	}

	@Override
	public EObject caseNamedElement(NamedElement namedElement) {
		namedElement.setName(newLabel);
		return namedElement;
	}
	
	@Override
	public EObject caseSubflowState(SubflowState subflowState) {
		String flowName = newLabel.trim();
		// Check if the name has changed
		if (flowName != null && subflowState.getSubflow() != null && subflowState.getSubflow().getName() != null) {
			if (flowName.equalsIgnoreCase(subflowState.getSubflow().getName().trim())) {
				// Nothing to do
				return subflowState;
			}
		}
		
		List<Flow> foundFlows = FlowsUtil.getFlowsWithName(subflowState, flowName);
		if (foundFlows.isEmpty()) {
			// No flow found, let's notify the user
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
										"Unable to find flow",
										"No found flow with this name");
		} else if (foundFlows.size() == 1) {
			subflowState.setSubflow(foundFlows.get(0));
		} else {
			// Several flows with the same name, we let the user choose the correct one		
			Object result = UiUtil.getUserChoiceWithinList(
								"Select a flow",
								"Select a flow among the flows with the specified name",
								foundFlows.toArray(),
								new LabelProvider() {
									
									@Override
									public Image getImage(Object element) {
										URL imageURL = null;
										if (element instanceof Flow) {
											imageURL = (URL)CinematicEditPlugin.INSTANCE.getImage("full/obj16/Flow");
										}
										if (imageURL != null) {
											ImageDescriptor imgDesc = ImageDescriptor.createFromURL(imageURL);
											if (imgDesc != null) {
												return imgDesc.createImage();
											}
										}
										return null;
									}
			
									@Override
									public String getText(Object element) {
										String label = "";
										if (element instanceof Flow) {
											Flow flow = (Flow) element;
											label = getLabel(flow);
										}
										return label;
									}
									
									private String getLabel(EObject eObject) {
										String label = ""; 
										if (eObject.eContainer() != null) {
											String parentLabel = getLabel(eObject.eContainer());
											if (parentLabel != null) {
												label = parentLabel + "::";
											}
										}
										if (eObject instanceof NamedElement) {
											label += ((NamedElement)eObject).getName();
										}
										 
										return label;
									}
								});
			if (result instanceof Flow) {
				subflowState.setSubflow((Flow)result);
			}
		}
		return subflowState;
	}
	
}
