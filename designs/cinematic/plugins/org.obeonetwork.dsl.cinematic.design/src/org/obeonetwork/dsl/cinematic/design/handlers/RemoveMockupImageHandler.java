/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.handlers;

import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.WorkspaceImageDescription;
import org.eclipse.sirius.diagram.ui.business.api.image.WorkspaceImageHelper;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.sirius.viewpoint.BasicLabelStyle;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

public class RemoveMockupImageHandler  extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		for(IDiagramElementEditPart selectedDiagramElementEditPart : EventHelper.uwrapMultipleSelection(event, IDiagramElementEditPart.class)) {
			removeMockupImage(selectedDiagramElementEditPart);
		}
		
		return null;
	}

	private void removeMockupImage(IDiagramElementEditPart selectedDiagramElementEditPart) {
		DDiagramElement diagramElement = selectedDiagramElementEditPart.resolveDiagramElement();
		
		String workspacePath = null;
		if(diagramElement.getMapping() instanceof NodeMapping) {
			NodeMapping mapping = (NodeMapping) diagramElement.getMapping();
			if(mapping.getStyle() instanceof WorkspaceImageDescription) {
				WorkspaceImageDescription workspaceImageDescription = (WorkspaceImageDescription) mapping.getStyle();
				workspacePath = workspaceImageDescription.getWorkspacePath();
			}
		};
		
		if(!isNullOrWhite(workspacePath)) {
			WorkspaceImageHelper.INSTANCE.updateStyle((BasicLabelStyle) diagramElement.getStyle(), workspacePath);
		}
		// TODO Note for future devs. We can't supress the unset image here because we would loose track of the last index.
		// We probably need a cache of the created filenames, keeping in mind that it should manage multiple Sirius
		// sessions.
	}

}
