/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
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
package org.obeonetwork.tools.requirement.wizard.page;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementFactory;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.util.RequirementService;
import org.obeonetwork.tools.requirement.wizard.util.LinkedRequirementsLabelProvider;
import org.obeonetwork.tools.requirement.wizard.util.RequirementsRepositoriesContentProvider;

import org.eclipse.sirius.ui.tools.api.views.ViewHelper;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class CategorySelectionPage extends WizardPage {

	private TreeViewer categoriesViewer;
	private Button createCategorie;
	private Category selectedCategory;
	private Object currentValue;

	public CategorySelectionPage() {
		super("Category selection"); //$NON-NLS-1$
		this.setTitle(RequirementLinkerPlugin.getInstance().getString("CategorySelectionPage_title")); //$NON-NLS-1$
		this.setDescription(RequirementLinkerPlugin.getInstance().getString("CategorySelectionPage_description")); //$NON-NLS-1$
		selectedCategory = null;
	}

	/**
	 * @return
	 */
	private Object getInput() {
		return RequirementService.findRequirementsRepositories(
				((Requirement) ((PropertiesEditionWizard) getWizard()).getEObject()).getReferencedObject().get((0)));
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
				if (object instanceof Category) {
					return ((Category) object).getSubCategories().toArray();
				}
				return super.getChildren(object);
			}

			@Override
			public boolean hasChildren(Object object) {
				if (object instanceof Category) {
					return !((Category) object).getSubCategories().isEmpty();
				}
				return super.hasChildren(object);
			}

		});
		categoriesViewer.setInput(getInput());
		categoriesViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				EObject selection = getTreeviewSelection();
				if (selection instanceof Category) {
					selectedCategory = (Category) selection;
					setPageComplete(true);
				} else {
					setPageComplete(false);
				}
				createCategorie.setEnabled(selection instanceof Category || selection instanceof Repository);
			}
		});
		createCategorie = new Button(control, SWT.PUSH);
		createCategorie.setText(
				RequirementLinkerPlugin.getInstance().getString("CategorySelectionPage_CreateCategoryButton_title")); //$NON-NLS-1$
		createCategorie.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				InputDialog dialog = new InputDialog(getShell(),
						RequirementLinkerPlugin.getInstance()
								.getString("CategorySelectionPage_CreateCategoryDialog_title"), //$NON-NLS-1$
						RequirementLinkerPlugin.getInstance()
								.getString("CategorySelectionPage_CreateCategoryDialog_description"), //$NON-NLS-1$
						RequirementLinkerPlugin.getInstance()
								.getString("CategorySelectionPage_CreateCategoryDialog_defaultvalue"), //$NON-NLS-1$
						null);
				int open = dialog.open();
				if (open == Window.OK) {
					Category category = RequirementFactory.eINSTANCE.createCategory();
					category.setName(dialog.getValue());
					if (getTreeviewSelection() instanceof Category) {
						((Category) getTreeviewSelection()).getSubCategories().add(category);
					} else if (getTreeviewSelection() instanceof Repository) {
						((Repository) getTreeviewSelection()).getMainCategories().add(category);
					}
				}
			}

		});
		createCategorie.setEnabled(false);
		if (currentValue != null) {
			categoriesViewer.reveal(currentValue);
			categoriesViewer.setSelection(new StructuredSelection(currentValue));
		}
		setControl(control);
	}

	/**
	 * @return
	 */
	public Category getSelection() {
		return selectedCategory;
	}

	private EObject getTreeviewSelection() {
		if (categoriesViewer.getSelection() instanceof StructuredSelection) {
			Object selection = ((StructuredSelection) categoriesViewer.getSelection()).getFirstElement();
			if (selection instanceof EObject) {
				return (EObject) selection;
			}
		}
		return null;
	}

	public void init(EObject currentValue) {
		this.currentValue = currentValue;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return super.canFlipToNextPage();
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
