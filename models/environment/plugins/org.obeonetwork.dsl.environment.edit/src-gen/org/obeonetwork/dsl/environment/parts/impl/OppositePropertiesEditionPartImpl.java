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
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.obeonetwork.dsl.environment.components.ReferenceOppositePropertiesEditionComponent;

import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart;

import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class OppositePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, OppositePropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer referencedType;
	protected EMFComboViewer multiplicity;
	protected Button isComposite;
	protected Button navigable;
	protected Button identifier;
	protected EObjectFlatComboViewer oppositeOf;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public OppositePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence oppositeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = oppositeStep.addStep(EnvironmentViewsRepository.Opposite.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.name);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.referencedType);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.multiplicity);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.isComposite);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.navigable);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.identifier);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.oppositeOf);
		propertiesStep.addStep(EnvironmentViewsRepository.Opposite.Properties.description);
		
		
		composer = new PartComposer(oppositeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.Opposite.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.name) {
					return createNameText(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.referencedType) {
					return createReferencedTypeFlatComboViewer(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.multiplicity) {
					return createMultiplicityEMFComboViewer(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.isComposite) {
					return createIsCompositeCheckbox(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.navigable) {
					return createNavigableCheckbox(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.identifier) {
					return createIdentifierCheckbox(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.oppositeOf) {
					return createOppositeOfFlatComboViewer(parent);
				}
				if (key == EnvironmentViewsRepository.Opposite.Properties.description) {
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
		propertiesGroup.setText(EnvironmentMessages.OppositePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Opposite.Properties.name, EnvironmentMessages.OppositePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EnvironmentViewsRepository.Opposite.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.name, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createReferencedTypeFlatComboViewer(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Opposite.Properties.referencedType, EnvironmentMessages.OppositePropertiesEditionPart_ReferencedTypeLabel);
		referencedType = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EnvironmentViewsRepository.Opposite.Properties.referencedType, EnvironmentViewsRepository.SWT_KIND));
		referencedType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		referencedType.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.referencedType, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getReferencedType()));
			}

		});
		GridData referencedTypeData = new GridData(GridData.FILL_HORIZONTAL);
		referencedType.setLayoutData(referencedTypeData);
		referencedType.setID(EnvironmentViewsRepository.Opposite.Properties.referencedType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.referencedType, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReferencedTypeFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createMultiplicityEMFComboViewer(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Opposite.Properties.multiplicity, EnvironmentMessages.OppositePropertiesEditionPart_MultiplicityLabel);
		multiplicity = new EMFComboViewer(parent);
		multiplicity.setContentProvider(new ArrayContentProvider());
		multiplicity.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData multiplicityData = new GridData(GridData.FILL_HORIZONTAL);
		multiplicity.getCombo().setLayoutData(multiplicityData);
		multiplicity.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.multiplicity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMultiplicity()));
			}

		});
		multiplicity.setID(EnvironmentViewsRepository.Opposite.Properties.multiplicity);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.multiplicity, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMultiplicityEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createIsCompositeCheckbox(Composite parent) {
		isComposite = new Button(parent, SWT.CHECK);
		isComposite.setText(getDescription(EnvironmentViewsRepository.Opposite.Properties.isComposite, EnvironmentMessages.OppositePropertiesEditionPart_IsCompositeLabel));
		isComposite.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.isComposite, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isComposite.getSelection())));
			}

		});
		GridData isCompositeData = new GridData(GridData.FILL_HORIZONTAL);
		isCompositeData.horizontalSpan = 2;
		isComposite.setLayoutData(isCompositeData);
		EditingUtils.setID(isComposite, EnvironmentViewsRepository.Opposite.Properties.isComposite);
		EditingUtils.setEEFtype(isComposite, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.isComposite, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIsCompositeCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createNavigableCheckbox(Composite parent) {
		navigable = new Button(parent, SWT.CHECK);
		navigable.setText(getDescription(EnvironmentViewsRepository.Opposite.Properties.navigable, EnvironmentMessages.OppositePropertiesEditionPart_NavigableLabel));
		navigable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.navigable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(navigable.getSelection())));
			}

		});
		GridData navigableData = new GridData(GridData.FILL_HORIZONTAL);
		navigableData.horizontalSpan = 2;
		navigable.setLayoutData(navigableData);
		EditingUtils.setID(navigable, EnvironmentViewsRepository.Opposite.Properties.navigable);
		EditingUtils.setEEFtype(navigable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.navigable, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNavigableCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createIdentifierCheckbox(Composite parent) {
		identifier = new Button(parent, SWT.CHECK);
		identifier.setText(getDescription(EnvironmentViewsRepository.Opposite.Properties.identifier, EnvironmentMessages.OppositePropertiesEditionPart_IdentifierLabel));
		identifier.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.identifier, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(identifier.getSelection())));
			}

		});
		GridData identifierData = new GridData(GridData.FILL_HORIZONTAL);
		identifierData.horizontalSpan = 2;
		identifier.setLayoutData(identifierData);
		EditingUtils.setID(identifier, EnvironmentViewsRepository.Opposite.Properties.identifier);
		EditingUtils.setEEFtype(identifier, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.identifier, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdentifierCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createOppositeOfFlatComboViewer(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Opposite.Properties.oppositeOf, EnvironmentMessages.OppositePropertiesEditionPart_OppositeOfLabel);
		oppositeOf = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EnvironmentViewsRepository.Opposite.Properties.oppositeOf, EnvironmentViewsRepository.SWT_KIND));
		oppositeOf.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		oppositeOf.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.oppositeOf, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getOppositeOf()));
			}

		});
		GridData oppositeOfData = new GridData(GridData.FILL_HORIZONTAL);
		oppositeOf.setLayoutData(oppositeOfData);
		oppositeOf.setID(EnvironmentViewsRepository.Opposite.Properties.oppositeOf);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.oppositeOf, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOppositeOfFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, EnvironmentViewsRepository.Opposite.Properties.description, EnvironmentMessages.OppositePropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OppositePropertiesEditionPartImpl.this, EnvironmentViewsRepository.Opposite.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, EnvironmentViewsRepository.Opposite.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Opposite.Properties.description, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Opposite.Properties.name, ((ReferenceOppositePropertiesEditionComponent) propertiesEditionComponent).getOppositeNameSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getReferencedType()
	 * 
	 */
	public EObject getReferencedType() {
		if (referencedType.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) referencedType.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#initReferencedType(EObjectFlatComboSettings)
	 */
	public void initReferencedType(EObjectFlatComboSettings settings) {
		referencedType.setInput(settings);
		if (current != null) {
			referencedType.setSelection(new StructuredSelection(settings.getValue()));
		}
		referencedType.setEnabled(false);
		referencedType.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setReferencedType(EObject newValue)
	 * 
	 */
	public void setReferencedType(EObject newValue) {
		if (newValue != null) {
			referencedType.setSelection(new StructuredSelection(newValue));
		} else {
			referencedType.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		referencedType.setEnabled(false);
		referencedType.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setReferencedTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setReferencedTypeButtonMode(ButtonsModeEnum newValue) {
		referencedType.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#addFilterReferencedType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToReferencedType(ViewerFilter filter) {
		referencedType.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#addBusinessFilterReferencedType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToReferencedType(ViewerFilter filter) {
		referencedType.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getMultiplicity()
	 * 
	 */
	public Enumerator getMultiplicity() {
		Enumerator selection = (Enumerator) ((StructuredSelection) multiplicity.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#initMultiplicity(Object input, Enumerator current)
	 */
	public void initMultiplicity(Object input, Enumerator current) {
		multiplicity.setInput(input);
		multiplicity.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Opposite.Properties.multiplicity, ((ReferenceOppositePropertiesEditionComponent) propertiesEditionComponent).getOppositeMultiplicitySettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && multiplicity.isEnabled()) {
			multiplicity.setEnabled(false);
			multiplicity.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !multiplicity.isEnabled()) {
			multiplicity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setMultiplicity(Enumerator newValue)
	 * 
	 */
	public void setMultiplicity(Enumerator newValue) {
		multiplicity.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Opposite.Properties.multiplicity, ((ReferenceOppositePropertiesEditionComponent) propertiesEditionComponent).getOppositeMultiplicitySettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && multiplicity.isEnabled()) {
			multiplicity.setEnabled(false);
			multiplicity.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !multiplicity.isEnabled()) {
			multiplicity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getIsComposite()
	 * 
	 */
	public Boolean getIsComposite() {
		return Boolean.valueOf(isComposite.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setIsComposite(Boolean newValue)
	 * 
	 */
	public void setIsComposite(Boolean newValue) {
		if (newValue != null) {
			isComposite.setSelection(newValue.booleanValue());
		} else {
			isComposite.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Opposite.Properties.isComposite, ((ReferenceOppositePropertiesEditionComponent) propertiesEditionComponent).getOppositeIsCompositeSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && isComposite.isEnabled()) {
			isComposite.setEnabled(false);
			isComposite.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !isComposite.isEnabled()) {
			isComposite.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getNavigable()
	 * 
	 */
	public Boolean getNavigable() {
		return Boolean.valueOf(navigable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setNavigable(Boolean newValue)
	 * 
	 */
	public void setNavigable(Boolean newValue) {
		if (newValue != null) {
			navigable.setSelection(newValue.booleanValue());
		} else {
			navigable.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Opposite.Properties.navigable, ((ReferenceOppositePropertiesEditionComponent) propertiesEditionComponent).getOppositeNavigableSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && navigable.isEnabled()) {
			navigable.setEnabled(false);
			navigable.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !navigable.isEnabled()) {
			navigable.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getIdentifier()
	 * 
	 */
	public Boolean getIdentifier() {
		return Boolean.valueOf(identifier.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setIdentifier(Boolean newValue)
	 * 
	 */
	public void setIdentifier(Boolean newValue) {
		if (newValue != null) {
			identifier.setSelection(newValue.booleanValue());
		} else {
			identifier.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Opposite.Properties.identifier, ((ReferenceOppositePropertiesEditionComponent) propertiesEditionComponent).getOppositeIdentifierSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && identifier.isEnabled()) {
			identifier.setEnabled(false);
			identifier.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !identifier.isEnabled()) {
			identifier.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getOppositeOf()
	 * 
	 */
	public EObject getOppositeOf() {
		if (oppositeOf.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) oppositeOf.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#initOppositeOf(EObjectFlatComboSettings)
	 */
	public void initOppositeOf(EObjectFlatComboSettings settings) {
		oppositeOf.setInput(settings);
		if (current != null) {
			oppositeOf.setSelection(new StructuredSelection(settings.getValue()));
		}
		oppositeOf.setEnabled(false);
		oppositeOf.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setOppositeOf(EObject newValue)
	 * 
	 */
	public void setOppositeOf(EObject newValue) {
		if (newValue != null) {
			oppositeOf.setSelection(new StructuredSelection(newValue));
		} else {
			oppositeOf.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		oppositeOf.setEnabled(false);
		oppositeOf.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setOppositeOfButtonMode(ButtonsModeEnum newValue)
	 */
	public void setOppositeOfButtonMode(ButtonsModeEnum newValue) {
		oppositeOf.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#addFilterOppositeOf(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOppositeOf(ViewerFilter filter) {
		oppositeOf.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#addBusinessFilterOppositeOf(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOppositeOf(ViewerFilter filter) {
		oppositeOf.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Opposite.Properties.description, ((ReferenceOppositePropertiesEditionComponent) propertiesEditionComponent).getOppositeDescriptionSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(EnvironmentMessages.Opposite_ReadOnly);
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
		return EnvironmentMessages.Opposite_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
