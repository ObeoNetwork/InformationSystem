/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.ui.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.is.design.service.ProvidedModelsService;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;

public class ImportEnvironmentModelHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Session session = getSession(event);
		if (session == null) {
			return null;
		}
		
		Collection<URI> semanticURIs = new ArrayList<URI>();
		for (Resource semanticResource : session.getSemanticResources()) {
			semanticURIs.add(semanticResource.getURI());
		}
		
		Shell shell = HandlerUtil.getActiveShell(event);
		Collection<Environment> environments = ProvidedModelsService.getProvidedEnvironmentModels(semanticURIs);
		Environment selectedEnvironment = getSelectedEnvironment(shell, environments);
		if (selectedEnvironment != null) {
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
			if (ted != null) {
				ted.getCommandStack().execute(new AddSemanticResourceCommand(session, selectedEnvironment.eResource().getURI(), new NullProgressMonitor()));
				MessageDialog.openInformation(shell, "Import Environment model", "The model has been added as a semantic ressource");
			}
		}
		return null;
	}
	
	private Session getSession(ExecutionEvent event) {
		IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
		if (editorInput instanceof SessionEditorInput) {
			SessionEditorInput sessionEditorInput = (SessionEditorInput)editorInput;
			return sessionEditorInput.getSession();
		}
		return null;
	}
	
	private Environment getSelectedEnvironment(Shell shell, Collection<Environment> environments) {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell,
				new LabelProvider() {

					@Override
					public String getText(Object element) {
						if (element instanceof Environment) {
							Environment environment = (Environment) element;
							return environment.getName() + " - " + environment.eResource().getURI();
						}
						return super.getText(element);
					}
					
				});
		dialog.setTitle("Import Environment model");
		dialog.setMessage("Select an environment model");
		dialog.setBlockOnOpen(true);
		dialog.setMultipleSelection(false);
		dialog.setElements(environments.toArray());
		dialog.open();
		Object[] results = dialog.getResult();
		dialog.close();
		if (results != null && results.length == 1) {
			Object selected = results[0];
			if (selected instanceof Environment) {
				return (Environment)selected;
			}
		}
		return null;
	}

}
