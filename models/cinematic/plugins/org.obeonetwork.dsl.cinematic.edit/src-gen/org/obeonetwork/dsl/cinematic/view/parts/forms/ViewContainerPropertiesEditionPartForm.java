/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.view.parts.forms;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
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
import org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.cinematic.view.providers.ViewMessages;

// End of user code

/**
 * 
 * 
 */
public class ViewContainerPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ViewContainerPropertiesEditionPart {

	protected Text name;
	protected Text label;
	protected EObjectFlatComboViewer widget;
	protected ReferencesTable dataBindings;
	protected List<ViewerFilter> dataBindingsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> dataBindingsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable actions;
	protected List<ViewerFilter> actionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> actionsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable events;
	protected List<ViewerFilter> eventsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eventsFilters = new ArrayList<ViewerFilter>();
	protected Text description;
	protected ReferencesTable ownedElements;
	protected List<ViewerFilter> ownedElementsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ownedElementsFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public ViewContainerPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ViewContainerPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence viewContainerStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = viewContainerStep.addStep(ViewViewsRepository.ViewContainer.Properties.class);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.name);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.label);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.widget);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.dataBindings);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.actions);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.events);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.description);
		propertiesStep.addStep(ViewViewsRepository.ViewContainer.Properties.ownedElements);
		
		
		composer = new PartComposer(viewContainerStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ViewViewsRepository.ViewContainer.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.label) {
					return createLabelText(widgetFactory, parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.widget) {
					return createWidgetFlatComboViewer(parent, widgetFactory);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.dataBindings) {
					return createDataBindingsTableComposition(widgetFactory, parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.actions) {
					return createActionsTableComposition(widgetFactory, parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.events) {
					return createEventsTableComposition(widgetFactory, parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == ViewViewsRepository.ViewContainer.Properties.ownedElements) {
					return createOwnedElementsTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(ViewMessages.ViewContainerPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, ViewViewsRepository.ViewContainer.Properties.name, ViewMessages.ViewContainerPropertiesEditionPart_NameLabel);
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
							ViewContainerPropertiesEditionPartForm.this,
							ViewViewsRepository.ViewContainer.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewContainerPropertiesEditionPartForm.this,
									ViewViewsRepository.ViewContainer.Properties.name,
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
									ViewContainerPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, ViewViewsRepository.ViewContainer.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.name, ViewViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createLabelText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ViewViewsRepository.ViewContainer.Properties.label, ViewMessages.ViewContainerPropertiesEditionPart_LabelLabel);
		label = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		label.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData labelData = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(labelData);
		label.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ViewContainerPropertiesEditionPartForm.this,
							ViewViewsRepository.ViewContainer.Properties.label,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, label.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewContainerPropertiesEditionPartForm.this,
									ViewViewsRepository.ViewContainer.Properties.label,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, label.getText()));
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
									ViewContainerPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		label.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.label, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, label.getText()));
				}
			}
		});
		EditingUtils.setID(label, ViewViewsRepository.ViewContainer.Properties.label);
		EditingUtils.setEEFtype(label, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.label, ViewViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createWidgetFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, ViewViewsRepository.ViewContainer.Properties.widget, ViewMessages.ViewContainerPropertiesEditionPart_WidgetLabel);
		widget = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ViewViewsRepository.ViewContainer.Properties.widget, ViewViewsRepository.FORM_KIND));
		widgetFactory.adapt(widget);
		widget.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData widgetData = new GridData(GridData.FILL_HORIZONTAL);
		widget.setLayoutData(widgetData);
		widget.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.widget, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getWidget()));
			}

		});
		widget.setID(ViewViewsRepository.ViewContainer.Properties.widget);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.widget, ViewViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createDataBindingsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.dataBindings = new ReferencesTable(getDescription(ViewViewsRepository.ViewContainer.Properties.dataBindings, ViewMessages.ViewContainerPropertiesEditionPart_DataBindingsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.dataBindings, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				dataBindings.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.dataBindings, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				dataBindings.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.dataBindings, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				dataBindings.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.dataBindings, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				dataBindings.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.dataBindingsFilters) {
			this.dataBindings.addFilter(filter);
		}
		this.dataBindings.setHelpText(propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.dataBindings, ViewViewsRepository.FORM_KIND));
		this.dataBindings.createControls(parent, widgetFactory);
		this.dataBindings.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.dataBindings, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData dataBindingsData = new GridData(GridData.FILL_HORIZONTAL);
		dataBindingsData.horizontalSpan = 3;
		this.dataBindings.setLayoutData(dataBindingsData);
		this.dataBindings.setLowerBound(0);
		this.dataBindings.setUpperBound(-1);
		dataBindings.setID(ViewViewsRepository.ViewContainer.Properties.dataBindings);
		dataBindings.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createActionsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.actions = new ReferencesTable(getDescription(ViewViewsRepository.ViewContainer.Properties.actions, ViewMessages.ViewContainerPropertiesEditionPart_ActionsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				actions.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				actions.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				actions.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				actions.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.actionsFilters) {
			this.actions.addFilter(filter);
		}
		this.actions.setHelpText(propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.actions, ViewViewsRepository.FORM_KIND));
		this.actions.createControls(parent, widgetFactory);
		this.actions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.actions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData actionsData = new GridData(GridData.FILL_HORIZONTAL);
		actionsData.horizontalSpan = 3;
		this.actions.setLayoutData(actionsData);
		this.actions.setLowerBound(0);
		this.actions.setUpperBound(-1);
		actions.setID(ViewViewsRepository.ViewContainer.Properties.actions);
		actions.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEventsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.events = new ReferencesTable(getDescription(ViewViewsRepository.ViewContainer.Properties.events, ViewMessages.ViewContainerPropertiesEditionPart_EventsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				events.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				events.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				events.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				events.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eventsFilters) {
			this.events.addFilter(filter);
		}
		this.events.setHelpText(propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.events, ViewViewsRepository.FORM_KIND));
		this.events.createControls(parent, widgetFactory);
		this.events.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.events, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eventsData = new GridData(GridData.FILL_HORIZONTAL);
		eventsData.horizontalSpan = 3;
		this.events.setLayoutData(eventsData);
		this.events.setLowerBound(0);
		this.events.setUpperBound(-1);
		events.setID(ViewViewsRepository.ViewContainer.Properties.events);
		events.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ViewViewsRepository.ViewContainer.Properties.description, ViewMessages.ViewContainerPropertiesEditionPart_DescriptionLabel);
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
							ViewContainerPropertiesEditionPartForm.this,
							ViewViewsRepository.ViewContainer.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewContainerPropertiesEditionPartForm.this,
									ViewViewsRepository.ViewContainer.Properties.description,
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
									ViewContainerPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, ViewViewsRepository.ViewContainer.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.description, ViewViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOwnedElementsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedElements = new ReferencesTable(getDescription(ViewViewsRepository.ViewContainer.Properties.ownedElements, ViewMessages.ViewContainerPropertiesEditionPart_OwnedElementsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ownedElements.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ownedElements.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ownedElements.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ownedElements.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ownedElementsFilters) {
			this.ownedElements.addFilter(filter);
		}
		this.ownedElements.setHelpText(propertiesEditionComponent.getHelpContent(ViewViewsRepository.ViewContainer.Properties.ownedElements, ViewViewsRepository.FORM_KIND));
		this.ownedElements.createControls(parent, widgetFactory);
		this.ownedElements.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewContainerPropertiesEditionPartForm.this, ViewViewsRepository.ViewContainer.Properties.ownedElements, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ownedElementsData = new GridData(GridData.FILL_HORIZONTAL);
		ownedElementsData.horizontalSpan = 3;
		this.ownedElements.setLayoutData(ownedElementsData);
		this.ownedElements.setLowerBound(0);
		this.ownedElements.setUpperBound(-1);
		ownedElements.setID(ViewViewsRepository.ViewContainer.Properties.ownedElements);
		ownedElements.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getLabel()
	 * 
	 */
	public String getLabel() {
		return label.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setLabel(String newValue)
	 * 
	 */
	public void setLabel(String newValue) {
		if (newValue != null) {
			label.setText(newValue);
		} else {
			label.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.label);
		if (readOnly && label.isEnabled()) {
			label.setEnabled(false);
			label.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !label.isEnabled()) {
			label.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getWidget()
	 * 
	 */
	public EObject getWidget() {
		if (widget.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) widget.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initWidget(EObjectFlatComboSettings)
	 */
	public void initWidget(EObjectFlatComboSettings settings) {
		widget.setInput(settings);
		if (current != null) {
			widget.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.widget);
		if (readOnly && widget.isEnabled()) {
			widget.setEnabled(false);
			widget.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !widget.isEnabled()) {
			widget.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setWidget(EObject newValue)
	 * 
	 */
	public void setWidget(EObject newValue) {
		if (newValue != null) {
			widget.setSelection(new StructuredSelection(newValue));
		} else {
			widget.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.widget);
		if (readOnly && widget.isEnabled()) {
			widget.setEnabled(false);
			widget.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !widget.isEnabled()) {
			widget.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setWidgetButtonMode(ButtonsModeEnum newValue)
	 */
	public void setWidgetButtonMode(ButtonsModeEnum newValue) {
		widget.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterWidget(ViewerFilter filter)
	 * 
	 */
	public void addFilterToWidget(ViewerFilter filter) {
		widget.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterWidget(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToWidget(ViewerFilter filter) {
		widget.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initDataBindings(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initDataBindings(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		dataBindings.setContentProvider(contentProvider);
		dataBindings.setInput(settings);
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.dataBindings);
		if (readOnly && dataBindings.isEnabled()) {
			dataBindings.setEnabled(false);
			dataBindings.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !dataBindings.isEnabled()) {
			dataBindings.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#updateDataBindings()
	 * 
	 */
	public void updateDataBindings() {
	dataBindings.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterDataBindings(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDataBindings(ViewerFilter filter) {
		dataBindingsFilters.add(filter);
		if (this.dataBindings != null) {
			this.dataBindings.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterDataBindings(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDataBindings(ViewerFilter filter) {
		dataBindingsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#isContainedInDataBindingsTable(EObject element)
	 * 
	 */
	public boolean isContainedInDataBindingsTable(EObject element) {
		return ((ReferencesTableSettings)dataBindings.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initActions(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initActions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		actions.setContentProvider(contentProvider);
		actions.setInput(settings);
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.actions);
		if (readOnly && actions.isEnabled()) {
			actions.setEnabled(false);
			actions.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !actions.isEnabled()) {
			actions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#updateActions()
	 * 
	 */
	public void updateActions() {
	actions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterActions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToActions(ViewerFilter filter) {
		actionsFilters.add(filter);
		if (this.actions != null) {
			this.actions.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterActions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToActions(ViewerFilter filter) {
		actionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#isContainedInActionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInActionsTable(EObject element) {
		return ((ReferencesTableSettings)actions.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initEvents(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEvents(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		events.setContentProvider(contentProvider);
		events.setInput(settings);
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.events);
		if (readOnly && events.isEnabled()) {
			events.setEnabled(false);
			events.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !events.isEnabled()) {
			events.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#updateEvents()
	 * 
	 */
	public void updateEvents() {
	events.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterEvents(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEvents(ViewerFilter filter) {
		eventsFilters.add(filter);
		if (this.events != null) {
			this.events.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterEvents(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEvents(ViewerFilter filter) {
		eventsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#isContainedInEventsTable(EObject element)
	 * 
	 */
	public boolean isContainedInEventsTable(EObject element) {
		return ((ReferencesTableSettings)events.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#initOwnedElements(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedElements(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ownedElements.setContentProvider(contentProvider);
		ownedElements.setInput(settings);
		boolean readOnly = isReadOnly(ViewViewsRepository.ViewContainer.Properties.ownedElements);
		if (readOnly && ownedElements.isEnabled()) {
			ownedElements.setEnabled(false);
			ownedElements.setToolTipText(ViewMessages.ViewContainer_ReadOnly);
		} else if (!readOnly && !ownedElements.isEnabled()) {
			ownedElements.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#updateOwnedElements()
	 * 
	 */
	public void updateOwnedElements() {
	ownedElements.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addFilterOwnedElements(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOwnedElements(ViewerFilter filter) {
		ownedElementsFilters.add(filter);
		if (this.ownedElements != null) {
			this.ownedElements.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#addBusinessFilterOwnedElements(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOwnedElements(ViewerFilter filter) {
		ownedElementsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.view.parts.ViewContainerPropertiesEditionPart#isContainedInOwnedElementsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOwnedElementsTable(EObject element) {
		return ((ReferencesTableSettings)ownedElements.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ViewMessages.ViewContainer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
