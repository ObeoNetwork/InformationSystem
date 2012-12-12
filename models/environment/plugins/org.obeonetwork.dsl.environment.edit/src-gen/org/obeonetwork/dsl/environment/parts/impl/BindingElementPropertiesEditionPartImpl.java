/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts.impl;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.environment.parts.BindingElementPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class BindingElementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, BindingElementPropertiesEditionPart {

	protected EMFComboViewer boundElement;
	protected Text bindingExpression;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BindingElementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence bindingElementStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = bindingElementStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.boundElement);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.bindingExpression);
		propertiesStep.addStep(EnvironmentViewsRepository.BindingElement.Properties.description);
		
		
		composer = new PartComposer(bindingElementStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.BindingElement.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EnvironmentViewsRepository.BindingElement.Properties.boundElement) {
					return createBoundElementEMFComboViewer(parent);
				}
				if (key == EnvironmentViewsRepository.BindingElement.Properties.bindingExpression) {
					return createBindingExpressionText(parent);
				}
				if (key == EnvironmentViewsRepository.BindingElement.Properties.description) {
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
		propertiesGroup.setText(EnvironmentMessages.BindingElementPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createBoundElementEMFComboViewer(Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingElementPropertiesEditionPartImpl.this, EnvironmentViewsRepository.BindingElement.Properties.boundElement, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getBoundElement()));
			}

		});
		boundElement.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(boundElement.getCombo(), EnvironmentViewsRepository.BindingElement.Properties.boundElement);
		EditingUtils.setEEFtype(boundElement.getCombo(), "eef::Combo"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingElement.Properties.boundElement, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createBindingExpressionText(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.BindingElement.Properties.bindingExpression, EnvironmentMessages.BindingElementPropertiesEditionPart_BindingExpressionLabel);
		bindingExpression = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData bindingExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		bindingExpression.setLayoutData(bindingExpressionData);
		bindingExpression.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingElementPropertiesEditionPartImpl.this, EnvironmentViewsRepository.BindingElement.Properties.bindingExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, bindingExpression.getText()));
			}

		});
		bindingExpression.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingElementPropertiesEditionPartImpl.this, EnvironmentViewsRepository.BindingElement.Properties.bindingExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, bindingExpression.getText()));
				}
			}

		});
		EditingUtils.setID(bindingExpression, EnvironmentViewsRepository.BindingElement.Properties.bindingExpression);
		EditingUtils.setEEFtype(bindingExpression, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingElement.Properties.bindingExpression, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, EnvironmentViewsRepository.BindingElement.Properties.description, EnvironmentMessages.BindingElementPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BindingElementPropertiesEditionPartImpl.this, EnvironmentViewsRepository.BindingElement.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, EnvironmentViewsRepository.BindingElement.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.BindingElement.Properties.description, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
