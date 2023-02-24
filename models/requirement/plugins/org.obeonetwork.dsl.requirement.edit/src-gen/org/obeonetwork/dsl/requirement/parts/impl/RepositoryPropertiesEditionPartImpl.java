/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
import org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.providers.RequirementMessages;

// End of user code

/**
 * 
 * 
 */
public class RepositoryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RepositoryPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable mainCategories;
	protected List<ViewerFilter> mainCategoriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> mainCategoriesFilters = new ArrayList<ViewerFilter>();
	protected FlatReferencesTable referencedObject;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RepositoryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence repositoryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep repository_Step = repositoryStep.addStep(RequirementViewsRepository.Repository.Repository_.class);
		repository_Step.addStep(RequirementViewsRepository.Repository.Repository_.name);
		repository_Step.addStep(RequirementViewsRepository.Repository.Repository_.mainCategories);
		repository_Step.addStep(RequirementViewsRepository.Repository.Repository_.referencedObject);
		
		
		composer = new PartComposer(repositoryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == RequirementViewsRepository.Repository.Repository_.class) {
					return createRepositoryGroup(parent);
				}
				if (key == RequirementViewsRepository.Repository.Repository_.name) {
					return createNameText(parent);
				}
				if (key == RequirementViewsRepository.Repository.Repository_.mainCategories) {
					return createMainCategoriesAdvancedTableComposition(parent);
				}
				if (key == RequirementViewsRepository.Repository.Repository_.referencedObject) {
					return createReferencedObjectFlatReferencesTable(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createRepositoryGroup(Composite parent) {
		Group repositoryGroup = new Group(parent, SWT.NONE);
		repositoryGroup.setText(RequirementMessages.RepositoryPropertiesEditionPart_RepositoryGroupLabel);
		GridData repositoryGroupData = new GridData(GridData.FILL_HORIZONTAL);
		repositoryGroupData.horizontalSpan = 3;
		repositoryGroup.setLayoutData(repositoryGroupData);
		GridLayout repositoryGroupLayout = new GridLayout();
		repositoryGroupLayout.numColumns = 3;
		repositoryGroup.setLayout(repositoryGroupLayout);
		return repositoryGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Repository.Repository_.name, RequirementMessages.RepositoryPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, RequirementViewsRepository.Repository.Repository_.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Repository.Repository_.name, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createMainCategoriesAdvancedTableComposition(Composite parent) {
		this.mainCategories = new ReferencesTable(getDescription(RequirementViewsRepository.Repository.Repository_.mainCategories, RequirementMessages.RepositoryPropertiesEditionPart_MainCategoriesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				mainCategories.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				mainCategories.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				mainCategories.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				mainCategories.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.mainCategoriesFilters) {
			this.mainCategories.addFilter(filter);
		}
		this.mainCategories.setHelpText(propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Repository.Repository_.mainCategories, RequirementViewsRepository.SWT_KIND));
		this.mainCategories.createControls(parent);
		this.mainCategories.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData mainCategoriesData = new GridData(GridData.FILL_HORIZONTAL);
		mainCategoriesData.horizontalSpan = 3;
		this.mainCategories.setLayoutData(mainCategoriesData);
		this.mainCategories.setLowerBound(0);
		this.mainCategories.setUpperBound(-1);
		mainCategories.setID(RequirementViewsRepository.Repository.Repository_.mainCategories);
		mainCategories.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createMainCategoriesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param parent
	 * 
	 */
	protected Composite createReferencedObjectFlatReferencesTable(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Repository.Repository_.referencedObject, RequirementMessages.RepositoryPropertiesEditionPart_ReferencedObjectLabel);
		referencedObject = new FlatReferencesTable(parent);
		referencedObject.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		referencedObject.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof StructuredSelection) 
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartImpl.this, RequirementViewsRepository.Repository.Repository_.referencedObject, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ((StructuredSelection)event.getSelection()).toList()));
			}

		});
		GridData referencedObjectData = new GridData(GridData.FILL_HORIZONTAL);
		referencedObject.setLayoutData(referencedObjectData);
		referencedObject.setID(RequirementViewsRepository.Repository.Repository_.referencedObject);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Repository.Repository_.referencedObject, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReferencedObjectFlatReferencesTable

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
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Repository.Repository_.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(RequirementMessages.Repository_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#initMainCategories(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initMainCategories(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		mainCategories.setContentProvider(contentProvider);
		mainCategories.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Repository.Repository_.mainCategories);
		if (eefElementEditorReadOnlyState && mainCategories.isEnabled()) {
			mainCategories.setEnabled(false);
			mainCategories.setToolTipText(RequirementMessages.Repository_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mainCategories.isEnabled()) {
			mainCategories.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#updateMainCategories()
	 * 
	 */
	public void updateMainCategories() {
	mainCategories.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#addFilterMainCategories(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMainCategories(ViewerFilter filter) {
		mainCategoriesFilters.add(filter);
		if (this.mainCategories != null) {
			this.mainCategories.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#addBusinessFilterMainCategories(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMainCategories(ViewerFilter filter) {
		mainCategoriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#isContainedInMainCategoriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInMainCategoriesTable(EObject element) {
		return ((ReferencesTableSettings)mainCategories.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#initReferencedObject(ReferencesTableSettings)
	 */
	public void initReferencedObject(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		referencedObject.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Repository.Repository_.referencedObject);
		if (eefElementEditorReadOnlyState && referencedObject.isEnabled()) {
			referencedObject.setEnabled(false);
			referencedObject.setToolTipText(RequirementMessages.Repository_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !referencedObject.isEnabled()) {
			referencedObject.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#updateReferencedObject()
	 * 
	 */
	public void updateReferencedObject() {
	referencedObject.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#addFilterReferencedObject(ViewerFilter filter)
	 * 
	 */
	public void addFilterToReferencedObject(ViewerFilter filter) {
		referencedObject.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#addBusinessFilterReferencedObject(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToReferencedObject(ViewerFilter filter) {
		referencedObject.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart#isContainedInReferencedObjectTable(EObject element)
	 * 
	 */
	public boolean isContainedInReferencedObjectTable(EObject element) {
		return ((ReferencesTableSettings)referencedObject.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return RequirementMessages.Repository_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
