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
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.cinematic.design.services.CinematicLayoutServices;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

//TODO VRI implement the pre conditions in plugin.xml
public class ExtractLayoutHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IDiagramElementEditPart selectedDiagramElementEditPart = uwrapSelection(event);
		
		DNodeContainer dNodeContainer = (DNodeContainer) selectedDiagramElementEditPart.resolveDiagramElement();
		ViewContainer viewContainer = (ViewContainer) selectedDiagramElementEditPart.resolveTargetSemanticElement();
		
		Session session = new EObjectQuery(dNodeContainer).getSession();
		if (session != null) {
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();

			ted.getCommandStack().execute(new RecordingCommand(ted) {

				@Override
				protected void doExecute() {
					viewContainer.setLayout(CinematicLayoutServices.extractLayout(dNodeContainer));
				}
			});

		}
		
		return null;
	}

	private IDiagramElementEditPart uwrapSelection(ExecutionEvent event) throws ExecutionException {
		IDiagramElementEditPart selectedDiagramElementEditPart = null;
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			Iterator<?> selectionIteratror = structuredSelection.iterator();
			if (selectionIteratror.hasNext()) {
				Object selectedObject = selectionIteratror.next();
				if (selectedObject instanceof IDiagramElementEditPart) {
					selectedDiagramElementEditPart = ((IDiagramElementEditPart) selectedObject);
				}				
			}
		}
		return selectedDiagramElementEditPart;
	}
	
}
