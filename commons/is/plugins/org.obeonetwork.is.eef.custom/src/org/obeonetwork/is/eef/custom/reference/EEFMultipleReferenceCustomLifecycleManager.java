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
package org.obeonetwork.is.eef.custom.reference;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Optional;

import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.api.widgets.EEFTableSelectionListener;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManager;
import org.eclipse.eef.ide.ui.ext.widgets.reference.internal.EEFExtMultipleReferenceLifecycleManager;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

@SuppressWarnings("restriction")
public class EEFMultipleReferenceCustomLifecycleManager extends EEFExtMultipleReferenceLifecycleManager
		implements IEEFLifecycleManager {

	private EEFCustomReferenceDescription customDescription;

	public EEFMultipleReferenceCustomLifecycleManager(EEFCustomReferenceDescription description, EObject target,
			EReference eReference, IVariableManager variableManager, IInterpreter interpreter,
			EditingContextAdapter editingContextAdapter) {
		super(description, target, eReference, variableManager, interpreter, editingContextAdapter);
		this.customDescription = description;
	}
	
	@Override
	protected void createMainControl(Composite parent, IEEFFormContainer formContainer) {
		super.createMainControl(parent, formContainer);
		this.controller = this.customDescription.getController();
	}
	
	@Override
	protected void setEnabled(boolean isEnabled) {
		if (this.addButton != null && !this.addButton.isDisposed()) {
			this.addButton.setEnabled(isEnabled && this.customDescription.addButtonEnabled());
		}
		if (this.browseButton != null && !this.browseButton.isDisposed()) {
			this.browseButton.setEnabled(isEnabled && this.customDescription.browseButtonNeeded());
		}
		
		this.setEnableWidgetWithSelection(this.removeButton, isEnabled && this.customDescription.removeButtonNeeded());
		this.handleUpDownButtons(isEnabled);
	}
	
	private void setEnableWidgetWithSelection(Control control, boolean isEnabled) {
		if (control != null && !control.isDisposed()) {
			control.setEnabled(isEnabled && this.getSelection() != null);
		}
	}
	
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		
		// Delete super table selection listener to add ours in order to do the same thing as the super table listener + a refresh of the widget
		handleTableSelectionListener();
		// No need to do override aboutToBeHidden as it will be handled by super
		
		// Hide the Add button if necessary
		if(customDescription.addButtonIsHidden()) {
			GridData gridData = (GridData) addButton.getLayoutData();
			gridData.exclude = true; // Exclude the widget from the layout to avoid an empty space 
			addButton.setVisible(false);
		}
		
		// Hide the Browse button if necessary
		if(customDescription.browseButtonIsHidden()) {
			GridData gridData = (GridData) browseButton.getLayoutData();
			gridData.exclude = true; // Exclude the widget from the layout to avoid an empty space 
			browseButton.setVisible(false);
		}
		
		// Hide the Remove button if necessary
		if(customDescription.removeButtonIsHidden()) {
			GridData gridData = (GridData) removeButton.getLayoutData();
			gridData.exclude = true; // Exclude the widget from the layout to avoid an empty space 
			removeButton.setVisible(false);
		}
	}
	
	@Override
	protected void removeButtonCallback() {
		super.removeButtonCallback();
		this.refresh();
	}
	
	private TableViewer getTableViewer() {
		return getFieldValue("tableViewer", TableViewer.class).orElseGet(null);
	}
	
	private EObject getSelection() {
		IStructuredSelection structuredSelection = getTableViewer().getStructuredSelection();
		Object element = structuredSelection.getFirstElement();
		if (element != null && element instanceof EObject) {
			return (EObject) element;
		}
		return null;
	}
	
	private void handleUpDownButtons(boolean isEnabled) {
		boolean shouldEnableUpButton = isEnabled;
		boolean shouldEnableDownButton = isEnabled;
		Optional<Button> upButtonOptional = getFieldValue("upButton", Button.class);
		Optional<Button> downButtonOptional = getFieldValue("downButton", Button.class);
		EObject selection = this.getSelection();
		if (selection != null) {
			Object value = this.target.eGet(eReference);
			if (value instanceof Collection<?>) {
				Object[] values = ((Collection<?>) value).toArray();
				// enable up button only if selection is not first
				shouldEnableUpButton &= values.length > 0 && !selection.equals(values[0]);
				// enable down button only if selection is not last
				shouldEnableDownButton &= values.length > 1 && !selection.equals(values[values.length - 1]);
			} else {
				// Should never happen, but just in case
				shouldEnableUpButton = false;
				shouldEnableDownButton = false;
			}
		} else {
			shouldEnableUpButton = false;
			shouldEnableDownButton = false;
		}
		if (upButtonOptional.isPresent()) {
			upButtonOptional.get().setEnabled(shouldEnableUpButton);
		}
		if (downButtonOptional.isPresent()) {
			downButtonOptional.get().setEnabled(shouldEnableDownButton);
		}
	}
	
	private void handleTableSelectionListener() {
		// Unfortunately some fields are private and we need them, so go deep inside reflective java
		Optional<EEFTableSelectionListener> tableSelectionListenerOptional = getFieldValue("tableSelectionListener", EEFTableSelectionListener.class);
		Optional<TableViewer> tableViewerOptional = getFieldValue("tableViewer", TableViewer.class);
		if (tableSelectionListenerOptional.isPresent() && tableViewerOptional.isPresent()) {
			EEFTableSelectionListener selectionListener = tableSelectionListenerOptional.get();
			TableViewer tableViewer = tableViewerOptional.get();
			// remove the super table selection listener
			if (tableViewer != null && tableViewer.getTable() != null && !tableViewer.getTable().isDisposed()) {
				tableViewer.getTable().removeSelectionListener(selectionListener);
			}
			EEFTableSelectionListener tempTableSelectionListener = new EEFTableSelectionListener(this.controller) {
				public void widgetSelected(SelectionEvent event) {
					super.widgetSelected(event);
					// The refresh is used to update the status of the button
					EEFMultipleReferenceCustomLifecycleManager.this.refresh();
				}
				public void widgetDefaultSelected(SelectionEvent event) {
					super.widgetDefaultSelected(event);
					// The refresh is used to update the status of the button
					EEFMultipleReferenceCustomLifecycleManager.this.refresh();
				}
			};
			this.setFieldValue("tableSelectionListener", tempTableSelectionListener);
			tableViewer.getTable().addSelectionListener(tempTableSelectionListener);
		}
	}
	
	private void setFieldValue(String fieldName, Object newValue) {
		try {
			Field field = this.getClass().getSuperclass().getDeclaredField(fieldName);
			field.setAccessible(true);
			try {
				field.set(this, newValue);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// Silent catch
			} finally {
				field.setAccessible(false);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// Silent catch
		}
	}
	
	private <T> Optional<T> getFieldValue(String fieldName, Class<T> clazz) {
		try {
			Field field = this.getClass().getSuperclass().getDeclaredField(fieldName);
			field.setAccessible(true);
			Object fieldValue;
			try {
				fieldValue = field.get(this);
				if (clazz.isAssignableFrom(fieldValue.getClass())) {
					return Optional.of(clazz.cast(fieldValue));
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// Silent catch
			} finally {
				field.setAccessible(false);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// Silent catch
		}
		return Optional.empty();
	}

	@Override
	protected void addButtonCallback() {
		if (this.customDescription.hasAddButtonOperation()) {
			this.customDescription.executeAddButtonOperation();
		} else if (this.eReference.isContainment()){
			super.addButtonCallback();
		} else {
			CustomEEFExtEObjectSelectionWizard wizard = new CustomEEFExtEObjectSelectionWizard(this.target, this.eReference, this.editingContextAdapter);
			WizardDialog wizardDialog = new WizardDialog(this.label.getShell(), wizard);
			if (Window.OK == wizardDialog.open()) {
				EList<?> result = wizard.getResult();
				if (result != null) {
					Object oldValue = this.target.eGet(this.eReference);
					if (oldValue instanceof Collection) {
						((Collection<Object>)oldValue).addAll(result);
					}
				}						
			}
		}
	}
	
	@Override
	protected void browseButtonCallback() {
		if (this.customDescription.hasBrowseButtonOperation()) {
			this.customDescription.executeBrowseButtonOperation();
		} else {
			super.browseButtonCallback();
		}
	}

}
