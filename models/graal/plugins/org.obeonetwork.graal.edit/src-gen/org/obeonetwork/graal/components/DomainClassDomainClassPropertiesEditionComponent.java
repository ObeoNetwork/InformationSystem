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
package org.obeonetwork.graal.components;

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
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.parts.DomainClassPropertiesEditionPart;
import org.obeonetwork.graal.parts.GraalViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class DomainClassDomainClassPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String DOMAINCLASS_PART = "DomainClass"; //$NON-NLS-1$

	
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
	public DomainClassDomainClassPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject domainClass, String editing_mode) {
		super(editingContext, domainClass, editing_mode);
		parts = new String[] { DOMAINCLASS_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.DomainClass.class;
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
			
			final DomainClass domainClass = (DomainClass)elt;
			final DomainClassPropertiesEditionPart domainClassPart = (DomainClassPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.DomainClass.Properties.name))
				domainClassPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, domainClass.getName()));
			
			if (isAccessible(GraalViewsRepository.DomainClass.Properties.superType)) {
				// init part
				superTypeSettings = new EObjectFlatComboSettings(domainClass, EnvironmentPackage.eINSTANCE.getStructuredType_Supertype());
				domainClassPart.initSuperType(superTypeSettings);
				// set the button mode
				domainClassPart.setSuperTypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(GraalViewsRepository.DomainClass.Properties.description))
				domainClassPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, domainClass.getDescription()));
			if (isAccessible(GraalViewsRepository.DomainClass.Properties.associatedTypes)) {
				associatedTypesSettings = new ReferencesTableSettings(domainClass, EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes());
				domainClassPart.initAssociatedTypes(associatedTypesSettings);
			}
			// init filters
			
			
			
			if (isAccessible(GraalViewsRepository.DomainClass.Properties.associatedTypes)) {
				domainClassPart.addFilterToAssociatedTypes(new EObjectFilter(EnvironmentPackage.Literals.STRUCTURED_TYPE));
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
		if (editorKey == GraalViewsRepository.DomainClass.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getType_Name();
		}
		if (editorKey == GraalViewsRepository.DomainClass.Properties.superType) {
			return EnvironmentPackage.eINSTANCE.getStructuredType_Supertype();
		}
		if (editorKey == GraalViewsRepository.DomainClass.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.DomainClass.Properties.associatedTypes) {
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
		DomainClass domainClass = (DomainClass)semanticObject;
		if (GraalViewsRepository.DomainClass.Properties.name == event.getAffectedEditor()) {
			domainClass.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.DomainClass.Properties.superType == event.getAffectedEditor()) {
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
		if (GraalViewsRepository.DomainClass.Properties.description == event.getAffectedEditor()) {
			domainClass.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.DomainClass.Properties.associatedTypes == event.getAffectedEditor()) {
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
			DomainClassPropertiesEditionPart domainClassPart = (DomainClassPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getType_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && domainClassPart != null && isAccessible(GraalViewsRepository.DomainClass.Properties.name)) {
				if (msg.getNewValue() != null) {
					domainClassPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					domainClassPart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getStructuredType_Supertype().equals(msg.getFeature()) && domainClassPart != null && isAccessible(GraalViewsRepository.DomainClass.Properties.superType))
				domainClassPart.setSuperType((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && domainClassPart != null && isAccessible(GraalViewsRepository.DomainClass.Properties.description)){
				if (msg.getNewValue() != null) {
					domainClassPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					domainClassPart.setDescription("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getStructuredType_AssociatedTypes().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.DomainClass.Properties.associatedTypes))
				domainClassPart.updateAssociatedTypes();
			
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
		return key == GraalViewsRepository.DomainClass.Properties.name || key == GraalViewsRepository.Persistence.Properties.historized;
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
				if (GraalViewsRepository.DomainClass.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.DomainClass.Properties.description == event.getAffectedEditor()) {
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
