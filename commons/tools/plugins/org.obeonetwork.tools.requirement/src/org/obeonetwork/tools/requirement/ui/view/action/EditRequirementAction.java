/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.Dialog;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.RequirementLink;
import org.obeonetwork.utils.common.ui.EEFPropertiesPageDialog;

/**
 * @author Obeo
 *
 */
public class EditRequirementAction extends EObjectLinksViewAction {

	/**
	 * @param linksView
	 */
	public EditRequirementAction(EObjectLinksView linksView) {
		super(linksView);
		this.setText(RequirementLinkerPlugin.getInstance().getString("EditRequirementAction_title")); //$NON-NLS-1$
		this.setToolTipText(RequirementLinkerPlugin.getInstance().getString("EditRequirementAction_description")); //$NON-NLS-1$
		this.setImageDescriptor(RequirementLinkerPlugin.getInstance().getImageDescriptor(RequirementLinkerPlugin.EDIT));
		this.setEnabled(false);
	}

	private boolean isSelectionValid(List<EObjectLink> selection) {
		// Action enabled if one
		// (and only one) entry
		// is selected
		return selection.size() == 1 
				 // The  selected entry is an entry of the current selection
				// and not a children entry
				&&  selection.get(0).getSource() == linksView.getInput();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		List<EObjectLink> selection = linksView.getSelectedEntries();
		if (!isSelectionValid(selection)) {
			return;
		}
		RequirementLink eObjectLink = (RequirementLink) selection.get(0);

		Requirement requirementTarget = eObjectLink.getRequirement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(requirementTarget);
	
		
		AbstractEMFOperation operation = new AbstractEMFOperation(editingDomain, getText()) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				
				Dialog dialog = new EEFPropertiesPageDialog(linksView, requirementTarget, true);
				if (dialog.open() != Dialog.OK) {
					return Status.CANCEL_STATUS;
				}
				
				return Status.OK_STATUS;
			}
			
		};
		

		try {
			operation.execute(new NullProgressMonitor(), null);
			linksView.refresh();
		} catch (ExecutionException e) {
			RequirementLinkerPlugin.getInstance()
				.getLog()
				.error("An error occured while edition Requirement.", e); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction#fireSelectionChanged(java.util.List)
	 */
	@Override
	public void fireSelectionChanged(List<EObjectLink> newSelection) {
		this.setEnabled(isSelectionValid(newSelection));
	}

}
