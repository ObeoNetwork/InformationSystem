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
package org.obeonetwork.dsl.cinematic.design.services.label;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.sirius.diagram.ui.tools.api.command.GMFCommandWrapper;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.cinematic.flow.Transition;

/**
 * Direct edit policy for the guard label on transitions.
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a> 
 *
 */
public class TransitionGuardEditLabel extends LabelDirectEditPolicy {

	@Override
	protected org.eclipse.gef.commands.Command getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest edit) {
		
		final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)getHost()).resolveSemanticElement();
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
		
		RecordingCommand cmd = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				String newGuard = (String) edit.getCellEditor().getValue(); 

				if (element instanceof DSemanticDecorator && ((DSemanticDecorator) element).getTarget() instanceof Transition) {
					Transition transition = (Transition) ((DSemanticDecorator) element).getTarget();								
					transition.setGuard(newGuard.trim());					
				}
			}
		};
		
		return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

	}; 
}
