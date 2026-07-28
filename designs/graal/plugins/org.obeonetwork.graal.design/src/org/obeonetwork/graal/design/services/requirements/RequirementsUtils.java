/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.services.requirements;

import java.util.Collection;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UseCase;

/**
 * Utilities services concerning Requirements
 * 
 * @author Obeo
 * 
 */
public class RequirementsUtils {

	/**
	 * Return the linked Task if exist using the "asTask" service
	 * 
	 * @param context
	 *            the context on which is applied the service
	 * @return the related task, null otherwise
	 */
	public Task relatedTask(Requirement context) {
		for (EObject object : context.getReferencedObject()) {
			Task asTask = asTask(object);
			if (asTask != null) {
				return asTask;
			}
		}
		return null;
	}

	/**
	 * Try to interpret an object as a Task
	 * - return this if the object is a Task
	 * - Up the containing hierarchy to find a Task
	 * - null otherwise
	 * 
	 * @param context the context on which is applied the service
	 * @return a task if task is find null otherwise
	 */
	public Task asTask(EObject context) {
		if (context instanceof Task) {
			return (Task) context;
		}
		EObject container = context.eContainer();
		if (container != null) {
			return asTask(container);
		}
		return null;
	}

	/**
	 * Return the related Use case
	 * 
	 * @param context the context on which is applied the service
	 * @return useCase if useCase is found null otherwise
	 */
	public UseCase relatedUseCase(Requirement context) {
		for (EObject object : context.getReferencedObject()) {
			UseCase asUseCase = asUseCase(object);
			if (asUseCase != null) {
				return asUseCase;
			}
		}
		return null;
	}
	
	/**
	 * Try to interpret an object as an UseCase
	 * - return this if the object is a UseCase
	 * - return the UseCase associated to the group if the referencedObject can be interpreted as a group
	 * - return the UseCase associated to the task if the referencedObject can be interpreted as a task
	 * - return the UseCase associated to the domainClass or the parent namespace if the referencedObject can be interpreted as a domainClass
	 * - return the UseCase associated to the namespace if the referencedObject can be interpreted as a namespace
	 * - null otherwise
	 * 
	 * @param context The context on which is applied the service
	 * @return the useCase, if a useCase is find, null otherwise
	 */
	public UseCase asUseCase(EObject context) {
		if (context instanceof UseCase useCase) {
			return useCase;
		} else if (context instanceof TasksGroup taskGroup) {
			return taskGroup.getUseCase();
		} else if (context instanceof DomainClass domainClass) {
			ECrossReferenceAdapter semanticCrossReferencer = Session.of(domainClass).get().getSemanticCrossReferencer();
			// Concat the inverse reference for the DomainClass and it's parent in case the link isn't direct
			Stream<Setting> inverseReferences = Stream.concat(semanticCrossReferencer.getInverseReferences(domainClass, GraalPackage.eINSTANCE.getUseCase_DomainClasses(), true).stream(),
					semanticCrossReferencer.getInverseReferences(domainClass.eContainer(), GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces(), true).stream());
			
			return inverseReferences
					.map(Setting::getEObject)
					.filter(UseCase.class::isInstance)
					.map(UseCase.class::cast)
					.findFirst()
					.orElse(null);
		} else if (context instanceof Namespace namespace) {
			return Session.of(namespace).get().getSemanticCrossReferencer().getInverseReferences(namespace, GraalPackage.eINSTANCE.getDomainModelRegistry_Namespaces(), true).stream()
					.map(Setting::getEObject)
					.filter(UseCase.class::isInstance)
					.map(UseCase.class::cast)
					.findFirst()
					.orElse(null);
		} else {
			Task asTask = asTask(context);
			if (asTask != null) {
				return asTask.getUseCase();
			}
		}
		return null;
	}
}