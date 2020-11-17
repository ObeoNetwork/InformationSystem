/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.parts.impl;

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
import org.eclipse.emf.eef.runtime.ui.widgets.FlatReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.providers.RequirementMessages;

// End of user code

/**
 * 
 * 
 */
public class CategoryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CategoryPropertiesEditionPart {

	protected Text id;
	protected Text name;
	protected ReferencesTable requirements;
	protected List<ViewerFilter> requirementsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> requirementsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable subCategories;
	protected List<ViewerFilter> subCategoriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> subCategoriesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CategoryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence categoryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep category_Step = categoryStep.addStep(RequirementViewsRepository.Category.Category_.class);
		category_Step.addStep(RequirementViewsRepository.Category.Category_.id);
		category_Step.addStep(RequirementViewsRepository.Category.Category_.name);
		category_Step.addStep(RequirementViewsRepository.Category.Category_.requirements);
		category_Step.addStep(RequirementViewsRepository.Category.Category_.subCategories);
		
		
		composer = new PartComposer(categoryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == RequirementViewsRepository.Category.Category_.class) {
					return createCategoryGroup(parent);
				}
				if (key == RequirementViewsRepository.Category.Category_.id) {
					return createIdText(parent);
				}
				if (key == RequirementViewsRepository.Category.Category_.name) {
					return createNameText(parent);
				}
				if (key == RequirementViewsRepository.Category.Category_.requirements) {
					return createRequirementsAdvancedTableComposition(parent);
				}
				if (key == RequirementViewsRepository.Category.Category_.subCategories) {
					return createSubCategoriesAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createCategoryGroup(Composite parent) {
		Group categoryGroup = new Group(parent, SWT.NONE);
		categoryGroup.setText(RequirementMessages.CategoryPropertiesEditionPart_CategoryGroupLabel);
		GridData categoryGroupData = new GridData(GridData.FILL_HORIZONTAL);
		categoryGroupData.horizontalSpan = 3;
		categoryGroup.setLayoutData(categoryGroupData);
		GridLayout categoryGroupLayout = new GridLayout();
		categoryGroupLayout.numColumns = 3;
		categoryGroup.setLayout(categoryGroupLayout);
		return categoryGroup;
	}

	
	protected Composite createIdText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Category.Category_.id, RequirementMessages.CategoryPropertiesEditionPart_IdLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, RequirementViewsRepository.Category.Category_.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Category.Category_.id, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Category.Category_.name, RequirementMessages.CategoryPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, RequirementViewsRepository.Category.Category_.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Category.Category_.name, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRequirementsAdvancedTableComposition(Composite parent) {
		this.requirements = new ReferencesTable(getDescription(RequirementViewsRepository.Category.Category_.requirements, RequirementMessages.CategoryPropertiesEditionPart_RequirementsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.requirements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				requirements.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.requirements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				requirements.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.requirements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				requirements.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.requirements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				requirements.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.requirementsFilters) {
			this.requirements.addFilter(filter);
		}
		this.requirements.setHelpText(propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Category.Category_.requirements, RequirementViewsRepository.SWT_KIND));
		this.requirements.createControls(parent);
		this.requirements.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.requirements, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData requirementsData = new GridData(GridData.FILL_HORIZONTAL);
		requirementsData.horizontalSpan = 3;
		this.requirements.setLayoutData(requirementsData);
		this.requirements.setLowerBound(0);
		this.requirements.setUpperBound(-1);
		requirements.setID(RequirementViewsRepository.Category.Category_.requirements);
		requirements.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRequirementsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSubCategoriesAdvancedTableComposition(Composite parent) {
		this.subCategories = new ReferencesTable(getDescription(RequirementViewsRepository.Category.Category_.subCategories, RequirementMessages.CategoryPropertiesEditionPart_SubCategoriesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.subCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				subCategories.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.subCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				subCategories.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.subCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				subCategories.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.subCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				subCategories.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.subCategoriesFilters) {
			this.subCategories.addFilter(filter);
		}
		this.subCategories.setHelpText(propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Category.Category_.subCategories, RequirementViewsRepository.SWT_KIND));
		this.subCategories.createControls(parent);
		this.subCategories.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CategoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Category.Category_.subCategories, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData subCategoriesData = new GridData(GridData.FILL_HORIZONTAL);
		subCategoriesData.horizontalSpan = 3;
		this.subCategories.setLayoutData(subCategoriesData);
		this.subCategories.setLowerBound(0);
		this.subCategories.setUpperBound(-1);
		subCategories.setID(RequirementViewsRepository.Category.Category_.subCategories);
		subCategories.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createSubCategoriesAdvancedTableComposition

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
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#getId()
	 * 
	 */
	public String getId() {
		return id.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#setId(String newValue)
	 * 
	 */
	public void setId(String newValue) {
		if (newValue != null) {
			id.setText(newValue);
		} else {
			id.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Category.Category_.id);
		if (eefElementEditorReadOnlyState && id.isEnabled()) {
			id.setEnabled(false);
			id.setToolTipText(RequirementMessages.Category_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
			id.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Category.Category_.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(RequirementMessages.Category_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#initRequirements(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRequirements(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		requirements.setContentProvider(contentProvider);
		requirements.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Category.Category_.requirements);
		if (eefElementEditorReadOnlyState && requirements.isEnabled()) {
			requirements.setEnabled(false);
			requirements.setToolTipText(RequirementMessages.Category_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !requirements.isEnabled()) {
			requirements.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#updateRequirements()
	 * 
	 */
	public void updateRequirements() {
	requirements.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#addFilterRequirements(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRequirements(ViewerFilter filter) {
		requirementsFilters.add(filter);
		if (this.requirements != null) {
			this.requirements.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#addBusinessFilterRequirements(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRequirements(ViewerFilter filter) {
		requirementsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#isContainedInRequirementsTable(EObject element)
	 * 
	 */
	public boolean isContainedInRequirementsTable(EObject element) {
		return ((ReferencesTableSettings)requirements.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#initSubCategories(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubCategories(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		subCategories.setContentProvider(contentProvider);
		subCategories.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Category.Category_.subCategories);
		if (eefElementEditorReadOnlyState && subCategories.isEnabled()) {
			subCategories.setEnabled(false);
			subCategories.setToolTipText(RequirementMessages.Category_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !subCategories.isEnabled()) {
			subCategories.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#updateSubCategories()
	 * 
	 */
	public void updateSubCategories() {
	subCategories.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#addFilterSubCategories(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSubCategories(ViewerFilter filter) {
		subCategoriesFilters.add(filter);
		if (this.subCategories != null) {
			this.subCategories.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#addBusinessFilterSubCategories(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSubCategories(ViewerFilter filter) {
		subCategoriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart#isContainedInSubCategoriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSubCategoriesTable(EObject element) {
		return ((ReferencesTableSettings)subCategories.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return RequirementMessages.Category_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
