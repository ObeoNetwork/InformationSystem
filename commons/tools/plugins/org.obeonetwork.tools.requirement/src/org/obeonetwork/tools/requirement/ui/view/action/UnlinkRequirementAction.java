/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.tools.requirement.ui.view.action;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.ui.ISharedImages;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.RequirementLink;

/**
 * @author Obeo
 *
 */
public class UnlinkRequirementAction extends EObjectLinksViewAction {

	/**
	 * @param linksView
	 */
	public UnlinkRequirementAction(EObjectLinksView linksView) {
		super(linksView);
		this.setText(RequirementLinkerPlugin.getInstance().getString("UnlinkRequirementAction_title")); //$NON-NLS-1$
		this.setToolTipText(RequirementLinkerPlugin.getInstance().getString("UnlinkRequirementAction_description")); //$NON-NLS-1$
		this.setImageDescriptor(RequirementLinkerPlugin.getInstance().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		this.setEnabled(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		MessageDialog dialog = new MessageDialog(linksView.getSite().getShell(),
				RequirementLinkerPlugin.getInstance().getString("DeleteRequirementLinkAction_ConfirmDialog_title"), //$NON-NLS-1$
				null,
				RequirementLinkerPlugin.getInstance().getString("DeleteRequirementLinkAction_ConfirmDialog_msg"), //$NON-NLS-1$
				MessageDialog.CONFIRM, new String[] { IDialogConstants.OK_LABEL,
						IDialogConstants.CANCEL_LABEL },
				1);
		boolean openConfirm = dialog.open() == Window.OK;
		if (openConfirm) {
			Session session = new EObjectQuery(linksView.getInput()).getSession();
			if (session != null) {
				TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
				RecordingCommand cmd = new RecordingCommand(editingDomain, "UnLink Requirements") { //$NON-NLS-1$
					protected void doExecute() {
						for (EObjectLink link : linksView.getSelectedEntries()) {
							if (link instanceof RequirementLink) {
								RequirementLink reqLink = (RequirementLink) link;
								reqLink.getRequirement().getReferencedObject().remove(linksView.getInput());
							}
						}
					}
				};
				editingDomain.getCommandStack().execute(cmd);
			}
			linksView.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction#fireSelectionChanged(java.util.List)
	 */
	@Override
	public void fireSelectionChanged(List<EObjectLink> newSelection) {
		if (newSelection.size() > 0) {
			for (EObjectLink eObjectLink : newSelection) {
				if (eObjectLink.getSource() != linksView.getInput()) {
					this.setEnabled(false);
					return;
				}
			}
			this.setEnabled(true);
		} else {
			this.setEnabled(false);
		}
	}

}
