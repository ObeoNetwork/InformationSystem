package org.obeonetwork.dsl.statemachine.design.ui.extension.actions;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.statemachine.StateMachine;

import fr.obeo.dsl.viewpoint.DRepresentation;
import fr.obeo.dsl.viewpoint.business.api.dialect.DialectManager;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectEditor;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIManager;
import fr.obeo.dsl.viewpoint.ui.business.api.session.IEditingSession;
import fr.obeo.dsl.viewpoint.ui.business.api.session.SessionUIManager;
import fr.obeo.mda.ecore.extender.business.api.accessor.ModelAccessor;

public class DeleteStateMachineHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final StateMachine stateMachine = extractStateMachine(event);
		if (stateMachine == null) {
			return null;
		}
		boolean confirm = MessageDialog.openConfirm(HandlerUtil.getActiveShell(event), "Delete State Machine", "Delete the selected state machine ?");
		if (confirm) {
			final Session session = SessionManager.INSTANCE.getSession(stateMachine);
			final ModelAccessor modelAccessor = session.getModelAccessor();
			final ECrossReferenceAdapter semanticCrossReferencer = session.getSemanticCrossReferencer();
			
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			transactionalEditingDomain.getCommandStack().execute(new RecordingCommand(transactionalEditingDomain) {
				@Override
				protected void doExecute() {
					// Retrieve associated representations
					Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(stateMachine, session);
					// Delete representations
					for (DRepresentation representation : representations) {
						closeEditor(session, representation);
						DialectManager.INSTANCE.deleteRepresentation(representation, session);
					}
					// Delete StateMachine
					modelAccessor.eDelete(stateMachine, semanticCrossReferencer);
				}
			});
		}
		return null;
	}
	
	private StateMachine extractStateMachine(ExecutionEvent event) {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection)currentSelection).getFirstElement();
			if (selectedObject instanceof StateMachine) {
				return (StateMachine)selectedObject;
			}
		}
		return null;
	}
	
	
	private void closeEditor(Session session, DRepresentation representation) {
		IEditingSession editingSession = SessionUIManager.INSTANCE.getUISession(session);
        if (editingSession != null) {
            DialectEditor editor = editingSession.getEditor(representation);
            if (editor != null) {
                DialectUIManager.INSTANCE.closeEditor(editor, false);
                editingSession.detachEditor(editor);
            }
        }
		return;
	}

}
