/*******************************************************************************
 * Copyright (c) 2008, 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.ui.dialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class EnvironmentUsedElementResourceWarning extends Dialog {

	private List<EObject> crossReferences;
	private List<Resource> roots;
	private ComposedAdapterFactory composedAdapterFactory;
	private String resourceAboutToBeRemovedName;

	/**
	 * Create the dialog.
	 * @param parentShell The parent shell
	 * @param roots The resources holding cross references
	 * @param crossReferences The cross references
	 */
	public EnvironmentUsedElementResourceWarning(Shell parentShell, List<Resource> roots, List<EObject> crossReferences, String resourceAboutToBeRemovedName) {
		super(parentShell);
		this.resourceAboutToBeRemovedName = resourceAboutToBeRemovedName;
		setShellStyle(SWT.SHELL_TRIM);
		this.crossReferences = crossReferences;
		this.roots = roots;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		newShell.setMinimumSize(new Point(640, 480));
		super.configureShell(newShell);
		newShell.setText("");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		Label lblTheResources = new Label(container, SWT.NONE);
		lblTheResources.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblTheResources.setText(String.format("The resource %1$s is about to be removed from project.\r\nSome of the contained elements are referenced:", this.resourceAboutToBeRemovedName));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TreeColumnLayout tcl_composite = new TreeColumnLayout();
		composite.setLayout(tcl_composite);
		
		TreeViewer treeViewer = new TreeViewer(composite, SWT.BORDER);
		treeViewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
		Tree tree = treeViewer.getTree();
		
		TreeColumn trclmnNewColumn = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn.setResizable(false);
		tcl_composite.setColumnData(trclmnNewColumn, new ColumnWeightData(1, 100, false));
		trclmnNewColumn.setText("New Column");
		
		Label lblAreYouSure = new Label(container, SWT.NONE);
		lblAreYouSure.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblAreYouSure.setText("Are you sure you want to remove references to those elements?");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("Note: changes will be applied but not saved.");
		
		
		this.composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		this.composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		treeViewer.setContentProvider(new EnvironmentUseTreeContentProvider());
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.composedAdapterFactory));
		
		treeViewer.setInput(roots);
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	/**
	 * {@link ITreeContentProvider} used to display containment relation between leaves and roots.
	 */
	private class EnvironmentUseTreeContentProvider implements ITreeContentProvider {
		
		public EnvironmentUseTreeContentProvider() {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection<?>) {
				return ((Collection<?>) inputElement).toArray();
			}
			return new Object[] {inputElement};
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Resource) {
				return ((Resource) parentElement).getContents().toArray();
			} else if (parentElement instanceof EObject) {
				// Use of the fragment URI to determine if an EObject is in the containment chain.
				EObject parentEObject = (EObject) parentElement;
				EList<EObject> potentialChildren = parentEObject.eContents();
				List<EObject> children = new ArrayList<>();
				for (EObject crossReference : crossReferences) {
					String source = EcoreUtil.getRelativeURIFragmentPath(null, crossReference);
					if (parentEObject.eResource().equals(crossReference.eResource())) {
						for (EObject potentialChild : potentialChildren) {
							String target = EcoreUtil.getRelativeURIFragmentPath(null, potentialChild);
							if (source.startsWith(target) && !children.contains(potentialChild)) {
								children.add(potentialChild);
							}
						}
					}
				}
				return children.toArray();
			}
			return new Object[0];
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof EObject) {
				return ((EObject) element).eContainer();
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof Resource) {
				return roots.contains(element);
			} else if (element instanceof EObject) {
				EObject eObject = (EObject) element;
				String target = EcoreUtil.getRelativeURIFragmentPath(null, eObject);
				return crossReferences.stream().filter(eo -> {
					String source = EcoreUtil.getRelativeURIFragmentPath(null, eo);
					return !source.equals(target) && source.startsWith(target);
				}).count() > 0;
			}
			return false;
		}
	}

}
