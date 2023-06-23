/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.soa.parts.BindingPropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;
import org.obeonetwork.dsl.soa.providers.SoaMessages;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jerome Benois</a>
 * 
 */
public class BindingPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, BindingPropertiesEditionPart {

	protected EMFComboViewer technology;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BindingPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence bindingStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = bindingStep.addStep(SoaViewsRepository.Binding.Properties.class);
		propertiesStep.addStep(SoaViewsRepository.Binding.Properties.technology);
		propertiesStep.addStep(SoaViewsRepository.Binding.Properties.description);
		
		
		composer = new PartComposer(bindingStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == SoaViewsRepository.Binding.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == SoaViewsRepository.Binding.Properties.technology) {
					return createTechnologyEMFComboViewer(parent);
				}
				if (key == SoaViewsRepository.Binding.Properties.description) {
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
		propertiesGroup.setText(SoaMessages.BindingPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createTechnologyEMFComboViewer(Composite parent) {
		createDescription(parent, SoaViewsRepository.Binding.Properties.technology, SoaMessages.BindingPropertiesEditionPart_TechnologyLabel);
		technology = new EMFComboViewer(parent);
		technology.setContentProvider(new ArrayContentProvider());
		technology.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData technologyData = new GridData(GridData.FILL_HORIZONTAL);
		technology.getCombo().setLayoutData(technologyData);
		technology.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingPropertiesEditionPartImpl.this, SoaViewsRepository.Binding.Properties.technology, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTechnology()));
			}

		});
		technology.setID(SoaViewsRepository.Binding.Properties.technology);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Binding.Properties.technology, SoaViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTechnologyEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, SoaViewsRepository.Binding.Properties.description, SoaMessages.BindingPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingPropertiesEditionPartImpl.this, SoaViewsRepository.Binding.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, SoaViewsRepository.Binding.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Binding.Properties.description, SoaViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.soa.parts.BindingPropertiesEditionPart#getTechnology()
	 * 
	 */
	public Enumerator getTechnology() {
		Enumerator selection = (Enumerator) ((StructuredSelection) technology.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.BindingPropertiesEditionPart#initTechnology(Object input, Enumerator current)
	 */
	public void initTechnology(Object input, Enumerator current) {
		technology.setInput(input);
		technology.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Binding.Properties.technology);
		if (eefElementEditorReadOnlyState && technology.isEnabled()) {
			technology.setEnabled(false);
			technology.setToolTipText(SoaMessages.Binding_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !technology.isEnabled()) {
			technology.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.BindingPropertiesEditionPart#setTechnology(Enumerator newValue)
	 * 
	 */
	public void setTechnology(Enumerator newValue) {
		technology.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Binding.Properties.technology);
		if (eefElementEditorReadOnlyState && technology.isEnabled()) {
			technology.setEnabled(false);
			technology.setToolTipText(SoaMessages.Binding_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !technology.isEnabled()) {
			technology.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.BindingPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.BindingPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Binding.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(SoaMessages.Binding_ReadOnly);
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
		return SoaMessages.Binding_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
