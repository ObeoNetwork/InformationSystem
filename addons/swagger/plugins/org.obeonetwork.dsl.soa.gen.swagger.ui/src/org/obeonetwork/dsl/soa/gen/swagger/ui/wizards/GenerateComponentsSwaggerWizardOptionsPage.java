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
package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter.MapperType;
import org.obeonetwork.utils.common.StringUtils;

public class GenerateComponentsSwaggerWizardOptionsPage extends WizardPage {

	@SuppressWarnings("unused")
	private GenerateComponentsSwaggerWizard wizard;
	
	private DataBindingContext bindingContext;
	
	private GenerateSwaggerWizardParameters model;
	
	private Text txtOutputDirPath;
	private Combo comboMapperType;
	
	private ComboViewer comboMapperTypeViewer;

	private PropertyChangeListener outputDirPathModelListener;

	
	static class GenerateSwaggerWizardParameters {
		private String outputDirPath = ""; //$NON-NLS-1$
		private MapperType mapperType = MapperType.YAML;
		
		private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
		
		public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}

		public String getOutputDirPath() {
			return outputDirPath;
		}

		public void setOutputDirPath(String outputDirPath) {
			if(!Objects.equals(this.outputDirPath, outputDirPath)) 
				propertyChangeSupport.firePropertyChange("outputDirPath", this.outputDirPath, this.outputDirPath = outputDirPath); //$NON-NLS-1$
		}

		public MapperType getMapperType() {
			return mapperType;
		}

		public void setMapperType(MapperType mapperType) {
			if(this.mapperType != mapperType) 
				propertyChangeSupport.firePropertyChange("mapperType", this.mapperType, this.mapperType = mapperType); //$NON-NLS-1$
		}
		
	}
	
	public GenerateComponentsSwaggerWizardOptionsPage(GenerateComponentsSwaggerWizard wizard) {
		super("generateSwaggerWizardOptionsPage"); //$NON-NLS-1$
		setTitle(wizard.getWindowTitle());
		setDescription(Messages.GenerateComponentsSwaggerWizardOptionsPage_Description);
		this.wizard = wizard;
		this.model = new GenerateSwaggerWizardParameters();
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblOutputDirPath = new Label(container, SWT.NONE);
		lblOutputDirPath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOutputDirPath.setText(Messages.GenerateComponentsSwaggerWizardOptionsPage_Label_Export_directory);
		
		txtOutputDirPath = new Text(container, SWT.BORDER);
		txtOutputDirPath.setText(Messages.GenerateComponentsSwaggerWizardOptionsPage_Label_Export_directory);
		txtOutputDirPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSelectOutputDirPath = new Button(container, SWT.NONE);
		btnSelectOutputDirPath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(GenerateComponentsSwaggerWizardOptionsPage.this.getShell(), SWT.OPEN);
				model.setOutputDirPath(dialog.open());
			}
		});
		btnSelectOutputDirPath.setText("..."); //$NON-NLS-1$
		
		LabelProvider enumLabelProvider = new LabelProvider() {

			@Override
			public String getText(Object element) {
				return StringUtils.upperFirst(element.toString().toLowerCase());
			}
			
		};
		
		Label lblMapperType = new Label(container, SWT.NONE);
		lblMapperType.setText(Messages.GenerateComponentsSwaggerWizardOptionsPage_Label_Output_format);
		
		comboMapperTypeViewer = new ComboViewer(container, SWT.NONE);
		comboMapperTypeViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboMapperTypeViewer.setLabelProvider(enumLabelProvider);
		comboMapperTypeViewer.setInput(sortArray(MapperType.values()));
		comboMapperType = comboMapperTypeViewer.getCombo();
		comboMapperType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		bindingContext = initDataBindings();
		
		outputDirPathModelListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setPageComplete(isComplete());
			}

		};
		model.addPropertyChangeListener("outputDirPath", outputDirPathModelListener); //$NON-NLS-1$
	}

	private <T> T[] sortArray(T[] values) {
		Arrays.sort(values, (a, b) -> a.toString().compareTo(b.toString()));
		return values;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		
		// outputDirPath
		IObservableValue observeTextOutputDirPathObserveWidget = WidgetProperties.text(SWT.FocusOut).observe(txtOutputDirPath);
		IObservableValue textOutputDirPathPathModelObserveValue = BeanProperties.value("outputDirPath").observe(model); //$NON-NLS-1$
		bindingContext.bindValue(observeTextOutputDirPathObserveWidget, textOutputDirPathPathModelObserveValue, null, null);
		
		// mapperType
		IObservableValue<MapperType> comboMapperTypeViewerObservable = ViewerProperties.singleSelection().observe(comboMapperTypeViewer);
		IObservableValue mapperTypeModelObserveValue = BeanProperties.value(GenerateSwaggerWizardParameters.class, "mapperType").observe(model); //$NON-NLS-1$
		bindingContext.bindValue(comboMapperTypeViewerObservable, mapperTypeModelObserveValue);
		
		return bindingContext;
	}
	
	public boolean isComplete() {
		return model.getOutputDirPath() != null && new File(model.getOutputDirPath()).isDirectory();
	}
	
	@Override
	public void dispose() {
		model.removePropertyChangeListener(outputDirPathModelListener);
		bindingContext.dispose();
		
		super.dispose();
	}

	public MapperType getMapperType() {
		return model.getMapperType();
	}

	public String getOutputDirPath() {
		return model.getOutputDirPath();
	}

}
