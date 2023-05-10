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
package org.obeonetwork.database.ui.wizards.imports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2_13;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL_8;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB_106;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE_21C;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES_14;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER_2008;
import org.obeonetwork.database.ui.dialogs.FileExtensionsViewerFilter;
import org.obeonetwork.database.ui.dialogs.SpecificWorkspaceResourceDialog;
import org.obeonetwork.utils.common.ui.services.WizardHelper;


@SuppressWarnings("deprecation")
public class DatabaseImportWizardPage extends WizardPage {
	
	private static final String DATABASE_FILE_EXTENSION = "database";

	private static final String[] DB_VENDOR_CHOICES = new String[]{DB_H2_13, DB_MYSQL_8, DB_MARIADB_106, DB_POSTGRES_14, DB_SQLSERVER_2008, DB_ORACLE_21C};
	
	// Model
	private DatabaseInfos databaseInfos;
	private Collection<IFile> referencedFiles = new ArrayList<IFile>();
	
	private Label lblError;
	private Combo comboDbVendor;
	private Text txtHost;
	private Text txtPort;
	private Text txtDatabase;
	private Text txtSchema;
	private Text txtUser;
	private Text txtPassword;
	private Text txtUrl;
	private StyledText txtModelFile;
	private ListViewer listReferencedModelFiles;
	
	public DatabaseImportWizardPage(String pageName, DatabaseInfos databaseInfos) {
		super(pageName);
		setTitle(pageName); //NON-NLS-1
		setDescription("Import the contents of a database into a database model"); //NON-NLS-1
		
		this.databaseInfos = databaseInfos;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls(org.eclipse.swt.widgets.Composite)
	 */	
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		
		lblError = new Label(composite, SWT.NONE);
		lblError.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblError.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label lblDbVendor = new Label(composite, SWT.NONE);
		lblDbVendor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblDbVendor.setText("DB Vendor :");
		
		comboDbVendor = new Combo(composite, SWT.NONE);
		comboDbVendor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblHost = new Label(composite, SWT.NONE);
		lblHost.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblHost.setText("Host :");
		
		txtHost = new Text(composite, SWT.BORDER);
		txtHost.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblPort = new Label(composite, SWT.NONE);
		lblPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblPort.setText("Port :");
		
		txtPort = new Text(composite, SWT.BORDER);
		txtPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		final Label lblDatabase = new Label(composite, SWT.NONE);
		lblDatabase.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblDatabase.setText("Database :");
		
		txtDatabase = new Text(composite, SWT.BORDER);
		txtDatabase.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblSchema = new Label(composite, SWT.NONE);
		lblSchema.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblSchema.setText("Schema :");
		
		txtSchema = new Text(composite, SWT.BORDER);
		txtSchema.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblUser = new Label(composite, SWT.NONE);
		lblUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblUser.setText("User :");
		
		txtUser = new Text(composite, SWT.BORDER);
		txtUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblPassword = new Label(composite, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblPassword.setText("Password :");
		
		txtPassword = new Text(composite, SWT.BORDER);
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblUrl = new Label(composite, SWT.NONE);
		lblUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblUrl.setText("URL :");
		
		txtUrl = new Text(composite, SWT.BORDER);
		txtUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		comboDbVendor.setItems(DB_VENDOR_CHOICES);
		comboDbVendor.addSelectionListener(new SelectionAdapter() {
						
			public void widgetSelected(SelectionEvent e) {
				txtSchema.setEnabled(!DB_MYSQL_8.equals(comboDbVendor.getText()));
				txtSchema.setEnabled(!DB_MARIADB_106.equals(comboDbVendor.getText()));
				
				txtHost.setEnabled(!DB_H2_13.equals(comboDbVendor.getText()));
				txtPort.setEnabled(!DB_H2_13.equals(comboDbVendor.getText()));
				
			}
		});
		
		txtSchema.setEnabled(!DB_MYSQL_8.equals(comboDbVendor.getText()));
		txtSchema.setEnabled(!DB_MARIADB_106.equals(comboDbVendor.getText()));
		
		Label lblModelFile = new Label(composite, SWT.NONE);
		lblModelFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblModelFile.setText("New model file :");
		
		txtModelFile = new StyledText(composite, SWT.BORDER);
		txtModelFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtModelFile.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				WizardHelper.addExtensionIfMissing(txtModelFile, "."+DATABASE_FILE_EXTENSION);
				setPageComplete(checkStatus());
			}
		});
		
		Button btnBrowseFile = new Button(composite, SWT.NONE);
		btnBrowseFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnBrowseFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Collection<ViewerFilter> filters = new ArrayList<ViewerFilter>();
				filters.add(new FileExtensionsViewerFilter(new String[]{DATABASE_FILE_EXTENSION}));
				IResource selectedResource = SpecificWorkspaceResourceDialog.openFileSelection(getShell(),
																					"Output model",
																					"Specify the file to create",
																					new Path(txtModelFile.getText()),
																					filters,
																					DATABASE_FILE_EXTENSION);
				if (selectedResource != null) {
					txtModelFile.setText(selectedResource.getFullPath().toString());
				}
			}
		});
		btnBrowseFile.setText("Browse...");
		btnBrowseFile.setSize(62, 23);
		
		Label lblReferencedModelFiles = new Label(composite, SWT.NONE);
		lblReferencedModelFiles.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblReferencedModelFiles.setText("Referenced files :");
		
		final List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		filters.add(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof IFile) {
					IResource workspaceResource = (IResource)element;
					return !referencedFiles.contains(workspaceResource)
						&& DATABASE_FILE_EXTENSION.equals(workspaceResource.getFileExtension());
				}
				return true;
			}
			
		});
		
		Button btnAddReferencedFile = new Button(composite, SWT.NONE);
		btnAddReferencedFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnAddReferencedFile.setText("Add...");
		btnAddReferencedFile.setSize(62, 23);
		btnAddReferencedFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IFile[] selectedFiles = WorkspaceResourceDialog.openFileSelection(getShell(), 
						"Add referenced file", "Select the referenced files (*." + DATABASE_FILE_EXTENSION + ")", 
						true, null, filters);
				for (IFile selectedFile : selectedFiles) {
					referencedFiles.add(selectedFile);
				}
				listReferencedModelFiles.refresh();
			}
		});
		
		Button btnRemoveReferencedFile = new Button(composite, SWT.NONE);
		btnRemoveReferencedFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnRemoveReferencedFile.setText("Remove");
		btnRemoveReferencedFile.setSize(62, 23);
		btnRemoveReferencedFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selectedFile = (StructuredSelection)listReferencedModelFiles.getSelection();
				if (selectedFile.getFirstElement() instanceof IFile) {
					referencedFiles.remove((IFile)selectedFile.getFirstElement());
					listReferencedModelFiles.refresh();
				}
			}
		});
		
		listReferencedModelFiles = new ListViewer(composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listReferencedModelFiles.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		listReferencedModelFiles.setContentProvider(new ArrayContentProvider());
		listReferencedModelFiles.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				IFile file = (IFile)element;
				return file.getFullPath().toString();
			}
		});
		
		setControl(composite);
		initInput();
		bindValues();
	}
	
	private void initInput() {
		comboDbVendor.select(Arrays.asList(DB_VENDOR_CHOICES).indexOf(databaseInfos.getVendor()));
		txtHost.setText(databaseInfos.getHost());
		txtPort.setText(databaseInfos.getPort());
		txtDatabase.setText(databaseInfos.getDatabase());
		txtSchema.setText(databaseInfos.getSchema());
		txtUser.setText(databaseInfos.getUser());
		txtPassword.setText(databaseInfos.getPassword());
		txtUrl.setText(databaseInfos.getUrl());
		txtSchema.setEnabled(!DB_MYSQL_8.equals(comboDbVendor.getText()));
		txtSchema.setEnabled(!DB_MARIADB_106.equals(comboDbVendor.getText()));
		listReferencedModelFiles.setInput(referencedFiles);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void bindValues() {
		// The DataBindingContext object will manage the databindings
		// Lets bind it
		DataBindingContext ctx = new DataBindingContext();
		
		IObservableValue widgetValue = WidgetProperties.selection().observe(comboDbVendor);
		IObservableValue modelValue = BeansObservables.observeValue(databaseInfos, "vendor");
		ctx.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).observe(txtHost);
		modelValue = BeanProperties.value(DatabaseInfos.class, "host").observe(databaseInfos);
		ctx.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).observe(txtPort);
		modelValue = BeanProperties.value(DatabaseInfos.class, "port").observe(databaseInfos);
		ctx.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).observe(txtDatabase);
		modelValue = BeanProperties.value(DatabaseInfos.class, DATABASE_FILE_EXTENSION).observe(databaseInfos);
		ctx.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).observe(txtSchema);
		modelValue = BeanProperties.value(DatabaseInfos.class, "schema").observe(databaseInfos);
		ctx.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).observe(txtUser);
		modelValue = BeanProperties.value(DatabaseInfos.class, "user").observe(databaseInfos);
		ctx.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).observe(txtPassword);
		modelValue = BeanProperties.value(DatabaseInfos.class, "password").observe(databaseInfos);
		ctx.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).observe(txtUrl);
		modelValue = BeanProperties.value(DatabaseInfos.class, "url").observe(databaseInfos);
		ctx.bindValue(widgetValue, modelValue);
	}

	public boolean checkStatus() {
		boolean status = false;
		
		String modelFilename = txtModelFile.getText();
		
		String errorMsg = "";
		if (modelFilename != null && modelFilename.trim().length() > 0) {
				// File extensions must be correct
			if (modelFilename.endsWith("." + DATABASE_FILE_EXTENSION)) {
				// The file should not already exist
				final IFile generatedFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelFilename));
				if (generatedFile.exists()){
					errorMsg = "The file should not already exist";
				} else {
					status = true;
				}
			} else {
				errorMsg = "The model file must end with \"." + DATABASE_FILE_EXTENSION + "\" extension";
			}
		} else {
			errorMsg = "The model file (." + DATABASE_FILE_EXTENSION + ") is required";
		}
		
		// Set or unset the error message
		lblError.setText(errorMsg);
		
		return status;
	}
	
	public String getModelFilePath() {
		return txtModelFile.getText();
	}
	
	public Collection<IFile> getReferencedFiles() {
		return referencedFiles;
	}

}
