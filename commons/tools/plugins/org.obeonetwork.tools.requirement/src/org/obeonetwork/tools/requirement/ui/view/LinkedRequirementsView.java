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

package org.obeonetwork.tools.requirement.ui.view;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.util.EObjectLinkContentProvider;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.RequirementLink;
import org.obeonetwork.tools.requirement.ui.view.action.CreateRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.action.EditRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.action.LinkRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.action.UnlinkRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.util.LinkedRequirementsContentProvider;
import org.obeonetwork.tools.requirement.ui.view.util.LinkedRequirementsLabelProvider;

/**
 * @author Obeo
 *
 */
public class LinkedRequirementsView extends EObjectLinksView {

	public static final String ID = "org.obeonetwork.tools.requirement.views.LinkedRequirementsView"; //$NON-NLS-1$

	@Override
	protected void update(EObject selectedEObject) {
		// Requirement and categories should not be used to attach requirements
		// to them
		EObject filtered = selectedEObject;
		if (selectedEObject != null && selectedEObject.eClass().getEPackage() == RequirementPackage.eINSTANCE) {
			filtered = null;
		}
		super.update(filtered);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#addColumns()
	 */
	@Override
	protected void addColumns() {
		addColumn(RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_IDColumn_title"), 20); //$NON-NLS-1$
		addColumn(RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_NameColumn_title"), 40); //$NON-NLS-1$
		addColumn(RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_CategoryColumn_title"), 40); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createContentProvider()
	 */
	@Override
	protected EObjectLinkContentProvider createContentProvider() {
		return new LinkedRequirementsContentProvider();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createLabelProvider()
	 */
	@Override
	protected CellLabelProvider createLabelProvider() {
		return new LinkedRequirementsLabelProvider(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createFilters()
	 */
	@Override
	protected List<ViewerFilter> createFilters() {
		return List.of(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof RequirementLink;
			}
		});
	}

	/**
	 * Create actions for selection.
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#fillLocalActionBar()
	 */
	@Override
	protected void fillLocalActionBar() {
		getViewSite().getActionBars().getToolBarManager().add(new CreateRequirementAction(this));
		getViewSite().getActionBars().getToolBarManager().add(new EditRequirementAction(this));
		getViewSite().getActionBars().getToolBarManager().add(new LinkRequirementAction(this));
		getViewSite().getActionBars().getToolBarManager().add(new UnlinkRequirementAction(this));
	}
	
	/**
	 * Create action to edit selected requirement.
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createDoubleClickAction()
	 */
	@Override
	protected IAction createDoubleClickAction() {
		return new EditRequirementAction(this);
	}
	
	@Override
	protected String getShowChildrenActionTitle() {
		return RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_ShowChildrenAction_title");
	}

	@Override
	protected String getShowChildrenActionDescription() {
		return RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_ShowChildrenAction_description");
	}
}
