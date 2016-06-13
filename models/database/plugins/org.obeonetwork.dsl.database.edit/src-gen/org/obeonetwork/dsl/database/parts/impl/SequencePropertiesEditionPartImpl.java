/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts.impl;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart;
import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class SequencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SequencePropertiesEditionPart {

	protected Text name;
	protected Text start;
	protected Text increment;
	protected Text minValue;
	protected Text maxValue;
	protected Button cycle;
	protected Text cacheSize;
	protected Text comments;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SequencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence sequenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = sequenceStep.addStep(DatabaseViewsRepository.Sequence.Properties.class);
		propertiesStep.addStep(DatabaseViewsRepository.Sequence.Properties.name);
		CompositionStep startIncrementStep = propertiesStep.addStep(DatabaseViewsRepository.Sequence.Properties.StartIncrement.class);
		startIncrementStep.addStep(DatabaseViewsRepository.Sequence.Properties.StartIncrement.start);
		startIncrementStep.addStep(DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment);
		
		CompositionStep minMaxStep = propertiesStep.addStep(DatabaseViewsRepository.Sequence.Properties.MinMax.class);
		minMaxStep.addStep(DatabaseViewsRepository.Sequence.Properties.MinMax.minValue);
		minMaxStep.addStep(DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue);
		
		CompositionStep cycleCacheSizeStep = propertiesStep.addStep(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.class);
		cycleCacheSizeStep.addStep(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle);
		cycleCacheSizeStep.addStep(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize);
		
		propertiesStep.addStep(DatabaseViewsRepository.Sequence.Properties.comments);
		
		
		composer = new PartComposer(sequenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.Sequence.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.name) {
					return createNameText(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.StartIncrement.class) {
					return createStartIncrementHBox(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.StartIncrement.start) {
					return createStartText(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment) {
					return createIncrementText(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.MinMax.class) {
					return createMinMaxHBox(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.MinMax.minValue) {
					return createMinValueText(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue) {
					return createMaxValueText(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.class) {
					return createCycleCacheSizeHBox(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle) {
					return createCycleCheckbox(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize) {
					return createCacheSizeText(parent);
				}
				if (key == DatabaseViewsRepository.Sequence.Properties.comments) {
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
		propertiesGroup.setText(DatabaseMessages.SequencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Sequence.Properties.name, DatabaseMessages.SequencePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, DatabaseViewsRepository.Sequence.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.name, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createStartIncrementHBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox startIncrementHBox = new HorizontalBox(container);
		return startIncrementHBox;
	}

	
	protected Composite createStartText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Sequence.Properties.StartIncrement.start, DatabaseMessages.SequencePropertiesEditionPart_StartLabel);
		start = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData startData = new GridData(GridData.FILL_HORIZONTAL);
		start.setLayoutData(startData);
		start.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.StartIncrement.start, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, start.getText()));
			}

		});
		start.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.StartIncrement.start, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, start.getText()));
				}
			}

		});
		EditingUtils.setID(start, DatabaseViewsRepository.Sequence.Properties.StartIncrement.start);
		EditingUtils.setEEFtype(start, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.StartIncrement.start, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStartText

		// End of user code
		return parent;
	}

	
	protected Composite createIncrementText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment, DatabaseMessages.SequencePropertiesEditionPart_IncrementLabel);
		increment = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData incrementData = new GridData(GridData.FILL_HORIZONTAL);
		increment.setLayoutData(incrementData);
		increment.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, increment.getText()));
			}

		});
		increment.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, increment.getText()));
				}
			}

		});
		EditingUtils.setID(increment, DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment);
		EditingUtils.setEEFtype(increment, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIncrementText

		// End of user code
		return parent;
	}

	
	protected Composite createMinMaxHBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox minMaxHBox = new HorizontalBox(container);
		return minMaxHBox;
	}

	
	protected Composite createMinValueText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Sequence.Properties.MinMax.minValue, DatabaseMessages.SequencePropertiesEditionPart_MinValueLabel);
		minValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData minValueData = new GridData(GridData.FILL_HORIZONTAL);
		minValue.setLayoutData(minValueData);
		minValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.MinMax.minValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minValue.getText()));
			}

		});
		minValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.MinMax.minValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minValue.getText()));
				}
			}

		});
		EditingUtils.setID(minValue, DatabaseViewsRepository.Sequence.Properties.MinMax.minValue);
		EditingUtils.setEEFtype(minValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.MinMax.minValue, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMinValueText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxValueText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue, DatabaseMessages.SequencePropertiesEditionPart_MaxValueLabel);
		maxValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData maxValueData = new GridData(GridData.FILL_HORIZONTAL);
		maxValue.setLayoutData(maxValueData);
		maxValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxValue.getText()));
			}

		});
		maxValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxValue.getText()));
				}
			}

		});
		EditingUtils.setID(maxValue, DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue);
		EditingUtils.setEEFtype(maxValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxValueText

		// End of user code
		return parent;
	}

	
	protected Composite createCycleCacheSizeHBox(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		container.setLayoutData(gridData);
		HorizontalBox cycleCacheSizeHBox = new HorizontalBox(container);
		//Apply constraint for checkbox
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
		constraint.horizontalAlignment = GridData.BEGINNING;
		cycleCacheSizeHBox.setLayoutData(constraint);
		return cycleCacheSizeHBox;
	}

	
	protected Composite createCycleCheckbox(Composite parent) {
		cycle = new Button(parent, SWT.CHECK);
		cycle.setText(getDescription(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle, DatabaseMessages.SequencePropertiesEditionPart_CycleLabel));
		cycle.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(cycle.getSelection())));
			}

		});
		GridData cycleData = new GridData(GridData.FILL_HORIZONTAL);
		cycleData.horizontalSpan = 2;
		cycle.setLayoutData(cycleData);
		EditingUtils.setID(cycle, DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle);
		EditingUtils.setEEFtype(cycle, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCycleCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createCacheSizeText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize, DatabaseMessages.SequencePropertiesEditionPart_CacheSizeLabel);
		cacheSize = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData cacheSizeData = new GridData(GridData.FILL_HORIZONTAL);
		cacheSize.setLayoutData(cacheSizeData);
		cacheSize.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheSize.getText()));
			}

		});
		cacheSize.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheSize.getText()));
				}
			}

		});
		EditingUtils.setID(cacheSize, DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize);
		EditingUtils.setEEFtype(cacheSize, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheSizeText

		// End of user code
		return parent;
	}

	
	protected Composite createCommentsTextarea(Composite parent) {
		Label commentsLabel = createDescription(parent, DatabaseViewsRepository.Sequence.Properties.comments, DatabaseMessages.SequencePropertiesEditionPart_CommentsLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartImpl.this, DatabaseViewsRepository.Sequence.Properties.comments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
			}

		});
		EditingUtils.setID(comments, DatabaseViewsRepository.Sequence.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.Sequence.Properties.comments, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getStart()
	 * 
	 */
	public String getStart() {
		return start.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setStart(String newValue)
	 * 
	 */
	public void setStart(String newValue) {
		if (newValue != null) {
			start.setText(newValue);
		} else {
			start.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.StartIncrement.start);
		if (eefElementEditorReadOnlyState && start.isEnabled()) {
			start.setEnabled(false);
			start.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !start.isEnabled()) {
			start.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getIncrement()
	 * 
	 */
	public String getIncrement() {
		return increment.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setIncrement(String newValue)
	 * 
	 */
	public void setIncrement(String newValue) {
		if (newValue != null) {
			increment.setText(newValue);
		} else {
			increment.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment);
		if (eefElementEditorReadOnlyState && increment.isEnabled()) {
			increment.setEnabled(false);
			increment.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !increment.isEnabled()) {
			increment.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getMinValue()
	 * 
	 */
	public String getMinValue() {
		return minValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setMinValue(String newValue)
	 * 
	 */
	public void setMinValue(String newValue) {
		if (newValue != null) {
			minValue.setText(newValue);
		} else {
			minValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.MinMax.minValue);
		if (eefElementEditorReadOnlyState && minValue.isEnabled()) {
			minValue.setEnabled(false);
			minValue.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !minValue.isEnabled()) {
			minValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getMaxValue()
	 * 
	 */
	public String getMaxValue() {
		return maxValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setMaxValue(String newValue)
	 * 
	 */
	public void setMaxValue(String newValue) {
		if (newValue != null) {
			maxValue.setText(newValue);
		} else {
			maxValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue);
		if (eefElementEditorReadOnlyState && maxValue.isEnabled()) {
			maxValue.setEnabled(false);
			maxValue.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxValue.isEnabled()) {
			maxValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getCycle()
	 * 
	 */
	public Boolean getCycle() {
		return Boolean.valueOf(cycle.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setCycle(Boolean newValue)
	 * 
	 */
	public void setCycle(Boolean newValue) {
		if (newValue != null) {
			cycle.setSelection(newValue.booleanValue());
		} else {
			cycle.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle);
		if (eefElementEditorReadOnlyState && cycle.isEnabled()) {
			cycle.setEnabled(false);
			cycle.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cycle.isEnabled()) {
			cycle.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getCacheSize()
	 * 
	 */
	public String getCacheSize() {
		return cacheSize.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setCacheSize(String newValue)
	 * 
	 */
	public void setCacheSize(String newValue) {
		if (newValue != null) {
			cacheSize.setText(newValue);
		} else {
			cacheSize.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize);
		if (eefElementEditorReadOnlyState && cacheSize.isEnabled()) {
			cacheSize.setEnabled(false);
			cacheSize.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheSize.isEnabled()) {
			cacheSize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart#setComments(String newValue)
	 * 
	 */
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.Sequence.Properties.comments);
		if (eefElementEditorReadOnlyState && comments.isEnabled()) {
			comments.setEnabled(false);
			comments.setBackground(comments.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			comments.setToolTipText(DatabaseMessages.Sequence_ReadOnly);
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
		return DatabaseMessages.Sequence_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
