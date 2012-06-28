/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts.forms;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.providers.TypeslibraryMessages;

// End of user code

/**
 * 
 * 
 */
public class TypeInstancePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, TypeInstancePropertiesEditionPart {

	protected EMFComboViewer type;
	protected Text length;
	protected Text precision;
	protected Text literals;
	protected Button editLiterals;
	private EList literalsList;



	/**
	 * For {@link ISection} use only.
	 */
	public TypeInstancePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TypeInstancePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence typeInstanceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = typeInstanceStep.addStep(TypeslibraryViewsRepository.TypeInstance.Properties.class);
		propertiesStep.addStep(TypeslibraryViewsRepository.TypeInstance.Properties.type);
		CompositionStep typeAttributesStep = propertiesStep.addStep(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.class);
		typeAttributesStep.addStep(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length);
		typeAttributesStep.addStep(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision);
		
		propertiesStep.addStep(TypeslibraryViewsRepository.TypeInstance.Properties.literals);
		
		
		composer = new PartComposer(typeInstanceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == TypeslibraryViewsRepository.TypeInstance.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == TypeslibraryViewsRepository.TypeInstance.Properties.type) {
					return createTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.class) {
					return createTypeAttributesHBox(widgetFactory, parent);
				}
				if (key == TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length) {
					return createLengthText(widgetFactory, parent);
				}
				if (key == TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision) {
					return createPrecisionText(widgetFactory, parent);
				}
				if (key == TypeslibraryViewsRepository.TypeInstance.Properties.literals) {
					return createLiteralsMultiValuedEditor(widgetFactory, parent);
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
		propertiesSection.setText(TypeslibraryMessages.TypeInstancePropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.TypeInstance.Properties.type, TypeslibraryMessages.TypeInstancePropertiesEditionPart_TypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TypeInstancePropertiesEditionPartForm.this, TypeslibraryViewsRepository.TypeInstance.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		type.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(type.getCombo(), TypeslibraryViewsRepository.TypeInstance.Properties.type);
		EditingUtils.setEEFtype(type.getCombo(), "eef::Combo");
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.TypeInstance.Properties.type, TypeslibraryViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
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
		createDescription(parent, TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length, TypeslibraryMessages.TypeInstancePropertiesEditionPart_LengthLabel);
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
							TypeInstancePropertiesEditionPartForm.this,
							TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TypeInstancePropertiesEditionPartForm.this,
									TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length,
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
									TypeInstancePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TypeInstancePropertiesEditionPartForm.this, TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
				}
			}
		});
		EditingUtils.setID(length, TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length);
		EditingUtils.setEEFtype(length, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.length, TypeslibraryViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPrecisionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision, TypeslibraryMessages.TypeInstancePropertiesEditionPart_PrecisionLabel);
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
							TypeInstancePropertiesEditionPartForm.this,
							TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, precision.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TypeInstancePropertiesEditionPartForm.this,
									TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision,
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
									TypeInstancePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TypeInstancePropertiesEditionPartForm.this, TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, precision.getText()));
				}
			}
		});
		EditingUtils.setID(precision, TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision);
		EditingUtils.setEEFtype(precision, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.TypeInstance.Properties.TypeAttributes.precision, TypeslibraryViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(literals, TypeslibraryViewsRepository.TypeInstance.Properties.literals);
		EditingUtils.setEEFtype(literals, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editLiterals = widgetFactory.createButton(parent, getDescription(TypeslibraryViewsRepository.TypeInstance.Properties.literals, TypeslibraryMessages.TypeInstancePropertiesEditionPart_LiteralsLabel), SWT.NONE);
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
						literals.getShell(), "TypeInstance", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						literalsList, TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					literalsList = dialog.getResult();
					if (literalsList == null) {
						literalsList = new BasicEList();
					}
					literals.setText(literalsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TypeInstancePropertiesEditionPartForm.this, TypeslibraryViewsRepository.TypeInstance.Properties.literals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(literalsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editLiterals, TypeslibraryViewsRepository.TypeInstance.Properties.literals);
		EditingUtils.setEEFtype(editLiterals, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#getType()
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#initType(Object input, Object currentValue)
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#setType(Object newValue)
	 * 
	 */
	public void setType(Object newValue) {
		if (newValue != null) {
			type.modelUpdating(new StructuredSelection(newValue));
		} else {
			type.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#addFilterType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToType(ViewerFilter filter) {
		type.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#getLength()
	 * 
	 */
	public String getLength() {
		return length.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#setLength(String newValue)
	 * 
	 */
	public void setLength(String newValue) {
		if (newValue != null) {
			length.setText(newValue);
		} else {
			length.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#getPrecision()
	 * 
	 */
	public String getPrecision() {
		return precision.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#setPrecision(String newValue)
	 * 
	 */
	public void setPrecision(String newValue) {
		if (newValue != null) {
			precision.setText(newValue);
		} else {
			precision.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#getLiterals()
	 * 
	 */
	public EList getLiterals() {
		return literalsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart#setLiterals(EList newValue)
	 * 
	 */
	public void setLiterals(EList newValue) {
		literalsList = newValue;
		if (newValue != null) {
			literals.setText(literalsList.toString());
		} else {
			literals.setText(""); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TypeslibraryMessages.TypeInstance_Part_Title;
	}

	// Start of user code additional methods
	private static final int LENGHT_LABEL_INDEX = 0;
	private static final int LENGHT_TEXT_INDEX = 1;
	private static final int LENGHT_HELP_INDEX = 2;
	private static final int PRECISION_LABEL_INDEX = 3;
	private static final int PRECISION_TEXT_INDEX = 4;
	private static final int PRECISION_HELP_INDEX = 5;
	private static final int LENGHT_AND_PRECISION_COMPOSITE_INDEX = 3;
	private static final int LITERALS_TEXT_INDEX = 4;
	private static final int LITERALS_BUTTON_INDEX = 5;
	
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
