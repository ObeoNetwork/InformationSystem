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

public class TransitionGuardEditLabel extends LabelDirectEditPolicy {

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
