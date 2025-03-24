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
package org.obeonetwork.dsl.environment.design.views;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.eef.properties.ui.api.IEEFTabDescriptor;
import org.eclipse.eef.properties.ui.internal.registry.EEFTabbedPropertyRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.obeonetwork.utils.common.IntrospectionUtils;

@SuppressWarnings("restriction")
public class ISPropertiesTabsRegistry extends EEFTabbedPropertyRegistry {
	
	public static void install() {
		EEFTabbedPropertyRegistry defaultRegistry = EEFTabbedPropertyRegistry.getDefault(null);
		if (!(defaultRegistry instanceof ISPropertiesTabsRegistry)) {
			IntrospectionUtils.setFieldValue(defaultRegistry, "instance", new ISPropertiesTabsRegistry());
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.internal.registry.EEFTabbedPropertyRegistry#getTabDescriptors(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public List<IEEFTabDescriptor> getTabDescriptors(IWorkbenchPart part, ISelection input) {
		List<IEEFTabDescriptor> descriptors = super.getTabDescriptors(part, input);
		
		if (descriptors == null) {
			return null;
		}
		
		List<IEEFTabDescriptor> sortableDescriptors = new ArrayList<>();
		List<IEEFTabDescriptor> nonSortableDescriptors = new ArrayList<>();
		descriptors.forEach(descriptor -> {
			if(getTabOrder(descriptor) != -1) {
				sortableDescriptors.add(descriptor);
			} else {
				nonSortableDescriptors.add(descriptor);
			}
		});
		
		sortableDescriptors.sort((tab1, tab2) -> getTabOrder(tab1) - getTabOrder(tab2));
		
		sortableDescriptors.addAll(nonSortableDescriptors);
		
		return sortableDescriptors;
	}
	
	private static final Pattern TAB_ORDER_PATTERN = Pattern.compile(".*\\{tabOrder=([0-9]+)\\}.*");
	
	private int getTabOrder(IEEFTabDescriptor tabDescriptor) {
		Matcher matcher = TAB_ORDER_PATTERN.matcher(tabDescriptor.getId());
		if(matcher.matches()) {
			return Integer.parseInt(matcher.group(1));
		}
		return -1;
	}
	
}
