/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.exp;

import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.dsl.manifest.util.ManifestUtils;
import org.obeonetwork.utils.common.ui.services.WizardHelper;

/**
 * Wizard page to set manifest informations
 * 
 */
@SuppressWarnings("deprecation")
public class ExportProjectAsLibraryManifestPage extends WizardPage {
	
	private ExportProjectAsLibraryWizardModel model;
	
	private DataBindingContext bindingContext;
	
	private Text txtProjectId;
	private Text txtVersion;
	private Table table;
	private Text txtComment;
	private StyledText txtMarFileName;
	private Table updatedProjectsTable;
	
	private TableViewer tableViewer;
	private CheckboxTableViewer updateTableViewer;
	
	private PropertyChangeListener projectIdModelListener;
	private PropertyChangeListener versionModelListener;
	private PropertyChangeListener marFileNameModelListener;

	/**
	 * Create the wizard.
	 */
	public ExportProjectAsLibraryManifestPage(ExportProjectAsLibraryWizard wizard) {
		super("ExportProjectAsLibraryManifestPage");
		setTitle("Export modeling project as library");
		setDescription("Set informations about the manifest");
		this.model = wizard.getModel();
		setPageComplete(false);
	}
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		
		// Project ID
		Label lblProjectId = new Label(composite, SWT.NONE);
		lblProjectId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProjectId.setText("Project ID");
		
		txtProjectId = new Text(composite, SWT.BORDER);
		txtProjectId.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		projectIdModelListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setPageComplete(isComplete());
				updateMarFileName();
			}
		};
		model.addPropertyChangeListener("projectId", projectIdModelListener); //$NON-NLS-1$
		
		// Version
		Label lblVersion = new Label(composite, SWT.NONE);
		lblVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVersion.setText("Version");
		
		txtVersion = new Text(composite, SWT.BORDER);
		txtVersion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		versionModelListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setPageComplete(isComplete());
				updateMarFileName();
			}
		};
		model.addPropertyChangeListener("version", versionModelListener); //$NON-NLS-1$
		
		Label lblVersionHelp = new Label(composite, SWT.NONE);
		lblVersionHelp.setToolTipText("major.minor.patch.qualifier (ex : 1.2.123.alpha)");
		lblVersionHelp.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/etool16/help_contents.png"));
		
		// Previous versions
		Label lblPreviousversions = new Label(composite, SWT.NONE);
		lblPreviousversions.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblPreviousversions.setText("PreviousVersions");
		
		Composite compositeTbl = new Composite(composite, SWT.NONE);
		GridData compositeTblGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		compositeTbl.setLayoutData(compositeTblGridData);
		TableColumnLayout tcl_compositeTbl = new TableColumnLayout();
		compositeTbl.setLayout(tcl_compositeTbl);
		
		tableViewer = new TableViewer(compositeTbl, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		compositeTblGridData.heightHint = 138;
		TableViewerColumn tableViewerColumnVersion = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnVersion = tableViewerColumnVersion.getColumn();
		tcl_compositeTbl.setColumnData(tblclmnVersion, new ColumnWeightData(25, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnVersion.setText("Version");
		
		TableViewerColumn tableViewerColumnID = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnId = tableViewerColumnID.getColumn();
		tcl_compositeTbl.setColumnData(tblclmnId, new ColumnWeightData(25, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnId.setText("ID");
		
		TableViewerColumn tableViewerColumnComment = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnComment = tableViewerColumnComment.getColumn();
		tcl_compositeTbl.setColumnData(tblclmnComment, new ColumnWeightData(50, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnComment.setText("Comment");
		new Label(composite, SWT.NONE);
		
		// Comment
		Label lblComment = new Label(composite, SWT.NONE);
		lblComment.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblComment.setText("Comment");
		
		txtComment = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		GridData txtCommentGridData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		txtCommentGridData.heightHint = 60;
		txtComment.setLayoutData(txtCommentGridData);
		new Label(composite, SWT.NONE);
		
		// MAR Filename
		Label lblMarFileName = new Label(composite, SWT.NONE);
		lblMarFileName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMarFileName.setText("MAR filename");
		
		txtMarFileName = new StyledText(composite, SWT.BORDER);
		txtMarFileName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				WizardHelper.addExtensionIfMissing(txtMarFileName, ManifestUtils.MODELING_ARCHIVE_FILE_EXTENSION);
				setPageComplete(isComplete());
			}
		});
		txtMarFileName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		marFileNameModelListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setPageComplete(isComplete());
				setErrorMessage(computeErrorMessage());
				setMessage(computeWarningMessage(), IMessageProvider.WARNING);
			}
		};
		model.addPropertyChangeListener("marFileName", marFileNameModelListener); //$NON-NLS-1$
		
		// Update referencing projects
		Label lblUpdateReferencingProjects = new Label(composite, SWT.NONE);
		lblUpdateReferencingProjects.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblUpdateReferencingProjects.setText("Update referencing projects");
		
		Composite compositeTbl2 = new Composite(composite, SWT.NONE);
		GridData compositeTbl2GridData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		compositeTbl2.setLayoutData(compositeTbl2GridData);
		TableColumnLayout table_layout = new TableColumnLayout();
		compositeTbl2.setLayout(table_layout);
		
		updateTableViewer = CheckboxTableViewer.newCheckList(compositeTbl2, SWT.BORDER | SWT.FULL_SELECTION);
		this.updatedProjectsTable = updateTableViewer.getTable();
		compositeTbl2GridData.heightHint = 26 * 4;
		
		// 
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		bindingContext = initDataBindings();
		
		updateMarFileName();
	}
	
	private void updateMarFileName() {
		StringBuilder marFileName = new StringBuilder();
		if(model.getProjectId() != null)
		marFileName.append(model.getProjectId().trim());
		if(!isNullOrWhite(model.getVersion())) {
			marFileName.append("-");
			marFileName.append(model.getVersion().trim());
		}
		marFileName.append(".mar");
		
		model.setMarFileName(marFileName.toString());
	}
	
	private boolean isComplete() {
		return !isNullOrWhite(model.getProjectId())
				&& !isNullOrWhite(model.getVersion())
				&& ManifestUtils.isVersionFormatValid(model.getVersion())
				&& !isNullOrWhite(model.getMarFileName())
				&& !isExportingProjectWithDependencies();
	}
	
	private String computeErrorMessage() {
		if(!isNullOrWhite(model.getMarFileName()) && !model.getMarFileName().endsWith(".mar")) {
			return "MAR filename must end with '.mar'";
		}
		
		if(isExportingProjectWithDependencies()) {
			return "The exported project has dependencies to other projects";
		}
		
		return null;
	}
	
	private String computeWarningMessage() {
		if(!isNullOrWhite(model.getExportDirectory()) && !isNullOrWhite(model.getMarFileName()) && new File(new File(model.getExportDirectory()), model.getMarFileName()).exists()) {
			return "MAR file already exists. It will be replaced.";
		}
		return null;
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			// Make sure right informations are displayed
			String projectId = model.getProjectId();
			if (!txtProjectId.getText().equals(projectId)) {
				if (projectId != null) {
					txtProjectId.setText(projectId);
				} else {
					txtProjectId.setText("");					
				}
			}
			String version = model.getVersion();
			if (!txtVersion.getText().equals(version)) {
				if (version != null) {
					txtVersion.setText(version);
				} else {
					txtVersion.setText("");
				}
			}
			tableViewer.refresh();
			updateTableViewer.refresh();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtProjectIdObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtProjectId);
		IObservableValue projectIdWizardgetModelObserveValue = BeanProperties.value("projectId").observe(model);
		bindingContext.bindValue(observeTextTxtProjectIdObserveWidget, projectIdWizardgetModelObserveValue, null, null);
		//
		IObservableValue observeTextTxtVersionObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtVersion);
		IObservableValue versionWizardgetModelObserveValue = BeanProperties.value("version").observe(model);
		bindingContext.bindValue(observeTextTxtVersionObserveWidget, versionWizardgetModelObserveValue, null, null);
		//
		IObservableValue observeTextTxtCommentObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtComment);
		IObservableValue commentWizardgetModelObserveValue = BeanProperties.value("comment").observe(model);
		bindingContext.bindValue(observeTextTxtCommentObserveWidget, commentWizardgetModelObserveValue, null, null);
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), MManifest.class, new String[]{"version", "projectId", "comment"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList previousVersionsWizardgetModelObserveList = BeanProperties.list("previousVersions").observe(model);
		tableViewer.setInput(previousVersionsWizardgetModelObserveList);
		//
		IObservableValue observeTextTxtMarFileNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtMarFileName);
		IObservableValue marFileNameWizardgetModelObserveValue = BeanProperties.value("marFileName").observe(model);
		bindingContext.bindValue(observeTextTxtMarFileNameObserveWidget, marFileNameWizardgetModelObserveValue, null, null);
		//
		ObservableSetContentProvider setContentProvider = new ObservableSetContentProvider();
		updateTableViewer.setContentProvider(setContentProvider);
		updateTableViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if(element instanceof ModelingProject) {
					return ((ModelingProject) element).getProject().getName();
				}
				return super.getText(element);
			}
		});
		IObservableSet referencingModelingProjectsWizardgetModelObserveSet = BeanProperties.set("referencingModelingProjects").observe(model);
		updateTableViewer.setInput(referencingModelingProjectsWizardgetModelObserveSet);
		//
		return bindingContext;
	}
	
	@Override
	public void dispose() {
		model.removePropertyChangeListener(projectIdModelListener);
		model.removePropertyChangeListener(versionModelListener);
		model.removePropertyChangeListener(marFileNameModelListener);
		bindingContext.dispose();
		
		super.dispose();
	}
	
	public Set<ModelingProject> getSelectedReferencingProjects() {
		Set<ModelingProject> result = new HashSet<>();
		Object[] selection = this.updateTableViewer.getCheckedElements();
		for(Object item : selection) {
			if(item instanceof ModelingProject) {
				result.add((ModelingProject) item);
			}
		}
		return result;
	}
	
	/**
	 * Return {@code true} if the exported project has dependencies to other projects, {@code false} otherwise.
	 * 
	 * @return {@code true} if the exported project has dependencies to other projects, {@code false} otherwise.
	 */
	public boolean isExportingProjectWithDependencies() {
		return model.getIsSelectedModelingProjectHasDependencies();
	}

}
