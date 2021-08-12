/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerImporter;
import org.obeonetwork.dsl.soa.gen.swagger.ui.wizards.SwaggerImportDialog;
import org.obeonetwork.utils.sirius.services.EObjectUtils;
import org.obeonetwork.utils.sirius.session.SessionUtils;
import org.obeonetwork.utils.sirius.transaction.RecordingCommandWithResult;

public class ImportSwaggerHandler extends AbstractHandler implements IHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		System system = unwrapSelection(event);
		Shell shell = HandlerUtil.getActiveShell(event);
		SwaggerImportDialog dialog = new SwaggerImportDialog(shell, SWT.OPEN);
		int returnValue = dialog.open(); 
		
		if(returnValue == SWT.OK && dialog.getSwaggerFilePath() != null) {
			String swaggerFilePath = dialog.getSwaggerFilePath();
			String paginationExtension = dialog.getPaginationExtension();
			
			Environment environment = EObjectUtils.getAllResources(system).stream()
			.flatMap(resource -> resource.getContents().stream())
			.filter(eObject -> eObject instanceof Environment)
			.map(eObject -> (Environment)eObject)
			.findFirst().orElse(null);
			
			TransactionalEditingDomain ted = new EObjectQuery(system).getSession().getTransactionalEditingDomain();
			
			RecordingCommandWithResult<Integer> swaggerImportCommand = new RecordingCommandWithResult<Integer>(ted) {

				@Override
				protected Integer doExecuteWithResult() {
					SwaggerImporter swaggerImporter = new SwaggerImporter(system, environment);
					return swaggerImporter.importFromFile(swaggerFilePath, paginationExtension);
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
	
	public String getDefaultInputDirPath(System system) {
		String defaultInputDirPath = null;
		if(system != null) {
			Session session = new EObjectQuery(system).getSession();
			ModelingProject modelingProject = SessionUtils.getModelingProjectFromSession(session);
			defaultInputDirPath = modelingProject.getProject().getLocation().toOSString();
		} else {
			defaultInputDirPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		}

		return defaultInputDirPath;
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
