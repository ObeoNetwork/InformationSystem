/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.ui.decoration;

import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.obeonetwork.graal.GraalObject;

import org.eclipse.sirius.diagram.ui.edit.api.part.IAbstractDiagramNodeEditPart;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramEdgeEditPart;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;

/**
 * Graphical decorators provider to display User story information
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class UserStoryDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateDecoratorsOperation) {
			final IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation)operation).getDecoratorTarget();
			return shouldDecorate(decoratorTarget);
		}
		return false;
	}
	
	/**
	 * Checks if the specified targetshould be decorated
	 * @param decoratorTarget	
	 * @return true if the target should be decorated
	 */
	public static boolean shouldDecorate(IDecoratorTarget decoratorTarget) {
		IDiagramElementEditPart diagramEditPart = getDecoratorTargetEditPart(decoratorTarget);
		
		if (isNodeOrContainerEditPart(diagramEditPart)
			|| isEdgeEditPart(diagramEditPart)){
			
			if (diagramEditPart.resolveTargetSemanticElement() instanceof GraalObject) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Creates the decorators for the specified target
	 * @param decoratorTarget
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		if (shouldDecorate(decoratorTarget)) {
			IDiagramElementEditPart editPart = getDecoratorTargetEditPart(decoratorTarget);
			if (isNodeOrContainerEditPart(editPart)) {
				decoratorTarget.installDecorator("USER-STORY-NODE-MARKER", new UserStoryNodeDecorator(decoratorTarget));
			}
			if (isEdgeEditPart(editPart)) {
				decoratorTarget.installDecorator("USER-STORY-EDGE-MARKER", new UserStoryEdgeDecorator(decoratorTarget));
			}
		}
	}
	
	/**
	 * Gets the diagram element edit part from the target
	 * @param decoratorTarget
	 * @return the DiagramElementEditPart instance
	 */
	private static IDiagramElementEditPart getDecoratorTargetEditPart(IDecoratorTarget decoratorTarget) {
		return (IDiagramElementEditPart)decoratorTarget.getAdapter(IDiagramElementEditPart.class);
	}

	/**
	 * Checks if the edit part corresponds to an edge
	 * @param diagramEditPart
	 * @return true if it corresponds to an edge
	 */
	private static boolean isEdgeEditPart(IDiagramElementEditPart diagramEditPart) {
		return diagramEditPart instanceof IDiagramEdgeEditPart;
	}
	
	/**
	 * Checks if the edit part corresponds to a node or a container
	 * @param diagramEditPart
	 * @return true if it corresponds to a node or a container
	 */
	private static boolean isNodeOrContainerEditPart(IDiagramElementEditPart diagramEditPart) {
		return diagramEditPart instanceof IAbstractDiagramNodeEditPart;
	}

}
