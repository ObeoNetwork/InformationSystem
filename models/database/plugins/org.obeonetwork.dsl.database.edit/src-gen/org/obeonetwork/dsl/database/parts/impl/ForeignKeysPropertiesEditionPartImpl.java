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
import org.obeonetwork.dsl.database.parts.ForeignKeysPropertiesEditionPart;

import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class ForeignKeysPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ForeignKeysPropertiesEditionPart {

	protected ReferencesTable foreignKeys;
	protected List<ViewerFilter> foreignKeysBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> foreignKeysFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ForeignKeysPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence foreignKeysStep = new BindingCompositionSequence(propertiesEditionComponent);
		foreignKeysStep
			.addStep(DatabaseViewsRepository.ForeignKeys.Properties.class)
			.addStep(DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_);
		
		
		composer = new PartComposer(foreignKeysStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.ForeignKeys.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_) {
					return createForeignKeysAdvancedTableComposition(parent);
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
		propertiesGroup.setText(DatabaseMessages.ForeignKeysPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createForeignKeysAdvancedTableComposition(Composite parent) {
		this.foreignKeys = new ReferencesTable(getDescription(DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_, DatabaseMessages.ForeignKeysPropertiesEditionPart_ForeignKeysLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeysPropertiesEditionPartImpl.this, DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				foreignKeys.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeysPropertiesEditionPartImpl.this, DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				foreignKeys.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeysPropertiesEditionPartImpl.this, DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				foreignKeys.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeysPropertiesEditionPartImpl.this, DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				foreignKeys.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.foreignKeysFilters) {
			this.foreignKeys.addFilter(filter);
		}
		this.foreignKeys.setHelpText(propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_, DatabaseViewsRepository.SWT_KIND));
		this.foreignKeys.createControls(parent);
		this.foreignKeys.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeysPropertiesEditionPartImpl.this, DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData foreignKeysData = new GridData(GridData.FILL_HORIZONTAL);
		foreignKeysData.horizontalSpan = 3;
		this.foreignKeys.setLayoutData(foreignKeysData);
		this.foreignKeys.setLowerBound(0);
		this.foreignKeys.setUpperBound(-1);
		foreignKeys.setID(DatabaseViewsRepository.ForeignKeys.Properties.foreignKeys_);
		foreignKeys.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeysPropertiesEditionPart#initForeignKeys(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initForeignKeys(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		foreignKeys.setContentProvider(contentProvider);
		foreignKeys.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeysPropertiesEditionPart#updateForeignKeys()
	 * 
	 */
	public void updateForeignKeys() {
	foreignKeys.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeysPropertiesEditionPart#addFilterForeignKeys(ViewerFilter filter)
	 * 
	 */
	public void addFilterToForeignKeys(ViewerFilter filter) {
		foreignKeysFilters.add(filter);
		if (this.foreignKeys != null) {
			this.foreignKeys.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeysPropertiesEditionPart#addBusinessFilterForeignKeys(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToForeignKeys(ViewerFilter filter) {
		foreignKeysBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeysPropertiesEditionPart#isContainedInForeignKeysTable(EObject element)
	 * 
	 */
	public boolean isContainedInForeignKeysTable(EObject element) {
		return ((ReferencesTableSettings)foreignKeys.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return DatabaseMessages.ForeignKeys_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
