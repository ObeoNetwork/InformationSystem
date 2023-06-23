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
package org.obeonetwork.graal.parts.impl;

// Start of user code for imports
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

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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

import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.PersistencePropertiesEditionPart;

import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class PersistencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PersistencePropertiesEditionPart {

	protected Text estimatedVolumetry;
	protected Button historized;



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
		CompositionStep propertiesStep = persistenceStep.addStep(GraalViewsRepository.Persistence.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.Persistence.Properties.estimatedVolumetry);
		propertiesStep.addStep(GraalViewsRepository.Persistence.Properties.historized);
		
		
		composer = new PartComposer(persistenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.Persistence.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalViewsRepository.Persistence.Properties.estimatedVolumetry) {
					return createEstimatedVolumetryText(parent);
				}
				if (key == GraalViewsRepository.Persistence.Properties.historized) {
					return createHistorizedCheckbox(parent);
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
		propertiesGroup.setText(GraalMessages.PersistencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createEstimatedVolumetryText(Composite parent) {
		createDescription(parent, GraalViewsRepository.Persistence.Properties.estimatedVolumetry, GraalMessages.PersistencePropertiesEditionPart_EstimatedVolumetryLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, GraalViewsRepository.Persistence.Properties.estimatedVolumetry, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, GraalViewsRepository.Persistence.Properties.estimatedVolumetry, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
				}
			}

		});
		EditingUtils.setID(estimatedVolumetry, GraalViewsRepository.Persistence.Properties.estimatedVolumetry);
		EditingUtils.setEEFtype(estimatedVolumetry, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Persistence.Properties.estimatedVolumetry, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedVolumetryText

		// End of user code
		return parent;
	}

	
	protected Composite createHistorizedCheckbox(Composite parent) {
		historized = new Button(parent, SWT.CHECK);
		historized.setText(getDescription(GraalViewsRepository.Persistence.Properties.historized, GraalMessages.PersistencePropertiesEditionPart_HistorizedLabel));
		historized.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartImpl.this, GraalViewsRepository.Persistence.Properties.historized, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(historized.getSelection())));
			}

		});
		GridData historizedData = new GridData(GridData.FILL_HORIZONTAL);
		historizedData.horizontalSpan = 2;
		historized.setLayoutData(historizedData);
		EditingUtils.setID(historized, GraalViewsRepository.Persistence.Properties.historized);
		EditingUtils.setEEFtype(historized, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Persistence.Properties.historized, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHistorizedCheckbox

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
	 * @see org.obeonetwork.graal.parts.PersistencePropertiesEditionPart#getEstimatedVolumetry()
	 * 
	 */
	public String getEstimatedVolumetry() {
		return estimatedVolumetry.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.PersistencePropertiesEditionPart#setEstimatedVolumetry(String newValue)
	 * 
	 */
	public void setEstimatedVolumetry(String newValue) {
		if (newValue != null) {
			estimatedVolumetry.setText(newValue);
		} else {
			estimatedVolumetry.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Persistence.Properties.estimatedVolumetry);
		if (eefElementEditorReadOnlyState && estimatedVolumetry.isEnabled()) {
			estimatedVolumetry.setEnabled(false);
			estimatedVolumetry.setToolTipText(GraalMessages.Persistence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !estimatedVolumetry.isEnabled()) {
			estimatedVolumetry.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.PersistencePropertiesEditionPart#getHistorized()
	 * 
	 */
	public Boolean getHistorized() {
		return Boolean.valueOf(historized.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.PersistencePropertiesEditionPart#setHistorized(Boolean newValue)
	 * 
	 */
	public void setHistorized(Boolean newValue) {
		if (newValue != null) {
			historized.setSelection(newValue.booleanValue());
		} else {
			historized.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Persistence.Properties.historized);
		if (eefElementEditorReadOnlyState && historized.isEnabled()) {
			historized.setEnabled(false);
			historized.setToolTipText(GraalMessages.Persistence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !historized.isEnabled()) {
			historized.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.Persistence_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
