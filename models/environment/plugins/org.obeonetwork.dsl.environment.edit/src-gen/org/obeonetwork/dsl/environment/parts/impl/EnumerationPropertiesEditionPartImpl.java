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
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class EnumerationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EnumerationPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable literals;
	protected List<ViewerFilter> literalsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> literalsFilters = new ArrayList<ViewerFilter>();
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EnumerationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence enumerationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = enumerationStep.addStep(EnvironmentViewsRepository.Enumeration.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.Enumeration.Properties.name);
		propertiesStep.addStep(EnvironmentViewsRepository.Enumeration.Properties.literals);
		propertiesStep.addStep(EnvironmentViewsRepository.Enumeration.Properties.description);
		
		
		composer = new PartComposer(enumerationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.Enumeration.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EnvironmentViewsRepository.Enumeration.Properties.name) {
					return createNameText(parent);
				}
				if (key == EnvironmentViewsRepository.Enumeration.Properties.literals) {
					return createLiteralsAdvancedTableComposition(parent);
				}
				if (key == EnvironmentViewsRepository.Enumeration.Properties.description) {
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
		propertiesGroup.setText(EnvironmentMessages.EnumerationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Enumeration.Properties.name, EnvironmentMessages.EnumerationPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EnvironmentViewsRepository.Enumeration.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Enumeration.Properties.name, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createLiteralsAdvancedTableComposition(Composite parent) {
		this.literals = new ReferencesTable(getDescription(EnvironmentViewsRepository.Enumeration.Properties.literals, EnvironmentMessages.EnumerationPropertiesEditionPart_LiteralsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.literals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				literals.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.literals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				literals.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.literals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				literals.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.literals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				literals.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.literalsFilters) {
			this.literals.addFilter(filter);
		}
		this.literals.setHelpText(propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Enumeration.Properties.literals, EnvironmentViewsRepository.SWT_KIND));
		this.literals.createControls(parent);
		this.literals.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.literals, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData literalsData = new GridData(GridData.FILL_HORIZONTAL);
		literalsData.horizontalSpan = 3;
		this.literals.setLayoutData(literalsData);
		this.literals.setLowerBound(1);
		this.literals.setUpperBound(-1);
		literals.setID(EnvironmentViewsRepository.Enumeration.Properties.literals);
		literals.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createLiteralsAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, EnvironmentViewsRepository.Enumeration.Properties.description, EnvironmentMessages.EnumerationPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnumerationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Enumeration.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, EnvironmentViewsRepository.Enumeration.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Enumeration.Properties.description, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Enumeration.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EnvironmentMessages.Enumeration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#initLiterals(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initLiterals(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		literals.setContentProvider(contentProvider);
		literals.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Enumeration.Properties.literals);
		if (eefElementEditorReadOnlyState && literals.isEnabled()) {
			literals.setEnabled(false);
			literals.setToolTipText(EnvironmentMessages.Enumeration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !literals.isEnabled()) {
			literals.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#updateLiterals()
	 * 
	 */
	public void updateLiterals() {
	literals.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#addFilterLiterals(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLiterals(ViewerFilter filter) {
		literalsFilters.add(filter);
		if (this.literals != null) {
			this.literals.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#addBusinessFilterLiterals(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLiterals(ViewerFilter filter) {
		literalsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#isContainedInLiteralsTable(EObject element)
	 * 
	 */
	public boolean isContainedInLiteralsTable(EObject element) {
		return ((ReferencesTableSettings)literals.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Enumeration.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(EnvironmentMessages.Enumeration_ReadOnly);
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
		return EnvironmentMessages.Enumeration_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
