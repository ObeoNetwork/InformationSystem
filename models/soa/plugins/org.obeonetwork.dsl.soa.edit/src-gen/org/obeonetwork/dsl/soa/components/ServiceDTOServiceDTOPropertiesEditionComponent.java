/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

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

import org.obeonetwork.dsl.soa.ServiceDTO;

import org.obeonetwork.dsl.soa.parts.ServiceDTOPropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;


// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class ServiceDTOServiceDTOPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SERVICEDTO_PART = "ServiceDTO"; //$NON-NLS-1$

	
	/**
	 * Settings for supertype EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings supertypeSettings;
	
	/**
	 * Settings for associatedTypes ReferencesTable
	 */
	private	ReferencesTableSettings associatedTypesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ServiceDTOServiceDTOPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject serviceDTO, String editing_mode) {
		super(editingContext, serviceDTO, editing_mode);
		parts = new String[] { SERVICEDTO_PART };
		repositoryKey = SoaViewsRepository.class;
		partKey = SoaViewsRepository.ServiceDTO.class;
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
			final ServiceDTO serviceDTO = (ServiceDTO)elt;
			final ServiceDTOPropertiesEditionPart serviceDTOPart = (ServiceDTOPropertiesEditionPart)editingPart;
			// init values
			if (serviceDTO.getName() != null && isAccessible(SoaViewsRepository.ServiceDTO.Properties.name))
				serviceDTOPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, serviceDTO.getName()));
			
			if (isAccessible(SoaViewsRepository.ServiceDTO.Properties.supertype)) {
				// init part
				supertypeSettings = new EObjectFlatComboSettings(serviceDTO, EnvironmentPackage.eINSTANCE.getDTO_Supertype());
				serviceDTOPart.initSupertype(supertypeSettings);
				// set the button mode
				serviceDTOPart.setSupertypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (serviceDTO.getDescription() != null && isAccessible(SoaViewsRepository.ServiceDTO.Properties.description))
				serviceDTOPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, serviceDTO.getDescription()));
			if (isAccessible(SoaViewsRepository.ServiceDTO.Properties.associatedTypes)) {
				associatedTypesSettings = new ReferencesTableSettings(serviceDTO, EnvironmentPackage.eINSTANCE.getDTO_AssociatedTypes());
				serviceDTOPart.initAssociatedTypes(associatedTypesSettings);
			}
			// init filters
			
			serviceDTOPart.addFilterToSupertype(new ViewerFilter() {
			
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof String && element.equals("")) || (element instanceof DTO); //$NON-NLS-1$ 
				}
			
			});
			// Start of user code 
			// End of user code
			
			
			serviceDTOPart.addFilterToAssociatedTypes(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!serviceDTOPart.isContainedInAssociatedTypesTable((EObject)element));
					return element instanceof Resource;
				}
			
			});
			serviceDTOPart.addFilterToAssociatedTypes(new EObjectFilter(EnvironmentPackage.Literals.STRUCTURED_TYPE));
			// Start of user code 
			// End of user code
			
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
		if (editorKey == SoaViewsRepository.ServiceDTO.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getType_Name();
		}
		if (editorKey == SoaViewsRepository.ServiceDTO.Properties.supertype) {
			return EnvironmentPackage.eINSTANCE.getDTO_Supertype();
		}
		if (editorKey == SoaViewsRepository.ServiceDTO.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == SoaViewsRepository.ServiceDTO.Properties.associatedTypes) {
			return EnvironmentPackage.eINSTANCE.getDTO_AssociatedTypes();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ServiceDTO serviceDTO = (ServiceDTO)semanticObject;
		if (SoaViewsRepository.ServiceDTO.Properties.name == event.getAffectedEditor()) {
			serviceDTO.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (SoaViewsRepository.ServiceDTO.Properties.supertype == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				supertypeSettings.setToReference((DTO)event.getNewValue());
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
		if (SoaViewsRepository.ServiceDTO.Properties.description == event.getAffectedEditor()) {
			serviceDTO.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (SoaViewsRepository.ServiceDTO.Properties.associatedTypes == event.getAffectedEditor()) {
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
		if (editingPart.isVisible()) {
			ServiceDTOPropertiesEditionPart serviceDTOPart = (ServiceDTOPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getType_Name().equals(msg.getFeature()) && serviceDTOPart != null && isAccessible(SoaViewsRepository.ServiceDTO.Properties.name)) {
				if (msg.getNewValue() != null) {
					serviceDTOPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					serviceDTOPart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getDTO_Supertype().equals(msg.getFeature()) && serviceDTOPart != null && isAccessible(SoaViewsRepository.ServiceDTO.Properties.supertype))
				serviceDTOPart.setSupertype((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && serviceDTOPart != null && isAccessible(SoaViewsRepository.ServiceDTO.Properties.description)){
				if (msg.getNewValue() != null) {
					serviceDTOPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					serviceDTOPart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getDTO_AssociatedTypes().equals(msg.getFeature())  && isAccessible(SoaViewsRepository.ServiceDTO.Properties.associatedTypes))
				serviceDTOPart.updateAssociatedTypes();
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == SoaViewsRepository.ServiceDTO.Properties.name;
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
				if (SoaViewsRepository.ServiceDTO.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), newValue);
				}
				if (SoaViewsRepository.ServiceDTO.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
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
