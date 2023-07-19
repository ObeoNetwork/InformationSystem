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
package org.obeonetwork.dsl.entity.parts.impl;

//Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.providers.EntityMessages;

// End of user code

/**
 * @author Obeo
 * 
 */
public class EntityPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EntityPropertiesEditionPart {

	protected Text name;
	protected AdvancedEObjectFlatComboViewer superType;
	protected ViewerFilter superTypeFilter;
	protected ReferencesTable associatedTypes;
	protected List<ViewerFilter> associatedTypesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> associatedTypesFilters = new ArrayList<ViewerFilter>();
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EntityPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence entity_Step = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = entity_Step.addStep(EntityViewsRepository.Entity_.Properties.class);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.name);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.superType);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.associatedTypes);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.description);
		
		
		composer = new PartComposer(entity_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityViewsRepository.Entity_.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.name) {
					return createNameText(parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.superType) {
					return createSuperTypeAdvancedFlatComboViewer(parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.associatedTypes) {
					return createAssociatedTypesAdvancedReferencesTable(parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.description) {
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
		propertiesGroup.setText(EntityMessages.EntityPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EntityViewsRepository.Entity_.Properties.name, EntityMessages.EntityPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EntityViewsRepository.Entity_.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.name, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSuperTypeAdvancedFlatComboViewer(Composite parent) {
		createDescription(parent, EntityViewsRepository.Entity_.Properties.superType, EntityMessages.EntityPropertiesEditionPart_SuperTypeLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.superType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.superType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getSuperType();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.superType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}
		};
		//create widget
		superType = new AdvancedEObjectFlatComboViewer(getDescription(EntityViewsRepository.Entity_.Properties.superType, EntityMessages.EntityPropertiesEditionPart_SuperTypeLabel), resourceSet, superTypeFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		superType.createControls(parent);
		GridData superTypeData = new GridData(GridData.FILL_HORIZONTAL);
		superType.setLayoutData(superTypeData);
		superType.setID(EntityViewsRepository.Entity_.Properties.superType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.superType, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuperTypeAdvancedFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createAssociatedTypesAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EntityViewsRepository.Entity_.Properties.associatedTypes, EntityMessages.EntityPropertiesEditionPart_AssociatedTypesLabel);		 
		this.associatedTypes = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addAssociatedTypes(); }
			public void handleEdit(EObject element) { editAssociatedTypes(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveAssociatedTypes(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromAssociatedTypes(element); }
			public void navigateTo(EObject element) { }
		});
		this.associatedTypes.setHelpText(propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.associatedTypes, EntityViewsRepository.SWT_KIND));
		this.associatedTypes.createControls(parent);
		this.associatedTypes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.associatedTypes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData associatedTypesData = new GridData(GridData.FILL_HORIZONTAL);
		associatedTypesData.horizontalSpan = 3;
		this.associatedTypes.setLayoutData(associatedTypesData);
		this.associatedTypes.disableMove();
		associatedTypes.setID(EntityViewsRepository.Entity_.Properties.associatedTypes);
		associatedTypes.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addAssociatedTypes() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(associatedTypes.getInput(), associatedTypesFilters, associatedTypesBusinessFilters,
		"associatedTypes", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.associatedTypes,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				associatedTypes.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveAssociatedTypes(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.associatedTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		associatedTypes.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromAssociatedTypes(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.associatedTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		associatedTypes.refresh();
	}

	/**
	 * 
	 */
	protected void editAssociatedTypes(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				associatedTypes.refresh();
			}
		}
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, EntityViewsRepository.Entity_.Properties.description, EntityMessages.EntityPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartImpl.this, EntityViewsRepository.Entity_.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, EntityViewsRepository.Entity_.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.description, EntityViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#getSuperType()
	 * 
	 */
	public EObject getSuperType() {
		return superType.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#initSuperType(EObjectFlatComboSettings)
	 */
	public void initSuperType(EObjectFlatComboSettings settings) {
		superType.setInput(settings);
		if (current != null) {
			superType.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.superType);
		if (eefElementEditorReadOnlyState && superType.isEnabled()) {
			superType.setEnabled(false);
			superType.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !superType.isEnabled()) {
			superType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setSuperType(EObject newValue)
	 * 
	 */
	public void setSuperType(EObject newValue) {
		if (newValue != null) {
			superType.setSelection(new StructuredSelection(newValue));
		} else {
			superType.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.superType);
		if (eefElementEditorReadOnlyState && superType.isEnabled()) {
			superType.setEnabled(false);
			superType.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !superType.isEnabled()) {
			superType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setSuperTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSuperTypeButtonMode(ButtonsModeEnum newValue) {
		superType.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#addFilterSuperType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSuperType(ViewerFilter filter) {
		superType.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#addBusinessFilterSuperType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSuperType(ViewerFilter filter) {
		superType.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#initAssociatedTypes(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initAssociatedTypes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		associatedTypes.setContentProvider(contentProvider);
		associatedTypes.setInput(settings);
		associatedTypesBusinessFilters.clear();
		associatedTypesFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.associatedTypes);
		if (eefElementEditorReadOnlyState && associatedTypes.getTable().isEnabled()) {
			associatedTypes.setEnabled(false);
			associatedTypes.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !associatedTypes.getTable().isEnabled()) {
			associatedTypes.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#updateAssociatedTypes()
	 * 
	 */
	public void updateAssociatedTypes() {
	associatedTypes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#addFilterAssociatedTypes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAssociatedTypes(ViewerFilter filter) {
		associatedTypesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#addBusinessFilterAssociatedTypes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAssociatedTypes(ViewerFilter filter) {
		associatedTypesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#isContainedInAssociatedTypesTable(EObject element)
	 * 
	 */
	public boolean isContainedInAssociatedTypesTable(EObject element) {
		return ((ReferencesTableSettings)associatedTypes.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(EntityMessages.Entity_ReadOnly);
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
		return EntityMessages.Entity_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
