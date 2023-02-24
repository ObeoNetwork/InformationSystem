/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.requirement.ui.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.sirius.ui.tools.api.views.ViewHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.util.RequirementService;
import org.obeonetwork.tools.requirement.wizard.util.RequirementsRepositoriesContentProvider;

/**
 * The dialog opened when using the "Link Requirements with Selection" button in
 * the "Linked Requirements" view.
 *
 */
public class LinkRequirementsDialog extends TitleAreaDialog {

	/**
	 * The initial size of this dialog.
	 */
	private static final Point DIALOG_INITIAL_SIZE = new Point(900, 700);

	private AdapterFactory adapterFactory = ViewHelper.INSTANCE.createAdapterFactory();

	private CheckboxTreeViewer checkboxTreeViewer;
	private EObject selectedEObject;

	/**
	 * Creates this dialog.
	 * 
	 * @param parentShell
	 *            the hosting {@link Shell}.
	 * @param selectedEObject
	 *            the {@link EObject} selected by the user, used as context for
	 *            this dialog's contents.
	 */
	public LinkRequirementsDialog(Shell parentShell, EObject selectedEObject) {
		super(parentShell);
		super.setShellStyle(SWT.TITLE | SWT.APPLICATION_MODAL | SWT.RESIZE);
		this.selectedEObject = selectedEObject;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		super.setTitle(RequirementLinkerPlugin.getInstance().getString("LinkRequirementsDialog_title")); //$NON-NLS-1$

		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.marginHeight = 1;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		this.checkboxTreeViewer = createRequirementsTreeViewer(container, this.adapterFactory, this.selectedEObject);

		return container;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected Point getInitialSize() {
		return DIALOG_INITIAL_SIZE;
	}

	@Override
	protected void okPressed() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(this.selectedEObject);
		RecordingCommand cmd = new RecordingCommand(editingDomain, "Link Requirements") { //$NON-NLS-1$
			protected void doExecute() {
				// Clear all requirements links
				for (Requirement requirement : RequirementService
						.getLinkedRequirements(LinkRequirementsDialog.this.selectedEObject)) {
					requirement.getReferencedObject().remove(LinkRequirementsDialog.this.selectedEObject);
				}

				// Add new requirements links
				for (Object checkedElement : LinkRequirementsDialog.this.checkboxTreeViewer.getCheckedElements()) {
					if (checkedElement instanceof Requirement) {
						Requirement requirement = (Requirement) checkedElement;
						requirement.getReferencedObject().add(LinkRequirementsDialog.this.selectedEObject);
					}
				}
			}
		};
		editingDomain.getCommandStack().execute(cmd);
		super.okPressed();
	}

	/**
	 * Creates, in the given {@link Composite}, the {@link CheckBoxTreeViewer}
	 * allowing users to select and unselect {@link Requirement Requirements} to
	 * associate with the selected model element.
	 * 
	 * @param parent
	 *            the parent in which the {@link CheckboxTreeViewer} must be
	 *            created.
	 * @param adapterFactory
	 *            the {@link IAdapterFactory}.
	 * @param selectedEObject
	 *            the contextual {@link EObject}.
	 */
	private static CheckboxTreeViewer createRequirementsTreeViewer(Composite parent, AdapterFactory adapterFactory,
			EObject selectedEObject) {
		CheckboxTreeViewer checkBoxTreeViewer = new CheckboxTreeViewer(parent, SWT.MULTI | SWT.BORDER | SWT.CHECK);

		// Layout
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_tree.heightHint = 208;
		Tree tree = checkBoxTreeViewer.getTree();
		tree.setLayoutData(gd_tree);

		// Contents
		checkBoxTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		checkBoxTreeViewer.setContentProvider(new RequirementsRepositoriesContentProvider(adapterFactory));
		checkBoxTreeViewer.setInput(RequirementService.findRequirementsRepositories(selectedEObject));

		checkBoxTreeViewer.setCheckedElements(
				determineObjectsToCheck(RequirementService.getLinkedRequirementsSet(selectedEObject)).toArray());
		checkBoxTreeViewer.setGrayedElements(
				determineObjectsToGray(RequirementService.getLinkedRequirementsSet(selectedEObject)).toArray());

		// Expands the tree viewer up to all the checked elements. This way the
		// user can easily add or remove requirement links with requirements
		// which are located alongside already-checked requirements.
		expandTreeViewerUpToCheckedElements(checkBoxTreeViewer,
				Arrays.asList(RequirementService.getLinkedRequirements(selectedEObject)));

		checkBoxTreeViewer.addCheckStateListener(new LinkRequirementsCheckStateListener());

		return checkBoxTreeViewer;
	}

	/**
	 * Initially, we want to check:
	 * <ul>
	 * <li>the {@link Requirement Requirements} linked to the selected model
	 * element.</li>
	 * <li>the {@link Category Categories and sub-Categories} containing
	 * selected {@link Requirement Requirements}.</li>
	 * <li>the {@link Repository Repositories} containing selected
	 * {@link Requirement Requirements}.</li>
	 * <li>the {@link Resource Resources} containing selected {@link Requirement
	 * Requirements}.</li>
	 * </ul>
	 * 
	 * @param linkedRequirements
	 *            the {@link Requirement Requirements} linked to the selected
	 *            model element.
	 * @return the objects in the {@link CheckboxTreeViewer} which must be
	 *         checked initially.
	 */
	private static Set<Object> determineObjectsToCheck(Set<Requirement> linkedRequirements) {
		Set<Object> objectsToCheck = new HashSet<Object>();

		for (Requirement linkedRequirement : linkedRequirements) {
			// The linked Requirement.
			objectsToCheck.add(linkedRequirement);

			// The Categories and all its super-Categories.
			Category category = linkedRequirement.getCategory();
			objectsToCheck.add(category);
			while (category.getParentCategory() != null) {
				category = category.getParentCategory();
				objectsToCheck.add(category);
			}

			// The Repository
			Repository repository = category.getRepository();
			objectsToCheck.add(repository);

			// The Resource
			Resource resource = repository.eResource();
			objectsToCheck.add(resource);
		}

		return objectsToCheck;
	}

	/**
	 * We want to gray all checked elements but the {@link Requirement
	 * Requirements}.
	 * 
	 * @param linkedRequirements
	 *            the {@link Requirement Requirements} linked to the selected
	 *            model element.
	 * @return the objects in the {@link CheckboxTreeViewer} which must be
	 *         grayed initially.
	 */
	private static Set<Object> determineObjectsToGray(Set<Requirement> linkedRequirements) {
		Set<Object> objectsToGray = new HashSet<Object>();

		for (Object objectToCheck : determineObjectsToCheck(linkedRequirements)) {
			if (!(objectToCheck instanceof Requirement)) {
				objectsToGray.add(objectToCheck);
			}
		}

		return objectsToGray;
	}

	/**
	 * Expands a {@link TreeViewer} up to all the given elements.
	 * 
	 * @param treeViewer
	 * @param checkedElements
	 */
	private static void expandTreeViewerUpToCheckedElements(TreeViewer treeViewer, List<Requirement> checkedElements) {
		ITreeContentProvider contentProvider = (ITreeContentProvider) treeViewer.getContentProvider();

		// We need the unicity because there may be common ancestors in the tree
		// of several checked elements. We also need the insertion order because
		// we need to expand the higher nodes first.
		LinkedHashSet<Object> treeOfElements = new LinkedHashSet<Object>();
		for (Requirement checkedElement : checkedElements) {
			Object element = checkedElement;
			while (contentProvider.getParent(element) != null) {
				treeOfElements.add(element);
				element = contentProvider.getParent(element);
			}
		}
		// Reverse the order to start with the root element (the EMF Resource).
		List<Object> elementsToExpand = new ArrayList<Object>(treeOfElements);
		Collections.reverse(elementsToExpand);
		treeViewer.setExpandedElements(elementsToExpand.toArray());
	}
}
