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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Literal;
import org.obeonetwork.dsl.environment.parts.EnumerationPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class EnumerationEnumerationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String ENUMERATION_PART = "Enumeration"; //$NON-NLS-1$

	
	/**
	 * Settings for literals ReferencesTable
	 */
	protected ReferencesTableSettings literalsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EnumerationEnumerationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject enumeration, String editing_mode) {
		super(editingContext, enumeration, editing_mode);
		parts = new String[] { ENUMERATION_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.Enumeration.class;
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
			
			final Enumeration enumeration = (Enumeration)elt;
			final EnumerationPropertiesEditionPart enumerationPart = (EnumerationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.Enumeration.Properties.name))
				enumerationPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enumeration.getName()));
			
			if (isAccessible(EnvironmentViewsRepository.Enumeration.Properties.literals)) {
				literalsSettings = new ReferencesTableSettings(enumeration, EnvironmentPackage.eINSTANCE.getEnumeration_Literals());
				enumerationPart.initLiterals(literalsSettings);
			}
			if (isAccessible(EnvironmentViewsRepository.Enumeration.Properties.description))
				enumerationPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, enumeration.getDescription()));
			// init filters
			
			if (isAccessible(EnvironmentViewsRepository.Enumeration.Properties.literals)) {
				enumerationPart.addFilterToLiterals(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Literal);
					}
			
				});
				// Start of user code for additional businessfilters for literals
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
		if (editorKey == EnvironmentViewsRepository.Enumeration.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getType_Name();
		}
		if (editorKey == EnvironmentViewsRepository.Enumeration.Properties.literals) {
			return EnvironmentPackage.eINSTANCE.getEnumeration_Literals();
		}
		if (editorKey == EnvironmentViewsRepository.Enumeration.Properties.description) {
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
		Enumeration enumeration = (Enumeration)semanticObject;
		if (EnvironmentViewsRepository.Enumeration.Properties.name == event.getAffectedEditor()) {
			enumeration.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.Enumeration.Properties.literals == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, literalsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				literalsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				literalsSettings.move(event.getNewIndex(), (Literal) event.getNewValue());
			}
		}
		if (EnvironmentViewsRepository.Enumeration.Properties.description == event.getAffectedEditor()) {
			enumeration.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			EnumerationPropertiesEditionPart enumerationPart = (EnumerationPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getType_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && enumerationPart != null && isAccessible(EnvironmentViewsRepository.Enumeration.Properties.name)) {
				if (msg.getNewValue() != null) {
					enumerationPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					enumerationPart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getEnumeration_Literals().equals(msg.getFeature()) && isAccessible(EnvironmentViewsRepository.Enumeration.Properties.literals))
				enumerationPart.updateLiterals();
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && enumerationPart != null && isAccessible(EnvironmentViewsRepository.Enumeration.Properties.description)){
				if (msg.getNewValue() != null) {
					enumerationPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					enumerationPart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getType_Name(),
			EnvironmentPackage.eINSTANCE.getEnumeration_Literals(),
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
		return key == EnvironmentViewsRepository.Enumeration.Properties.name || key == EnvironmentViewsRepository.Enumeration.Properties.literals;
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
				if (EnvironmentViewsRepository.Enumeration.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getType_Name().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Enumeration.Properties.description == event.getAffectedEditor()) {
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
