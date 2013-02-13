/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.flow.providers.FlowMessages;

// End of user code

/**
 * 
 * 
 */
public class ViewStatePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ViewStatePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable actions;
	protected List<ViewerFilter> actionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> actionsFilters = new ArrayList<ViewerFilter>();
	protected Button newInstance;
	protected Button refresh;
	protected ReferencesTable viewContainers;
	protected List<ViewerFilter> viewContainersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> viewContainersFilters = new ArrayList<ViewerFilter>();
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ViewStatePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence viewStateStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = viewStateStep.addStep(FlowViewsRepository.ViewState.Properties.class);
		propertiesStep.addStep(FlowViewsRepository.ViewState.Properties.name);
		propertiesStep.addStep(FlowViewsRepository.ViewState.Properties.actions);
		propertiesStep.addStep(FlowViewsRepository.ViewState.Properties.newInstance);
		propertiesStep.addStep(FlowViewsRepository.ViewState.Properties.refresh);
		propertiesStep.addStep(FlowViewsRepository.ViewState.Properties.viewContainers);
		propertiesStep.addStep(FlowViewsRepository.ViewState.Properties.description);
		
		
		composer = new PartComposer(viewStateStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == FlowViewsRepository.ViewState.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == FlowViewsRepository.ViewState.Properties.name) {
					return createNameText(parent);
				}
				if (key == FlowViewsRepository.ViewState.Properties.actions) {
					return createActionsAdvancedTableComposition(parent);
				}
				if (key == FlowViewsRepository.ViewState.Properties.newInstance) {
					return createNewInstanceCheckbox(parent);
				}
				if (key == FlowViewsRepository.ViewState.Properties.refresh) {
					return createRefreshCheckbox(parent);
				}
				if (key == FlowViewsRepository.ViewState.Properties.viewContainers) {
					return createViewContainersAdvancedReferencesTable(parent);
				}
				if (key == FlowViewsRepository.ViewState.Properties.description) {
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
		propertiesGroup.setText(FlowMessages.ViewStatePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, FlowViewsRepository.ViewState.Properties.name, FlowMessages.ViewStatePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, FlowViewsRepository.ViewState.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.ViewState.Properties.name, FlowViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createActionsAdvancedTableComposition(Composite parent) {
		this.actions = new ReferencesTable(getDescription(FlowViewsRepository.ViewState.Properties.actions, FlowMessages.ViewStatePropertiesEditionPart_ActionsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				actions.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				actions.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				actions.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				actions.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.actionsFilters) {
			this.actions.addFilter(filter);
		}
		this.actions.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.ViewState.Properties.actions, FlowViewsRepository.SWT_KIND));
		this.actions.createControls(parent);
		this.actions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.actions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData actionsData = new GridData(GridData.FILL_HORIZONTAL);
		actionsData.horizontalSpan = 3;
		this.actions.setLayoutData(actionsData);
		this.actions.setLowerBound(0);
		this.actions.setUpperBound(-1);
		actions.setID(FlowViewsRepository.ViewState.Properties.actions);
		actions.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createNewInstanceCheckbox(Composite parent) {
		newInstance = new Button(parent, SWT.CHECK);
		newInstance.setText(getDescription(FlowViewsRepository.ViewState.Properties.newInstance, FlowMessages.ViewStatePropertiesEditionPart_NewInstanceLabel));
		newInstance.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.newInstance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(newInstance.getSelection())));
			}

		});
		GridData newInstanceData = new GridData(GridData.FILL_HORIZONTAL);
		newInstanceData.horizontalSpan = 2;
		newInstance.setLayoutData(newInstanceData);
		EditingUtils.setID(newInstance, FlowViewsRepository.ViewState.Properties.newInstance);
		EditingUtils.setEEFtype(newInstance, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.ViewState.Properties.newInstance, FlowViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createRefreshCheckbox(Composite parent) {
		refresh = new Button(parent, SWT.CHECK);
		refresh.setText(getDescription(FlowViewsRepository.ViewState.Properties.refresh, FlowMessages.ViewStatePropertiesEditionPart_RefreshLabel));
		refresh.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.refresh, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(refresh.getSelection())));
			}

		});
		GridData refreshData = new GridData(GridData.FILL_HORIZONTAL);
		refreshData.horizontalSpan = 2;
		refresh.setLayoutData(refreshData);
		EditingUtils.setID(refresh, FlowViewsRepository.ViewState.Properties.refresh);
		EditingUtils.setEEFtype(refresh, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.ViewState.Properties.refresh, FlowViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createViewContainersAdvancedReferencesTable(Composite parent) {
		String label = getDescription(FlowViewsRepository.ViewState.Properties.viewContainers, FlowMessages.ViewStatePropertiesEditionPart_ViewContainersLabel);		 
		this.viewContainers = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addViewContainers(); }
			public void handleEdit(EObject element) { editViewContainers(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveViewContainers(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromViewContainers(element); }
			public void navigateTo(EObject element) { }
		});
		this.viewContainers.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.ViewState.Properties.viewContainers, FlowViewsRepository.SWT_KIND));
		this.viewContainers.createControls(parent);
		this.viewContainers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.viewContainers, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData viewContainersData = new GridData(GridData.FILL_HORIZONTAL);
		viewContainersData.horizontalSpan = 3;
		this.viewContainers.setLayoutData(viewContainersData);
		this.viewContainers.disableMove();
		viewContainers.setID(FlowViewsRepository.ViewState.Properties.viewContainers);
		viewContainers.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addViewContainers() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(viewContainers.getInput(), viewContainersFilters, viewContainersBusinessFilters,
		"viewContainers", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.viewContainers,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				viewContainers.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveViewContainers(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		viewContainers.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromViewContainers(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		viewContainers.refresh();
	}

	/**
	 * 
	 */
	protected void editViewContainers(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				viewContainers.refresh();
			}
		}
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, FlowViewsRepository.ViewState.Properties.description, FlowMessages.ViewStatePropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewStatePropertiesEditionPartImpl.this, FlowViewsRepository.ViewState.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, FlowViewsRepository.ViewState.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.ViewState.Properties.description, FlowViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.ViewState.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(FlowMessages.ViewState_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#initActions(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initActions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		actions.setContentProvider(contentProvider);
		actions.setInput(settings);
		boolean readOnly = isReadOnly(FlowViewsRepository.ViewState.Properties.actions);
		if (readOnly && actions.isEnabled()) {
			actions.setEnabled(false);
			actions.setToolTipText(FlowMessages.ViewState_ReadOnly);
		} else if (!readOnly && !actions.isEnabled()) {
			actions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#updateActions()
	 * 
	 */
	public void updateActions() {
	actions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#addFilterActions(ViewerFilter filter)
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
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#addBusinessFilterActions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToActions(ViewerFilter filter) {
		actionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#isContainedInActionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInActionsTable(EObject element) {
		return ((ReferencesTableSettings)actions.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#getNewInstance()
	 * 
	 */
	public Boolean getNewInstance() {
		return Boolean.valueOf(newInstance.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#setNewInstance(Boolean newValue)
	 * 
	 */
	public void setNewInstance(Boolean newValue) {
		if (newValue != null) {
			newInstance.setSelection(newValue.booleanValue());
		} else {
			newInstance.setSelection(false);
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.ViewState.Properties.newInstance);
		if (readOnly && newInstance.isEnabled()) {
			newInstance.setEnabled(false);
			newInstance.setToolTipText(FlowMessages.ViewState_ReadOnly);
		} else if (!readOnly && !newInstance.isEnabled()) {
			newInstance.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#getRefresh()
	 * 
	 */
	public Boolean getRefresh() {
		return Boolean.valueOf(refresh.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#setRefresh(Boolean newValue)
	 * 
	 */
	public void setRefresh(Boolean newValue) {
		if (newValue != null) {
			refresh.setSelection(newValue.booleanValue());
		} else {
			refresh.setSelection(false);
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.ViewState.Properties.refresh);
		if (readOnly && refresh.isEnabled()) {
			refresh.setEnabled(false);
			refresh.setToolTipText(FlowMessages.ViewState_ReadOnly);
		} else if (!readOnly && !refresh.isEnabled()) {
			refresh.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#initViewContainers(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initViewContainers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		viewContainers.setContentProvider(contentProvider);
		viewContainers.setInput(settings);
		boolean readOnly = isReadOnly(FlowViewsRepository.ViewState.Properties.viewContainers);
		if (readOnly && viewContainers.getTable().isEnabled()) {
			viewContainers.setEnabled(false);
			viewContainers.setToolTipText(FlowMessages.ViewState_ReadOnly);
		} else if (!readOnly && !viewContainers.getTable().isEnabled()) {
			viewContainers.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#updateViewContainers()
	 * 
	 */
	public void updateViewContainers() {
	viewContainers.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#addFilterViewContainers(ViewerFilter filter)
	 * 
	 */
	public void addFilterToViewContainers(ViewerFilter filter) {
		viewContainersFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#addBusinessFilterViewContainers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToViewContainers(ViewerFilter filter) {
		viewContainersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#isContainedInViewContainersTable(EObject element)
	 * 
	 */
	public boolean isContainedInViewContainersTable(EObject element) {
		return ((ReferencesTableSettings)viewContainers.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.ViewStatePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.ViewState.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(FlowMessages.ViewState_ReadOnly);
		} else if (!readOnly && !description.isEnabled()) {
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
		return FlowMessages.ViewState_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
