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
package org.obeonetwork.dsl.cinematic.parts.impl;

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
import org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.providers.CinematicMessages;

// End of user code

/**
 * 
 * 
 */
public class CinematicRootPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CinematicRootPropertiesEditionPart {

	protected Text name;
	protected Text description;
	protected ReferencesTable subPackages;
	protected List<ViewerFilter> subPackagesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> subPackagesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable flows;
	protected List<ViewerFilter> flowsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> flowsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable viewContainers;
	protected List<ViewerFilter> viewContainersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> viewContainersFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CinematicRootPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cinematicRootStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cinematicRootStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.class);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.name);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.description);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.subPackages);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.flows);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.viewContainers);
		
		
		composer = new PartComposer(cinematicRootStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == CinematicViewsRepository.CinematicRoot.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.name) {
					return createNameText(parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.subPackages) {
					return createSubPackagesAdvancedTableComposition(parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.flows) {
					return createFlowsAdvancedTableComposition(parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.viewContainers) {
					return createViewContainersAdvancedTableComposition(parent);
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
		propertiesGroup.setText(CinematicMessages.CinematicRootPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, CinematicViewsRepository.CinematicRoot.Properties.name, CinematicMessages.CinematicRootPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, CinematicViewsRepository.CinematicRoot.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.name, CinematicViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, CinematicViewsRepository.CinematicRoot.Properties.description, CinematicMessages.CinematicRootPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, CinematicViewsRepository.CinematicRoot.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.description, CinematicViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSubPackagesAdvancedTableComposition(Composite parent) {
		this.subPackages = new ReferencesTable(getDescription(CinematicViewsRepository.CinematicRoot.Properties.subPackages, CinematicMessages.CinematicRootPropertiesEditionPart_SubPackagesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				subPackages.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				subPackages.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				subPackages.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				subPackages.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.subPackagesFilters) {
			this.subPackages.addFilter(filter);
		}
		this.subPackages.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.subPackages, CinematicViewsRepository.SWT_KIND));
		this.subPackages.createControls(parent);
		this.subPackages.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData subPackagesData = new GridData(GridData.FILL_HORIZONTAL);
		subPackagesData.horizontalSpan = 3;
		this.subPackages.setLayoutData(subPackagesData);
		this.subPackages.setLowerBound(0);
		this.subPackages.setUpperBound(-1);
		subPackages.setID(CinematicViewsRepository.CinematicRoot.Properties.subPackages);
		subPackages.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createSubPackagesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createFlowsAdvancedTableComposition(Composite parent) {
		this.flows = new ReferencesTable(getDescription(CinematicViewsRepository.CinematicRoot.Properties.flows, CinematicMessages.CinematicRootPropertiesEditionPart_FlowsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				flows.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				flows.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				flows.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				flows.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.flowsFilters) {
			this.flows.addFilter(filter);
		}
		this.flows.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.flows, CinematicViewsRepository.SWT_KIND));
		this.flows.createControls(parent);
		this.flows.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData flowsData = new GridData(GridData.FILL_HORIZONTAL);
		flowsData.horizontalSpan = 3;
		this.flows.setLayoutData(flowsData);
		this.flows.setLowerBound(0);
		this.flows.setUpperBound(-1);
		flows.setID(CinematicViewsRepository.CinematicRoot.Properties.flows);
		flows.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createFlowsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createViewContainersAdvancedTableComposition(Composite parent) {
		this.viewContainers = new ReferencesTable(getDescription(CinematicViewsRepository.CinematicRoot.Properties.viewContainers, CinematicMessages.CinematicRootPropertiesEditionPart_ViewContainersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				viewContainers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				viewContainers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				viewContainers.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				viewContainers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.viewContainersFilters) {
			this.viewContainers.addFilter(filter);
		}
		this.viewContainers.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.viewContainers, CinematicViewsRepository.SWT_KIND));
		this.viewContainers.createControls(parent);
		this.viewContainers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartImpl.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData viewContainersData = new GridData(GridData.FILL_HORIZONTAL);
		viewContainersData.horizontalSpan = 3;
		this.viewContainers.setLayoutData(viewContainersData);
		this.viewContainers.setLowerBound(0);
		this.viewContainers.setUpperBound(-1);
		viewContainers.setID(CinematicViewsRepository.CinematicRoot.Properties.viewContainers);
		viewContainers.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createViewContainersAdvancedTableComposition

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
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(CinematicViewsRepository.CinematicRoot.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(CinematicMessages.CinematicRoot_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(CinematicViewsRepository.CinematicRoot.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(CinematicMessages.CinematicRoot_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#initSubPackages(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubPackages(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		subPackages.setContentProvider(contentProvider);
		subPackages.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(CinematicViewsRepository.CinematicRoot.Properties.subPackages);
		if (eefElementEditorReadOnlyState && subPackages.isEnabled()) {
			subPackages.setEnabled(false);
			subPackages.setToolTipText(CinematicMessages.CinematicRoot_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !subPackages.isEnabled()) {
			subPackages.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#updateSubPackages()
	 * 
	 */
	public void updateSubPackages() {
	subPackages.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addFilterSubPackages(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSubPackages(ViewerFilter filter) {
		subPackagesFilters.add(filter);
		if (this.subPackages != null) {
			this.subPackages.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addBusinessFilterSubPackages(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSubPackages(ViewerFilter filter) {
		subPackagesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#isContainedInSubPackagesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSubPackagesTable(EObject element) {
		return ((ReferencesTableSettings)subPackages.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#initFlows(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initFlows(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		flows.setContentProvider(contentProvider);
		flows.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(CinematicViewsRepository.CinematicRoot.Properties.flows);
		if (eefElementEditorReadOnlyState && flows.isEnabled()) {
			flows.setEnabled(false);
			flows.setToolTipText(CinematicMessages.CinematicRoot_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !flows.isEnabled()) {
			flows.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#updateFlows()
	 * 
	 */
	public void updateFlows() {
	flows.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addFilterFlows(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFlows(ViewerFilter filter) {
		flowsFilters.add(filter);
		if (this.flows != null) {
			this.flows.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addBusinessFilterFlows(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFlows(ViewerFilter filter) {
		flowsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#isContainedInFlowsTable(EObject element)
	 * 
	 */
	public boolean isContainedInFlowsTable(EObject element) {
		return ((ReferencesTableSettings)flows.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#initViewContainers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initViewContainers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		viewContainers.setContentProvider(contentProvider);
		viewContainers.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(CinematicViewsRepository.CinematicRoot.Properties.viewContainers);
		if (eefElementEditorReadOnlyState && viewContainers.isEnabled()) {
			viewContainers.setEnabled(false);
			viewContainers.setToolTipText(CinematicMessages.CinematicRoot_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !viewContainers.isEnabled()) {
			viewContainers.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#updateViewContainers()
	 * 
	 */
	public void updateViewContainers() {
	viewContainers.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addFilterViewContainers(ViewerFilter filter)
	 * 
	 */
	public void addFilterToViewContainers(ViewerFilter filter) {
		viewContainersFilters.add(filter);
		if (this.viewContainers != null) {
			this.viewContainers.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addBusinessFilterViewContainers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToViewContainers(ViewerFilter filter) {
		viewContainersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#isContainedInViewContainersTable(EObject element)
	 * 
	 */
	public boolean isContainedInViewContainersTable(EObject element) {
		return ((ReferencesTableSettings)viewContainers.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return CinematicMessages.CinematicRoot_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
