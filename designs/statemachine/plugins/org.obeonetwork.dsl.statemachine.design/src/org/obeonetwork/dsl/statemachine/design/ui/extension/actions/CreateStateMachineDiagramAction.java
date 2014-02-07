package org.obeonetwork.dsl.statemachine.design.ui.extension.actions;

import java.net.URL;
import java.util.Collection;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.statemachine.StateMachine;
import org.obeonetwork.dsl.statemachine.StateMachineFactory;
import org.obeonetwork.dsl.statemachine.design.Activator;
import org.obeonetwork.dsl.statemachine.design.ui.extension.providers.StateMachineAnalysisContextMenuActionProvider;

import fr.obeo.dsl.viewpoint.DRepresentation;
import fr.obeo.dsl.viewpoint.business.api.dialect.DialectManager;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.dsl.viewpoint.description.RepresentationDescription;
import fr.obeo.dsl.viewpoint.description.Viewpoint;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIManager;

public class CreateStateMachineDiagramAction extends Action {

	private static ImageDescriptor image;
	static {
		URL url = Activator.getDefault().getBundle().getEntry("icons/StateMachine.gif");
		image = ImageDescriptor.createFromURL(url);
	}
	
	private ObeoDSMObject context;
	
	public CreateStateMachineDiagramAction(ObeoDSMObject context) {
		this.context = context;
	}	

	@Override
	public String getId() {
		return "org.obeonetwork.dsl.statemachine.design.ui.extension.actions.CreateStateMachineDiagramAction";
	}

	@Override
	public String getText() {
		return "new State Machine Diagram";
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
		if (session == null) {
			return;
		}
		TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		if (editingDomain == null) {
			return;
		}
		
		RecordingCommand cmd = new RecordingCommand(editingDomain, "Create Sequence diagram") {
			protected void doExecute() {
				// Get Session
				Session session = SessionManager.INSTANCE.getSession(context);
				
				if (session != null) {
					// Ask the user to provide a name for the diagram
					InputDialog dialog = new InputDialog(shell, "New representation", "New representation name", "new State machine diagram", null);
					int buttonPressed = dialog.open();
					if (buttonPressed == InputDialog.OK) {
						String diagramName = dialog.getValue();
						
						// Create a new state machine instance
						StateMachine statemachine = StateMachineFactory.eINSTANCE.createStateMachine();
						statemachine.setName(diagramName);
						context.getBehaviours().add(statemachine);
						
						Collection<RepresentationDescription> descs = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false), statemachine);
						for (RepresentationDescription desc : descs) {
							Viewpoint viewpoint = (Viewpoint)desc.eContainer();
							
							if (StateMachineAnalysisContextMenuActionProvider.isStateMachineViewpoint(viewpoint)
									&& "State Machine Diagram".equals(desc.getName())) {
								// Create the new diagram
								if (DialectManager.INSTANCE.canCreate(statemachine, desc)) {
									DRepresentation stateMachineDiagram = DialectManager.INSTANCE.createRepresentation(diagramName, statemachine, desc, session, new NullProgressMonitor());
									if (stateMachineDiagram != null) {
										DialectUIManager.INSTANCE.openEditor(session, stateMachineDiagram, new NullProgressMonitor());
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