/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.ui.dialog;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;
import org.obeonetwork.dsl.environment.design.internal.EnvironmentRow;
import org.eclipse.jface.viewers.ColumnPixelData;

public class EnvironmentResourcesDialog extends Dialog {
	private Table table_1;
	private List<EnvironmentRow> environmentRows;
	private String projectName;

	/**
	 * Create the dialog.
	 * @param parentShell
	 * @param selectedEnvironmentRows 
	 */
	public EnvironmentResourcesDialog(Shell parentShell, List<EnvironmentRow> environmentRows, String projectName) {
		super(parentShell);
		this.environmentRows = environmentRows;
		this.projectName = projectName;
		setShellStyle(SWT.SHELL_TRIM);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		newShell.setMinimumSize(new Point(960, 480));
		super.configureShell(newShell);
		newShell.setText("Manage Environment");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		Label lblManageEnvironmentModels = new Label(container, SWT.NONE);
		lblManageEnvironmentModels.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblManageEnvironmentModels.setText("Manage environment models");
		
		Label lblSelectEnvironmentResources = new Label(container, SWT.NONE);
		lblSelectEnvironmentResources.setText(String.format("Select environment resources to be added/removed for project %1$s", this.projectName));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		CheckboxTableViewer tableViewer = CheckboxTableViewer.newCheckList(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer.getTable();
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tcl_composite.setColumnData(tblclmnNewColumn_3, new ColumnPixelData(30, false, true));
		tblclmnNewColumn_3.setResizable(false);
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_4.getColumn();
		tcl_composite.setColumnData(tblclmnNewColumn_4, new ColumnWeightData(5, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnNewColumn_4.setText("Name");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_5 = tableViewerColumn_5.getColumn();
		tcl_composite.setColumnData(tblclmnNewColumn_5, new ColumnWeightData(20, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnNewColumn_5.setText("URI");

		
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new ITableLabelProvider() {
			
			public void removeListener(ILabelProviderListener listener) {
			}
			
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}
			
			public void dispose() {
			}
			
			public void addListener(ILabelProviderListener listener) {
			}
			
			public String getColumnText(Object element, int columnIndex) {
				String text = "";
				switch (columnIndex) {
				case 1:
					text = ((EnvironmentRow) element).name;
					break;
			    case 2:
			    	text = ((EnvironmentRow) element).uri;
			    	break;
				default:
					break;
				}
				return text;
			}
			
			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}
		});
		
		tableViewer.setCheckStateProvider(new ICheckStateProvider() {
			
			@Override
			public boolean isGrayed(Object element) {
				return false;
			}
			
			@Override
			public boolean isChecked(Object element) {
				EnvironmentRow row = (EnvironmentRow) element;
				return row.selected;
			}
		});
		
		tableViewer.addCheckStateListener((event) -> {
			EnvironmentRow row = (EnvironmentRow) event.getElement();
			row.selected = event.getChecked();
		});
		
		tableViewer.setInput(environmentRows);
//		tableViewer.setCheckedElements(selecetdEnvironmentRows.toArray());
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
	protected void okPressed() {
		super.okPressed();
	}

	public List<EnvironmentRow> getEnvironmentRows() {
		return environmentRows;
	}
}
