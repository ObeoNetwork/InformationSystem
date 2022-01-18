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
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.UseCasePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class UseCaseUseCasePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String USECASE_PART = "UseCase"; //$NON-NLS-1$

	
	/**
	 * Settings for tasks ReferencesTable
	 */
	private ReferencesTableSettings tasksSettings;
	
	/**
	 * Settings for namespaces ReferencesTable
	 */
	private ReferencesTableSettings namespacesSettings;
	
	/**
	 * Settings for domainClasses ReferencesTable
	 */
	private ReferencesTableSettings domainClassesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public UseCaseUseCasePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject useCase, String editing_mode) {
		super(editingContext, useCase, editing_mode);
		parts = new String[] { USECASE_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.UseCase.class;
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
			
			final UseCase useCase = (UseCase)elt;
			final UseCasePropertiesEditionPart useCasePart = (UseCasePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.UseCase.Properties.description))
				useCasePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, useCase.getDescription()));
			if (isAccessible(GraalViewsRepository.UseCase.Properties.tasks)) {
				tasksSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getUseCase_Tasks());
				useCasePart.initTasks(tasksSettings);
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.name))
				useCasePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, useCase.getName()));
			
			if (isAccessible(GraalViewsRepository.UseCase.Properties.namespaces)) {
				namespacesSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces());
				useCasePart.initNamespaces(namespacesSettings);
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.domainClasses)) {
				domainClassesSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getUseCase_DomainClasses());
				useCasePart.initDomainClasses(domainClassesSettings);
			}
			// init filters
			
			if (isAccessible(GraalViewsRepository.UseCase.Properties.tasks)) {
				useCasePart.addFilterToTasks(new EObjectFilter(GraalPackage.Literals.ABSTRACT_TASK));
				// Start of user code for additional businessfilters for tasks
				// End of user code
			}
			
			if (isAccessible(GraalViewsRepository.UseCase.Properties.namespaces)) {
				useCasePart.addFilterToNamespaces(new EObjectFilter(EnvironmentPackage.Literals.NAMESPACE));
				// Start of user code for additional businessfilters for namespaces
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.domainClasses)) {
				useCasePart.addFilterToDomainClasses(new EObjectFilter(GraalPackage.Literals.DOMAIN_CLASS));
				// Start of user code for additional businessfilters for domainClasses
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
		if (editorKey == GraalViewsRepository.UseCase.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.tasks) {
			return GraalPackage.eINSTANCE.getUseCase_Tasks();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.name) {
			return GraalPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.namespaces) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.domainClasses) {
			return GraalPackage.eINSTANCE.getUseCase_DomainClasses();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		UseCase useCase = (UseCase)semanticObject;
		if (GraalViewsRepository.UseCase.Properties.description == event.getAffectedEditor()) {
			useCase.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.UseCase.Properties.tasks == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof AbstractTask) {
					tasksSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				tasksSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				tasksSettings.move(event.getNewIndex(), (AbstractTask) event.getNewValue());
			}
		}
		if (GraalViewsRepository.UseCase.Properties.name == event.getAffectedEditor()) {
			useCase.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.UseCase.Properties.namespaces == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Namespace) {
					namespacesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				namespacesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				namespacesSettings.move(event.getNewIndex(), (Namespace) event.getNewValue());
			}
		}
		if (GraalViewsRepository.UseCase.Properties.domainClasses == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof DomainClass) {
					domainClassesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				domainClassesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				domainClassesSettings.move(event.getNewIndex(), (DomainClass) event.getNewValue());
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
			UseCasePropertiesEditionPart useCasePart = (UseCasePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && useCasePart != null && isAccessible(GraalViewsRepository.UseCase.Properties.description)){
				if (msg.getNewValue() != null) {
					useCasePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					useCasePart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getUseCase_Tasks().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.tasks))
				useCasePart.updateTasks();
			if (GraalPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && useCasePart != null && isAccessible(GraalViewsRepository.UseCase.Properties.name)) {
				if (msg.getNewValue() != null) {
					useCasePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					useCasePart.setName("");
				}
			}
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.namespaces))
				useCasePart.updateNamespaces();
			if (GraalPackage.eINSTANCE.getUseCase_DomainClasses().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.domainClasses))
				useCasePart.updateDomainClasses();
			
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
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description(),
			GraalPackage.eINSTANCE.getUseCase_Tasks(),
			GraalPackage.eINSTANCE.getNamedElement_Name(),
			GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces(),
			GraalPackage.eINSTANCE.getUseCase_DomainClasses()		);
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
				if (GraalViewsRepository.UseCase.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.UseCase.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
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
