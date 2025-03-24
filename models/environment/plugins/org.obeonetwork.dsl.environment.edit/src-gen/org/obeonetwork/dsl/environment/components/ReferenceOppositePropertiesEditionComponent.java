/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;

import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;

import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFFilter;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInitializer;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;

import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Reference;

import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.OppositePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ReferenceOppositePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String OPPOSITE_PART = "Opposite"; //$NON-NLS-1$

	
	
	/**
	 * Settings for oppositeName editor
	 */
	protected EEFEditorSettingsImpl oppositeNameSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EnvironmentPackage.eINSTANCE.getProperty_Name())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getReference_OppositeOf())
	.index(0).build())
	.build();
	
	/**
	 * Settings for oppositeReferencedType editor
	 */
	protected EEFEditorSettingsImpl oppositeReferencedTypeSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EnvironmentPackage.eINSTANCE.getReference_ReferencedType())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getReference_OppositeOf())
	.index(0).build())
	.build();
	
	/**
	 * Settings for oppositeMultiplicity editor
	 */
	protected EEFEditorSettingsImpl oppositeMultiplicitySettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EnvironmentPackage.eINSTANCE.getProperty_Multiplicity())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getReference_OppositeOf())
	.index(0).build())
	.build();
	
	/**
	 * Settings for oppositeIsComposite editor
	 */
	protected EEFEditorSettingsImpl oppositeIsCompositeSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EnvironmentPackage.eINSTANCE.getReference_IsComposite())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getReference_OppositeOf())
	.index(0).build())
	.build();
	
	/**
	 * Settings for oppositeNavigable editor
	 */
	protected EEFEditorSettingsImpl oppositeNavigableSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EnvironmentPackage.eINSTANCE.getReference_Navigable())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getReference_OppositeOf())
	.index(0).build())
	.build();
	
	/**
	 * Settings for oppositeIdentifier editor
	 */
	protected EEFEditorSettingsImpl oppositeIdentifierSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getReference_OppositeOf())
	.index(0).build())
	.build();
	
	/**
	 * Settings for oppositeDescription editor
	 */
	protected EEFEditorSettingsImpl oppositeDescriptionSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description())
	.nextStep(NavigationStepBuilder.create(EnvironmentPackage.eINSTANCE.getReference_OppositeOf())
	.index(0).build())
	.build();
	
	/**
	 * Default constructor
	 * 
	 */
	public ReferenceOppositePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject reference, String editing_mode) {
		super(editingContext, reference, editing_mode);
		parts = new String[] { OPPOSITE_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.Opposite.class;
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
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeNameSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeReferencedTypeSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeMultiplicitySettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeIsCompositeSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeNavigableSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeIdentifierSettings);
				((CompositePropertiesEditionPart) editingPart).getSettings().add(oppositeDescriptionSettings);
			}
			final Reference reference = (Reference)elt;
			final OppositePropertiesEditionPart oppositePart = (OppositePropertiesEditionPart)editingPart;
			// init values
			if (oppositeNameSettings.getValue() != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.name))
				oppositePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, oppositeNameSettings.getValue()));
			
			// FIXME NO VALID CASE INTO template public updater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : oppositeReferencedType, Opposite, reference.
			if (oppositeMultiplicitySettings.getSignificantObject() != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.multiplicity)) {
				oppositePart.initMultiplicity(EEFUtils.choiceOfValues(oppositeMultiplicitySettings.getSignificantObject(), EnvironmentPackage.eINSTANCE.getProperty_Multiplicity()), (Enumerator)oppositeMultiplicitySettings.getValue());
			}
			if (isAccessible(EnvironmentViewsRepository.Opposite.Properties.isComposite)) {
				oppositePart.setIsComposite((Boolean)oppositeIsCompositeSettings.getValue());
			}
			if (isAccessible(EnvironmentViewsRepository.Opposite.Properties.navigable)) {
				oppositePart.setNavigable((Boolean)oppositeNavigableSettings.getValue());
			}
			if (isAccessible(EnvironmentViewsRepository.Opposite.Properties.identifier)) {
				oppositePart.setIdentifier((Boolean)oppositeIdentifierSettings.getValue());
			}
			if (oppositeDescriptionSettings.getValue() != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.description))
				oppositePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, oppositeDescriptionSettings.getValue()));
			// init filters
			
			// FIXME NO VALID CASE INTO template public filterUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : oppositeReferencedType, Opposite, reference.
			
			
			
			
			
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
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Opposite.Properties.name) {
			return (oppositeNameSettings.getValue() == null) ? (event.getNewValue() != null) : (!oppositeNameSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Opposite.Properties.referencedType) {
			return (oppositeReferencedTypeSettings.getValue() == null) ? (event.getNewValue() != null) : (!oppositeReferencedTypeSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Opposite.Properties.multiplicity) {
			return (oppositeMultiplicitySettings.getValue() == null) ? (event.getNewValue() != null) : (!oppositeMultiplicitySettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Opposite.Properties.isComposite) {
			return (oppositeIsCompositeSettings.getValue() == null) ? (event.getNewValue() != null) : (!oppositeIsCompositeSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Opposite.Properties.navigable) {
			return (oppositeNavigableSettings.getValue() == null) ? (event.getNewValue() != null) : (!oppositeNavigableSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Opposite.Properties.identifier) {
			return (oppositeIdentifierSettings.getValue() == null) ? (event.getNewValue() != null) : (!oppositeIdentifierSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EnvironmentViewsRepository.Opposite.Properties.description) {
			return (oppositeDescriptionSettings.getValue() == null) ? (event.getNewValue() != null) : (!oppositeDescriptionSettings.getValue().equals(event.getNewValue()));
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
		Reference reference = (Reference)semanticObject;
		if (EnvironmentViewsRepository.Opposite.Properties.name == event.getAffectedEditor()) {
			oppositeNameSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.Opposite.Properties.multiplicity == event.getAffectedEditor()) {
			oppositeMultiplicitySettings.setValue((MultiplicityKind)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Opposite.Properties.isComposite == event.getAffectedEditor()) {
			oppositeIsCompositeSettings.setValue((Boolean)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Opposite.Properties.navigable == event.getAffectedEditor()) {
			oppositeNavigableSettings.setValue((Boolean)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Opposite.Properties.identifier == event.getAffectedEditor()) {
			oppositeIdentifierSettings.setValue((Boolean)event.getNewValue());
		}
		if (EnvironmentViewsRepository.Opposite.Properties.description == event.getAffectedEditor()) {
			oppositeDescriptionSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			OppositePropertiesEditionPart oppositePart = (OppositePropertiesEditionPart)editingPart;
			if (!(msg.getNewValue() instanceof EObject) && oppositeNameSettings.isAffectingEvent(msg) && oppositePart != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.name)) {
				if (msg.getNewValue() != null) {
					oppositePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					oppositePart.setName("");
				}
			}
			// FIXME INVALID CASE INTO template public liveUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : oppositeReferencedType, Opposite, reference.
			if (oppositeMultiplicitySettings.isAffectingEvent(msg) && isAccessible(EnvironmentViewsRepository.Opposite.Properties.multiplicity))
				oppositePart.setMultiplicity((MultiplicityKind)msg.getNewValue());
			
			if (oppositeIsCompositeSettings.isAffectingEvent(msg) && oppositePart != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.isComposite))
				oppositePart.setIsComposite((Boolean)msg.getNewValue());
			
			if (oppositeNavigableSettings.isAffectingEvent(msg) && oppositePart != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.navigable))
				oppositePart.setNavigable((Boolean)msg.getNewValue());
			
			if (oppositeIdentifierSettings.isAffectingEvent(msg) && oppositePart != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.identifier))
				oppositePart.setIdentifier((Boolean)msg.getNewValue());
			
			if (!(msg.getNewValue() instanceof EObject) && oppositeDescriptionSettings.isAffectingEvent(msg) && oppositePart != null && isAccessible(EnvironmentViewsRepository.Opposite.Properties.description)){
				if (msg.getNewValue() != null) {
					oppositePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					oppositePart.setDescription("");
				}
			}
			
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
			EnvironmentPackage.eINSTANCE.getProperty_Name()
			,
			EnvironmentPackage.eINSTANCE.getReference_ReferencedType()
			,
			EnvironmentPackage.eINSTANCE.getProperty_Multiplicity()
			,
			EnvironmentPackage.eINSTANCE.getReference_IsComposite()
			,
			EnvironmentPackage.eINSTANCE.getReference_Navigable()
			,
			EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier()
			,
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description()
					);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EnvironmentViewsRepository.Reference.Properties.referencedType || key == EnvironmentViewsRepository.Reference.Properties.isComposite || key == EnvironmentViewsRepository.Reference.Properties.navigable || key == EnvironmentViewsRepository.Opposite.Properties.referencedType || key == EnvironmentViewsRepository.Opposite.Properties.isComposite || key == EnvironmentViewsRepository.Opposite.Properties.navigable;
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
				if (EnvironmentViewsRepository.Opposite.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getProperty_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getProperty_Name().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Opposite.Properties.multiplicity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getProperty_Multiplicity().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getProperty_Multiplicity().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Opposite.Properties.isComposite == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getReference_IsComposite().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getReference_IsComposite().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Opposite.Properties.navigable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getReference_Navigable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getReference_Navigable().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Opposite.Properties.identifier == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Opposite.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
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
	 * @ return settings for oppositeName editor
	 */
	public EEFEditorSettingsImpl getOppositeNameSettings() {
			return oppositeNameSettings;
	}
	/**
	 * @ return settings for oppositeReferencedType editor
	 */
	public EEFEditorSettingsImpl getOppositeReferencedTypeSettings() {
			return oppositeReferencedTypeSettings;
	}
	/**
	 * @ return settings for oppositeMultiplicity editor
	 */
	public EEFEditorSettingsImpl getOppositeMultiplicitySettings() {
			return oppositeMultiplicitySettings;
	}
	/**
	 * @ return settings for oppositeIsComposite editor
	 */
	public EEFEditorSettingsImpl getOppositeIsCompositeSettings() {
			return oppositeIsCompositeSettings;
	}
	/**
	 * @ return settings for oppositeNavigable editor
	 */
	public EEFEditorSettingsImpl getOppositeNavigableSettings() {
			return oppositeNavigableSettings;
	}
	/**
	 * @ return settings for oppositeIdentifier editor
	 */
	public EEFEditorSettingsImpl getOppositeIdentifierSettings() {
			return oppositeIdentifierSettings;
	}
	/**
	 * @ return settings for oppositeDescription editor
	 */
	public EEFEditorSettingsImpl getOppositeDescriptionSettings() {
			return oppositeDescriptionSettings;
	}

	

}
