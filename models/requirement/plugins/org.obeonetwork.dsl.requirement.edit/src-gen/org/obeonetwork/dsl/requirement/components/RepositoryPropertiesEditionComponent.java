/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.dsl.requirement.components;

// Start of user code for imports
import java.util.List;

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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectStrictFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.requirement.parts.RepositoryPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class RepositoryPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String REPOSITORY_PART = "Repository"; //$NON-NLS-1$

	
	/**
	 * Settings for mainCategories ReferencesTable
	 */
	protected ReferencesTableSettings mainCategoriesSettings;
	
	/**
	 * Settings for referencedObject ReferencesTable
	 */
	private ReferencesTableSettings referencedObjectSettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public RepositoryPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject repository, String editing_mode) {
		super(editingContext, repository, editing_mode);
		parts = new String[] { REPOSITORY_PART };
		repositoryKey = RequirementViewsRepository.class;
		partKey = RequirementViewsRepository.Repository.class;
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
			
			final Repository repository = (Repository)elt;
			final RepositoryPropertiesEditionPart repositoryPart = (RepositoryPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(RequirementViewsRepository.Repository.Repository_.name))
				repositoryPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, repository.getName()));
			
			if (isAccessible(RequirementViewsRepository.Repository.Repository_.mainCategories)) {
				mainCategoriesSettings = new ReferencesTableSettings(repository, RequirementPackage.eINSTANCE.getRepository_MainCategories());
				repositoryPart.initMainCategories(mainCategoriesSettings);
			}
			if (isAccessible(RequirementViewsRepository.Repository.Repository_.referencedObject)) {
				referencedObjectSettings = new ReferencesTableSettings(repository, RequirementPackage.eINSTANCE.getRepository_ReferencedObject());
				repositoryPart.initReferencedObject(referencedObjectSettings);
			}
			// init filters
			
			if (isAccessible(RequirementViewsRepository.Repository.Repository_.mainCategories)) {
				repositoryPart.addFilterToMainCategories(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Category); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for mainCategories
				// End of user code
			}
			if (isAccessible(RequirementViewsRepository.Repository.Repository_.referencedObject)) {
				repositoryPart.addFilterToReferencedObject(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!repositoryPart.isContainedInReferencedObjectTable((EObject)element));
						return element instanceof String && element.equals("");
					}
				
				});
				repositoryPart.addFilterToReferencedObject(new EObjectStrictFilter(EcorePackage.Literals.EOBJECT));
				// Start of user code for additional businessfilters for referencedObject
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
		if (editorKey == RequirementViewsRepository.Repository.Repository_.name) {
			return RequirementPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == RequirementViewsRepository.Repository.Repository_.mainCategories) {
			return RequirementPackage.eINSTANCE.getRepository_MainCategories();
		}
		if (editorKey == RequirementViewsRepository.Repository.Repository_.referencedObject) {
			return RequirementPackage.eINSTANCE.getRepository_ReferencedObject();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Repository repository = (Repository)semanticObject;
		if (RequirementViewsRepository.Repository.Repository_.name == event.getAffectedEditor()) {
			repository.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (RequirementViewsRepository.Repository.Repository_.mainCategories == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, mainCategoriesSettings, editingContext.getAdapterFactory());
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
				mainCategoriesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				mainCategoriesSettings.move(event.getNewIndex(), (Category) event.getNewValue());
			}
		}
		if (RequirementViewsRepository.Repository.Repository_.referencedObject == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET)
				referencedObjectSettings.setToReference((List<EObject>) event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RepositoryPropertiesEditionPart repositoryPart = (RepositoryPropertiesEditionPart)editingPart;
			if (RequirementPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && repositoryPart != null && isAccessible(RequirementViewsRepository.Repository.Repository_.name)) {
				if (msg.getNewValue() != null) {
					repositoryPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					repositoryPart.setName("");
				}
			}
			if (RequirementPackage.eINSTANCE.getRepository_MainCategories().equals(msg.getFeature()) && isAccessible(RequirementViewsRepository.Repository.Repository_.mainCategories))
				repositoryPart.updateMainCategories();
			if (RequirementPackage.eINSTANCE.getRepository_ReferencedObject().equals(msg.getFeature()) && isAccessible(RequirementViewsRepository.Repository.Repository_.referencedObject))
				repositoryPart.updateReferencedObject();
			
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
			RequirementPackage.eINSTANCE.getNamedElement_Name(),
			RequirementPackage.eINSTANCE.getRepository_MainCategories(),
			RequirementPackage.eINSTANCE.getRepository_ReferencedObject()		);
		return new NotificationFilter[] {filter,};
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
				if (RequirementViewsRepository.Repository.Repository_.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
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
