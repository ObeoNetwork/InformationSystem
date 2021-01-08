/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.ui.dialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.design.ui.providers.RootElement;
import org.obeonetwork.graal.design.ui.providers.TasksContentProvider;
import org.obeonetwork.graal.provider.GraalItemProviderAdapterFactory;
import org.obeonetwork.graal.util.GraalAdapterFactory;

/**
 * Dialog allowing the user to select the tasks concerned by the creatio of an "use" relationship
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class CreateUseRelationshipDialog extends Dialog {

	private EObject source;
	private EObject target;
	private GraalAdapterFactory adapterFactory;
	
	private TreeViewer treeSourceViewer;
	private TreeViewer treeTargetViewer;
	private Button okButton;
	
	private List<Task> selectedTasksAsSource = new ArrayList<Task>();
	private List<Task> selectedTasksAsTarget = new ArrayList<Task>();
	
	/**
	 * Creates the dialog.
	 * @param parentShell
	 */
	public CreateUseRelationshipDialog(Shell parentShell) {
		super(parentShell);
	}
	
	public CreateUseRelationshipDialog(Shell parentShell, EObject source, EObject target) {
		this(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.source = source;
		this.target = target;
		adapterFactory = new GraalItemProviderAdapterFactory();
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Choose tasks to create a new Use relationship");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));
		
		Label lblSource = new Label(container, SWT.NONE);
		lblSource.setText("Source :");
		
		Label lblTarget = new Label(container, SWT.NONE);
		lblTarget.setText("Target :");
		
		treeSourceViewer = new TreeViewer(container, SWT.BORDER | SWT.MULTI);
		treeSourceViewer.setContentProvider(new TasksContentProvider());
		treeSourceViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeSourceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@SuppressWarnings("rawtypes")
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection().isEmpty()) {
					selectedTasksAsSource.clear();
				} else if(event.getSelection() instanceof IStructuredSelection) {
					selectedTasksAsSource.clear();
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
						Object domain = (Object)iterator.next();
						if (domain instanceof Task) {
							selectedTasksAsSource.add((Task)domain);
						}
					}
				}
				computeOkButtonState();
			}
		});
		treeSourceViewer.setInput(new RootElement(this.source));
		treeSourceViewer.setSelection(new StructuredSelection(this.source), true);
		Tree treeSource = treeSourceViewer.getTree();
		treeSource.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		treeTargetViewer = new TreeViewer(container, SWT.BORDER | SWT.MULTI);
		treeTargetViewer.setContentProvider(new TasksContentProvider());
		treeTargetViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeTargetViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@SuppressWarnings("rawtypes")
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection().isEmpty()) {
					selectedTasksAsTarget.clear();
				} else if(event.getSelection() instanceof IStructuredSelection) {
					selectedTasksAsTarget.clear();
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
						Object domain = (Object)iterator.next();
						if (domain instanceof Task) {
							selectedTasksAsTarget.add((Task)domain);
						}
					}
				}
				 computeOkButtonState();
			}
		});
		treeTargetViewer.setInput(new RootElement(this.target));
		treeTargetViewer.setSelection(new StructuredSelection(this.target), true);
		Tree treeTarget = treeTargetViewer.getTree();
		treeTarget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		return container;
	}
	
	/**
	 * Computes the enabled/disabled state of the "OK" button
	 * depending on the selection made by the user
	 */
	private void computeOkButtonState() {
		if (okButton != null) {
			okButton.setEnabled(!selectedTasksAsSource.isEmpty() && !selectedTasksAsTarget.isEmpty());
		}
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		computeOkButtonState();
	}

	/**
	 * Return the initial size of the dialog.
	 * @return initial size
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(628, 409);
	}

	/**
	 * Returns the task selected as the source of the relationship
	 * @return selected Tasl
	 */
	public List<Task> getSelectedTasksAsSource() {
		return selectedTasksAsSource;
	}

	/**
	 * Returns the task selected as the target of the relationship
	 * @return selected Task
	 */
	public List<Task> getSelectedTasksAsTarget() {
		return selectedTasksAsTarget;
	}
	
}
