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
package org.obeonetwork.dsl.statemachine.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;
import org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart;
import org.obeonetwork.dsl.statemachine.providers.StatemachineMessages;

// End of user code

/**
 * 
 * 
 */
public class TransitionPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, TransitionPropertiesEditionPart {

	protected Text guard;
	protected EObjectFlatComboViewer from;
	protected EObjectFlatComboViewer to;
	protected Text keywords;
	protected Button editKeywords;
	private EList keywordsList;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public TransitionPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TransitionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence transitionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = transitionStep.addStep(StatemachineViewsRepository.Transition.Properties.class);
		propertiesStep.addStep(StatemachineViewsRepository.Transition.Properties.guard);
		propertiesStep.addStep(StatemachineViewsRepository.Transition.Properties.from);
		propertiesStep.addStep(StatemachineViewsRepository.Transition.Properties.to);
		propertiesStep.addStep(StatemachineViewsRepository.Transition.Properties.keywords);
		propertiesStep.addStep(StatemachineViewsRepository.Transition.Properties.description);
		
		
		composer = new PartComposer(transitionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == StatemachineViewsRepository.Transition.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.Transition.Properties.guard) {
					return createGuardText(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.Transition.Properties.from) {
					return createFromFlatComboViewer(parent, widgetFactory);
				}
				if (key == StatemachineViewsRepository.Transition.Properties.to) {
					return createToFlatComboViewer(parent, widgetFactory);
				}
				if (key == StatemachineViewsRepository.Transition.Properties.keywords) {
					return createKeywordsMultiValuedEditor(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.Transition.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
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
		propertiesSection.setText(StatemachineMessages.TransitionPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createGuardText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, StatemachineViewsRepository.Transition.Properties.guard, StatemachineMessages.TransitionPropertiesEditionPart_GuardLabel);
		guard = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		guard.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData guardData = new GridData(GridData.FILL_HORIZONTAL);
		guard.setLayoutData(guardData);
		guard.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							TransitionPropertiesEditionPartForm.this,
							StatemachineViewsRepository.Transition.Properties.guard,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, guard.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TransitionPropertiesEditionPartForm.this,
									StatemachineViewsRepository.Transition.Properties.guard,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, guard.getText()));
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
									TransitionPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		guard.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, StatemachineViewsRepository.Transition.Properties.guard, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, guard.getText()));
				}
			}
		});
		EditingUtils.setID(guard, StatemachineViewsRepository.Transition.Properties.guard);
		EditingUtils.setEEFtype(guard, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.Transition.Properties.guard, StatemachineViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createGuardText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createFromFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, StatemachineViewsRepository.Transition.Properties.from, StatemachineMessages.TransitionPropertiesEditionPart_FromLabel);
		from = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(StatemachineViewsRepository.Transition.Properties.from, StatemachineViewsRepository.FORM_KIND));
		widgetFactory.adapt(from);
		from.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData fromData = new GridData(GridData.FILL_HORIZONTAL);
		from.setLayoutData(fromData);
		from.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, StatemachineViewsRepository.Transition.Properties.from, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFrom()));
			}

		});
		from.setID(StatemachineViewsRepository.Transition.Properties.from);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.Transition.Properties.from, StatemachineViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFromFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createToFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, StatemachineViewsRepository.Transition.Properties.to, StatemachineMessages.TransitionPropertiesEditionPart_ToLabel);
		to = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(StatemachineViewsRepository.Transition.Properties.to, StatemachineViewsRepository.FORM_KIND));
		widgetFactory.adapt(to);
		to.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData toData = new GridData(GridData.FILL_HORIZONTAL);
		to.setLayoutData(toData);
		to.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, StatemachineViewsRepository.Transition.Properties.to, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTo()));
			}

		});
		to.setID(StatemachineViewsRepository.Transition.Properties.to);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.Transition.Properties.to, StatemachineViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createToFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createKeywordsMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		keywords = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData keywordsData = new GridData(GridData.FILL_HORIZONTAL);
		keywordsData.horizontalSpan = 2;
		keywords.setLayoutData(keywordsData);
		EditingUtils.setID(keywords, StatemachineViewsRepository.Transition.Properties.keywords);
		EditingUtils.setEEFtype(keywords, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editKeywords = widgetFactory.createButton(parent, getDescription(StatemachineViewsRepository.Transition.Properties.keywords, StatemachineMessages.TransitionPropertiesEditionPart_KeywordsLabel), SWT.NONE);
		GridData editKeywordsData = new GridData();
		editKeywords.setLayoutData(editKeywordsData);
		editKeywords.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						keywords.getShell(), "Transition", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						keywordsList, EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					keywordsList = dialog.getResult();
					if (keywordsList == null) {
						keywordsList = new BasicEList();
					}
					keywords.setText(keywordsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, StatemachineViewsRepository.Transition.Properties.keywords, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(keywordsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editKeywords, StatemachineViewsRepository.Transition.Properties.keywords);
		EditingUtils.setEEFtype(editKeywords, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createKeywordsMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, StatemachineViewsRepository.Transition.Properties.description, StatemachineMessages.TransitionPropertiesEditionPart_DescriptionLabel);
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							TransitionPropertiesEditionPartForm.this,
							StatemachineViewsRepository.Transition.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TransitionPropertiesEditionPartForm.this,
									StatemachineViewsRepository.Transition.Properties.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
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
									TransitionPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TransitionPropertiesEditionPartForm.this, StatemachineViewsRepository.Transition.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, StatemachineViewsRepository.Transition.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.Transition.Properties.description, StatemachineViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#getGuard()
	 * 
	 */
	public String getGuard() {
		return guard.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#setGuard(String newValue)
	 * 
	 */
	public void setGuard(String newValue) {
		if (newValue != null) {
			guard.setText(newValue);
		} else {
			guard.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.Transition.Properties.guard);
		if (eefElementEditorReadOnlyState && guard.isEnabled()) {
			guard.setEnabled(false);
			guard.setToolTipText(StatemachineMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !guard.isEnabled()) {
			guard.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#getFrom()
	 * 
	 */
	public EObject getFrom() {
		if (from.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) from.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#initFrom(EObjectFlatComboSettings)
	 */
	public void initFrom(EObjectFlatComboSettings settings) {
		from.setInput(settings);
		if (current != null) {
			from.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.Transition.Properties.from);
		if (eefElementEditorReadOnlyState && from.isEnabled()) {
			from.setEnabled(false);
			from.setToolTipText(StatemachineMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !from.isEnabled()) {
			from.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#setFrom(EObject newValue)
	 * 
	 */
	public void setFrom(EObject newValue) {
		if (newValue != null) {
			from.setSelection(new StructuredSelection(newValue));
		} else {
			from.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.Transition.Properties.from);
		if (eefElementEditorReadOnlyState && from.isEnabled()) {
			from.setEnabled(false);
			from.setToolTipText(StatemachineMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !from.isEnabled()) {
			from.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#setFromButtonMode(ButtonsModeEnum newValue)
	 */
	public void setFromButtonMode(ButtonsModeEnum newValue) {
		from.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#addFilterFrom(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFrom(ViewerFilter filter) {
		from.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#addBusinessFilterFrom(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFrom(ViewerFilter filter) {
		from.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#getTo()
	 * 
	 */
	public EObject getTo() {
		if (to.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) to.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#initTo(EObjectFlatComboSettings)
	 */
	public void initTo(EObjectFlatComboSettings settings) {
		to.setInput(settings);
		if (current != null) {
			to.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.Transition.Properties.to);
		if (eefElementEditorReadOnlyState && to.isEnabled()) {
			to.setEnabled(false);
			to.setToolTipText(StatemachineMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !to.isEnabled()) {
			to.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#setTo(EObject newValue)
	 * 
	 */
	public void setTo(EObject newValue) {
		if (newValue != null) {
			to.setSelection(new StructuredSelection(newValue));
		} else {
			to.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.Transition.Properties.to);
		if (eefElementEditorReadOnlyState && to.isEnabled()) {
			to.setEnabled(false);
			to.setToolTipText(StatemachineMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !to.isEnabled()) {
			to.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#setToButtonMode(ButtonsModeEnum newValue)
	 */
	public void setToButtonMode(ButtonsModeEnum newValue) {
		to.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#addFilterTo(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTo(ViewerFilter filter) {
		to.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#addBusinessFilterTo(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTo(ViewerFilter filter) {
		to.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#getKeywords()
	 * 
	 */
	public EList getKeywords() {
		return keywordsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#setKeywords(EList newValue)
	 * 
	 */
	public void setKeywords(EList newValue) {
		keywordsList = newValue;
		if (newValue != null) {
			keywords.setText(keywordsList.toString());
		} else {
			keywords.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.Transition.Properties.keywords);
		if (eefElementEditorReadOnlyState && keywords.isEnabled()) {
			keywords.setEnabled(false);
			keywords.setToolTipText(StatemachineMessages.Transition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !keywords.isEnabled()) {
			keywords.setEnabled(true);
		}	
		
	}

	public void addToKeywords(Object newValue) {
		keywordsList.add(newValue);
		if (newValue != null) {
			keywords.setText(keywordsList.toString());
		} else {
			keywords.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToKeywords(Object newValue) {
		keywordsList.remove(newValue);
		if (newValue != null) {
			keywords.setText(keywordsList.toString());
		} else {
			keywords.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.TransitionPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.Transition.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(StatemachineMessages.Transition_ReadOnly);
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
		return StatemachineMessages.Transition_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
