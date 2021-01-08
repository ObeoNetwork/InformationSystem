/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart;
import org.obeonetwork.dsl.entity.providers.EntityMessages;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class FinderPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, FinderPropertiesEditionPart {

	protected Text customizedName;
	protected EMFComboViewer multiplicity;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FinderPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence finderStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = finderStep.addStep(EntityViewsRepository.Finder.Properties.class);
		propertiesStep.addStep(EntityViewsRepository.Finder.Properties.customizedName);
		propertiesStep.addStep(EntityViewsRepository.Finder.Properties.multiplicity);
		propertiesStep.addStep(EntityViewsRepository.Finder.Properties.description);
		
		
		composer = new PartComposer(finderStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityViewsRepository.Finder.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EntityViewsRepository.Finder.Properties.customizedName) {
					return createCustomizedNameText(parent);
				}
				if (key == EntityViewsRepository.Finder.Properties.multiplicity) {
					return createMultiplicityEMFComboViewer(parent);
				}
				if (key == EntityViewsRepository.Finder.Properties.description) {
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
		propertiesGroup.setText(EntityMessages.FinderPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createCustomizedNameText(Composite parent) {
		createDescription(parent, EntityViewsRepository.Finder.Properties.customizedName, EntityMessages.FinderPropertiesEditionPart_CustomizedNameLabel);
		customizedName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData customizedNameData = new GridData(GridData.FILL_HORIZONTAL);
		customizedName.setLayoutData(customizedNameData);
		customizedName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinderPropertiesEditionPartImpl.this, EntityViewsRepository.Finder.Properties.customizedName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, customizedName.getText()));
			}

		});
		customizedName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinderPropertiesEditionPartImpl.this, EntityViewsRepository.Finder.Properties.customizedName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, customizedName.getText()));
				}
			}

		});
		EditingUtils.setID(customizedName, EntityViewsRepository.Finder.Properties.customizedName);
		EditingUtils.setEEFtype(customizedName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Finder.Properties.customizedName, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCustomizedNameText

		// End of user code
		return parent;
	}

	
	protected Composite createMultiplicityEMFComboViewer(Composite parent) {
		createDescription(parent, EntityViewsRepository.Finder.Properties.multiplicity, EntityMessages.FinderPropertiesEditionPart_MultiplicityLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinderPropertiesEditionPartImpl.this, EntityViewsRepository.Finder.Properties.multiplicity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMultiplicity()));
			}

		});
		multiplicity.setID(EntityViewsRepository.Finder.Properties.multiplicity);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Finder.Properties.multiplicity, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMultiplicityEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, EntityViewsRepository.Finder.Properties.description, EntityMessages.FinderPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FinderPropertiesEditionPartImpl.this, EntityViewsRepository.Finder.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, EntityViewsRepository.Finder.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Finder.Properties.description, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart#getCustomizedName()
	 * 
	 */
	public String getCustomizedName() {
		return customizedName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart#setCustomizedName(String newValue)
	 * 
	 */
	public void setCustomizedName(String newValue) {
		if (newValue != null) {
			customizedName.setText(newValue);
		} else {
			customizedName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Finder.Properties.customizedName);
		if (eefElementEditorReadOnlyState && customizedName.isEnabled()) {
			customizedName.setEnabled(false);
			customizedName.setToolTipText(EntityMessages.Finder_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizedName.isEnabled()) {
			customizedName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart#getMultiplicity()
	 * 
	 */
	public Enumerator getMultiplicity() {
		Enumerator selection = (Enumerator) ((StructuredSelection) multiplicity.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart#initMultiplicity(Object input, Enumerator current)
	 */
	public void initMultiplicity(Object input, Enumerator current) {
		multiplicity.setInput(input);
		multiplicity.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Finder.Properties.multiplicity);
		if (eefElementEditorReadOnlyState && multiplicity.isEnabled()) {
			multiplicity.setEnabled(false);
			multiplicity.setToolTipText(EntityMessages.Finder_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !multiplicity.isEnabled()) {
			multiplicity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart#setMultiplicity(Enumerator newValue)
	 * 
	 */
	public void setMultiplicity(Enumerator newValue) {
		multiplicity.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Finder.Properties.multiplicity);
		if (eefElementEditorReadOnlyState && multiplicity.isEnabled()) {
			multiplicity.setEnabled(false);
			multiplicity.setToolTipText(EntityMessages.Finder_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !multiplicity.isEnabled()) {
			multiplicity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.FinderPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Finder.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(EntityMessages.Finder_ReadOnly);
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
		return EntityMessages.Finder_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
