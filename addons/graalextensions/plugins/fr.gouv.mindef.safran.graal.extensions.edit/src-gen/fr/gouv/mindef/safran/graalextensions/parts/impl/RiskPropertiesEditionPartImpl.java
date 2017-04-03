/**
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
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
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import fr.gouv.mindef.safran.graalextensions.components.RiskPropertiesEditionComponent;
import fr.gouv.mindef.safran.graalextensions.parts.GraalextensionsViewsRepository;
import fr.gouv.mindef.safran.graalextensions.parts.RiskPropertiesEditionPart;
import fr.gouv.mindef.safran.graalextensions.providers.GraalextensionsMessages;

// End of user code

/**
 * @author Obeo.fr
 * 
 */
public class RiskPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RiskPropertiesEditionPart {

	protected EMFComboViewer benefits;
	protected EMFComboViewer drawbacks;
	protected EMFComboViewer risk;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RiskPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence riskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = riskStep.addStep(GraalextensionsViewsRepository.Risk.Properties.class);
		propertiesStep.addStep(GraalextensionsViewsRepository.Risk.Properties.benefits);
		propertiesStep.addStep(GraalextensionsViewsRepository.Risk.Properties.drawbacks);
		propertiesStep.addStep(GraalextensionsViewsRepository.Risk.Properties.risk_);
		
		
		composer = new PartComposer(riskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalextensionsViewsRepository.Risk.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalextensionsViewsRepository.Risk.Properties.benefits) {
					return createBenefitsEMFComboViewer(parent);
				}
				if (key == GraalextensionsViewsRepository.Risk.Properties.drawbacks) {
					return createDrawbacksEMFComboViewer(parent);
				}
				if (key == GraalextensionsViewsRepository.Risk.Properties.risk_) {
					return createRiskEMFComboViewer(parent);
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
		propertiesGroup.setText(GraalextensionsMessages.RiskPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createBenefitsEMFComboViewer(Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RiskPropertiesEditionPartImpl.this, GraalextensionsViewsRepository.Risk.Properties.benefits, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getBenefits()));
			}

		});
		benefits.setID(GraalextensionsViewsRepository.Risk.Properties.benefits);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Risk.Properties.benefits, GraalextensionsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBenefitsEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDrawbacksEMFComboViewer(Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RiskPropertiesEditionPartImpl.this, GraalextensionsViewsRepository.Risk.Properties.drawbacks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDrawbacks()));
			}

		});
		drawbacks.setID(GraalextensionsViewsRepository.Risk.Properties.drawbacks);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Risk.Properties.drawbacks, GraalextensionsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDrawbacksEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRiskEMFComboViewer(Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RiskPropertiesEditionPartImpl.this, GraalextensionsViewsRepository.Risk.Properties.risk_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRisk()));
			}

		});
		risk.setID(GraalextensionsViewsRepository.Risk.Properties.risk_);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Risk.Properties.risk_, GraalextensionsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 */
	public void initBenefits(Object input, Enumerator current) {
		benefits.setInput(input);
		benefits.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.benefits, ((RiskPropertiesEditionComponent) propertiesEditionComponent).getBenefitsSettings().getOrCreateSignificantObject());
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
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.benefits, ((RiskPropertiesEditionComponent) propertiesEditionComponent).getBenefitsSettings().getOrCreateSignificantObject());
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
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.drawbacks, ((RiskPropertiesEditionComponent) propertiesEditionComponent).getDrawbacksSettings().getOrCreateSignificantObject());
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
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.drawbacks, ((RiskPropertiesEditionComponent) propertiesEditionComponent).getDrawbacksSettings().getOrCreateSignificantObject());
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
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.risk_, ((RiskPropertiesEditionComponent) propertiesEditionComponent).getRiskSettings().getOrCreateSignificantObject());
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
		boolean eefElementEditorReadOnlyState = isReadOnly(GraalextensionsViewsRepository.Risk.Properties.risk_, ((RiskPropertiesEditionComponent) propertiesEditionComponent).getRiskSettings().getOrCreateSignificantObject());
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
