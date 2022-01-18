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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.StructuredType;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class EntityEntityPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String ENTITY_PART = "Entity"; //$NON-NLS-1$

	
	/**
	 * Settings for superType EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings superTypeSettings;
	
	/**
	 * Settings for associatedTypes ReferencesTable
	 */
	private ReferencesTableSettings associatedTypesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EntityEntityPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject entity, String editing_mode) {
		super(editingContext, entity, editing_mode);
		parts = new String[] { ENTITY_PART };
		repositoryKey = EntityViewsRepository.class;
		partKey = EntityViewsRepository.Entity_.class;
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
			final EntityPropertiesEditionPart entityPart = (EntityPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EntityViewsRepository.Entity_.Properties.name))
				entityPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, entity.getName()));
			
			if (isAccessible(EntityViewsRepository.Entity_.Properties.superType)) {
				// init part
				superTypeSettings = new EObjectFlatComboSettings(entity, EnvironmentPackage.eINSTANCE.getStructuredType_Supertype());
				entityPart.initSuperType(superTypeSettings);
				// set the button mode
				entityPart.setSuperTypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EntityViewsRepository.Entity_.Properties.description))
				entityPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, entity.getDescription()));
			if (isAccessible(EntityViewsRepository.Entity_.Properties.associatedTypes)) {
				associatedTypesSettings = new ReferencesTableSettings(entity, EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes());
				entityPart.initAssociatedTypes(associatedTypesSettings);
			}
			// init filters
			
			
			
			if (isAccessible(EntityViewsRepository.Entity_.Properties.associatedTypes)) {
				entityPart.addFilterToAssociatedTypes(new EObjectFilter(EnvironmentPackage.Literals.STRUCTURED_TYPE));
				// Start of user code for additional businessfilters for associatedTypes
				// End of user code
			}
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
		if (editorKey == EntityViewsRepository.Entity_.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getType_Name();
		}
		if (editorKey == EntityViewsRepository.Entity_.Properties.superType) {
			return EnvironmentPackage.eINSTANCE.getStructuredType_Supertype();
		}
		if (editorKey == EntityViewsRepository.Entity_.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == EntityViewsRepository.Entity_.Properties.associatedTypes) {
			return EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes();
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
		if (EntityViewsRepository.Entity_.Properties.name == event.getAffectedEditor()) {
			entity.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EntityViewsRepository.Entity_.Properties.superType == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				superTypeSettings.setToReference((StructuredType)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, superTypeSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (EntityViewsRepository.Entity_.Properties.description == event.getAffectedEditor()) {
			entity.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EntityViewsRepository.Entity_.Properties.associatedTypes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof StructuredType) {
					associatedTypesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				associatedTypesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				associatedTypesSettings.move(event.getNewIndex(), (StructuredType) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			EntityPropertiesEditionPart entityPart = (EntityPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getType_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && entityPart != null && isAccessible(EntityViewsRepository.Entity_.Properties.name)) {
				if (msg.getNewValue() != null) {
					entityPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					entityPart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getStructuredType_Supertype().equals(msg.getFeature()) && entityPart != null && isAccessible(EntityViewsRepository.Entity_.Properties.superType))
				entityPart.setSuperType((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && entityPart != null && isAccessible(EntityViewsRepository.Entity_.Properties.description)){
				if (msg.getNewValue() != null) {
					entityPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					entityPart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes().equals(msg.getFeature())  && isAccessible(EntityViewsRepository.Entity_.Properties.associatedTypes))
				entityPart.updateAssociatedTypes();
			
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
			EnvironmentPackage.eINSTANCE.getType_Name(),
			EnvironmentPackage.eINSTANCE.getStructuredType_Supertype(),
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description(),
			EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes()		);
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
				if (EntityViewsRepository.Entity_.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), newValue);
				}
				if (EntityViewsRepository.Entity_.Properties.description == event.getAffectedEditor()) {
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
