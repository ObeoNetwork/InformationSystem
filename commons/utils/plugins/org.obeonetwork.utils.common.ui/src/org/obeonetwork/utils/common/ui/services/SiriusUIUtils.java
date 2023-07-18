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
import java.util.HashMap;
import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.eef.core.api.EEFPage;
import org.eclipse.eef.ide.ui.properties.api.EEFTabDescriptor;
import org.eclipse.eef.properties.ui.api.EEFTabContents;
import org.eclipse.eef.properties.ui.api.EEFTabbedPropertySheetPage;
import org.eclipse.eef.properties.ui.api.IEEFTabDescriptor;
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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.eclipse.ui.views.properties.PropertySheet;
import org.obeonetwork.utils.common.IntrospectionUtils;
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
	
	/**
	 * Force a refresh of the Properties view if the page with the given name is active. Do nothing otherwise.
	 * 
	 * @param self an EObject
	 * @param pageName the name of the page to refresh
	 * @return self
	 */
	public EObject refreshPropertiesView(EObject self, String pageName) {
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IWorkbenchPart part = page.getActivePart();
		
		if(part instanceof PropertySheet) {
			PropertySheet sheet = (PropertySheet) part;
			if(sheet.getCurrentPage() instanceof EEFTabbedPropertySheetPage) {
				String eefTabDescriptorPrefix = String.format("%s Page%s", pageName, pageName);
				EEFTabbedPropertySheetPage currentPage = (EEFTabbedPropertySheetPage) sheet.getCurrentPage();
				// Warning: we use reflection here because we are limited by the EEF API.
				@SuppressWarnings("unchecked")
				HashMap<IEEFTabDescriptor, EEFTabContents> descriptorToTab = IntrospectionUtils.getFieldValue(currentPage, "descriptorToTab", HashMap.class);
	            Optional<EEFTabDescriptor> tabDescriptor = descriptorToTab.keySet().stream()
	            		.filter(tab -> tab.getId().startsWith(eefTabDescriptorPrefix))
	            		.filter(EEFTabDescriptor.class::isInstance)
	            		.map(tab -> (EEFTabDescriptor) tab)
	            		.findFirst();
	            if(tabDescriptor.isPresent()) {
					// Warning: we use reflection here because we are limited by the EEF API.
	            	EEFPage eefPage = IntrospectionUtils.getFieldValue(tabDescriptor.get(), "eefPage", EEFPage.class);
	            	// Change the page identifier to fool EEF and trigger the tab recreation.
	            	// See {@link EEFTabbedPropertySheetPage.updateTabs(List<IEEFTabDescriptor> descriptors)}
	            	eefPage.getDescription().setIdentifier(eefPage.getDescription().getIdentifier()+System.currentTimeMillis());
	            }
			}
		}
		
		return self;
	}
	
}
