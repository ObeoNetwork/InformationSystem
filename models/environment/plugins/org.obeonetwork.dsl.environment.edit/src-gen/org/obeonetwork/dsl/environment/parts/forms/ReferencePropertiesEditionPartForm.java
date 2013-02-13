/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts.forms;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class ReferencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ReferencePropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer type;
	protected EMFComboViewer multiplicity;
	protected Button isComposite;
	protected Button navigable;
	protected EObjectFlatComboViewer oppositeOf;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public ReferencePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ReferencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence referenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = referenceStep.addStep(EnvironmentViewsRepository.Reference.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.Reference.Properties.name);
		propertiesStep.addStep(EnvironmentViewsRepository.Reference.Properties.type);
		propertiesStep.addStep(EnvironmentViewsRepository.Reference.Properties.multiplicity);
		propertiesStep.addStep(EnvironmentViewsRepository.Reference.Properties.isComposite);
		propertiesStep.addStep(EnvironmentViewsRepository.Reference.Properties.navigable);
		propertiesStep.addStep(EnvironmentViewsRepository.Reference.Properties.oppositeOf);
		propertiesStep.addStep(EnvironmentViewsRepository.Reference.Properties.description);
		
		
		composer = new PartComposer(referenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.Reference.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Reference.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Reference.Properties.type) {
					return createTypeFlatComboViewer(parent, widgetFactory);
				}
				if (key == EnvironmentViewsRepository.Reference.Properties.multiplicity) {
					return createMultiplicityEMFComboViewer(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Reference.Properties.isComposite) {
					return createIsCompositeCheckbox(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Reference.Properties.navigable) {
					return createNavigableCheckbox(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Reference.Properties.oppositeOf) {
					return createOppositeOfFlatComboViewer(parent, widgetFactory);
				}
				if (key == EnvironmentViewsRepository.Reference.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
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
		propertiesSection.setText(EnvironmentMessages.ReferencePropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EnvironmentViewsRepository.Reference.Properties.name, EnvironmentMessages.ReferencePropertiesEditionPart_NameLabel);
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
							ReferencePropertiesEditionPartForm.this,
							EnvironmentViewsRepository.Reference.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ReferencePropertiesEditionPartForm.this,
									EnvironmentViewsRepository.Reference.Properties.name,
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
									ReferencePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, EnvironmentViewsRepository.Reference.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EnvironmentViewsRepository.Reference.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Reference.Properties.name, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createTypeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EnvironmentViewsRepository.Reference.Properties.type, EnvironmentMessages.ReferencePropertiesEditionPart_TypeLabel);
		type = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EnvironmentViewsRepository.Reference.Properties.type, EnvironmentViewsRepository.FORM_KIND));
		widgetFactory.adapt(type);
		type.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		type.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, EnvironmentViewsRepository.Reference.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		type.setID(EnvironmentViewsRepository.Reference.Properties.type);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Reference.Properties.type, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createMultiplicityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Reference.Properties.multiplicity, EnvironmentMessages.ReferencePropertiesEditionPart_MultiplicityLabel);
		multiplicity = new EMFComboViewer(parent);
		multiplicity.setContentProvider(new ArrayContentProvider());
		multiplicity.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData multiplicityData = new GridData(GridData.FILL_HORIZONTAL);
		multiplicity.getCombo().setLayoutData(multiplicityData);
		multiplicity.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, EnvironmentViewsRepository.Reference.Properties.multiplicity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMultiplicity()));
			}

		});
		multiplicity.setID(EnvironmentViewsRepository.Reference.Properties.multiplicity);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Reference.Properties.multiplicity, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIsCompositeCheckbox(FormToolkit widgetFactory, Composite parent) {
		isComposite = widgetFactory.createButton(parent, getDescription(EnvironmentViewsRepository.Reference.Properties.isComposite, EnvironmentMessages.ReferencePropertiesEditionPart_IsCompositeLabel), SWT.CHECK);
		isComposite.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, EnvironmentViewsRepository.Reference.Properties.isComposite, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isComposite.getSelection())));
			}

		});
		GridData isCompositeData = new GridData(GridData.FILL_HORIZONTAL);
		isCompositeData.horizontalSpan = 2;
		isComposite.setLayoutData(isCompositeData);
		EditingUtils.setID(isComposite, EnvironmentViewsRepository.Reference.Properties.isComposite);
		EditingUtils.setEEFtype(isComposite, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Reference.Properties.isComposite, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createNavigableCheckbox(FormToolkit widgetFactory, Composite parent) {
		navigable = widgetFactory.createButton(parent, getDescription(EnvironmentViewsRepository.Reference.Properties.navigable, EnvironmentMessages.ReferencePropertiesEditionPart_NavigableLabel), SWT.CHECK);
		navigable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, EnvironmentViewsRepository.Reference.Properties.navigable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(navigable.getSelection())));
			}

		});
		GridData navigableData = new GridData(GridData.FILL_HORIZONTAL);
		navigableData.horizontalSpan = 2;
		navigable.setLayoutData(navigableData);
		EditingUtils.setID(navigable, EnvironmentViewsRepository.Reference.Properties.navigable);
		EditingUtils.setEEFtype(navigable, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Reference.Properties.navigable, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createOppositeOfFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EnvironmentViewsRepository.Reference.Properties.oppositeOf, EnvironmentMessages.ReferencePropertiesEditionPart_OppositeOfLabel);
		oppositeOf = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EnvironmentViewsRepository.Reference.Properties.oppositeOf, EnvironmentViewsRepository.FORM_KIND));
		widgetFactory.adapt(oppositeOf);
		oppositeOf.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData oppositeOfData = new GridData(GridData.FILL_HORIZONTAL);
		oppositeOf.setLayoutData(oppositeOfData);
		oppositeOf.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, EnvironmentViewsRepository.Reference.Properties.oppositeOf, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOppositeOf()));
			}

		});
		oppositeOf.setID(EnvironmentViewsRepository.Reference.Properties.oppositeOf);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Reference.Properties.oppositeOf, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Reference.Properties.description, EnvironmentMessages.ReferencePropertiesEditionPart_DescriptionLabel);
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ReferencePropertiesEditionPartForm.this,
							EnvironmentViewsRepository.Reference.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ReferencePropertiesEditionPartForm.this,
									EnvironmentViewsRepository.Reference.Properties.description,
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
									ReferencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, EnvironmentViewsRepository.Reference.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EnvironmentViewsRepository.Reference.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Reference.Properties.description, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#getType()
	 * 
	 */
	public EObject getType() {
		if (type.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) type.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#initType(EObjectFlatComboSettings)
	 */
	public void initType(EObjectFlatComboSettings settings) {
		type.setInput(settings);
		if (current != null) {
			type.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.type);
		if (readOnly && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setType(EObject newValue)
	 * 
	 */
	public void setType(EObject newValue) {
		if (newValue != null) {
			type.setSelection(new StructuredSelection(newValue));
		} else {
			type.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.type);
		if (readOnly && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTypeButtonMode(ButtonsModeEnum newValue) {
		type.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#addFilterType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToType(ViewerFilter filter) {
		type.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#addBusinessFilterType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToType(ViewerFilter filter) {
		type.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#getMultiplicity()
	 * 
	 */
	public Enumerator getMultiplicity() {
		Enumerator selection = (Enumerator) ((StructuredSelection) multiplicity.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#initMultiplicity(Object input, Enumerator current)
	 */
	public void initMultiplicity(Object input, Enumerator current) {
		multiplicity.setInput(input);
		multiplicity.modelUpdating(new StructuredSelection(current));
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.multiplicity);
		if (readOnly && multiplicity.isEnabled()) {
			multiplicity.setEnabled(false);
			multiplicity.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !multiplicity.isEnabled()) {
			multiplicity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setMultiplicity(Enumerator newValue)
	 * 
	 */
	public void setMultiplicity(Enumerator newValue) {
		multiplicity.modelUpdating(new StructuredSelection(newValue));
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.multiplicity);
		if (readOnly && multiplicity.isEnabled()) {
			multiplicity.setEnabled(false);
			multiplicity.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !multiplicity.isEnabled()) {
			multiplicity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#getIsComposite()
	 * 
	 */
	public Boolean getIsComposite() {
		return Boolean.valueOf(isComposite.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setIsComposite(Boolean newValue)
	 * 
	 */
	public void setIsComposite(Boolean newValue) {
		if (newValue != null) {
			isComposite.setSelection(newValue.booleanValue());
		} else {
			isComposite.setSelection(false);
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.isComposite);
		if (readOnly && isComposite.isEnabled()) {
			isComposite.setEnabled(false);
			isComposite.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !isComposite.isEnabled()) {
			isComposite.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#getNavigable()
	 * 
	 */
	public Boolean getNavigable() {
		return Boolean.valueOf(navigable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setNavigable(Boolean newValue)
	 * 
	 */
	public void setNavigable(Boolean newValue) {
		if (newValue != null) {
			navigable.setSelection(newValue.booleanValue());
		} else {
			navigable.setSelection(false);
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.navigable);
		if (readOnly && navigable.isEnabled()) {
			navigable.setEnabled(false);
			navigable.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !navigable.isEnabled()) {
			navigable.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#getOppositeOf()
	 * 
	 */
	public EObject getOppositeOf() {
		if (oppositeOf.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) oppositeOf.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#initOppositeOf(EObjectFlatComboSettings)
	 */
	public void initOppositeOf(EObjectFlatComboSettings settings) {
		oppositeOf.setInput(settings);
		if (current != null) {
			oppositeOf.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.oppositeOf);
		if (readOnly && oppositeOf.isEnabled()) {
			oppositeOf.setEnabled(false);
			oppositeOf.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !oppositeOf.isEnabled()) {
			oppositeOf.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setOppositeOf(EObject newValue)
	 * 
	 */
	public void setOppositeOf(EObject newValue) {
		if (newValue != null) {
			oppositeOf.setSelection(new StructuredSelection(newValue));
		} else {
			oppositeOf.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.oppositeOf);
		if (readOnly && oppositeOf.isEnabled()) {
			oppositeOf.setEnabled(false);
			oppositeOf.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
		} else if (!readOnly && !oppositeOf.isEnabled()) {
			oppositeOf.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setOppositeOfButtonMode(ButtonsModeEnum newValue)
	 */
	public void setOppositeOfButtonMode(ButtonsModeEnum newValue) {
		oppositeOf.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#addFilterOppositeOf(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOppositeOf(ViewerFilter filter) {
		oppositeOf.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#addBusinessFilterOppositeOf(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOppositeOf(ViewerFilter filter) {
		oppositeOf.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.ReferencePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Reference.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EnvironmentMessages.Reference_ReadOnly);
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
		return EnvironmentMessages.Reference_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
