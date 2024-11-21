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
package org.obeonetwork.dsl.database.liquibasegen.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
/**
 * Creates a dialog for getting options for Liquibase generation.
 * 
 * @author Obeo
 *         
 */
public class LiquibaseGenerationOptionsDialog extends Dialog {

	private boolean createSchemaIfNotExists;
	private boolean isOracleDatabase;
	

	public LiquibaseGenerationOptionsDialog(Shell parentShell, boolean createSchemaIfNotExists, boolean isOracleDatabase) {
		super(parentShell);
		this.createSchemaIfNotExists = createSchemaIfNotExists;
		this.isOracleDatabase = isOracleDatabase;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(1,false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		composite.setBounds(0, 0, 32, 32);
		
		Button createSchemaIfNotExistCheckBox =  new Button(parent, SWT.CHECK);
		createSchemaIfNotExistCheckBox.setText("Create schema(s)"+(isOracleDatabase ? "" :" if none exist"));
		GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gridData.heightHint = 50;
		createSchemaIfNotExistCheckBox.setLayoutData(gridData);
		createSchemaIfNotExistCheckBox.setSelection(createSchemaIfNotExists);
		createSchemaIfNotExistCheckBox.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent event) {
	            Button btn = (Button) event.getSource();
	            createSchemaIfNotExists = btn.getSelection();
	        }
	    });
		
		return container;
	}
	
	/**
	 * 
	 * @return createSchemaIfNotExists {@link Boolean}
	 */
	public boolean getCreateSchemaIfNotExists() {
		return createSchemaIfNotExists;
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
		return new Point(350, 150);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Liquibase generation options");
	}
}
