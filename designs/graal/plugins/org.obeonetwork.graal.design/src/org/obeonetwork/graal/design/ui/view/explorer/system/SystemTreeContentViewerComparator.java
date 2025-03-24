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

import java.util.Comparator;

import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;

/**
 * @author obeo
 *
 */
public class SystemTreeContentViewerComparator extends org.eclipse.jface.viewers.ViewerComparator {

	public SystemTreeContentViewerComparator() {
	}

	/**
	 * @param comparator
	 */
	public SystemTreeContentViewerComparator(Comparator<? super String> comparator) {
		super(comparator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int category(Object element) {
		if (element instanceof DRepresentationDescriptor) {
			return 0;
		}
		return 1;
	}

}
