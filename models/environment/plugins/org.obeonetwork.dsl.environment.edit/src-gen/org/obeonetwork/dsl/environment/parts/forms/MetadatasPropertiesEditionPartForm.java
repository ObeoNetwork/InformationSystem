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
package org.obeonetwork.dsl.environment.parts.forms;

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
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class MetadatasPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, MetadatasPropertiesEditionPart {

	protected TableViewer metadata;
	protected List<ViewerFilter> metadataBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> metadataFilters = new ArrayList<ViewerFilter>();
	protected Button addMetadata;
	protected Button removeMetadata;
	protected Button editMetadata;



	/**
	 * For {@link ISection} use only.
	 */
	public MetadatasPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MetadatasPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence metadatasStep = new BindingCompositionSequence(propertiesEditionComponent);
		metadatasStep
			.addStep(EnvironmentViewsRepository.Metadatas.Properties.class)
			.addStep(EnvironmentViewsRepository.Metadatas.Properties.metadata);
		
		
		composer = new PartComposer(metadatasStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.Metadatas.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Metadatas.Properties.metadata) {
					return createMetadataTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(EnvironmentMessages.MetadatasPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createMetadataTableComposition(FormToolkit widgetFactory, Composite container) {
		Composite tableContainer = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableMetadata = widgetFactory.createTable(tableContainer, SWT.FULL_SELECTION | SWT.BORDER);
		tableMetadata.setHeaderVisible(true);
		GridData gdMetadata = new GridData();
		gdMetadata.grabExcessHorizontalSpace = true;
		gdMetadata.horizontalAlignment = GridData.FILL;
		gdMetadata.grabExcessVerticalSpace = true;
		gdMetadata.verticalAlignment = GridData.FILL;
		tableMetadata.setLayoutData(gdMetadata);
		tableMetadata.setLinesVisible(true);

		// Start of user code for columns definition for Metadata
		TableColumn title = new TableColumn(tableMetadata, SWT.NONE);
		title.setWidth(120);
		title.setText("title"); //$NON-NLS-1$
		TableColumn body = new TableColumn(tableMetadata, SWT.NONE);
		body.setWidth(300);
		body.setText("body"); //$NON-NLS-1$
		// End of user code

		metadata = new TableViewer(tableMetadata);
		metadata.setContentProvider(new ArrayContentProvider());
		metadata.setLabelProvider(new ITableLabelProvider() {
			//Start of user code for label provider definition for Metadata
						public String getColumnText(Object object, int columnIndex) {
							if (object instanceof Annotation) {
								Annotation annot = (Annotation)object;
								switch (columnIndex) {
								case 0:
									return annot.getTitle();
								case 1:
									return annot.getBody();
								}
							}
							return ""; //$NON-NLS-1$
						}
			
						public Image getColumnImage(Object element, int columnIndex) {
							return null;
						}
			
			//End of user code

			public void addListener(ILabelProviderListener listener) {
			}

			public void dispose() {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}

		});
		metadata.getTable().addListener(SWT.MouseDoubleClick, new Listener(){

			public void handleEvent(Event event) {
				if (metadata.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) metadata.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartForm.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, selection.getFirstElement()));
						metadata.refresh();
					}
				}
			}

		});
		GridData metadataData = new GridData(GridData.FILL_HORIZONTAL);
		metadataData.minimumHeight = 120;
		metadataData.heightHint = 120;
		metadata.getTable().setLayoutData(metadataData);
		for (ViewerFilter filter : this.metadataFilters) {
			metadata.addFilter(filter);
		}
		EditingUtils.setID(metadata.getTable(), EnvironmentViewsRepository.Metadatas.Properties.metadata);
		EditingUtils.setEEFtype(metadata.getTable(), "eef::TableComposition::field"); //$NON-NLS-1$
		createMetadataPanel(widgetFactory, tableContainer);
		// Start of user code for createMetadataTableComposition

		// End of user code
		return container;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createMetadataPanel(FormToolkit widgetFactory, Composite container) {
		Composite metadataPanel = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout metadataPanelLayout = new GridLayout();
		metadataPanelLayout.numColumns = 1;
		metadataPanel.setLayout(metadataPanelLayout);
		addMetadata = widgetFactory.createButton(metadataPanel, EnvironmentMessages.PropertiesEditionPart_AddTableViewerLabel, SWT.NONE);
		GridData addMetadataData = new GridData(GridData.FILL_HORIZONTAL);
		addMetadata.setLayoutData(addMetadataData);
		addMetadata.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartForm.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				metadata.refresh();
			}
		});
		EditingUtils.setID(addMetadata, EnvironmentViewsRepository.Metadatas.Properties.metadata);
		EditingUtils.setEEFtype(addMetadata, "eef::TableComposition::addbutton"); //$NON-NLS-1$
		removeMetadata = widgetFactory.createButton(metadataPanel, EnvironmentMessages.PropertiesEditionPart_RemoveTableViewerLabel, SWT.NONE);
		GridData removeMetadataData = new GridData(GridData.FILL_HORIZONTAL);
		removeMetadata.setLayoutData(removeMetadataData);
		removeMetadata.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				if (metadata.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) metadata.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						EObject selectedElement = (EObject) selection.getFirstElement();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartForm.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, selectedElement));
						metadata.refresh();
					}
				}
			}

		});
		EditingUtils.setID(removeMetadata, EnvironmentViewsRepository.Metadatas.Properties.metadata);
		EditingUtils.setEEFtype(removeMetadata, "eef::TableComposition::removebutton"); //$NON-NLS-1$
		editMetadata = widgetFactory.createButton(metadataPanel, EnvironmentMessages.PropertiesEditionPart_EditTableViewerLabel, SWT.NONE);
		GridData editMetadataData = new GridData(GridData.FILL_HORIZONTAL);
		editMetadata.setLayoutData(editMetadataData);
		editMetadata.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				if (metadata.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) metadata.getSelection();
					if (selection.getFirstElement() instanceof EObject) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartForm.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, selection.getFirstElement()));
						metadata.refresh();
					}
				}
			}

		});
		EditingUtils.setID(editMetadata, EnvironmentViewsRepository.Metadatas.Properties.metadata);
		EditingUtils.setEEFtype(editMetadata, "eef::TableComposition::editbutton"); //$NON-NLS-1$
		// Start of user code for createMetadataPanel

		// End of user code
		return metadataPanel;
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
	 * @see org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart#initMetadata(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initMetadata(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		metadata.setContentProvider(contentProvider);
		metadata.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Metadatas.Properties.metadata);
		if (eefElementEditorReadOnlyState && metadata.getTable().isEnabled()) {
			metadata.getTable().setEnabled(false);
			metadata.getTable().setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
			addMetadata.setEnabled(false);
			addMetadata.setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
			removeMetadata.setEnabled(false);
			removeMetadata.setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
			editMetadata.setEnabled(false);
			editMetadata.setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !metadata.getTable().isEnabled()) {
			metadata.getTable().setEnabled(true);
			addMetadata.setEnabled(true);
			removeMetadata.setEnabled(true);
			editMetadata.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart#updateMetadata()
	 * 
	 */
	public void updateMetadata() {
	metadata.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart#addFilterMetadata(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMetadata(ViewerFilter filter) {
		metadataFilters.add(filter);
		if (this.metadata != null) {
			this.metadata.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart#addBusinessFilterMetadata(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMetadata(ViewerFilter filter) {
		metadataBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart#isContainedInMetadataTable(EObject element)
	 * 
	 */
	public boolean isContainedInMetadataTable(EObject element) {
		return ((ReferencesTableSettings)metadata.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EnvironmentMessages.Metadatas_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
