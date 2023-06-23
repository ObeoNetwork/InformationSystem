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
package org.obeonetwork.dsl.cinematic.view.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.cinematic.view.providers.ViewMessages;

// End of user code

/**
 * 
 * 
 */
public class ViewContainerPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ViewContainerPropertiesEditionPart {

	protected Text name;
	protected Text label;
	protected EObjectFlatComboViewer widget;
	protected ReferencesTable actions;
	protected List<ViewerFilter> actionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> actionsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable events;
	protected List<ViewerFilter> eventsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eventsFilters = new ArrayList<ViewerFilter>();
	protected Text description;
	protected ReferencesTable ownedElements;
	protected List<ViewerFilter> ownedElementsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ownedElementsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ViewContainerPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence viewContainerStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = viewContainerStep.addStep(ViewViewsRepository.ViewContainer.Properties.class);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.name);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.label);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.widget);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.actions);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.events);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.description);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.ownedElements);
		
		
		composer = new PartComposer(viewContainerStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ViewViewsRepository.ViewContainer.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.name) {
					return createNameText(parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.label) {
					return createLabelText(parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.widget) {
					return createWidgetFlatComboViewer(parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.actions) {
					return createActionsAdvancedTableComposition(parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.events) {
					return createEventsAdvancedTableComposition(parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.ownedElements) {
					return createOwnedElementsAdvancedTableComposition(parent);
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
		propertiesGroup.setText(ViewMessages.ViewContainerPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, ViewViewsRepository.ViewContainer.Properties.name, ViewMessages.ViewContainerPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, ViewViewsRepository.ViewContainer.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.name, ViewViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createLabelText(Composite parent) {
		createDescription(parent, ViewViewsRepository.ViewContainer.Properties.label, ViewMessages.ViewContainerPropertiesEditionPart_LabelLabel);
		label = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData labelData = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(labelData);
		label.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.label, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, label.getText()));
			}

		});
		label.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.label, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, label.getText()));
				}
			}

		});
		EditingUtils.setID(label, ViewViewsRepository.ViewContainer.Properties.label);
		EditingUtils.setEEFtype(label, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.label, ViewViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLabelText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createWidgetFlatComboViewer(Composite parent) {
		createDescription(parent, ViewViewsRepository.ViewContainer.Properties.widget, ViewMessages.ViewContainerPropertiesEditionPart_WidgetLabel);
		widget = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ViewViewsRepository.ViewContainer.Properties.widget, ViewViewsRepository.SWT_KIND));
		widget.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		widget.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.widget, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getWidget()));
			}

		});
		GridData widgetData = new GridData(GridData.FILL_HORIZONTAL);
		widget.setLayoutData(widgetData);
		widget.setID(ViewViewsRepository.ViewContainer.Properties.widget);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.widget, ViewViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createWidgetFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createActionsAdvancedTableComposition(Composite parent) {
		this.actions = new ReferencesTable(getDescription(ViewViewsRepository.ViewContainer.Properties.actions, ViewMessages.ViewContainerPropertiesEditionPart_ActionsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				actions.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				actions.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				actions.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				actions.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.actionsFilters) {
			this.actions.addFilter(filter);
		}
		this.actions.setHelpText(propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.actions, ViewViewsRepository.SWT_KIND));
		this.actions.createControls(parent);
		this.actions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData actionsData = new GridData(GridData.FILL_HORIZONTAL);
		actionsData.horizontalSpan = 3;
		this.actions.setLayoutData(actionsData);
		this.actions.setLowerBound(0);
		this.actions.setUpperBound(-1);
		actions.setID(ViewViewsRepository.ViewContainer.Properties.actions);
		actions.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createActionsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEventsAdvancedTableComposition(Composite parent) {
		this.events = new ReferencesTable(getDescription(ViewViewsRepository.ViewContainer.Properties.events, ViewMessages.ViewContainerPropertiesEditionPart_EventsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				events.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				events.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				events.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				events.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eventsFilters) {
			this.events.addFilter(filter);
		}
		this.events.setHelpText(propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.events, ViewViewsRepository.SWT_KIND));
		this.events.createControls(parent);
		this.events.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eventsData = new GridData(GridData.FILL_HORIZONTAL);
		eventsData.horizontalSpan = 3;
		this.events.setLayoutData(eventsData);
		this.events.setLowerBound(0);
		this.events.setUpperBound(-1);
		events.setID(ViewViewsRepository.ViewContainer.Properties.events);
		events.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createEventsAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, ViewViewsRepository.ViewContainer.Properties.description, ViewMessages.ViewContainerPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, ViewViewsRepository.ViewContainer.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.description, ViewViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOwnedElementsAdvancedTableComposition(Composite parent) {
		this.ownedElements = new ReferencesTable(getDescription(ViewViewsRepository.ViewContainer.Properties.ownedElements, ViewMessages.ViewContainerPropertiesEditionPart_OwnedElementsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ownedElements.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ownedElements.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ownedElements.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ownedElements.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ownedElementsFilters) {
			this.ownedElements.addFilter(filter);
		}
		this.ownedElements.setHelpText(propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.ownedElements, ViewViewsRepository.SWT_KIND));
		this.ownedElements.createControls(parent);
		this.ownedElements.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartImpl.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ownedElementsData = new GridData(GridData.FILL_HORIZONTAL);
		ownedElementsData.horizontalSpan = 3;
		this.ownedElements.setLayoutData(ownedElementsData);
		this.ownedElements.setLowerBound(0);
		this.ownedElements.setUpperBound(-1);
		ownedElements.setID(ViewViewsRepository.ViewContainer.Properties.ownedElements);
		ownedElements.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOwnedElementsAdvancedTableComposition

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
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getLabel()
	 * 
	 */
	public String getLabel() {
		return label.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setLabel(String newValue)
	 * 
	 */
	public void setLabel(String newValue) {
		if (newValue != null) {
			label.setText(newValue);
		} else {
			label.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.label);
		if (eefElementEditorReadOnlyState && label.isEnabled()) {
			label.setEnabled(false);
			label.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !label.isEnabled()) {
			label.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getWidget()
	 * 
	 */
	public EObject getWidget() {
		if (widget.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) widget.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initWidget(EObjectFlatComboSettings)
	 */
	public void initWidget(EObjectFlatComboSettings settings) {
		widget.setInput(settings);
		if (current != null) {
			widget.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.widget);
		if (eefElementEditorReadOnlyState && widget.isEnabled()) {
			widget.setEnabled(false);
			widget.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !widget.isEnabled()) {
			widget.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setWidget(EObject newValue)
	 * 
	 */
	public void setWidget(EObject newValue) {
		if (newValue != null) {
			widget.setSelection(new StructuredSelection(newValue));
		} else {
			widget.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.widget);
		if (eefElementEditorReadOnlyState && widget.isEnabled()) {
			widget.setEnabled(false);
			widget.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !widget.isEnabled()) {
			widget.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setWidgetButtonMode(ButtonsModeEnum newValue)
	 */
	public void setWidgetButtonMode(ButtonsModeEnum newValue) {
		widget.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterWidget(ViewerFilter filter)
	 * 
	 */
	public void addFilterToWidget(ViewerFilter filter) {
		widget.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterWidget(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToWidget(ViewerFilter filter) {
		widget.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initActions(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initActions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		actions.setContentProvider(contentProvider);
		actions.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.actions);
		if (eefElementEditorReadOnlyState && actions.isEnabled()) {
			actions.setEnabled(false);
			actions.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !actions.isEnabled()) {
			actions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#updateActions()
	 * 
	 */
	public void updateActions() {
	actions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterActions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToActions(ViewerFilter filter) {
		actionsFilters.add(filter);
		if (this.actions != null) {
			this.actions.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterActions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToActions(ViewerFilter filter) {
		actionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#isContainedInActionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInActionsTable(EObject element) {
		return ((ReferencesTableSettings)actions.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initEvents(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEvents(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		events.setContentProvider(contentProvider);
		events.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.events);
		if (eefElementEditorReadOnlyState && events.isEnabled()) {
			events.setEnabled(false);
			events.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !events.isEnabled()) {
			events.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#updateEvents()
	 * 
	 */
	public void updateEvents() {
	events.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterEvents(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEvents(ViewerFilter filter) {
		eventsFilters.add(filter);
		if (this.events != null) {
			this.events.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterEvents(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEvents(ViewerFilter filter) {
		eventsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#isContainedInEventsTable(EObject element)
	 * 
	 */
	public boolean isContainedInEventsTable(EObject element) {
		return ((ReferencesTableSettings)events.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initOwnedElements(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedElements(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ownedElements.setContentProvider(contentProvider);
		ownedElements.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ViewViewsRepository.ViewContainer.Properties.ownedElements);
		if (eefElementEditorReadOnlyState && ownedElements.isEnabled()) {
			ownedElements.setEnabled(false);
			ownedElements.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ownedElements.isEnabled()) {
			ownedElements.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#updateOwnedElements()
	 * 
	 */
	public void updateOwnedElements() {
	ownedElements.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterOwnedElements(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOwnedElements(ViewerFilter filter) {
		ownedElementsFilters.add(filter);
		if (this.ownedElements != null) {
			this.ownedElements.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterOwnedElements(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOwnedElements(ViewerFilter filter) {
		ownedElementsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#isContainedInOwnedElementsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOwnedElementsTable(EObject element) {
		return ((ReferencesTableSettings)ownedElements.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ViewMessages.ViewContainer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
