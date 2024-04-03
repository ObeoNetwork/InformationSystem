/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.doc.ui.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISharedImages;
import org.obeonetwork.tools.doc.DocBridgeUI;
import org.obeonetwork.tools.doc.core.command.AddDocumentationLinkCommand;
import org.obeonetwork.tools.doc.ui.dialog.DocumentationLinkDialog;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;

/**
 * @author Obeo
 *
 */
public class AddDocumentationLink extends EObjectLinksViewAction {

	
	/**
	 * @param linksView
	 */
	public AddDocumentationLink(EObjectLinksView linksView) {
		super(linksView);
		this.setText(DocBridgeUI.getInstance().getString("AddDocumentationLinkAction_title")); //$NON-NLS-1$
		this.setToolTipText(DocBridgeUI.getInstance().getString("AddDocumentationLinkAction_description")); //$NON-NLS-1$
		this.setImageDescriptor(DocBridgeUI.getInstance().getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		this.setEnabled(false);
		
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		EObject input = linksView.getInput();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(input);
		if (editingDomain != null) {
			DocumentationLinkDialog dialog = new DocumentationLinkDialog(linksView.getSite().getShell());
			int open = dialog.open();
			if (open == Window.OK) {
				editingDomain.getCommandStack().execute(new AddDocumentationLinkCommand(input, dialog.getName(), dialog.getValue()));
				linksView.refresh();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction#fireInputChanged(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void fireInputChanged(EObject newInput) {
		setEnabled(newInput != null);
	}
	
	

}
