/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.provider.util;

import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
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
				GraalPackage.Literals.TASKS_CONTAINER__TASKS, "Tasks"));
		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				GraalPackage.Literals.SYSTEM__SUB_SYSTEMS, "SubSystems"));

		children.add(new SystemCustomContentItemProvider(adapterFactory, system, GraalPackage.Literals.SYSTEM__ACTORS,
				"Actors"));
		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				GraalPackage.Literals.SYSTEM__USE_CASES, "UseCases"));

		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				GraalPackage.Literals.SYSTEM__USER_STORIES, "UserStories"));
		// Index==5
		children.add(new SystemCustomContentItemProvider(adapterFactory, system,
				EnvironmentPackage.eINSTANCE.getNamespacesContainer_OwnedNamespaces(), "Domains"));
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
}
