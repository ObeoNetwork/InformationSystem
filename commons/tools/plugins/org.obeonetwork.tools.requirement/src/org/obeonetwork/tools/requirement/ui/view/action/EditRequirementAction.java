/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.operation.WizardEditingOperation;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.RequirementLink;
import org.obeonetwork.tools.requirement.wizard.operation.RequirementEditingOperation;

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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		RequirementLink eObjectLink = (RequirementLink) linksView.getSelectedEntries().get(0);

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(linksView.getInput());
		DomainPropertiesEditionContext propertiesEditionContext = new DomainPropertiesEditionContext(null, null,
				editingDomain, linksView.getAdapterFactory(), eObjectLink.getRequirement());
		WizardEditingOperation operation = new RequirementEditingOperation(propertiesEditionContext);
		try {
			operation.execute(new NullProgressMonitor(), null);
			linksView.refresh();
		} catch (ExecutionException e) {
			EEFRuntimePlugin.getDefault().logError("An error occured during wizard editing.", e); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction#fireSelectionChanged(java.util.List)
	 */
	@Override
	public void fireSelectionChanged(List<EObjectLink> newSelection) {
		boolean enabled = newSelection.size() == 1 && // Action enabled if one
														// (and only one) entry
														// is selected
				newSelection.get(0).getSource() == linksView.getInput(); // The
																			// selected
																			// entry
																			// is
																			// an
																			// entry
																			// of
																			// the
																			// current
																			// selection
																			// and
																			// not
																			// a
																			// children
																			// entry
		this.setEnabled(enabled);
	}

}
