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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart;
import org.obeonetwork.dsl.statemachine.parts.StatemachineViewsRepository;
import org.obeonetwork.dsl.statemachine.providers.StatemachineMessages;

// End of user code

/**
 * 
 * 
 */
public class StatePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, StatePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable incomingTransitions;
	protected List<ViewerFilter> incomingTransitionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> incomingTransitionsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable outcomingTransitions;
	protected List<ViewerFilter> outcomingTransitionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> outcomingTransitionsFilters = new ArrayList<ViewerFilter>();
	protected Text keywords;
	protected Button editKeywords;
	private EList keywordsList;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public StatePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StatePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence stateStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = stateStep.addStep(StatemachineViewsRepository.State.Properties.class);
		propertiesStep.addStep(StatemachineViewsRepository.State.Properties.name);
		propertiesStep.addStep(StatemachineViewsRepository.State.Properties.incomingTransitions);
		propertiesStep.addStep(StatemachineViewsRepository.State.Properties.outcomingTransitions);
		propertiesStep.addStep(StatemachineViewsRepository.State.Properties.keywords);
		propertiesStep.addStep(StatemachineViewsRepository.State.Properties.description);
		
		
		composer = new PartComposer(stateStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == StatemachineViewsRepository.State.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.State.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.State.Properties.incomingTransitions) {
					return createIncomingTransitionsReferencesTable(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.State.Properties.outcomingTransitions) {
					return createOutcomingTransitionsReferencesTable(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.State.Properties.keywords) {
					return createKeywordsMultiValuedEditor(widgetFactory, parent);
				}
				if (key == StatemachineViewsRepository.State.Properties.description) {
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
		propertiesSection.setText(StatemachineMessages.StatePropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, StatemachineViewsRepository.State.Properties.name, StatemachineMessages.StatePropertiesEditionPart_NameLabel);
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
							StatePropertiesEditionPartForm.this,
							StatemachineViewsRepository.State.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									StatePropertiesEditionPartForm.this,
									StatemachineViewsRepository.State.Properties.name,
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
									StatePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, StatemachineViewsRepository.State.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.State.Properties.name, StatemachineViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createIncomingTransitionsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.incomingTransitions = new ReferencesTable(getDescription(StatemachineViewsRepository.State.Properties.incomingTransitions, StatemachineMessages.StatePropertiesEditionPart_IncomingTransitionsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addIncomingTransitions(); }
			public void handleEdit(EObject element) { editIncomingTransitions(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveIncomingTransitions(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromIncomingTransitions(element); }
			public void navigateTo(EObject element) { }
		});
		this.incomingTransitions.setHelpText(propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.State.Properties.incomingTransitions, StatemachineViewsRepository.FORM_KIND));
		this.incomingTransitions.createControls(parent, widgetFactory);
		this.incomingTransitions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.incomingTransitions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData incomingTransitionsData = new GridData(GridData.FILL_HORIZONTAL);
		incomingTransitionsData.horizontalSpan = 3;
		this.incomingTransitions.setLayoutData(incomingTransitionsData);
		this.incomingTransitions.disableMove();
		incomingTransitions.setID(StatemachineViewsRepository.State.Properties.incomingTransitions);
		incomingTransitions.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createIncomingTransitionsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addIncomingTransitions() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(incomingTransitions.getInput(), incomingTransitionsFilters, incomingTransitionsBusinessFilters,
		"incomingTransitions", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.incomingTransitions,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				incomingTransitions.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveIncomingTransitions(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.incomingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		incomingTransitions.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromIncomingTransitions(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.incomingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		incomingTransitions.refresh();
	}

	/**
	 * 
	 */
	protected void editIncomingTransitions(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				incomingTransitions.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createOutcomingTransitionsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.outcomingTransitions = new ReferencesTable(getDescription(StatemachineViewsRepository.State.Properties.outcomingTransitions, StatemachineMessages.StatePropertiesEditionPart_OutcomingTransitionsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addOutcomingTransitions(); }
			public void handleEdit(EObject element) { editOutcomingTransitions(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveOutcomingTransitions(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromOutcomingTransitions(element); }
			public void navigateTo(EObject element) { }
		});
		this.outcomingTransitions.setHelpText(propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.State.Properties.outcomingTransitions, StatemachineViewsRepository.FORM_KIND));
		this.outcomingTransitions.createControls(parent, widgetFactory);
		this.outcomingTransitions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.outcomingTransitions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData outcomingTransitionsData = new GridData(GridData.FILL_HORIZONTAL);
		outcomingTransitionsData.horizontalSpan = 3;
		this.outcomingTransitions.setLayoutData(outcomingTransitionsData);
		this.outcomingTransitions.disableMove();
		outcomingTransitions.setID(StatemachineViewsRepository.State.Properties.outcomingTransitions);
		outcomingTransitions.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createOutcomingTransitionsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addOutcomingTransitions() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(outcomingTransitions.getInput(), outcomingTransitionsFilters, outcomingTransitionsBusinessFilters,
		"outcomingTransitions", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.outcomingTransitions,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				outcomingTransitions.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveOutcomingTransitions(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.outcomingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		outcomingTransitions.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromOutcomingTransitions(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.outcomingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		outcomingTransitions.refresh();
	}

	/**
	 * 
	 */
	protected void editOutcomingTransitions(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				outcomingTransitions.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createKeywordsMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		keywords = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData keywordsData = new GridData(GridData.FILL_HORIZONTAL);
		keywordsData.horizontalSpan = 2;
		keywords.setLayoutData(keywordsData);
		EditingUtils.setID(keywords, StatemachineViewsRepository.State.Properties.keywords);
		EditingUtils.setEEFtype(keywords, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editKeywords = widgetFactory.createButton(parent, getDescription(StatemachineViewsRepository.State.Properties.keywords, StatemachineMessages.StatePropertiesEditionPart_KeywordsLabel), SWT.NONE);
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
						keywords.getShell(), "State", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						keywordsList, EnvironmentPackage.eINSTANCE.getObeoDSMObject_Keywords().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					keywordsList = dialog.getResult();
					if (keywordsList == null) {
						keywordsList = new BasicEList();
					}
					keywords.setText(keywordsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.keywords, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(keywordsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editKeywords, StatemachineViewsRepository.State.Properties.keywords);
		EditingUtils.setEEFtype(editKeywords, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createKeywordsMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, StatemachineViewsRepository.State.Properties.description, StatemachineMessages.StatePropertiesEditionPart_DescriptionLabel);
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
							StatePropertiesEditionPartForm.this,
							StatemachineViewsRepository.State.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									StatePropertiesEditionPartForm.this,
									StatemachineViewsRepository.State.Properties.description,
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
									StatePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StatePropertiesEditionPartForm.this, StatemachineViewsRepository.State.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, StatemachineViewsRepository.State.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(StatemachineViewsRepository.State.Properties.description, StatemachineViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.State.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(StatemachineMessages.State_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#initIncomingTransitions(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initIncomingTransitions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		incomingTransitions.setContentProvider(contentProvider);
		incomingTransitions.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.State.Properties.incomingTransitions);
		if (eefElementEditorReadOnlyState && incomingTransitions.getTable().isEnabled()) {
			incomingTransitions.setEnabled(false);
			incomingTransitions.setToolTipText(StatemachineMessages.State_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !incomingTransitions.getTable().isEnabled()) {
			incomingTransitions.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#updateIncomingTransitions()
	 * 
	 */
	public void updateIncomingTransitions() {
	incomingTransitions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#addFilterIncomingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIncomingTransitions(ViewerFilter filter) {
		incomingTransitionsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#addBusinessFilterIncomingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIncomingTransitions(ViewerFilter filter) {
		incomingTransitionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#isContainedInIncomingTransitionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInIncomingTransitionsTable(EObject element) {
		return ((ReferencesTableSettings)incomingTransitions.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#initOutcomingTransitions(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initOutcomingTransitions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		outcomingTransitions.setContentProvider(contentProvider);
		outcomingTransitions.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.State.Properties.outcomingTransitions);
		if (eefElementEditorReadOnlyState && outcomingTransitions.getTable().isEnabled()) {
			outcomingTransitions.setEnabled(false);
			outcomingTransitions.setToolTipText(StatemachineMessages.State_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outcomingTransitions.getTable().isEnabled()) {
			outcomingTransitions.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#updateOutcomingTransitions()
	 * 
	 */
	public void updateOutcomingTransitions() {
	outcomingTransitions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#addFilterOutcomingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOutcomingTransitions(ViewerFilter filter) {
		outcomingTransitionsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#addBusinessFilterOutcomingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOutcomingTransitions(ViewerFilter filter) {
		outcomingTransitionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#isContainedInOutcomingTransitionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOutcomingTransitionsTable(EObject element) {
		return ((ReferencesTableSettings)outcomingTransitions.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#getKeywords()
	 * 
	 */
	public EList getKeywords() {
		return keywordsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#setKeywords(EList newValue)
	 * 
	 */
	public void setKeywords(EList newValue) {
		keywordsList = newValue;
		if (newValue != null) {
			keywords.setText(keywordsList.toString());
		} else {
			keywords.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.State.Properties.keywords);
		if (eefElementEditorReadOnlyState && keywords.isEnabled()) {
			keywords.setEnabled(false);
			keywords.setToolTipText(StatemachineMessages.State_ReadOnly);
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
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.statemachine.parts.StatePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(StatemachineViewsRepository.State.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(StatemachineMessages.State_ReadOnly);
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
		return StatemachineMessages.State_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
