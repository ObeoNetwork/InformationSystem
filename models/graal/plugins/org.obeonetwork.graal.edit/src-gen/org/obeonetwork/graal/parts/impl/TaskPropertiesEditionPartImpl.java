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
package org.obeonetwork.graal.parts.impl;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.TaskPropertiesEditionPart;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class TaskPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TaskPropertiesEditionPart {

	protected Text id;
	protected Text name;
	protected Text description;
	protected Text preconditions;
	protected Text postconditions;
	protected ReferencesTable subActivities;
	protected List<ViewerFilter> subActivitiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> subActivitiesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable actors;
	protected List<ViewerFilter> actorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> actorsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable uses;
	protected List<ViewerFilter> usesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> usesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TaskPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence taskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = taskStep.addStep(GraalViewsRepository.Task.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.id);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.name);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.description);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.preconditions);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.postconditions);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.subActivities);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.actors);
		propertiesStep.addStep(GraalViewsRepository.Task.Properties.uses);
		
		
		composer = new PartComposer(taskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.Task.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.id) {
					return createIdText(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.name) {
					return createNameText(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.preconditions) {
					return createPreconditionsTextarea(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.postconditions) {
					return createPostconditionsTextarea(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.subActivities) {
					return createSubActivitiesAdvancedTableComposition(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.actors) {
					return createActorsAdvancedReferencesTable(parent);
				}
				if (key == GraalViewsRepository.Task.Properties.uses) {
					return createUsesAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(GraalMessages.TaskPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createIdText(Composite parent) {
		createDescription(parent, GraalViewsRepository.Task.Properties.id, GraalMessages.TaskPropertiesEditionPart_IdLabel);
		id = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData idData = new GridData(GridData.FILL_HORIZONTAL);
		id.setLayoutData(idData);
		id.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
			}

		});
		id.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, GraalViewsRepository.Task.Properties.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.id, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, GraalViewsRepository.Task.Properties.name, GraalMessages.TaskPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, GraalViewsRepository.Task.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.name, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, GraalViewsRepository.Task.Properties.description, GraalMessages.TaskPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, GraalViewsRepository.Task.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.description, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}

	
	protected Composite createPreconditionsTextarea(Composite parent) {
		Label preconditionsLabel = createDescription(parent, GraalViewsRepository.Task.Properties.preconditions, GraalMessages.TaskPropertiesEditionPart_PreconditionsLabel);
		GridData preconditionsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		preconditionsLabelData.horizontalSpan = 3;
		preconditionsLabel.setLayoutData(preconditionsLabelData);
		preconditions = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData preconditionsData = new GridData(GridData.FILL_HORIZONTAL);
		preconditionsData.horizontalSpan = 2;
		preconditionsData.heightHint = 80;
		preconditionsData.widthHint = 200;
		preconditions.setLayoutData(preconditionsData);
		preconditions.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.preconditions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, preconditions.getText()));
			}

		});
		EditingUtils.setID(preconditions, GraalViewsRepository.Task.Properties.preconditions);
		EditingUtils.setEEFtype(preconditions, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.preconditions, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPreconditionsTextArea

		// End of user code
		return parent;
	}

	
	protected Composite createPostconditionsTextarea(Composite parent) {
		Label postconditionsLabel = createDescription(parent, GraalViewsRepository.Task.Properties.postconditions, GraalMessages.TaskPropertiesEditionPart_PostconditionsLabel);
		GridData postconditionsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		postconditionsLabelData.horizontalSpan = 3;
		postconditionsLabel.setLayoutData(postconditionsLabelData);
		postconditions = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData postconditionsData = new GridData(GridData.FILL_HORIZONTAL);
		postconditionsData.horizontalSpan = 2;
		postconditionsData.heightHint = 80;
		postconditionsData.widthHint = 200;
		postconditions.setLayoutData(postconditionsData);
		postconditions.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.postconditions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, postconditions.getText()));
			}

		});
		EditingUtils.setID(postconditions, GraalViewsRepository.Task.Properties.postconditions);
		EditingUtils.setEEFtype(postconditions, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.postconditions, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPostconditionsTextArea

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSubActivitiesAdvancedTableComposition(Composite parent) {
		this.subActivities = new ReferencesTable(getDescription(GraalViewsRepository.Task.Properties.subActivities, GraalMessages.TaskPropertiesEditionPart_SubActivitiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				subActivities.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				subActivities.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				subActivities.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				subActivities.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.subActivitiesFilters) {
			this.subActivities.addFilter(filter);
		}
		this.subActivities.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.subActivities, GraalViewsRepository.SWT_KIND));
		this.subActivities.createControls(parent);
		this.subActivities.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.subActivities, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData subActivitiesData = new GridData(GridData.FILL_HORIZONTAL);
		subActivitiesData.horizontalSpan = 3;
		this.subActivities.setLayoutData(subActivitiesData);
		this.subActivities.setLowerBound(0);
		this.subActivities.setUpperBound(-1);
		subActivities.setID(GraalViewsRepository.Task.Properties.subActivities);
		subActivities.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createSubActivitiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createActorsAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.Task.Properties.actors, GraalMessages.TaskPropertiesEditionPart_ActorsLabel);		 
		this.actors = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addActors(); }
			public void handleEdit(EObject element) { editActors(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveActors(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromActors(element); }
			public void navigateTo(EObject element) { }
		});
		this.actors.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.actors, GraalViewsRepository.SWT_KIND));
		this.actors.createControls(parent);
		this.actors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.actors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData actorsData = new GridData(GridData.FILL_HORIZONTAL);
		actorsData.horizontalSpan = 3;
		this.actors.setLayoutData(actorsData);
		this.actors.disableMove();
		actors.setID(GraalViewsRepository.Task.Properties.actors);
		actors.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addActors() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(actors.getInput(), actorsFilters, actorsBusinessFilters,
		"actors", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.actors,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				actors.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveActors(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.actors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		actors.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromActors(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.actors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		actors.refresh();
	}

	/**
	 * 
	 */
	protected void editActors(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				actors.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createUsesAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.Task.Properties.uses, GraalMessages.TaskPropertiesEditionPart_UsesLabel);		 
		this.uses = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addUses(); }
			public void handleEdit(EObject element) { editUses(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveUses(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromUses(element); }
			public void navigateTo(EObject element) { }
		});
		this.uses.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.Task.Properties.uses, GraalViewsRepository.SWT_KIND));
		this.uses.createControls(parent);
		this.uses.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.uses, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData usesData = new GridData(GridData.FILL_HORIZONTAL);
		usesData.horizontalSpan = 3;
		this.uses.setLayoutData(usesData);
		this.uses.disableMove();
		uses.setID(GraalViewsRepository.Task.Properties.uses);
		uses.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addUses() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(uses.getInput(), usesFilters, usesBusinessFilters,
		"uses", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.uses,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				uses.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveUses(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		uses.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromUses(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, GraalViewsRepository.Task.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		uses.refresh();
	}

	/**
	 * 
	 */
	protected void editUses(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				uses.refresh();
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
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#getId()
	 * 
	 */
	public String getId() {
		return id.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#setId(String newValue)
	 * 
	 */
	public void setId(String newValue) {
		if (newValue != null) {
			id.setText(newValue);
		} else {
			id.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.id);
		if (eefElementEditorReadOnlyState && id.isEnabled()) {
			id.setEnabled(false);
			id.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
			id.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#getPreconditions()
	 * 
	 */
	public String getPreconditions() {
		return preconditions.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#setPreconditions(String newValue)
	 * 
	 */
	public void setPreconditions(String newValue) {
		if (newValue != null) {
			preconditions.setText(newValue);
		} else {
			preconditions.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.preconditions);
		if (eefElementEditorReadOnlyState && preconditions.isEnabled()) {
			preconditions.setEnabled(false);
			preconditions.setBackground(preconditions.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			preconditions.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !preconditions.isEnabled()) {
			preconditions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#getPostconditions()
	 * 
	 */
	public String getPostconditions() {
		return postconditions.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#setPostconditions(String newValue)
	 * 
	 */
	public void setPostconditions(String newValue) {
		if (newValue != null) {
			postconditions.setText(newValue);
		} else {
			postconditions.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.postconditions);
		if (eefElementEditorReadOnlyState && postconditions.isEnabled()) {
			postconditions.setEnabled(false);
			postconditions.setBackground(postconditions.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			postconditions.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !postconditions.isEnabled()) {
			postconditions.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#initSubActivities(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubActivities(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		subActivities.setContentProvider(contentProvider);
		subActivities.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.subActivities);
		if (eefElementEditorReadOnlyState && subActivities.isEnabled()) {
			subActivities.setEnabled(false);
			subActivities.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !subActivities.isEnabled()) {
			subActivities.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#updateSubActivities()
	 * 
	 */
	public void updateSubActivities() {
	subActivities.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#addFilterSubActivities(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSubActivities(ViewerFilter filter) {
		subActivitiesFilters.add(filter);
		if (this.subActivities != null) {
			this.subActivities.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#addBusinessFilterSubActivities(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSubActivities(ViewerFilter filter) {
		subActivitiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#isContainedInSubActivitiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSubActivitiesTable(EObject element) {
		return ((ReferencesTableSettings)subActivities.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#initActors(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initActors(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		actors.setContentProvider(contentProvider);
		actors.setInput(settings);
		actorsBusinessFilters.clear();
		actorsFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.actors);
		if (eefElementEditorReadOnlyState && actors.getTable().isEnabled()) {
			actors.setEnabled(false);
			actors.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !actors.getTable().isEnabled()) {
			actors.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#updateActors()
	 * 
	 */
	public void updateActors() {
	actors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#addFilterActors(ViewerFilter filter)
	 * 
	 */
	public void addFilterToActors(ViewerFilter filter) {
		actorsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#addBusinessFilterActors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToActors(ViewerFilter filter) {
		actorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#isContainedInActorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInActorsTable(EObject element) {
		return ((ReferencesTableSettings)actors.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#initUses(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initUses(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		uses.setContentProvider(contentProvider);
		uses.setInput(settings);
		usesBusinessFilters.clear();
		usesFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Task.Properties.uses);
		if (eefElementEditorReadOnlyState && uses.getTable().isEnabled()) {
			uses.setEnabled(false);
			uses.setToolTipText(GraalMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !uses.getTable().isEnabled()) {
			uses.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#updateUses()
	 * 
	 */
	public void updateUses() {
	uses.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#addFilterUses(ViewerFilter filter)
	 * 
	 */
	public void addFilterToUses(ViewerFilter filter) {
		usesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#addBusinessFilterUses(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToUses(ViewerFilter filter) {
		usesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskPropertiesEditionPart#isContainedInUsesTable(EObject element)
	 * 
	 */
	public boolean isContainedInUsesTable(EObject element) {
		return ((ReferencesTableSettings)uses.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.Task_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
