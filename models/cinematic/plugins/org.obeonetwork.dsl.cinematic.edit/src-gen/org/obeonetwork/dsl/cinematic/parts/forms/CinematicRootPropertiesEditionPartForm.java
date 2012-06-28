/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.parts.forms;

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

import org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;

import org.obeonetwork.dsl.cinematic.providers.CinematicMessages;

// End of user code

/**
 * 
 * 
 */
public class CinematicRootPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CinematicRootPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable toolkits;
	protected List<ViewerFilter> toolkitsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> toolkitsFilters = new ArrayList<ViewerFilter>();
	protected Text description;
	protected ReferencesTable subPackages;
	protected List<ViewerFilter> subPackagesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> subPackagesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable flows;
	protected List<ViewerFilter> flowsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> flowsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable viewContainers;
	protected List<ViewerFilter> viewContainersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> viewContainersFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public CinematicRootPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CinematicRootPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cinematicRootStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cinematicRootStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.class);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.name);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.toolkits);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.description);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.subPackages);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.flows);
		propertiesStep.addStep(CinematicViewsRepository.CinematicRoot.Properties.viewContainers);
		
		
		composer = new PartComposer(cinematicRootStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == CinematicViewsRepository.CinematicRoot.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.toolkits) {
					return createToolkitsReferencesTable(widgetFactory, parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.subPackages) {
					return createSubPackagesTableComposition(widgetFactory, parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.flows) {
					return createFlowsTableComposition(widgetFactory, parent);
				}
				if (key == CinematicViewsRepository.CinematicRoot.Properties.viewContainers) {
					return createViewContainersTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(CinematicMessages.CinematicRootPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, CinematicViewsRepository.CinematicRoot.Properties.name, CinematicMessages.CinematicRootPropertiesEditionPart_NameLabel);
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
							CinematicRootPropertiesEditionPartForm.this,
							CinematicViewsRepository.CinematicRoot.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CinematicRootPropertiesEditionPartForm.this,
									CinematicViewsRepository.CinematicRoot.Properties.name,
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
									CinematicRootPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, CinematicViewsRepository.CinematicRoot.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.name, CinematicViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createToolkitsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.toolkits = new ReferencesTable(getDescription(CinematicViewsRepository.CinematicRoot.Properties.toolkits, CinematicMessages.CinematicRootPropertiesEditionPart_ToolkitsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addToolkits(); }
			public void handleEdit(EObject element) { editToolkits(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveToolkits(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromToolkits(element); }
			public void navigateTo(EObject element) { }
		});
		this.toolkits.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.toolkits, CinematicViewsRepository.FORM_KIND));
		this.toolkits.createControls(parent, widgetFactory);
		this.toolkits.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.toolkits, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData toolkitsData = new GridData(GridData.FILL_HORIZONTAL);
		toolkitsData.horizontalSpan = 3;
		this.toolkits.setLayoutData(toolkitsData);
		this.toolkits.disableMove();
		toolkits.setID(CinematicViewsRepository.CinematicRoot.Properties.toolkits);
		toolkits.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addToolkits() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(toolkits.getInput(), toolkitsFilters, toolkitsBusinessFilters,
		"toolkits", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.toolkits,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				toolkits.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveToolkits(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.toolkits, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		toolkits.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromToolkits(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.toolkits, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		toolkits.refresh();
	}

	/**
	 * 
	 */
	protected void editToolkits(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				toolkits.refresh();
			}
		}
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CinematicViewsRepository.CinematicRoot.Properties.description, CinematicMessages.CinematicRootPropertiesEditionPart_DescriptionLabel);
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
							CinematicRootPropertiesEditionPartForm.this,
							CinematicViewsRepository.CinematicRoot.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CinematicRootPropertiesEditionPartForm.this,
									CinematicViewsRepository.CinematicRoot.Properties.description,
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
									CinematicRootPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, CinematicViewsRepository.CinematicRoot.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.description, CinematicViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSubPackagesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.subPackages = new ReferencesTable(getDescription(CinematicViewsRepository.CinematicRoot.Properties.subPackages, CinematicMessages.CinematicRootPropertiesEditionPart_SubPackagesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				subPackages.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				subPackages.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				subPackages.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				subPackages.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.subPackagesFilters) {
			this.subPackages.addFilter(filter);
		}
		this.subPackages.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.subPackages, CinematicViewsRepository.FORM_KIND));
		this.subPackages.createControls(parent, widgetFactory);
		this.subPackages.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.subPackages, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData subPackagesData = new GridData(GridData.FILL_HORIZONTAL);
		subPackagesData.horizontalSpan = 3;
		this.subPackages.setLayoutData(subPackagesData);
		this.subPackages.setLowerBound(0);
		this.subPackages.setUpperBound(-1);
		subPackages.setID(CinematicViewsRepository.CinematicRoot.Properties.subPackages);
		subPackages.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createFlowsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.flows = new ReferencesTable(getDescription(CinematicViewsRepository.CinematicRoot.Properties.flows, CinematicMessages.CinematicRootPropertiesEditionPart_FlowsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				flows.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				flows.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				flows.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				flows.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.flowsFilters) {
			this.flows.addFilter(filter);
		}
		this.flows.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.flows, CinematicViewsRepository.FORM_KIND));
		this.flows.createControls(parent, widgetFactory);
		this.flows.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.flows, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData flowsData = new GridData(GridData.FILL_HORIZONTAL);
		flowsData.horizontalSpan = 3;
		this.flows.setLayoutData(flowsData);
		this.flows.setLowerBound(0);
		this.flows.setUpperBound(-1);
		flows.setID(CinematicViewsRepository.CinematicRoot.Properties.flows);
		flows.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createViewContainersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.viewContainers = new ReferencesTable(getDescription(CinematicViewsRepository.CinematicRoot.Properties.viewContainers, CinematicMessages.CinematicRootPropertiesEditionPart_ViewContainersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				viewContainers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				viewContainers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				viewContainers.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				viewContainers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.viewContainersFilters) {
			this.viewContainers.addFilter(filter);
		}
		this.viewContainers.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.CinematicRoot.Properties.viewContainers, CinematicViewsRepository.FORM_KIND));
		this.viewContainers.createControls(parent, widgetFactory);
		this.viewContainers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CinematicRootPropertiesEditionPartForm.this, CinematicViewsRepository.CinematicRoot.Properties.viewContainers, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData viewContainersData = new GridData(GridData.FILL_HORIZONTAL);
		viewContainersData.horizontalSpan = 3;
		this.viewContainers.setLayoutData(viewContainersData);
		this.viewContainers.setLowerBound(0);
		this.viewContainers.setUpperBound(-1);
		viewContainers.setID(CinematicViewsRepository.CinematicRoot.Properties.viewContainers);
		viewContainers.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#initToolkits(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initToolkits(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		toolkits.setContentProvider(contentProvider);
		toolkits.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#updateToolkits()
	 * 
	 */
	public void updateToolkits() {
	toolkits.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addFilterToolkits(ViewerFilter filter)
	 * 
	 */
	public void addFilterToToolkits(ViewerFilter filter) {
		toolkitsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addBusinessFilterToolkits(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToToolkits(ViewerFilter filter) {
		toolkitsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#isContainedInToolkitsTable(EObject element)
	 * 
	 */
	public boolean isContainedInToolkitsTable(EObject element) {
		return ((ReferencesTableSettings)toolkits.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#initSubPackages(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubPackages(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		subPackages.setContentProvider(contentProvider);
		subPackages.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#updateSubPackages()
	 * 
	 */
	public void updateSubPackages() {
	subPackages.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addFilterSubPackages(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSubPackages(ViewerFilter filter) {
		subPackagesFilters.add(filter);
		if (this.subPackages != null) {
			this.subPackages.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addBusinessFilterSubPackages(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSubPackages(ViewerFilter filter) {
		subPackagesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#isContainedInSubPackagesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSubPackagesTable(EObject element) {
		return ((ReferencesTableSettings)subPackages.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#initFlows(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initFlows(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		flows.setContentProvider(contentProvider);
		flows.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#updateFlows()
	 * 
	 */
	public void updateFlows() {
	flows.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addFilterFlows(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFlows(ViewerFilter filter) {
		flowsFilters.add(filter);
		if (this.flows != null) {
			this.flows.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addBusinessFilterFlows(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFlows(ViewerFilter filter) {
		flowsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#isContainedInFlowsTable(EObject element)
	 * 
	 */
	public boolean isContainedInFlowsTable(EObject element) {
		return ((ReferencesTableSettings)flows.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#initViewContainers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initViewContainers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		viewContainers.setContentProvider(contentProvider);
		viewContainers.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#updateViewContainers()
	 * 
	 */
	public void updateViewContainers() {
	viewContainers.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addFilterViewContainers(ViewerFilter filter)
	 * 
	 */
	public void addFilterToViewContainers(ViewerFilter filter) {
		viewContainersFilters.add(filter);
		if (this.viewContainers != null) {
			this.viewContainers.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#addBusinessFilterViewContainers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToViewContainers(ViewerFilter filter) {
		viewContainersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart#isContainedInViewContainersTable(EObject element)
	 * 
	 */
	public boolean isContainedInViewContainersTable(EObject element) {
		return ((ReferencesTableSettings)viewContainers.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return CinematicMessages.CinematicRoot_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
