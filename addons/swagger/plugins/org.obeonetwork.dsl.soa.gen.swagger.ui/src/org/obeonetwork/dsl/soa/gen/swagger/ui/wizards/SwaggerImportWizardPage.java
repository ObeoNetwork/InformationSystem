/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
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
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerFileQuery;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SwaggerImportWizardPage extends WizardPage {

	private SwaggerImportWizard wizard;

	private DataBindingContext bindingContext;

	private SwaggerImportWizardModel model;

	private Text txtSwaggerFilePath;
	private Text txtPaginationExtension;
	private Label inputVersionLabel;

	private PropertyChangeListener swaggerFilePathModelListener;

	static class SwaggerImportWizardModel {
		private String swaggerFilePath = "";
		private String paginationExtension = "";
		private String validInputVersion = null;

		private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

		public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}

		public static final String SWAGGER_FILE_PATH_PROP = "swaggerFilePath";
		
		public String getSwaggerFilePath() {
			return swaggerFilePath;
		}

		public void setSwaggerFilePath(String swaggerFilePath) {
			if (!Objects.equals(this.swaggerFilePath, swaggerFilePath))
				propertyChangeSupport.firePropertyChange(SWAGGER_FILE_PATH_PROP, this.swaggerFilePath, //$NON-NLS-1$
						this.swaggerFilePath = swaggerFilePath);
		}

		public static final String PAGINATION_EXTENSION_PROP = "paginationExtension";
		
		public String getPaginationExtension() {
			return paginationExtension;
		}

		public void setPaginationExtension(String paginationExtension) {
			if (!Objects.equals(this.paginationExtension, paginationExtension))
				propertyChangeSupport.firePropertyChange(PAGINATION_EXTENSION_PROP, this.paginationExtension, //$NON-NLS-1$
						this.paginationExtension = paginationExtension);
		}

		public String getValidInputVersion() {
			return validInputVersion;
		}

		public void setValidInputVersion(String version) {
			validInputVersion = version;
		}

	}

	public SwaggerImportWizardPage(SwaggerImportWizard wizard) {
		super("swaggerImportWizardPage");
		setTitle("Swagger import");
		setDescription("Select file to import.");
		this.wizard = wizard;
		this.model = new SwaggerImportWizardModel();
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
				dialog.setFilterExtensions(new String[] { "*.yaml;*.yml;*.json", "*.yaml;*.yml", "*.json" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				dialog.setFilterPath(model.getSwaggerFilePath());
				String swaggerFilePath = dialog.open();
				if (swaggerFilePath != null) {
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
				setPageComplete(false);
				// Check file exits
				if (!fileExists()) {
					setErrorMessage("Selected file does not exist.");
					resetInputVersionLabel();
					return;
				}
				// Validate file content.
				SwaggerFileQuery fileQuery = null;
				try {
					File inputFile = new File(model.getSwaggerFilePath());
					fileQuery = new SwaggerFileQuery(inputFile);
				} catch (JsonProcessingException e) {
					setErrorMessage("Selected file content is not valid. See error log.");
					logError(String.format("Invalid file content : %s.", model.getSwaggerFilePath()), e);
				} catch (IOException e) {
					setErrorMessage("Selected file content cannot be processed. See error log.");
					logError(String.format("Cannot validate file content : %s.", model.getSwaggerFilePath()), e);
				}
				if (fileQuery == null) {
					resetInputVersionLabel();
					setPageComplete(false);
					return;
				}
				setErrorMessage(null);
				String inputVersion = fileQuery.getVersion();
				boolean supportedVersion = SwaggerFileQuery.isVersionSupported(inputVersion);
				if (supportedVersion) {
					model.setValidInputVersion(inputVersion);
				} else {
					model.setValidInputVersion(null);
				}
				if (inputVersionLabel != null) {
					if (!supportedVersion) {
						inputVersionLabel.setText("Not supported");
					} else {
						inputVersionLabel.setText(inputVersion);
					}
				}
				setPageComplete(isComplete());
			}

		};
		model.addPropertyChangeListener(SwaggerImportWizardModel.SWAGGER_FILE_PATH_PROP, swaggerFilePathModelListener); //$NON-NLS-1$

		Label labelInputVersion = new Label(container, SWT.NONE);
		labelInputVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelInputVersion.setText("Input version:");

		inputVersionLabel = new Label(container, SWT.WRAP);
		inputVersionLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));

		Label supportedVersions = new Label(container, SWT.BOTTOM | SWT.BOLD);
		supportedVersions.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		supportedVersions.setText("Supported versions:");
		supportedVersions.setForeground(container.getDisplay().getSystemColor(SWT.COLOR_WIDGET_DARK_SHADOW));

		Label supportedVersionsText = new Label(container, SWT.NONE);
		supportedVersionsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		supportedVersionsText.setText(SwaggerFileQuery.getSupportedVersions().toString());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();

		// swaggerFilePath
		IObservableValue observeTextSwaggerFilePathObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSwaggerFilePath);
		IObservableValue textTxtSwaggerFilePathObserveValue = BeanProperties.value(SwaggerImportWizardModel.SWAGGER_FILE_PATH_PROP).observe(model);
		bindingContext.bindValue(observeTextSwaggerFilePathObserveWidget, textTxtSwaggerFilePathObserveValue, null, null);

		// paginationExtension
		IObservableValue observeTextTxtPaginationExtensionObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtPaginationExtension);
		IObservableValue textTxtPaginationExtensionObserveValue = BeanProperties.value(SwaggerImportWizardModel.PAGINATION_EXTENSION_PROP).observe(model);
		bindingContext.bindValue(observeTextTxtPaginationExtensionObserveWidget, textTxtPaginationExtensionObserveValue, null, null);

		return bindingContext;
	}

	private boolean fileExists() {
		File file = new File(model.getSwaggerFilePath());
		return file.exists() && file.isFile();
	}

	public boolean isComplete() {
		return fileExists() && model.getValidInputVersion() != null;
	}

	private void resetInputVersionLabel() {
		if (inputVersionLabel != null) {
			inputVersionLabel.setText("");
		}
		if (model != null) {
			model.setValidInputVersion(null);
		}
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
