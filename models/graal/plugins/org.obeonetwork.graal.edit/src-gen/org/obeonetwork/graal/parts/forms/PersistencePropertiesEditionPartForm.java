/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.parts.forms;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.PersistencePropertiesEditionPart;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class PersistencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, PersistencePropertiesEditionPart {

	protected Text estimatedVolumetry;
	protected Button historized;



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
		CompositionStep propertiesStep = persistenceStep.addStep(GraalViewsRepository.Persistence.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.Persistence.Properties.estimatedVolumetry);
		propertiesStep.addStep(GraalViewsRepository.Persistence.Properties.historized);
		
		
		composer = new PartComposer(persistenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.Persistence.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == GraalViewsRepository.Persistence.Properties.estimatedVolumetry) {
					return createEstimatedVolumetryText(widgetFactory, parent);
				}
				if (key == GraalViewsRepository.Persistence.Properties.historized) {
					return createHistorizedCheckbox(widgetFactory, parent);
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
		propertiesSection.setText(GraalMessages.PersistencePropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, GraalViewsRepository.Persistence.Properties.estimatedVolumetry, GraalMessages.PersistencePropertiesEditionPart_EstimatedVolumetryLabel);
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
							GraalViewsRepository.Persistence.Properties.estimatedVolumetry,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PersistencePropertiesEditionPartForm.this,
									GraalViewsRepository.Persistence.Properties.estimatedVolumetry,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartForm.this, GraalViewsRepository.Persistence.Properties.estimatedVolumetry, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
				}
			}
		});
		EditingUtils.setID(estimatedVolumetry, GraalViewsRepository.Persistence.Properties.estimatedVolumetry);
		EditingUtils.setEEFtype(estimatedVolumetry, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Persistence.Properties.estimatedVolumetry, GraalViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedVolumetryText

		// End of user code
		return parent;
	}

	
	protected Composite createHistorizedCheckbox(FormToolkit widgetFactory, Composite parent) {
		historized = widgetFactory.createButton(parent, getDescription(GraalViewsRepository.Persistence.Properties.historized, GraalMessages.PersistencePropertiesEditionPart_HistorizedLabel), SWT.CHECK);
		historized.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistencePropertiesEditionPartForm.this, GraalViewsRepository.Persistence.Properties.historized, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(historized.getSelection())));
			}

		});
		GridData historizedData = new GridData(GridData.FILL_HORIZONTAL);
		historizedData.horizontalSpan = 2;
		historized.setLayoutData(historizedData);
		EditingUtils.setID(historized, GraalViewsRepository.Persistence.Properties.historized);
		EditingUtils.setEEFtype(historized, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Persistence.Properties.historized, GraalViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
