/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction.design.ui.extension.actions;

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
import org.obeonetwork.dsl.interaction.Interaction;

import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;

public class DeleteInteractionHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Interaction interaction = extractInteraction(event);
		if (interaction == null) {
			return null;
		}
		boolean confirm = MessageDialog.openConfirm(HandlerUtil.getActiveShell(event), "Delete interaction", "Delete the selected interaction ?");
		if (confirm) {
			final Session session = SessionManager.INSTANCE.getSession(interaction);
			final ModelAccessor modelAccessor = session.getModelAccessor();
			final ECrossReferenceAdapter semanticCrossReferencer = session.getSemanticCrossReferencer();
			
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			transactionalEditingDomain.getCommandStack().execute(new RecordingCommand(transactionalEditingDomain) {
				@Override
				protected void doExecute() {
					// Retrieve associated representations
					Collection<DRepresentationDescriptor> representationDescriptors = DialectManager.INSTANCE.getRepresentationDescriptors(interaction, session);
					// Delete representations
					for (DRepresentationDescriptor representationDescriptor : representationDescriptors) {
						closeEditor(session, representationDescriptor.getRepresentation());
						DialectManager.INSTANCE.deleteRepresentation(representationDescriptor, session);
					}
					// Delete interaction
					modelAccessor.eDelete(interaction, semanticCrossReferencer);
				}
			});
		}
		return null;
	}
	
	private Interaction extractInteraction(ExecutionEvent event) {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection)currentSelection).getFirstElement();
			if (selectedObject instanceof Interaction) {
				return (Interaction)selectedObject;
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
