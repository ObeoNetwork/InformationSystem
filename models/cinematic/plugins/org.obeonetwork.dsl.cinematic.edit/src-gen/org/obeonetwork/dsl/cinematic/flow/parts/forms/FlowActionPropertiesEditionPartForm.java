/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.providers.FlowMessages;

// End of user code

/**
 * 
 * 
 */
public class FlowActionPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, FlowActionPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable calls;
	protected List<ViewerFilter> callsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> callsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable operations;
	protected List<ViewerFilter> operationsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> operationsFilters = new ArrayList<ViewerFilter>();
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public FlowActionPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FlowActionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence flowActionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = flowActionStep.addStep(FlowViewsRepository.FlowAction.Properties.class);
		propertiesStep.addStep(FlowViewsRepository.FlowAction.Properties.name);
		propertiesStep.addStep(FlowViewsRepository.FlowAction.Properties.calls);
		propertiesStep.addStep(FlowViewsRepository.FlowAction.Properties.operations);
		propertiesStep.addStep(FlowViewsRepository.FlowAction.Properties.description);
		
		
		composer = new PartComposer(flowActionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == FlowViewsRepository.FlowAction.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.FlowAction.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.FlowAction.Properties.calls) {
					return createCallsReferencesTable(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.FlowAction.Properties.operations) {
					return createOperationsReferencesTable(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.FlowAction.Properties.description) {
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
		propertiesSection.setText(FlowMessages.FlowActionPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, FlowViewsRepository.FlowAction.Properties.name, FlowMessages.FlowActionPropertiesEditionPart_NameLabel);
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
							FlowActionPropertiesEditionPartForm.this,
							FlowViewsRepository.FlowAction.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FlowActionPropertiesEditionPartForm.this,
									FlowViewsRepository.FlowAction.Properties.name,
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
									FlowActionPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, FlowViewsRepository.FlowAction.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.FlowAction.Properties.name, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCallsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.calls = new ReferencesTable(getDescription(FlowViewsRepository.FlowAction.Properties.calls, FlowMessages.FlowActionPropertiesEditionPart_CallsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addCalls(); }
			public void handleEdit(EObject element) { editCalls(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveCalls(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromCalls(element); }
			public void navigateTo(EObject element) { }
		});
		this.calls.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.FlowAction.Properties.calls, FlowViewsRepository.FORM_KIND));
		this.calls.createControls(parent, widgetFactory);
		this.calls.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.calls, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData callsData = new GridData(GridData.FILL_HORIZONTAL);
		callsData.horizontalSpan = 3;
		this.calls.setLayoutData(callsData);
		this.calls.disableMove();
		calls.setID(FlowViewsRepository.FlowAction.Properties.calls);
		calls.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createCallsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addCalls() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(calls.getInput(), callsFilters, callsBusinessFilters,
		"calls", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.calls,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				calls.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveCalls(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.calls, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		calls.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromCalls(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.calls, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		calls.refresh();
	}

	/**
	 * 
	 */
	protected void editCalls(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				calls.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createOperationsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.operations = new ReferencesTable(getDescription(FlowViewsRepository.FlowAction.Properties.operations, FlowMessages.FlowActionPropertiesEditionPart_OperationsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addOperations(); }
			public void handleEdit(EObject element) { editOperations(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveOperations(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromOperations(element); }
			public void navigateTo(EObject element) { }
		});
		this.operations.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.FlowAction.Properties.operations, FlowViewsRepository.FORM_KIND));
		this.operations.createControls(parent, widgetFactory);
		this.operations.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.operations, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData operationsData = new GridData(GridData.FILL_HORIZONTAL);
		operationsData.horizontalSpan = 3;
		this.operations.setLayoutData(operationsData);
		this.operations.disableMove();
		operations.setID(FlowViewsRepository.FlowAction.Properties.operations);
		operations.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createOperationsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addOperations() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(operations.getInput(), operationsFilters, operationsBusinessFilters,
		"operations", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.operations,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				operations.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveOperations(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		operations.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromOperations(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		operations.refresh();
	}

	/**
	 * 
	 */
	protected void editOperations(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				operations.refresh();
			}
		}
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, FlowViewsRepository.FlowAction.Properties.description, FlowMessages.FlowActionPropertiesEditionPart_DescriptionLabel);
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
							FlowActionPropertiesEditionPartForm.this,
							FlowViewsRepository.FlowAction.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FlowActionPropertiesEditionPartForm.this,
									FlowViewsRepository.FlowAction.Properties.description,
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
									FlowActionPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowActionPropertiesEditionPartForm.this, FlowViewsRepository.FlowAction.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, FlowViewsRepository.FlowAction.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.FlowAction.Properties.description, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.FlowAction.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(FlowMessages.FlowAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#initCalls(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initCalls(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		calls.setContentProvider(contentProvider);
		calls.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.FlowAction.Properties.calls);
		if (eefElementEditorReadOnlyState && calls.getTable().isEnabled()) {
			calls.setEnabled(false);
			calls.setToolTipText(FlowMessages.FlowAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !calls.getTable().isEnabled()) {
			calls.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#updateCalls()
	 * 
	 */
	public void updateCalls() {
	calls.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#addFilterCalls(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCalls(ViewerFilter filter) {
		callsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#addBusinessFilterCalls(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCalls(ViewerFilter filter) {
		callsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#isContainedInCallsTable(EObject element)
	 * 
	 */
	public boolean isContainedInCallsTable(EObject element) {
		return ((ReferencesTableSettings)calls.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#initOperations(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initOperations(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		operations.setContentProvider(contentProvider);
		operations.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.FlowAction.Properties.operations);
		if (eefElementEditorReadOnlyState && operations.getTable().isEnabled()) {
			operations.setEnabled(false);
			operations.setToolTipText(FlowMessages.FlowAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operations.getTable().isEnabled()) {
			operations.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#updateOperations()
	 * 
	 */
	public void updateOperations() {
	operations.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#addFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOperations(ViewerFilter filter) {
		operationsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#addBusinessFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOperations(ViewerFilter filter) {
		operationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#isContainedInOperationsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOperationsTable(EObject element) {
		return ((ReferencesTableSettings)operations.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowActionPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.FlowAction.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(FlowMessages.FlowAction_ReadOnly);
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
		return FlowMessages.FlowAction_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
