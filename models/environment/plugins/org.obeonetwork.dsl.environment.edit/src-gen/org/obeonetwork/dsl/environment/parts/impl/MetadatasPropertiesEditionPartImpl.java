/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.MetadatasPropertiesEditionPart;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class MetadatasPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, MetadatasPropertiesEditionPart {

	protected TableViewer metadata;
	protected List<ViewerFilter> metadataBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> metadataFilters = new ArrayList<ViewerFilter>();
	protected Button addMetadata;
	protected Button removeMetadata;
	protected Button editMetadata;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MetadatasPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence metadatasStep = new BindingCompositionSequence(propertiesEditionComponent);
		metadatasStep
			.addStep(EnvironmentViewsRepository.Metadatas.Properties.class)
			.addStep(EnvironmentViewsRepository.Metadatas.Properties.metadata);
		
		
		composer = new PartComposer(metadatasStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.Metadatas.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EnvironmentViewsRepository.Metadatas.Properties.metadata) {
					return createMetadataTableComposition(parent);
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
		propertiesGroup.setText(EnvironmentMessages.MetadatasPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createMetadataTableComposition(Composite container) {
		Composite tableContainer = new Composite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableMetadata = new org.eclipse.swt.widgets.Table(tableContainer, SWT.FULL_SELECTION);
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, selection.getFirstElement()));
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
		createMetadataPanel(tableContainer);
		return container;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createMetadataPanel(Composite container) {
		Composite metadataPanel = new Composite(container, SWT.NONE);
		GridLayout metadataPanelLayout = new GridLayout();
		metadataPanelLayout.numColumns = 1;
		metadataPanel.setLayout(metadataPanelLayout);
		addMetadata = new Button(metadataPanel, SWT.NONE);
		addMetadata.setText(EnvironmentMessages.PropertiesEditionPart_AddTableViewerLabel);
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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				metadata.refresh();
			}
		});
		EditingUtils.setID(addMetadata, EnvironmentViewsRepository.Metadatas.Properties.metadata);
		EditingUtils.setEEFtype(addMetadata, "eef::TableComposition::addbutton"); //$NON-NLS-1$
		removeMetadata = new Button(metadataPanel, SWT.NONE);
		removeMetadata.setText(EnvironmentMessages.PropertiesEditionPart_RemoveTableViewerLabel);
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, selectedElement));
						metadata.refresh();
					}
				}
			}

		});
		EditingUtils.setID(removeMetadata, EnvironmentViewsRepository.Metadatas.Properties.metadata);
		EditingUtils.setEEFtype(removeMetadata, "eef::TableComposition::removebutton"); //$NON-NLS-1$
		editMetadata = new Button(metadataPanel, SWT.NONE);
		editMetadata.setText(EnvironmentMessages.PropertiesEditionPart_EditTableViewerLabel);
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MetadatasPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Metadatas.Properties.metadata, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, selection.getFirstElement()));
						metadata.refresh();
					}
				}
			}

		});
		EditingUtils.setID(editMetadata, EnvironmentViewsRepository.Metadatas.Properties.metadata);
		EditingUtils.setEEFtype(editMetadata, "eef::TableComposition::editbutton"); //$NON-NLS-1$
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
		boolean readOnly = isReadOnly(EnvironmentViewsRepository.Metadatas.Properties.metadata);
		if (readOnly && metadata.getTable().isEnabled()) {
			metadata.getTable().setEnabled(false);
			metadata.getTable().setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
			addMetadata.setEnabled(false);
			addMetadata.setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
			removeMetadata.setEnabled(false);
			removeMetadata.setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
			editMetadata.setEnabled(false);
			editMetadata.setToolTipText(EnvironmentMessages.Metadatas_ReadOnly);
		} else if (!readOnly && !metadata.getTable().isEnabled()) {
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
