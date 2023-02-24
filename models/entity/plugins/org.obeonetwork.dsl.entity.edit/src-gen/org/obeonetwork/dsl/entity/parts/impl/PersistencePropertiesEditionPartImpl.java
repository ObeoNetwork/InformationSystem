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
package org.obeonetwork.dsl.entity.parts.impl;

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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart;

import org.obeonetwork.dsl.entity.providers.EntityMessages;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class PersistencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PersistencePropertiesEditionPart {

	protected Text estimatedVolumetry;
	protected Text estimatedAccess;
	protected Button historized;
	protected EMFComboViewer inheritanceKind;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PersistencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence persistenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = persistenceStep.addStep(EntityViewsRepository.Persistence.Properties.class);
		propertiesStep.addStep(EntityViewsRepository.Persistence.Properties.estimatedVolumetry);
		propertiesStep.addStep(EntityViewsRepository.Persistence.Properties.estimatedAccess);
		propertiesStep.addStep(EntityViewsRepository.Persistence.Properties.historized);
		propertiesStep.addStep(EntityViewsRepository.Persistence.Properties.inheritanceKind);
		
		
		composer = new PartComposer(persistenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityViewsRepository.Persistence.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.estimatedVolumetry) {
					return createEstimatedVolumetryText(parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.estimatedAccess) {
					return createEstimatedAccessText(parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.historized) {
					return createHistorizedCheckbox(parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.inheritanceKind) {
					return createInheritanceKindEMFComboViewer(parent);
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
		propertiesGroup.setText(EntityMessages.PersistencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createEstimatedVolumetryText(Composite parent) {
		createDescription(parent, EntityViewsRepository.Persistence.Properties.estimatedVolumetry, EntityMessages.PersistencePropertiesEditionPart_EstimatedVolumetryLabel);
		estimatedVolumetry = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData estimatedVolumetryData = new GridData(GridData.FILL_HORIZONTAL);
		estimatedVolumetry.setLayoutData(estimatedVolumetryData);
		estimatedVolumetry.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, EntityViewsRepository.Persistence.Properties.estimatedVolumetry, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
			}

		});
		estimatedVolumetry.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, EntityViewsRepository.Persistence.Properties.estimatedVolumetry, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
				}
			}

		});
		EditingUtils.setID(estimatedVolumetry, EntityViewsRepository.Persistence.Properties.estimatedVolumetry);
		EditingUtils.setEEFtype(estimatedVolumetry, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.estimatedVolumetry, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedVolumetryText

		// End of user code
		return parent;
	}

	
	protected Composite createEstimatedAccessText(Composite parent) {
		createDescription(parent, EntityViewsRepository.Persistence.Properties.estimatedAccess, EntityMessages.PersistencePropertiesEditionPart_EstimatedAccessLabel);
		estimatedAccess = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData estimatedAccessData = new GridData(GridData.FILL_HORIZONTAL);
		estimatedAccess.setLayoutData(estimatedAccessData);
		estimatedAccess.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, EntityViewsRepository.Persistence.Properties.estimatedAccess, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedAccess.getText()));
			}

		});
		estimatedAccess.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, EntityViewsRepository.Persistence.Properties.estimatedAccess, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedAccess.getText()));
				}
			}

		});
		EditingUtils.setID(estimatedAccess, EntityViewsRepository.Persistence.Properties.estimatedAccess);
		EditingUtils.setEEFtype(estimatedAccess, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.estimatedAccess, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedAccessText

		// End of user code
		return parent;
	}

	
	protected Composite createHistorizedCheckbox(Composite parent) {
		historized = new Button(parent, SWT.CHECK);
		historized.setText(getDescription(EntityViewsRepository.Persistence.Properties.historized, EntityMessages.PersistencePropertiesEditionPart_HistorizedLabel));
		historized.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, EntityViewsRepository.Persistence.Properties.historized, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(historized.getSelection())));
			}

		});
		GridData historizedData = new GridData(GridData.FILL_HORIZONTAL);
		historizedData.horizontalSpan = 2;
		historized.setLayoutData(historizedData);
		EditingUtils.setID(historized, EntityViewsRepository.Persistence.Properties.historized);
		EditingUtils.setEEFtype(historized, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.historized, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHistorizedCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createInheritanceKindEMFComboViewer(Composite parent) {
		createDescription(parent, EntityViewsRepository.Persistence.Properties.inheritanceKind, EntityMessages.PersistencePropertiesEditionPart_InheritanceKindLabel);
		inheritanceKind = new EMFComboViewer(parent);
		inheritanceKind.setContentProvider(new ArrayContentProvider());
		inheritanceKind.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inheritanceKindData = new GridData(GridData.FILL_HORIZONTAL);
		inheritanceKind.getCombo().setLayoutData(inheritanceKindData);
		inheritanceKind.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, EntityViewsRepository.Persistence.Properties.inheritanceKind, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInheritanceKind()));
			}

		});
		inheritanceKind.setID(EntityViewsRepository.Persistence.Properties.inheritanceKind);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.inheritanceKind, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInheritanceKindEMFComboViewer

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
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#getEstimatedVolumetry()
	 * 
	 */
	public String getEstimatedVolumetry() {
		return estimatedVolumetry.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#setEstimatedVolumetry(String newValue)
	 * 
	 */
	public void setEstimatedVolumetry(String newValue) {
		if (newValue != null) {
			estimatedVolumetry.setText(newValue);
		} else {
			estimatedVolumetry.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Persistence.Properties.estimatedVolumetry);
		if (eefElementEditorReadOnlyState && estimatedVolumetry.isEnabled()) {
			estimatedVolumetry.setEnabled(false);
			estimatedVolumetry.setToolTipText(EntityMessages.Persistence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !estimatedVolumetry.isEnabled()) {
			estimatedVolumetry.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#getEstimatedAccess()
	 * 
	 */
	public String getEstimatedAccess() {
		return estimatedAccess.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#setEstimatedAccess(String newValue)
	 * 
	 */
	public void setEstimatedAccess(String newValue) {
		if (newValue != null) {
			estimatedAccess.setText(newValue);
		} else {
			estimatedAccess.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Persistence.Properties.estimatedAccess);
		if (eefElementEditorReadOnlyState && estimatedAccess.isEnabled()) {
			estimatedAccess.setEnabled(false);
			estimatedAccess.setToolTipText(EntityMessages.Persistence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !estimatedAccess.isEnabled()) {
			estimatedAccess.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#getHistorized()
	 * 
	 */
	public Boolean getHistorized() {
		return Boolean.valueOf(historized.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#setHistorized(Boolean newValue)
	 * 
	 */
	public void setHistorized(Boolean newValue) {
		if (newValue != null) {
			historized.setSelection(newValue.booleanValue());
		} else {
			historized.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Persistence.Properties.historized);
		if (eefElementEditorReadOnlyState && historized.isEnabled()) {
			historized.setEnabled(false);
			historized.setToolTipText(EntityMessages.Persistence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !historized.isEnabled()) {
			historized.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#getInheritanceKind()
	 * 
	 */
	public Enumerator getInheritanceKind() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inheritanceKind.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#initInheritanceKind(Object input, Enumerator current)
	 */
	public void initInheritanceKind(Object input, Enumerator current) {
		inheritanceKind.setInput(input);
		inheritanceKind.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Persistence.Properties.inheritanceKind);
		if (eefElementEditorReadOnlyState && inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(false);
			inheritanceKind.setToolTipText(EntityMessages.Persistence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart#setInheritanceKind(Enumerator newValue)
	 * 
	 */
	public void setInheritanceKind(Enumerator newValue) {
		inheritanceKind.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Persistence.Properties.inheritanceKind);
		if (eefElementEditorReadOnlyState && inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(false);
			inheritanceKind.setToolTipText(EntityMessages.Persistence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EntityMessages.Persistence_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
