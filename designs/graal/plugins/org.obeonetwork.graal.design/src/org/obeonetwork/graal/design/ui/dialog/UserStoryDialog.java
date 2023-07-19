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
package org.obeonetwork.graal.design.ui.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.graal.UserStory;

/**
 * @author Obeo
 *
 */
public class UserStoryDialog extends Dialog {
	
	private String name;
	private String description;
	private UserStory currentStory;

	/**
	 * @param parentShell
	 */
	public UserStoryDialog(Shell parentShell) {
		super(parentShell);
	}
	
	public UserStoryDialog(Shell activeShell, UserStory userStory) {
		this(activeShell);
		this.currentStory = userStory;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.Dialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control createContents = super.createContents(parent);
		updateButton();
		return createContents;
	}



	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = initDialogContainer(parent);
		Label nameLabel = new Label(container, SWT.NONE);
		nameLabel.setText("Name : ");
		nameLabel.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT));
		final Text nameText = new Text(container, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(data);
		Label descriptionLabel = new Label(container, SWT.NONE);
		descriptionLabel.setText("Description : ");
		GridData gd = new GridData();
		gd.verticalAlignment = SWT.TOP;
		descriptionLabel.setLayoutData(gd);
		final Text descriptionText = new Text(container, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		GridData data2 = new GridData(GridData.FILL_BOTH);
		descriptionText.setLayoutData(data2);
		if (currentStory != null) {
			if (currentStory.getName() != null) {
				nameText.setText(currentStory.getName());
				name = currentStory.getName();
			}
			if (currentStory.getDescription() != null) {
				descriptionText.setText(currentStory.getDescription());
				description = currentStory.getDescription();
			}
		}
		nameText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				name = nameText.getText();
				updateButton();
			}
		});
		descriptionText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				description = descriptionText.getText();
			}
		});
		return container;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	private Composite initDialogContainer(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout gl_container_1 = new GridLayout(2, false);
		gl_container_1.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		gl_container_1.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		gl_container_1.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		gl_container_1.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		container.setLayout(gl_container_1);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		applyDialogFont(container);
		return container;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(new Point(450, 300));
		newShell.setText("User Story");
	}

	public void updateButton() {
		if (name == null || "".equals(name)) {
			getButton(OK).setEnabled(false);
		} else {
			getButton(OK).setEnabled(true);			
		}
	}
		

}
