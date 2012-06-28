/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart;

import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class ForeignKeyElementPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ForeignKeyElementPropertiesEditionPart {

	protected Text sourceTable;
	protected EObjectFlatComboViewer fKColumn;
	protected Text targetTable;
	protected EObjectFlatComboViewer pKColumn;
	protected Text comments;



	/**
	 * For {@link ISection} use only.
	 */
	public ForeignKeyElementPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ForeignKeyElementPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence foreignKeyElementStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = foreignKeyElementStep.addStep(DatabaseViewsRepository.ForeignKeyElement.Properties.class);
		propertiesStep.addStep(DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable);
		propertiesStep.addStep(DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn);
		propertiesStep.addStep(DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable);
		propertiesStep.addStep(DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn);
		propertiesStep.addStep(DatabaseViewsRepository.ForeignKeyElement.Properties.comments);
		
		
		composer = new PartComposer(foreignKeyElementStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.ForeignKeyElement.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable) {
					return createSourceTableText(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn) {
					return createFKColumnFlatComboViewer(parent, widgetFactory);
				}
				if (key == DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable) {
					return createTargetTableText(widgetFactory, parent);
				}
				if (key == DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn) {
					return createPKColumnFlatComboViewer(parent, widgetFactory);
				}
				if (key == DatabaseViewsRepository.ForeignKeyElement.Properties.comments) {
					return createCommentsTextarea(widgetFactory, parent);
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
		propertiesSection.setText(DatabaseMessages.ForeignKeyElementPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createSourceTableText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable, DatabaseMessages.ForeignKeyElementPropertiesEditionPart_SourceTableLabel);
		sourceTable = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sourceTable.setEnabled(false);
		sourceTable.setToolTipText(DatabaseMessages.ForeignKeyElement_ReadOnly);
		sourceTable.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceTableData = new GridData(GridData.FILL_HORIZONTAL);
		sourceTable.setLayoutData(sourceTableData);
		sourceTable.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ForeignKeyElementPropertiesEditionPartForm.this,
							DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceTable.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForeignKeyElementPropertiesEditionPartForm.this,
									DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sourceTable.getText()));
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
									ForeignKeyElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sourceTable.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeyElementPropertiesEditionPartForm.this, DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceTable.getText()));
				}
			}
		});
		EditingUtils.setID(sourceTable, DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable);
		EditingUtils.setEEFtype(sourceTable, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createFKColumnFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn, DatabaseMessages.ForeignKeyElementPropertiesEditionPart_FKColumnLabel);
		fKColumn = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn, DatabaseViewsRepository.FORM_KIND));
		widgetFactory.adapt(fKColumn);
		fKColumn.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData fKColumnData = new GridData(GridData.FILL_HORIZONTAL);
		fKColumn.setLayoutData(fKColumnData);
		fKColumn.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeyElementPropertiesEditionPartForm.this, DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFKColumn()));
			}

		});
		fKColumn.setID(DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTargetTableText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable, DatabaseMessages.ForeignKeyElementPropertiesEditionPart_TargetTableLabel);
		targetTable = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetTable.setEnabled(false);
		targetTable.setToolTipText(DatabaseMessages.ForeignKeyElement_ReadOnly);
		targetTable.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetTableData = new GridData(GridData.FILL_HORIZONTAL);
		targetTable.setLayoutData(targetTableData);
		targetTable.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ForeignKeyElementPropertiesEditionPartForm.this,
							DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetTable.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForeignKeyElementPropertiesEditionPartForm.this,
									DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetTable.getText()));
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
									ForeignKeyElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetTable.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeyElementPropertiesEditionPartForm.this, DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetTable.getText()));
				}
			}
		});
		EditingUtils.setID(targetTable, DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable);
		EditingUtils.setEEFtype(targetTable, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createPKColumnFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn, DatabaseMessages.ForeignKeyElementPropertiesEditionPart_PKColumnLabel);
		pKColumn = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn, DatabaseViewsRepository.FORM_KIND));
		widgetFactory.adapt(pKColumn);
		pKColumn.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData pKColumnData = new GridData(GridData.FILL_HORIZONTAL);
		pKColumn.setLayoutData(pKColumnData);
		pKColumn.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForeignKeyElementPropertiesEditionPartForm.this, DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPKColumn()));
			}

		});
		pKColumn.setID(DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCommentsTextarea(FormToolkit widgetFactory, Composite parent) {
		Label commentsLabel = createDescription(parent, DatabaseViewsRepository.ForeignKeyElement.Properties.comments, DatabaseMessages.ForeignKeyElementPropertiesEditionPart_CommentsLabel);
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
							ForeignKeyElementPropertiesEditionPartForm.this,
							DatabaseViewsRepository.ForeignKeyElement.Properties.comments,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForeignKeyElementPropertiesEditionPartForm.this,
									DatabaseViewsRepository.ForeignKeyElement.Properties.comments,
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
									ForeignKeyElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(comments, DatabaseViewsRepository.ForeignKeyElement.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.ForeignKeyElement.Properties.comments, DatabaseViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#getSourceTable()
	 * 
	 */
	public String getSourceTable() {
		return sourceTable.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#setSourceTable(String newValue)
	 * 
	 */
	public void setSourceTable(String newValue) {
		if (newValue != null) {
			sourceTable.setText(newValue);
		} else {
			sourceTable.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#getFKColumn()
	 * 
	 */
	public EObject getFKColumn() {
		if (fKColumn.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) fKColumn.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#initFKColumn(EObjectFlatComboSettings)
	 */
	public void initFKColumn(EObjectFlatComboSettings settings) {
		fKColumn.setInput(settings);
		if (current != null) {
			fKColumn.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#setFKColumn(EObject newValue)
	 * 
	 */
	public void setFKColumn(EObject newValue) {
		if (newValue != null) {
			fKColumn.setSelection(new StructuredSelection(newValue));
		} else {
			fKColumn.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#setFKColumnButtonMode(ButtonsModeEnum newValue)
	 */
	public void setFKColumnButtonMode(ButtonsModeEnum newValue) {
		fKColumn.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#addFilterFKColumn(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFKColumn(ViewerFilter filter) {
		fKColumn.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#addBusinessFilterFKColumn(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFKColumn(ViewerFilter filter) {
		fKColumn.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#getTargetTable()
	 * 
	 */
	public String getTargetTable() {
		return targetTable.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#setTargetTable(String newValue)
	 * 
	 */
	public void setTargetTable(String newValue) {
		if (newValue != null) {
			targetTable.setText(newValue);
		} else {
			targetTable.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#getPKColumn()
	 * 
	 */
	public EObject getPKColumn() {
		if (pKColumn.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) pKColumn.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#initPKColumn(EObjectFlatComboSettings)
	 */
	public void initPKColumn(EObjectFlatComboSettings settings) {
		pKColumn.setInput(settings);
		if (current != null) {
			pKColumn.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#setPKColumn(EObject newValue)
	 * 
	 */
	public void setPKColumn(EObject newValue) {
		if (newValue != null) {
			pKColumn.setSelection(new StructuredSelection(newValue));
		} else {
			pKColumn.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#setPKColumnButtonMode(ButtonsModeEnum newValue)
	 */
	public void setPKColumnButtonMode(ButtonsModeEnum newValue) {
		pKColumn.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#addFilterPKColumn(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPKColumn(ViewerFilter filter) {
		pKColumn.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#addBusinessFilterPKColumn(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPKColumn(ViewerFilter filter) {
		pKColumn.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart#setComments(String newValue)
	 * 
	 */
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return DatabaseMessages.ForeignKeyElement_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
