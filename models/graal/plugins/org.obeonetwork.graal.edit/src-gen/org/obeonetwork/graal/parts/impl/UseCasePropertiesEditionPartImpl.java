/**
 * Generated with Acceleo
 */
package org.obeonetwork.graal.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.UseCasePropertiesEditionPart;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class UseCasePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, UseCasePropertiesEditionPart {

	protected Text name;
	protected Text description;
	protected ReferencesTable tasks;
	protected List<ViewerFilter> tasksBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> tasksFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable namespaces;
	protected List<ViewerFilter> namespacesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> namespacesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable types;
	protected List<ViewerFilter> typesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> typesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public UseCasePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence useCaseStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = useCaseStep.addStep(GraalViewsRepository.UseCase.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.UseCase.Properties.name);
		propertiesStep.addStep(GraalViewsRepository.UseCase.Properties.description);
		propertiesStep.addStep(GraalViewsRepository.UseCase.Properties.tasks);
		propertiesStep.addStep(GraalViewsRepository.UseCase.Properties.namespaces);
		propertiesStep.addStep(GraalViewsRepository.UseCase.Properties.types);
		
		
		composer = new PartComposer(useCaseStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.UseCase.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalViewsRepository.UseCase.Properties.name) {
					return createNameText(parent);
				}
				if (key == GraalViewsRepository.UseCase.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				if (key == GraalViewsRepository.UseCase.Properties.tasks) {
					return createTasksAdvancedReferencesTable(parent);
				}
				if (key == GraalViewsRepository.UseCase.Properties.namespaces) {
					return createNamespacesAdvancedReferencesTable(parent);
				}
				if (key == GraalViewsRepository.UseCase.Properties.types) {
					return createTypesAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(GraalMessages.UseCasePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, GraalViewsRepository.UseCase.Properties.name, GraalMessages.UseCasePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, GraalViewsRepository.UseCase.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.UseCase.Properties.name, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, GraalViewsRepository.UseCase.Properties.description, GraalMessages.UseCasePropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, GraalViewsRepository.UseCase.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.UseCase.Properties.description, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createTasksAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.UseCase.Properties.tasks, GraalMessages.UseCasePropertiesEditionPart_TasksLabel);		 
		this.tasks = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addTasks(); }
			public void handleEdit(EObject element) { editTasks(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveTasks(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromTasks(element); }
			public void navigateTo(EObject element) { }
		});
		this.tasks.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.UseCase.Properties.tasks, GraalViewsRepository.SWT_KIND));
		this.tasks.createControls(parent);
		this.tasks.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.tasks, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData tasksData = new GridData(GridData.FILL_HORIZONTAL);
		tasksData.horizontalSpan = 3;
		this.tasks.setLayoutData(tasksData);
		this.tasks.disableMove();
		tasks.setID(GraalViewsRepository.UseCase.Properties.tasks);
		tasks.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addTasks() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(tasks.getInput(), tasksFilters, tasksBusinessFilters,
		"tasks", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.tasks,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				tasks.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveTasks(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.tasks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		tasks.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromTasks(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.tasks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		tasks.refresh();
	}

	/**
	 * 
	 */
	protected void editTasks(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				tasks.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createNamespacesAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.UseCase.Properties.namespaces, GraalMessages.UseCasePropertiesEditionPart_NamespacesLabel);		 
		this.namespaces = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addNamespaces(); }
			public void handleEdit(EObject element) { editNamespaces(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveNamespaces(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromNamespaces(element); }
			public void navigateTo(EObject element) { }
		});
		this.namespaces.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.UseCase.Properties.namespaces, GraalViewsRepository.SWT_KIND));
		this.namespaces.createControls(parent);
		this.namespaces.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.namespaces, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData namespacesData = new GridData(GridData.FILL_HORIZONTAL);
		namespacesData.horizontalSpan = 3;
		this.namespaces.setLayoutData(namespacesData);
		this.namespaces.disableMove();
		namespaces.setID(GraalViewsRepository.UseCase.Properties.namespaces);
		namespaces.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addNamespaces() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(namespaces.getInput(), namespacesFilters, namespacesBusinessFilters,
		"namespaces", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.namespaces,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				namespaces.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveNamespaces(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.namespaces, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		namespaces.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromNamespaces(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.namespaces, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		namespaces.refresh();
	}

	/**
	 * 
	 */
	protected void editNamespaces(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				namespaces.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createTypesAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.UseCase.Properties.types, GraalMessages.UseCasePropertiesEditionPart_TypesLabel);		 
		this.types = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addTypes(); }
			public void handleEdit(EObject element) { editTypes(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveTypes(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromTypes(element); }
			public void navigateTo(EObject element) { }
		});
		this.types.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.UseCase.Properties.types, GraalViewsRepository.SWT_KIND));
		this.types.createControls(parent);
		this.types.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.types, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData typesData = new GridData(GridData.FILL_HORIZONTAL);
		typesData.horizontalSpan = 3;
		this.types.setLayoutData(typesData);
		this.types.disableMove();
		types.setID(GraalViewsRepository.UseCase.Properties.types);
		types.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addTypes() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(types.getInput(), typesFilters, typesBusinessFilters,
		"types", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.types,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				types.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveTypes(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		types.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromTypes(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UseCasePropertiesEditionPartImpl.this, GraalViewsRepository.UseCase.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		types.refresh();
	}

	/**
	 * 
	 */
	protected void editTypes(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				types.refresh();
			}
		}
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
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.UseCase.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(GraalMessages.UseCase_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.UseCase.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(GraalMessages.UseCase_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#initTasks(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initTasks(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		tasks.setContentProvider(contentProvider);
		tasks.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.UseCase.Properties.tasks);
		if (eefElementEditorReadOnlyState && tasks.getTable().isEnabled()) {
			tasks.setEnabled(false);
			tasks.setToolTipText(GraalMessages.UseCase_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !tasks.getTable().isEnabled()) {
			tasks.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#updateTasks()
	 * 
	 */
	public void updateTasks() {
	tasks.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#addFilterTasks(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTasks(ViewerFilter filter) {
		tasksFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#addBusinessFilterTasks(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTasks(ViewerFilter filter) {
		tasksBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#isContainedInTasksTable(EObject element)
	 * 
	 */
	public boolean isContainedInTasksTable(EObject element) {
		return ((ReferencesTableSettings)tasks.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#initNamespaces(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initNamespaces(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		namespaces.setContentProvider(contentProvider);
		namespaces.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.UseCase.Properties.namespaces);
		if (eefElementEditorReadOnlyState && namespaces.getTable().isEnabled()) {
			namespaces.setEnabled(false);
			namespaces.setToolTipText(GraalMessages.UseCase_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !namespaces.getTable().isEnabled()) {
			namespaces.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#updateNamespaces()
	 * 
	 */
	public void updateNamespaces() {
	namespaces.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#addFilterNamespaces(ViewerFilter filter)
	 * 
	 */
	public void addFilterToNamespaces(ViewerFilter filter) {
		namespacesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#addBusinessFilterNamespaces(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToNamespaces(ViewerFilter filter) {
		namespacesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#isContainedInNamespacesTable(EObject element)
	 * 
	 */
	public boolean isContainedInNamespacesTable(EObject element) {
		return ((ReferencesTableSettings)namespaces.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#initTypes(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initTypes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		types.setContentProvider(contentProvider);
		types.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.UseCase.Properties.types);
		if (eefElementEditorReadOnlyState && types.getTable().isEnabled()) {
			types.setEnabled(false);
			types.setToolTipText(GraalMessages.UseCase_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !types.getTable().isEnabled()) {
			types.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#updateTypes()
	 * 
	 */
	public void updateTypes() {
	types.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#addFilterTypes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTypes(ViewerFilter filter) {
		typesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#addBusinessFilterTypes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTypes(ViewerFilter filter) {
		typesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.UseCasePropertiesEditionPart#isContainedInTypesTable(EObject element)
	 * 
	 */
	public boolean isContainedInTypesTable(EObject element) {
		return ((ReferencesTableSettings)types.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.UseCase_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
