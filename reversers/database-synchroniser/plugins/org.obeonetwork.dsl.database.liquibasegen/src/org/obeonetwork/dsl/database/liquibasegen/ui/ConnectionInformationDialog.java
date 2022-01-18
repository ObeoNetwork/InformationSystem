/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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

/**
 * Creates a dialog for defining the identifiers of the database.
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a> 
 *         
 */
public class ConnectionInformationDialog extends Dialog {

	private String url;
	private String username;
	private String password;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 * @param url 
	 * @param username 
	 * @param password
	 */
	public ConnectionInformationDialog(Shell parentShell, String url, String username, String password) {
		super(parentShell);
		this.url = url;
		this.username = username;
		this.password = password;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setBounds(0, 0, 32, 32);
		
		Label lblNewLabel = new Label(composite, SWT.WRAP);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 100;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("URL");
		
		Text urlText = new Text(composite, SWT.BORDER);
		urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		urlText.setText(url);
		urlText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				url = ((Text) e.widget).getText();
			}
		});
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite_1.widthHint = 387;
		composite_1.setLayoutData(gd_composite_1);
		composite_1.setBounds(0, 0, 32, 32);
		
		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		GridData gd_lblNewLabel_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 100;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		lblNewLabel_1.setText("Username");
		
		Text usernameText = new Text(composite_1, SWT.BORDER);
		usernameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		usernameText.setText(username);
		usernameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				username = ((Text) e.widget).getText();
			}
		});
		
		Composite composite_2 = new Composite(container, SWT.NONE);
		composite_2.setLayout(new GridLayout(2, false));
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite_2.setBounds(0, 0, 32, 32);
		
		Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
		GridData gd_lblNewLabel_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_2.widthHint = 100;
		lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
		lblNewLabel_2.setText("Password");
		
		Text passwordText = new Text(composite_2, SWT.BORDER);
		passwordText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		passwordText.setText(password);
		passwordText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				password = ((Text) e.widget).getText();
			}
		});
		
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

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Liquibase update");
	}
	
	/**
	 * 
	 * @return url {@link String}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @return username {@link String}
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @return password {@link String}
	 * 
	 */
	public String getPassword() {
		return password;
	}
	
}
