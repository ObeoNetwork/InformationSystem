/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts.impl;

// Start of user code for imports
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class BindingReferencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, BindingReferencePropertiesEditionPart {

	protected EMFComboViewer left;
	protected EMFComboViewer right;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BindingReferencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence bindingReferenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = bindingReferenceStep.addStep(EnvironmentViewsRepository.BindingReference.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingReference.Properties.left);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingReference.Properties.right);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingReference.Properties.description);
		
		
		composer = new PartComposer(bindingReferenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.BindingReference.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EnvironmentViewsRepository.BindingReference.Properties.left) {
					return createLeftEMFComboViewer(parent);
				}
				if (key == EnvironmentViewsRepository.BindingReference.Properties.right) {
					return createRightEMFComboViewer(parent);
				}
				if (key == EnvironmentViewsRepository.BindingReference.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EnvironmentMessages.BindingReferencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createLeftEMFComboViewer(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.BindingReference.Properties.left, EnvironmentMessages.BindingReferencePropertiesEditionPart_LeftLabel);
		left = new EMFComboViewer(parent);
		GridData leftData = new GridData(GridData.FILL_HORIZONTAL);
		left.getCombo().setLayoutData(leftData);
		left.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		left.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingReferencePropertiesEditionPartImpl.this, EnvironmentViewsRepository.BindingReference.Properties.left, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLeft()));
			}

		});
		left.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(left.getCombo(), EnvironmentViewsRepository.BindingReference.Properties.left);
		EditingUtils.setEEFtype(left.getCombo(), "eef::Combo"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingReference.Properties.left, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLeftEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRightEMFComboViewer(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.BindingReference.Properties.right, EnvironmentMessages.BindingReferencePropertiesEditionPart_RightLabel);
		right = new EMFComboViewer(parent);
		GridData rightData = new GridData(GridData.FILL_HORIZONTAL);
		right.getCombo().setLayoutData(rightData);
		right.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		right.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingReferencePropertiesEditionPartImpl.this, EnvironmentViewsRepository.BindingReference.Properties.right, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRight()));
			}

		});
		right.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(right.getCombo(), EnvironmentViewsRepository.BindingReference.Properties.right);
		EditingUtils.setEEFtype(right.getCombo(), "eef::Combo"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingReference.Properties.right, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRightEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, EnvironmentViewsRepository.BindingReference.Properties.description, EnvironmentMessages.BindingReferencePropertiesEditionPart_DescriptionLabel);
		GridData descriptionLabelData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionLabelData.horizontalSpan = 3;
		descriptionLabel.setLayoutData(descriptionLabelData);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionData.horizontalSpan = 2;
		descriptionData.heightHint = 80;
		descriptionData.widthHint = 200;
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingReferencePropertiesEditionPartImpl.this, EnvironmentViewsRepository.BindingReference.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, EnvironmentViewsRepository.BindingReference.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingReference.Properties.description, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#getLeft()
	 * 
	 */
	public Object getLeft() {
		if (left.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection) left.getSelection()).getFirstElement();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#initLeft(Object input, Object currentValue)
	 */
	public void initLeft(Object input, Object currentValue) {
		left.setInput(input);
		if (currentValue != null) {
			left.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#setLeft(Object newValue)
	 * 
	 */
	public void setLeft(Object newValue) {
		if (newValue != null) {
			left.modelUpdating(new StructuredSelection(newValue));
		} else {
			left.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.BindingReference.Properties.left);
		if (eefElementEditorReadOnlyState && left.isEnabled()) {
			left.setEnabled(false);
			left.setToolTipText(EnvironmentMessages.BindingReference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !left.isEnabled()) {
			left.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#addFilterLeft(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLeft(ViewerFilter filter) {
		left.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#getRight()
	 * 
	 */
	public Object getRight() {
		if (right.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection) right.getSelection()).getFirstElement();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#initRight(Object input, Object currentValue)
	 */
	public void initRight(Object input, Object currentValue) {
		right.setInput(input);
		if (currentValue != null) {
			right.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#setRight(Object newValue)
	 * 
	 */
	public void setRight(Object newValue) {
		if (newValue != null) {
			right.modelUpdating(new StructuredSelection(newValue));
		} else {
			right.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.BindingReference.Properties.right);
		if (eefElementEditorReadOnlyState && right.isEnabled()) {
			right.setEnabled(false);
			right.setToolTipText(EnvironmentMessages.BindingReference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !right.isEnabled()) {
			right.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#addFilterRight(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRight(ViewerFilter filter) {
		right.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingReferencePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.BindingReference.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(EnvironmentMessages.BindingReference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EnvironmentMessages.BindingReference_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
