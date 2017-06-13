/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
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
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class TaskReferencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, TaskReferencePropertiesEditionPart {

	protected EObjectFlatComboViewer task;
	protected Text description;
	protected ReferencesTable outgoingTransitions;
	protected List<ViewerFilter> outgoingTransitionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> outgoingTransitionsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable incomingTransitions;
	protected List<ViewerFilter> incomingTransitionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> incomingTransitionsFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public TaskReferencePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TaskReferencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence taskReferenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = taskReferenceStep.addStep(GraalViewsRepository.TaskReference.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.TaskReference.Properties.task);
		propertiesStep.addStep(GraalViewsRepository.TaskReference.Properties.description);
		propertiesStep.addStep(GraalViewsRepository.TaskReference.Properties.outgoingTransitions);
		propertiesStep.addStep(GraalViewsRepository.TaskReference.Properties.incomingTransitions);
		
		
		composer = new PartComposer(taskReferenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.TaskReference.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == GraalViewsRepository.TaskReference.Properties.task) {
					return createTaskFlatComboViewer(parent, widgetFactory);
				}
				if (key == GraalViewsRepository.TaskReference.Properties.description) {
					return createDescriptionTextarea(widgetFactory, parent);
				}
				if (key == GraalViewsRepository.TaskReference.Properties.outgoingTransitions) {
					return createOutgoingTransitionsReferencesTable(widgetFactory, parent);
				}
				if (key == GraalViewsRepository.TaskReference.Properties.incomingTransitions) {
					return createIncomingTransitionsReferencesTable(widgetFactory, parent);
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
		propertiesSection.setText(GraalMessages.TaskReferencePropertiesEditionPart_PropertiesGroupLabel);
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
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createTaskFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, GraalViewsRepository.TaskReference.Properties.task, GraalMessages.TaskReferencePropertiesEditionPart_TaskLabel);
		task = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(GraalViewsRepository.TaskReference.Properties.task, GraalViewsRepository.FORM_KIND));
		widgetFactory.adapt(task);
		task.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData taskData = new GridData(GridData.FILL_HORIZONTAL);
		task.setLayoutData(taskData);
		task.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.task, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTask()));
			}

		});
		task.setID(GraalViewsRepository.TaskReference.Properties.task);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.TaskReference.Properties.task, GraalViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTaskFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionTextarea(FormToolkit widgetFactory, Composite parent) {
		Label descriptionLabel = createDescription(parent, GraalViewsRepository.TaskReference.Properties.description, GraalMessages.TaskReferencePropertiesEditionPart_DescriptionLabel);
		GridData descriptionLabelData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionLabelData.horizontalSpan = 3;
		descriptionLabel.setLayoutData(descriptionLabelData);
		description = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
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
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							TaskReferencePropertiesEditionPartForm.this,
							GraalViewsRepository.TaskReference.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TaskReferencePropertiesEditionPartForm.this,
									GraalViewsRepository.TaskReference.Properties.description,
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
									TaskReferencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(description, GraalViewsRepository.TaskReference.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.TaskReference.Properties.description, GraalViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createOutgoingTransitionsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.outgoingTransitions = new ReferencesTable(getDescription(GraalViewsRepository.TaskReference.Properties.outgoingTransitions, GraalMessages.TaskReferencePropertiesEditionPart_OutgoingTransitionsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addOutgoingTransitions(); }
			public void handleEdit(EObject element) { editOutgoingTransitions(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveOutgoingTransitions(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromOutgoingTransitions(element); }
			public void navigateTo(EObject element) { }
		});
		this.outgoingTransitions.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.TaskReference.Properties.outgoingTransitions, GraalViewsRepository.FORM_KIND));
		this.outgoingTransitions.createControls(parent, widgetFactory);
		this.outgoingTransitions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.outgoingTransitions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData outgoingTransitionsData = new GridData(GridData.FILL_HORIZONTAL);
		outgoingTransitionsData.horizontalSpan = 3;
		this.outgoingTransitions.setLayoutData(outgoingTransitionsData);
		this.outgoingTransitions.disableMove();
		outgoingTransitions.setID(GraalViewsRepository.TaskReference.Properties.outgoingTransitions);
		outgoingTransitions.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createOutgoingTransitionsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addOutgoingTransitions() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(outgoingTransitions.getInput(), outgoingTransitionsFilters, outgoingTransitionsBusinessFilters,
		"outgoingTransitions", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.outgoingTransitions,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				outgoingTransitions.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveOutgoingTransitions(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.outgoingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		outgoingTransitions.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromOutgoingTransitions(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.outgoingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		outgoingTransitions.refresh();
	}

	/**
	 * 
	 */
	protected void editOutgoingTransitions(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				outgoingTransitions.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createIncomingTransitionsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.incomingTransitions = new ReferencesTable(getDescription(GraalViewsRepository.TaskReference.Properties.incomingTransitions, GraalMessages.TaskReferencePropertiesEditionPart_IncomingTransitionsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addIncomingTransitions(); }
			public void handleEdit(EObject element) { editIncomingTransitions(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveIncomingTransitions(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromIncomingTransitions(element); }
			public void navigateTo(EObject element) { }
		});
		this.incomingTransitions.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.TaskReference.Properties.incomingTransitions, GraalViewsRepository.FORM_KIND));
		this.incomingTransitions.createControls(parent, widgetFactory);
		this.incomingTransitions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.incomingTransitions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData incomingTransitionsData = new GridData(GridData.FILL_HORIZONTAL);
		incomingTransitionsData.horizontalSpan = 3;
		this.incomingTransitions.setLayoutData(incomingTransitionsData);
		this.incomingTransitions.disableMove();
		incomingTransitions.setID(GraalViewsRepository.TaskReference.Properties.incomingTransitions);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.incomingTransitions,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.incomingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		incomingTransitions.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromIncomingTransitions(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskReferencePropertiesEditionPartForm.this, GraalViewsRepository.TaskReference.Properties.incomingTransitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#getTask()
	 * 
	 */
	public EObject getTask() {
		if (task.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) task.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#initTask(EObjectFlatComboSettings)
	 */
	public void initTask(EObjectFlatComboSettings settings) {
		task.setInput(settings);
		if (current != null) {
			task.setSelection(new StructuredSelection(settings.getValue()));
		}
		task.setEnabled(false);
		task.setToolTipText(GraalMessages.TaskReference_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#setTask(EObject newValue)
	 * 
	 */
	public void setTask(EObject newValue) {
		if (newValue != null) {
			task.setSelection(new StructuredSelection(newValue));
		} else {
			task.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		task.setEnabled(false);
		task.setToolTipText(GraalMessages.TaskReference_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#setTaskButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTaskButtonMode(ButtonsModeEnum newValue) {
		task.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#addFilterTask(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTask(ViewerFilter filter) {
		task.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#addBusinessFilterTask(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTask(ViewerFilter filter) {
		task.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.TaskReference.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(GraalMessages.TaskReference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#initOutgoingTransitions(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initOutgoingTransitions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		outgoingTransitions.setContentProvider(contentProvider);
		outgoingTransitions.setInput(settings);
		outgoingTransitionsBusinessFilters.clear();
		outgoingTransitionsFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.TaskReference.Properties.outgoingTransitions);
		if (eefElementEditorReadOnlyState && outgoingTransitions.getTable().isEnabled()) {
			outgoingTransitions.setEnabled(false);
			outgoingTransitions.setToolTipText(GraalMessages.TaskReference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outgoingTransitions.getTable().isEnabled()) {
			outgoingTransitions.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#updateOutgoingTransitions()
	 * 
	 */
	public void updateOutgoingTransitions() {
	outgoingTransitions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#addFilterOutgoingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOutgoingTransitions(ViewerFilter filter) {
		outgoingTransitionsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#addBusinessFilterOutgoingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOutgoingTransitions(ViewerFilter filter) {
		outgoingTransitionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#isContainedInOutgoingTransitionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOutgoingTransitionsTable(EObject element) {
		return ((ReferencesTableSettings)outgoingTransitions.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#initIncomingTransitions(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initIncomingTransitions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		incomingTransitions.setContentProvider(contentProvider);
		incomingTransitions.setInput(settings);
		incomingTransitionsBusinessFilters.clear();
		incomingTransitionsFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalViewsRepository.TaskReference.Properties.incomingTransitions);
		if (eefElementEditorReadOnlyState && incomingTransitions.getTable().isEnabled()) {
			incomingTransitions.setEnabled(false);
			incomingTransitions.setToolTipText(GraalMessages.TaskReference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !incomingTransitions.getTable().isEnabled()) {
			incomingTransitions.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#updateIncomingTransitions()
	 * 
	 */
	public void updateIncomingTransitions() {
	incomingTransitions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#addFilterIncomingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIncomingTransitions(ViewerFilter filter) {
		incomingTransitionsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#addBusinessFilterIncomingTransitions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIncomingTransitions(ViewerFilter filter) {
		incomingTransitionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.TaskReferencePropertiesEditionPart#isContainedInIncomingTransitionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInIncomingTransitionsTable(EObject element) {
		return ((ReferencesTableSettings)incomingTransitions.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.TaskReference_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
