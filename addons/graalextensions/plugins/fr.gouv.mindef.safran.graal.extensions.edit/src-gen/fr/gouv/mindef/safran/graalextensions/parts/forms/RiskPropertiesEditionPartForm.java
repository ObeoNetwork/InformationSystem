/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

import fr.gouv.mindef.safran.graalextensions.components.CustomRiskPropertiesEditionComponent;
import fr.gouv.mindef.safran.graalextensions.parts.GraalextensionsViewsRepository;
import fr.gouv.mindef.safran.graalextensions.parts.RiskPropertiesEditionPart;
import fr.gouv.mindef.safran.graalextensions.providers.GraalextensionsMessages;

// End of user code

/**
 * @author Obeo.fr
 * 
 */
public class RiskPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RiskPropertiesEditionPart {

	protected EMFComboViewer benefits;
	protected EMFComboViewer drawbacks;
	protected EMFComboViewer risk;



	/**
	 * For {@link ISection} use only.
	 */
	public RiskPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RiskPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence riskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = riskStep.addStep(GraalextensionsViewsRepository.Risk.Properties.class);
		propertiesStep.addStep(GraalextensionsViewsRepository.Risk.Properties.benefits);
		propertiesStep.addStep(GraalextensionsViewsRepository.Risk.Properties.drawbacks);
		propertiesStep.addStep(GraalextensionsViewsRepository.Risk.Properties.risk_);
		
		
		composer = new PartComposer(riskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalextensionsViewsRepository.Risk.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == GraalextensionsViewsRepository.Risk.Properties.benefits) {
					return createBenefitsEMFComboViewer(widgetFactory, parent);
				}
				if (key == GraalextensionsViewsRepository.Risk.Properties.drawbacks) {
					return createDrawbacksEMFComboViewer(widgetFactory, parent);
				}
				if (key == GraalextensionsViewsRepository.Risk.Properties.risk_) {
					return createRiskEMFComboViewer(widgetFactory, parent);
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
		propertiesSection.setText(GraalextensionsMessages.RiskPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createBenefitsEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Risk.Properties.benefits, GraalextensionsMessages.RiskPropertiesEditionPart_BenefitsLabel);
		benefits = new EMFComboViewer(parent);
		benefits.setContentProvider(new ArrayContentProvider());
		benefits.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData benefitsData = new GridData(GridData.FILL_HORIZONTAL);
		benefits.getCombo().setLayoutData(benefitsData);
		benefits.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RiskPropertiesEditionPartForm.this, GraalextensionsViewsRepository.Risk.Properties.benefits, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getBenefits()));
			}

		});
		benefits.setID(GraalextensionsViewsRepository.Risk.Properties.benefits);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Risk.Properties.benefits, GraalextensionsViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBenefitsEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDrawbacksEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Risk.Properties.drawbacks, GraalextensionsMessages.RiskPropertiesEditionPart_DrawbacksLabel);
		drawbacks = new EMFComboViewer(parent);
		drawbacks.setContentProvider(new ArrayContentProvider());
		drawbacks.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData drawbacksData = new GridData(GridData.FILL_HORIZONTAL);
		drawbacks.getCombo().setLayoutData(drawbacksData);
		drawbacks.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RiskPropertiesEditionPartForm.this, GraalextensionsViewsRepository.Risk.Properties.drawbacks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDrawbacks()));
			}

		});
		drawbacks.setID(GraalextensionsViewsRepository.Risk.Properties.drawbacks);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Risk.Properties.drawbacks, GraalextensionsViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDrawbacksEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRiskEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Risk.Properties.risk_, GraalextensionsMessages.RiskPropertiesEditionPart_RiskLabel);
		risk = new EMFComboViewer(parent);
		risk.setContentProvider(new ArrayContentProvider());
		risk.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData riskData = new GridData(GridData.FILL_HORIZONTAL);
		risk.getCombo().setLayoutData(riskData);
		risk.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RiskPropertiesEditionPartForm.this, GraalextensionsViewsRepository.Risk.Properties.risk_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRisk()));
			}

		});
		risk.setID(GraalextensionsViewsRepository.Risk.Properties.risk_);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Risk.Properties.risk_, GraalextensionsViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRiskEMFComboViewer

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
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#getBenefits()
	 * 
	 */
	public Enumerator getBenefits() {
		Enumerator selection = (Enumerator) ((StructuredSelection) benefits.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#initBenefits(Object input, Enumerator current)
	 * @generated NOT
	 */
	public void initBenefits(Object input, Enumerator current) {
		benefits.setInput(input);
		benefits.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.benefits, ((CustomRiskPropertiesEditionComponent) propertiesEditionComponent).getBenefitsSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && benefits.isEnabled()) {
			benefits.setEnabled(false);
			benefits.setToolTipText(GraalextensionsMessages.Risk_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !benefits.isEnabled()) {
			benefits.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#setBenefits(Enumerator newValue)
	 * 
	 */
	public void setBenefits(Enumerator newValue) {
		benefits.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.benefits, ((CustomRiskPropertiesEditionComponent) propertiesEditionComponent).getBenefitsSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && benefits.isEnabled()) {
			benefits.setEnabled(false);
			benefits.setToolTipText(GraalextensionsMessages.Risk_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !benefits.isEnabled()) {
			benefits.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#getDrawbacks()
	 * 
	 */
	public Enumerator getDrawbacks() {
		Enumerator selection = (Enumerator) ((StructuredSelection) drawbacks.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#initDrawbacks(Object input, Enumerator current)
	 */
	public void initDrawbacks(Object input, Enumerator current) {
		drawbacks.setInput(input);
		drawbacks.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.drawbacks, ((CustomRiskPropertiesEditionComponent) propertiesEditionComponent).getDrawbacksSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && drawbacks.isEnabled()) {
			drawbacks.setEnabled(false);
			drawbacks.setToolTipText(GraalextensionsMessages.Risk_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !drawbacks.isEnabled()) {
			drawbacks.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#setDrawbacks(Enumerator newValue)
	 * 
	 */
	public void setDrawbacks(Enumerator newValue) {
		drawbacks.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.drawbacks, ((CustomRiskPropertiesEditionComponent) propertiesEditionComponent).getDrawbacksSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && drawbacks.isEnabled()) {
			drawbacks.setEnabled(false);
			drawbacks.setToolTipText(GraalextensionsMessages.Risk_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !drawbacks.isEnabled()) {
			drawbacks.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#getRisk()
	 * 
	 */
	public Enumerator getRisk() {
		Enumerator selection = (Enumerator) ((StructuredSelection) risk.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#initRisk(Object input, Enumerator current)
	 */
	public void initRisk(Object input, Enumerator current) {
		risk.setInput(input);
		risk.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.risk_, ((CustomRiskPropertiesEditionComponent) propertiesEditionComponent).getRiskSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && risk.isEnabled()) {
			risk.setEnabled(false);
			risk.setToolTipText(GraalextensionsMessages.Risk_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !risk.isEnabled()) {
			risk.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.RiskPropertiesEditionPart#setRisk(Enumerator newValue)
	 * 
	 */
	public void setRisk(Enumerator newValue) {
		risk.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.risk_, ((CustomRiskPropertiesEditionComponent) propertiesEditionComponent).getRiskSettings().getOrCreateSignificantObject());
		if (eefElementEditorReadOnlyState && risk.isEnabled()) {
			risk.setEnabled(false);
			risk.setToolTipText(GraalextensionsMessages.Risk_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !risk.isEnabled()) {
			risk.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalextensionsMessages.Risk_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
