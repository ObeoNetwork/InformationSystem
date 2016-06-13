/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts.forms;

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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart;
import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class ViewPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ViewPropertiesEditionPart {

	protected Text name;
	protected Text query;
	protected Text comments;
	protected ReferencesTable columns;
	protected List<ViewerFilter> columnsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> columnsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable tables;
	protected List<ViewerFilter> tablesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> tablesFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public ViewPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ViewPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence viewStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = viewStep.addStep(DatabaseViewsRepository.View.Properties.class);
		propertiesStep.addStep(DatabaseViewsRepository.View.Properties.name);
		propertiesStep.addStep(DatabaseViewsRepository.View.Properties.query);
		propertiesStep.addStep(DatabaseViewsRepository.View.Properties.comments);
		propertiesStep.addStep(DatabaseViewsRepository.View.Properties.columns);
		propertiesStep.addStep(DatabaseViewsRepository.View.Properties.tables);
		
		
		composer = new PartComposer(viewStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.View.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.View.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.View.Properties.query) {
					return createQueryTextarea(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.View.Properties.comments) {
					return createCommentsTextarea(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.View.Properties.columns) {
					return createColumnsTableComposition(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.View.Properties.tables) {
					return createTablesTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(DatabaseMessages.ViewPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, DatabaseViewsRepository.View.Properties.name, DatabaseMessages.ViewPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ViewPropertiesEditionPartForm.this,
							DatabaseViewsRepository.View.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewPropertiesEditionPartForm.this,
									DatabaseViewsRepository.View.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, DatabaseViewsRepository.View.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.View.Properties.name, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createQueryTextarea(FormToolkit widgetFactory, Composite parent) {
		Label queryLabel = createDescription(parent, DatabaseViewsRepository.View.Properties.query, DatabaseMessages.ViewPropertiesEditionPart_QueryLabel);
		GridData queryLabelData = new GridData(GridData.FILL_HORIZONTAL);
		queryLabelData.horizontalSpan = 3;
		queryLabel.setLayoutData(queryLabelData);
		query = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
		GridData queryData = new GridData(GridData.FILL_HORIZONTAL);
		queryData.horizontalSpan = 2;
		queryData.heightHint = 80;
		queryData.widthHint = 200;
		query.setLayoutData(queryData);
		query.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ViewPropertiesEditionPartForm.this,
							DatabaseViewsRepository.View.Properties.query,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, query.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewPropertiesEditionPartForm.this,
									DatabaseViewsRepository.View.Properties.query,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, query.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(query, DatabaseViewsRepository.View.Properties.query);
		EditingUtils.setEEFtype(query, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.View.Properties.query, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createQueryTextArea

		// End of user code
		return parent;
	}

	
	protected Composite createCommentsTextarea(FormToolkit widgetFactory, Composite parent) {
		Label commentsLabel = createDescription(parent, DatabaseViewsRepository.View.Properties.comments, DatabaseMessages.ViewPropertiesEditionPart_CommentsLabel);
		GridData commentsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		commentsLabelData.horizontalSpan = 3;
		commentsLabel.setLayoutData(commentsLabelData);
		comments = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
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
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ViewPropertiesEditionPartForm.this,
							DatabaseViewsRepository.View.Properties.comments,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewPropertiesEditionPartForm.this,
									DatabaseViewsRepository.View.Properties.comments,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, comments.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ViewPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(comments, DatabaseViewsRepository.View.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.View.Properties.comments, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCommentsTextArea

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createColumnsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.columns = new ReferencesTable(getDescription(DatabaseViewsRepository.View.Properties.columns, DatabaseMessages.ViewPropertiesEditionPart_ColumnsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				columns.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				columns.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				columns.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				columns.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.columnsFilters) {
			this.columns.addFilter(filter);
		}
		this.columns.setHelpText(propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.View.Properties.columns, DatabaseViewsRepository.FORM_KIND));
		this.columns.createControls(parent, widgetFactory);
		this.columns.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.columns, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData columnsData = new GridData(GridData.FILL_HORIZONTAL);
		columnsData.horizontalSpan = 3;
		this.columns.setLayoutData(columnsData);
		this.columns.setLowerBound(0);
		this.columns.setUpperBound(-1);
		columns.setID(DatabaseViewsRepository.View.Properties.columns);
		columns.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createColumnsTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTablesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.tables = new ReferencesTable(getDescription(DatabaseViewsRepository.View.Properties.tables, DatabaseMessages.ViewPropertiesEditionPart_TablesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.tables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				tables.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.tables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				tables.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.tables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				tables.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.tables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				tables.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.tablesFilters) {
			this.tables.addFilter(filter);
		}
		this.tables.setHelpText(propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.View.Properties.tables, DatabaseViewsRepository.FORM_KIND));
		this.tables.createControls(parent, widgetFactory);
		this.tables.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewPropertiesEditionPartForm.this, DatabaseViewsRepository.View.Properties.tables, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData tablesData = new GridData(GridData.FILL_HORIZONTAL);
		tablesData.horizontalSpan = 3;
		this.tables.setLayoutData(tablesData);
		this.tables.setLowerBound(0);
		this.tables.setUpperBound(-1);
		tables.setID(DatabaseViewsRepository.View.Properties.tables);
		tables.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTablesTableComposition

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
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.View.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(DatabaseMessages.View_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#getQuery()
	 * 
	 */
	public String getQuery() {
		return query.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#setQuery(String newValue)
	 * 
	 */
	public void setQuery(String newValue) {
		if (newValue != null) {
			query.setText(newValue);
		} else {
			query.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.View.Properties.query);
		if (eefElementEditorReadOnlyState && query.isEnabled()) {
			query.setEnabled(false);
			query.setBackground(query.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			query.setToolTipText(DatabaseMessages.View_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !query.isEnabled()) {
			query.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#setComments(String newValue)
	 * 
	 */
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.View.Properties.comments);
		if (eefElementEditorReadOnlyState && comments.isEnabled()) {
			comments.setEnabled(false);
			comments.setBackground(comments.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			comments.setToolTipText(DatabaseMessages.View_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !comments.isEnabled()) {
			comments.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#initColumns(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initColumns(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		columns.setContentProvider(contentProvider);
		columns.setInput(settings);
		columns.setEnabled(false);
		columns.setToolTipText(DatabaseMessages.View_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#updateColumns()
	 * 
	 */
	public void updateColumns() {
	columns.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#addFilterColumns(ViewerFilter filter)
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
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#addBusinessFilterColumns(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToColumns(ViewerFilter filter) {
		columnsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#isContainedInColumnsTable(EObject element)
	 * 
	 */
	public boolean isContainedInColumnsTable(EObject element) {
		return ((ReferencesTableSettings)columns.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#initTables(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTables(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		tables.setContentProvider(contentProvider);
		tables.setInput(settings);
		tables.setEnabled(false);
		tables.setToolTipText(DatabaseMessages.View_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#updateTables()
	 * 
	 */
	public void updateTables() {
	tables.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#addFilterTables(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTables(ViewerFilter filter) {
		tablesFilters.add(filter);
		if (this.tables != null) {
			this.tables.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#addBusinessFilterTables(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTables(ViewerFilter filter) {
		tablesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart#isContainedInTablesTable(EObject element)
	 * 
	 */
	public boolean isContainedInTablesTable(EObject element) {
		return ((ReferencesTableSettings)tables.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return DatabaseMessages.View_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
