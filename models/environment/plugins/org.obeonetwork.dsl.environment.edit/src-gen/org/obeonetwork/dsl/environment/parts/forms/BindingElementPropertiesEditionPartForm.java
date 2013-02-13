/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts.forms;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class BindingElementPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, BindingElementPropertiesEditionPart {

	protected EMFComboViewer boundElement;
	protected Text bindingExpression;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public BindingElementPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BindingElementPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence bindingElementStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = bindingElementStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.boundElement);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.bindingExpression);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.description);
		
		
		composer = new PartComposer(bindingElementStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.BindingElement.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.BindingElement.Properties.boundElement) {
					return createBoundElementEMFComboViewer(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.BindingElement.Properties.bindingExpression) {
					return createBindingExpressionText(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.BindingElement.Properties.description) {
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
		propertiesSection.setText(EnvironmentMessages.BindingElementPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createBoundElementEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.BindingElement.Properties.boundElement, EnvironmentMessages.BindingElementPropertiesEditionPart_BoundElementLabel);
		boundElement = new EMFComboViewer(parent);
		GridData boundElementData = new GridData(GridData.FILL_HORIZONTAL);
		boundElement.getCombo().setLayoutData(boundElementData);
		boundElement.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		boundElement.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingElementPropertiesEditionPartForm.this, EnvironmentViewsRepository.BindingElement.Properties.boundElement, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getBoundElement()));
			}

		});
		boundElement.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(boundElement.getCombo(), EnvironmentViewsRepository.BindingElement.Properties.boundElement);
		EditingUtils.setEEFtype(boundElement.getCombo(), "eef::Combo");
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingElement.Properties.boundElement, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createBindingExpressionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.BindingElement.Properties.bindingExpression, EnvironmentMessages.BindingElementPropertiesEditionPart_BindingExpressionLabel);
		bindingExpression = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		bindingExpression.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData bindingExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		bindingExpression.setLayoutData(bindingExpressionData);
		bindingExpression.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BindingElementPropertiesEditionPartForm.this,
							EnvironmentViewsRepository.BindingElement.Properties.bindingExpression,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, bindingExpression.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BindingElementPropertiesEditionPartForm.this,
									EnvironmentViewsRepository.BindingElement.Properties.bindingExpression,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, bindingExpression.getText()));
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
									BindingElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		bindingExpression.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingElementPropertiesEditionPartForm.this, EnvironmentViewsRepository.BindingElement.Properties.bindingExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, bindingExpression.getText()));
				}
			}
		});
		EditingUtils.setID(bindingExpression, EnvironmentViewsRepository.BindingElement.Properties.bindingExpression);
		EditingUtils.setEEFtype(bindingExpression, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingElement.Properties.bindingExpression, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionTextarea(FormToolkit widgetFactory, Composite parent) {
		Label descriptionLabel = createDescription(parent, EnvironmentViewsRepository.BindingElement.Properties.description, EnvironmentMessages.BindingElementPropertiesEditionPart_DescriptionLabel);
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
							BindingElementPropertiesEditionPartForm.this,
							EnvironmentViewsRepository.BindingElement.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BindingElementPropertiesEditionPartForm.this,
									EnvironmentViewsRepository.BindingElement.Properties.description,
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
									BindingElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(description, EnvironmentViewsRepository.BindingElement.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingElement.Properties.description, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#getBoundElement()
	 * 
	 */
	public Object getBoundElement() {
		if (boundElement.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection) boundElement.getSelection()).getFirstElement();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#initBoundElement(Object input, Object currentValue)
	 */
	public void initBoundElement(Object input, Object currentValue) {
		boundElement.setInput(input);
		if (currentValue != null) {
			boundElement.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#setBoundElement(Object newValue)
	 * 
	 */
	public void setBoundElement(Object newValue) {
		if (newValue != null) {
			boundElement.modelUpdating(new StructuredSelection(newValue));
		} else {
			boundElement.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.BindingElement.Properties.boundElement);
		if (readOnly && boundElement.isEnabled()) {
			boundElement.setEnabled(false);
			boundElement.setToolTipText(EnvironmentMessages.BindingElement_ReadOnly);
		} else if (!readOnly && !boundElement.isEnabled()) {
			boundElement.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#addFilterBoundElement(ViewerFilter filter)
	 * 
	 */
	public void addFilterToBoundElement(ViewerFilter filter) {
		boundElement.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#getBindingExpression()
	 * 
	 */
	public String getBindingExpression() {
		return bindingExpression.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#setBindingExpression(String newValue)
	 * 
	 */
	public void setBindingExpression(String newValue) {
		if (newValue != null) {
			bindingExpression.setText(newValue);
		} else {
			bindingExpression.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.BindingElement.Properties.bindingExpression);
		if (readOnly && bindingExpression.isEnabled()) {
			bindingExpression.setEnabled(false);
			bindingExpression.setToolTipText(EnvironmentMessages.BindingElement_ReadOnly);
		} else if (!readOnly && !bindingExpression.isEnabled()) {
			bindingExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.BindingElement.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(EnvironmentMessages.BindingElement_ReadOnly);
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
		return EnvironmentMessages.BindingElement_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
