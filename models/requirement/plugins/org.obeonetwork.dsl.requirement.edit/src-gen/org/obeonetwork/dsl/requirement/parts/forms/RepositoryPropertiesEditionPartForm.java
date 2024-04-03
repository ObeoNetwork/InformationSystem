/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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
package org.obeonetwork.dsl.requirement.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FlatReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.providers.RequirementMessages;

// End of user code

/**
 * 
 * 
 */
public class RepositoryPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RepositoryPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable mainCategories;
	protected List<ViewerFilter> mainCategoriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> mainCategoriesFilters = new ArrayList<ViewerFilter>();
	protected FlatReferencesTable referencedObject;



	/**
	 * For {@link ISection} use only.
	 */
	public RepositoryPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RepositoryPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence repositoryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep repository_Step = repositoryStep.addStep(RequirementViewsRepository.Repository.Repository_.class);
		repository_Step.addStep(RequirementViewsRepository.Repository.Repository_.name);
		repository_Step.addStep(RequirementViewsRepository.Repository.Repository_.mainCategories);
		repository_Step.addStep(RequirementViewsRepository.Repository.Repository_.referencedObject);
		
		
		composer = new PartComposer(repositoryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == RequirementViewsRepository.Repository.Repository_.class) {
					return createRepositoryGroup(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Repository.Repository_.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Repository.Repository_.mainCategories) {
					return createMainCategoriesTableComposition(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Repository.Repository_.referencedObject) {
					return createReferencedObjectFlatReferencesTable(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createRepositoryGroup(FormToolkit widgetFactory, final Composite parent) {
		Section repositorySection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		repositorySection.setText(RequirementMessages.RepositoryPropertiesEditionPart_RepositoryGroupLabel);
		GridData repositorySectionData = new GridData(GridData.FILL_HORIZONTAL);
		repositorySectionData.horizontalSpan = 3;
		repositorySection.setLayoutData(repositorySectionData);
		Composite repositoryGroup = widgetFactory.createComposite(repositorySection);
		GridLayout repositoryGroupLayout = new GridLayout();
		repositoryGroupLayout.numColumns = 3;
		repositoryGroup.setLayout(repositoryGroupLayout);
		repositorySection.setClient(repositoryGroup);
		return repositoryGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Repository.Repository_.name, RequirementMessages.RepositoryPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RepositoryPropertiesEditionPartForm.this,
							RequirementViewsRepository.Repository.Repository_.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RepositoryPropertiesEditionPartForm.this,
									RequirementViewsRepository.Repository.Repository_.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RepositoryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartForm.this, RequirementViewsRepository.Repository.Repository_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, RequirementViewsRepository.Repository.Repository_.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Repository.Repository_.name, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createMainCategoriesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.mainCategories = new ReferencesTable(getDescription(RequirementViewsRepository.Repository.Repository_.mainCategories, RequirementMessages.RepositoryPropertiesEditionPart_MainCategoriesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartForm.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				mainCategories.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartForm.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				mainCategories.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartForm.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				mainCategories.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartForm.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				mainCategories.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.mainCategoriesFilters) {
			this.mainCategories.addFilter(filter);
		}
		this.mainCategories.setHelpText(propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Repository.Repository_.mainCategories, RequirementViewsRepository.FORM_KIND));
		this.mainCategories.createControls(parent, widgetFactory);
		this.mainCategories.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartForm.this, RequirementViewsRepository.Repository.Repository_.mainCategories, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createMainCategoriesTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param parent
	 * 
	 */
	protected Composite createReferencedObjectFlatReferencesTable(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Repository.Repository_.referencedObject, RequirementMessages.RepositoryPropertiesEditionPart_ReferencedObjectLabel);
		referencedObject = new FlatReferencesTable(parent);
		referencedObject.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		referencedObject.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof StructuredSelection) 
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RepositoryPropertiesEditionPartForm.this, RequirementViewsRepository.Repository.Repository_.referencedObject, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ((StructuredSelection)event.getSelection()).toList()));
			}

		});
		GridData referencedObjectData = new GridData(GridData.FILL_HORIZONTAL);
		referencedObject.setLayoutData(referencedObjectData);
		referencedObject.setID(RequirementViewsRepository.Repository.Repository_.referencedObject);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Repository.Repository_.referencedObject, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
