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
/**
 * 
 */
package org.obeonetwork.tools.linker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Obeo
 *
 */
public class EObjectLinker extends AdapterImpl {

	private ResourceSet resourceSet;
	private Map<String, LinkType> registeredTypes;
	
	/**
	 * Return the linker attached to the given {@link EObject} or create one. 
	 * @param source {@link EObject} to manage
	 * @return the attached {@link EObjectLinker}
	 */
	public static EObjectLinker getLinker(EObject source) {
		if (source != null && source.eResource() != null && source.eResource().getResourceSet() != null) {
			return getLinker(source.eResource().getResourceSet());
		} 
		return null;
	}
	
	/**
	 * Return the linker attached to the given {@link ResourceSet} or create one. 
	 * @param resourceSet {@link ResourceSet} to manage
	 * @return the attached {@link EObjectLinker}
	 */
	private static EObjectLinker getLinker(ResourceSet resourceSet) {
		Adapter adapter = EcoreUtil.getAdapter(resourceSet.eAdapters(), EObjectLinker.class);
		if (adapter != null) {
			return (EObjectLinker) adapter;
		} else {
			EObjectLinker linker = new EObjectLinker(resourceSet);
			return linker;
		}
	}
	
	/**
	 * Create a new {@link EObjectLinker} and attach it the this resourceSet.
	 * @param resourceSet {@link ResourceSet} to manage
	 */
	private EObjectLinker(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		resourceSet.eAdapters().add(this);
		this.registeredTypes = new HashMap<String, LinkType>();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		return EObjectLinker.class.equals(type);
	}
	
	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * @param type to register.
	 */
	public void registerType(LinkType type) {
		if (registeredTypes.get(type.getId()) == null) {
			registeredTypes.put(type.getId(), type);
		}
	}
	
	/**
	 * @return all the {@link EObjectLink} linked to this Object.
	 */
	public List<EObjectLink> getLinks(EObject object) {
		List<EObjectLink> result = new ArrayList<EObjectLink>();
		for (LinkType type : registeredTypes.values()) {
			result.addAll(type.loadLinks(object));
		}
		return result;
	}
	
	
	/**
	 * @param source
	 * @param type
	 * @return
	 */
	public EObjectLink create(EObject source, String type) {
		if (registeredTypes.get(type) != null) {
			return registeredTypes.get(type).createLink(source);
		} else {
			throw new RuntimeException("No corresponding type registered"); //$NON-NLS-1$
		}
	}

	public void delete(EObjectLink link) {
		if (registeredTypes.get(link.getType()) != null) {
			registeredTypes.get(link.getType()).delete(link);
		} else {
			throw new RuntimeException("No corresponding type registered"); //$NON-NLS-1$
		}

	}
	
}
