package org.obeonetwork.graal.provider.util;

import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.provider.custom.SystemCustomContentItemProvider;

/**
 * Helper class for data associated to the ItemProviders for the logical blocs
 * below a {@link System}.
 * 
 * @author Obeo
 *
 */
public class SystemContentItemProviderUtil {

	@SuppressWarnings("unchecked")
	public static void addSystemCustomContentItemProviders(List children, System system,
			AdapterFactory adapterFactory) {
		Objects.requireNonNull(children);
		Objects.requireNonNull(system);
		Objects.requireNonNull(adapterFactory);
		// Index==0
		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				GraalPackage.Literals.TASKS_CONTAINER__TASKS, () -> GraalFactory.eINSTANCE.createTask(), "Tasks"));
		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				GraalPackage.Literals.SYSTEM__SUB_SYSTEMS, () -> GraalFactory.eINSTANCE.createSystem(), "SubSystems"));

		children.add(new SystemCustomContentItemProvider(adapterFactory, system, GraalPackage.Literals.SYSTEM__ACTORS,
				() -> GraalFactory.eINSTANCE.createActor(), "Actors"));
		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				GraalPackage.Literals.SYSTEM__USE_CASES, () -> GraalFactory.eINSTANCE.createUseCase(), "UseCases"));

		children.add(
				new SystemCustomContentItemProvider(adapterFactory, system, GraalPackage.Literals.SYSTEM__USER_STORIES,
						() -> GraalFactory.eINSTANCE.createUserStory(), "UserStories"));
		// Index==5
		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				EnvironmentPackage.eINSTANCE.getNamespacesContainer_OwnedNamespaces(),
				() -> EnvironmentFactory.eINSTANCE.createNamespace(), "Namespaces"));
	}

	@SuppressWarnings("unchecked")
	public static Object getSystemCustomContentItemProvider(EStructuralFeature reference, List children) {
		Objects.requireNonNull(reference);
		Objects.requireNonNull(children);
		return children.stream().filter(SystemCustomContentItemProvider.class::isInstance)
				.map(SystemCustomContentItemProvider.class::cast)
				.filter(ip -> reference.equals(((SystemCustomContentItemProvider) ip).getReference())).findFirst()
				.orElse(null);
	}

	public static final List<EStructuralFeature> SYSTEM_CUSTOM_CONTENT_ORDERED_REFERENCES = List.of(
			GraalPackage.Literals.TASKS_CONTAINER__TASKS, GraalPackage.Literals.SYSTEM__SUB_SYSTEMS,
			GraalPackage.Literals.SYSTEM__ACTORS, GraalPackage.Literals.SYSTEM__USE_CASES,
			GraalPackage.Literals.SYSTEM__USER_STORIES,
			EnvironmentPackage.eINSTANCE.getNamespacesContainer_OwnedNamespaces());

	public static final String getFeatureText(EStructuralFeature reference) {

		if (GraalPackage.Literals.TASKS_CONTAINER__TASKS.equals(reference)) {
			return "Task";
		}
		if (GraalPackage.Literals.SYSTEM__SUB_SYSTEMS.equals(reference)) {
			return "SubSystem";
		}
		if (GraalPackage.Literals.SYSTEM__ACTORS.equals(reference)) {
			return "Actor";
		}
		if (GraalPackage.Literals.SYSTEM__USE_CASES.equals(reference)) {
			return "Use Case";
		}
		if (GraalPackage.Literals.SYSTEM__USER_STORIES.equals(reference)) {
			return "User Story";
		}
		if (EnvironmentPackage.eINSTANCE.getNamespacesContainer_OwnedNamespaces().equals(reference)) {
			return "Namespace";
		}
		return null;
//		#Added manually for custom nodes below System
//		_UI_TasksContainer_tasks_feature = Task
//		_UI_NamespacesContainer_ownedNamespaces_feature =  Namespace
//		_UI_System_userStories_feature = User Story
//		_UI_System_useCases_feature = Use Case
//		_UI_System_subSystems_feature = SubSystem
//		_UI_System_actors_feature =  Actor
	}
}
