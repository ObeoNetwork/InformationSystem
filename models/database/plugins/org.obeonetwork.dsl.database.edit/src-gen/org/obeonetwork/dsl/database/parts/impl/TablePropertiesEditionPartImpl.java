/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts.impl;

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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart;
import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class TablePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TablePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable columns;
	protected List<ViewerFilter> columnsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> columnsFilters = new ArrayList<ViewerFilter>();
	protected Text comments;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TablePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence tableStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = tableStep.addStep(DatabaseViewsRepository.Table.Properties.class);
		propertiesStep.addStep(DatabaseViewsRepository.Table.Properties.name);
		propertiesStep.addStep(DatabaseViewsRepository.Table.Properties.columns);
		propertiesStep.addStep(DatabaseViewsRepository.Table.Properties.comments);
		
		
		composer = new PartComposer(tableStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.Table.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == DatabaseViewsRepository.Table.Properties.name) {
					return createNameText(parent);
				}
				if (key == DatabaseViewsRepository.Table.Properties.columns) {
					return createColumnsAdvancedTableComposition(parent);
				}
				if (key == DatabaseViewsRepository.Table.Properties.comments) {
					return createCommentsTextarea(parent);
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
		propertiesGroup.setText(DatabaseMessages.TablePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Table.Properties.name, DatabaseMessages.TablePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, DatabaseViewsRepository.Table.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Table.Properties.name, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createColumnsAdvancedTableComposition(Composite parent) {
		this.columns = new ReferencesTable(getDescription(DatabaseViewsRepository.Table.Properties.columns, DatabaseMessages.TablePropertiesEditionPart_ColumnsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				columns.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				columns.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				columns.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				columns.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.columnsFilters) {
			this.columns.addFilter(filter);
		}
		this.columns.setHelpText(propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Table.Properties.columns, DatabaseViewsRepository.SWT_KIND));
		this.columns.createControls(parent);
		this.columns.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.columns, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData columnsData = new GridData(GridData.FILL_HORIZONTAL);
		columnsData.horizontalSpan = 3;
		this.columns.setLayoutData(columnsData);
		this.columns.setLowerBound(0);
		this.columns.setUpperBound(-1);
		columns.setID(DatabaseViewsRepository.Table.Properties.columns);
		columns.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createColumnsAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createCommentsTextarea(Composite parent) {
		Label commentsLabel = createDescription(parent, DatabaseViewsRepository.Table.Properties.comments, DatabaseMessages.TablePropertiesEditionPart_CommentsLabel);
		GridData commentsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		commentsLabelData.horizontalSpan = 3;
		commentsLabel.setLayoutData(commentsLabelData);
		comments = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData commentsData = new GridData(GridData.FILL_HORIZONTAL);
		commentsData.horizontalSpan = 2;
		commentsData.heightHint = 80;
		commentsData.widthHint = 200;
		comments.setLayoutData(commentsData);
		comments.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TablePropertiesEditionPartImpl.this, DatabaseViewsRepository.Table.Properties.comments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
			}

		});
		EditingUtils.setID(comments, DatabaseViewsRepository.Table.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Table.Properties.comments, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCommentsTextArea

		// End of user code
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
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Table.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(DatabaseMessages.Table_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#initColumns(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initColumns(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		columns.setContentProvider(contentProvider);
		columns.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Table.Properties.columns);
		if (eefElementEditorReadOnlyState && columns.isEnabled()) {
			columns.setEnabled(false);
			columns.setToolTipText(DatabaseMessages.Table_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !columns.isEnabled()) {
			columns.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#updateColumns()
	 * 
	 */
	public void updateColumns() {
	columns.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#addFilterColumns(ViewerFilter filter)
	 * 
	 */
	public void addFilterToColumns(ViewerFilter filter) {
		columnsFilters.add(filter);
		if (this.columns != null) {
			this.columns.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#addBusinessFilterColumns(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToColumns(ViewerFilter filter) {
		columnsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#isContainedInColumnsTable(EObject element)
	 * 
	 */
	public boolean isContainedInColumnsTable(EObject element) {
		return ((ReferencesTableSettings)columns.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.TablePropertiesEditionPart#setComments(String newValue)
	 * 
	 */
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Table.Properties.comments);
		if (eefElementEditorReadOnlyState && comments.isEnabled()) {
			comments.setEnabled(false);
			comments.setBackground(comments.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			comments.setToolTipText(DatabaseMessages.Table_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !comments.isEnabled()) {
			comments.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return DatabaseMessages.Table_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
