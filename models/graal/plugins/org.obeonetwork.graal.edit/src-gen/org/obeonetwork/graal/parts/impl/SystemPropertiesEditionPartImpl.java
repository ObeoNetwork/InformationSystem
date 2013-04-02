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
import org.obeonetwork.graal.parts.SystemPropertiesEditionPart;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class SystemPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SystemPropertiesEditionPart {

	protected Text name;
	protected Text description;
	protected ReferencesTable dtoCategories;
	protected List<ViewerFilter> dtoCategoriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> dtoCategoriesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable dtos;
	protected List<ViewerFilter> dtosBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> dtosFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable entityBlocks;
	protected List<ViewerFilter> entityBlocksBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> entityBlocksFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable entities;
	protected List<ViewerFilter> entitiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> entitiesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SystemPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence systemStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = systemStep.addStep(GraalViewsRepository.System.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.System.Properties.name);
		propertiesStep.addStep(GraalViewsRepository.System.Properties.description);
		propertiesStep.addStep(GraalViewsRepository.System.Properties.dtoCategories);
		propertiesStep.addStep(GraalViewsRepository.System.Properties.dtos);
		propertiesStep.addStep(GraalViewsRepository.System.Properties.entityBlocks);
		propertiesStep.addStep(GraalViewsRepository.System.Properties.entities);
		
		
		composer = new PartComposer(systemStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.System.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalViewsRepository.System.Properties.name) {
					return createNameText(parent);
				}
				if (key == GraalViewsRepository.System.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				if (key == GraalViewsRepository.System.Properties.dtoCategories) {
					return createDtoCategoriesAdvancedReferencesTable(parent);
				}
				if (key == GraalViewsRepository.System.Properties.dtos) {
					return createDtosAdvancedReferencesTable(parent);
				}
				if (key == GraalViewsRepository.System.Properties.entityBlocks) {
					return createEntityBlocksAdvancedReferencesTable(parent);
				}
				if (key == GraalViewsRepository.System.Properties.entities) {
					return createEntitiesAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(GraalMessages.SystemPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, GraalViewsRepository.System.Properties.name, GraalMessages.SystemPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, GraalViewsRepository.System.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.System.Properties.name, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, GraalViewsRepository.System.Properties.description, GraalMessages.SystemPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, GraalViewsRepository.System.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.System.Properties.description, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createDtoCategoriesAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.System.Properties.dtoCategories, GraalMessages.SystemPropertiesEditionPart_DtoCategoriesLabel);		 
		this.dtoCategories = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addDtoCategories(); }
			public void handleEdit(EObject element) { editDtoCategories(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveDtoCategories(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromDtoCategories(element); }
			public void navigateTo(EObject element) { }
		});
		this.dtoCategories.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.System.Properties.dtoCategories, GraalViewsRepository.SWT_KIND));
		this.dtoCategories.createControls(parent);
		this.dtoCategories.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtoCategories, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData dtoCategoriesData = new GridData(GridData.FILL_HORIZONTAL);
		dtoCategoriesData.horizontalSpan = 3;
		this.dtoCategories.setLayoutData(dtoCategoriesData);
		this.dtoCategories.disableMove();
		dtoCategories.setID(GraalViewsRepository.System.Properties.dtoCategories);
		dtoCategories.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addDtoCategories() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(dtoCategories.getInput(), dtoCategoriesFilters, dtoCategoriesBusinessFilters,
		"dtoCategories", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtoCategories,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				dtoCategories.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveDtoCategories(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtoCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		dtoCategories.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromDtoCategories(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtoCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		dtoCategories.refresh();
	}

	/**
	 * 
	 */
	protected void editDtoCategories(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				dtoCategories.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createDtosAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.System.Properties.dtos, GraalMessages.SystemPropertiesEditionPart_DtosLabel);		 
		this.dtos = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addDtos(); }
			public void handleEdit(EObject element) { editDtos(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveDtos(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromDtos(element); }
			public void navigateTo(EObject element) { }
		});
		this.dtos.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.System.Properties.dtos, GraalViewsRepository.SWT_KIND));
		this.dtos.createControls(parent);
		this.dtos.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtos, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData dtosData = new GridData(GridData.FILL_HORIZONTAL);
		dtosData.horizontalSpan = 3;
		this.dtos.setLayoutData(dtosData);
		this.dtos.disableMove();
		dtos.setID(GraalViewsRepository.System.Properties.dtos);
		dtos.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addDtos() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(dtos.getInput(), dtosFilters, dtosBusinessFilters,
		"dtos", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtos,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				dtos.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveDtos(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtos, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		dtos.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromDtos(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.dtos, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		dtos.refresh();
	}

	/**
	 * 
	 */
	protected void editDtos(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				dtos.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createEntityBlocksAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.System.Properties.entityBlocks, GraalMessages.SystemPropertiesEditionPart_EntityBlocksLabel);		 
		this.entityBlocks = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEntityBlocks(); }
			public void handleEdit(EObject element) { editEntityBlocks(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEntityBlocks(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEntityBlocks(element); }
			public void navigateTo(EObject element) { }
		});
		this.entityBlocks.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.System.Properties.entityBlocks, GraalViewsRepository.SWT_KIND));
		this.entityBlocks.createControls(parent);
		this.entityBlocks.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entityBlocks, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData entityBlocksData = new GridData(GridData.FILL_HORIZONTAL);
		entityBlocksData.horizontalSpan = 3;
		this.entityBlocks.setLayoutData(entityBlocksData);
		this.entityBlocks.disableMove();
		entityBlocks.setID(GraalViewsRepository.System.Properties.entityBlocks);
		entityBlocks.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEntityBlocks() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(entityBlocks.getInput(), entityBlocksFilters, entityBlocksBusinessFilters,
		"entityBlocks", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entityBlocks,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				entityBlocks.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEntityBlocks(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entityBlocks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		entityBlocks.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEntityBlocks(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entityBlocks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		entityBlocks.refresh();
	}

	/**
	 * 
	 */
	protected void editEntityBlocks(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				entityBlocks.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createEntitiesAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.System.Properties.entities, GraalMessages.SystemPropertiesEditionPart_EntitiesLabel);		 
		this.entities = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEntities(); }
			public void handleEdit(EObject element) { editEntities(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEntities(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEntities(element); }
			public void navigateTo(EObject element) { }
		});
		this.entities.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.System.Properties.entities, GraalViewsRepository.SWT_KIND));
		this.entities.createControls(parent);
		this.entities.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entities, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData entitiesData = new GridData(GridData.FILL_HORIZONTAL);
		entitiesData.horizontalSpan = 3;
		this.entities.setLayoutData(entitiesData);
		this.entities.disableMove();
		entities.setID(GraalViewsRepository.System.Properties.entities);
		entities.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEntities() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(entities.getInput(), entitiesFilters, entitiesBusinessFilters,
		"entities", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entities,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				entities.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEntities(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		entities.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEntities(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SystemPropertiesEditionPartImpl.this, GraalViewsRepository.System.Properties.entities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		entities.refresh();
	}

	/**
	 * 
	 */
	protected void editEntities(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				entities.refresh();
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
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.System.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(GraalMessages.System_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.System.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(GraalMessages.System_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#initDtoCategories(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initDtoCategories(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		dtoCategories.setContentProvider(contentProvider);
		dtoCategories.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.System.Properties.dtoCategories);
		if (eefElementEditorReadOnlyState && dtoCategories.getTable().isEnabled()) {
			dtoCategories.setEnabled(false);
			dtoCategories.setToolTipText(GraalMessages.System_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dtoCategories.getTable().isEnabled()) {
			dtoCategories.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#updateDtoCategories()
	 * 
	 */
	public void updateDtoCategories() {
	dtoCategories.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addFilterDtoCategories(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDtoCategories(ViewerFilter filter) {
		dtoCategoriesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addBusinessFilterDtoCategories(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDtoCategories(ViewerFilter filter) {
		dtoCategoriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#isContainedInDtoCategoriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInDtoCategoriesTable(EObject element) {
		return ((ReferencesTableSettings)dtoCategories.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#initDtos(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initDtos(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		dtos.setContentProvider(contentProvider);
		dtos.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.System.Properties.dtos);
		if (eefElementEditorReadOnlyState && dtos.getTable().isEnabled()) {
			dtos.setEnabled(false);
			dtos.setToolTipText(GraalMessages.System_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dtos.getTable().isEnabled()) {
			dtos.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#updateDtos()
	 * 
	 */
	public void updateDtos() {
	dtos.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addFilterDtos(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDtos(ViewerFilter filter) {
		dtosFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addBusinessFilterDtos(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDtos(ViewerFilter filter) {
		dtosBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#isContainedInDtosTable(EObject element)
	 * 
	 */
	public boolean isContainedInDtosTable(EObject element) {
		return ((ReferencesTableSettings)dtos.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#initEntityBlocks(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEntityBlocks(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		entityBlocks.setContentProvider(contentProvider);
		entityBlocks.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.System.Properties.entityBlocks);
		if (eefElementEditorReadOnlyState && entityBlocks.getTable().isEnabled()) {
			entityBlocks.setEnabled(false);
			entityBlocks.setToolTipText(GraalMessages.System_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entityBlocks.getTable().isEnabled()) {
			entityBlocks.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#updateEntityBlocks()
	 * 
	 */
	public void updateEntityBlocks() {
	entityBlocks.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addFilterEntityBlocks(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEntityBlocks(ViewerFilter filter) {
		entityBlocksFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addBusinessFilterEntityBlocks(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEntityBlocks(ViewerFilter filter) {
		entityBlocksBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#isContainedInEntityBlocksTable(EObject element)
	 * 
	 */
	public boolean isContainedInEntityBlocksTable(EObject element) {
		return ((ReferencesTableSettings)entityBlocks.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#initEntities(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEntities(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		entities.setContentProvider(contentProvider);
		entities.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.System.Properties.entities);
		if (eefElementEditorReadOnlyState && entities.getTable().isEnabled()) {
			entities.setEnabled(false);
			entities.setToolTipText(GraalMessages.System_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entities.getTable().isEnabled()) {
			entities.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#updateEntities()
	 * 
	 */
	public void updateEntities() {
	entities.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addFilterEntities(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEntities(ViewerFilter filter) {
		entitiesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#addBusinessFilterEntities(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEntities(ViewerFilter filter) {
		entitiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.SystemPropertiesEditionPart#isContainedInEntitiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInEntitiesTable(EObject element) {
		return ((ReferencesTableSettings)entities.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.System_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
