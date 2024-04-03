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
package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.Objects;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SwaggerImportWizardPage extends WizardPage {
	
	private SwaggerImportWizard wizard;
	
	private DataBindingContext bindingContext;
	
	SwaggerImportWizardParameters model;
	
	private Text txtSwaggerFilePath;
	private Text txtPaginationExtension;

	private PropertyChangeListener swaggerFilePathModelListener;
	
	static class SwaggerImportWizardParameters {
		private String swaggerFilePath = "";
		private String paginationExtension = "";
		
		private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
		
		public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}

		public String getSwaggerFilePath() {
			return swaggerFilePath;
		}

		public void setSwaggerFilePath(String swaggerFilePath) {
			if(!Objects.equals(this.swaggerFilePath, swaggerFilePath)) 
				propertyChangeSupport.firePropertyChange("swaggerFilePath", this.swaggerFilePath, this.swaggerFilePath = swaggerFilePath); //$NON-NLS-1$
		}
		
		public String getPaginationExtension() {
			return paginationExtension;
		}

		public void setPaginationExtension(String paginationExtension) {
			if(!Objects.equals(this.paginationExtension, paginationExtension)) 
				propertyChangeSupport.firePropertyChange("paginationExtension", this.paginationExtension, this.paginationExtension = paginationExtension); //$NON-NLS-1$
		}
		
	}
	
	public SwaggerImportWizardPage(SwaggerImportWizard wizard) {
		super("swaggerImportWizardPage");
		setTitle("Swagger import");
		setDescription("Select file to import.");
		this.wizard = wizard;
		this.model = new SwaggerImportWizardParameters();
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblSwaggerFilePath = new Label(container, SWT.NONE);
		lblSwaggerFilePath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSwaggerFilePath.setText("Swagger file");
		
		txtSwaggerFilePath = new Text(container, SWT.BORDER);
		txtSwaggerFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSelectSwaggerFilePath = new Button(container, SWT.NONE);
		btnSelectSwaggerFilePath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(SwaggerImportWizardPage.this.getShell(), SWT.OPEN);
				dialog.setFilterExtensions(new String [] { "*.yaml;*.yml;*.json", "*.yaml;*.yml", "*.json" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				dialog.setFilterPath(model.getSwaggerFilePath());
				String swaggerFilePath = dialog.open();
				if(swaggerFilePath != null) {
					model.setSwaggerFilePath(swaggerFilePath);
				}
			}
		});
		btnSelectSwaggerFilePath.setText("...");
		
		model.setSwaggerFilePath(wizard.getDefaultInputDirPath());
		
		Label lblPaginationExtension = new Label(container, SWT.NONE);
		lblPaginationExtension.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPaginationExtension.setText("Pagination extension");
		
		txtPaginationExtension = new Text(container, SWT.BORDER);
		txtPaginationExtension.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		bindingContext = initDataBindings();
		
		swaggerFilePathModelListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setPageComplete(isComplete());
				if(!fileExists()) {
					setErrorMessage("Selected file does not exist.");
				} else {
					setErrorMessage(null);
				}
			}

		};
		model.addPropertyChangeListener("swaggerFilePath", swaggerFilePathModelListener); //$NON-NLS-1$
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		
		// swaggerFilePath
		IObservableValue observeTextSwaggerFilePathObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSwaggerFilePath);
		IObservableValue textTxtSwaggerFilePathObserveValue = BeanProperties.value("swaggerFilePath").observe(model);
		bindingContext.bindValue(observeTextSwaggerFilePathObserveWidget, textTxtSwaggerFilePathObserveValue, null, null);
		
		// paginationExtension
		IObservableValue observeTextTxtPaginationExtensionObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtPaginationExtension);
		IObservableValue textTxtPaginationExtensionObserveValue = BeanProperties.value("paginationExtension").observe(model);
		bindingContext.bindValue(observeTextTxtPaginationExtensionObserveWidget, textTxtPaginationExtensionObserveValue, null, null);
		
		return bindingContext;
	}

	private boolean fileExists() {
		File file = new File(model.getSwaggerFilePath());
		return file.exists() && file.isFile();
	}
	
	public boolean isComplete() {
		return fileExists();
	}

	@Override
	public void dispose() {
		model.removePropertyChangeListener(swaggerFilePathModelListener);
		bindingContext.dispose();
		
		super.dispose();
	}
	
	public String getSwaggerFilePath() {
		return model.getSwaggerFilePath();
	}

	public String getPaginationExtension() {
		return model.getPaginationExtension();
	}

}
