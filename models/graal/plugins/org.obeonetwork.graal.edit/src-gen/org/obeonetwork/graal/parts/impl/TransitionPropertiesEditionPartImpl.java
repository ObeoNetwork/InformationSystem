/**
 * Generated with Acceleo
 */
package org.obeonetwork.graal.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.TransitionPropertiesEditionPart;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class TransitionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TransitionPropertiesEditionPart {

	protected Text guard;
	protected EMFComboViewer kind;
	protected EObjectFlatComboViewer source;
	protected EObjectFlatComboViewer target;
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TransitionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence transitionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = transitionStep.addStep(GraalViewsRepository.Transition.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.Transition.Properties.guard);
		propertiesStep.addStep(GraalViewsRepository.Transition.Properties.kind);
		propertiesStep.addStep(GraalViewsRepository.Transition.Properties.source);
		propertiesStep.addStep(GraalViewsRepository.Transition.Properties.target);
		propertiesStep.addStep(GraalViewsRepository.Transition.Properties.description);
		
		
		composer = new PartComposer(transitionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.Transition.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalViewsRepository.Transition.Properties.guard) {
					return createGuardText(parent);
				}
				if (key == GraalViewsRepository.Transition.Properties.kind) {
					return createKindEMFComboViewer(parent);
				}
				if (key == GraalViewsRepository.Transition.Properties.source) {
					return createSourceFlatComboViewer(parent);
				}
				if (key == GraalViewsRepository.Transition.Properties.target) {
					return createTargetFlatComboViewer(parent);
				}
				if (key == GraalViewsRepository.Transition.Properties.description) {
					return createDescriptionTextarea(parent);
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
		propertiesGroup.setText(GraalMessages.TransitionPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createGuardText(Composite parent) {
		createDescription(parent, GraalViewsRepository.Transition.Properties.guard, GraalMessages.TransitionPropertiesEditionPart_GuardLabel);
		guard = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData guardData = new GridData(GridData.FILL_HORIZONTAL);
		guard.setLayoutData(guardData);
		guard.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartImpl.this, GraalViewsRepository.Transition.Properties.guard, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, guard.getText()));
			}

		});
		guard.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartImpl.this, GraalViewsRepository.Transition.Properties.guard, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, guard.getText()));
				}
			}

		});
		EditingUtils.setID(guard, GraalViewsRepository.Transition.Properties.guard);
		EditingUtils.setEEFtype(guard, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Transition.Properties.guard, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createGuardText

		// End of user code
		return parent;
	}

	
	protected Composite createKindEMFComboViewer(Composite parent) {
		createDescription(parent, GraalViewsRepository.Transition.Properties.kind, GraalMessages.TransitionPropertiesEditionPart_KindLabel);
		kind = new EMFComboViewer(parent);
		kind.setContentProvider(new ArrayContentProvider());
		kind.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData kindData = new GridData(GridData.FILL_HORIZONTAL);
		kind.getCombo().setLayoutData(kindData);
		kind.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartImpl.this, GraalViewsRepository.Transition.Properties.kind, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getKind()));
			}

		});
		kind.setID(GraalViewsRepository.Transition.Properties.kind);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Transition.Properties.kind, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createKindEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSourceFlatComboViewer(Composite parent) {
		createDescription(parent, GraalViewsRepository.Transition.Properties.source, GraalMessages.TransitionPropertiesEditionPart_SourceLabel);
		source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(GraalViewsRepository.Transition.Properties.source, GraalViewsRepository.SWT_KIND));
		source.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		source.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartImpl.this, GraalViewsRepository.Transition.Properties.source, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSource()));
			}

		});
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.setID(GraalViewsRepository.Transition.Properties.source);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Transition.Properties.source, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createTargetFlatComboViewer(Composite parent) {
		createDescription(parent, GraalViewsRepository.Transition.Properties.target, GraalMessages.TransitionPropertiesEditionPart_TargetLabel);
		target = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(GraalViewsRepository.Transition.Properties.target, GraalViewsRepository.SWT_KIND));
		target.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		target.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartImpl.this, GraalViewsRepository.Transition.Properties.target, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getTarget()));
			}

		});
		GridData targetData = new GridData(GridData.FILL_HORIZONTAL);
		target.setLayoutData(targetData);
		target.setID(GraalViewsRepository.Transition.Properties.target);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Transition.Properties.target, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, GraalViewsRepository.Transition.Properties.description, GraalMessages.TransitionPropertiesEditionPart_DescriptionLabel);
		GridData descriptionLabelData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionLabelData.horizontalSpan = 3;
		descriptionLabel.setLayoutData(descriptionLabelData);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionData.horizontalSpan = 2;
		descriptionData.heightHint = 80;
		descriptionData.widthHint = 200;
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartImpl.this, GraalViewsRepository.Transition.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, GraalViewsRepository.Transition.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Transition.Properties.description, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

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
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#getGuard()
	 * 
	 */
	public String getGuard() {
		return guard.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#setGuard(String newValue)
	 * 
	 */
	public void setGuard(String newValue) {
		if (newValue != null) {
			guard.setText(newValue);
		} else {
			guard.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.guard);
		if (eefElementEditorReadOnlyState && guard.isEnabled()) {
			guard.setEnabled(false);
			guard.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !guard.isEnabled()) {
			guard.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#getKind()
	 * 
	 */
	public Enumerator getKind() {
		Enumerator selection = (Enumerator) ((StructuredSelection) kind.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#initKind(Object input, Enumerator current)
	 */
	public void initKind(Object input, Enumerator current) {
		kind.setInput(input);
		kind.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.kind);
		if (eefElementEditorReadOnlyState && kind.isEnabled()) {
			kind.setEnabled(false);
			kind.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !kind.isEnabled()) {
			kind.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#setKind(Enumerator newValue)
	 * 
	 */
	public void setKind(Enumerator newValue) {
		kind.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.kind);
		if (eefElementEditorReadOnlyState && kind.isEnabled()) {
			kind.setEnabled(false);
			kind.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !kind.isEnabled()) {
			kind.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#getSource()
	 * 
	 */
	public EObject getSource() {
		if (source.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) source.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#initSource(EObjectFlatComboSettings)
	 */
	public void initSource(EObjectFlatComboSettings settings) {
		source.setInput(settings);
		if (current != null) {
			source.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#setSource(EObject newValue)
	 * 
	 */
	public void setSource(EObject newValue) {
		if (newValue != null) {
			source.setSelection(new StructuredSelection(newValue));
		} else {
			source.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#setSourceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue) {
		source.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#addFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter) {
		source.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#addBusinessFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter) {
		source.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#getTarget()
	 * 
	 */
	public EObject getTarget() {
		if (target.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) target.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#initTarget(EObjectFlatComboSettings)
	 */
	public void initTarget(EObjectFlatComboSettings settings) {
		target.setInput(settings);
		if (current != null) {
			target.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.target);
		if (eefElementEditorReadOnlyState && target.isEnabled()) {
			target.setEnabled(false);
			target.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !target.isEnabled()) {
			target.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#setTarget(EObject newValue)
	 * 
	 */
	public void setTarget(EObject newValue) {
		if (newValue != null) {
			target.setSelection(new StructuredSelection(newValue));
		} else {
			target.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.target);
		if (eefElementEditorReadOnlyState && target.isEnabled()) {
			target.setEnabled(false);
			target.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !target.isEnabled()) {
			target.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#setTargetButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTargetButtonMode(ButtonsModeEnum newValue) {
		target.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#addFilterTarget(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTarget(ViewerFilter filter) {
		target.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#addBusinessFilterTarget(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTarget(ViewerFilter filter) {
		target.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TransitionPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.Transition.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(GraalMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.Transition_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
