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
package org.obeonetwork.acceleo.utils.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.obeonetwork.acceleo.utils.properties.util.AcceleoGenerationPropertiesHelper;

/**
 * @author Obeo
 *
 */
public class LaunchGenerationWizard extends Wizard {
	
	private GeneratorSelectionPage page;
	private IFile selectedFile;
	private AcceleoGenerationPropertiesHelper helper;
	private IProject generationTarget;
	
	/**
	 * @param helper 
	 * 
	 */
	public LaunchGenerationWizard(AcceleoGenerationPropertiesHelper helper, IFile selectedFile) {
		super();
		this.helper = helper;
		this.selectedFile = selectedFile;
		setWindowTitle("Acceleo generation");
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	public void addPages() {
		page = new GeneratorSelectionPage();
		addPage(page);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	public boolean canFinish() {
		return generationTarget != null;
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		return true;
	}

	public IProject getGenerationTarget() {
		return generationTarget;
	}
	
	private class GeneratorSelectionPage extends WizardPage {

		private TreeViewer viewer;

		/**
		 * @param pageName
		 */
		public GeneratorSelectionPage() {
			super("Generation settings");
			setTitle("Generation settings");
			setDescription("Defines your generation settings.");
		}

		/**
		 * {@inheritDoc}
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			Composite container = new Composite(parent, SWT.NONE);
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			container.setLayout(new GridLayout());
			Label label = new Label(container, SWT.NONE);
			label.setText("Select target project :");
			viewer = new TreeViewer(container);
			viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
			viewer.setContentProvider(new WorkbenchContentProvider());
			viewer.setLabelProvider(new WorkbenchLabelProvider());
			viewer.addFilter(new ViewerFilter() {
				
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return element instanceof IProject;
				}
			});
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				
				public void selectionChanged(SelectionChangedEvent event) {
					generationTarget = (IProject) ((StructuredSelection)page.viewer.getSelection()).getFirstElement();
					getWizard().getContainer().updateButtons();
				}
			});
			viewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
			viewer.setSelection(new StructuredSelection(mostAppropriatedProject()));
			viewer.expandAll();
			setControl(viewer.getControl());
		}

		protected IProject mostAppropriatedProject() {
			IProject project = null;
			try {
				project = helper.lastGenerationTarget();
			} catch (CoreException e) {
				// TODO throw error
				e.printStackTrace();
			}
			if (project == null) {
				project = selectedFile.getProject();
			}
			return project;
		}
	}
}
