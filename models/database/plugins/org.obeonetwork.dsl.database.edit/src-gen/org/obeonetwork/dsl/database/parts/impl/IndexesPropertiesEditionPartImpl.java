/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts.impl;

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

import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.IndexesPropertiesEditionPart;

import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class IndexesPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, IndexesPropertiesEditionPart {

	protected ReferencesTable indexes;
	protected List<ViewerFilter> indexesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> indexesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public IndexesPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence indexesStep = new BindingCompositionSequence(propertiesEditionComponent);
		indexesStep
			.addStep(DatabaseViewsRepository.Indexes.Properties.class)
			.addStep(DatabaseViewsRepository.Indexes.Properties.indexes_);
		
		
		composer = new PartComposer(indexesStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.Indexes.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == DatabaseViewsRepository.Indexes.Properties.indexes_) {
					return createIndexesAdvancedTableComposition(parent);
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
		propertiesGroup.setText(DatabaseMessages.IndexesPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createIndexesAdvancedTableComposition(Composite parent) {
		this.indexes = new ReferencesTable(getDescription(DatabaseViewsRepository.Indexes.Properties.indexes_, DatabaseMessages.IndexesPropertiesEditionPart_IndexesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IndexesPropertiesEditionPartImpl.this, DatabaseViewsRepository.Indexes.Properties.indexes_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				indexes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IndexesPropertiesEditionPartImpl.this, DatabaseViewsRepository.Indexes.Properties.indexes_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				indexes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IndexesPropertiesEditionPartImpl.this, DatabaseViewsRepository.Indexes.Properties.indexes_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				indexes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IndexesPropertiesEditionPartImpl.this, DatabaseViewsRepository.Indexes.Properties.indexes_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				indexes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.indexesFilters) {
			this.indexes.addFilter(filter);
		}
		this.indexes.setHelpText(propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Indexes.Properties.indexes_, DatabaseViewsRepository.SWT_KIND));
		this.indexes.createControls(parent);
		this.indexes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IndexesPropertiesEditionPartImpl.this, DatabaseViewsRepository.Indexes.Properties.indexes_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData indexesData = new GridData(GridData.FILL_HORIZONTAL);
		indexesData.horizontalSpan = 3;
		this.indexes.setLayoutData(indexesData);
		this.indexes.setLowerBound(0);
		this.indexes.setUpperBound(-1);
		indexes.setID(DatabaseViewsRepository.Indexes.Properties.indexes_);
		indexes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.database.parts.IndexesPropertiesEditionPart#initIndexes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initIndexes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		indexes.setContentProvider(contentProvider);
		indexes.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.IndexesPropertiesEditionPart#updateIndexes()
	 * 
	 */
	public void updateIndexes() {
	indexes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.IndexesPropertiesEditionPart#addFilterIndexes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIndexes(ViewerFilter filter) {
		indexesFilters.add(filter);
		if (this.indexes != null) {
			this.indexes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.IndexesPropertiesEditionPart#addBusinessFilterIndexes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIndexes(ViewerFilter filter) {
		indexesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.IndexesPropertiesEditionPart#isContainedInIndexesTable(EObject element)
	 * 
	 */
	public boolean isContainedInIndexesTable(EObject element) {
		return ((ReferencesTableSettings)indexes.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return DatabaseMessages.Indexes_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
