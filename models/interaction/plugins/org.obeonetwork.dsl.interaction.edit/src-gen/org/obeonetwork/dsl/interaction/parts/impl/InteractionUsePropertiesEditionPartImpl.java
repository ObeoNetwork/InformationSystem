/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.interaction.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

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

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart;
import org.obeonetwork.dsl.interaction.parts.InteractionViewsRepository;

import org.obeonetwork.dsl.interaction.providers.InteractionMessages;

// End of user code

/**
 * 
 * 
 */
public class InteractionUsePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, InteractionUsePropertiesEditionPart {

	protected Text name;
	protected Text type;
	protected EObjectFlatComboViewer interaction;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public InteractionUsePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence interactionUseStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = interactionUseStep.addStep(InteractionViewsRepository.InteractionUse.Properties.class);
		propertiesStep.addStep(InteractionViewsRepository.InteractionUse.Properties.name);
		propertiesStep.addStep(InteractionViewsRepository.InteractionUse.Properties.type);
		propertiesStep.addStep(InteractionViewsRepository.InteractionUse.Properties.interaction_);
		propertiesStep.addStep(InteractionViewsRepository.InteractionUse.Properties.description);
		
		
		composer = new PartComposer(interactionUseStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == InteractionViewsRepository.InteractionUse.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == InteractionViewsRepository.InteractionUse.Properties.name) {
					return createNameText(parent);
				}
				if (key == InteractionViewsRepository.InteractionUse.Properties.type) {
					return createTypeText(parent);
				}
				if (key == InteractionViewsRepository.InteractionUse.Properties.interaction_) {
					return createInteractionFlatComboViewer(parent);
				}
				if (key == InteractionViewsRepository.InteractionUse.Properties.description) {
					return createDescriptionText(parent);
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
		propertiesGroup.setText(InteractionMessages.InteractionUsePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, InteractionViewsRepository.InteractionUse.Properties.name, InteractionMessages.InteractionUsePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InteractionUsePropertiesEditionPartImpl.this, InteractionViewsRepository.InteractionUse.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InteractionUsePropertiesEditionPartImpl.this, InteractionViewsRepository.InteractionUse.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, InteractionViewsRepository.InteractionUse.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(InteractionViewsRepository.InteractionUse.Properties.name, InteractionViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createTypeText(Composite parent) {
		createDescription(parent, InteractionViewsRepository.InteractionUse.Properties.type, InteractionMessages.InteractionUsePropertiesEditionPart_TypeLabel);
		type = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		type.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InteractionUsePropertiesEditionPartImpl.this, InteractionViewsRepository.InteractionUse.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
			}

		});
		type.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InteractionUsePropertiesEditionPartImpl.this, InteractionViewsRepository.InteractionUse.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
				}
			}

		});
		EditingUtils.setID(type, InteractionViewsRepository.InteractionUse.Properties.type);
		EditingUtils.setEEFtype(type, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(InteractionViewsRepository.InteractionUse.Properties.type, InteractionViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTypeText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createInteractionFlatComboViewer(Composite parent) {
		createDescription(parent, InteractionViewsRepository.InteractionUse.Properties.interaction_, InteractionMessages.InteractionUsePropertiesEditionPart_InteractionLabel);
		interaction = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(InteractionViewsRepository.InteractionUse.Properties.interaction_, InteractionViewsRepository.SWT_KIND));
		interaction.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		interaction.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InteractionUsePropertiesEditionPartImpl.this, InteractionViewsRepository.InteractionUse.Properties.interaction_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getInteraction()));
			}

		});
		GridData interactionData = new GridData(GridData.FILL_HORIZONTAL);
		interaction.setLayoutData(interactionData);
		interaction.setID(InteractionViewsRepository.InteractionUse.Properties.interaction_);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(InteractionViewsRepository.InteractionUse.Properties.interaction_, InteractionViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInteractionFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, InteractionViewsRepository.InteractionUse.Properties.description, InteractionMessages.InteractionUsePropertiesEditionPart_DescriptionLabel);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InteractionUsePropertiesEditionPartImpl.this, InteractionViewsRepository.InteractionUse.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		description.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InteractionUsePropertiesEditionPartImpl.this, InteractionViewsRepository.InteractionUse.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, InteractionViewsRepository.InteractionUse.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(InteractionViewsRepository.InteractionUse.Properties.description, InteractionViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(InteractionViewsRepository.InteractionUse.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(InteractionMessages.InteractionUse_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#getType()
	 * 
	 */
	public String getType() {
		return type.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#setType(String newValue)
	 * 
	 */
	public void setType(String newValue) {
		if (newValue != null) {
			type.setText(newValue);
		} else {
			type.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(InteractionViewsRepository.InteractionUse.Properties.type);
		if (eefElementEditorReadOnlyState && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(InteractionMessages.InteractionUse_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#getInteraction()
	 * 
	 */
	public EObject getInteraction() {
		if (interaction.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) interaction.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#initInteraction(EObjectFlatComboSettings)
	 */
	public void initInteraction(EObjectFlatComboSettings settings) {
		interaction.setInput(settings);
		if (current != null) {
			interaction.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(InteractionViewsRepository.InteractionUse.Properties.interaction_);
		if (eefElementEditorReadOnlyState && interaction.isEnabled()) {
			interaction.setEnabled(false);
			interaction.setToolTipText(InteractionMessages.InteractionUse_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !interaction.isEnabled()) {
			interaction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#setInteraction(EObject newValue)
	 * 
	 */
	public void setInteraction(EObject newValue) {
		if (newValue != null) {
			interaction.setSelection(new StructuredSelection(newValue));
		} else {
			interaction.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(InteractionViewsRepository.InteractionUse.Properties.interaction_);
		if (eefElementEditorReadOnlyState && interaction.isEnabled()) {
			interaction.setEnabled(false);
			interaction.setToolTipText(InteractionMessages.InteractionUse_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !interaction.isEnabled()) {
			interaction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#setInteractionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setInteractionButtonMode(ButtonsModeEnum newValue) {
		interaction.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#addFilterInteraction(ViewerFilter filter)
	 * 
	 */
	public void addFilterToInteraction(ViewerFilter filter) {
		interaction.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#addBusinessFilterInteraction(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToInteraction(ViewerFilter filter) {
		interaction.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.interaction.parts.InteractionUsePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(InteractionViewsRepository.InteractionUse.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(InteractionMessages.InteractionUse_ReadOnly);
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
		return InteractionMessages.InteractionUse_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
