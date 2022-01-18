/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart;

import org.obeonetwork.dsl.cinematic.providers.CinematicMessages;

// End of user code

/**
 * 
 * 
 */
public class ToolkitsPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ToolkitsPropertiesEditionPart {

	protected ReferencesTable toolkits;
	protected List<ViewerFilter> toolkitsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> toolkitsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ToolkitsPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence toolkitsStep = new BindingCompositionSequence(propertiesEditionComponent);
		toolkitsStep
			.addStep(CinematicViewsRepository.Toolkits.Properties.class)
			.addStep(CinematicViewsRepository.Toolkits.Properties.toolkits_);
		
		
		composer = new PartComposer(toolkitsStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == CinematicViewsRepository.Toolkits.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == CinematicViewsRepository.Toolkits.Properties.toolkits_) {
					return createToolkitsAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(CinematicMessages.ToolkitsPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * 
	 */
	protected Composite createToolkitsAdvancedReferencesTable(Composite parent) {
		String label = getDescription(CinematicViewsRepository.Toolkits.Properties.toolkits_, CinematicMessages.ToolkitsPropertiesEditionPart_ToolkitsLabel);		 
		this.toolkits = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addToolkits(); }
			public void handleEdit(EObject element) { editToolkits(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveToolkits(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromToolkits(element); }
			public void navigateTo(EObject element) { }
		});
		this.toolkits.setHelpText(propertiesEditionComponent.getHelpContent(CinematicViewsRepository.Toolkits.Properties.toolkits_, CinematicViewsRepository.SWT_KIND));
		this.toolkits.createControls(parent);
		this.toolkits.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartImpl.this, CinematicViewsRepository.Toolkits.Properties.toolkits_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData toolkitsData = new GridData(GridData.FILL_HORIZONTAL);
		toolkitsData.horizontalSpan = 3;
		this.toolkits.setLayoutData(toolkitsData);
		this.toolkits.disableMove();
		toolkits.setID(CinematicViewsRepository.Toolkits.Properties.toolkits_);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartImpl.this, CinematicViewsRepository.Toolkits.Properties.toolkits_,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartImpl.this, CinematicViewsRepository.Toolkits.Properties.toolkits_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		toolkits.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromToolkits(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ToolkitsPropertiesEditionPartImpl.this, CinematicViewsRepository.Toolkits.Properties.toolkits_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
