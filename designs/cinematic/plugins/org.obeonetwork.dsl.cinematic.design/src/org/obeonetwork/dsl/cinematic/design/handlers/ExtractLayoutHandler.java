package org.obeonetwork.dsl.cinematic.design.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDDiagramEditPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.cinematic.design.services.CinematicLayoutServices;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

public class ExtractLayoutHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IDDiagramEditPart selectedDDiagramEditPart = uwrapSelection(event);
		DDiagram viewContainerDDiagram = selectedDDiagramEditPart.resolveDDiagram().get();
		ViewContainer viewContainer = (ViewContainer) selectedDDiagramEditPart.resolveSemanticElement();
		
		Session session = new EObjectQuery(viewContainerDDiagram).getSession();
		if (session != null) {
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();

			ted.getCommandStack().execute(new RecordingCommand(ted) {

				@Override
				protected void doExecute() {
					viewContainer.setLayout(CinematicLayoutServices.extractLayout(viewContainerDDiagram));
				}
			});

		}
		
		return null;
	}

	private IDDiagramEditPart uwrapSelection(ExecutionEvent event) throws ExecutionException {
		IDDiagramEditPart selectedDDiagramEditPart = null;
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			Iterator<?> selectionIteratror = structuredSelection.iterator();
			if (selectionIteratror.hasNext()) {
				Object selectedObject = selectionIteratror.next();
				if (selectedObject instanceof IDDiagramEditPart) {
					selectedDDiagramEditPart = ((IDDiagramEditPart) selectedObject);
				}				
			}
		}
		return selectedDDiagramEditPart;
	}
	
}
