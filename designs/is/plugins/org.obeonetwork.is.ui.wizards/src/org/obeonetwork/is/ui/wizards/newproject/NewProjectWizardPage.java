/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.is.ui.wizards.newproject;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This wizard page allows setting the name for the project to be created.
 */

public class NewProjectWizardPage extends WizardPage {
	private Label lblProjectName;
	private Text projectNameText;
	private Label lblNameExample;
	private Label lblPrjectPrefix;
	private Text projectPrefixText;
	private Label lblPrefixExample;

	/**
	 * Constructor.
	 */
	public NewProjectWizardPage() {
		super("newISProjectWizardPage"); //$NON-NLS-1$
		setTitle(Messages.wizard_title);
		setDescription(Messages.wizard_description);
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite projectName = new Composite(parent, SWT.NULL);
		GridLayout gl_projectName = new GridLayout();
		projectName.setLayout(gl_projectName);
		gl_projectName.numColumns = 3;
		gl_projectName.verticalSpacing = 9;

		lblProjectName = new Label(projectName, SWT.NULL);
		lblProjectName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProjectName.setText(Messages.wizard_project_name_label);

		projectNameText = new Text(projectName, SWT.BORDER | SWT.SINGLE);
		projectNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		projectNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		lblNameExample = new Label(projectName, SWT.NONE);
		lblNameExample.setText(Messages.wizard_project_name_example_label);
		
		lblPrjectPrefix = new Label(projectName, SWT.NONE);
		lblPrjectPrefix.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrjectPrefix.setText(Messages.wizard_project_prefix_label);
		
		projectPrefixText = new Text(projectName, SWT.BORDER);
		projectPrefixText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		projectPrefixText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		lblPrefixExample = new Label(projectName, SWT.NONE);
		lblPrefixExample.setText(Messages.wizard_project_prefix_example_label);
		
		dialogChanged();
		setControl(projectName);
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		if (getProjectName().length() == 0) {
			updateStatus(Messages.wizard_error_name_is_required);
			return;
		}
		
		if (getProjectPrefix().length() == 0) {
			updateStatus(Messages.wizard_error_prefix_is_required);
			return;
		}
		
		IResource project = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getProjectFullName()));
		
		if (project != null && (project.getType() & IResource.PROJECT) != 0) {
			updateStatus(Messages.wizard_error_project_already_exists);
			return;
		}
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getProjectName() {
		return projectNameText.getText();
	}
	
	public String getProjectPrefix() {
		return projectPrefixText.getText();
	}
	
	public String getProjectFullName() {
		return getProjectPrefix() + "." + getProjectName();
	}
}