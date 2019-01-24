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
package org.obeonetwork.dsl.environment.properties.ui.eef.widget;

import java.util.List;

import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.common.ui.api.EEFWidgetFactory;
import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.IEEFWidgetController;
import org.eclipse.eef.ide.ui.api.widgets.AbstractEEFWidgetLifecycleManager;
import org.eclipse.eef.ide.ui.api.widgets.EEFTableSelectionListener;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.obeonetwork.dsl.environment.properties.Activator;
import org.obeonetwork.dsl.environment.properties.internal.TableColumnsLabelProvider;
import org.obeonetwork.dsl.environment.properties.internal.TableReferenceContentProvider;

/**
 * The lifecycle manager of the table widget.
 * 
 * @author gcoutable
 */
public class TableLifecycleManager extends AbstractEEFWidgetLifecycleManager {

	private static final String DIRECTION_UP = "up";
	
	private static final int MINIMUM_BUTTON_WIDTH = 80;
	
	private EEFCustomWidgetDescription description;
	
	private TableController controller;
	
	private EEFWidgetFactory widgetFactory;
	
	private TableViewer tableViewer;
	
	private Button editButton;
	
	private ButtonSelectionListener editButtonListener;
	
	private Button addButton;
	
	private ButtonSelectionListener addButtonListener;
	
	private Button removeButton;
	
	private ButtonSelectionListener removeButtonListener;

	private Button upButton;
	
	private ButtonSelectionListener upButtonListener;
	
	private Button downButton;
	
	private ButtonSelectionListener downButtonListener;
	
	private SelectionListener tableSelectionListener;

	public TableLifecycleManager(EEFCustomWidgetDescription controlDescription, IVariableManager variableManager, IInterpreter interpreter,
			EditingContextAdapter editingContextAdapter) {
		super(variableManager, interpreter, editingContextAdapter);
		this.description = controlDescription;
		this.controller = new TableController(controlDescription, variableManager, interpreter, editingContextAdapter);
	}

	@Override
	protected IEEFWidgetController getController() {
		return this.controller;
	}

	@Override
	protected EEFWidgetDescription getWidgetDescription() {
		return this.description;
	}

	@Override
	protected void setEnabled(boolean isEnabled) {
		super.isEnabled();
		
		if (this.addButton != null && !this.addButton.isDisposed()) {
			this.addButton.setEnabled(isEnabled);
		}
		this.setEnableWidgetWithSelection(this.editButton, isEnabled);
		this.setEnableWidgetWithSelection(this.removeButton, isEnabled);
		this.setEnableWidgetWithSelection(this.upButton, isEnabled);
		this.setEnableWidgetWithSelection(this.downButton, isEnabled);
	}
	
	/**
	 * Sets the enablement of the child widget. the widget will be enabled if the parent is enabled and an object is selected.
	 * 
	 * @param control
	 * 			The widget.
	 * @param isEnabled
	 * 			The enablement of the parent widget
	 */
	private void setEnableWidgetWithSelection(Control control, boolean isEnabled) {
		if (control != null && !control.isDisposed()) {
			control.setEnabled(isEnabled && this.controller.getSelection() != null);
		}
	}

	@Override
	protected Control getValidationControl() {
		return this.tableViewer.getTable();
	}
	
	@Override
	public void refresh() {
		super.refresh();
		this.tableViewer.setInput(this.controller.getTarget());
	}

	@Override
	protected void createMainControl(Composite parent, IEEFFormContainer formContainer) {
		widgetFactory = formContainer.getWidgetFactory();
		
		Composite widgetComposite = this.widgetFactory.createFlatFormComposite(parent);
		GridLayout widgetGridLayout = new GridLayout(2, false);
		widgetComposite.setLayout(widgetGridLayout);
		
		GridData widgetCompositeGridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		widgetComposite.setLayoutData(widgetCompositeGridData);
		
		this.createTable(widgetComposite);
		
		Composite buttonsComposite = this.widgetFactory.createFlatFormComposite(widgetComposite);
		GridData buttonsCompositeGridData = new GridData();
		buttonsCompositeGridData.verticalAlignment = SWT.BEGINNING;
		buttonsComposite.setLayoutData(buttonsCompositeGridData);
		
		GridLayout buttonsGridLayout = new GridLayout(1, false);
		buttonsGridLayout.marginHeight = 0;
		buttonsComposite.setLayout(buttonsGridLayout);
		
		Image editImage = ExtendedImageRegistry.INSTANCE.getImage(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, Activator.EDIT_ICON_PATH));
		Image addImage = ExtendedImageRegistry.INSTANCE.getImage(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, Activator.ADD_ICON_PATH));
		Image removeImage = ExtendedImageRegistry.INSTANCE.getImage(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, Activator.REMOVE_ICON_PATH));
		Image upImage = ExtendedImageRegistry.INSTANCE.getImage(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, Activator.UP_ICON_PATH));
		Image downImage = ExtendedImageRegistry.INSTANCE.getImage(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, Activator.DOWN_ICON_PATH));
		
		this.editButton = this.createButton(buttonsComposite, editImage);
		this.addButton = this.createButton(buttonsComposite, addImage);
		this.removeButton = this.createButton(buttonsComposite, removeImage);
		this.upButton = this.createButton(buttonsComposite, upImage);
		this.downButton = this.createButton(buttonsComposite, downImage);
		
		this.widgetFactory.paintBordersFor(parent);
	}

	private void createTable(Composite parent) {
		Composite composite = this.widgetFactory.createComposite(parent, SWT.NONE);
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		composite.setLayoutData(gridData);
		TableColumnLayout tableColumnLayout = new TableColumnLayout();
		composite.setLayout(tableColumnLayout);
		
		int style = SWT.READ_ONLY | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER | SWT.SINGLE | SWT.VIRTUAL;
		
		Table table = widgetFactory.createTable(composite, style);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tableViewer = new TableViewer(table);
		
		GridData tableGridData = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		tableGridData.horizontalIndent = VALIDATION_MARKER_OFFSET;
		tableGridData.grabExcessHorizontalSpace = true;
		this.tableViewer.getTable().setLayoutData(tableGridData);
		
		this.addColumns(this.tableViewer, tableColumnLayout);
		
		this.tableViewer.setContentProvider(new TableReferenceContentProvider(this.controller.getReference()));
	}

	private void addColumns(TableViewer viewer, TableColumnLayout columnLayout) {
		List<String> columnsLabels = this.controller.getColumnsLabels();
		for (String columnLabel : columnsLabels) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			columnLayout.setColumnData(column.getColumn(), new ColumnWeightData(this.controller.getColumnWeight(columnLabel), ColumnWeightData.MINIMUM_WIDTH, true));
			column.getColumn().setText(columnLabel);
			column.setLabelProvider(new TableColumnsLabelProvider(columnLabel));
		}
	}

	private Button createButton(Composite parent, Image image) {
		Button button = this.widgetFactory.createButton(parent, "", SWT.NONE);
		button.setImage(image);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.minimumWidth = MINIMUM_BUTTON_WIDTH;
		button.setLayoutData(gridData);
		return button;
	}
	
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		this.tableSelectionListener = new EEFTableSelectionListener(this.controller) {
			public void widgetSelected(SelectionEvent event) {
				super.widgetSelected(event);
				// The refresh is used to update the status of the button
				TableLifecycleManager.this.refresh();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				super.widgetDefaultSelected(event);
				// The refresh is used to update the status of the button
				TableLifecycleManager.this.refresh();
			}
		};
		this.tableViewer.getTable().addSelectionListener(this.tableSelectionListener);
		this.initializeAddButton();
		this.initializeRemoveButton();
		this.initializeEditButtonButton();
		this.initializeUpButton();
		this.initializeDownButton();
	}
	
	private void initializeEditButtonButton() {
		this.editButtonListener = new ButtonSelectionListener(this.editingContextAdapter, () -> this.editButtonCallback());
		this.editButton.addSelectionListener(this.editButtonListener);
		this.editButton.setToolTipText("Button to edit the selected metadata");
	}

	private void editButtonCallback() {
		this.controller.displayEditWizard();
	}
	
	private void initializeAddButton() {
		this.addButtonListener = new ButtonSelectionListener(this.editingContextAdapter, () -> this.addButtonCallback());
		this.addButton.addSelectionListener(this.addButtonListener);
		this.addButton.setToolTipText("Button to add metadata");
	}

	private void addButtonCallback() {
		this.controller.displayAddButtonWizard();
	}

	private void initializeRemoveButton() {
		this.removeButtonListener = new ButtonSelectionListener(this.editingContextAdapter, () -> this.removeButtonCallback());
		this.removeButton.addSelectionListener(this.removeButtonListener);
		this.removeButton.setToolTipText("Button to remove the selected metadata");
	}

	private void removeButtonCallback() {
		if (this.controller.getSelection() != null) {
			EcoreUtil.remove(this.controller.getTarget(), this.controller.getReference(), this.controller.getSelection());
		}
	}

	private void initializeUpButton() {
		this.upButtonListener = new ButtonSelectionListener(this.editingContextAdapter, () -> this.moveButtonCallback(DIRECTION_UP));
		this.upButton.addSelectionListener(this.upButtonListener);
		this.upButton.setToolTipText("Button to move up the selected metadata");
	}

	private void moveButtonCallback(String direction) {
		if (this.controller.getSelection() != null) {
			EObject selection = this.controller.getSelection();
			EList<?> values = this.getValues();
			if (DIRECTION_UP.equals(direction)) {
				values.move(Math.max(0, values.indexOf(selection) - 1), values.indexOf(selection));
			} else {
				values.move(Math.min(values.size() - 1, values.indexOf(selection) + 1), values.indexOf(selection));
			}
		}
		//Updates the selection
		this.tableViewer.refresh();
	}

	private EList<?> getValues() {
		Object value = this.controller.getTarget().eGet(this.controller.getReference());
		if (value instanceof EList<?>) {
			return (EList<?>) value;
		}
		return new BasicEList<>();
	}

	private void initializeDownButton() {
		this.downButtonListener = new ButtonSelectionListener(this.editingContextAdapter, () -> this.moveButtonCallback("down"));
		this.downButton.addSelectionListener(this.downButtonListener);
		this.downButton.setToolTipText("Button to move down the selected metadata");
	}

	@Override
	public void aboutToBeHidden() {
		
		if (this.tableViewer != null && this.tableViewer.getTable() != null && !this.tableViewer.getTable().isDisposed()) {
			this.tableViewer.getTable().removeSelectionListener(this.tableSelectionListener);
		}
		this.removeListener(this.editButton, this.editButtonListener);
		this.removeListener(this.addButton, this.addButtonListener);
		this.removeListener(this.removeButton, this.removeButtonListener);
		this.removeListener(this.upButton, this.upButtonListener);
		this.removeListener(this.downButton, this.downButtonListener);
		
		super.aboutToBeHidden();
	}

	private void removeListener(Button button, ButtonSelectionListener listener) {
		if (!button.isDisposed()) {
			button.removeSelectionListener(listener);
		}
	}
}
