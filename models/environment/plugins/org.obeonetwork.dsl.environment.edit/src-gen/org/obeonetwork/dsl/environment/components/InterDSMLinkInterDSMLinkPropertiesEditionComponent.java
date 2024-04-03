/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.InterDSMLink;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.InterDSMLinkPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class InterDSMLinkInterDSMLinkPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INTERDSMLINK_PART = "InterDSMLink"; //$NON-NLS-1$

	
	/**
	 * Settings for target EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings targetSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public InterDSMLinkInterDSMLinkPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject interDSMLink, String editing_mode) {
		super(editingContext, interDSMLink, editing_mode);
		parts = new String[] { INTERDSMLINK_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.InterDSMLink.class;
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
			
			final InterDSMLink interDSMLink = (InterDSMLink)elt;
			final InterDSMLinkPropertiesEditionPart interDSMLinkPart = (InterDSMLinkPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.InterDSMLink.Properties.name))
				interDSMLinkPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, interDSMLink.getName()));
			
			if (isAccessible(EnvironmentViewsRepository.InterDSMLink.Properties.target)) {
				// init part
				targetSettings = new EObjectFlatComboSettings(interDSMLink, EnvironmentPackage.eINSTANCE.getInterDSMLink_Target());
				interDSMLinkPart.initTarget(targetSettings);
				// set the button mode
				interDSMLinkPart.setTargetButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EnvironmentViewsRepository.InterDSMLink.Properties.description))
				interDSMLinkPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, interDSMLink.getDescription()));
			// init filters
			
			if (isAccessible(EnvironmentViewsRepository.InterDSMLink.Properties.target)) {
				interDSMLinkPart.addFilterToTarget(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof EObject);
					}
					
				});
				// Start of user code for additional businessfilters for target
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
		if (editorKey == EnvironmentViewsRepository.InterDSMLink.Properties.name) {
			return EnvironmentPackage.eINSTANCE.getInterDSMLink_Name();
		}
		if (editorKey == EnvironmentViewsRepository.InterDSMLink.Properties.target) {
			return EnvironmentPackage.eINSTANCE.getInterDSMLink_Target();
		}
		if (editorKey == EnvironmentViewsRepository.InterDSMLink.Properties.description) {
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
		InterDSMLink interDSMLink = (InterDSMLink)semanticObject;
		if (EnvironmentViewsRepository.InterDSMLink.Properties.name == event.getAffectedEditor()) {
			interDSMLink.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.InterDSMLink.Properties.target == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				targetSettings.setToReference((EObject)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EObject eObject = EcoreFactory.eINSTANCE.createEObject();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				targetSettings.setToReference(eObject);
			}
		}
		if (EnvironmentViewsRepository.InterDSMLink.Properties.description == event.getAffectedEditor()) {
			interDSMLink.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			InterDSMLinkPropertiesEditionPart interDSMLinkPart = (InterDSMLinkPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getInterDSMLink_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interDSMLinkPart != null && isAccessible(EnvironmentViewsRepository.InterDSMLink.Properties.name)) {
				if (msg.getNewValue() != null) {
					interDSMLinkPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interDSMLinkPart.setName("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getInterDSMLink_Target().equals(msg.getFeature()) && interDSMLinkPart != null && isAccessible(EnvironmentViewsRepository.InterDSMLink.Properties.target))
				interDSMLinkPart.setTarget((EObject)msg.getNewValue());
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && interDSMLinkPart != null && isAccessible(EnvironmentViewsRepository.InterDSMLink.Properties.description)){
				if (msg.getNewValue() != null) {
					interDSMLinkPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					interDSMLinkPart.setDescription("");
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
			EnvironmentPackage.eINSTANCE.getInterDSMLink_Name(),
			EnvironmentPackage.eINSTANCE.getInterDSMLink_Target(),
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
		return key == EnvironmentViewsRepository.InterDSMLink.Properties.name || key == EnvironmentViewsRepository.InterDSMLink.Properties.target;
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
				if (EnvironmentViewsRepository.InterDSMLink.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getInterDSMLink_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getInterDSMLink_Name().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.InterDSMLink.Properties.description == event.getAffectedEditor()) {
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
