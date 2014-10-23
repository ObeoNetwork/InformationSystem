/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
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
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.providers.EntityMessages;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>J�r�me Benois</a>
 * 
 */
public class EntityPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EntityPropertiesEditionPart {

	protected Text name;
	protected AdvancedEObjectFlatComboViewer superType;
	protected ViewerFilter superTypeFilter;
	protected Text estimatedVolumetry;
	protected Text estimatedAccess;
	protected Button historized;
	protected EMFComboViewer inheritanceKind;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public EntityPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EntityPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence entity_Step = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = entity_Step.addStep(EntityViewsRepository.Entity_.Properties.class);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.name);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.superType);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.estimatedVolumetry);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.estimatedAccess);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.historized);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.inheritanceKind);
		propertiesStep.addStep(EntityViewsRepository.Entity_.Properties.description);
		
		
		composer = new PartComposer(entity_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityViewsRepository.Entity_.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.superType) {
					return createSuperTypeFlatComboViewer(parent, widgetFactory);
				}
				if (key == EntityViewsRepository.Entity_.Properties.estimatedVolumetry) {
					return createEstimatedVolumetryText(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.estimatedAccess) {
					return createEstimatedAccessText(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.historized) {
					return createHistorizedCheckbox(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.inheritanceKind) {
					return createInheritanceKindEMFComboViewer(widgetFactory, parent);
				}
				if (key == EntityViewsRepository.Entity_.Properties.description) {
					return createDescriptionTextarea(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EntityMessages.EntityPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityViewsRepository.Entity_.Properties.name, EntityMessages.EntityPropertiesEditionPart_NameLabel);
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
							EntityPropertiesEditionPartForm.this,
							EntityViewsRepository.Entity_.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntityPropertiesEditionPartForm.this,
									EntityViewsRepository.Entity_.Properties.name,
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
									EntityPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EntityViewsRepository.Entity_.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.name, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSuperTypeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EntityViewsRepository.Entity_.Properties.superType, EntityMessages.EntityPropertiesEditionPart_SuperTypeLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.superType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.superType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getSuperType();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.superType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}

		};
		//create widget
		superType = new AdvancedEObjectFlatComboViewer(EntityMessages.EntityPropertiesEditionPart_SuperTypeLabel, resourceSet, superTypeFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		superType.createControls(parent, widgetFactory);
		GridData superTypeData = new GridData(GridData.FILL_HORIZONTAL);
		superType.setLayoutData(superTypeData);
		superType.setID(EntityViewsRepository.Entity_.Properties.superType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.superType, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuperTypeFlatComboViewer

		// End of user code
		return parent;
	}


	
	protected Composite createEstimatedVolumetryText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityViewsRepository.Entity_.Properties.estimatedVolumetry, EntityMessages.EntityPropertiesEditionPart_EstimatedVolumetryLabel);
		estimatedVolumetry = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		estimatedVolumetry.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData estimatedVolumetryData = new GridData(GridData.FILL_HORIZONTAL);
		estimatedVolumetry.setLayoutData(estimatedVolumetryData);
		estimatedVolumetry.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntityPropertiesEditionPartForm.this,
							EntityViewsRepository.Entity_.Properties.estimatedVolumetry,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntityPropertiesEditionPartForm.this,
									EntityViewsRepository.Entity_.Properties.estimatedVolumetry,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, estimatedVolumetry.getText()));
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
									EntityPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		estimatedVolumetry.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.estimatedVolumetry, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedVolumetry.getText()));
				}
			}
		});
		EditingUtils.setID(estimatedVolumetry, EntityViewsRepository.Entity_.Properties.estimatedVolumetry);
		EditingUtils.setEEFtype(estimatedVolumetry, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.estimatedVolumetry, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedVolumetryText

		// End of user code
		return parent;
	}

	
	protected Composite createEstimatedAccessText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityViewsRepository.Entity_.Properties.estimatedAccess, EntityMessages.EntityPropertiesEditionPart_EstimatedAccessLabel);
		estimatedAccess = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		estimatedAccess.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData estimatedAccessData = new GridData(GridData.FILL_HORIZONTAL);
		estimatedAccess.setLayoutData(estimatedAccessData);
		estimatedAccess.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntityPropertiesEditionPartForm.this,
							EntityViewsRepository.Entity_.Properties.estimatedAccess,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedAccess.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntityPropertiesEditionPartForm.this,
									EntityViewsRepository.Entity_.Properties.estimatedAccess,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, estimatedAccess.getText()));
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
									EntityPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		estimatedAccess.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.estimatedAccess, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, estimatedAccess.getText()));
				}
			}
		});
		EditingUtils.setID(estimatedAccess, EntityViewsRepository.Entity_.Properties.estimatedAccess);
		EditingUtils.setEEFtype(estimatedAccess, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.estimatedAccess, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEstimatedAccessText

		// End of user code
		return parent;
	}

	
	protected Composite createHistorizedCheckbox(FormToolkit widgetFactory, Composite parent) {
		historized = widgetFactory.createButton(parent, getDescription(EntityViewsRepository.Entity_.Properties.historized, EntityMessages.EntityPropertiesEditionPart_HistorizedLabel), SWT.CHECK);
		historized.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.historized, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(historized.getSelection())));
			}

		});
		GridData historizedData = new GridData(GridData.FILL_HORIZONTAL);
		historizedData.horizontalSpan = 2;
		historized.setLayoutData(historizedData);
		EditingUtils.setID(historized, EntityViewsRepository.Entity_.Properties.historized);
		EditingUtils.setEEFtype(historized, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.historized, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHistorizedCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createInheritanceKindEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityViewsRepository.Entity_.Properties.inheritanceKind, EntityMessages.EntityPropertiesEditionPart_InheritanceKindLabel);
		inheritanceKind = new EMFComboViewer(parent);
		inheritanceKind.setContentProvider(new ArrayContentProvider());
		inheritanceKind.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inheritanceKindData = new GridData(GridData.FILL_HORIZONTAL);
		inheritanceKind.getCombo().setLayoutData(inheritanceKindData);
		inheritanceKind.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntityPropertiesEditionPartForm.this, EntityViewsRepository.Entity_.Properties.inheritanceKind, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInheritanceKind()));
			}

		});
		inheritanceKind.setID(EntityViewsRepository.Entity_.Properties.inheritanceKind);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.inheritanceKind, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInheritanceKindEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(FormToolkit widgetFactory, Composite parent) {
		Label descriptionLabel = createDescription(parent, EntityViewsRepository.Entity_.Properties.description, EntityMessages.EntityPropertiesEditionPart_DescriptionLabel);
		GridData descriptionLabelData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionLabelData.horizontalSpan = 3;
		descriptionLabel.setLayoutData(descriptionLabelData);
		description = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
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
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntityPropertiesEditionPartForm.this,
							EntityViewsRepository.Entity_.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntityPropertiesEditionPartForm.this,
									EntityViewsRepository.Entity_.Properties.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
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
									EntityPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(description, EntityViewsRepository.Entity_.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityViewsRepository.Entity_.Properties.description, EntityViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#getEstimatedVolumetry()
	 * 
	 */
	public String getEstimatedVolumetry() {
		return estimatedVolumetry.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setEstimatedVolumetry(String newValue)
	 * 
	 */
	public void setEstimatedVolumetry(String newValue) {
		if (newValue != null) {
			estimatedVolumetry.setText(newValue);
		} else {
			estimatedVolumetry.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.estimatedVolumetry);
		if (eefElementEditorReadOnlyState && estimatedVolumetry.isEnabled()) {
			estimatedVolumetry.setEnabled(false);
			estimatedVolumetry.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !estimatedVolumetry.isEnabled()) {
			estimatedVolumetry.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#getEstimatedAccess()
	 * 
	 */
	public String getEstimatedAccess() {
		return estimatedAccess.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setEstimatedAccess(String newValue)
	 * 
	 */
	public void setEstimatedAccess(String newValue) {
		if (newValue != null) {
			estimatedAccess.setText(newValue);
		} else {
			estimatedAccess.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.estimatedAccess);
		if (eefElementEditorReadOnlyState && estimatedAccess.isEnabled()) {
			estimatedAccess.setEnabled(false);
			estimatedAccess.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !estimatedAccess.isEnabled()) {
			estimatedAccess.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#getHistorized()
	 * 
	 */
	public Boolean getHistorized() {
		return Boolean.valueOf(historized.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setHistorized(Boolean newValue)
	 * 
	 */
	public void setHistorized(Boolean newValue) {
		if (newValue != null) {
			historized.setSelection(newValue.booleanValue());
		} else {
			historized.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.historized);
		if (eefElementEditorReadOnlyState && historized.isEnabled()) {
			historized.setEnabled(false);
			historized.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !historized.isEnabled()) {
			historized.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#getInheritanceKind()
	 * 
	 */
	public Enumerator getInheritanceKind() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inheritanceKind.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#initInheritanceKind(Object input, Enumerator current)
	 */
	public void initInheritanceKind(Object input, Enumerator current) {
		inheritanceKind.setInput(input);
		inheritanceKind.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.inheritanceKind);
		if (eefElementEditorReadOnlyState && inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(false);
			inheritanceKind.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart#setInheritanceKind(Enumerator newValue)
	 * 
	 */
	public void setInheritanceKind(Enumerator newValue) {
		inheritanceKind.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EntityViewsRepository.Entity_.Properties.inheritanceKind);
		if (eefElementEditorReadOnlyState && inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(false);
			inheritanceKind.setToolTipText(EntityMessages.Entity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inheritanceKind.isEnabled()) {
			inheritanceKind.setEnabled(true);
		}	
		
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
