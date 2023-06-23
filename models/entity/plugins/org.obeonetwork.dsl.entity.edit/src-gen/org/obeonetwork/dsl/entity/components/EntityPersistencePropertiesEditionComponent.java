/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.InheritanceKind;

import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class EntityPersistencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String PERSISTENCE_PART = "Persistence"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public EntityPersistencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject entity, String editing_mode) {
		super(editingContext, entity, editing_mode);
		parts = new String[] { PERSISTENCE_PART };
		repositoryKey = EntityViewsRepository.class;
		partKey = EntityViewsRepository.Persistence.class;
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
			
			final Entity entity = (Entity)elt;
			final PersistencePropertiesEditionPart persistencePart = (PersistencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EntityViewsRepository.Persistence.Properties.estimatedVolumetry)) {
				persistencePart.setEstimatedVolumetry(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, entity.getEstimatedVolumetry()));
			}
			
			if (isAccessible(EntityViewsRepository.Persistence.Properties.estimatedAccess)) {
				persistencePart.setEstimatedAccess(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, entity.getEstimatedAccess()));
			}
			
			if (isAccessible(EntityViewsRepository.Persistence.Properties.historized)) {
				persistencePart.setHistorized(entity.isHistorized());
			}
			if (isAccessible(EntityViewsRepository.Persistence.Properties.inheritanceKind)) {
				persistencePart.initInheritanceKind(EEFUtils.choiceOfValues(entity, EntityPackage.eINSTANCE.getEntity_InheritanceKind()), entity.getInheritanceKind());
			}
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
		if (editorKey == EntityViewsRepository.Persistence.Properties.estimatedVolumetry) {
			return EntityPackage.eINSTANCE.getEntity_EstimatedVolumetry();
		}
		if (editorKey == EntityViewsRepository.Persistence.Properties.estimatedAccess) {
			return EntityPackage.eINSTANCE.getEntity_EstimatedAccess();
		}
		if (editorKey == EntityViewsRepository.Persistence.Properties.historized) {
			return EntityPackage.eINSTANCE.getEntity_Historized();
		}
		if (editorKey == EntityViewsRepository.Persistence.Properties.inheritanceKind) {
			return EntityPackage.eINSTANCE.getEntity_InheritanceKind();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Entity entity = (Entity)semanticObject;
		if (EntityViewsRepository.Persistence.Properties.estimatedVolumetry == event.getAffectedEditor()) {
			entity.setEstimatedVolumetry((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EntityViewsRepository.Persistence.Properties.estimatedAccess == event.getAffectedEditor()) {
			entity.setEstimatedAccess((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EntityViewsRepository.Persistence.Properties.historized == event.getAffectedEditor()) {
			entity.setHistorized((Boolean)event.getNewValue());
		}
		if (EntityViewsRepository.Persistence.Properties.inheritanceKind == event.getAffectedEditor()) {
			entity.setInheritanceKind((InheritanceKind)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PersistencePropertiesEditionPart persistencePart = (PersistencePropertiesEditionPart)editingPart;
			if (EntityPackage.eINSTANCE.getEntity_EstimatedVolumetry().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && persistencePart != null && isAccessible(EntityViewsRepository.Persistence.Properties.estimatedVolumetry)) {
				if (msg.getNewValue() != null) {
					persistencePart.setEstimatedVolumetry(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					persistencePart.setEstimatedVolumetry("");
				}
			}
			if (EntityPackage.eINSTANCE.getEntity_EstimatedAccess().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && persistencePart != null && isAccessible(EntityViewsRepository.Persistence.Properties.estimatedAccess)) {
				if (msg.getNewValue() != null) {
					persistencePart.setEstimatedAccess(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					persistencePart.setEstimatedAccess("");
				}
			}
			if (EntityPackage.eINSTANCE.getEntity_Historized().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && persistencePart != null && isAccessible(EntityViewsRepository.Persistence.Properties.historized))
				persistencePart.setHistorized((Boolean)msg.getNewValue());
			
			if (EntityPackage.eINSTANCE.getEntity_InheritanceKind().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EntityViewsRepository.Persistence.Properties.inheritanceKind))
				persistencePart.setInheritanceKind((InheritanceKind)msg.getNewValue());
			
			
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
			EntityPackage.eINSTANCE.getEntity_EstimatedVolumetry(),
			EntityPackage.eINSTANCE.getEntity_EstimatedAccess(),
			EntityPackage.eINSTANCE.getEntity_Historized(),
			EntityPackage.eINSTANCE.getEntity_InheritanceKind()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EntityViewsRepository.Entity_.Properties.name || key == EntityViewsRepository.Persistence.Properties.historized;
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
				if (EntityViewsRepository.Persistence.Properties.estimatedVolumetry == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityPackage.eINSTANCE.getEntity_EstimatedVolumetry().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityPackage.eINSTANCE.getEntity_EstimatedVolumetry().getEAttributeType(), newValue);
				}
				if (EntityViewsRepository.Persistence.Properties.estimatedAccess == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityPackage.eINSTANCE.getEntity_EstimatedAccess().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityPackage.eINSTANCE.getEntity_EstimatedAccess().getEAttributeType(), newValue);
				}
				if (EntityViewsRepository.Persistence.Properties.historized == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityPackage.eINSTANCE.getEntity_Historized().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityPackage.eINSTANCE.getEntity_Historized().getEAttributeType(), newValue);
				}
				if (EntityViewsRepository.Persistence.Properties.inheritanceKind == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityPackage.eINSTANCE.getEntity_InheritanceKind().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityPackage.eINSTANCE.getEntity_InheritanceKind().getEAttributeType(), newValue);
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
