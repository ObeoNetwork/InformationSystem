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
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

/**
 * Wizard page to set manifest informations
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
@SuppressWarnings("deprecation")
public class ExportProjectAsLibraryManifestPage extends WizardPage {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;
	
	private ExportProjectAsLibraryWizard wizard = null;
	
	private Text txtProjectId;
	private Text txtVersion;
	private Table table;
	private Text txtComment;
	
	private TableViewer tableViewer;

	/**
	 * Create the wizard.
	 */
	public ExportProjectAsLibraryManifestPage(ExportProjectAsLibraryWizard wizard) {
		super("ExportProjectAsLibraryManifestPage");
		setTitle("Export modeling project as library");
		setDescription("Set informations about the manifest");
		this.wizard = wizard;
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
		
		Label lblProjectId = new Label(composite, SWT.NONE);
		lblProjectId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProjectId.setText("Project ID");
		
		txtProjectId = new Text(composite, SWT.BORDER);
		txtProjectId.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(isInfoComplete(txtProjectId.getText(), txtVersion.getText()));
			}
		});
		txtProjectId.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		Label lblVersion = new Label(composite, SWT.NONE);
		lblVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVersion.setText("Version");
		
		txtVersion = new Text(composite, SWT.BORDER);
		txtVersion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtVersion.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(isInfoComplete(txtProjectId.getText(), txtVersion.getText()));
			}
		});
		
		Label lblVersionHelp = new Label(composite, SWT.NONE);
		lblVersionHelp.setToolTipText("major.minor.patch.qualifier (ex : 1.2.123.alpha)");
		lblVersionHelp.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/etool16/help_contents.png"));
		
		Label lblPreviousversions = new Label(composite, SWT.NONE);
		lblPreviousversions.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblPreviousversions.setText("PreviousVersions");
		
		Composite compositeTbl = new Composite(composite, SWT.NONE);
		compositeTbl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TableColumnLayout tcl_compositeTbl = new TableColumnLayout();
		compositeTbl.setLayout(tcl_compositeTbl);
		
		tableViewer = new TableViewer(compositeTbl, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
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
		
		Label lblComment = new Label(composite, SWT.NONE);
		lblComment.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblComment.setText("Comment");
		
		txtComment = new Text(composite, SWT.BORDER | SWT.MULTI);
		txtComment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Label(composite, SWT.NONE);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		m_bindingContext = initDataBindings();
	}
	
	private boolean isInfoComplete(String projectId, String version) {
		return projectId != null
				&& !projectId.trim().isEmpty()
				&& version != null
				&& !version.trim().isEmpty()
				&& ManifestUtils.isVersionFormatValid(version);
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			// Make sure right informations are displayed
			String projectId = wizard.getModel().getProjectId();
			if (!txtProjectId.getText().equals(projectId)) {
				if (projectId != null) {
					txtProjectId.setText(projectId);
				} else {
					txtProjectId.setText("");					
				}
			}
			String version = wizard.getModel().getVersion();
			if (!txtVersion.getText().equals(version)) {
				if (version != null) {
					txtVersion.setText(version);
				} else {
					txtVersion.setText("");
				}
			}
			tableViewer.refresh();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtProjectIdObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtProjectId);
		IObservableValue projectIdWizardgetModelObserveValue = PojoProperties.value("projectId").observe(wizard.getModel());
		bindingContext.bindValue(observeTextTxtProjectIdObserveWidget, projectIdWizardgetModelObserveValue, null, null);
		//
		IObservableValue observeTextTxtVersionObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtVersion);
		IObservableValue versionWizardgetModelObserveValue = PojoProperties.value("version").observe(wizard.getModel());
		bindingContext.bindValue(observeTextTxtVersionObserveWidget, versionWizardgetModelObserveValue, null, null);
		//
		IObservableValue observeTextTxtCommentObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtComment);
		IObservableValue commentWizardgetModelObserveValue = PojoProperties.value("comment").observe(wizard.getModel());
		bindingContext.bindValue(observeTextTxtCommentObserveWidget, commentWizardgetModelObserveValue, null, null);
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), MManifest.class, new String[]{"version", "projectId", "comment"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList previousVersionsWizardgetModelObserveList = PojoProperties.list("previousVersions").observe(wizard.getModel());
		tableViewer.setInput(previousVersionsWizardgetModelObserveList);
		//
		return bindingContext;
	}
}
