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
package org.obeonetwork.graal.design.ui.view.explorer.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.query.RepresentationDescriptionQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.util.EqualityHelper;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.provider.custom.SystemCustomContentItemProvider;

/**
 * @author Obeo
 *
 */
public class SystemTreeContentProvider implements ITreeContentProvider {
	final AdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	@Override
	public Object[] getElements(Object inputElement) {
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof SystemCustomContentItemProvider) {
			SystemCustomContentItemProvider systemCustomContentItemProvider = (SystemCustomContentItemProvider) parentElement;
			return systemCustomContentItemProvider.getChildren(systemCustomContentItemProvider.getTarget()).toArray();
		} else if (parentElement instanceof EObject) {// Below SystemCustomContentItemProvider
			List<Object> result = new ArrayList<>();
			result.addAll(getRepresentationDescriptorsAssociatedToEObject((EObject) parentElement));
			Object itemProvider = composedAdapterFactory.adapt((EObject) parentElement,
					IEditingDomainItemProvider.class);
			if(itemProvider!=null) {
				result.addAll(((IEditingDomainItemProvider) itemProvider).getChildren(parentElement));
			}
			return result.toArray();
		}
		return new Object[0];
	}
	
	/**
	 * Adapted from
	 * org.eclipse.sirius.ui.tools.internal.views.common.SessionWrapperContentProvider
	 * 
	 * @param eObject
	 * @return
	 */
	private Collection<DRepresentationDescriptor> getRepresentationDescriptorsAssociatedToEObject(
			final EObject eObject) {
		final Session session = SessionManager.INSTANCE.getSession(eObject);
		if (session != null && session.isOpen()) {
			return DialectManager.INSTANCE.getRepresentationDescriptors(eObject, session).stream()
					.filter(repDescriptor -> {
						if (repDescriptor.eResource() != null) {
							RepresentationDescription description = repDescriptor.getDescription();
							if (description != null) {
								Viewpoint reprViewpoint = new RepresentationDescriptionQuery(description)
										.getParentViewpoint();
								if (reprViewpoint != null && !reprViewpoint.eIsProxy()
										&& reprViewpoint.eResource() != null) {
									for (final Viewpoint viewpoint : session.getSelectedViewpoints(false)) {
										if (EqualityHelper.areEquals(viewpoint, reprViewpoint)) {
											return true;
										}
									}
								}
							}
						}
						return false;
					}).sorted(Comparator.comparing(DRepresentationDescriptor::getName)).toList();
		}
		return Collections.emptyList();
	}
	

	@Override
	public Object getParent(Object element) {
		if (element instanceof SystemCustomContentItemProvider) {
			SystemCustomContentItemProvider systemCustomContentItemProvider = (SystemCustomContentItemProvider) element;
			return systemCustomContentItemProvider.getParent(systemCustomContentItemProvider.getTarget());
		} else if (element instanceof EObject && !(element instanceof System)) {// Below SystemCustomContentItemProvider
			final AdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			Object itemProvider = composedAdapterFactory.adapt(element, IEditingDomainItemProvider.class);
			if (itemProvider != null) {
				return ((IEditingDomainItemProvider) itemProvider).getParent(element);
			}
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
}
