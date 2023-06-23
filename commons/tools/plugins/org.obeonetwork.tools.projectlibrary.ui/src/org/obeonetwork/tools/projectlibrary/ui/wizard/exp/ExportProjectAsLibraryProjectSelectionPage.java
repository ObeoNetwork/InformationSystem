/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.exp;

import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("deprecation")
public class ExportProjectAsLibraryProjectSelectionPage extends WizardPage {
	
	private ExportProjectAsLibraryWizardModel model;
	
	private DataBindingContext bindingContext;

	private ListViewer lstModelingProject;
	private Text txtExportDirectory;

	private PropertyChangeListener exportDirectoryModelListener;

	/**
	 * Create the wizard.
	 */
	public ExportProjectAsLibraryProjectSelectionPage(ExportProjectAsLibraryWizard wizard) {
		super("ExportProjetAsLibraryProjectSelectionPage");
		setTitle("Export modeling project as library");
		setDescription("Select a modeling project");
		this.model = wizard.getModel();
	}
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblModelingProject = new Label(container, SWT.NONE);
		lblModelingProject.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblModelingProject.setText("Modeling project");
		
		lstModelingProject = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		List list = lstModelingProject.getList();
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(isComplete());
			}
		});
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		gd_list.heightHint = 176;
		list.setLayoutData(gd_list);
		
		Label lblExportDirectory = new Label(container, SWT.NONE);
		lblExportDirectory.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblExportDirectory.setText("Export directory");
		
		txtExportDirectory = new Text(container, SWT.BORDER);
		txtExportDirectory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		exportDirectoryModelListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setPageComplete(isComplete());
				setErrorMessage(computeErrorMessage());
			}
		};
		model.addPropertyChangeListener("exportDirectory", exportDirectoryModelListener); //$NON-NLS-1$
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN);
				dialog.setFilterPath(model.getExportDirectory());
				String exportDirectory = dialog.open();
				if(exportDirectory != null) {
					model.setExportDirectory(exportDirectory);
					setPageComplete(isComplete());
				}
			}
		});
		btnBrowse.setText("Browse...");
		
		bindingContext = initDataBindings();
		
		setPageComplete(isComplete());
	}
	
	private boolean isComplete() {
		return model.getSelectedModelingProject() != null 
				&& !isNullOrWhite(model.getExportDirectory())
				&& new File(model.getExportDirectory()).isDirectory();
	}
	
	private String computeErrorMessage() {
		if(!isNullOrWhite(model.getExportDirectory()) && !new File(model.getExportDirectory()).isDirectory()) {
			return "Export directory does not exist.";
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), ModelingProject.class, "project.name");
		lstModelingProject.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		lstModelingProject.setContentProvider(listContentProvider);
		//
		IObservableList modelingProjectsWizardgetModelObserveList = BeanProperties.list("modelingProjects").observe(model);
		lstModelingProject.setInput(modelingProjectsWizardgetModelObserveList);
		//
		IObservableValue observeSingleSelectionListViewer_1 = ViewerProperties.singleSelection().observe(lstModelingProject);
		IObservableValue selectedModelingProjectWizardgetModelObserveValue = BeanProperties.value("selectedModelingProject").observe(model);
		bindingContext.bindValue(observeSingleSelectionListViewer_1, selectedModelingProjectWizardgetModelObserveValue, null, null);
		//
		IObservableValue observeTextTxtExportDirectoryObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtExportDirectory);
		IObservableValue exportDirectoryWizardgetModelObserveValue = BeanProperties.value("exportDirectory").observe(model);
		bindingContext.bindValue(observeTextTxtExportDirectoryObserveWidget, exportDirectoryWizardgetModelObserveValue, null, null);
		//
		return bindingContext;
	}
	
	@Override
	public void dispose() {
		model.removePropertyChangeListener(exportDirectoryModelListener);
		bindingContext.dispose();
		
		super.dispose();
	}

}
