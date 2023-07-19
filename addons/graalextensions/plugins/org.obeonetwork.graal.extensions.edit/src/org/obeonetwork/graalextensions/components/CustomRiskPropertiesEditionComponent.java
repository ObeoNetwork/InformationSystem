/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.components;

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
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

import org.obeonetwork.graalextensions.BenefitsLevel;
import org.obeonetwork.graalextensions.DrawbacksLevel;
import org.obeonetwork.graalextensions.GraalExtensionsFactory;
import org.obeonetwork.graalextensions.GraalExtensionsPackage;
import org.obeonetwork.graalextensions.Risk;
import org.obeonetwork.graalextensions.RiskLevel;
import org.obeonetwork.graalextensions.parts.CustomEEFEditorSettings;
import org.obeonetwork.graalextensions.parts.GraalextensionsViewsRepository;
import org.obeonetwork.graalextensions.parts.RiskPropertiesEditionPart;


/**
 * @author Obeo
 * 
 */
public class CustomRiskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String RISK_PART = "Risk"; //$NON-NLS-1$

	
	/**
	 * Settings for benefits editor
	 */
	protected CustomEEFEditorSettings benefitsSettings = new CustomEEFEditorSettings(
			(EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, GraalExtensionsPackage.eINSTANCE.getRisk_Benefits())
				.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas())
				.index(0).build())
				.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas())
				.index(0)
				.discriminator(GraalExtensionsPackage.Literals.RISK).build())
				.build(),
				GraalExtensionsPackage.eINSTANCE.getRisk_Benefits(),
				(DomainPropertiesEditionContext)editingContext);
	
	/**
	 * Settings for drawbacks editor
	 */
	protected CustomEEFEditorSettings drawbacksSettings = new CustomEEFEditorSettings(
			(EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks())
				.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas())
				.index(0).build())
				.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas())
				.index(0)
				.discriminator(GraalExtensionsPackage.Literals.RISK).build())
				.build(),
				GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks(),
				(DomainPropertiesEditionContext)editingContext);
	
	/**
	 * Settings for risk editor
	 */
	protected CustomEEFEditorSettings riskSettings = new CustomEEFEditorSettings(
			(EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, GraalExtensionsPackage.eINSTANCE.getRisk_Risk())
				.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Metadatas())
				.index(0).build())
				.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getMetaDataContainer_Metadatas())
				.index(0)
				.discriminator(GraalExtensionsPackage.Literals.RISK).build())
				.build(),
				GraalExtensionsPackage.eINSTANCE.getRisk_Risk(),
				(DomainPropertiesEditionContext)editingContext);
	
	/**
	 * Default constructor
	 * 
	 */
	public CustomRiskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject obeoDSMObject, String editing_mode) {
		super(editingContext, obeoDSMObject, editing_mode);
		parts = new String[] { RISK_PART };
		repositoryKey = GraalextensionsViewsRepository.class;
		partKey = GraalextensionsViewsRepository.Risk.class;
	}

	
	private Risk getRiskObject(EObject element) {
		if (element instanceof ObeoDSMObject) {
			ObeoDSMObject obeoDSMObject = (ObeoDSMObject)element;
			if (obeoDSMObject.getMetadatas() != null) {
				for (Object metadata : obeoDSMObject.getMetadatas().getMetadatas()) {
					if (metadata instanceof Risk) {
						return (Risk)metadata;
					}
				}
			}
		}
		return null;
	}
	
	private Risk createRiskObject(EObject element) {
		if (element instanceof ObeoDSMObject) {
			ObeoDSMObject obeoDSMObject = (ObeoDSMObject)element;
			MetaDataContainer container = obeoDSMObject.getMetadatas();
			if (container == null) {
				container = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
				obeoDSMObject.setMetadatas(container);
			}
			Risk newRisk = GraalExtensionsFactory.eINSTANCE.createRisk();
			container.getMetadatas().add(newRisk);
			return newRisk;
		}
		return null;
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
			final ObeoDSMObject obeoDSMObject = (ObeoDSMObject)elt;
			final Risk riskObject = getRiskObject(obeoDSMObject);
			final RiskPropertiesEditionPart riskPart = (RiskPropertiesEditionPart)editingPart;
			// init values
			if (riskObject != null) {
				if (benefitsSettings.getSignificantObject() != null && isAccessible(GraalextensionsViewsRepository.Risk.Properties.benefits)) {
					riskPart.initBenefits(EEFUtils.choiceOfValues(benefitsSettings.getSignificantObject(), GraalExtensionsPackage.eINSTANCE.getRisk_Benefits()), (Enumerator)benefitsSettings.getValue());
				}
				if (drawbacksSettings.getSignificantObject() != null && isAccessible(GraalextensionsViewsRepository.Risk.Properties.drawbacks)) {
					riskPart.initDrawbacks(EEFUtils.choiceOfValues(drawbacksSettings.getSignificantObject(), GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks()), (Enumerator)drawbacksSettings.getValue());
				}
				if (riskSettings.getSignificantObject() != null && isAccessible(GraalextensionsViewsRepository.Risk.Properties.risk_)) {
					riskPart.initRisk(EEFUtils.choiceOfValues(riskSettings.getSignificantObject(), GraalExtensionsPackage.eINSTANCE.getRisk_Risk()), (Enumerator)riskSettings.getValue());
				}
			} else {
				riskPart.initBenefits(BenefitsLevel.values(), BenefitsLevel.UNDEFINED);
				riskPart.initDrawbacks(DrawbacksLevel.values(), DrawbacksLevel.UNDEFINED);
				riskPart.initRisk(RiskLevel.values(), RiskLevel.UNDEFINED);
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
		if (getRiskObject(semanticObject) != null) {
			if (event.getAffectedEditor() == GraalextensionsViewsRepository.Risk.Properties.benefits) {
				return (benefitsSettings.getValue() == null) ? (event.getNewValue() != null) : (!benefitsSettings.getValue().equals(event.getNewValue()));
			}
			if (event.getAffectedEditor() == GraalextensionsViewsRepository.Risk.Properties.drawbacks) {
				return (drawbacksSettings.getValue() == null) ? (event.getNewValue() != null) : (!drawbacksSettings.getValue().equals(event.getNewValue()));
			}
			if (event.getAffectedEditor() == GraalextensionsViewsRepository.Risk.Properties.risk_) {
				return (riskSettings.getValue() == null) ? (event.getNewValue() != null) : (!riskSettings.getValue().equals(event.getNewValue()));
			}
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
			
			Risk riskObject = getRiskObject(semanticObject);
			if (riskObject == null) {
				riskObject = createRiskObject(semanticObject);
			}
			benefitsSettings.setValue((BenefitsLevel)event.getNewValue());
		}
		if (GraalextensionsViewsRepository.Risk.Properties.drawbacks == event.getAffectedEditor()) {
			Risk riskObject = getRiskObject(semanticObject);
			if (riskObject == null) {
				createRiskObject(semanticObject);
			}
			drawbacksSettings.setValue((DrawbacksLevel)event.getNewValue());
		}
		if (GraalextensionsViewsRepository.Risk.Properties.risk_ == event.getAffectedEditor()) {
			Risk riskObject = getRiskObject(semanticObject);
			if (riskObject == null) {
				createRiskObject(semanticObject);
			}
			riskSettings.setValue((RiskLevel)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			RiskPropertiesEditionPart riskPart = (RiskPropertiesEditionPart)editingPart;
			if (GraalExtensionsPackage.eINSTANCE.getRisk_Benefits().equals(msg.getFeature()) && isAccessible(GraalextensionsViewsRepository.Risk.Properties.benefits))
				riskPart.setBenefits((BenefitsLevel)msg.getNewValue());
			
			if (GraalExtensionsPackage.eINSTANCE.getRisk_Drawbacks().equals(msg.getFeature()) && isAccessible(GraalextensionsViewsRepository.Risk.Properties.drawbacks))
				riskPart.setDrawbacks((DrawbacksLevel)msg.getNewValue());
			
			if (GraalExtensionsPackage.eINSTANCE.getRisk_Risk().equals(msg.getFeature()) && isAccessible(GraalextensionsViewsRepository.Risk.Properties.risk_))
				riskPart.setRisk((RiskLevel)msg.getNewValue());
			
			
		}
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
	 * @ return settings for benefits editor
	 */
	public CustomEEFEditorSettings getBenefitsSettings() {
			return benefitsSettings;
	}
	/**
	 * @ return settings for drawbacks editor
	 */
	public CustomEEFEditorSettings getDrawbacksSettings() {
			return drawbacksSettings;
	}
	/**
	 * @ return settings for risk editor
	 */
	public CustomEEFEditorSettings getRiskSettings() {
			return riskSettings;
	}
}
