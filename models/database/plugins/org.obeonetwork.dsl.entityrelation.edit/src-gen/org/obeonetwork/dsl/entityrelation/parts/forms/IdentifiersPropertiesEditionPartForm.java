/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
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
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.providers.EntityrelationMessages;

// End of user code

/**
 * 
 * 
 */
public class IdentifiersPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, IdentifiersPropertiesEditionPart {

	protected ReferencesTable identifiers;
	protected List<ViewerFilter> identifiersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> identifiersFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public IdentifiersPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public IdentifiersPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence identifiersStep = new BindingCompositionSequence(propertiesEditionComponent);
		identifiersStep
			.addStep(EntityrelationViewsRepository.Identifiers.Properties.class)
			.addStep(EntityrelationViewsRepository.Identifiers.Properties.identifiers_);
		
		
		composer = new PartComposer(identifiersStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityrelationViewsRepository.Identifiers.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Identifiers.Properties.identifiers_) {
					return createIdentifiersTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(EntityrelationMessages.IdentifiersPropertiesEditionPart_PropertiesGroupLabel);
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
	 * @param container
	 * 
	 */
	protected Composite createIdentifiersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.identifiers = new ReferencesTable(getDescription(EntityrelationViewsRepository.Identifiers.Properties.identifiers_, EntityrelationMessages.IdentifiersPropertiesEditionPart_IdentifiersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartForm.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				identifiers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartForm.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				identifiers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartForm.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				identifiers.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartForm.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				identifiers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.identifiersFilters) {
			this.identifiers.addFilter(filter);
		}
		this.identifiers.setHelpText(propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Identifiers.Properties.identifiers_, EntityrelationViewsRepository.FORM_KIND));
		this.identifiers.createControls(parent, widgetFactory);
		this.identifiers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartForm.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData identifiersData = new GridData(GridData.FILL_HORIZONTAL);
		identifiersData.horizontalSpan = 3;
		this.identifiers.setLayoutData(identifiersData);
		this.identifiers.setLowerBound(0);
		this.identifiers.setUpperBound(-1);
		identifiers.setID(EntityrelationViewsRepository.Identifiers.Properties.identifiers_);
		identifiers.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart#initIdentifiers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initIdentifiers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		identifiers.setContentProvider(contentProvider);
		identifiers.setInput(settings);
		boolean readOnly = isReadOnly(EntityrelationViewsRepository.Identifiers.Properties.identifiers_);
		if (readOnly && identifiers.isEnabled()) {
			identifiers.setEnabled(false);
			identifiers.setToolTipText(EntityrelationMessages.Identifiers_ReadOnly);
		} else if (!readOnly && !identifiers.isEnabled()) {
			identifiers.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart#updateIdentifiers()
	 * 
	 */
	public void updateIdentifiers() {
	identifiers.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart#addFilterIdentifiers(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIdentifiers(ViewerFilter filter) {
		identifiersFilters.add(filter);
		if (this.identifiers != null) {
			this.identifiers.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart#addBusinessFilterIdentifiers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIdentifiers(ViewerFilter filter) {
		identifiersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart#isContainedInIdentifiersTable(EObject element)
	 * 
	 */
	public boolean isContainedInIdentifiersTable(EObject element) {
		return ((ReferencesTableSettings)identifiers.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EntityrelationMessages.Identifiers_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
