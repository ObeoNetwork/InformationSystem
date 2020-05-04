/*******************************************************************************
 * Copyright (c) 2016-2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.ui.handlers;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.design.services.ModelServices;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerImporter;
import org.obeonetwork.utils.sirius.transaction.RecordingCommandWithResult;

public class ImportSwaggerHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		System system = unwrapSelection(event);
		
		Shell shell = HandlerUtil.getActiveShell(event);
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		dialog.setFilterExtensions(new String [] { "*.yaml;*.json", "*.yaml", "*.json" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		String swaggerFilePath = dialog.open();	
		
		if(swaggerFilePath != null) {
			Environment environment = ModelServices.getAllResources(system).stream()
			.flatMap(resource -> resource.getContents().stream())
			.filter(eObject -> eObject instanceof Environment)
			.map(eObject -> (Environment)eObject)
			.findFirst().orElse(null);
			
			TransactionalEditingDomain ted = new EObjectQuery(system).getSession().getTransactionalEditingDomain();
			
			RecordingCommandWithResult<Integer> swaggerImportCommand = new RecordingCommandWithResult<Integer>(ted) {

				@Override
				protected Integer doExecuteWithResult() {
					SwaggerImporter swaggerImporter = new SwaggerImporter(system, environment);
					return swaggerImporter.importFromFile(swaggerFilePath);
				}
				
			};
			
			ted.getCommandStack().execute(swaggerImportCommand);
			
			Integer status = swaggerImportCommand.getSingleResult();
			
			if(swaggerImportCommand.getException() != null) {
				logError("Unexpected error.", swaggerImportCommand.getException());
				status = IStatus.ERROR;
			}
			
			switch (status) {
			case IStatus.OK:
				MessageDialog.openInformation(shell, Messages.ImportSwaggerHandler_ResultDialog_Title, Messages.ImportSwaggerHandler_ResultDialog_Success_message);
				break;
			case IStatus.WARNING:
				MessageDialog.openWarning(shell, Messages.ImportSwaggerHandler_ResultDialog_Title, Messages.ImportSwaggerHandler_ResultDialog_Warning_message);
				break;
			case IStatus.ERROR:
				MessageDialog.openError(shell, Messages.ImportSwaggerHandler_ResultDialog_Title, Messages.ImportSwaggerHandler_ResultDialog_Failure_message);
				break;
			}
			
		}
		
		return null;
		
	}
	
	private System unwrapSelection(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();

		System system = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			system = (System) structuredSelection.getFirstElement();
			
		}
		
		return system;
	}
	
}
