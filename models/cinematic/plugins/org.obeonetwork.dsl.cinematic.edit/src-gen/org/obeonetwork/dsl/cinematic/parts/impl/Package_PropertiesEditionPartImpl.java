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
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.providers.CinematicMessages;

// End of user code

/**
 * 
 * 
 */
public class Package_PropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, Package_PropertiesEditionPart {

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
	public Package_PropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence package_Step = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = package_Step.addStep(CinematicViewsRepository.Package_.Properties.class);
		propertiesStep.addStep(CinematicViewsRepository.Package_.Properties.name);
		propertiesStep.addStep(CinematicViewsRepository.Package_.Properties.description);
		propertiesStep.addStep(CinematicViewsRepository.Package_.Properties.subPackages);
		propertiesStep.addStep(CinematicViewsRepository.Package_.Properties.flows);
		propertiesStep.addStep(CinematicViewsRepository.Package_.Properties.viewContainers);
		
		
		composer = new PartComposer(package_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == CinematicViewsRepository.Package_.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == CinematicViewsRepository.Package_.Properties.name) {
					return createNameText(parent);
				}
				if (key == CinematicViewsRepository.Package_.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == CinematicViewsRepository.Package_.Properties.subPackages) {
					return createSubPackagesAdvancedTableComposition(parent);
				}
				if (key == CinematicViewsRepository.Package_.Properties.flows) {
					return createFlowsAdvancedTableComposition(parent);
				}
				if (key == CinematicViewsRepository.Package_.Properties.viewContainers) {
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
		propertiesGroup.setText(CinematicMessages.Package_PropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, CinematicViewsRepository.Package_.Properties.name, CinematicMessages.Package_PropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, CinematicViewsRepository.Package_.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CinematicViewsRepository.Package_.Properties.name, CinematicViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, CinematicViewsRepository.Package_.Properties.description, CinematicMessages.Package_PropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, CinematicViewsRepository.Package_.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CinematicViewsRepository.Package_.Properties.description, CinematicViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSubPackagesAdvancedTableComposition(Composite parent) {
		this.subPackages = new ReferencesTable(getDescription(CinematicViewsRepository.Package_.Properties.subPackages, CinematicMessages.Package_PropertiesEditionPart_SubPackagesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				subPackages.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				subPackages.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				subPackages.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				subPackages.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.subPackagesFilters) {
			this.subPackages.addFilter(filter);
		}
		this.subPackages.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.Package_.Properties.subPackages, CinematicViewsRepository.SWT_KIND));
		this.subPackages.createControls(parent);
		this.subPackages.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.subPackages, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData subPackagesData = new GridData(GridData.FILL_HORIZONTAL);
		subPackagesData.horizontalSpan = 3;
		this.subPackages.setLayoutData(subPackagesData);
		this.subPackages.setLowerBound(0);
		this.subPackages.setUpperBound(-1);
		subPackages.setID(CinematicViewsRepository.Package_.Properties.subPackages);
		subPackages.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createFlowsAdvancedTableComposition(Composite parent) {
		this.flows = new ReferencesTable(getDescription(CinematicViewsRepository.Package_.Properties.flows, CinematicMessages.Package_PropertiesEditionPart_FlowsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				flows.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				flows.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				flows.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				flows.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.flowsFilters) {
			this.flows.addFilter(filter);
		}
		this.flows.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.Package_.Properties.flows, CinematicViewsRepository.SWT_KIND));
		this.flows.createControls(parent);
		this.flows.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.flows, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData flowsData = new GridData(GridData.FILL_HORIZONTAL);
		flowsData.horizontalSpan = 3;
		this.flows.setLayoutData(flowsData);
		this.flows.setLowerBound(0);
		this.flows.setUpperBound(-1);
		flows.setID(CinematicViewsRepository.Package_.Properties.flows);
		flows.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createViewContainersAdvancedTableComposition(Composite parent) {
		this.viewContainers = new ReferencesTable(getDescription(CinematicViewsRepository.Package_.Properties.viewContainers, CinematicMessages.Package_PropertiesEditionPart_ViewContainersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				viewContainers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				viewContainers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				viewContainers.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				viewContainers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.viewContainersFilters) {
			this.viewContainers.addFilter(filter);
		}
		this.viewContainers.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.Package_.Properties.viewContainers, CinematicViewsRepository.SWT_KIND));
		this.viewContainers.createControls(parent);
		this.viewContainers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(Package_PropertiesEditionPartImpl.this, CinematicViewsRepository.Package_.Properties.viewContainers, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData viewContainersData = new GridData(GridData.FILL_HORIZONTAL);
		viewContainersData.horizontalSpan = 3;
		this.viewContainers.setLayoutData(viewContainersData);
		this.viewContainers.setLowerBound(0);
		this.viewContainers.setUpperBound(-1);
		viewContainers.setID(CinematicViewsRepository.Package_.Properties.viewContainers);
		viewContainers.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(CinematicViewsRepository.Package_.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(CinematicMessages.Package__ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(CinematicViewsRepository.Package_.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(CinematicMessages.Package__ReadOnly);
		} else if (!readOnly && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#initSubPackages(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubPackages(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		subPackages.setContentProvider(contentProvider);
		subPackages.setInput(settings);
		boolean readOnly = isReadOnly(CinematicViewsRepository.Package_.Properties.subPackages);
		if (readOnly && subPackages.isEnabled()) {
			subPackages.setEnabled(false);
			subPackages.setToolTipText(CinematicMessages.Package__ReadOnly);
		} else if (!readOnly && !subPackages.isEnabled()) {
			subPackages.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#updateSubPackages()
	 * 
	 */
	public void updateSubPackages() {
	subPackages.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#addFilterSubPackages(ViewerFilter filter)
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
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#addBusinessFilterSubPackages(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSubPackages(ViewerFilter filter) {
		subPackagesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#isContainedInSubPackagesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSubPackagesTable(EObject element) {
		return ((ReferencesTableSettings)subPackages.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#initFlows(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initFlows(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		flows.setContentProvider(contentProvider);
		flows.setInput(settings);
		boolean readOnly = isReadOnly(CinematicViewsRepository.Package_.Properties.flows);
		if (readOnly && flows.isEnabled()) {
			flows.setEnabled(false);
			flows.setToolTipText(CinematicMessages.Package__ReadOnly);
		} else if (!readOnly && !flows.isEnabled()) {
			flows.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#updateFlows()
	 * 
	 */
	public void updateFlows() {
	flows.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#addFilterFlows(ViewerFilter filter)
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
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#addBusinessFilterFlows(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFlows(ViewerFilter filter) {
		flowsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#isContainedInFlowsTable(EObject element)
	 * 
	 */
	public boolean isContainedInFlowsTable(EObject element) {
		return ((ReferencesTableSettings)flows.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#initViewContainers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initViewContainers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		viewContainers.setContentProvider(contentProvider);
		viewContainers.setInput(settings);
		boolean readOnly = isReadOnly(CinematicViewsRepository.Package_.Properties.viewContainers);
		if (readOnly && viewContainers.isEnabled()) {
			viewContainers.setEnabled(false);
			viewContainers.setToolTipText(CinematicMessages.Package__ReadOnly);
		} else if (!readOnly && !viewContainers.isEnabled()) {
			viewContainers.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#updateViewContainers()
	 * 
	 */
	public void updateViewContainers() {
	viewContainers.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#addFilterViewContainers(ViewerFilter filter)
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
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#addBusinessFilterViewContainers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToViewContainers(ViewerFilter filter) {
		viewContainersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.Package_PropertiesEditionPart#isContainedInViewContainersTable(EObject element)
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
		return CinematicMessages.Package__Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
