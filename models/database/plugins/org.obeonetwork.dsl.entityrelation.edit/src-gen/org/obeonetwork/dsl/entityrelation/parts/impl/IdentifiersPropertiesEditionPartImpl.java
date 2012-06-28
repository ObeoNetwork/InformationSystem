/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart;

import org.obeonetwork.dsl.entityrelation.providers.EntityrelationMessages;

// End of user code

/**
 * 
 * 
 */
public class IdentifiersPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, IdentifiersPropertiesEditionPart {

	protected ReferencesTable identifiers;
	protected List<ViewerFilter> identifiersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> identifiersFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public IdentifiersPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence identifiersStep = new BindingCompositionSequence(propertiesEditionComponent);
		identifiersStep
			.addStep(EntityrelationViewsRepository.Identifiers.Properties.class)
			.addStep(EntityrelationViewsRepository.Identifiers.Properties.identifiers_);
		
		
		composer = new PartComposer(identifiersStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityrelationViewsRepository.Identifiers.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EntityrelationViewsRepository.Identifiers.Properties.identifiers_) {
					return createIdentifiersAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EntityrelationMessages.IdentifiersPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createIdentifiersAdvancedTableComposition(Composite parent) {
		this.identifiers = new ReferencesTable(getDescription(EntityrelationViewsRepository.Identifiers.Properties.identifiers_, EntityrelationMessages.IdentifiersPropertiesEditionPart_IdentifiersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartImpl.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				identifiers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartImpl.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				identifiers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartImpl.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				identifiers.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartImpl.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				identifiers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.identifiersFilters) {
			this.identifiers.addFilter(filter);
		}
		this.identifiers.setHelpText(propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Identifiers.Properties.identifiers_, EntityrelationViewsRepository.SWT_KIND));
		this.identifiers.createControls(parent);
		this.identifiers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IdentifiersPropertiesEditionPartImpl.this, EntityrelationViewsRepository.Identifiers.Properties.identifiers_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
