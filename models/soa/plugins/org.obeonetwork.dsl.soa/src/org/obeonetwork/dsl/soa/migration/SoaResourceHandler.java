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
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.soa.Parameter;
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
		handleUnknownFeaturesMixedValue(eObj, unknownData.getMixed());
		handleUnknownFeaturesAnyAttribute(eObj, unknownData.getAnyAttribute());
	}
	
	private void handleUnknownFeaturesMixedValue(final EObject owner, final FeatureMap featureMap) {
		final Iterator<FeatureMap.Entry> iter = featureMap.iterator();
		while (iter.hasNext()) {
			final FeatureMap.Entry entry = iter.next();
			if (isADeletedFeature(owner, entry.getEStructuralFeature())) {
				iter.remove();
			}
		}
	}

	private void handleUnknownFeaturesAnyAttribute(final EObject owner, final FeatureMap featureMap) {
		Iterator<FeatureMap.Entry> iter;
		if (owner instanceof Parameter) {
			Parameter parameter = (Parameter)owner;
			// Convert "lower + upper" to "multiplicity"
			// Previous default values were lower = 1 and upper = 1
			iter = featureMap.iterator();
			int lower = 1;
			int upper = 1;
			while (iter.hasNext()) {
				final FeatureMap.Entry entry = iter.next();
				if ("lower".equals(entry.getEStructuralFeature().getName())) {
					lower = Integer.parseInt((String)entry.getValue());
				}
				if ("upper".equals(entry.getEStructuralFeature().getName())) {
					upper = Integer.parseInt((String)entry.getValue());
				}
			}
			
			// Convert now
			if (lower == 0) {
				// lower == 0
				if (upper < 0 || upper > 1) {
					parameter.setMultiplicity(MultiplicityKind.ZERO_STAR_LITERAL);
				} else {
					parameter.setMultiplicity(MultiplicityKind.ZERO_ONE_LITERAL);
				}
			} else {
				// lower == 1
				if (upper < 0 || upper > 1) {
					parameter.setMultiplicity(MultiplicityKind.ONE_STAR_LITERAL);
				} else {
					parameter.setMultiplicity(MultiplicityKind.ONE_LITERAL);
				}
			}
		}
		
		iter = featureMap.iterator();
		while (iter.hasNext()) {
			final FeatureMap.Entry entry = iter.next();
			if (isADeletedFeature(owner, entry.getEStructuralFeature())) {
				iter.remove();
			}
		}
	}

	private boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		if (owner instanceof Parameter) {
			if ("lower".equals(eStructuralFeature.getName())) {
				return true;
			}
			if ("upper".equals(eStructuralFeature.getName())) {
				return true;
			}
		}
		return false;
	}
}
