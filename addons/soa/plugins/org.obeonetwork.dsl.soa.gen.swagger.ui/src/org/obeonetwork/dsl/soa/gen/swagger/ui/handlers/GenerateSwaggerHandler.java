package org.obeonetwork.dsl.soa.gen.swagger.ui.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.ui.wizards.GenerateComponentsSwaggerWizard;

public class GenerateSwaggerHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();

		List<Component> components = new ArrayList<>();
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator<?> selectionIteratror = structuredSelection.iterator();
			while(selectionIteratror.hasNext()) {
				Object selectedObject = selectionIteratror.next();
				if(selectedObject instanceof Component) {
					components.add((Component) selectedObject);
				} else if(selectedObject instanceof System) {
					components.addAll(((System)selectedObject).getOwnedComponents());
				}
			}
		}
		
		Shell shell = HandlerUtil.getActiveShell(event);
		WizardDialog dialog = new WizardDialog(shell, new GenerateComponentsSwaggerWizard(components));
		dialog.open();
		
		return null;
		
	}
}
