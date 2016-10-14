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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart;

import org.obeonetwork.dsl.cinematic.providers.CinematicMessages;

// End of user code

/**
 * 
 * 
 */
public class ToolkitsPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ToolkitsPropertiesEditionPart {

	protected ReferencesTable toolkits;
	protected List<ViewerFilter> toolkitsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> toolkitsFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public ToolkitsPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ToolkitsPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence toolkitsStep = new BindingCompositionSequence(propertiesEditionComponent);
		toolkitsStep
			.addStep(CinematicViewsRepository.Toolkits.Properties.class)
			.addStep(CinematicViewsRepository.Toolkits.Properties.toolkits_);
		
		
		composer = new PartComposer(toolkitsStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == CinematicViewsRepository.Toolkits.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == CinematicViewsRepository.Toolkits.Properties.toolkits_) {
					return createToolkitsReferencesTable(widgetFactory, parent);
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
		propertiesSection.setText(CinematicMessages.ToolkitsPropertiesEditionPart_PropertiesGroupLabel);
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

	/**
	 * 
	 */
	protected Composite createToolkitsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.toolkits = new ReferencesTable(getDescription(CinematicViewsRepository.Toolkits.Properties.toolkits_, CinematicMessages.ToolkitsPropertiesEditionPart_ToolkitsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addToolkits(); }
			public void handleEdit(EObject element) { editToolkits(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveToolkits(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromToolkits(element); }
			public void navigateTo(EObject element) { }
		});
		this.toolkits.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.Toolkits.Properties.toolkits_, CinematicViewsRepository.FORM_KIND));
		this.toolkits.createControls(parent, widgetFactory);
		this.toolkits.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartForm.this, CinematicViewsRepository.Toolkits.Properties.toolkits_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData toolkitsData = new GridData(GridData.FILL_HORIZONTAL);
		toolkitsData.horizontalSpan = 3;
		this.toolkits.setLayoutData(toolkitsData);
		this.toolkits.disableMove();
		toolkits.setID(CinematicViewsRepository.Toolkits.Properties.toolkits_);
		toolkits.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createToolkitsReferencesTable

		// End of user code
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartForm.this, CinematicViewsRepository.Toolkits.Properties.toolkits_,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartForm.this, CinematicViewsRepository.Toolkits.Properties.toolkits_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		toolkits.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromToolkits(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartForm.this, CinematicViewsRepository.Toolkits.Properties.toolkits_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
	 * @see org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart#initToolkits(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initToolkits(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		toolkits.setContentProvider(contentProvider);
		toolkits.setInput(settings);

		toolkitsBusinessFilters.clear();
		toolkitsFilters.clear();

		boolean eefElementEditorReadOnlyState = isReadOnly(CinematicViewsRepository.Toolkits.Properties.toolkits_);
		if (eefElementEditorReadOnlyState && toolkits.getTable().isEnabled()) {
			toolkits.setEnabled(false);
			toolkits.setToolTipText(CinematicMessages.Toolkits_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !toolkits.getTable().isEnabled()) {
			toolkits.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart#updateToolkits()
	 * 
	 */
	public void updateToolkits() {
	toolkits.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart#addFilterToolkits(ViewerFilter filter)
	 * 
	 */
	public void addFilterToToolkits(ViewerFilter filter) {
		toolkitsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart#addBusinessFilterToolkits(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToToolkits(ViewerFilter filter) {
		toolkitsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart#isContainedInToolkitsTable(EObject element)
	 * 
	 */
	public boolean isContainedInToolkitsTable(EObject element) {
		return ((ReferencesTableSettings)toolkits.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return CinematicMessages.Toolkits_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
