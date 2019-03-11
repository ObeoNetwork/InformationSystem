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
package org.obeonetwork.dsl.database.design.reference.custom;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.ext.widgets.reference.internal.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.ext.emf.edit.EditingDomainServices;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

@SuppressWarnings("restriction")
public class CustomEEFExtEObjectSelectionPage extends WizardPage {

	private EObject target;
	private EReference eReference;
	private EditingContextAdapter editingContextAdapter;
	private ComposedAdapterFactory composedAdapterFactory;
	private ComboViewer eReferenceComboViewer;
	private EditingDomainServices editingDomainServices;
	private ISelectionChangedListener eReferenceComboViewerListener;

	public CustomEEFExtEObjectSelectionPage(EObject target, EReference eReference,
			EditingContextAdapter editingContextAdapter) {
		super(Messages.ReferenceSelectionWizardPage_title);
		this.target = target;
		this.eReference = eReference;
		this.editingContextAdapter = editingContextAdapter;
		this.editingDomainServices = new EditingDomainServices();
		
		this.setTitle(Messages.ReferenceSelectionWizardPage_title);
		this.setDescription(Messages.ReferenceSelectionWizardPage_description);
	}

	@Override
	public void createControl(Composite parent) {
		this.initializeDialogUnits(parent);
		
		Composite control = new Composite(parent, SWT.NONE);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.setControl(control);

		GridLayout gridLayout = new GridLayout(2, false);
		control.setLayout(gridLayout);

		this.composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		this.composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		this.createEReferenceViewer(control);
		this.initializeInput();

		this.determinePageCompletion();
	}
	
	private void initializeInput() {
		Object initialValue = this.target.eGet(this.eReference);
		this.eReferenceComboViewer.setInput(this.target);
		if (initialValue != null) {
			this.eReferenceComboViewer.setSelection(new StructuredSelection(initialValue));
		}
	}

	private void createEReferenceViewer(Composite control) {
		Label label = new Label(control, SWT.NONE);
		label.setText(Messages.ReferenceCreationWizardPage_eClassToCreateLabel);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		this.eReferenceComboViewer = new ComboViewer(new Combo(control, SWT.DROP_DOWN | SWT.READ_ONLY));
		this.eReferenceComboViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.composedAdapterFactory));
		
		this.eReferenceComboViewer.setContentProvider(new AdapterFactoryContentProvider(this.composedAdapterFactory) {
			@Override
			public Object[] getElements(Object object) {
				if (object instanceof EObject) {
					List<?> propertyDescriptorChoiceOfValues = editingDomainServices.getPropertyDescriptorChoiceOfValues((EObject) object, eReference.getName());
					propertyDescriptorChoiceOfValues.removeIf(Objects::isNull);
					return propertyDescriptorChoiceOfValues.toArray();
				}
				return new Object[0];
			}
		});
		
		this.eReferenceComboViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		this.eReferenceComboViewerListener = new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				CustomEEFExtEObjectSelectionPage.this.determinePageCompletion();
			}
		};
		this.eReferenceComboViewer.addSelectionChangedListener(this.eReferenceComboViewerListener);
	}
	

	private void determinePageCompletion() {
		this.setMessage(null);
		boolean isPageComplete = this.isCompleteViewer(true, this.eReferenceComboViewer, "Nécessite une valeur");
		this.setPageComplete(isPageComplete);
	}

	/**
	 * Verifies if the given viewer is complete and if not, set the given error message.
	 *
	 * @param isCurrentlyComplete
	 *            The currently completion status
	 * @param viewer
	 *            The viewer
	 * @param errorMessage
	 *            The error message
	 * @return <code>true</code> if the wizard is currently complete and the viewer too, <code>false</code> otherwise
	 */
	private boolean isCompleteViewer(boolean isCurrentlyComplete, StructuredViewer viewer, String errorMessage) {
		boolean isComplete = isCurrentlyComplete;
		if (isCurrentlyComplete) {
			boolean isViewerComplete = this.getEObject(viewer) != null;
			isComplete = isComplete && isViewerComplete;

			if (!isViewerComplete) {
				this.setMessage(errorMessage, ERROR);
			}
		}
		return isComplete;
	}

	/**
	 * Sets the value of the reference to the selected object.
	 *
	 * @param monitor
	 *            The progress monitor
	 */
	public void performFinish(IProgressMonitor monitor) {
		EObject eObject = this.getEObject(this.eReferenceComboViewer);
		if (eObject != null) {
			Object object = this.target.eGet(this.eReference);
			if (!eObject.equals(object)) {
				this.target.eSet(this.eReference, eObject);
			}
		}
	}
	
	/**
	 * Returns the currently selected EObject in the given viewer.
	 *
	 * @param viewer
	 *            The viewer
	 *
	 * @return The currently selected EObject in the given viewer, or <code>null</code> if the current selection is
	 *         empty or not an EObject (for example an EResource)
	 */
	private EObject getEObject(StructuredViewer viewer) {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object object = structuredSelection.getFirstElement();
			if (object instanceof EObject) {
				return (EObject) object;
			}
		}
		return null;
	}
}
