package org.obeonetwork.dsl.interaction.design.ui.extension.actions;

import java.net.URL;
import java.util.Collection;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionFactory;
import org.obeonetwork.dsl.interaction.design.Activator;
import org.obeonetwork.dsl.interaction.design.ui.extension.providers.InteractionAnalysisContextMenuActionProvider;

import fr.obeo.dsl.common.tools.api.editing.EditingDomainFactoryService;
import fr.obeo.dsl.viewpoint.DRepresentation;
import fr.obeo.dsl.viewpoint.business.api.dialect.DialectManager;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.dsl.viewpoint.description.RepresentationDescription;
import fr.obeo.dsl.viewpoint.description.Viewpoint;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIManager;

public class CreateSequenceDiagramAction extends Action {

	private static ImageDescriptor image;
	static {
		URL url = Activator.getDefault().getBundle().getEntry("images/createSequenceDiagram.gif");
		image = ImageDescriptor.createFromURL(url);
	}
	
	private ObeoDSMObject context;
	
	public CreateSequenceDiagramAction(ObeoDSMObject context) {
		this.context = context;
	}	

	@Override
	public String getId() {
		return "org.obeonetwork.dsl.interaction.design.ui.extension.actions.CreateSequenceDiagramAction";
	}

	@Override
	public String getText() {
		return "new Sequence Diagram";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return image;
	}

	@Override
	public void run() {
		if (context == null) {
			return;
		}
		
		final Shell shell = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
		
//		TransactionalEditingDomain editingDomain = EditingDomainService.getInstance().getEditingDomainProvider().getEditingDomain();
		Session session = SessionManager.INSTANCE.getSession(context);
		if (session == null || session.getSessionResource() == null || session.getSessionResource().getResourceSet() == null) {
			return;
		}
		ResourceSet resourceSet = session.getSessionResource().getResourceSet();
		TransactionalEditingDomain editingDomain = EditingDomainFactoryService.INSTANCE.getEditingDomainFactory().getEditingDomain(resourceSet);
		
		RecordingCommand cmd = new RecordingCommand(editingDomain, "Create Sequence diagram") {
			protected void doExecute() {
				// Get Session
				Session session = SessionManager.INSTANCE.getSession(context);
				
				if (session != null) {
					// Ask the user to provide a name for the diagram
					InputDialog dialog = new InputDialog(shell, "New representation", "New representation name", "new Sequence diagram", null);
					int buttonPressed = dialog.open();
					if (buttonPressed == InputDialog.OK) {
						String diagramName = dialog.getValue();
						
						// Create a new interaction instance
						Interaction interaction = InteractionFactory.eINSTANCE.createInteraction();
						context.getBehaviours().add(interaction);
						
						Collection<RepresentationDescription> descs = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(), interaction);
						for (RepresentationDescription desc : descs) {
							Viewpoint viewpoint = (Viewpoint)desc.eContainer();
							
							if (InteractionAnalysisContextMenuActionProvider.isInteractionViewpoint(viewpoint)
									&& "Sequence Diagram".equals(desc.getName())) {
								// Create the new diagram
								if (DialectManager.INSTANCE.canCreate(interaction, desc)) {
									DRepresentation sequenceDiagram = DialectManager.INSTANCE.createRepresentation(diagramName, interaction, desc, session, new NullProgressMonitor());
									if (sequenceDiagram != null) {
										DialectUIManager.INSTANCE.openEditor(session, sequenceDiagram);
									}
								}
							}
						}
					}
				}
			}
		};
		editingDomain.getCommandStack().execute(cmd);
	}
}