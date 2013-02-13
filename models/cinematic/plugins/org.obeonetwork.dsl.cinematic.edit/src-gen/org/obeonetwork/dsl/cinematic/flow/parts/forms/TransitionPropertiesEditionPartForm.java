/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.flow.providers.FlowMessages;

// End of user code

/**
 * 
 * 
 */
public class TransitionPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, TransitionPropertiesEditionPart {

	protected Text name;
	protected Text guard;
	protected Button modal;
	protected ReferencesTable on;
	protected List<ViewerFilter> onBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> onFilters = new ArrayList<ViewerFilter>();
	protected Text description;
	protected EObjectFlatComboViewer from;
	protected EObjectFlatComboViewer to;



	/**
	 * For {@link ISection} use only.
	 */
	public TransitionPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TransitionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence transitionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = transitionStep.addStep(FlowViewsRepository.Transition.Properties.class);
		propertiesStep.addStep(FlowViewsRepository.Transition.Properties.name);
		propertiesStep.addStep(FlowViewsRepository.Transition.Properties.guard);
		propertiesStep.addStep(FlowViewsRepository.Transition.Properties.modal);
		propertiesStep.addStep(FlowViewsRepository.Transition.Properties.on);
		propertiesStep.addStep(FlowViewsRepository.Transition.Properties.description);
		propertiesStep.addStep(FlowViewsRepository.Transition.Properties.from);
		propertiesStep.addStep(FlowViewsRepository.Transition.Properties.to);
		
		
		composer = new PartComposer(transitionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == FlowViewsRepository.Transition.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.Transition.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.Transition.Properties.guard) {
					return createGuardText(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.Transition.Properties.modal) {
					return createModalCheckbox(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.Transition.Properties.on) {
					return createOnReferencesTable(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.Transition.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == FlowViewsRepository.Transition.Properties.from) {
					return createFromFlatComboViewer(parent, widgetFactory);
				}
				if (key == FlowViewsRepository.Transition.Properties.to) {
					return createToFlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(FlowMessages.TransitionPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, FlowViewsRepository.Transition.Properties.name, FlowMessages.TransitionPropertiesEditionPart_NameLabel);
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
							TransitionPropertiesEditionPartForm.this,
							FlowViewsRepository.Transition.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TransitionPropertiesEditionPartForm.this,
									FlowViewsRepository.Transition.Properties.name,
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
									TransitionPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, FlowViewsRepository.Transition.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Transition.Properties.name, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createGuardText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, FlowViewsRepository.Transition.Properties.guard, FlowMessages.TransitionPropertiesEditionPart_GuardLabel);
		guard = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		guard.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData guardData = new GridData(GridData.FILL_HORIZONTAL);
		guard.setLayoutData(guardData);
		guard.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							TransitionPropertiesEditionPartForm.this,
							FlowViewsRepository.Transition.Properties.guard,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, guard.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TransitionPropertiesEditionPartForm.this,
									FlowViewsRepository.Transition.Properties.guard,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, guard.getText()));
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
									TransitionPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		guard.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.guard, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, guard.getText()));
				}
			}
		});
		EditingUtils.setID(guard, FlowViewsRepository.Transition.Properties.guard);
		EditingUtils.setEEFtype(guard, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Transition.Properties.guard, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createModalCheckbox(FormToolkit widgetFactory, Composite parent) {
		modal = widgetFactory.createButton(parent, getDescription(FlowViewsRepository.Transition.Properties.modal, FlowMessages.TransitionPropertiesEditionPart_ModalLabel), SWT.CHECK);
		modal.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.modal, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(modal.getSelection())));
			}

		});
		GridData modalData = new GridData(GridData.FILL_HORIZONTAL);
		modalData.horizontalSpan = 2;
		modal.setLayoutData(modalData);
		EditingUtils.setID(modal, FlowViewsRepository.Transition.Properties.modal);
		EditingUtils.setEEFtype(modal, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Transition.Properties.modal, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createOnReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.on = new ReferencesTable(getDescription(FlowViewsRepository.Transition.Properties.on, FlowMessages.TransitionPropertiesEditionPart_OnLabel), new ReferencesTableListener	() {
			public void handleAdd() { addOn(); }
			public void handleEdit(EObject element) { editOn(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveOn(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromOn(element); }
			public void navigateTo(EObject element) { }
		});
		this.on.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.Transition.Properties.on, FlowViewsRepository.FORM_KIND));
		this.on.createControls(parent, widgetFactory);
		this.on.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.on, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData onData = new GridData(GridData.FILL_HORIZONTAL);
		onData.horizontalSpan = 3;
		this.on.setLayoutData(onData);
		this.on.disableMove();
		on.setID(FlowViewsRepository.Transition.Properties.on);
		on.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addOn() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(on.getInput(), onFilters, onBusinessFilters,
		"on", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.on,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				on.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveOn(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.on, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		on.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromOn(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.on, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		on.refresh();
	}

	/**
	 * 
	 */
	protected void editOn(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				on.refresh();
			}
		}
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, FlowViewsRepository.Transition.Properties.description, FlowMessages.TransitionPropertiesEditionPart_DescriptionLabel);
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
							TransitionPropertiesEditionPartForm.this,
							FlowViewsRepository.Transition.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TransitionPropertiesEditionPartForm.this,
									FlowViewsRepository.Transition.Properties.description,
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
									TransitionPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, FlowViewsRepository.Transition.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Transition.Properties.description, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createFromFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, FlowViewsRepository.Transition.Properties.from, FlowMessages.TransitionPropertiesEditionPart_FromLabel);
		from = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(FlowViewsRepository.Transition.Properties.from, FlowViewsRepository.FORM_KIND));
		widgetFactory.adapt(from);
		from.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData fromData = new GridData(GridData.FILL_HORIZONTAL);
		from.setLayoutData(fromData);
		from.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.from, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFrom()));
			}

		});
		from.setID(FlowViewsRepository.Transition.Properties.from);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Transition.Properties.from, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createToFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, FlowViewsRepository.Transition.Properties.to, FlowMessages.TransitionPropertiesEditionPart_ToLabel);
		to = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(FlowViewsRepository.Transition.Properties.to, FlowViewsRepository.FORM_KIND));
		widgetFactory.adapt(to);
		to.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData toData = new GridData(GridData.FILL_HORIZONTAL);
		to.setLayoutData(toData);
		to.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, FlowViewsRepository.Transition.Properties.to, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTo()));
			}

		});
		to.setID(FlowViewsRepository.Transition.Properties.to);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Transition.Properties.to, FlowViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#getGuard()
	 * 
	 */
	public String getGuard() {
		return guard.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setGuard(String newValue)
	 * 
	 */
	public void setGuard(String newValue) {
		if (newValue != null) {
			guard.setText(newValue);
		} else {
			guard.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.guard);
		if (readOnly && guard.isEnabled()) {
			guard.setEnabled(false);
			guard.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !guard.isEnabled()) {
			guard.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#getModal()
	 * 
	 */
	public Boolean getModal() {
		return Boolean.valueOf(modal.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setModal(Boolean newValue)
	 * 
	 */
	public void setModal(Boolean newValue) {
		if (newValue != null) {
			modal.setSelection(newValue.booleanValue());
		} else {
			modal.setSelection(false);
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.modal);
		if (readOnly && modal.isEnabled()) {
			modal.setEnabled(false);
			modal.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !modal.isEnabled()) {
			modal.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#initOn(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initOn(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		on.setContentProvider(contentProvider);
		on.setInput(settings);
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.on);
		if (readOnly && on.getTable().isEnabled()) {
			on.setEnabled(false);
			on.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !on.getTable().isEnabled()) {
			on.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#updateOn()
	 * 
	 */
	public void updateOn() {
	on.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#addFilterOn(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOn(ViewerFilter filter) {
		onFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#addBusinessFilterOn(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOn(ViewerFilter filter) {
		onBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#isContainedInOnTable(EObject element)
	 * 
	 */
	public boolean isContainedInOnTable(EObject element) {
		return ((ReferencesTableSettings)on.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#getFrom()
	 * 
	 */
	public EObject getFrom() {
		if (from.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) from.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#initFrom(EObjectFlatComboSettings)
	 */
	public void initFrom(EObjectFlatComboSettings settings) {
		from.setInput(settings);
		if (current != null) {
			from.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.from);
		if (readOnly && from.isEnabled()) {
			from.setEnabled(false);
			from.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !from.isEnabled()) {
			from.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setFrom(EObject newValue)
	 * 
	 */
	public void setFrom(EObject newValue) {
		if (newValue != null) {
			from.setSelection(new StructuredSelection(newValue));
		} else {
			from.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.from);
		if (readOnly && from.isEnabled()) {
			from.setEnabled(false);
			from.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !from.isEnabled()) {
			from.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setFromButtonMode(ButtonsModeEnum newValue)
	 */
	public void setFromButtonMode(ButtonsModeEnum newValue) {
		from.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#addFilterFrom(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFrom(ViewerFilter filter) {
		from.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#addBusinessFilterFrom(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFrom(ViewerFilter filter) {
		from.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#getTo()
	 * 
	 */
	public EObject getTo() {
		if (to.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) to.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#initTo(EObjectFlatComboSettings)
	 */
	public void initTo(EObjectFlatComboSettings settings) {
		to.setInput(settings);
		if (current != null) {
			to.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.to);
		if (readOnly && to.isEnabled()) {
			to.setEnabled(false);
			to.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !to.isEnabled()) {
			to.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setTo(EObject newValue)
	 * 
	 */
	public void setTo(EObject newValue) {
		if (newValue != null) {
			to.setSelection(new StructuredSelection(newValue));
		} else {
			to.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(FlowViewsRepository.Transition.Properties.to);
		if (readOnly && to.isEnabled()) {
			to.setEnabled(false);
			to.setToolTipText(FlowMessages.Transition_ReadOnly);
		} else if (!readOnly && !to.isEnabled()) {
			to.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#setToButtonMode(ButtonsModeEnum newValue)
	 */
	public void setToButtonMode(ButtonsModeEnum newValue) {
		to.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#addFilterTo(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTo(ViewerFilter filter) {
		to.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.TransitionPropertiesEditionPart#addBusinessFilterTo(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTo(ViewerFilter filter) {
		to.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return FlowMessages.Transition_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
