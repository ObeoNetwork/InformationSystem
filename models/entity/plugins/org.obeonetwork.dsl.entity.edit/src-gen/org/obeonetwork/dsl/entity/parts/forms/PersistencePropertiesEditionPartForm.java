/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart;

import org.obeonetwork.dsl.entity.providers.EntityMessages;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class PersistencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, PersistencePropertiesEditionPart {

	protected Text estimatedVolumetry;
	protected Text estimatedAccess;
	protected Button historized;
	protected EMFComboViewer inheritanceKind;



	/**
	 * For {@link ISection} use only.
	 */
	public PersistencePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PersistencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
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
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.estimatedVolumetry) {
					return createEstimatedVolumetryText(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.estimatedAccess) {
					return createEstimatedAccessText(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.historized) {
					return createHistorizedCheckbox(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Persistence.Properties.inheritanceKind) {
					return createInheritanceKindEMFComboViewer(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EntityMessages.PersistencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createEstimatedVolumetryText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityViewsRepository.Persistence.Properties.estimatedVolumetry, EntityMessages.PersistencePropertiesEditionPart_EstimatedVolumetryLabel);
		estimatedVolumetry = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		estimatedVolumetry.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData estimatedVolumetryData = new GridData(GridData.FILL_HORIZONTAL);
		estimatedVolumetry.setLayoutData(estimatedVolumetryData);
		estimatedVolumetry.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PersistencePropertiesEditionPartForm.this,
							EntityViewsRepository.Persistence.Properties.estimatedVolumetry,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PersistencePropertiesEditionPartForm.this,
									EntityViewsRepository.Persistence.Properties.estimatedVolumetry,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, estimatedVolumetry.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PersistencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		estimatedVolumetry.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartForm.this, EntityViewsRepository.Persistence.Properties.estimatedVolumetry, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
				}
			}
		});
		EditingUtils.setID(estimatedVolumetry, EntityViewsRepository.Persistence.Properties.estimatedVolumetry);
		EditingUtils.setEEFtype(estimatedVolumetry, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.estimatedVolumetry, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedVolumetryText

		// End of user code
		return parent;
	}

	
	protected Composite createEstimatedAccessText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityViewsRepository.Persistence.Properties.estimatedAccess, EntityMessages.PersistencePropertiesEditionPart_EstimatedAccessLabel);
		estimatedAccess = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		estimatedAccess.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData estimatedAccessData = new GridData(GridData.FILL_HORIZONTAL);
		estimatedAccess.setLayoutData(estimatedAccessData);
		estimatedAccess.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PersistencePropertiesEditionPartForm.this,
							EntityViewsRepository.Persistence.Properties.estimatedAccess,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedAccess.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PersistencePropertiesEditionPartForm.this,
									EntityViewsRepository.Persistence.Properties.estimatedAccess,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, estimatedAccess.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PersistencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		estimatedAccess.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartForm.this, EntityViewsRepository.Persistence.Properties.estimatedAccess, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedAccess.getText()));
				}
			}
		});
		EditingUtils.setID(estimatedAccess, EntityViewsRepository.Persistence.Properties.estimatedAccess);
		EditingUtils.setEEFtype(estimatedAccess, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.estimatedAccess, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedAccessText

		// End of user code
		return parent;
	}

	
	protected Composite createHistorizedCheckbox(FormToolkit widgetFactory, Composite parent) {
		historized = widgetFactory.createButton(parent, getDescription(EntityViewsRepository.Persistence.Properties.historized, EntityMessages.PersistencePropertiesEditionPart_HistorizedLabel), SWT.CHECK);
		historized.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartForm.this, EntityViewsRepository.Persistence.Properties.historized, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(historized.getSelection())));
			}

		});
		GridData historizedData = new GridData(GridData.FILL_HORIZONTAL);
		historizedData.horizontalSpan = 2;
		historized.setLayoutData(historizedData);
		EditingUtils.setID(historized, EntityViewsRepository.Persistence.Properties.historized);
		EditingUtils.setEEFtype(historized, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.historized, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHistorizedCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createInheritanceKindEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartForm.this, EntityViewsRepository.Persistence.Properties.inheritanceKind, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInheritanceKind()));
			}

		});
		inheritanceKind.setID(EntityViewsRepository.Persistence.Properties.inheritanceKind);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Persistence.Properties.inheritanceKind, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
