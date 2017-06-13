/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
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
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.obeonetwork.graal.parts.ActorPropertiesEditionPart;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class ActorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ActorPropertiesEditionPart {

	protected Text name;
	protected Text description;
	protected EObjectFlatComboViewer superActor;
	protected ReferencesTable subActors;
	protected List<ViewerFilter> subActorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> subActorsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ActorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence actorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = actorStep.addStep(GraalViewsRepository.Actor.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.Actor.Properties.name);
		propertiesStep.addStep(GraalViewsRepository.Actor.Properties.description);
		propertiesStep.addStep(GraalViewsRepository.Actor.Properties.superActor);
		propertiesStep.addStep(GraalViewsRepository.Actor.Properties.subActors);
		
		
		composer = new PartComposer(actorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.Actor.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalViewsRepository.Actor.Properties.name) {
					return createNameText(parent);
				}
				if (key == GraalViewsRepository.Actor.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				if (key == GraalViewsRepository.Actor.Properties.superActor) {
					return createSuperActorFlatComboViewer(parent);
				}
				if (key == GraalViewsRepository.Actor.Properties.subActors) {
					return createSubActorsAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(GraalMessages.ActorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, GraalViewsRepository.Actor.Properties.name, GraalMessages.ActorPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, GraalViewsRepository.Actor.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Actor.Properties.name, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, GraalViewsRepository.Actor.Properties.description, GraalMessages.ActorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, GraalViewsRepository.Actor.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Actor.Properties.description, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSuperActorFlatComboViewer(Composite parent) {
		createDescription(parent, GraalViewsRepository.Actor.Properties.superActor, GraalMessages.ActorPropertiesEditionPart_SuperActorLabel);
		superActor = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(GraalViewsRepository.Actor.Properties.superActor, GraalViewsRepository.SWT_KIND));
		superActor.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		superActor.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.superActor, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSuperActor()));
			}

		});
		GridData superActorData = new GridData(GridData.FILL_HORIZONTAL);
		superActor.setLayoutData(superActorData);
		superActor.setID(GraalViewsRepository.Actor.Properties.superActor);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Actor.Properties.superActor, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuperActorFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSubActorsAdvancedReferencesTable(Composite parent) {
		String label = getDescription(GraalViewsRepository.Actor.Properties.subActors, GraalMessages.ActorPropertiesEditionPart_SubActorsLabel);		 
		this.subActors = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addSubActors(); }
			public void handleEdit(EObject element) { editSubActors(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveSubActors(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromSubActors(element); }
			public void navigateTo(EObject element) { }
		});
		this.subActors.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.Actor.Properties.subActors, GraalViewsRepository.SWT_KIND));
		this.subActors.createControls(parent);
		this.subActors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.subActors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData subActorsData = new GridData(GridData.FILL_HORIZONTAL);
		subActorsData.horizontalSpan = 3;
		this.subActors.setLayoutData(subActorsData);
		this.subActors.disableMove();
		subActors.setID(GraalViewsRepository.Actor.Properties.subActors);
		subActors.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addSubActors() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(subActors.getInput(), subActorsFilters, subActorsBusinessFilters,
		"subActors", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.subActors,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				subActors.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveSubActors(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.subActors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		subActors.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromSubActors(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ActorPropertiesEditionPartImpl.this, GraalViewsRepository.Actor.Properties.subActors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		subActors.refresh();
	}

	/**
	 * 
	 */
	protected void editSubActors(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				subActors.refresh();
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
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Actor.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(GraalMessages.Actor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Actor.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(GraalMessages.Actor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#getSuperActor()
	 * 
	 */
	public EObject getSuperActor() {
		if (superActor.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) superActor.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#initSuperActor(EObjectFlatComboSettings)
	 */
	public void initSuperActor(EObjectFlatComboSettings settings) {
		superActor.setInput(settings);
		if (current != null) {
			superActor.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Actor.Properties.superActor);
		if (eefElementEditorReadOnlyState && superActor.isEnabled()) {
			superActor.setEnabled(false);
			superActor.setToolTipText(GraalMessages.Actor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !superActor.isEnabled()) {
			superActor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#setSuperActor(EObject newValue)
	 * 
	 */
	public void setSuperActor(EObject newValue) {
		if (newValue != null) {
			superActor.setSelection(new StructuredSelection(newValue));
		} else {
			superActor.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Actor.Properties.superActor);
		if (eefElementEditorReadOnlyState && superActor.isEnabled()) {
			superActor.setEnabled(false);
			superActor.setToolTipText(GraalMessages.Actor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !superActor.isEnabled()) {
			superActor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#setSuperActorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSuperActorButtonMode(ButtonsModeEnum newValue) {
		superActor.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#addFilterSuperActor(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSuperActor(ViewerFilter filter) {
		superActor.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#addBusinessFilterSuperActor(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSuperActor(ViewerFilter filter) {
		superActor.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#initSubActors(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initSubActors(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		subActors.setContentProvider(contentProvider);
		subActors.setInput(settings);
		subActorsBusinessFilters.clear();
		subActorsFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Actor.Properties.subActors);
		if (eefElementEditorReadOnlyState && subActors.getTable().isEnabled()) {
			subActors.setEnabled(false);
			subActors.setToolTipText(GraalMessages.Actor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !subActors.getTable().isEnabled()) {
			subActors.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#updateSubActors()
	 * 
	 */
	public void updateSubActors() {
	subActors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#addFilterSubActors(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSubActors(ViewerFilter filter) {
		subActorsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#addBusinessFilterSubActors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSubActors(ViewerFilter filter) {
		subActorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.ActorPropertiesEditionPart#isContainedInSubActorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInSubActorsTable(EObject element) {
		return ((ReferencesTableSettings)subActors.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.Actor_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
