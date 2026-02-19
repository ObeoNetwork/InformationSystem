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
package org.obeonetwork.tools.requirement.wizard.page;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.ui.tools.api.views.ViewHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.RequirementFactory;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.util.RequirementService;
import org.obeonetwork.tools.requirement.wizard.util.LinkedRequirementsLabelProvider;
import org.obeonetwork.tools.requirement.wizard.util.RequirementsRepositoriesContentProvider;

/**
 * @author Obeo
 *
 */
public class CategorySelectionPage extends WizardPage {

	private TreeViewer categoriesViewer;
	private Button createCategorie;
	private Category selectedCategory;
	private EObject currentValue;

	public CategorySelectionPage() {
		super("Category selection"); //$NON-NLS-1$
		this.setTitle(RequirementLinkerPlugin.getInstance().getString("CategorySelectionPage_title")); //$NON-NLS-1$
		this.setDescription(RequirementLinkerPlugin.getInstance().getString("CategorySelectionPage_description")); //$NON-NLS-1$
		selectedCategory = null;
	}

	public void init(EObject currentValue) {
		this.currentValue = currentValue;
	}
	
	/**
	 * @return
	 */
	protected Object getInput() {
		return RequirementService.findRequirementsRepositories(currentValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_BOTH);
		control.setLayoutData(gd);
		GridLayout layout = new GridLayout();
		control.setLayout(layout);
		Label intro = new Label(control, SWT.NONE);
		intro.setText(RequirementLinkerPlugin.getInstance().getString("CategorySelectionPage_label")); //$NON-NLS-1$
		GridData labelData = new GridData(GridData.FILL_HORIZONTAL);
		intro.setLayoutData(labelData);
		categoriesViewer = new TreeViewer(control);
		categoriesViewer.getControl().setLayoutData(gd);
		AdapterFactory adapterFactory = ViewHelper.INSTANCE.createAdapterFactory();
		categoriesViewer.setLabelProvider(new LinkedRequirementsLabelProvider(adapterFactory));
		categoriesViewer.setContentProvider(new RequirementsRepositoriesContentProvider(adapterFactory) {

			@Override
			public Object[] getChildren(Object object) {
				if (object instanceof Category element) {
					return element.getSubCategories().toArray();
				}
				return super.getChildren(object);
			}

			@Override
			public boolean hasChildren(Object object) {
				if (object instanceof Category element) {
					return !element.getSubCategories().isEmpty();
				}
				return super.hasChildren(object);
			}

		});
		categoriesViewer.setInput(getInput());
		categoriesViewer.addSelectionChangedListener(event -> {
			EObject selection = getTreeviewSelection();
			boolean selectionValid = false;
			if (selection instanceof Category element) {
				selectedCategory = element;
				selectionValid = true;
			}
			setPageComplete(selectionValid);
			createCategorie.setEnabled(getCategoryContainment(selection) != null);
		});
		createCategorie = new Button(control, SWT.PUSH);
		createCategorie.setText(RequirementLinkerPlugin.getInstance()
				.getString("CategorySelectionPage_CreateCategoryButton_title")); //$NON-NLS-1$
		createCategorie.addSelectionListener(SelectionListener.widgetSelectedAdapter(event -> {
			InputDialog dialog = new InputDialog(getShell(),
					RequirementLinkerPlugin.getInstance()
							.getString("CategorySelectionPage_CreateCategoryDialog_title"), //$NON-NLS-1$
					RequirementLinkerPlugin.getInstance()
							.getString("CategorySelectionPage_CreateCategoryDialog_description"), //$NON-NLS-1$
					RequirementLinkerPlugin.getInstance()
							.getString("CategorySelectionPage_CreateCategoryDialog_defaultvalue"), //$NON-NLS-1$
					null);

			if (dialog.open() == Window.OK) {
				Category category = RequirementFactory.eINSTANCE.createCategory();
				category.setName(dialog.getValue());
				getCategoryContainment(getTreeviewSelection()).add(category);
			}
		}));
		createCategorie.setEnabled(false);
		if (currentValue != null) {
			categoriesViewer.reveal(currentValue);
			categoriesViewer.setSelection(new StructuredSelection(currentValue));
		}
		setControl(control);
	}

	private List<Category> getCategoryContainment(EObject selection) {
		if (selection instanceof Category element) {
			return element.getSubCategories();
		} else if (selection instanceof Repository element) {
			return element.getMainCategories();
		}
		return null;
	}
	
	/**
	 * @return
	 */
	public Category getSelection() {
		return selectedCategory;
	}

	private EObject getTreeviewSelection() {
		if (categoriesViewer.getSelection() instanceof StructuredSelection selection
				&& selection.getFirstElement() instanceof EObject current) {
			return (EObject) current;	
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		return super.isPageComplete() && getTreeviewSelection() instanceof Category;
	}

}
