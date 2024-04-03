/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.ecorebinding.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

public class EcoreSelectionWizardPage extends WizardPage implements IWizardPage {

	private IPath ecoreFilePath;
	private Text pathField;
	
	public EcoreSelectionWizardPage() {
		super("");
	}
	
	public EcoreSelectionWizardPage(IPath ecorePath) {
		this();
		this.ecoreFilePath = ecorePath;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
		Group projectGroup = new Group(composite, SWT.NONE);
		projectGroup.setText("Ecore model to bind"); //$NON-NLS-1$
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project name entry field
		pathField = new Text(projectGroup, SWT.BORDER);
		if (ecoreFilePath != null) {
			pathField.setText(ecoreFilePath.toString());
		}
		GridData data = new GridData(GridData.FILL_HORIZONTAL);

		final int width = 250;
		data.widthHint = width;
		pathField.setLayoutData(data);
		pathField.setFont(parent.getFont());
		pathField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				boolean validatePage = validatePage();
				setPageComplete(validatePage);
			}
		});
		Button modelButton = new Button(projectGroup, SWT.PUSH);
		modelButton.setText("Search"); //$NON-NLS-1$
		modelButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				/*
				 * Empty by default
				 */
			}

			public void widgetSelected(SelectionEvent e) {
				handleBrowseModelTargetButton();
			}
		});
		this.validatePage();
		
		this.setControl(composite);
	}
	
	
	public IPath getEcoreFilePath() {
		return ecoreFilePath;
	}
	
	private void handleBrowseModelTargetButton() {
		FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(getShell(), false,
				ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		
		dialog.setTitle("Select the ecore model"); //$NON-NLS-1$

		String path = pathField.getText();
		if (path != null && path.length() > 0 && new Path(path).lastSegment().length() > 0 && "ecore".equals(new Path(path).lastSegment())) {
			dialog.setInitialPattern(new Path(path).lastSegment());
		}

		dialog.open();
		if (dialog.getResult() != null && dialog.getResult().length > 0
				&& dialog.getResult()[0] instanceof IFile) {
			pathField.setText(((IFile)dialog.getResult()[0]).getName());
		}
	}
	
	public boolean validatePage() {
		return true;
	}
}
