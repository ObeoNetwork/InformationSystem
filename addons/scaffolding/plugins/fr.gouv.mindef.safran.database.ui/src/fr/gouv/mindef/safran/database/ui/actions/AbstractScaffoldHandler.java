/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.actions;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.ui.util.ScaffoldingUtils;
import fr.gouv.mindef.safran.database.ui.wizards.scaffolding.ScaffoldingOperation;
import fr.gouv.mindef.safran.database.ui.wizards.scaffolding.ScaffoldingWizard;

public abstract class AbstractScaffoldHandler extends AbstractHandler {
	
	private Shell shell = null;
	private static final int USE_EXISTING_SCAFFOLD = 0;
	private static final int CREATE_NEW_SCAFFOLD = 1;
	private static final int CANCEL = 2;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		shell = HandlerUtil.getActiveShell(event);
		if (selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			if (structuredSelection.size() == 2 ) {
				ScaffoldInfo existingScaffoldInfo = getExistingScaffoldModel(structuredSelection);
				if (existingScaffoldInfo != null) {
					MessageDialog dlg = new MessageDialog(shell, "Existing scaffold model found", null, "A scaffold model already exists for these objects in file " + existingScaffoldInfo.eResource().getURI().toPlatformString(true) + "\n\nWhat do you want to do ?", MessageDialog.QUESTION_WITH_CANCEL, new String[]{"Use existing scaffold", "Create a new scaffold", "Cancel"}, 0);
					int btn = dlg.open();
					if (btn == CANCEL) {
						return null;
					} else if (btn == CREATE_NEW_SCAFFOLD) {
						executeScaffoldingWizard(structuredSelection);						
					} else if (btn == USE_EXISTING_SCAFFOLD) {
						executeFromScaffoldModel(existingScaffoldInfo);
					}
				} else {
					executeScaffoldingWizard(structuredSelection);
				}
				
			} else if (structuredSelection.size() == 1) {
				executeFromScaffoldModel(structuredSelection);
			}
		}
		return null;
	}
	
	
	private ScaffoldInfo getExistingScaffoldModel(StructuredSelection selection) {
		Iterator<?> iterator = selection.iterator();
		Object first = iterator.next();
		Object second = iterator.next();
		
		EObject firstEObject = null;
		EObject secondEObject = null;
		if (first instanceof EObject && second instanceof EObject) {
			firstEObject = (EObject)first;
			secondEObject = (EObject)second;
			
			Session session = SessionManager.INSTANCE.getSession(firstEObject);
			for (Resource semanticResource : session.getSemanticResources()) {
				for (EObject object : semanticResource.getContents()) {
					if (object instanceof ScaffoldInfo) {
						ScaffoldInfo info = (ScaffoldInfo)object;
						if ((info.getLeftObject() == firstEObject && info.getRightObject() == secondEObject)
								|| (info.getLeftObject() == secondEObject && info.getRightObject() == firstEObject)) {
							return info;
						}
					}
				}
			}
		}
		return null;
	}
	
	protected void executeFromScaffoldModel(StructuredSelection structuredSelection) {
		ScaffoldInfo info = ScaffoldingUtils.getScaffoldInfoFromSelection(structuredSelection.getFirstElement());
		executeFromScaffoldModel(info);
	}
	
	protected void executeFromScaffoldModel(ScaffoldInfo info) {
		if (info != null) {
			ScaffoldingOperation op = new ScaffoldingOperation(
					info,
					getWizardKind());
	
			ScaffoldingUtils.executeScaffolding(op, shell);
		}
	}
	
	protected void executeScaffoldingWizard(StructuredSelection structuredSelection) {
		ScaffoldingWizard wizard = new ScaffoldingWizard(getWizardKind());
		
		IWorkbench workbench = PlatformUI.getWorkbench();
		wizard.init(workbench, structuredSelection);
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(workbench.getActiveWorkbenchWindow().getShell(), wizard);
		dialog.create();
		dialog.open();		
	}
	
	protected abstract ScaffoldType getWizardKind();

}
