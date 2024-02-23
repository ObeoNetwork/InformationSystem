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

import static java.util.stream.Collectors.toList;
import static org.obeonetwork.utils.common.ui.Activator.logInfo;
import static org.obeonetwork.utils.common.ui.Activator.logWarning;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.CompoundCommand;
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
	
	/**
	 * Executes the given {@link CreateRepresentationCommand} or compound of {@link CreateRepresentationCommand}s.<br>
	 * <p>
	 * Joins on the save session job family to make sure that no session save is in progress.<br>
	 * Otherwise, when the representation is added to the resource,
	 * CreateRepresentationCommand can be problematic.
	 * At some point during the save, the eSetDeliver is disabled
	 * (ResourceSaveDiagnose.hasDifferentSerialization), preventing any adapter from
	 * being added to the new representation.
	 * </p>
	 * <p>
	 * Warning: This induce the following risk. If no dialect editors are open,
	 * SaveSessionWhenNoDialectEditorsListener saves the session each time a command
	 * is executed on the stack. Creating multiple representations with multiple
	 * commands executed separately and at once may therefore cause a deadlock situation
	 * (SAFRAN-1134). This is why this method accepts a compound of {@link CreateRepresentationCommand}s.
	 * </p>
		
	 * @param command
	 * @param session
	 */
	public static void executeCreateRepresentationCommand(AbstractCommand command, Session session) {
		logInfo("Joining on Sirius save session job family.");
		try {
			Job.getJobManager().join(SaveSessionJob.FAMILY, new NullProgressMonitor());
		} catch (OperationCanceledException | InterruptedException e) {
			logWarning(String.format("Join Sirius save session jobs aborted for '%s'.", command.getLabel()));
		}
		logInfo("Joining on Sirius save session job family passed.");
		logInfo(String.format("Executing command '%s'.", command.getLabel()));
		session.getTransactionalEditingDomain().getCommandStack().execute(command);
		logInfo(String.format("Command '%s' executed.", command.getLabel()));
	}
	
	public static DRepresentation createRepresentation(Session session, EObject context, RepresentationDescription representationDescription, String title, IProgressMonitor monitor) {
		CreateRepresentationCommand command = new CreateRepresentationCommand(session, representationDescription, context, title, monitor);
		executeCreateRepresentationCommand(command, session);
		return command.getCreatedRepresentation();
	}
	
	public static DRepresentation createRepresentation(Session session, EObject context, String representationDescriptionId, IProgressMonitor monitor) {
		CreateRepresentationCommand command = createRepresentationCommand(session, context, representationDescriptionId, monitor);
		executeCreateRepresentationCommand(command, session);
		return command.getCreatedRepresentation();
	}
	
	public static List<DRepresentation> createRepresentations(Session session, List<EObject> contexts, List<String> representationDescriptionIds, IProgressMonitor monitor) {
		CompoundCommand compoundCommand = new CompoundCommand();
		
		Iterator<EObject> contextIterator = contexts.iterator();
		Iterator<String> representationDescriptionIdIterator = representationDescriptionIds.iterator();
		while(contextIterator.hasNext() && representationDescriptionIdIterator.hasNext()) {
			compoundCommand.append(createRepresentationCommand(session, contextIterator.next(), representationDescriptionIdIterator.next(), monitor));
		}
		
		executeCreateRepresentationCommand(compoundCommand, session);

		return compoundCommand.getCommandList().stream()
		.map(CreateRepresentationCommand.class::cast)
		.map(CreateRepresentationCommand::getCreatedRepresentation)
		.collect(toList());
	}
	
	private static CreateRepresentationCommand createRepresentationCommand(Session session, EObject context, String representationDescriptionId, IProgressMonitor monitor) {
		
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
		
		return new CreateRepresentationCommand(session, representationDescription, context, title, monitor);
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
