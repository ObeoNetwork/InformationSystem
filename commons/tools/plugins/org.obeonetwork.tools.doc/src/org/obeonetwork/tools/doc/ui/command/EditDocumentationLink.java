/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.doc.ui.command;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.obeonetwork.tools.doc.DocBridgeUI;
import org.obeonetwork.tools.doc.core.DocumentationLink;
import org.obeonetwork.tools.doc.core.command.EditDocumentationLinkCommand;
import org.obeonetwork.tools.doc.ui.dialog.DocumentationLinkDialog;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EditDocumentationLink extends EObjectLinksViewAction {

	/**
	 * @param linksView
	 */
	public EditDocumentationLink(EObjectLinksView linksView) {
		super(linksView);
		this.setText(DocBridgeUI.getInstance().getString("EditDocumentationLinkAction_title")); //$NON-NLS-1$
		this.setToolTipText(DocBridgeUI.getInstance().getString("EditDocumentationLinkAction_description")); //$NON-NLS-1$
		this.setImageDescriptor(DocBridgeUI.getInstance().getImageDescriptor(DocBridgeUI.EDIT_ICON_ID));
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
			DocumentationLink editedLink = (DocumentationLink)linksView.getSelectedEntries().get(0);
			DocumentationLinkDialog dialog = new DocumentationLinkDialog(linksView.getSite().getShell(), editedLink);
			int open = dialog.open();
			if (open == Window.OK) {
				editingDomain.getCommandStack().execute(new EditDocumentationLinkCommand(editedLink, dialog.getName(), dialog.getValue()));
				linksView.refresh();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction#fireSelectionChanged(java.util.List)
	 */
	@Override
	public void fireSelectionChanged(List<EObjectLink> newSelection) {
		this.setEnabled(newSelection.size() == 1);
	}

}
