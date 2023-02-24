/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.dsl.requirement.parts.impl;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FlatReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.providers.RequirementMessages;

// End of user code

/**
 * 
 * 
 */
public class AdvancedPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AdvancedPropertiesEditionPart {

	protected Text rationale;
	protected Text acceptanceCriteria;
	protected FlatReferencesTable referencedObject;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AdvancedPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence advancedStep = new BindingCompositionSequence(propertiesEditionComponent);
		advancedStep.addStep(RequirementViewsRepository.Advanced.rationale);
		advancedStep.addStep(RequirementViewsRepository.Advanced.acceptanceCriteria);
		advancedStep.addStep(RequirementViewsRepository.Advanced.referencedObject);
		
		composer = new PartComposer(advancedStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == RequirementViewsRepository.Advanced.rationale) {
					return createRationaleTextarea(parent);
				}
				if (key == RequirementViewsRepository.Advanced.acceptanceCriteria) {
					return createAcceptanceCriteriaTextarea(parent);
				}
				if (key == RequirementViewsRepository.Advanced.referencedObject) {
					return createReferencedObjectFlatReferencesTable(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	
	protected Composite createRationaleTextarea(Composite parent) {
		Label rationaleLabel = createDescription(parent, RequirementViewsRepository.Advanced.rationale, RequirementMessages.AdvancedPropertiesEditionPart_RationaleLabel);
		GridData rationaleLabelData = new GridData(GridData.FILL_HORIZONTAL);
		rationaleLabelData.horizontalSpan = 3;
		rationaleLabel.setLayoutData(rationaleLabelData);
		rationale = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData rationaleData = new GridData(GridData.FILL_HORIZONTAL);
		rationaleData.horizontalSpan = 2;
		rationaleData.heightHint = 80;
		rationaleData.widthHint = 200;
		rationale.setLayoutData(rationaleData);
		rationale.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedPropertiesEditionPartImpl.this, RequirementViewsRepository.Advanced.rationale, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rationale.getText()));
			}

		});
		EditingUtils.setID(rationale, RequirementViewsRepository.Advanced.rationale);
		EditingUtils.setEEFtype(rationale, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Advanced.rationale, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRationaleTextArea

		// End of user code
		return parent;
	}

	
	protected Composite createAcceptanceCriteriaTextarea(Composite parent) {
		Label acceptanceCriteriaLabel = createDescription(parent, RequirementViewsRepository.Advanced.acceptanceCriteria, RequirementMessages.AdvancedPropertiesEditionPart_AcceptanceCriteriaLabel);
		GridData acceptanceCriteriaLabelData = new GridData(GridData.FILL_HORIZONTAL);
		acceptanceCriteriaLabelData.horizontalSpan = 3;
		acceptanceCriteriaLabel.setLayoutData(acceptanceCriteriaLabelData);
		acceptanceCriteria = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData acceptanceCriteriaData = new GridData(GridData.FILL_HORIZONTAL);
		acceptanceCriteriaData.horizontalSpan = 2;
		acceptanceCriteriaData.heightHint = 80;
		acceptanceCriteriaData.widthHint = 200;
		acceptanceCriteria.setLayoutData(acceptanceCriteriaData);
		acceptanceCriteria.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedPropertiesEditionPartImpl.this, RequirementViewsRepository.Advanced.acceptanceCriteria, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, acceptanceCriteria.getText()));
			}

		});
		EditingUtils.setID(acceptanceCriteria, RequirementViewsRepository.Advanced.acceptanceCriteria);
		EditingUtils.setEEFtype(acceptanceCriteria, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Advanced.acceptanceCriteria, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAcceptanceCriteriaTextArea

		// End of user code
		return parent;
	}

	/**
	 * @param parent
	 * 
	 */
	protected Composite createReferencedObjectFlatReferencesTable(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Advanced.referencedObject, RequirementMessages.AdvancedPropertiesEditionPart_ReferencedObjectLabel);
		referencedObject = new FlatReferencesTable(parent);
		referencedObject.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		referencedObject.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof StructuredSelection) 
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedPropertiesEditionPartImpl.this, RequirementViewsRepository.Advanced.referencedObject, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ((StructuredSelection)event.getSelection()).toList()));
			}

		});
		GridData referencedObjectData = new GridData(GridData.FILL_HORIZONTAL);
		referencedObject.setLayoutData(referencedObjectData);
		referencedObject.setID(RequirementViewsRepository.Advanced.referencedObject);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Advanced.referencedObject, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReferencedObjectFlatReferencesTable

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
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#getRationale()
	 * 
	 */
	public String getRationale() {
		return rationale.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#setRationale(String newValue)
	 * 
	 */
	public void setRationale(String newValue) {
		if (newValue != null) {
			rationale.setText(newValue);
		} else {
			rationale.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Advanced.rationale);
		if (eefElementEditorReadOnlyState && rationale.isEnabled()) {
			rationale.setEnabled(false);
			rationale.setBackground(rationale.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			rationale.setToolTipText(RequirementMessages.Advanced_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rationale.isEnabled()) {
			rationale.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#getAcceptanceCriteria()
	 * 
	 */
	public String getAcceptanceCriteria() {
		return acceptanceCriteria.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#setAcceptanceCriteria(String newValue)
	 * 
	 */
	public void setAcceptanceCriteria(String newValue) {
		if (newValue != null) {
			acceptanceCriteria.setText(newValue);
		} else {
			acceptanceCriteria.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Advanced.acceptanceCriteria);
		if (eefElementEditorReadOnlyState && acceptanceCriteria.isEnabled()) {
			acceptanceCriteria.setEnabled(false);
			acceptanceCriteria.setBackground(acceptanceCriteria.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			acceptanceCriteria.setToolTipText(RequirementMessages.Advanced_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !acceptanceCriteria.isEnabled()) {
			acceptanceCriteria.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#initReferencedObject(ReferencesTableSettings)
	 */
	public void initReferencedObject(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		referencedObject.setInput(settings);
		referencedObject.setEnabled(false);
		referencedObject.setToolTipText(RequirementMessages.Advanced_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#updateReferencedObject()
	 * 
	 */
	public void updateReferencedObject() {
	referencedObject.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#addFilterReferencedObject(ViewerFilter filter)
	 * 
	 */
	public void addFilterToReferencedObject(ViewerFilter filter) {
		referencedObject.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#addBusinessFilterReferencedObject(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToReferencedObject(ViewerFilter filter) {
		referencedObject.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart#isContainedInReferencedObjectTable(EObject element)
	 * 
	 */
	public boolean isContainedInReferencedObjectTable(EObject element) {
		return ((ReferencesTableSettings)referencedObject.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return RequirementMessages.Advanced_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
