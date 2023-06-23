/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.contextual.explorer.ui.providers;

import org.eclipse.amalgam.explorer.contextual.core.provider.DefaultLabelProviderFactory;
import org.eclipse.amalgam.explorer.contextual.core.provider.wrapper.EObjectWrapper;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.environment.Annotation;

public class ISLabelProviderFactory extends DefaultLabelProviderFactory {
	
	@Override
	protected ILabelProvider getLabelProvider() {
		return new DelegatingLabelProvider(super.getLabelProvider());
	}
	
	private static final class DelegatingLabelProvider implements ILabelProvider {
		
		private ILabelProvider delegate;

		public DelegatingLabelProvider(ILabelProvider delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public Image getImage(Object element) {
			return this.delegate.getImage(element);
		}

		@Override
		public String getText(Object element) {
			String text = this.delegate.getText(element);
			if (element instanceof EObjectWrapper) {
				Object wrappedElement = ((EObjectWrapper) element).getElement();
				if (wrappedElement instanceof Annotation) {
					Annotation annotation = (Annotation) wrappedElement;
					text = annotation.getTitle() + " -> " + annotation.getBody();
				}
			}
			return text;
		}

		@Override
		public void addListener(ILabelProviderListener listener) {
			this.delegate.addListener(listener);
		}

		@Override
		public void dispose() {
			this.delegate.dispose();
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return this.delegate.isLabelProperty(element, property);
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			this.delegate.removeListener(listener);
		}
	}
}
