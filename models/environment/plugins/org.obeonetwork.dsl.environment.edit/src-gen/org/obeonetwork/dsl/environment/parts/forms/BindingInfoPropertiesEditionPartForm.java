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
import org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class BindingInfoPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, BindingInfoPropertiesEditionPart {

	protected EMFComboViewer left;
	protected EMFComboViewer right;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public BindingInfoPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BindingInfoPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence bindingInfoStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = bindingInfoStep.addStep(EnvironmentViewsRepository.BindingInfo.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingInfo.Properties.left);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingInfo.Properties.right);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingInfo.Properties.description);
		
		
		composer = new PartComposer(bindingInfoStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.BindingInfo.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.BindingInfo.Properties.left) {
					return createLeftEMFComboViewer(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.BindingInfo.Properties.right) {
					return createRightEMFComboViewer(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.BindingInfo.Properties.description) {
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
		propertiesSection.setText(EnvironmentMessages.BindingInfoPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createLeftEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.BindingInfo.Properties.left, EnvironmentMessages.BindingInfoPropertiesEditionPart_LeftLabel);
		left = new EMFComboViewer(parent);
		GridData leftData = new GridData(GridData.FILL_HORIZONTAL);
		left.getCombo().setLayoutData(leftData);
		left.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		left.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingInfoPropertiesEditionPartForm.this, EnvironmentViewsRepository.BindingInfo.Properties.left, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLeft()));
			}

		});
		left.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(left.getCombo(), EnvironmentViewsRepository.BindingInfo.Properties.left);
		EditingUtils.setEEFtype(left.getCombo(), "eef::Combo");
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingInfo.Properties.left, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createRightEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.BindingInfo.Properties.right, EnvironmentMessages.BindingInfoPropertiesEditionPart_RightLabel);
		right = new EMFComboViewer(parent);
		GridData rightData = new GridData(GridData.FILL_HORIZONTAL);
		right.getCombo().setLayoutData(rightData);
		right.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		right.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingInfoPropertiesEditionPartForm.this, EnvironmentViewsRepository.BindingInfo.Properties.right, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRight()));
			}

		});
		right.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(right.getCombo(), EnvironmentViewsRepository.BindingInfo.Properties.right);
		EditingUtils.setEEFtype(right.getCombo(), "eef::Combo");
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingInfo.Properties.right, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionTextarea(FormToolkit widgetFactory, Composite parent) {
		Label descriptionLabel = createDescription(parent, EnvironmentViewsRepository.BindingInfo.Properties.description, EnvironmentMessages.BindingInfoPropertiesEditionPart_DescriptionLabel);
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
							BindingInfoPropertiesEditionPartForm.this,
							EnvironmentViewsRepository.BindingInfo.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BindingInfoPropertiesEditionPartForm.this,
									EnvironmentViewsRepository.BindingInfo.Properties.description,
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
									BindingInfoPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(description, EnvironmentViewsRepository.BindingInfo.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingInfo.Properties.description, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#getLeft()
	 * 
	 */
	public Object getLeft() {
		if (left.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection) left.getSelection()).getFirstElement();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#initLeft(Object input, Object currentValue)
	 */
	public void initLeft(Object input, Object currentValue) {
		left.setInput(input);
		if (currentValue != null) {
			left.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#setLeft(Object newValue)
	 * 
	 */
	public void setLeft(Object newValue) {
		if (newValue != null) {
			left.modelUpdating(new StructuredSelection(newValue));
		} else {
			left.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.BindingInfo.Properties.left);
		if (readOnly && left.isEnabled()) {
			left.setEnabled(false);
			left.setToolTipText(EnvironmentMessages.BindingInfo_ReadOnly);
		} else if (!readOnly && !left.isEnabled()) {
			left.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#addFilterLeft(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLeft(ViewerFilter filter) {
		left.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#getRight()
	 * 
	 */
	public Object getRight() {
		if (right.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection) right.getSelection()).getFirstElement();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#initRight(Object input, Object currentValue)
	 */
	public void initRight(Object input, Object currentValue) {
		right.setInput(input);
		if (currentValue != null) {
			right.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#setRight(Object newValue)
	 * 
	 */
	public void setRight(Object newValue) {
		if (newValue != null) {
			right.modelUpdating(new StructuredSelection(newValue));
		} else {
			right.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.BindingInfo.Properties.right);
		if (readOnly && right.isEnabled()) {
			right.setEnabled(false);
			right.setToolTipText(EnvironmentMessages.BindingInfo_ReadOnly);
		} else if (!readOnly && !right.isEnabled()) {
			right.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#addFilterRight(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRight(ViewerFilter filter) {
		right.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.BindingInfoPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.BindingInfo.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(EnvironmentMessages.BindingInfo_ReadOnly);
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
		return EnvironmentMessages.BindingInfo_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
