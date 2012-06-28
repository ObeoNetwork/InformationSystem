/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;

import org.obeonetwork.dsl.database.providers.DatabaseMessages;

import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

// End of user code

/**
 * 
 * 
 */
public class ColumnPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ColumnPropertiesEditionPart {

	protected Text name;
	protected EMFComboViewer type;
	protected Text length;
	protected Text precision;
	protected Text literals;
	protected Button editLiterals;
	private EList literalsList;
	protected Button nullable;
	protected Button primaryKey;
	protected Button unique;
	protected Button autoincrement;
	protected EObjectFlatComboViewer sequence;
	protected Text defaultValue;
	protected Text comments;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ColumnPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence columnStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = columnStep.addStep(DatabaseViewsRepository.Column.Properties.class);
		propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.name);
		propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.type);
		CompositionStep typeAttributesStep = propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.TypeAttributes.class);
		typeAttributesStep.addStep(DatabaseViewsRepository.Column.Properties.TypeAttributes.length);
		typeAttributesStep.addStep(DatabaseViewsRepository.Column.Properties.TypeAttributes.precision);
		
		propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.literals);
		CompositionStep nullablePkAndUniqueStep = propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.class);
		nullablePkAndUniqueStep.addStep(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable);
		nullablePkAndUniqueStep.addStep(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey);
		nullablePkAndUniqueStep.addStep(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique);
		
		CompositionStep sequenceStep = propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.Sequence.class);
		sequenceStep.addStep(DatabaseViewsRepository.Column.Properties.Sequence.autoincrement);
		sequenceStep.addStep(DatabaseViewsRepository.Column.Properties.Sequence.sequence_);
		
		propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.defaultValue);
		propertiesStep.addStep(DatabaseViewsRepository.Column.Properties.comments);
		
		
		composer = new PartComposer(columnStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.Column.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.name) {
					return createNameText(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.type) {
					return createTypeEMFComboViewer(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.TypeAttributes.class) {
					return createTypeAttributesHBox(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.TypeAttributes.length) {
					return createLengthText(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.TypeAttributes.precision) {
					return createPrecisionText(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.literals) {
					return createLiteralsMultiValuedEditor(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.class) {
					return createNullablePkAndUniqueHBox(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable) {
					return createNullableCheckbox(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey) {
					return createPrimaryKeyCheckbox(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique) {
					return createUniqueCheckbox(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.Sequence.class) {
					return createSequenceHBox(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.Sequence.autoincrement) {
					return createAutoincrementCheckbox(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.Sequence.sequence_) {
					return createSequenceFlatComboViewer(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.defaultValue) {
					return createDefaultValueText(parent);
				}
				if (key == DatabaseViewsRepository.Column.Properties.comments) {
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
		propertiesGroup.setText(DatabaseMessages.ColumnPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Column.Properties.name, DatabaseMessages.ColumnPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, DatabaseViewsRepository.Column.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.name, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTypeEMFComboViewer(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Column.Properties.type, DatabaseMessages.ColumnPropertiesEditionPart_TypeLabel);
		type = new EMFComboViewer(parent);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.getCombo().setLayoutData(typeData);
		type.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		type.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		type.setContentProvider(new EMFListContentProvider());
		EditingUtils.setID(type.getCombo(), DatabaseViewsRepository.Column.Properties.type);
		EditingUtils.setEEFtype(type.getCombo(), "eef::Combo"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.type, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createTypeAttributesHBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox typeAttributesHBox = new HorizontalBox(container);
		return typeAttributesHBox;
	}

	
	protected Composite createLengthText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Column.Properties.TypeAttributes.length, DatabaseMessages.ColumnPropertiesEditionPart_LengthLabel);
		length = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData lengthData = new GridData(GridData.FILL_HORIZONTAL);
		length.setLayoutData(lengthData);
		length.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.TypeAttributes.length, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
			}

		});
		length.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.TypeAttributes.length, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
				}
			}

		});
		EditingUtils.setID(length, DatabaseViewsRepository.Column.Properties.TypeAttributes.length);
		EditingUtils.setEEFtype(length, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.TypeAttributes.length, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPrecisionText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Column.Properties.TypeAttributes.precision, DatabaseMessages.ColumnPropertiesEditionPart_PrecisionLabel);
		precision = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData precisionData = new GridData(GridData.FILL_HORIZONTAL);
		precision.setLayoutData(precisionData);
		precision.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.TypeAttributes.precision, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, precision.getText()));
			}

		});
		precision.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.TypeAttributes.precision, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, precision.getText()));
				}
			}

		});
		EditingUtils.setID(precision, DatabaseViewsRepository.Column.Properties.TypeAttributes.precision);
		EditingUtils.setEEFtype(precision, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.TypeAttributes.precision, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	protected Composite createLiteralsMultiValuedEditor(Composite parent) {
		literals = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData literalsData = new GridData(GridData.FILL_HORIZONTAL);
		literalsData.horizontalSpan = 2;
		literals.setLayoutData(literalsData);
		EditingUtils.setID(literals, DatabaseViewsRepository.Column.Properties.literals);
		EditingUtils.setEEFtype(literals, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editLiterals = new Button(parent, SWT.NONE);
		editLiterals.setText(getDescription(DatabaseViewsRepository.Column.Properties.literals, DatabaseMessages.ColumnPropertiesEditionPart_LiteralsLabel));
		GridData editLiteralsData = new GridData();
		editLiterals.setLayoutData(editLiteralsData);
		editLiterals.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						literals.getShell(), "Column", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						literalsList, TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					literalsList = dialog.getResult();
					if (literalsList == null) {
						literalsList = new BasicEList();
					}
					literals.setText(literalsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.literals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(literalsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editLiterals, DatabaseViewsRepository.Column.Properties.literals);
		EditingUtils.setEEFtype(editLiterals, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createNullablePkAndUniqueHBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox nullablePkAndUniqueHBox = new HorizontalBox(container);
		//Apply constraint for checkbox
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
		constraint.horizontalAlignment = GridData.BEGINNING;
		nullablePkAndUniqueHBox.setLayoutData(constraint);
		return nullablePkAndUniqueHBox;
	}

	
	protected Composite createNullableCheckbox(Composite parent) {
		nullable = new Button(parent, SWT.CHECK);
		nullable.setText(getDescription(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable, DatabaseMessages.ColumnPropertiesEditionPart_NullableLabel));
		nullable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(nullable.getSelection())));
			}

		});
		GridData nullableData = new GridData(GridData.FILL_HORIZONTAL);
		nullableData.horizontalSpan = 2;
		nullable.setLayoutData(nullableData);
		EditingUtils.setID(nullable, DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable);
		EditingUtils.setEEFtype(nullable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPrimaryKeyCheckbox(Composite parent) {
		primaryKey = new Button(parent, SWT.CHECK);
		primaryKey.setText(getDescription(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey, DatabaseMessages.ColumnPropertiesEditionPart_PrimaryKeyLabel));
		primaryKey.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(primaryKey.getSelection())));
			}

		});
		GridData primaryKeyData = new GridData(GridData.FILL_HORIZONTAL);
		primaryKeyData.horizontalSpan = 2;
		primaryKey.setLayoutData(primaryKeyData);
		EditingUtils.setID(primaryKey, DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey);
		EditingUtils.setEEFtype(primaryKey, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUniqueCheckbox(Composite parent) {
		unique = new Button(parent, SWT.CHECK);
		unique.setText(getDescription(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique, DatabaseMessages.ColumnPropertiesEditionPart_UniqueLabel));
		unique.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unique.getSelection())));
			}

		});
		GridData uniqueData = new GridData(GridData.FILL_HORIZONTAL);
		uniqueData.horizontalSpan = 2;
		unique.setLayoutData(uniqueData);
		EditingUtils.setID(unique, DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique);
		EditingUtils.setEEFtype(unique, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSequenceHBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox sequenceHBox = new HorizontalBox(container);
		//Apply constraint for checkbox
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
		constraint.horizontalAlignment = GridData.BEGINNING;
		sequenceHBox.setLayoutData(constraint);
		return sequenceHBox;
	}

	
	protected Composite createAutoincrementCheckbox(Composite parent) {
		autoincrement = new Button(parent, SWT.CHECK);
		autoincrement.setText(getDescription(DatabaseViewsRepository.Column.Properties.Sequence.autoincrement, DatabaseMessages.ColumnPropertiesEditionPart_AutoincrementLabel));
		autoincrement.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.Sequence.autoincrement, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(autoincrement.getSelection())));
			}

		});
		GridData autoincrementData = new GridData(GridData.FILL_HORIZONTAL);
		autoincrementData.horizontalSpan = 2;
		autoincrement.setLayoutData(autoincrementData);
		EditingUtils.setID(autoincrement, DatabaseViewsRepository.Column.Properties.Sequence.autoincrement);
		EditingUtils.setEEFtype(autoincrement, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.Sequence.autoincrement, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSequenceFlatComboViewer(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Column.Properties.Sequence.sequence_, DatabaseMessages.ColumnPropertiesEditionPart_SequenceLabel);
		sequence = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(DatabaseViewsRepository.Column.Properties.Sequence.sequence_, DatabaseViewsRepository.SWT_KIND));
		sequence.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		sequence.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.Sequence.sequence_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSequence()));
			}

		});
		GridData sequenceData = new GridData(GridData.FILL_HORIZONTAL);
		sequence.setLayoutData(sequenceData);
		sequence.setID(DatabaseViewsRepository.Column.Properties.Sequence.sequence_);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.Sequence.sequence_, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDefaultValueText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Column.Properties.defaultValue, DatabaseMessages.ColumnPropertiesEditionPart_DefaultValueLabel);
		defaultValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData defaultValueData = new GridData(GridData.FILL_HORIZONTAL);
		defaultValue.setLayoutData(defaultValueData);
		defaultValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
			}

		});
		defaultValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
				}
			}

		});
		EditingUtils.setID(defaultValue, DatabaseViewsRepository.Column.Properties.defaultValue);
		EditingUtils.setEEFtype(defaultValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.defaultValue, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCommentsTextarea(Composite parent) {
		Label commentsLabel = createDescription(parent, DatabaseViewsRepository.Column.Properties.comments, DatabaseMessages.ColumnPropertiesEditionPart_CommentsLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ColumnPropertiesEditionPartImpl.this, DatabaseViewsRepository.Column.Properties.comments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
			}

		});
		EditingUtils.setID(comments, DatabaseViewsRepository.Column.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Column.Properties.comments, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getType()
	 * 
	 */
	public Object getType() {
		if (type.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection) type.getSelection()).getFirstElement();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#initType(Object input, Object currentValue)
	 */
	public void initType(Object input, Object currentValue) {
		type.setInput(input);
		if (currentValue != null) {
			type.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setType(Object newValue)
	 * 
	 */
	public void setType(Object newValue) {
		if (newValue != null) {
			type.modelUpdating(new StructuredSelection(newValue));
		} else {
			type.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#addFilterType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToType(ViewerFilter filter) {
		type.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getLength()
	 * 
	 */
	public String getLength() {
		return length.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setLength(String newValue)
	 * 
	 */
	public void setLength(String newValue) {
		if (newValue != null) {
			length.setText(newValue);
		} else {
			length.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getPrecision()
	 * 
	 */
	public String getPrecision() {
		return precision.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setPrecision(String newValue)
	 * 
	 */
	public void setPrecision(String newValue) {
		if (newValue != null) {
			precision.setText(newValue);
		} else {
			precision.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getLiterals()
	 * 
	 */
	public EList getLiterals() {
		return literalsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setLiterals(EList newValue)
	 * 
	 */
	public void setLiterals(EList newValue) {
		literalsList = newValue;
		if (newValue != null) {
			literals.setText(literalsList.toString());
		} else {
			literals.setText(""); //$NON-NLS-1$
		}
	}

	public void addToLiterals(Object newValue) {
		literalsList.add(newValue);
		if (newValue != null) {
			literals.setText(literalsList.toString());
		} else {
			literals.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToLiterals(Object newValue) {
		literalsList.remove(newValue);
		if (newValue != null) {
			literals.setText(literalsList.toString());
		} else {
			literals.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getNullable()
	 * 
	 */
	public Boolean getNullable() {
		return Boolean.valueOf(nullable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setNullable(Boolean newValue)
	 * 
	 */
	public void setNullable(Boolean newValue) {
		if (newValue != null) {
			nullable.setSelection(newValue.booleanValue());
		} else {
			nullable.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getPrimaryKey()
	 * 
	 */
	public Boolean getPrimaryKey() {
		return Boolean.valueOf(primaryKey.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setPrimaryKey(Boolean newValue)
	 * 
	 */
	public void setPrimaryKey(Boolean newValue) {
		if (newValue != null) {
			primaryKey.setSelection(newValue.booleanValue());
		} else {
			primaryKey.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getUnique()
	 * 
	 */
	public Boolean getUnique() {
		return Boolean.valueOf(unique.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setUnique(Boolean newValue)
	 * 
	 */
	public void setUnique(Boolean newValue) {
		if (newValue != null) {
			unique.setSelection(newValue.booleanValue());
		} else {
			unique.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getAutoincrement()
	 * 
	 */
	public Boolean getAutoincrement() {
		return Boolean.valueOf(autoincrement.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setAutoincrement(Boolean newValue)
	 * 
	 */
	public void setAutoincrement(Boolean newValue) {
		if (newValue != null) {
			autoincrement.setSelection(newValue.booleanValue());
		} else {
			autoincrement.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getSequence()
	 * 
	 */
	public EObject getSequence() {
		if (sequence.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) sequence.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#initSequence(EObjectFlatComboSettings)
	 */
	public void initSequence(EObjectFlatComboSettings settings) {
		sequence.setInput(settings);
		if (current != null) {
			sequence.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setSequence(EObject newValue)
	 * 
	 */
	public void setSequence(EObject newValue) {
		if (newValue != null) {
			sequence.setSelection(new StructuredSelection(newValue));
		} else {
			sequence.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setSequenceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSequenceButtonMode(ButtonsModeEnum newValue) {
		sequence.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#addFilterSequence(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSequence(ViewerFilter filter) {
		sequence.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#addBusinessFilterSequence(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSequence(ViewerFilter filter) {
		sequence.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getDefaultValue()
	 * 
	 */
	public String getDefaultValue() {
		return defaultValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setDefaultValue(String newValue)
	 * 
	 */
	public void setDefaultValue(String newValue) {
		if (newValue != null) {
			defaultValue.setText(newValue);
		} else {
			defaultValue.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart#setComments(String newValue)
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
		return DatabaseMessages.Column_Part_Title;
	}

	// Start of user code additional methods

	public void updateTypeFields(boolean lengthVisible, boolean precisionVisible, boolean literalsVisible) {
		
	}

	
	// End of user code


}
