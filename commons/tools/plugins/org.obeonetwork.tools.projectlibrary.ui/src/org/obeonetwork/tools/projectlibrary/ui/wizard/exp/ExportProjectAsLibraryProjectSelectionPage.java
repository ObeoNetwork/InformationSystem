/**
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.exp;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.manifest.util.ManifestUtils;

/**
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
@SuppressWarnings("deprecation")
public class ExportProjectAsLibraryProjectSelectionPage extends WizardPage {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;
	
	private ExportProjectAsLibraryWizard wizard = null;
	private ListViewer listViewer;
	private Text txtMarFile;

	/**
	 * Create the wizard.
	 */
	public ExportProjectAsLibraryProjectSelectionPage(ExportProjectAsLibraryWizard wizard) {
		super("ExportProjetAsLibraryProjectSelectionPage");
		setTitle("Export modeling project as library");
		setDescription("Select a modeling project");
		this.wizard = wizard;
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
		
		listViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(isInfoComplete());
			}
		});
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		gd_list.heightHint = 176;
		list.setLayoutData(gd_list);
		
		Label lblExportToFile = new Label(container, SWT.NONE);
		lblExportToFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblExportToFile.setText("Export to MAR file");
		
		txtMarFile = new Text(container, SWT.BORDER);
		txtMarFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell(), SWT.SAVE);
				dlg.setFileName(txtMarFile.getText());
				dlg.setOverwrite(true);
				dlg.setFilterExtensions(new String[]{"*" + ManifestUtils.MODELING_ARCHIVE_FILE_EXTENSION, "*.*"});
				dlg.setFilterNames(new String[]{"MAR files (*" + ManifestUtils.MODELING_ARCHIVE_FILE_EXTENSION + ")", "All files (*.*)"});
				String exportFile = dlg.open();
				if (exportFile != null) {
					txtMarFile.setText(exportFile);
					setPageComplete(isInfoComplete());
				}
			}
		});
		btnBrowse.setText("Browse...");
		m_bindingContext = initDataBindings();
		
		setPageComplete(isInfoComplete());
	}
	
	private boolean isInfoComplete() {
		ModelingProject modelingProject = wizard.getModel().getSelectedModelingProject();
		String filePath  = wizard.getModel().getFilePath();
		return modelingProject != null && filePath != null && !filePath.trim().isEmpty();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), ModelingProject.class, "project.name");
		listViewer.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		listViewer.setContentProvider(listContentProvider);
		//
		IObservableList modelingProjectsWizardgetModelObserveList = PojoProperties.list("modelingProjects").observe(wizard.getModel());
		listViewer.setInput(modelingProjectsWizardgetModelObserveList);
		//
		IObservableValue observeSingleSelectionListViewer_1 = ViewerProperties.singleSelection().observe(listViewer);
		IObservableValue selectedModelingProjectWizardgetModelObserveValue = PojoProperties.value("selectedModelingProject").observe(wizard.getModel());
		bindingContext.bindValue(observeSingleSelectionListViewer_1, selectedModelingProjectWizardgetModelObserveValue, null, null);
		//
		IObservableValue observeTextTxtMarFileObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtMarFile);
		IObservableValue filePathWizardgetModelObserveValue = PojoProperties.value("filePath").observe(wizard.getModel());
		bindingContext.bindValue(observeTextTxtMarFileObserveWidget, filePathWizardgetModelObserveValue, null, null);
		//
		return bindingContext;
	}
}
