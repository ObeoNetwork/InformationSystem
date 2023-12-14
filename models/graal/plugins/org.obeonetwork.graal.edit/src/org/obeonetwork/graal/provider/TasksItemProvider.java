package org.obeonetwork.graal.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.GraalFactory;

public class TasksItemProvider extends TransientSystemItemProvider {

	public TasksItemProvider(AdapterFactory adapterFactory, System system) {
		super(adapterFactory, system);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(GraalPackage.Literals.TASKS_CONTAINER__TASKS);
		}
		return childrenFeatures;
	}

	@Override
	public String getText(Object object) {
		return "Tasks";
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(GraalPackage.Literals.TASKS_CONTAINER__TASKS,
				GraalFactory.eINSTANCE.createTask()));
	}

}
