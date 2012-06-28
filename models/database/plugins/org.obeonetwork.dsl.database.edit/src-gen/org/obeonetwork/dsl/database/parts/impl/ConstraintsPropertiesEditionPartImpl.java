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

import org.obeonetwork.dsl.database.parts.ConstraintsPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;

import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class ConstraintsPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConstraintsPropertiesEditionPart {

	protected ReferencesTable constraints;
	protected List<ViewerFilter> constraintsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> constraintsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConstraintsPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence constraintsStep = new BindingCompositionSequence(propertiesEditionComponent);
		constraintsStep
			.addStep(DatabaseViewsRepository.Constraints.Properties.class)
			.addStep(DatabaseViewsRepository.Constraints.Properties.constraints_);
		
		
		composer = new PartComposer(constraintsStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.Constraints.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == DatabaseViewsRepository.Constraints.Properties.constraints_) {
					return createConstraintsAdvancedTableComposition(parent);
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
		propertiesGroup.setText(DatabaseMessages.ConstraintsPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createConstraintsAdvancedTableComposition(Composite parent) {
		this.constraints = new ReferencesTable(getDescription(DatabaseViewsRepository.Constraints.Properties.constraints_, DatabaseMessages.ConstraintsPropertiesEditionPart_ConstraintsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConstraintsPropertiesEditionPartImpl.this, DatabaseViewsRepository.Constraints.Properties.constraints_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				constraints.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConstraintsPropertiesEditionPartImpl.this, DatabaseViewsRepository.Constraints.Properties.constraints_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				constraints.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConstraintsPropertiesEditionPartImpl.this, DatabaseViewsRepository.Constraints.Properties.constraints_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				constraints.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConstraintsPropertiesEditionPartImpl.this, DatabaseViewsRepository.Constraints.Properties.constraints_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				constraints.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.constraintsFilters) {
			this.constraints.addFilter(filter);
		}
		this.constraints.setHelpText(propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Constraints.Properties.constraints_, DatabaseViewsRepository.SWT_KIND));
		this.constraints.createControls(parent);
		this.constraints.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConstraintsPropertiesEditionPartImpl.this, DatabaseViewsRepository.Constraints.Properties.constraints_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData constraintsData = new GridData(GridData.FILL_HORIZONTAL);
		constraintsData.horizontalSpan = 3;
		this.constraints.setLayoutData(constraintsData);
		this.constraints.setLowerBound(0);
		this.constraints.setUpperBound(-1);
		constraints.setID(DatabaseViewsRepository.Constraints.Properties.constraints_);
		constraints.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.database.parts.ConstraintsPropertiesEditionPart#initConstraints(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initConstraints(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		constraints.setContentProvider(contentProvider);
		constraints.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ConstraintsPropertiesEditionPart#updateConstraints()
	 * 
	 */
	public void updateConstraints() {
	constraints.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ConstraintsPropertiesEditionPart#addFilterConstraints(ViewerFilter filter)
	 * 
	 */
	public void addFilterToConstraints(ViewerFilter filter) {
		constraintsFilters.add(filter);
		if (this.constraints != null) {
			this.constraints.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ConstraintsPropertiesEditionPart#addBusinessFilterConstraints(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToConstraints(ViewerFilter filter) {
		constraintsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ConstraintsPropertiesEditionPart#isContainedInConstraintsTable(EObject element)
	 * 
	 */
	public boolean isContainedInConstraintsTable(EObject element) {
		return ((ReferencesTableSettings)constraints.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return DatabaseMessages.Constraints_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
