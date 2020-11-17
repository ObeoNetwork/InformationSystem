/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.ExternalCriterion;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.ExternalCriterionPropertiesEditionPart;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Type;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class ExternalCriterionExternalCriterionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String EXTERNALCRITERION_PART = "ExternalCriterion"; //$NON-NLS-1$

	
	/**
	 * Settings for type EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings typeSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ExternalCriterionExternalCriterionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject externalCriterion, String editing_mode) {
		super(editingContext, externalCriterion, editing_mode);
		parts = new String[] { EXTERNALCRITERION_PART };
		repositoryKey = EntityViewsRepository.class;
		partKey = EntityViewsRepository.ExternalCriterion.class;
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
			
			final ExternalCriterion externalCriterion = (ExternalCriterion)elt;
			final ExternalCriterionPropertiesEditionPart externalCriterionPart = (ExternalCriterionPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EntityViewsRepository.ExternalCriterion.Properties.name))
				externalCriterionPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, externalCriterion.getName()));
			
			if (isAccessible(EntityViewsRepository.ExternalCriterion.Properties.type)) {
				// init part
				typeSettings = new EObjectFlatComboSettings(externalCriterion, EntityPackage.eINSTANCE.getExternalCriterion_Type());
				externalCriterionPart.initType(typeSettings);
				// set the button mode
				externalCriterionPart.setTypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EntityViewsRepository.ExternalCriterion.Properties.description))
				externalCriterionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, externalCriterion.getDescription()));
			// init filters
			
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}






	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EntityViewsRepository.ExternalCriterion.Properties.name) {
			return EntityPackage.eINSTANCE.getExternalCriterion_Name();
		}
		if (editorKey == EntityViewsRepository.ExternalCriterion.Properties.type) {
			return EntityPackage.eINSTANCE.getExternalCriterion_Type();
		}
		if (editorKey == EntityViewsRepository.ExternalCriterion.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ExternalCriterion externalCriterion = (ExternalCriterion)semanticObject;
		if (EntityViewsRepository.ExternalCriterion.Properties.name == event.getAffectedEditor()) {
			externalCriterion.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EntityViewsRepository.ExternalCriterion.Properties.type == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				typeSettings.setToReference((Type)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, typeSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (EntityViewsRepository.ExternalCriterion.Properties.description == event.getAffectedEditor()) {
			externalCriterion.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ExternalCriterionPropertiesEditionPart externalCriterionPart = (ExternalCriterionPropertiesEditionPart)editingPart;
			if (EntityPackage.eINSTANCE.getExternalCriterion_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && externalCriterionPart != null && isAccessible(EntityViewsRepository.ExternalCriterion.Properties.name)) {
				if (msg.getNewValue() != null) {
					externalCriterionPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					externalCriterionPart.setName("");
				}
			}
			if (EntityPackage.eINSTANCE.getExternalCriterion_Type().equals(msg.getFeature()) && externalCriterionPart != null && isAccessible(EntityViewsRepository.ExternalCriterion.Properties.type))
				externalCriterionPart.setType((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && externalCriterionPart != null && isAccessible(EntityViewsRepository.ExternalCriterion.Properties.description)){
				if (msg.getNewValue() != null) {
					externalCriterionPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					externalCriterionPart.setDescription("");
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
			EntityPackage.eINSTANCE.getExternalCriterion_Name(),
			EntityPackage.eINSTANCE.getExternalCriterion_Type(),
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EntityViewsRepository.ExternalCriterion.Properties.name || key == EntityViewsRepository.ExternalCriterion.Properties.type;
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
				if (EntityViewsRepository.ExternalCriterion.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityPackage.eINSTANCE.getExternalCriterion_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityPackage.eINSTANCE.getExternalCriterion_Name().getEAttributeType(), newValue);
				}
				if (EntityViewsRepository.ExternalCriterion.Properties.description == event.getAffectedEditor()) {
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


	

	

}
