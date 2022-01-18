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
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.TasksGroupPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class TasksGroupTasksGroupPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String TASKSGROUP_PART = "TasksGroup"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public TasksGroupTasksGroupPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject tasksGroup, String editing_mode) {
		super(editingContext, tasksGroup, editing_mode);
		parts = new String[] { TASKSGROUP_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.TasksGroup.class;
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
			
			final TasksGroup tasksGroup = (TasksGroup)elt;
			final TasksGroupPropertiesEditionPart tasksGroupPart = (TasksGroupPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.TasksGroup.Properties.description))
				tasksGroupPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, tasksGroup.getDescription()));
			if (isAccessible(GraalViewsRepository.TasksGroup.Properties.id))
				tasksGroupPart.setId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, tasksGroup.getId()));
			
			if (isAccessible(GraalViewsRepository.TasksGroup.Properties.name))
				tasksGroupPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, tasksGroup.getName()));
			
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
		if (editorKey == GraalViewsRepository.TasksGroup.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.TasksGroup.Properties.id) {
			return GraalPackage.eINSTANCE.getAbstractTask_Id();
		}
		if (editorKey == GraalViewsRepository.TasksGroup.Properties.name) {
			return GraalPackage.eINSTANCE.getNamedElement_Name();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		TasksGroup tasksGroup = (TasksGroup)semanticObject;
		if (GraalViewsRepository.TasksGroup.Properties.description == event.getAffectedEditor()) {
			tasksGroup.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.TasksGroup.Properties.id == event.getAffectedEditor()) {
			tasksGroup.setId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.TasksGroup.Properties.name == event.getAffectedEditor()) {
			tasksGroup.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			TasksGroupPropertiesEditionPart tasksGroupPart = (TasksGroupPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && tasksGroupPart != null && isAccessible(GraalViewsRepository.TasksGroup.Properties.description)){
				if (msg.getNewValue() != null) {
					tasksGroupPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					tasksGroupPart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getAbstractTask_Id().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && tasksGroupPart != null && isAccessible(GraalViewsRepository.TasksGroup.Properties.id)) {
				if (msg.getNewValue() != null) {
					tasksGroupPart.setId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					tasksGroupPart.setId("");
				}
			}
			if (GraalPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && tasksGroupPart != null && isAccessible(GraalViewsRepository.TasksGroup.Properties.name)) {
				if (msg.getNewValue() != null) {
					tasksGroupPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					tasksGroupPart.setName("");
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
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description(),
			GraalPackage.eINSTANCE.getAbstractTask_Id(),
			GraalPackage.eINSTANCE.getNamedElement_Name()		);
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
				if (GraalViewsRepository.TasksGroup.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.TasksGroup.Properties.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getAbstractTask_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getAbstractTask_Id().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.TasksGroup.Properties.name == event.getAffectedEditor()) {
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
