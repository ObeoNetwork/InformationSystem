/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.tree.provider.TreeItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.StructuredTypeLabelsSwitch;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;
import org.obeonetwork.dsl.environment.bindingdialect.provider.BindingdialectItemProviderAdapterFactory;

/**
 * @author sthibaudeau
 *
 */
public class DBoundElementLabelProvider implements ILabelProvider {

	final AdapterFactoryLabelProvider labelProvider;
	final StructuredTypeLabelsSwitch dtoLabelsSwitch;
	
	/**
	 * 
	 */
	public DBoundElementLabelProvider() {
		final ComposedAdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		factory.addAdapterFactory(new BindingdialectItemProviderAdapterFactory());
		factory.addAdapterFactory(new TreeItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(factory);
		
		dtoLabelsSwitch = new StructuredTypeLabelsSwitch();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		labelProvider.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if (element instanceof DBoundElement) {
			return labelProvider.getImage(((DBoundElement)element).getTarget());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof DBoundElement) {
			EObject target = ((DBoundElement)element).getTarget();
			return dtoLabelsSwitch.getLabel(target);
		}
		return null;
	}
//	
//	private boolean isFromEnvironmentMM(EObject eObject) {
//		return eObject instanceof DTO
//			|| eObject instanceof Attribute
//			|| eObject instanceof Reference;
//	}
//	
//	private boolean isFromEntityMM(EObject eObject) {
//		return eObject instanceof Entity;
//	}
}
