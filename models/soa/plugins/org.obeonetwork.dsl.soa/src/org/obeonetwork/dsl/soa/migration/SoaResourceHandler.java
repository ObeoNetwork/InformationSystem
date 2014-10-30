package org.obeonetwork.dsl.soa.migration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.soa.System;

public class SoaResourceHandler extends BasicResourceHandler {
	
	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		super.postLoad(resource, inputStream, options);
		processUnknownData(resource);
		
		// Remove old DTO Registry level
		for (EObject rootObject : resource.getContents()) {
			if (rootObject instanceof System) {
				System system = (System)rootObject;
				if (system.getNamespaces().size() == 1) {
					Namespace oldDtoRegistry = system.getNamespaces().get(0);
					removeDtoRegistry(oldDtoRegistry);
				}
			}
		}
	}
	
	private void removeDtoRegistry(Namespace dtoRegistry) {
		System system = (System)dtoRegistry.eContainer();
		
		if (!dtoRegistry.getOwnedNamespaces().isEmpty()) {
			// Store XMI IDs
			Map<EObject, String> eObjectToIds = new HashMap<EObject, String>();
			TreeIterator<EObject> eAllContents = dtoRegistry.eAllContents();
			while (eAllContents.hasNext()) {
				EObject child = eAllContents.next();
				String xmiId = child.eResource().getURIFragment(child);
				eObjectToIds.put(child, xmiId);
			}
			
			// Change parent of children
			Collection<Namespace> children = new ArrayList<Namespace>(dtoRegistry.getOwnedNamespaces());
			for (Namespace child : children) {
				system.getNamespaces().add(child);
			}
			
			// Restore XMI IDs
			for (Entry<EObject, String> eObjectToIdEntry : eObjectToIds.entrySet()) {
				EObject object = eObjectToIdEntry.getKey();
				String id = eObjectToIdEntry.getValue();
				((XMLResource)object.eResource()).setID(object, id);
			}
		}
		// Delete old DTO registry
		EcoreUtil.delete(dtoRegistry, false);
	}

	/**
	 * handle unknown data in Resource.
	 * 
	 * @param resource
	 *            the resource to check
	 */
	protected void processUnknownData(final XMLResource resource) {
		final Map<EObject, AnyType> extMap = resource.getEObjectToExtensionMap();
		for (final EObject key : extMap.keySet()) {
			final AnyType value = extMap.get(key);
			handleUnknownData(key, value);
		}
	}

	private void handleUnknownData(final EObject eObj, final AnyType unknownData) {
		handleUnknownFeatures(eObj, unknownData.getMixed());
		handleUnknownFeatures(eObj, unknownData.getAnyAttribute());
	}

	private void handleUnknownFeatures(final EObject owner, final FeatureMap featureMap) {
		final Iterator<FeatureMap.Entry> iter = featureMap.iterator();
		while (iter.hasNext()) {
			final FeatureMap.Entry entry = iter.next();
			if (isADeletedFeature(owner, entry.getEStructuralFeature())) {
				iter.remove();
			}
		}
	}

	private boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		// TODO return true if the feature should be deleted
		
//		if ("useless".equals(eStructuralFeature.getName()))
//			return true;
		return false;
	}
}
