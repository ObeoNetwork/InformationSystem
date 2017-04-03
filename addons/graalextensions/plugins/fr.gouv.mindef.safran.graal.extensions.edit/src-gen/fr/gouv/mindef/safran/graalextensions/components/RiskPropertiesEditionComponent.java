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
package fr.gouv.mindef.safran.graalextensions.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

import fr.gouv.mindef.safran.graalextensions.BenefitsLevel;
import fr.gouv.mindef.safran.graalextensions.DrawbacksLevel;
import fr.gouv.mindef.safran.graalextensions.GraalExtensionsPackage;
import fr.gouv.mindef.safran.graalextensions.RiskLevel;
import fr.gouv.mindef.safran.graalextensions.parts.GraalextensionsViewsRepository;
import fr.gouv.mindef.safran.graalextensions.parts.RiskPropertiesEditionPart;


// End of user code

/**
 * @author Obeo.fr
 * 
 */
public class RiskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String RISK_PART = "Risk"; //$NON-NLS-1$

	
	
	/**
	 * Settings for benefits editor
	 */
	protected EEFEditorSettingsImpl benefitsSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, GraalExtensionsPackage.eINSTANCE.getRisk_Benefits())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas())
	.index(0).build())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas())
	.index(0)
	.discriminator(GraalExtensionsPackage.Literals.RISK).build())
	.build();
	
	/**
	 * Settings for drawbacks editor
	 */
	protected EEFEditorSettingsImpl drawbacksSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas())
	.index(0).build())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas())
	.index(0)
	.discriminator(GraalExtensionsPackage.Literals.RISK).build())
	.build();
	
	/**
	 * Settings for risk editor
	 */
	protected EEFEditorSettingsImpl riskSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, GraalExtensionsPackage.eINSTANCE.getRisk_Risk())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas())
	.index(0).build())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas())
	.index(0)
	.discriminator(GraalExtensionsPackage.Literals.RISK).build())
	.build();
	
	/**
	 * Default constructor
	 * 
	 */
	public RiskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject obeoDSMObject, String editing_mode) {
		super(editingContext, obeoDSMObject, editing_mode);
		parts = new String[] { RISK_PART };
		repositoryKey = GraalextensionsViewsRepository.class;
		partKey = GraalextensionsViewsRepository.Risk.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			if (editingPart instanceof CompositePropertiesEditionPart) {
				((CompositePropertiesEditionPart) editingPart).getSettings().add(benefitsSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(drawbacksSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(riskSettings);
			}
			final RiskPropertiesEditionPart riskPart = (RiskPropertiesEditionPart)editingPart;
			// init values
			if (benefitsSettings.getSignificantObject() != null && isAccessible(GraalextensionsViewsRepository.Risk.Properties.benefits)) {
				riskPart.initBenefits(EEFUtils.choiceOfValues(benefitsSettings.getSignificantObject(), GraalExtensionsPackage.eINSTANCE.getRisk_Benefits()), (Enumerator)benefitsSettings.getValue());
			}
			if (drawbacksSettings.getSignificantObject() != null && isAccessible(GraalextensionsViewsRepository.Risk.Properties.drawbacks)) {
				riskPart.initDrawbacks(EEFUtils.choiceOfValues(drawbacksSettings.getSignificantObject(), GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks()), (Enumerator)drawbacksSettings.getValue());
			}
			if (riskSettings.getSignificantObject() != null && isAccessible(GraalextensionsViewsRepository.Risk.Properties.risk_)) {
				riskPart.initRisk(EEFUtils.choiceOfValues(riskSettings.getSignificantObject(), GraalExtensionsPackage.eINSTANCE.getRisk_Risk()), (Enumerator)riskSettings.getValue());
			}
			// init filters
			
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}





	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent#shouldProcess(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	protected boolean shouldProcess(IPropertiesEditionEvent event) {
		if (event.getAffectedEditor() == GraalextensionsViewsRepository.Risk.Properties.benefits) {
			return (benefitsSettings.getValue() == null) ? (event.getNewValue() != null) : (!benefitsSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == GraalextensionsViewsRepository.Risk.Properties.drawbacks) {
			return (drawbacksSettings.getValue() == null) ? (event.getNewValue() != null) : (!drawbacksSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == GraalextensionsViewsRepository.Risk.Properties.risk_) {
			return (riskSettings.getValue() == null) ? (event.getNewValue() != null) : (!riskSettings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		if (GraalextensionsViewsRepository.Risk.Properties.benefits == event.getAffectedEditor()) {
			benefitsSettings.setValue((BenefitsLevel)event.getNewValue());
		}
		if (GraalextensionsViewsRepository.Risk.Properties.drawbacks == event.getAffectedEditor()) {
			drawbacksSettings.setValue((DrawbacksLevel)event.getNewValue());
		}
		if (GraalextensionsViewsRepository.Risk.Properties.risk_ == event.getAffectedEditor()) {
			riskSettings.setValue((RiskLevel)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RiskPropertiesEditionPart riskPart = (RiskPropertiesEditionPart)editingPart;
			if (benefitsSettings.isAffectingEvent(msg) && isAccessible(GraalextensionsViewsRepository.Risk.Properties.benefits))
				riskPart.setBenefits((BenefitsLevel)msg.getNewValue());
			
			if (drawbacksSettings.isAffectingEvent(msg) && isAccessible(GraalextensionsViewsRepository.Risk.Properties.drawbacks))
				riskPart.setDrawbacks((DrawbacksLevel)msg.getNewValue());
			
			if (riskSettings.isAffectingEvent(msg) && isAccessible(GraalextensionsViewsRepository.Risk.Properties.risk_))
				riskPart.setRisk((RiskLevel)msg.getNewValue());
			
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			GraalExtensionsPackage.eINSTANCE.getRisk_Benefits()
			,
			GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks()
			,
			GraalExtensionsPackage.eINSTANCE.getRisk_Risk()
					);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (GraalextensionsViewsRepository.Risk.Properties.benefits == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalExtensionsPackage.eINSTANCE.getRisk_Benefits().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalExtensionsPackage.eINSTANCE.getRisk_Benefits().getEAttributeType(), newValue);
				}
				if (GraalextensionsViewsRepository.Risk.Properties.drawbacks == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks().getEAttributeType(), newValue);
				}
				if (GraalextensionsViewsRepository.Risk.Properties.risk_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalExtensionsPackage.eINSTANCE.getRisk_Risk().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalExtensionsPackage.eINSTANCE.getRisk_Risk().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	
	/**
	 * @ return settings for benefits editor
	 */
	public EEFEditorSettingsImpl getBenefitsSettings() {
			return benefitsSettings;
	}
	/**
	 * @ return settings for drawbacks editor
	 */
	public EEFEditorSettingsImpl getDrawbacksSettings() {
			return drawbacksSettings;
	}
	/**
	 * @ return settings for risk editor
	 */
	public EEFEditorSettingsImpl getRiskSettings() {
			return riskSettings;
	}

}
