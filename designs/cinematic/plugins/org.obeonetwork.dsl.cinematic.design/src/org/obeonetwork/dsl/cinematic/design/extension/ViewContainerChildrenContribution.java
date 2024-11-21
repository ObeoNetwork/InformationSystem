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
package org.obeonetwork.dsl.cinematic.design.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.extensionpoint.IBoundableElementChildren;

public class ViewContainerChildrenContribution implements IBoundableElementChildren {

	@Override
	public List<? extends EObject> getChildren(EObject object) {
		List<EObject> children = new ArrayList<>();
		if (object instanceof ViewContainer) {
			ViewContainer viewContainer = (ViewContainer) object;
			children.addAll(viewContainer.getViewElements());
			children.addAll(viewContainer.getViewContainers());
			children.addAll(
					viewContainer.getViewContainerReferences().stream().map(ViewContainerReference::getViewContainer)
							.filter(Objects::nonNull).collect(Collectors.toList()));
		}
		return Collections.unmodifiableList(children);
	}

	@Override
	public List<EClass> getApplicableEClasses() {
		return List.of(ViewPackage.eINSTANCE.getViewContainer(), ViewPackage.eINSTANCE.getViewElement());
	}

	private final ViewContainerLabelsSwitch viewLabelsSwitch = new ViewContainerLabelsSwitch();

	@Override
	public String getLabel(EObject eObject) {
		return viewLabelsSwitch.getLabel(eObject);
	}
}