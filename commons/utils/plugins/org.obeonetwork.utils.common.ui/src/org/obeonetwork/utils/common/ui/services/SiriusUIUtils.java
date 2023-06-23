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
package org.obeonetwork.utils.common.ui.services;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.internal.session.danalysis.SaveSessionJob;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.diagram.tools.api.DiagramPlugin;
import org.eclipse.sirius.diagram.ui.part.ValidateAction;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.obeonetwork.utils.common.SessionUtils;
import org.obeonetwork.utils.common.StringUtils;

@SuppressWarnings("restriction")
public class SiriusUIUtils {

    public static void validateDDiagramEditor(DDiagramEditor dDiagramEditor) {
    	
        if (dDiagramEditor instanceof IDiagramWorkbenchPart) {
            final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) dDiagramEditor;
            if(part.getDiagramEditPart() != null) {
                try {
                    new WorkspaceModifyDelegatingOperation(new IRunnableWithProgress() {

                        @Override
                        public void run(IProgressMonitor monitor) throws InterruptedException, InvocationTargetException {
                            ValidateAction.runValidation(part.getDiagramEditPart(), part.getDiagram());
                        }
                    }).run(new NullProgressMonitor());
                } catch (Exception e) {
                    DiagramPlugin.getDefault().logError(org.eclipse.sirius.diagram.ui.provider.Messages.ValidateAction_failureMessage, e);
                }
            }
        }
    }
	
	public static void activateViewpoint(Session session, URI viewpointURI, IProgressMonitor monitor) {
		if (session != null) {
			Viewpoint viewpoint = ViewpointRegistry.getInstance().getViewpoint(viewpointURI);
			if (viewpoint != null) {
				session.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
					@Override
					protected void doExecute() {
						final ViewpointSelectionCallback selection = new ViewpointSelectionCallback();
						selection.selectViewpoint(viewpoint, session, monitor);
					}
				});
			}
		}
	}
	
	public static DRepresentation createRepresentation(Session session, RepresentationDescription description, String name, EObject context, IProgressMonitor monitor) {
		// Ensure that there is no save in progress.
		// Otherwise when the representation is added to the resource CreateRepresentationCommand can be problematic.
		// Indeed, during the save the eSetDeliver is disabled at some point (ResourceSaveDiagnose.hasDifferentSerialization),
		// preventing any adapter to be added to the new representation.
		try {
			Job.getJobManager().join(SaveSessionJob.FAMILY, new NullProgressMonitor());
		} catch (OperationCanceledException | InterruptedException e) {
			// Ignore. The join is just here to avoid to have a save in progress.
		}
		
		CreateRepresentationCommand cmd = new CreateRepresentationCommand(session, description, context, name, monitor);
		session.getTransactionalEditingDomain().getCommandStack().execute(cmd);
		return cmd.getCreatedRepresentation();
	}
	
	public static DRepresentation createRepresentation(Session session, EObject context, String representationDescriptionId, IProgressMonitor monitor) {
		
		RepresentationDescription representationDescription = SessionUtils.getRepresentationDescription(session, context, representationDescriptionId);
		String title = null;
		String titleExpression = representationDescription.getTitleExpression();
		if(!StringUtils.isNullOrWhite(titleExpression)) {
			try {
				title = session.getInterpreter().evaluateString(context, titleExpression);
			} catch (EvaluationException e) {
				// Nop
			}
		}
		if(title == null) {
			title = representationDescription.getLabel();
		}
		
		return createRepresentation(session, representationDescription, title, context, monitor);
	}
	
}
