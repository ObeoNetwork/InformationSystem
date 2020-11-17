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
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.components;

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

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.StructuredType;

import org.obeonetwork.dsl.environment.parts.DtoPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class DtoDtoPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String DTO_PART = "Dto"; //$NON-NLS-1$

	
	/**
	 * Settings for supertype EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings supertypeSettings;
	
	/**
	 * Settings for associatedTypes ReferencesTable
	 */
	private ReferencesTableSettings associatedTypesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DtoDtoPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dTO, String editing_mode) {
		super(editingContext, dTO, editing_mode);
		parts = new String[] { DTO_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.Dto.class;
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
			
			final DTO dTO = (DTO)elt;
			final DtoPropertiesEditionPart dtoPart = (DtoPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.Dto.Properties.name))
				dtoPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dTO.getName()));
			
			if (isAccessible(EnvironmentViewsRepository.Dto.Properties.supertype)) {
				// init part
				supertypeSettings = new EObjectFlatComboSettings(dTO, EnvironmentPackage.eINSTANCE.getStructuredType_Supertype());
				dtoPart.initSupertype(supertypeSettings);
				// set the button mode
				dtoPart.setSupertypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EnvironmentViewsRepository.Dto.Properties.description))
				dtoPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, dTO.getDescription()));
			if (isAccessible(EnvironmentViewsRepository.Dto.Properties.associatedTypes)) {
				associatedTypesSettings = new ReferencesTableSettings(dTO, EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes());
				dtoPart.initAssociatedTypes(associatedTypesSettings);
			}
			// init filters
			
			if (isAccessible(EnvironmentViewsRepository.Dto.Properties.supertype)) {
				dtoPart.addFilterToSupertype(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof StructuredType); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for supertype
				// End of user code
			}
			
			if (isAccessible(EnvironmentViewsRepository.Dto.Properties.associatedTypes)) {
				dtoPart.addFilterToAssociatedTypes(new EObjectFilter(EnvironmentPackage.Literals.STRUCTURED_TYPE));
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
		if (editorKey == EnvironmentViewsRepository.Dto.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getType_Name();
		}
		if (editorKey == EnvironmentViewsRepository.Dto.Properties.supertype) {
			return EnvironmentPackage.eINSTANCE.getStructuredType_Supertype();
		}
		if (editorKey == EnvironmentViewsRepository.Dto.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == EnvironmentViewsRepository.Dto.Properties.associatedTypes) {
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
		DTO dTO = (DTO)semanticObject;
		if (EnvironmentViewsRepository.Dto.Properties.name == event.getAffectedEditor()) {
			dTO.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.Dto.Properties.supertype == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				supertypeSettings.setToReference((StructuredType)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, supertypeSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (EnvironmentViewsRepository.Dto.Properties.description == event.getAffectedEditor()) {
			dTO.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.Dto.Properties.associatedTypes == event.getAffectedEditor()) {
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
			DtoPropertiesEditionPart dtoPart = (DtoPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getType_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && dtoPart != null && isAccessible(EnvironmentViewsRepository.Dto.Properties.name)) {
				if (msg.getNewValue() != null) {
					dtoPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					dtoPart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getStructuredType_Supertype().equals(msg.getFeature()) && dtoPart != null && isAccessible(EnvironmentViewsRepository.Dto.Properties.supertype))
				dtoPart.setSupertype((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && dtoPart != null && isAccessible(EnvironmentViewsRepository.Dto.Properties.description)){
				if (msg.getNewValue() != null) {
					dtoPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					dtoPart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes().equals(msg.getFeature())  && isAccessible(EnvironmentViewsRepository.Dto.Properties.associatedTypes))
				dtoPart.updateAssociatedTypes();
			
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
		return key == EnvironmentViewsRepository.Dto.Properties.name;
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
				if (EnvironmentViewsRepository.Dto.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Dto.Properties.description == event.getAffectedEditor()) {
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
