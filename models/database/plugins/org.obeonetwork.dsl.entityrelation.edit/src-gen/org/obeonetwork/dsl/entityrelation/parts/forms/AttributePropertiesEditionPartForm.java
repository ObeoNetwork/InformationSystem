/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.entityrelation.components.AttributePropertiesEditionComponent;
import org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.providers.EntityrelationMessages;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

// End of user code

/**
 * 
 * 
 */
public class AttributePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, AttributePropertiesEditionPart {

	protected Text name;
	protected EMFComboViewer type;
	protected Text length;
	protected Text precision;
	protected Text literals;
	protected Button editLiterals;
	private EList literalsList;
	protected Button required;
	protected Button inPrimaryIdentifier;
	protected Text comments;



	/**
	 * For {@link ISection} use only.
	 */
	public AttributePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AttributePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence attributeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = attributeStep.addStep(EntityrelationViewsRepository.Attribute.Properties.class);
		propertiesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.name);
		propertiesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.type);
		CompositionStep typeAttributesStep = propertiesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.class);
		typeAttributesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length);
		typeAttributesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision);
		
		propertiesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.literals);
		CompositionStep requiredAndIdentifierStep = propertiesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.class);
		requiredAndIdentifierStep.addStep(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required);
		requiredAndIdentifierStep.addStep(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier);
		
		propertiesStep.addStep(EntityrelationViewsRepository.Attribute.Properties.comments);
		
		
		composer = new PartComposer(attributeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityrelationViewsRepository.Attribute.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.type) {
					return createTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.class) {
					return createTypeAttributesHBox(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length) {
					return createLengthText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision) {
					return createPrecisionText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.literals) {
					return createLiteralsMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.class) {
					return createRequiredAndIdentifierHBox(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required) {
					return createRequiredCheckbox(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier) {
					return createInPrimaryIdentifierCheckbox(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Attribute.Properties.comments) {
					return createCommentsTextarea(widgetFactory, parent);
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
		propertiesSection.setText(EntityrelationMessages.AttributePropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EntityrelationViewsRepository.Attribute.Properties.name, EntityrelationMessages.AttributePropertiesEditionPart_NameLabel);
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
							AttributePropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Attribute.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AttributePropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Attribute.Properties.name,
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
									AttributePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributePropertiesEditionPartForm.this, EntityrelationViewsRepository.Attribute.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EntityrelationViewsRepository.Attribute.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Attribute.Properties.name, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Attribute.Properties.type, EntityrelationMessages.AttributePropertiesEditionPart_TypeLabel);
		type = new EMFComboViewer(parent);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.getCombo().setLayoutData(typeData);
		type.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		type.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributePropertiesEditionPartForm.this, EntityrelationViewsRepository.Attribute.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		type.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(type.getCombo(), EntityrelationViewsRepository.Attribute.Properties.type);
		EditingUtils.setEEFtype(type.getCombo(), "eef::Combo");
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Attribute.Properties.type, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTypeAttributesHBox(FormToolkit widgetFactory, Composite parent) {
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan=3;
		container.setLayoutData(gridData);
				HorizontalBox typeAttributesHBox = new HorizontalBox(container);
		widgetFactory.adapt(typeAttributesHBox);
		return typeAttributesHBox;
	}

	
	protected Composite createLengthText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length, EntityrelationMessages.AttributePropertiesEditionPart_LengthLabel);
		length = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		length.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData lengthData = new GridData(GridData.FILL_HORIZONTAL);
		length.setLayoutData(lengthData);
		length.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AttributePropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AttributePropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, length.getText()));
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
									AttributePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		length.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributePropertiesEditionPartForm.this, EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
				}
			}
		});
		EditingUtils.setID(length, EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length);
		EditingUtils.setEEFtype(length, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPrecisionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision, EntityrelationMessages.AttributePropertiesEditionPart_PrecisionLabel);
		precision = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		precision.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData precisionData = new GridData(GridData.FILL_HORIZONTAL);
		precision.setLayoutData(precisionData);
		precision.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AttributePropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, precision.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AttributePropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, precision.getText()));
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
									AttributePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		precision.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributePropertiesEditionPartForm.this, EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, precision.getText()));
				}
			}
		});
		EditingUtils.setID(precision, EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision);
		EditingUtils.setEEFtype(precision, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createLiteralsMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		literals = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData literalsData = new GridData(GridData.FILL_HORIZONTAL);
		literalsData.horizontalSpan = 2;
		literals.setLayoutData(literalsData);
		EditingUtils.setID(literals, EntityrelationViewsRepository.Attribute.Properties.literals);
		EditingUtils.setEEFtype(literals, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editLiterals = widgetFactory.createButton(parent, getDescription(EntityrelationViewsRepository.Attribute.Properties.literals, EntityrelationMessages.AttributePropertiesEditionPart_LiteralsLabel), SWT.NONE);
		GridData editLiteralsData = new GridData();
		editLiterals.setLayoutData(editLiteralsData);
		editLiterals.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						literals.getShell(), "Attribute", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						literalsList, TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					literalsList = dialog.getResult();
					if (literalsList == null) {
						literalsList = new BasicEList();
					}
					literals.setText(literalsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributePropertiesEditionPartForm.this, EntityrelationViewsRepository.Attribute.Properties.literals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(literalsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editLiterals, EntityrelationViewsRepository.Attribute.Properties.literals);
		EditingUtils.setEEFtype(editLiterals, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createRequiredAndIdentifierHBox(FormToolkit widgetFactory, Composite parent) {
		Composite container = widgetFactory.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan=3;
		container.setLayoutData(gridData);
				HorizontalBox requiredAndIdentifierHBox = new HorizontalBox(container);
		//Apply constraint for checkbox
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
		constraint.horizontalAlignment = GridData.BEGINNING;
		requiredAndIdentifierHBox.setLayoutData(constraint);
		widgetFactory.adapt(requiredAndIdentifierHBox);
		return requiredAndIdentifierHBox;
	}

	
	protected Composite createRequiredCheckbox(FormToolkit widgetFactory, Composite parent) {
		required = widgetFactory.createButton(parent, getDescription(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required, EntityrelationMessages.AttributePropertiesEditionPart_RequiredLabel), SWT.CHECK);
		required.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributePropertiesEditionPartForm.this, EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(required.getSelection())));
			}

		});
		GridData requiredData = new GridData(GridData.FILL_HORIZONTAL);
		requiredData.horizontalSpan = 2;
		required.setLayoutData(requiredData);
		EditingUtils.setID(required, EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required);
		EditingUtils.setEEFtype(required, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInPrimaryIdentifierCheckbox(FormToolkit widgetFactory, Composite parent) {
		inPrimaryIdentifier = widgetFactory.createButton(parent, getDescription(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier, EntityrelationMessages.AttributePropertiesEditionPart_InPrimaryIdentifierLabel), SWT.CHECK);
		inPrimaryIdentifier.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributePropertiesEditionPartForm.this, EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inPrimaryIdentifier.getSelection())));
			}

		});
		GridData inPrimaryIdentifierData = new GridData(GridData.FILL_HORIZONTAL);
		inPrimaryIdentifierData.horizontalSpan = 2;
		inPrimaryIdentifier.setLayoutData(inPrimaryIdentifierData);
		EditingUtils.setID(inPrimaryIdentifier, EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier);
		EditingUtils.setEEFtype(inPrimaryIdentifier, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCommentsTextarea(FormToolkit widgetFactory, Composite parent) {
		Label commentsLabel = createDescription(parent, EntityrelationViewsRepository.Attribute.Properties.comments, EntityrelationMessages.AttributePropertiesEditionPart_CommentsLabel);
		GridData commentsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		commentsLabelData.horizontalSpan = 3;
		commentsLabel.setLayoutData(commentsLabelData);
		comments = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
		GridData commentsData = new GridData(GridData.FILL_HORIZONTAL);
		commentsData.horizontalSpan = 2;
		commentsData.heightHint = 80;
		commentsData.widthHint = 200;
		comments.setLayoutData(commentsData);
		comments.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AttributePropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Attribute.Properties.comments,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AttributePropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Attribute.Properties.comments,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, comments.getText()));
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
									AttributePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(comments, EntityrelationViewsRepository.Attribute.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Attribute.Properties.comments, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getType()
	 * 
	 */
	public Object getType() {
		if (type.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection) type.getSelection()).getFirstElement();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#initType(Object input, Object currentValue)
	 */
	public void initType(Object input, Object currentValue) {
		type.setInput(input);
		if (currentValue != null) {
			type.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setType(Object newValue)
	 * 
	 */
	public void setType(Object newValue) {
		if (newValue != null) {
			type.modelUpdating(new StructuredSelection(newValue));
		} else {
			type.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.type, ((AttributePropertiesEditionComponent) propertiesEditionComponent).getTypeSettings().getOrCreateSignificantObject());
		if (readOnly && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#addFilterType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToType(ViewerFilter filter) {
		type.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getLength()
	 * 
	 */
	public String getLength() {
		return length.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setLength(String newValue)
	 * 
	 */
	public void setLength(String newValue) {
		if (newValue != null) {
			length.setText(newValue);
		} else {
			length.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.length, ((AttributePropertiesEditionComponent) propertiesEditionComponent).getLengthSettings().getOrCreateSignificantObject());
		if (readOnly && length.isEnabled()) {
			length.setEnabled(false);
			length.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !length.isEnabled()) {
			length.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getPrecision()
	 * 
	 */
	public String getPrecision() {
		return precision.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setPrecision(String newValue)
	 * 
	 */
	public void setPrecision(String newValue) {
		if (newValue != null) {
			precision.setText(newValue);
		} else {
			precision.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.TypeAttributes.precision, ((AttributePropertiesEditionComponent) propertiesEditionComponent).getPrecisionSettings().getOrCreateSignificantObject());
		if (readOnly && precision.isEnabled()) {
			precision.setEnabled(false);
			precision.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !precision.isEnabled()) {
			precision.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getLiterals()
	 * 
	 */
	public EList getLiterals() {
		return literalsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setLiterals(EList newValue)
	 * 
	 */
	public void setLiterals(EList newValue) {
		literalsList = newValue;
		if (newValue != null) {
			literals.setText(literalsList.toString());
		} else {
			literals.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.literals, ((AttributePropertiesEditionComponent) propertiesEditionComponent).getLiteralsSettings().getOrCreateSignificantObject());
		if (readOnly && literals.isEnabled()) {
			literals.setEnabled(false);
			literals.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !literals.isEnabled()) {
			literals.setEnabled(true);
		}	
		
	}

	public void addToLiterals(Object newValue) {
		literalsList.add(newValue);
		if (newValue != null) {
			literals.setText(literalsList.toString());
		} else {
			literals.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToLiterals(Object newValue) {
		literalsList.remove(newValue);
		if (newValue != null) {
			literals.setText(literalsList.toString());
		} else {
			literals.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getRequired()
	 * 
	 */
	public Boolean getRequired() {
		return Boolean.valueOf(required.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setRequired(Boolean newValue)
	 * 
	 */
	public void setRequired(Boolean newValue) {
		if (newValue != null) {
			required.setSelection(newValue.booleanValue());
		} else {
			required.setSelection(false);
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.required);
		if (readOnly && required.isEnabled()) {
			required.setEnabled(false);
			required.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !required.isEnabled()) {
			required.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getInPrimaryIdentifier()
	 * 
	 */
	public Boolean getInPrimaryIdentifier() {
		return Boolean.valueOf(inPrimaryIdentifier.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setInPrimaryIdentifier(Boolean newValue)
	 * 
	 */
	public void setInPrimaryIdentifier(Boolean newValue) {
		if (newValue != null) {
			inPrimaryIdentifier.setSelection(newValue.booleanValue());
		} else {
			inPrimaryIdentifier.setSelection(false);
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.RequiredAndIdentifier.inPrimaryIdentifier);
		if (readOnly && inPrimaryIdentifier.isEnabled()) {
			inPrimaryIdentifier.setEnabled(false);
			inPrimaryIdentifier.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !inPrimaryIdentifier.isEnabled()) {
			inPrimaryIdentifier.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.AttributePropertiesEditionPart#setComments(String newValue)
	 * 
	 */
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Attribute.Properties.comments);
		if (readOnly && comments.isEnabled()) {
			comments.setEnabled(false);
			comments.setBackground(comments.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			comments.setToolTipText(EntityrelationMessages.Attribute_ReadOnly);
		} else if (!readOnly && !comments.isEnabled()) {
			comments.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EntityrelationMessages.Attribute_Part_Title;
	}

	// Start of user code additional methods
	private static final int LENGHT_LABEL_INDEX = 0;
	private static final int LENGHT_TEXT_INDEX = 1;
	private static final int LENGHT_HELP_INDEX = 2;
	private static final int PRECISION_LABEL_INDEX = 3;
	private static final int PRECISION_TEXT_INDEX = 4;
	private static final int PRECISION_HELP_INDEX = 5;
	private static final int LENGHT_AND_PRECISION_COMPOSITE_INDEX = 6;
	private static final int LITERALS_TEXT_INDEX = 7;
	private static final int LITERALS_BUTTON_INDEX = 8;
	
	public void updateTypeFields(boolean lengthVisible, boolean precisionVisible, boolean literalsVisible) {
		Composite composite = getMainComposite();
		Composite lengthAndPrecisionComposite = (Composite)composite.getChildren()[LENGHT_AND_PRECISION_COMPOSITE_INDEX];
		HorizontalBox lengthAndPrecisionHBox = (HorizontalBox)lengthAndPrecisionComposite.getChildren()[0];
		
		Control lengthText = lengthAndPrecisionHBox.getChildren()[LENGHT_TEXT_INDEX];
		Control lengthLabel = lengthAndPrecisionHBox.getChildren()[LENGHT_LABEL_INDEX];
		Control lengthHelp = lengthAndPrecisionHBox.getChildren()[LENGHT_HELP_INDEX];
		setVisibilityOnWidget(lengthText, lengthVisible);
		setVisibilityOnWidget(lengthLabel, lengthVisible);
		setVisibilityOnWidget(lengthHelp, lengthVisible);
		
		Control precisionText = lengthAndPrecisionHBox.getChildren()[PRECISION_TEXT_INDEX];
		Control precisionLabel = lengthAndPrecisionHBox.getChildren()[PRECISION_LABEL_INDEX];
		Control precisionHelp = lengthAndPrecisionHBox.getChildren()[PRECISION_HELP_INDEX];

		setVisibilityOnWidget(precisionText, precisionVisible);
		setVisibilityOnWidget(precisionLabel, precisionVisible);
		setVisibilityOnWidget(precisionHelp, precisionVisible);
		
		setVisibilityOnWidget(lengthAndPrecisionComposite, lengthVisible || precisionVisible);		
		
		Control literalsText = composite.getChildren()[LITERALS_TEXT_INDEX];
		Control literalsButton = composite.getChildren()[LITERALS_BUTTON_INDEX];
		setVisibilityOnWidget(literalsText, literalsVisible);
		setVisibilityOnWidget(literalsButton, literalsVisible);

		lengthAndPrecisionHBox.layout();
		lengthAndPrecisionComposite.layout();
		composite.layout();
	}
	
	private void setVisibilityOnWidget(Control widget, boolean visible) {
		((GridData)widget.getLayoutData()).exclude = !visible;
		widget.setVisible(visible);
	}
	
	private Composite getMainComposite() {
		Section section = (Section)view.getChildren()[0];
		Composite content  = (Composite)section.getChildren()[2];
		return content;
	}
	// End of user code


}
