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
package org.obeonetwork.dsl.statemachine.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
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
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart;
import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;
import org.obeonetwork.dsl.statemachine.providers.StatemachineMessages;

// End of user code

/**
 * 
 * 
 */
public class StateMachinePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, StateMachinePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable regions;
	protected List<ViewerFilter> regionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> regionsFilters = new ArrayList<ViewerFilter>();
	protected Text keywords;
	protected Button editKeywords;
	private EList keywordsList;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StateMachinePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence stateMachine_Step = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = stateMachine_Step.addStep(StatemachineViewsRepository.StateMachine_.Properties.class);
		propertiesStep.addStep(StatemachineViewsRepository.StateMachine_.Properties.name);
		propertiesStep.addStep(StatemachineViewsRepository.StateMachine_.Properties.regions);
		propertiesStep.addStep(StatemachineViewsRepository.StateMachine_.Properties.keywords);
		propertiesStep.addStep(StatemachineViewsRepository.StateMachine_.Properties.description);
		
		
		composer = new PartComposer(stateMachine_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == StatemachineViewsRepository.StateMachine_.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == StatemachineViewsRepository.StateMachine_.Properties.name) {
					return createNameText(parent);
				}
				if (key == StatemachineViewsRepository.StateMachine_.Properties.regions) {
					return createRegionsAdvancedTableComposition(parent);
				}
				if (key == StatemachineViewsRepository.StateMachine_.Properties.keywords) {
					return createKeywordsMultiValuedEditor(parent);
				}
				if (key == StatemachineViewsRepository.StateMachine_.Properties.description) {
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
		propertiesGroup.setText(StatemachineMessages.StateMachinePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, StatemachineViewsRepository.StateMachine_.Properties.name, StatemachineMessages.StateMachinePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, StatemachineViewsRepository.StateMachine_.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.StateMachine_.Properties.name, StatemachineViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRegionsAdvancedTableComposition(Composite parent) {
		this.regions = new ReferencesTable(getDescription(StatemachineViewsRepository.StateMachine_.Properties.regions, StatemachineMessages.StateMachinePropertiesEditionPart_RegionsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.regions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				regions.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.regions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				regions.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.regions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				regions.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.regions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				regions.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.regionsFilters) {
			this.regions.addFilter(filter);
		}
		this.regions.setHelpText(propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.StateMachine_.Properties.regions, StatemachineViewsRepository.SWT_KIND));
		this.regions.createControls(parent);
		this.regions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.regions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData regionsData = new GridData(GridData.FILL_HORIZONTAL);
		regionsData.horizontalSpan = 3;
		this.regions.setLayoutData(regionsData);
		this.regions.setLowerBound(0);
		this.regions.setUpperBound(-1);
		regions.setID(StatemachineViewsRepository.StateMachine_.Properties.regions);
		regions.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRegionsAdvancedTableComposition

		// End of user code
		return parent;
	}

	protected Composite createKeywordsMultiValuedEditor(Composite parent) {
		keywords = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData keywordsData = new GridData(GridData.FILL_HORIZONTAL);
		keywordsData.horizontalSpan = 2;
		keywords.setLayoutData(keywordsData);
		EditingUtils.setID(keywords, StatemachineViewsRepository.StateMachine_.Properties.keywords);
		EditingUtils.setEEFtype(keywords, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editKeywords = new Button(parent, SWT.NONE);
		editKeywords.setText(getDescription(StatemachineViewsRepository.StateMachine_.Properties.keywords, StatemachineMessages.StateMachinePropertiesEditionPart_KeywordsLabel));
		GridData editKeywordsData = new GridData();
		editKeywords.setLayoutData(editKeywordsData);
		editKeywords.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						keywords.getShell(), "StateMachine", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						keywordsList, EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					keywordsList = dialog.getResult();
					if (keywordsList == null) {
						keywordsList = new BasicEList();
					}
					keywords.setText(keywordsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.keywords, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(keywordsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editKeywords, StatemachineViewsRepository.StateMachine_.Properties.keywords);
		EditingUtils.setEEFtype(editKeywords, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createKeywordsMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, StatemachineViewsRepository.StateMachine_.Properties.description, StatemachineMessages.StateMachinePropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StateMachinePropertiesEditionPartImpl.this, StatemachineViewsRepository.StateMachine_.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, StatemachineViewsRepository.StateMachine_.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.StateMachine_.Properties.description, StatemachineViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.StateMachine_.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(StatemachineMessages.StateMachine_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#initRegions(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRegions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		regions.setContentProvider(contentProvider);
		regions.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.StateMachine_.Properties.regions);
		if (eefElementEditorReadOnlyState && regions.isEnabled()) {
			regions.setEnabled(false);
			regions.setToolTipText(StatemachineMessages.StateMachine_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !regions.isEnabled()) {
			regions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#updateRegions()
	 * 
	 */
	public void updateRegions() {
	regions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#addFilterRegions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRegions(ViewerFilter filter) {
		regionsFilters.add(filter);
		if (this.regions != null) {
			this.regions.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#addBusinessFilterRegions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRegions(ViewerFilter filter) {
		regionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#isContainedInRegionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInRegionsTable(EObject element) {
		return ((ReferencesTableSettings)regions.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#getKeywords()
	 * 
	 */
	public EList getKeywords() {
		return keywordsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#setKeywords(EList newValue)
	 * 
	 */
	public void setKeywords(EList newValue) {
		keywordsList = newValue;
		if (newValue != null) {
			keywords.setText(keywordsList.toString());
		} else {
			keywords.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.StateMachine_.Properties.keywords);
		if (eefElementEditorReadOnlyState && keywords.isEnabled()) {
			keywords.setEnabled(false);
			keywords.setToolTipText(StatemachineMessages.StateMachine_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !keywords.isEnabled()) {
			keywords.setEnabled(true);
		}	
		
	}

	public void addToKeywords(Object newValue) {
		keywordsList.add(newValue);
		if (newValue != null) {
			keywords.setText(keywordsList.toString());
		} else {
			keywords.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToKeywords(Object newValue) {
		keywordsList.remove(newValue);
		if (newValue != null) {
			keywords.setText(keywordsList.toString());
		} else {
			keywords.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StateMachinePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.StateMachine_.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(StatemachineMessages.StateMachine_ReadOnly);
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
		return StatemachineMessages.StateMachine_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
